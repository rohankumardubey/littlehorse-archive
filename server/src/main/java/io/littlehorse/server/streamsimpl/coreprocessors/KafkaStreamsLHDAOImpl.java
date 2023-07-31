package io.littlehorse.server.streamsimpl.coreprocessors;

import com.google.protobuf.Message;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.LHConstants;
import io.littlehorse.common.LHDAO;
import io.littlehorse.common.exceptions.LHBadRequestError;
import io.littlehorse.common.exceptions.LHConnectionError;
import io.littlehorse.common.model.Getable;
import io.littlehorse.common.model.ObjectId;
import io.littlehorse.common.model.Storeable;
import io.littlehorse.common.model.command.Command;
import io.littlehorse.common.model.command.subcommandresponse.DeleteObjectReply;
import io.littlehorse.common.model.meta.ExternalEventDef;
import io.littlehorse.common.model.meta.Host;
import io.littlehorse.common.model.meta.TaskDef;
import io.littlehorse.common.model.meta.TaskWorkerGroup;
import io.littlehorse.common.model.meta.WfSpec;
import io.littlehorse.common.model.meta.usertasks.UserTaskDef;
import io.littlehorse.common.model.objectId.ExternalEventDefId;
import io.littlehorse.common.model.objectId.ExternalEventId;
import io.littlehorse.common.model.objectId.NodeRunId;
import io.littlehorse.common.model.objectId.TaskDefId;
import io.littlehorse.common.model.objectId.TaskRunId;
import io.littlehorse.common.model.objectId.TaskWorkerGroupId;
import io.littlehorse.common.model.objectId.UserTaskDefId;
import io.littlehorse.common.model.objectId.UserTaskRunId;
import io.littlehorse.common.model.objectId.VariableId;
import io.littlehorse.common.model.objectId.WfRunId;
import io.littlehorse.common.model.objectId.WfSpecId;
import io.littlehorse.common.model.wfrun.ExternalEvent;
import io.littlehorse.common.model.wfrun.LHTimer;
import io.littlehorse.common.model.wfrun.NodeRun;
import io.littlehorse.common.model.wfrun.ScheduledTask;
import io.littlehorse.common.model.wfrun.ThreadRun;
import io.littlehorse.common.model.wfrun.UserTaskRun;
import io.littlehorse.common.model.wfrun.Variable;
import io.littlehorse.common.model.wfrun.WfRun;
import io.littlehorse.common.model.wfrun.taskrun.TaskRun;
import io.littlehorse.common.util.LHGlobalMetaStores;
import io.littlehorse.common.util.LHUtil;
import io.littlehorse.sdk.common.proto.HostInfoPb;
import io.littlehorse.sdk.common.proto.LHResponseCodePb;
import io.littlehorse.sdk.common.proto.LHStatusPb;
import io.littlehorse.sdk.common.proto.MetricsWindowLengthPb;
import io.littlehorse.server.KafkaStreamsServerImpl;
import io.littlehorse.server.streamsimpl.ServerTopology;
import io.littlehorse.server.streamsimpl.coreprocessors.repartitioncommand.RepartitionCommand;
import io.littlehorse.server.streamsimpl.coreprocessors.repartitioncommand.repartitionsubcommand.TaskMetricUpdate;
import io.littlehorse.server.streamsimpl.coreprocessors.repartitioncommand.repartitionsubcommand.WfMetricUpdate;
import io.littlehorse.server.streamsimpl.storeinternals.GetableStorageManager;
import io.littlehorse.server.streamsimpl.storeinternals.ReadOnlyRocksDBWrapper;
import io.littlehorse.server.streamsimpl.storeinternals.RocksDBWrapper;
import io.littlehorse.server.streamsimpl.storeinternals.utils.LHIterKeyValue;
import io.littlehorse.server.streamsimpl.storeinternals.utils.LHKeyValueIterator;
import io.littlehorse.server.streamsimpl.util.InternalHosts;
import io.littlehorse.server.streamsimpl.util.WfSpecCache;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;

@Slf4j
public class KafkaStreamsLHDAOImpl implements LHDAO {

    private Map<String, ScheduledTask> scheduledTaskPuts;
    private List<LHTimer> timersToSchedule;
    private Command command;
    private KafkaStreamsServerImpl server;
    private Map<String, TaskMetricUpdate> taskMetricPuts;
    private Map<String, WfMetricUpdate> wfMetricPuts;
    private Set<Host> currentHosts;

