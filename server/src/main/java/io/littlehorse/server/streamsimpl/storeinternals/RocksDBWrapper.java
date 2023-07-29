package io.littlehorse.server.streamsimpl.storeinternals;

import io.littlehorse.common.LHConfig;
import io.littlehorse.common.model.Storeable;
import io.littlehorse.common.proto.StoreableClassEnumPb;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.state.KeyValueStore;

@Slf4j
public class RocksDBWrapper extends ReadOnlyRocksDBWrapper {

    // note that super has ReadOnlyKeyValueStore<String, Bytes>
    private KeyValueStore<String, Bytes> rocksdb;

    public RocksDBWrapper(KeyValueStore<String, Bytes> rocksdb, LHConfig config) {
        super(rocksdb, config);
        this.rocksdb = rocksdb;
    }

    public void delete(Storeable<?> thing) {
        this.delete(thing.getStoreKey(), thing.getType());
    }

    public void put(Storeable<?> thing) {
        String storeKey = thing.getFullStoreKey();
        log.trace("Putting {}", storeKey);
        rocksdb.put(storeKey, new Bytes(thing.toBytes()));
    }

    public void delete(String storeKey, StoreableClassEnumPb cls) {
        String fullKey = Storeable.getFullStoreKey(cls, storeKey);
        log.trace("Deleting {}", fullKey);
        rocksdb.delete(fullKey);
    }
}
