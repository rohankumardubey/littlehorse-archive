package io.littlehorse.tests.cases.workflow;

import io.littlehorse.sdk.client.LHClient;
import io.littlehorse.sdk.common.config.LHWorkerConfig;
import io.littlehorse.sdk.common.exception.LHApiError;
import io.littlehorse.sdk.common.proto.ComparatorPb;
import io.littlehorse.sdk.common.proto.VariableTypePb;
import io.littlehorse.sdk.wfsdk.WfRunVariable;
import io.littlehorse.sdk.wfsdk.Workflow;
import io.littlehorse.sdk.wfsdk.internal.WorkflowImpl;
import io.littlehorse.sdk.worker.LHTaskMethod;
import io.littlehorse.tests.TestFailure;
import io.littlehorse.tests.WorkflowLogicTest;
import java.util.Arrays;
import java.util.List;

public class APConditionalLogicComplex extends WorkflowLogicTest {

    public APConditionalLogicComplex(LHClient client, LHWorkerConfig workerConfig) {
        super(client, workerConfig);
    }

    public String getDescription() {
        return "Tests that nested conditionals work as expected.";
    }

    public Workflow getWorkflowImpl() {
        return new WorkflowImpl(
            getWorkflowName(),
            thread -> {
                // Use an input JSON blob with two fields, LHS and RHS.
                // This allows us to test with various types on the left and the
                // right, since right now the JSON_OBJ var type does not have a
                // schema.
                WfRunVariable input = thread.addVariable("input", VariableTypePb.INT);

                /*
                if (input < 15) {
                    if (input < 10) {
                        execute(1);
                    }
                    execute(2);
                }
                execute(3);
                 */
                thread.doIf(
                    thread.condition(input, ComparatorPb.LESS_THAN, 15),
                    ifBlock -> {
                        thread.doIf(
                            thread.condition(input, ComparatorPb.LESS_THAN, 10),
                            ifBlock2 -> {
                                ifBlock2.execute("ap-task", 1);
                            }
                        );
                        ifBlock.execute("ap-task", 2);
                    }
                );

                thread.execute("ap-task", 3);
            }
        );
    }

    public List<Object> getTaskWorkerObjects() {
        return Arrays.asList(new APSimpleTask());
    }

    // private String twoInts() throws TestFailure

    public List<String> launchAndCheckWorkflows(LHClient client)
        throws TestFailure, InterruptedException, LHApiError {
        return Arrays.asList(
            runWithInputsAndCheckPath(client, 1, 1, 2, 3),
            runWithInputsAndCheckPath(client, 11, 2, 3),
            runWithInputsAndCheckPath(client, 16, 3)
        );
    }
}

class APSimpleTask {

    @LHTaskMethod("ap-task")
    public int theTask(int input) {
        return input;
    }
}
