package io.littlehorse.server.streamsimpl.storeinternals.index;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.proto.TagStorageTypePb;
import io.littlehorse.common.proto.TagsCachePb;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CachedTag extends LHSerializable<TagsCachePb.CachedTagPb> {

    private String id;
    private boolean isRemote;

    public CachedTag() {}

    public CachedTag(Tag tag) {
        this.id = tag.getStoreKey();
        this.isRemote = tag.getTagStorageTypePb() == TagStorageTypePb.REMOTE;
    }

    @Override
    public TagsCachePb.CachedTagPb.Builder toProto() {
        return TagsCachePb.CachedTagPb.newBuilder().setId(id).setIsRemote(isRemote);
    }

    @Override
    public void initFrom(Message proto) {
        TagsCachePb.CachedTagPb cachedTagPb = (TagsCachePb.CachedTagPb) proto;
        this.id = cachedTagPb.getId();
        this.isRemote = cachedTagPb.getIsRemote();
    }

    public static CachedTag fromProto(TagsCachePb.CachedTagPb proto) {
        CachedTag out = new CachedTag();
        out.initFrom(proto);
        return out;
    }

    @Override
    public Class<? extends GeneratedMessageV3> getProtoBaseClass() {
        return null;
    }
}
