package io.littlehorse.common.model.wfrun.subnoderun;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import io.littlehorse.common.LHConstants;
import io.littlehorse.common.exceptions.LHVarSubError;
import io.littlehorse.common.model.event.TaskResultEvent;
import io.littlehorse.common.model.event.TaskScheduleRequest;
import io.littlehorse.common.model.event.TaskStartedEvent;
import io.littlehorse.common.model.event.WfRunEvent;
import io.littlehorse.common.model.meta.Node;
import io.littlehorse.common.model.server.Tag;
import io.littlehorse.common.model.wfrun.LHTimer;
import io.littlehorse.common.model.wfrun.NodeRun;
import io.littlehorse.common.model.wfrun.SubNodeRun;
import io.littlehorse.common.model.wfrun.ThreadRun;
import io.littlehorse.common.model.wfrun.VariableValue;
import io.littlehorse.common.proto.LHStatusPb;
import io.littlehorse.common.proto.TaskResultCodePb;
import io.littlehorse.common.proto.TaskRunPb;
import io.littlehorse.common.proto.TaskRunPbOrBuilder;
import io.littlehorse.common.proto.WfRunEventPb.EventCase;
import io.littlehorse.common.util.LHUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;

public class TaskRun extends SubNodeRun<TaskRunPb> {

    public int attemptNumber;
    public VariableValue output;
    public byte[] logOutput;

    public Date startTime;
    public String taskDefName;

    public Class<TaskRunPb> getProtoBaseClass() {
        return TaskRunPb.class;
    }

    public void initFrom(MessageOrBuilder proto) {
        TaskRunPbOrBuilder p = (TaskRunPbOrBuilder) proto;
        attemptNumber = p.getAttemptNumber();
        if (p.hasOutput()) {
            output = VariableValue.fromProto(p.getOutputOrBuilder());
        }
        if (p.hasLogOutput()) {
            logOutput = p.getLogOutput().toByteArray();
        }

        if (p.hasStartTime()) {
            startTime = LHUtil.fromProtoTs(p.getStartTime());
        }
        taskDefName = p.getTaskDefId();
    }

    public TaskRunPb.Builder toProto() {
        TaskRunPb.Builder out = TaskRunPb
            .newBuilder()
            .setTaskDefId(taskDefName)
            .setAttemptNumber(attemptNumber);

        if (output != null) {
            out.setOutput(output.toProto());
        }
        if (logOutput != null) {
            out.setLogOutput(ByteString.copyFrom(logOutput));
        }
        if (startTime != null) {
            out.setStartTime(LHUtil.fromDate(startTime));
        }

        return out;
    }

    public static TaskRun fromProto(TaskRunPbOrBuilder proto) {
        TaskRun out = new TaskRun();
        out.initFrom(proto);
        return out;
    }

    public List<Tag> getTags(NodeRun parent) {
        List<Tag> out = new ArrayList<>();
        out.add(
            new Tag(
                parent,
                Pair.of("type", "TASK"),
                Pair.of("taskDefName", taskDefName)
            )
        );

        return out;
    }

    public boolean shouldRetry() {
        if (
            nodeRun.resultCode != TaskResultCodePb.FAILED &&
            nodeRun.resultCode != TaskResultCodePb.TIMEOUT
        ) {
            // Can only retry timeout or task failure.
            return false;
        }

        return nodeRun.attemptNumber < nodeRun.getNode().taskNode.retries;
    }

    public void processEvent(WfRunEvent event) {
        if (event.type == EventCase.STARTED_EVENT) {
            processStartedEvent(event);
        } else if (event.type == EventCase.TASK_RESULT) {
            handleTaskResult(event);
        } else {
            LHUtil.log("Nothing to do for TaskRun with event of type", event.type);
        }
    }

    public void advanceIfPossible(Date time) {}

