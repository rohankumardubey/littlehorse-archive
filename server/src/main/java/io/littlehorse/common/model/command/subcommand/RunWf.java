package io.littlehorse.common.model.command.subcommand;

import com.google.protobuf.Message;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.LHDAO;
import io.littlehorse.common.model.command.SubCommand;
import io.littlehorse.common.model.command.subcommandresponse.RunWfReply;
import io.littlehorse.common.model.meta.WfSpec;
import io.littlehorse.common.model.wfrun.VariableValue;
import io.littlehorse.common.model.wfrun.WfRun;
import io.littlehorse.common.util.LHUtil;
import io.littlehorse.sdk.common.proto.LHResponseCodePb;
import io.littlehorse.sdk.common.proto.LHStatusPb;
import io.littlehorse.sdk.common.proto.RunWfPb;
import io.littlehorse.sdk.common.proto.VariableValuePb;
import java.util.HashMap;
import java.util.Map;

public class RunWf extends SubCommand<RunWfPb> {

    public String wfSpecName;
    public Integer wfSpecVersion;
    public Map<String, VariableValue> variables;
    public String id;

    public String getPartitionKey() {
        if (id == null) {
            id = LHUtil.generateGuid();
        }
        return id;
    }

    public Class<RunWfPb> getProtoBaseClass() {
        return RunWfPb.class;
    }

    public RunWf() {
        variables = new HashMap<>();
    }

    public RunWfPb.Builder toProto() {
        RunWfPb.Builder out = RunWfPb.newBuilder().setWfSpecName(wfSpecName);
        if (id != null) out.setId(id);
        if (wfSpecVersion != null) out.setWfSpecVersion(wfSpecVersion);

        for (Map.Entry<String, VariableValue> e : variables.entrySet()) {
            out.putVariables(e.getKey(), e.getValue().toProto().build());
        }
        return out;
    }

    public void initFrom(Message proto) {
        RunWfPb p = (RunWfPb) proto;
        wfSpecName = p.getWfSpecName();
        if (p.hasId()) id = p.getId();
        if (p.hasWfSpecVersion()) wfSpecVersion = p.getWfSpecVersion();

        for (Map.Entry<String, VariableValuePb> e : p.getVariablesMap().entrySet()) {
            variables.put(e.getKey(), VariableValue.fromProto(e.getValue()));
        }
    }

    public boolean hasResponse() {
        return true;
    }

    public RunWfReply process(LHDAO dao, LHConfig config) {
        RunWfReply out = new RunWfReply();

        WfSpec spec = dao.getWfSpec(wfSpecName, wfSpecVersion);
        if (spec == null) {
            out.code = LHResponseCodePb.NOT_FOUND_ERROR;
            out.message = "Could not find specified WfSpec.";
            return out;
        }
        out.wfSpecVersion = spec.version;

        if (id == null) id = LHUtil.generateGuid();
        out.wfRunId = id;

        WfRun oldWfRun = dao.getWfRun(id);
        if (oldWfRun != null) {
            out.code = LHResponseCodePb.ALREADY_EXISTS_ERROR;
            out.message = "WfRun with id " + id + " already exists!";
            return out;
        }

        // TODO: Add WfRun Start Metrics

        WfRun newRun = spec.startNewRun(this);
        newRun.advance(dao.getEventTime());

        if (newRun.status == LHStatusPb.ERROR) {
            out.code = LHResponseCodePb.BAD_REQUEST_ERROR;
            out.message = newRun.threadRuns.get(0).errorMessage;
        } else {
            out.code = LHResponseCodePb.OK;
        }
        return out;
    }

    public static RunWf fromProto(RunWfPb p) {
        RunWf out = new RunWf();
        out.initFrom(p);
        return out;
    }
}
