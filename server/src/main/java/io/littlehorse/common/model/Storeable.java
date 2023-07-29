package io.littlehorse.common.model;

import com.google.protobuf.Message;
import io.littlehorse.common.proto.StoreableClassEnumPb;
import io.littlehorse.common.proto.TagStorageTypePb;

public abstract class Storeable<T extends Message> extends LHSerializable<T> {

    public String getFullStoreKey() {
        return getFullStoreKey(getType(), getFullStoreKey());
    }

    public static String getSubstorePrefix(StoreableClassEnumPb storeableType) {
        return String.valueOf(storeableType.getNumber()) + "/";
    }

    public static String getSubstorePrefix(Class<? extends Storeable<?>> cls) {
        return getSubstorePrefix(getStoreableType(cls));
    }

    public static String getFullStoreKey(StoreableClassEnumPb type, String storeKey) {
        return getSubstorePrefix(type) + storeKey;
    }

    public static String getFullStoreKey(
        Class<? extends Storeable<?>> cls,
        String storeKey
    ) {
        return getSubstorePrefix(getStoreableType(cls)) + storeKey;
    }

    public abstract String getStoreKey();

    public abstract StoreableClassEnumPb getType();

    public TagStorageTypePb tagStorageTypePb() {
        return TagStorageTypePb.LOCAL;
    }

    public static StoreableClassEnumPb getStoreableType(
        Class<? extends Storeable<?>> cls
    ) {
        switch (cls.getSimpleName()) {
            case "StoredGetable":
                return StoreableClassEnumPb.STORED_GETABLE;
            case "LHTimer":
                return StoreableClassEnumPb.LH_TIMER;
            case "Tag":
                return StoreableClassEnumPb.TAG;
            case "ScheduledTask":
                return StoreableClassEnumPb.SCHEDULED_TASK;
            case "WfMetricUpdate":
                return StoreableClassEnumPb.WF_METRIC_UPDATE;
            case "TaskMericUpdate":
                return StoreableClassEnumPb.TASK_METRIC_UPDATE;
        }
        throw new IllegalArgumentException("Unrecognized Storeable class: " + cls);
    }
}
