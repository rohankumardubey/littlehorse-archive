package io.littlehorse.server.streamsimpl.storeinternals.utils;

import com.google.protobuf.Message;
import io.littlehorse.common.model.Getable;
import io.littlehorse.common.proto.GetableClassEnumPb;
import io.littlehorse.server.streamsimpl.storeinternals.index.TagsCache;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetableToStore<U extends Message, T extends Getable<U>> {

    @Setter(AccessLevel.NONE)
    private final TagsCache tagsPresentBeforeUpdate;

    @Setter(AccessLevel.NONE)
    private final GetableClassEnumPb objectType;

    private T objectToStore;

    public GetableToStore(StoredGetable<U, T> thingInStore, Class<T> cls) {
        this.objectType = Getable.getTypeEnum(cls);

        if (thingInStore != null) {
            this.tagsPresentBeforeUpdate = thingInStore.getIndexCache();
            this.objectToStore = thingInStore.getStoredObject();
        } else {
            this.tagsPresentBeforeUpdate = null;
        }
    }
}
