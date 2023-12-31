package io.littlehorse.common.model.wfrun;

import com.google.protobuf.Message;
import io.littlehorse.common.LHDAO;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.model.meta.Node;
import io.littlehorse.common.model.meta.WfSpec;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class SubNodeRun<T extends Message> extends LHSerializable<T> {

    public NodeRun nodeRun;

    public abstract boolean advanceIfPossible(Date time);

    public abstract void arrive(Date time);

    /*
     * The default is that we can't interrupt a node that's making active progress,
     * the clearest example being that when a Task Worker is working on a TaskRun
     * we have to wait for the response to come back before it's safe to initialize
     * an interrupt thread.
     */
    public boolean canBeInterrupted() {
        return !nodeRun.isInProgress();
    }

    public void setNodeRun(NodeRun nodeRun) {
        this.nodeRun = nodeRun;
    }

    public WfSpec getWfSpec() {
        return getWfRun().getWfSpec();
    }

    public WfRun getWfRun() {
        return nodeRun.getThreadRun().getWfRun();
    }

    public Node getNode() {
        return nodeRun.getNode();
    }

    public LHDAO getDao() {
        return nodeRun.getThreadRun().getWfRun().getDao();
    }
}
