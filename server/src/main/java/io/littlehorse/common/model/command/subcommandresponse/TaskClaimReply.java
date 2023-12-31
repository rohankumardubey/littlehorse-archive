package io.littlehorse.common.model.command.subcommandresponse;

import com.google.protobuf.Message;
import io.littlehorse.common.model.command.AbstractResponse;
import io.littlehorse.common.model.wfrun.ScheduledTask;
import io.littlehorse.sdk.common.proto.PollTaskReplyPb;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskClaimReply extends AbstractResponse<PollTaskReplyPb> {

    public ScheduledTask result;

    public Class<PollTaskReplyPb> getProtoBaseClass() {
        return PollTaskReplyPb.class;
    }

    public PollTaskReplyPb.Builder toProto() {
        PollTaskReplyPb.Builder out = PollTaskReplyPb.newBuilder();
        out.setCode(code);
        if (result != null) out.setResult(result.toProto());
        if (message != null) out.setMessage(message);
        return out;
    }

    public void initFrom(Message proto) {
        PollTaskReplyPb p = (PollTaskReplyPb) proto;
        if (p.hasResult()) {
            result = ScheduledTask.fromProto(p.getResult());
        }
        code = p.getCode();
        if (p.hasMessage()) message = p.getMessage();
    }
}
