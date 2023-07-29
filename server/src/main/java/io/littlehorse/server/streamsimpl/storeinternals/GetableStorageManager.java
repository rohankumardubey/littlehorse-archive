package io.littlehorse.server.streamsimpl.storeinternals;

import com.google.common.base.Predicate;
import com.google.protobuf.Message;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.LHDAO;
import io.littlehorse.common.model.Getable;
import io.littlehorse.common.model.ObjectId;
import io.littlehorse.common.model.command.Command;
import io.littlehorse.server.streamsimpl.coreprocessors.CommandProcessorOutput;
import io.littlehorse.server.streamsimpl.storeinternals.utils.StoredGetable;
import java.util.Map;
import java.util.TreeMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

/*
 * The GetableStorageManager is a logical wrapper that handles the storage
 * and indexing of Getable objects, including forwarding CreateRemoteTag and
 * DeleteRemoteTag commands to the Repartition Command Topic.
 *
 * It does NOT deal with storing non-Getable's, such as ScheduledTasks, nor does it
 * forward Timers.
 *
 * This object only exists on the Core Command Processor. A new one is created for
 * every Command that we process.
 */
@Slf4j
public class GetableStorageManager {

    private RocksDBWrapper rocksdbWrapper;
    private Command command;
    private Map<ObjectId<?, ?, ?>, StoredGetable<?, ?>> buffer;
    private final ProcessorContext<String, CommandProcessorOutput> ctx;
    private LHDAO dao;

    public GetableStorageManager(
        RocksDBWrapper rocksdbWrapper,
        final ProcessorContext<String, CommandProcessorOutput> ctx,
        LHConfig config,
        Command command,
        LHDAO dao
    ) {
        this.rocksdbWrapper = rocksdbWrapper;
        this.ctx = ctx;
        this.buffer = new TreeMap<>();
        this.command = command;
        this.dao = dao;
    }

    public <U extends Message, T extends Getable<U>> T get(ObjectId<?, U, T> id) {
        log.trace("Getting {} with key {}", id.getType(), id.getStoreKey());
        T out = null;

        // First check the cache.
        @SuppressWarnings("unchecked")
        StoredGetable<U, T> hotResult = (StoredGetable<U, T>) buffer.get(id);
        if (hotResult != null) {
            return hotResult.getStoredObject();
        }

        // Next check the store.
        @SuppressWarnings("unchecked")
        StoredGetable<U, T> storeResult = (StoredGetable<U, T>) rocksdbWrapper.get(
            id.getStoreKey(),
            StoredGetable.class
        );

        if (storeResult == null) return null;

        // If we got here, that means that:
        // 1. The Getable exists in the store, and
        // 2. This is the first time in this txn (eg. Command Processing) that
        //    we are getting the
        out = storeResult.getStoredObject();
        out.setDao(dao);

        buffer.put(id, storeResult);
        return out;
    }

    public <U extends Message, T extends Getable<U>> void put(T getable) {
        log.trace(
            "Putting {} with key {}",
            getable.getClass(),
            getable.getStoreKey()
        );

        @SuppressWarnings("unchecked")
        StoredGetable<U, T> hotResult = (StoredGetable<U, T>) buffer.get(
            getable.getObjectId()
        );

        if (hotResult != null) {
            if (hotResult.getStoredObject() != getable) {
                throw new IllegalArgumentException(
                    "Appears that Getable " +
                    getable.getObjectId() +
                    " was re-instantiated"
                );
            }

            return;
        }

        // At this point, we know that the Getable hasn't been accessed yet in this
        // 'transaction', since it's not in the buffer.
        //
        // However, the Getable *may or may not* be in the store. If it is in the
        // store, we need to get it so that we can see whether it has

        Resume Train of Thought Here;
        StoredGetable<U, T> toPut = new StoredGetable<>();
        toPut.setStoredObject(getable);
        buffer.put(getable.getObjectId(), toPut);
    }

    public void deleteAllByPrefix(String prefix, Class<? extends Getable<?>> cls) {
        throw new NotImplementedException();
    }

    public <
        U extends Message, T extends Getable<U>
    > T getFirstByCreatedTimeFromPrefix(
        String prefix,
        Class<T> cls,
        Predicate<T> discriminator
    ) {
        throw new NotImplementedException();
    }

    public <U extends Message, T extends Getable<U>> T delete(ObjectId<?, U, T> id) {
        log.trace("Deleting {} with key {}", id.getType(), id.getStoreKey());
        throw new NotImplementedException();
    }

    public void flush() {
        throw new NotImplementedException();
    }

    public void reset() {
        throw new NotImplementedException();
    }

    // TODO: Do we need to implement prefixScan()?

    public <U extends Message, T extends Getable<U>> T getLastFromPrefix(
        String prefix,
        Class<T> cls
    ) {
        return null;
    }
}
/*
// Getable#getStoreKey() -> some string

getable = rocksdb.get(someKey);

// ... make changes

existingTags = rocskdb.get(getable.getExistingTagsKey());
for (tag in getable.getTags()) {
    if (tag not in existingTags) {
        rocksdb.put(tag);
    }
}

for (tag in existingTags) {
    if (tag not in getable.getTags()) {
        rocksdb.remove(tag);
    }
}

rocksdb.put(getable.getExistingTagsKey(), getable.getTags());
rocksdb.put(getable.getStoreKey(), getable);

 */
/*

message StoredGetable {
    TagsCachePb existing_tags = 1;
    bytes getable_payload = 2;
    string store_key = 3;
}

StoredGetable = rocksdb.get(someKey);
getable = StoredGetable.getGetable();
existingTags = StoredGetable.getExistingTags();

// make changes
// store tags like above


rocksdb.put(someKey, new StoredGetable(getable, getable.getTags()))
 */
/*

Command Processing:
-> LHDaoImpl(ProcessorContext)
  -> has an LHStoreWrapper
  -> has a GetableStorageManager which uses the LHSToreWrapper
     -> has a TagStorageManager which uses the LHStoreWrapper + PRocessorContext
* LHStoreWrapper uses ProcessorContext to get the store.

Suggest:
* LHDAO
  -> LHDAO has an LHStore, does NOT use localStore
     -> LHStore hides the localStore and processor context.

LHDAO#commit() {
    calls LHStore.commit()
}

 */
/* Processing Loop

For each command {
    dao.reset();
    command.process(dao);
    dao.commit();
}

dao reset -> clear the buffer

dao commit -> for each thing in the buffer, push into rocksdb.
*/