    private GetableStorageManager storageManager;
    private KeyValueStore<String, Bytes> rawLocalStore;

    /*
     * Certain metadata objects (eg. WfSpec, TaskDef, ExternalEventDef) are "global"
     * in nature. This means three things:
     * 1) Changes to them are low-throughput and infrequent
     * 2) There are a relatively small number of them
     * 3) Other resources (eg. WfRun) need to constantly consult them in order to run.
     *
     * Items 1) and 2) imply that these metadata objects can be stored on one node.
     * Item 3) implies that we *need* every node to have a local copy of these
     * objects.
     *
     * Furthermore, WfSpec's and TaskDef's depend on each other, and we want
     * strongly consistent processing (so that we can't accidentally delete a TaskDef
     * while processing a WfSpec that uses it, for example). Therefore, we want
     * all of the processing to be linearized, and therefore it needs to occur on
     * the same partition.
     *
     * So what do we do? We use the same getParttionKey() for all of the global
     * metadata.
     *
     * The boolean below here is true when this processor owns the "hot" partition.
     */
    private boolean isHotMetadataPartition;

    private RocksDBWrapper localStore;
    private ReadOnlyRocksDBWrapper globalStore;
    private ProcessorContext<String, CommandProcessorOutput> ctx;
    private LHConfig config;
    private final WfSpecCache wfSpecCache;
    private boolean partitionIsClaimed;

    public KafkaStreamsLHDAOImpl(
        final ProcessorContext<String, CommandProcessorOutput> ctx,
        LHConfig config,
        KafkaStreamsServerImpl server,
        WfSpecCache wfSpecCache
    ) {
        this.server = server;
        this.ctx = ctx;
        this.config = config;
        this.wfSpecCache = wfSpecCache;

        // At the start, we haven't claimed the partition until the claim event comes
        this.partitionIsClaimed = false;

        taskMetricPuts = new HashMap<>();
        wfMetricPuts = new HashMap<>();

        // TODO: Here is where we want to eventually add some cacheing for GET to
        // the WfSpec and TaskDef etc.

        isHotMetadataPartition =
            ctx.taskId().partition() == config.getHotMetadataPartition();

        rawLocalStore = ctx.getStateStore(ServerTopology.CORE_STORE);
        ReadOnlyKeyValueStore<String, Bytes> rawGlobalStore = ctx.getStateStore(
            ServerTopology.GLOBAL_STORE
        );
        localStore = new RocksDBWrapper(rawLocalStore, config);
        globalStore = new ReadOnlyRocksDBWrapper(rawGlobalStore, config);

        scheduledTaskPuts = new HashMap<>();
        timersToSchedule = new ArrayList<>();
    }

    @Override
    public void putNodeRun(NodeRun nr) {
        storageManager.put(nr);
    }

    @Override
    public NodeRun getNodeRun(String wfRunId, int threadNum, int position) {
        return storageManager.get(new NodeRunId(wfRunId, threadNum, position));
    }

    @Override
    public void putTaskRun(TaskRun tr) {
        storageManager.put(tr);
    }

    @Override
    public TaskRun getTaskRun(TaskRunId taskRunId) {
        return storageManager.get(taskRunId);
    }

    @Override
    public void putUserTaskRun(UserTaskRun utr) {
        storageManager.put(utr);
    }

    @Override
    public UserTaskRun getUserTaskRun(UserTaskRunId userTaskRunId) {
        return storageManager.get(userTaskRunId);
    }

    @Override
    public void resetAndSetCommand(Command command) {
        this.command = command;
        this.storageManager =
            new GetableStorageManager(localStore, ctx, config, command, this);
    }

    @Override
    public Command getCommand() {
        return this.command;
    }

    @Override
    public void putWfSpec(WfSpec spec) {
        if (!isHotMetadataPartition) {
            throw new RuntimeException(
                "Tried to put metadata despite being on the wrong partition!"
            );
        }
        // TODO: note we are putting a Global Metadata
        storageManager.put(spec);
    }

    @Override
    public void putExternalEventDef(ExternalEventDef spec) {
        if (!isHotMetadataPartition) {
            throw new RuntimeException(
                "Tried to put metadata despite being on the wrong partition!"
            );
        }
        // TODO: note we are putting a Global Metadata
        storageManager.put(spec);
    }

