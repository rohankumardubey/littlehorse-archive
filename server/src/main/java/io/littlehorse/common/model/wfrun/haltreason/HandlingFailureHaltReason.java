package io.littlehorse.common.model.wfrun.haltreason;

import com.google.protobuf.Message;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.model.wfrun.NodeRun;
import io.littlehorse.common.model.wfrun.ThreadRun;
import io.littlehorse.common.model.wfrun.WaitForThread;
import io.littlehorse.common.model.wfrun.WfRun;
import io.littlehorse.sdk.common.proto.HandlingFailureHaltReasonPb;
import io.littlehorse.sdk.common.proto.LHStatusPb;
import io.littlehorse.sdk.common.proto.NodeRunPb.NodeTypeCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HandlingFailureHaltReason
    extends LHSerializable<HandlingFailureHaltReasonPb>
    implements SubHaltReason {

    public int handlerThreadId;

    public boolean isResolved(WfRun wfRun) {
        ThreadRun handlerThread = wfRun.threadRuns.get(handlerThreadId);
        log.debug(
            "HandlingFailureHaltReason for failed thread {}: handler thread " +
            "status is {}",
            handlerThread.getFailureBeingHandled().getThreadRunNumber(),
            handlerThread.getStatus()
        );
        if (handlerThread.status == LHStatusPb.COMPLETED) {
            // Need to figure out if the handler thread was handling another
            // failed thread.
            ThreadRun originalThatFailed = wfRun.threadRuns.get(
                handlerThread.failureBeingHandled.getThreadRunNumber()
            );
            NodeRun handledNode = originalThatFailed.getNodeRun(
                handlerThread.failureBeingHandled.getNodeRunPosition()
            );

            if (handledNode.type == NodeTypeCase.WAIT_THREADS) {
                // The current implementation of failure handlers for wait_thread nodes
                // is an all-or-nothing handler that catches all failed children.
                //
                // Therefore, what we must do here is add each of the failed children.
                for (WaitForThread wft : handledNode
                    .getWaitThreadsRun()
                    .getThreads()) {
                    if (wft.getThreadStatus() == LHStatusPb.ERROR) {
                        originalThatFailed.handledFailedChildren.add(
                            wft.getThreadRunNumber()
                        );
                    } else if (wft.getThreadStatus() != LHStatusPb.COMPLETED) {
                        log.warn(
                            "Impossible: handling failure for a WaitThreadNode " +
                            "and found a non-terminated child"
                        );
                    }
                }
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
