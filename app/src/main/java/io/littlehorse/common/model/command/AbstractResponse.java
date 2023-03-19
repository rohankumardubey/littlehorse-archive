package io.littlehorse.common.model.command;

import com.google.protobuf.Message;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.jlib.common.proto.LHResponseCodePb;

public abstract class AbstractResponse<T extends Message> extends LHSerializable<T> {

    public LHResponseCodePb code;
    public String message;
}
