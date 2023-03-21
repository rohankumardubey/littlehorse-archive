package io.littlehorse.common.model.command.subcommand;

import com.google.protobuf.MessageOrBuilder;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.LHDAO;
import io.littlehorse.common.model.command.AbstractResponse;
import io.littlehorse.common.model.command.SubCommand;
import io.littlehorse.common.model.wfrun.WfRun;
import io.littlehorse.common.proto.ExternalEventNodeTimeoutPb;
import io.littlehorse.common.proto.ExternalEventNodeTimeoutPbOrBuilder;
import io.littlehorse.common.util.LHUtil;
import java.util.Date;
import org.apache.log4j.Logger;

public class ExternalEventTimeout extends SubCommand<ExternalEventNodeTimeoutPb> {

    private static final Logger log = Logger.getLogger(ExternalEventTimeout.class);

    public String wfRunId;
    public int threadRunNumber;
    public int nodeRunPosition;
    public Date time;

    public Class<ExternalEventNodeTimeoutPb> getProtoBaseClass() {
        return ExternalEventNodeTimeoutPb.class;
    }

    public ExternalEventNodeTimeoutPb.Builder toProto() {
        ExternalEventNodeTimeoutPb.Builder out = ExternalEventNodeTimeoutPb
            .newBuilder()
            .setWfRunId(wfRunId)
            .setThreadRunNumber(threadRunNumber)
            .setNodeRunPosition(nodeRunPosition)
            .setTime(LHUtil.fromDate(time));
        return out;
    }

    public void initFrom(MessageOrBuilder proto) {
        ExternalEventNodeTimeoutPbOrBuilder p = (ExternalEventNodeTimeoutPbOrBuilder) proto;
        wfRunId = p.getWfRunId();
        threadRunNumber = p.getThreadRunNumber();
        nodeRunPosition = p.getNodeRunPosition();
        time = LHUtil.fromProtoTs(p.getTime());
    }

    public String getPartitionKey() {
        return wfRunId;
    }

    public AbstractResponse<?> process(LHDAO dao, LHConfig config) {
        WfRun wfRun = dao.getWfRun(wfRunId);

        if (wfRun == null) {
            log.warn("Got an externalEventTimeout for missing wfRun " + wfRunId);
            return null;
        }

        wfRun.wfSpec = dao.getWfSpec(wfRun.wfSpecName, wfRun.wfSpecVersion);
        wfRun.cmdDao = dao;
        wfRun.processExtEvtTimeout(this);

        return null;
    }

    public boolean hasResponse() {
        return false;
    }

    public static ExternalEventTimeout fromProto(
        ExternalEventNodeTimeoutPbOrBuilder p
    ) {
        ExternalEventTimeout out = new ExternalEventTimeout();
        out.initFrom(p);
        return out;
    }
}