    @Override
    public void putTaskDef(TaskDef spec) {
        if (!isHotMetadataPartition) {
            throw new RuntimeException(
                "Tried to put metadata despite being on the wrong partition!"
            );
        }
        // TODO: note we are putting Global Metadata
        storageManager.put(spec);
    }

    @Override
    public WfSpec getWfSpec(String name, Integer version) {
        Supplier<WfSpec> findWfSpec = () -> {
            ReadOnlyRocksDBWrapper store = globalStore;
            if (version != null) {
                return store.get(new WfSpecId(name, version));
            }
            return store.getLastFromPrefix(name, WfSpec.class);
        };
        WfSpec wfSpec = wfSpecCache.getOrCache(name, version, findWfSpec);
        if (wfSpec != null) wfSpec.setDao(this);
        return wfSpec;
    }

    @Override
    public UserTaskDef getUserTaskDef(String name, Integer version) {
        ReadOnlyRocksDBWrapper store = globalStore;
        UserTaskDef out;
        if (version != null) {
            // First check the most recent puts
            out = store.get(new UserTaskDefId(name, version));
        } else {
            out = store.getLastFromPrefix(name, UserTaskDef.class);
        }
        if (out != null) out.setDao(this);
        return out;
    }

    @Override
    public void putUserTaskDef(UserTaskDef spec) {
        if (!isHotMetadataPartition) {
            throw new RuntimeException(
                "Tried to put metadata despite being on the wrong partition!"
            );
        }
        // TODO: global metadata storage change
        storageManager.put(spec);
    }

    @Override
    public TaskDef getTaskDef(String name) {
        ReadOnlyRocksDBWrapper store = globalStore;
        return store.get(new TaskDefId(name));
    }

    @Override
    public ExternalEventDef getExternalEventDef(String name) {
        ExternalEventDef out = globalStore.get(new ExternalEventDefId(name));
        if (out != null) {
            out.setDao(this);
        }
        return out;
    }

    @Override
    public TaskWorkerGroup getTaskWorkerGroup(String taskDefName) {
        return storageManager.get(new TaskWorkerGroupId(taskDefName));
    }

    @Override
    public void putTaskWorkerGroup(TaskWorkerGroup taskWorkerGroup) {
        storageManager.put(taskWorkerGroup);
    }

    @Override
    public LHGlobalMetaStores getGlobalMetaStores() {
        return this;
    }

    @Override
    public void putVariable(Variable var) {
        storageManager.put(var);
    }

    @Override
    public Variable getVariable(String wfRunId, String name, int threadNum) {
        return storageManager.get(new VariableId(wfRunId, threadNum, name));
    }

    // This for later
    @Override
    public ExternalEvent getUnclaimedEvent(
        String wfRunId,
        String externalEventDefName
    ) {
        return storageManager.getFirstByCreatedTimeFromPrefix(
            externalEventDefName,
            ExternalEvent.class,
            extEvt -> !extEvt.isClaimed()
        );
    }

    @Override
    public ExternalEvent getExternalEvent(String externalEventId) {
        ExternalEventId id = (ExternalEventId) ObjectId.fromString(
            externalEventId,
            ExternalEventId.class
        );
        return storageManager.get(id);
    }

    @Override
    public void saveExternalEvent(ExternalEvent evt) {
        storageManager.put(evt);
    }

    @Override
    public void scheduleTask(ScheduledTask scheduledTask) {
        scheduledTaskPuts.put(scheduledTask.getStoreKey(), scheduledTask);
    }

    @Override
    public void scheduleTimer(LHTimer timer) {
        timersToSchedule.add(timer);
    }

    @Override
    public ScheduledTask markTaskAsScheduled(TaskRunId taskRunId) {
        ScheduledTask scheduledTask = localStore.get(
            taskRunId.getStoreKey(),
            ScheduledTask.class
        );

        if (scheduledTask != null) {
            scheduledTaskPuts.put(scheduledTask.getStoreKey(), null);
        }

        return scheduledTask;
    }

    @Override
    public WfRun getWfRun(String wfRunId) {
        return getWfRun(new WfRunId(wfRunId));
    }

    @Override
    public WfRun getWfRun(WfRunId id) {
        return storageManager.get(id);
    }

    @Override
    public void saveWfRun(WfRun wfRun) {
        storageManager.put(wfRun);
    }

    @Override
    public void commitChanges() {
        storageManager.flush();

        timersToSchedule.forEach(this::forwardTimer);
        timersToSchedule.clear();

        for (Map.Entry<String, ScheduledTask> entry : scheduledTaskPuts.entrySet()) {
            forwardTask(entry.getKey(), entry.getValue());
        }
        // TODO: handle taskMetricUpdates and WfMetricUpdates
    }

