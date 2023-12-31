package io.littlehorse.sdk.wfsdk.internal.taskdefutil;

import io.littlehorse.sdk.common.exception.TaskSchemaMismatchError;
import io.littlehorse.sdk.common.proto.PutTaskDefPb;
import io.littlehorse.sdk.common.proto.VariableDefPb;
import io.littlehorse.sdk.common.proto.VariableTypePb;
import java.util.List;

public class TaskDefBuilder {

    public Object executable;
    public String taskDefName;
    public LHTaskSignature signature;

    public TaskDefBuilder(Object executable, String taskDefName)
        throws TaskSchemaMismatchError {
        signature = new LHTaskSignature(taskDefName, executable);
        this.executable = executable;
        this.taskDefName = taskDefName;
    }

    public PutTaskDefPb toPutTaskDefPb() {
        PutTaskDefPb.Builder out = PutTaskDefPb.newBuilder();
        List<String> varNames = signature.getVarNames();
        List<VariableTypePb> varTypes = signature.getParamTypes();

        for (int i = 0; i < varNames.size(); i++) {
            out.addInputVars(
                VariableDefPb
                    .newBuilder()
                    .setName(varNames.get(i))
                    .setType(varTypes.get(i))
            );
        }
        out.setName(taskDefName);

        return out.build();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;

        if (!(o instanceof TaskDefBuilder)) return false;
        TaskDefBuilder other = (TaskDefBuilder) o;

        return (
            signature.equals(other.signature) && taskDefName.equals(other.taskDefName)
        );
    }

    @Override
    public int hashCode() {
        return taskDefName.hashCode();
    }
}