    public void arrive(Date time) {
        Node node = nodeRun.getNode();

        TaskScheduleRequest tsr = new TaskScheduleRequest();

        Map<String, VariableValue> varVals;
        try {
            varVals = nodeRun.threadRun.assignVarsForNode(node.taskNode);
        } catch (LHVarSubError exn) {
            // make a call to `ThreadRun::fail()`
            nodeRun.fail(
                TaskResultCodePb.VAR_MUTATION_ERROR,
                "Failed mutating variables upon completion: " + exn.getMessage(),
                time
            );
            return;
        }

        tsr.wfRunEventQueue = LHConstants.WF_RUN_EVENT_TOPIC;
        tsr.taskDefId = node.taskNode.taskDefName;
        tsr.taskDefName = node.taskNode.taskDefName;
        tsr.taskRunNumber = nodeRun.number;
        tsr.taskRunPosition = nodeRun.position;
        tsr.threadRunNumber = nodeRun.threadRunNumber;
        tsr.wfRunId = nodeRun.threadRun.wfRunId;
        tsr.wfSpecId = nodeRun.threadRun.wfSpecId;
        tsr.nodeName = node.name;
        tsr.variables = varVals;

        nodeRun.threadRun.wfRun.stores.scheduleTask(tsr);
    }

    private void processStartedEvent(WfRunEvent we) {
        TaskStartedEvent se = we.startedEvent;
        ThreadRun thread = nodeRun.threadRun;

        if (nodeRun.position != se.taskRunPosition) {
            // Out-of-order event due to race conditions between task worker
            // transactional producer and regular producer
            return;
        }
        nodeRun.status = LHStatusPb.RUNNING;

        // set timer for TimeOut
        WfRunEvent timerEvt = new WfRunEvent();
        timerEvt.wfRunId = thread.wfRun.id;
        timerEvt.wfSpecId = thread.wfSpecId;
        Node node = nodeRun.getNode();

        timerEvt.type = EventCase.TASK_RESULT;
        timerEvt.taskResult = new TaskResultEvent();
        timerEvt.taskResult.resultCode = TaskResultCodePb.TIMEOUT;
        timerEvt.taskResult.taskRunNumber = nodeRun.number;
        timerEvt.taskResult.taskRunPosition = nodeRun.position;
        timerEvt.taskResult.threadRunNumber = nodeRun.threadRunNumber;

        try {
            timerEvt.time =
                new Date(
                    new Date().getTime() +
                    (
                        1000 *
                        thread.assignVariable(node.taskNode.timeoutSeconds).intVal
                    )
                );
        } catch (LHVarSubError exn) {
            // This should be impossible.
            throw new RuntimeException(exn);
        }
        timerEvt.taskResult.time = timerEvt.time;

        thread.wfRun.stores.scheduleTimer(new LHTimer(timerEvt, timerEvt.time));

        startTime = we.time;
        nodeRun.status = LHStatusPb.RUNNING;
    }

    public void handleTaskResult(WfRunEvent we) {
        TaskResultEvent ce = we.taskResult;
        if (nodeRun.status == LHStatusPb.COMPLETED) {
            LHUtil.log("Ignoring old event for completed task.");
            return;
        }

        if (nodeRun.status == LHStatusPb.ERROR) {
            LHUtil.log("Ignoring old event for errored task");
            return;
        }

        if (ce.taskRunPosition != nodeRun.position) {
            throw new RuntimeException("Not possible");
        }
        this.output = ce.stdout;
        this.logOutput = ce.stderr;

        switch (ce.resultCode) {
            case SUCCESS:
                nodeRun.complete(output, we.time);

                break;
            case TIMEOUT:
            case FAILED:
                if (shouldRetry()) {
                    nodeRun.doRetry(ce.resultCode, ce.resultCode.toString(), ce.time);
                } else {
                    nodeRun.fail(
                        ce.resultCode,
                        "Node failed: " + ce.resultCode,
                        ce.time
                    );
                }
                break;
            case VAR_MUTATION_ERROR:
            case VAR_SUB_ERROR:
                // This shouldn't be possible.
                throw new RuntimeException("Impossible TaskResultCodePb");
            case UNRECOGNIZED:
                throw new RuntimeException(
                    "Unrecognized TaskResultCode: " + ce.resultCode
                );
        }
    }
}