    // This method should only be called if we have a serious unknown bug in
    // LittleHorse that causes an unexpected exception to occur while executing
    // CommandProcessor#process().
    @Override
    public void abortChangesAndMarkWfRunFailed(Throwable failure, String wfRunId) {
        // if the wfRun exists: we want to mark it as failed with a message.
        // Else, do nothing.
        WfRun wfRun = storageManager.get(new WfRunId(wfRunId));
        if (wfRun != null) {
            log.warn(
                "Marking wfRun {} as failed due to internal LH exception",
                wfRunId
            );
            ThreadRun entrypoint = wfRun.getThreadRun(0);
            entrypoint.setStatus(LHStatusPb.ERROR);

            String message =
                "Had an internal LH failur processing command of type " +
                command.getType() +
                ": " +
                failure.getMessage();
            entrypoint.setErrorMessage(message);

            // Need to manually store wfRun into rocksdb. Ignore everything else
            // in lhStore.

            throw new NotImplementedException("Need to manually store wfRun");
        } else {
            log.warn(
                "Caught internal LH error but found no WfRun with id {}",
                wfRunId
            );
        }
    }

    @Override
    public String getCoreCmdTopic() {
        return config.getCoreCmdTopicName();
    }

    @Override
    public DeleteObjectReply deleteWfRun(WfRunId wfRunId) {
        WfRun wfRun = getWfRun(wfRunId);
        if (wfRun != null && wfRun.isRunning()) {
            return new DeleteObjectReply(
                LHResponseCodePb.NOT_FOUND_ERROR,
                "Couldn't find wfRun with provided ID."
            );
        }
        // Delete all wfRun children.
        storageManager.deleteAllByPrefix(wfRunId.getId(), NodeRun.class);
        storageManager.deleteAllByPrefix(wfRunId.getId(), TaskRun.class);
        storageManager.deleteAllByPrefix(wfRunId.getId(), ExternalEvent.class);
        storageManager.deleteAllByPrefix(wfRunId.getId(), Variable.class);
        storageManager.deleteAllByPrefix(wfRunId.getId(), UserTaskRun.class);

        return deleteObject(wfRunId);
    }

    @Override
    public DeleteObjectReply deleteTaskDef(TaskDefId id) {
        return deleteObject(id);
    }

    private <
        T extends Message, U extends Message, V extends Getable<U>
    > DeleteObjectReply deleteObject(ObjectId<T, U, V> id) {
        V toDelete = storageManager.get(id);

        if (toDelete == null) {
            return new DeleteObjectReply(
                LHResponseCodePb.NOT_FOUND_ERROR,
                "Couldn't find object with provided ID."
            );
        }
        storageManager.delete(id);
        return new DeleteObjectReply(LHResponseCodePb.OK, null);
    }

    @Override
    public DeleteObjectReply deleteUserTaskDef(UserTaskDefId id) {
        return deleteObject(id);
    }

    @Override
    public DeleteObjectReply deleteWfSpec(WfSpecId id) {
        return deleteObject(id);
    }

    @Override
    public DeleteObjectReply deleteExternalEventDef(ExternalEventDefId id) {
        return deleteObject(id);
    }

    @Override
    public DeleteObjectReply deleteExternalEvent(ExternalEventId id) {
        ExternalEvent evt = storageManager.get(id);
        if (evt.isClaimed()) {}
        return deleteObject(id);
    }

    public void onPartitionClaimed() {
        if (partitionIsClaimed) {
            throw new RuntimeException("Re-claiming partition! Yikes!");
        }
        partitionIsClaimed = true;

        try (
            LHKeyValueIterator<ScheduledTask> iter = localStore.prefixScan(
                "",
                ScheduledTask.class
            )
        ) {
            while (iter.hasNext()) {
                LHIterKeyValue<ScheduledTask> next = iter.next();
                ScheduledTask scheduledTask = next.getValue();
                log.debug(
                    "Rehydration: scheduling task: {}",
                    scheduledTask.getStoreKey()
                );
                server.onTaskScheduled(scheduledTask.getTaskDefId(), scheduledTask);
            }
        }
    }

