package io.littlehorse.examples;

import io.littlehorse.sdk.client.LHClient;
import io.littlehorse.sdk.common.config.LHWorkerConfig;
import io.littlehorse.sdk.common.exception.LHApiError;
import io.littlehorse.sdk.common.proto.VariableMutationTypePb;
import io.littlehorse.sdk.common.proto.VariableTypePb;
import io.littlehorse.sdk.wfsdk.SpawnedThread;
import io.littlehorse.sdk.wfsdk.WfRunVariable;
import io.littlehorse.sdk.wfsdk.Workflow;
import io.littlehorse.sdk.wfsdk.internal.WorkflowImpl;
import io.littlehorse.sdk.worker.LHTaskWorker;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * In this example you will see how to instantiate a child thread
 * and then wait until it has finished its execution before
 * executing another task
 */
public class ChildThreadExample {

    private static final Logger log = LoggerFactory.getLogger(
        ChildThreadExample.class
    );

    public static Workflow getWorkflow() {
        return new WorkflowImpl(
            "example-child-thread",
            thread -> {
                WfRunVariable parentVar = thread.addVariable(
                    "parent-var",
                    VariableTypePb.INT
                );

                thread.mutate(
                    parentVar,
                    VariableMutationTypePb.ASSIGN,
                    thread.execute("parent-task-1", parentVar)
                );

                SpawnedThread childThread = thread.spawnThread(
                    child -> { // this is the child workflow thread
                        WfRunVariable childVar = child.addVariable(
                            "child-var",
                            VariableTypePb.INT
                        );
                        child.execute("child-task", childVar);
                    },
                    "spawned-thread",
                    Map.of("child-var", parentVar)
                );

                thread.waitForThreads(childThread);

                thread.execute("parent-task-2");
            }
        );
    }

    public static Properties getConfigProps() throws IOException {
        Properties props = new Properties();
        Path configPath = Path.of(
            System.getProperty("user.home"),
            ".config/littlehorse.config"
        );
        props.load(new FileInputStream(configPath.toFile()));
        return props;
    }

    public static List<LHTaskWorker> getTaskWorkers(LHWorkerConfig config) {
        ChildThreadWorker executable = new ChildThreadWorker();
        List<LHTaskWorker> workers = List.of(
            new LHTaskWorker(executable, "parent-task-1", config),
            new LHTaskWorker(executable, "child-task", config),
            new LHTaskWorker(executable, "parent-task-2", config)
        );

        // Gracefully shutdown
        Runtime
            .getRuntime()
            .addShutdownHook(
                new Thread(() ->
                    workers.forEach(worker -> {
                        log.debug("Closing {}", worker.getTaskDefName());
                        worker.close();
                    })
                )
            );
        return workers;
    }

    public static void main(String[] args) throws IOException, LHApiError {
        // Let's prepare the configurations
        Properties props = getConfigProps();
        LHWorkerConfig config = new LHWorkerConfig(props);
        LHClient client = new LHClient(config);

        // New workflow
        Workflow workflow = getWorkflow();

        // New worker
        List<LHTaskWorker> workers = getTaskWorkers(config);

        // Register tasks if they don't exist
        for (LHTaskWorker worker : workers) {
            if (worker.doesTaskDefExist()) {
                log.debug(
                    "Task {} already exists, skipping creation",
                    worker.getTaskDefName()
                );
            } else {
                log.debug(
                    "Task {} does not exist, registering it",
                    worker.getTaskDefName()
                );
                worker.registerTaskDef();
            }
        }

        // Register a workflow if it does not exist
        if (workflow.doesWfSpecExist(client)) {
            log.debug(
                "Workflow {} already exists, skipping creation",
                workflow.getName()
            );
        } else {
            log.debug(
                "Workflow {} does not exist, registering it",
                workflow.getName()
            );
            workflow.registerWfSpec(client);
        }

        // Run the workers
        for (LHTaskWorker worker : workers) {
            log.debug("Starting {}", worker.getTaskDefName());
            worker.start();
        }
    }
}
