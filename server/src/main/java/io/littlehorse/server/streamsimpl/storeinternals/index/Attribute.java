package io.littlehorse.server.streamsimpl.storeinternals.index;

import com.google.protobuf.Message;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.proto.AttributePb;

public class Attribute extends LHSerializable<AttributePb> {

    private String key;
    private String val;

    public Class<AttributePb> getProtoBaseClass() {
        return AttributePb.class;
    }

    public AttributePb.Builder toProto() {
        AttributePb.Builder out = AttributePb.newBuilder().setKey(key).setVal(val);
        return out;
    }

    public void initFrom(Message proto) {
        AttributePb p = (AttributePb) proto;
        key = p.getKey();
        val = p.getVal();
    }

    // TODO: determine what escaping is necessary
    public String getEscapedKey() {
        return key;
    }

    // TODO: determine what escaping is necessary
    public String getEscapedVal() {
        return val;
    }

    public Attribute(String key, String val) {
        this.key = key;
        this.val = val;
    }

    public Attribute() {}

    public static Attribute fromProto(AttributePb p) {
        Attribute out = new Attribute();
        out.initFrom(p);
        return out;
    }
}