    public List<WfMetricUpdate> getWfMetricWindows(
        String wfSpecName,
        int wfSpecVersion,
        Date time
    ) {
        List<WfMetricUpdate> out = new ArrayList<>();
        out.add(
            getWmUpdate(
                time,
                MetricsWindowLengthPb.MINUTES_5,
                wfSpecName,
                wfSpecVersion
            )
        );
        out.add(
            getWmUpdate(
                time,
                MetricsWindowLengthPb.HOURS_2,
                wfSpecName,
                wfSpecVersion
            )
        );
        out.add(
            getWmUpdate(time, MetricsWindowLengthPb.DAYS_1, wfSpecName, wfSpecVersion)
        );
        return out;
    }

    private WfMetricUpdate getWmUpdate(
        Date windowStart,
        MetricsWindowLengthPb type,
        String wfSpecName,
        int wfSpecVersion
    ) {
        windowStart = LHUtil.getWindowStart(windowStart, type);
        String id = WfMetricUpdate.getObjectId(
            type,
            windowStart,
            wfSpecName,
            wfSpecVersion
        );
        if (wfMetricPuts.containsKey(id)) {
            return wfMetricPuts.get(id);
        }

        WfMetricUpdate out = localStore.get(id, WfMetricUpdate.class);
        if (out == null) {
            out = new WfMetricUpdate();
            out.windowStart = windowStart;
            out.type = type;
            out.wfSpecName = wfSpecName;
            out.wfSpecVersion = wfSpecVersion;
        }

        wfMetricPuts.put(id, out);
        return out;
    }

    public List<TaskMetricUpdate> getTaskMetricWindows(
        String taskDefName,
        Date time
    ) {
        List<TaskMetricUpdate> out = new ArrayList<>();
        out.add(getTmUpdate(time, MetricsWindowLengthPb.MINUTES_5, taskDefName));
        out.add(getTmUpdate(time, MetricsWindowLengthPb.HOURS_2, taskDefName));
        out.add(getTmUpdate(time, MetricsWindowLengthPb.DAYS_1, taskDefName));
        return out;
    }

    private TaskMetricUpdate getTmUpdate(
        Date windowStart,
        MetricsWindowLengthPb type,
        String taskDefName
    ) {
        windowStart = LHUtil.getWindowStart(windowStart, type);
        String id = TaskMetricUpdate.getStoreKey(type, windowStart, taskDefName);
        if (taskMetricPuts.containsKey(id)) {
            return taskMetricPuts.get(id);
        }

        TaskMetricUpdate out = localStore.get(id, TaskMetricUpdate.class);
        if (out == null) {
            out = new TaskMetricUpdate();
            out.windowStart = windowStart;
            out.type = type;
            out.taskDefName = taskDefName;
        }

        taskMetricPuts.put(id, out);
        return out;
    }

    private void forwardTask(String scheduledTaskId, ScheduledTask scheduledTask) {
        // since tsr is not null, it will save
        saveOrDeleteStorableFlush(
            scheduledTask.getStoreKey(),
            scheduledTask,
            ScheduledTask.class
        );

        if (scheduledTaskId == null) return;

        // This is where the magic happens
        if (partitionIsClaimed) {
            server.onTaskScheduled(scheduledTask.getTaskDefId(), scheduledTask);
        } else {
            log.debug("Haven't claimed partitions, deferring scheduling of tsr");
        }
    }

    private void forwardTimer(LHTimer timer) {
        CommandProcessorOutput output = new CommandProcessorOutput(
            config.getTimerTopic(),
            timer,
            timer.key
        );
        ctx.forward(
            new Record<String, CommandProcessorOutput>(
                timer.key,
                output,
                System.currentTimeMillis()
            )
        );
    }

    private <
        U extends Message, T extends Storeable<U>
    > void saveOrDeleteStorableFlush(String key, T val, Class<T> cls) {
        if (val != null) {
            localStore.put(val);
        } else {
            T oldThing = localStore.get(key, cls);
            if (oldThing != null) {
                localStore.delete(oldThing);
            } else {
                log.debug("Tried to delete nonexistent {} {}", cls.getName(), key);
            }
        }
    }

