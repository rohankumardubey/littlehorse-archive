package io.littlehorse.common.model;

import com.google.protobuf.Message;
import io.littlehorse.common.proto.GetableClassEnumPb;
import java.lang.reflect.InvocationTargetException;

public abstract class ObjectId<
    T extends Message, U extends Message, V extends Getable<U>
>
    extends LHSerializable<T>
    implements Comparable<ObjectId<?, ?, ?>> {

    public abstract String getStoreKey();

    public abstract void initFrom(String storeKey);

    public abstract String getPartitionKey();

    public abstract GetableClassEnumPb getType();

    @Override
    public String toString() {
        return getStoreKey();
    }

    @SuppressWarnings("unchecked")
    public Class<V> getGetableClass() {
        return (Class<V>) Getable.getCls(getType());
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (!this.getClass().equals(other.getClass())) return false;

        return getStoreKey().equals(((ObjectId<?, ?, ?>) other).getStoreKey());
    }

    @Override
    public int hashCode() {
        return getStoreKey().hashCode();
    }

    @Override
    public int compareTo(ObjectId<?, ?, ?> other) {
        if (other.getType() != getType()) {
            return getType().compareTo(getType());
        }
        return getStoreKey().compareTo(other.getStoreKey());
    }

    public static <
        T extends Message, U extends Message, V extends LHSerializable<U>
    > ObjectId<?, ?, ?> fromString(
        String objectId,
        Class<? extends ObjectId<?, ?, ?>> cls
    ) {
        try {
            ObjectId<?, ?, ?> id = cls.getDeclaredConstructor().newInstance();
            id.initFrom(objectId);
            return id;
        } catch (
            IllegalAccessException
            | InstantiationException
            | InvocationTargetException
            | NoSuchMethodException exn
        ) {
            throw new RuntimeException(exn);
        }
    }
}
