package io.littlehorse.examples;

import io.littlehorse.sdk.client.LHClient;
import io.littlehorse.sdk.common.config.LHWorkerConfig;
import io.littlehorse.sdk.common.exception.LHApiError;
import io.littlehorse.sdk.common.proto.VariableTypePb;
import io.littlehorse.sdk.common.proto.WfSpecPb;
import io.littlehorse.sdk.wfsdk.WfRunVariable;
import io.littlehorse.sdk.wfsdk.Workflow;
import io.littlehorse.sdk.wfsdk.internal.WorkflowImpl;
import io.littlehorse.sdk.worker.LHTaskWorker;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * In this example you will learn how to define several WfSpec versions, and
 * how to run them.
 */
public class WorkflowVersionsExample {

    private static final Logger log = LoggerFactory.getLogger(
        WorkflowVersionsExample.class
    );

    public static Workflow getWorkflow0() {
        return new WorkflowImpl(
            "example-wf-versions",
            thread -> {
                WfRunVariable theName = thread.addVariable(
                    "input-name",
                    VariableTypePb.STR
                );
                thread.execute("greet0", theName);
            }
        );
    }

    public static Workflow getWorkflow1() {
        return new WorkflowImpl(
            "example-wf-versions", // same name
            thread -> {
                WfRunVariable theName = thread.addVariable(
                    "input-name",
                    VariableTypePb.STR
                );
                thread.execute("greet1", theName);
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
        MyWorker executable = new MyWorker();
        List<LHTaskWorker> workers = List.of(
            new LHTaskWorker(executable, "greet0", config),
            new LHTaskWorker(executable, "greet1", config)
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

        // New workflow0
        Workflow workflow0 = getWorkflow0();

        // New workflow1
        Workflow workflow1 = getWorkflow1();

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

        // Register a workflow version 0 if it does not exist
        if (workflow0.doesWfSpecExist(client, 0)) {
            log.debug(
                "Workflow {} already exists with version 0, skipping creation",
                workflow0.getName()
            );
        } else {
            log.debug(
                "Workflow {} does not exist with version 0, registering it",
                workflow0.getName()
            );
            workflow0.registerWfSpec(client);
        }

        // Register a workflow version 1 if it does not exist
        if (workflow1.doesWfSpecExist(client, 1)) {
            log.debug(
                "Workflow {} already exists with version 1, skipping creation",
                workflow1.getName()
            );
        } else {
            log.debug(
                "Workflow {} does not exist with version 1, registering it",
                workflow1.getName()
            );
            workflow1.registerWfSpec(client);
        }

        // Getting the latest version
        WfSpecPb wfSpec = client.getWfSpec("example-wf-versions");
        log.info(
            "The latest version of example-wf-versions is {}",
            wfSpec.getVersion()
        );

        // Run the workers
        for (LHTaskWorker worker : workers) {
            log.debug("Starting {}", worker.getTaskDefName());
            worker.start();
        }
    }
}