    public void forwardAndClearMetricsUpdatesUntil() {
        Map<String, TaskMetricUpdate> clusterTaskUpdates = new HashMap<>();

        try (
            LHKeyValueIterator<TaskMetricUpdate> iter = localStore.range(
                "",
                "~",
                TaskMetricUpdate.class
            );
        ) {
            while (iter.hasNext()) {
                LHIterKeyValue<TaskMetricUpdate> next = iter.next();

                log.debug("Sending out metrics for {}", next.getKey());

                localStore.delete(next.getKey());
                TaskMetricUpdate tmu = next.getValue();
                forwardTaskMetricUpdate(tmu);

                // Update the cluster-level metrics
                String clusterTaskUpdateKey = TaskMetricUpdate.getStoreKey(
                    tmu.type,
                    tmu.windowStart,
                    LHConstants.CLUSTER_LEVEL_METRIC
                );
                TaskMetricUpdate clusterTaskUpdate;
                if (clusterTaskUpdates.containsKey(clusterTaskUpdateKey)) {
                    clusterTaskUpdate = clusterTaskUpdates.get(clusterTaskUpdateKey);
                } else {
                    clusterTaskUpdate =
                        new TaskMetricUpdate(
                            tmu.windowStart,
                            tmu.type,
                            LHConstants.CLUSTER_LEVEL_METRIC
                        );
                }

                clusterTaskUpdate.merge(tmu);
                clusterTaskUpdates.put(clusterTaskUpdateKey, clusterTaskUpdate);
                localStore.delete(tmu);
            }
        }

        // Forward the cluster level task updates
        for (TaskMetricUpdate tmu : clusterTaskUpdates.values()) {
            forwardTaskMetricUpdate(tmu);
        }

        // get ready to update the cluster level WF Metrics
        Map<String, WfMetricUpdate> clusterWfUpdates = new HashMap<>();

        try (
            LHKeyValueIterator<WfMetricUpdate> iter = localStore.range(
                "",
                "~",
                WfMetricUpdate.class
            );
        ) {
            while (iter.hasNext()) {
                LHIterKeyValue<WfMetricUpdate> next = iter.next();
                WfMetricUpdate wmu = next.getValue();
                forwardWfMetricUpdate(wmu);

                // Update the cluster-level metrics
                String clusterWfUpdateKey = WfMetricUpdate.getStoreKey(
                    wmu.type,
                    wmu.windowStart,
                    LHConstants.CLUSTER_LEVEL_METRIC,
                    0
                );
                WfMetricUpdate clusterWfUpdate;
                if (clusterWfUpdates.containsKey(clusterWfUpdateKey)) {
                    clusterWfUpdate = clusterWfUpdates.get(clusterWfUpdateKey);
                } else {
                    clusterWfUpdate =
                        new WfMetricUpdate(
                            wmu.windowStart,
                            wmu.type,
                            LHConstants.CLUSTER_LEVEL_METRIC,
                            0
                        );
                }
                clusterWfUpdate.merge(wmu);
                clusterWfUpdates.put(clusterWfUpdateKey, clusterWfUpdate);

                localStore.delete(wmu);
            }
        }

        // Forward the cluster level task updates
        for (WfMetricUpdate wmu : clusterWfUpdates.values()) {
            forwardWfMetricUpdate(wmu);
        }
    }

    private void forwardTaskMetricUpdate(TaskMetricUpdate tmu) {
        CommandProcessorOutput cpo = new CommandProcessorOutput();
        cpo.partitionKey = tmu.getPartitionKey();
        cpo.topic = config.getRepartitionTopicName();
        cpo.payload = new RepartitionCommand(tmu, new Date(), tmu.getPartitionKey());
        Record<String, CommandProcessorOutput> out = new Record<>(
            tmu.getPartitionKey(),
            cpo,
            System.currentTimeMillis()
        );
        ctx.forward(out);
    }

    private void forwardWfMetricUpdate(WfMetricUpdate wmu) {
        CommandProcessorOutput cpo = new CommandProcessorOutput();
        cpo.partitionKey = wmu.getPartitionKey();
        cpo.topic = config.getRepartitionTopicName();
        cpo.payload = new RepartitionCommand(wmu, new Date(), wmu.getPartitionKey());
        Record<String, CommandProcessorOutput> out = new Record<>(
            wmu.getPartitionKey(),
            cpo,
            System.currentTimeMillis()
        );
        ctx.forward(out);
    }

    @Override
    public HostInfoPb getAdvertisedHost(Host host, String listenerName)
        throws LHBadRequestError, LHConnectionError {
        return server.getAdvertisedHost(host, listenerName);
    }

    @Override
    public InternalHosts getInternalHosts() {
        Set<Host> newHost = server.getAllInternalHosts();
        InternalHosts internalHosts = new InternalHosts(currentHosts, newHost);
        currentHosts = newHost;
        return internalHosts;
    }
}
