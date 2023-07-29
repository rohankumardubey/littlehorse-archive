package io.littlehorse.server.streamsimpl.storeinternals.utils;

import com.google.protobuf.Message;
import io.littlehorse.common.model.Getable;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.model.Storeable;
import io.littlehorse.common.proto.GetableClassEnumPb;
import io.littlehorse.common.proto.StoreableClassEnumPb;
import io.littlehorse.common.proto.StoredGetablePb;
import io.littlehorse.sdk.common.exception.LHSerdeError;
import io.littlehorse.server.streamsimpl.storeinternals.index.TagsCache;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class StoredGetable<U extends Message, T extends Getable<U>>
    extends Storeable<StoredGetablePb> {

    private TagsCache indexCache;
    private T storedObject;
    private GetableClassEnumPb objectType;

    public StoredGetable() {}

    @Override
    public Class<StoredGetablePb> getProtoBaseClass() {
        return StoredGetablePb.class;
    }

    @Override
    public void initFrom(Message proto) {
        StoredGetablePb p = (StoredGetablePb) proto;
        indexCache = LHSerializable.fromProto(p.getIndexCache(), TagsCache.class);
        objectType = p.getType();
        try {
            storedObject =
                LHSerializable.fromBytes(
                    p.getGetablePayload().toByteArray(),
                    getStoredClass()
                );
        } catch (LHSerdeError exn) {
            log.error("Failed loading from store: {}", exn);
        }
    }

    @Override
    public StoredGetablePb.Builder toProto() {
        StoredGetablePb.Builder out = StoredGetablePb
            .newBuilder()
            .setType(objectType)
            .setIndexCache(indexCache.toProto())
            .setGetablePayload(storedObject.toProto().build().toByteString());

        return out;
    }

    @Override
    public String getStoreKey() {
        return String.valueOf(
            objectType.getNumber() + "/" + storedObject.getObjectId().getStoreKey()
        );
    }

    @SuppressWarnings("unchecked")
    public Class<T> getStoredClass() {
        return (Class<T>) Getable.getCls(objectType);
    }

    @Override
    public StoreableClassEnumPb getType() {
        return StoreableClassEnumPb.STORED_GETABLE;
    }
}
