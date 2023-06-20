package io.littlehorse.common.model.wfrun.haltreason;

import com.google.protobuf.Message;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.model.wfrun.NodeRun;
import io.littlehorse.common.model.wfrun.ThreadRun;
import io.littlehorse.common.model.wfrun.WfRun;
import io.littlehorse.jlib.common.proto.HandlingFailureHaltReasonPb;
import io.littlehorse.jlib.common.proto.LHStatusPb;
import io.littlehorse.jlib.common.proto.NodeRunPb.NodeTypeCase;

public class HandlingFailureHaltReason
    extends LHSerializable<HandlingFailureHaltReasonPb>
    implements SubHaltReason {

    public int handlerThreadId;

    public boolean isResolved(WfRun wfRun) {
        ThreadRun hThread = wfRun.threadRuns.get(handlerThreadId);
        if (hThread.status == LHStatusPb.COMPLETED) {
            // Need to figure out if the handler thread was handling another
            // failed thread.
            ThreadRun originalThatFailed = wfRun.threadRuns.get(
                hThread.failureBeingHandled.threadRunNumber
            );
            NodeRun handledNode = originalThatFailed.getNodeRun(
                hThread.failureBeingHandled.nodeRunPosition
            );

            if (handledNode.type == NodeTypeCase.WAIT_THREAD) {
                originalThatFailed.handledFailedChildren.add(
                    handledNode.waitThreadRun.threadRunNumber
                );
            }
            return true;
        } else {
            return false;
        }
    }

    public Class<HandlingFailureHaltReasonPb> getProtoBaseClass() {
        return HandlingFailureHaltReasonPb.class;
    }

    public HandlingFailureHaltReasonPb.Builder toProto() {
        HandlingFailureHaltReasonPb.Builder out = HandlingFailureHaltReasonPb.newBuilder();
        out.setHandlerThreadId(handlerThreadId);
        return out;
    }

    public void initFrom(Message proto) {
        HandlingFailureHaltReasonPb p = (HandlingFailureHaltReasonPb) proto;
        handlerThreadId = p.getHandlerThreadId();
    }

    public static HandlingFailureHaltReason fromProto(
        HandlingFailureHaltReasonPb proto
    ) {
        HandlingFailureHaltReason out = new HandlingFailureHaltReason();
        out.initFrom(proto);
        return out;
    }
}