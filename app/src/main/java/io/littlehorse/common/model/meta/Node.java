package io.littlehorse.common.model.meta;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.protobuf.MessageOrBuilder;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.exceptions.LHValidationError;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.model.meta.subnode.EntrypointNode;
import io.littlehorse.common.model.meta.subnode.ExitNode;
import io.littlehorse.common.model.meta.subnode.ExternalEventNode;
import io.littlehorse.common.model.meta.subnode.NopNode;
import io.littlehorse.common.model.meta.subnode.SleepNode;
import io.littlehorse.common.model.meta.subnode.StartThreadNode;
import io.littlehorse.common.model.meta.subnode.TaskNode;
import io.littlehorse.common.model.meta.subnode.WaitForThreadNode;
import io.littlehorse.common.util.LHGlobalMetaStores;
import io.littlehorse.common.util.LHUtil;
import io.littlehorse.jlib.common.proto.EdgePb;
import io.littlehorse.jlib.common.proto.FailureHandlerDefPb;
import io.littlehorse.jlib.common.proto.NodePb;
import io.littlehorse.jlib.common.proto.NodePb.NodeCase;
import io.littlehorse.jlib.common.proto.NodePbOrBuilder;
import io.littlehorse.jlib.common.proto.NopNodePb;
import io.littlehorse.jlib.common.proto.VariableMutationPb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node extends LHSerializable<NodePb> {

    public NodeCase type;
    public TaskNode taskNode;
    public ExternalEventNode externalEventNode;
    public EntrypointNode entrypointNode;
    public ExitNode exitNode;
    public StartThreadNode startThreadNode;
    public WaitForThreadNode waitForThreadNode;
    public NopNode nop;
    public SleepNode sleepNode;

    public List<VariableMutation> variableMutations;
    // public OutputSchema outputSchema;

    public List<FailureHandlerDef> failureHandlers;

    @JsonIgnore
    public Class<NodePb> getProtoBaseClass() {
        return NodePb.class;
    }

    @JsonIgnore
    public NodePb.Builder toProto() {
        NodePb.Builder out = NodePb.newBuilder();

        for (Edge o : outgoingEdges) {
            out.addOutgoingEdges(o.toProto());
        }

        for (VariableMutation v : variableMutations) {
            out.addVariableMutations(v.toProto());
        }

        for (FailureHandlerDef eh : failureHandlers) {
            out.addFailureHandlers(eh.toProto());
        }

        switch (type) {
            case TASK:
                out.setTask(taskNode.toProto());
                break;
            case ENTRYPOINT:
                out.setEntrypoint(entrypointNode.toProto());
                break;
            case EXIT:
                out.setExit(exitNode.toProto());
                break;
            case EXTERNAL_EVENT:
                out.setExternalEvent(externalEventNode.toProto());
                break;
            case START_THREAD:
                out.setStartThread(startThreadNode.toProto());
                break;
            case WAIT_FOR_THREAD:
                out.setWaitForThread(waitForThreadNode.toProto());
                break;
            case NOP:
                out.setNop(NopNodePb.newBuilder());
                break;
            case SLEEP:
                out.setSleep(sleepNode.toProto());
                break;
            case NODE_NOT_SET:
                throw new RuntimeException("Not possible");
        }

        return out;
    }

    public void initFrom(MessageOrBuilder p) {
        NodePbOrBuilder proto = (NodePbOrBuilder) p;
        type = proto.getNodeCase();

        for (EdgePb epb : proto.getOutgoingEdgesList()) {
            Edge edge = Edge.fromProto(epb);
            edge.threadSpec = threadSpec;
            outgoingEdges.add(edge);
        }

        for (VariableMutationPb vmpb : proto.getVariableMutationsList()) {
            VariableMutation vm = new VariableMutation();
            vm.initFrom(vmpb);
            variableMutations.add(vm);
        }

        for (FailureHandlerDefPb ehpb : proto.getFailureHandlersList()) {
            failureHandlers.add(FailureHandlerDef.fromProto(ehpb));
        }

        switch (type) {
            case TASK:
                taskNode = new TaskNode();
                taskNode.initFrom(proto.getTask());
                break;
            case ENTRYPOINT:
                entrypointNode = new EntrypointNode();
                entrypointNode.initFrom(proto.getEntrypoint());
                break;
            case EXIT:
                exitNode = new ExitNode();
                exitNode.initFrom(proto.getExit());
                break;
            case EXTERNAL_EVENT:
                externalEventNode = new ExternalEventNode();
                externalEventNode.initFrom(proto.getExternalEvent());
                break;
            case START_THREAD:
                startThreadNode = new StartThreadNode();
                startThreadNode.initFrom(proto.getStartThread());
                break;
            case WAIT_FOR_THREAD:
                waitForThreadNode = new WaitForThreadNode();
                waitForThreadNode.initFrom(proto.getWaitForThread());
                break;
            case NOP:
                nop = new NopNode();
                break;
            case SLEEP:
                sleepNode = new SleepNode();
                sleepNode.initFrom(proto.getSleep());
                break;
            case NODE_NOT_SET:
                throw new RuntimeException(
                    "Node " + name + " on thread " + threadSpec.name + " is unset!"
                );
        }
        getSubNode().setNode(this);
    }

    // Implementation details below

    public Node() {
        outgoingEdges = new ArrayList<>();
        variableMutations = new ArrayList<>();
        failureHandlers = new ArrayList<>();
    }

    public List<Edge> outgoingEdges;
    public String name;

    @JsonIgnore
    public ThreadSpec threadSpec;

    @JsonIgnore
    public Set<String> neededVariableNames() {
        Set<String> out = new HashSet<>();

        for (VariableMutation mut : variableMutations) {
            out.add(mut.lhsName);
            if (mut.rhsSourceVariable != null) {
                if (mut.rhsSourceVariable.rhsVariableName != null) {
                    out.add(mut.rhsSourceVariable.rhsVariableName);
                }
            }
        }

        out.addAll(getSubNode().getNeededVariableNames());

        return out;
    }

    public void validate(LHGlobalMetaStores client, LHConfig config)
        throws LHValidationError {
        for (Edge e : outgoingEdges) {
            if (e.sinkNodeName.equals(name)) {
                throw new LHValidationError(null, "Self loop not allowed!");
            }

            Node sink = threadSpec.nodes.get(e.sinkNodeName);
            if (sink == null) {
                throw new LHValidationError(
                    null,
                    String.format(
                        "Outgoing edge referring to missing node %s!",
                        e.sinkNodeName
                    )
                );
            }

            if (sink.type == NodeCase.ENTRYPOINT) {
                throw new LHValidationError(
                    null,
                    String.format(
                        "Entrypoint node has incoming edge from node %s.",
                        threadSpec.name,
                        name
                    )
                );
            }
            if (e.condition != null) {
                e.condition.validate();
            }
        }

        if (!outgoingEdges.isEmpty()) {
            Edge last = outgoingEdges.get(outgoingEdges.size() - 1);
            if (last.condition != null) {
                // throw new LHValidationError(
                //     null,
                //     "Last outgoing edge has non-null condition!"
                // );

                LHUtil.log(
                    "WARN: there is no default edge, better know what you're doing!",
                    "Future releases will validate that everything is ok."
                );
            }
        }

        try {
            getSubNode().validate(client, config);
        } catch (LHValidationError exn) {
            // Decorate the exception with contextual info
            exn.addPrefix("Sub Node");
            throw exn;
        }
    }

    public SubNode<?> getSubNode() {
        if (type == NodeCase.TASK) {
            return taskNode;
        } else if (type == NodeCase.ENTRYPOINT) {
            return entrypointNode;
        } else if (type == NodeCase.EXIT) {
            return exitNode;
        } else if (type == NodeCase.EXTERNAL_EVENT) {
            return externalEventNode;
        } else if (type == NodeCase.START_THREAD) {
            return startThreadNode;
        } else if (type == NodeCase.WAIT_FOR_THREAD) {
            return waitForThreadNode;
        } else if (type == NodeCase.NOP) {
            return nop;
        } else if (type == NodeCase.SLEEP) {
            return sleepNode;
        } else {
            throw new RuntimeException("Unhandled node type " + type);
        }
    }

    /**
     * Returns the set of all thread variable names referred to by this
     * Node. Used internally for validation of the WfSpec.
     */
    @JsonIgnore
    public Set<String> getRequiredVariableNames() {
        Set<String> out = new HashSet<>();
        for (VariableMutation mut : variableMutations) {
            out.addAll(mut.getRequiredVariableNames());
        }

        for (Edge edge : outgoingEdges) {
            out.addAll(edge.getRequiredVariableNames());
        }

        out.addAll(getSubNode().getNeededVariableNames());

        return out;
    }
}
