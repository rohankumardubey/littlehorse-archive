package io.littlehorse.server.streamsimpl.storeinternals;

import com.google.common.base.Predicate;
import com.google.protobuf.Message;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.LHDAO;
import io.littlehorse.common.model.Getable;
import io.littlehorse.common.model.ObjectId;
import io.littlehorse.common.model.Storeable;
import io.littlehorse.common.model.command.Command;
import io.littlehorse.server.streamsimpl.coreprocessors.CommandProcessorOutput;
import io.littlehorse.server.streamsimpl.storeinternals.utils.GetableToStore;
import io.littlehorse.server.streamsimpl.storeinternals.utils.StoredGetable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.kafka.streams.processor.api.ProcessorContext;

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
    private Map<ObjectId<?, ?, ?>, GetableToStore<?, ?>> buffer;
    private LHDAO dao;
    private TagStorageManager tagStorageManager;

    /**
     * The GetableStorageManager is a lightweight object that is created for each
     * Command that is processed in the CommandProcessor#process() method.
     * @param rocksdbWrapper gives access to RocksDB.
     * @param ctx is the Kafka Streams Processor Context from the Core Command
     * Processor.
     * @param config is an LHConfig.
     * @param command is the Command that is being processed by the Core Command
     * Processor.
     * @param dao is a handle to the LHDao for the Streams Task that this
     * GetableStorageManager lives on.
     */
    public GetableStorageManager(
        RocksDBWrapper rocksdbWrapper,
        final ProcessorContext<String, CommandProcessorOutput> ctx,
        LHConfig config,
        Command command,
        LHDAO dao
    ) {
        this.rocksdbWrapper = rocksdbWrapper;
        this.buffer = new TreeMap<>();
        this.command = command;
        this.dao = dao;
        this.tagStorageManager = new TagStorageManager(rocksdbWrapper, ctx, config);
    }

    /**
     * Gets a getable with a provided ID from the store (within a transaction). Note
     * that if you make any modifications to the Java object returned by this method,
     * then those changes will be persisted in the state store when the "transaction"
     * is committed, i.e. when we call {@link LHDAO#commitChanges()}.
     * @param <U> is the proto type of the Getable.
     * @param <T> is the java class type of the Getable.
     * @param id is the ObjectId to look for.
     * @return the specified Getable, or null if it doesn't exist.
     */
    public <U extends Message, T extends Getable<U>> T get(ObjectId<?, U, T> id) {
        log.trace("Getting {} with key {}", id.getType(), id.getStoreKey());
        T out = null;

        // First check the cache.
        @SuppressWarnings("unchecked")
        GetableToStore<U, T> bufferedResult = (GetableToStore<U, T>) buffer.get(id);
        if (bufferedResult != null) {
            return bufferedResult.getObjectToStore();
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

        buffer.put(id, new GetableToStore<>(storeResult, id.getGetableClass()));
        return out;
    }

    /**
     * Puts a Getable in the buffer to be flushed when LHDAO#commit() is called.
     * @param <U> is the proto type of the getable.
     * @param <T> is the class of the getable.
     * @param getable is the getable to store.
     * @throws IllegalStateException if a different getable Java Object has been
     * put into the store in the same transaction BUT with also the same objectId.
     */
    public <U extends Message, T extends Getable<U>> void put(T getable)
        throws IllegalStateException {
        log.trace(
            "Putting {} with key {}",
            getable.getClass(),
            getable.getStoreKey()
        );

        @SuppressWarnings("unchecked")
        GetableToStore<U, T> bufferedResult = (GetableToStore<U, T>) buffer.get(
            getable.getObjectId()
        );

        if (bufferedResult != null) {
            if (bufferedResult.getObjectToStore() != getable) {
                throw new IllegalStateException(
                    "Appears that Getable " +
                    getable.getObjectId() +
                    " was re-instantiated"
                );
            }
            // We know that the buffer already has a pointer to the thing
            // we are storing. We can safely return now.
            return;
        }

        // At this point, we know that `getable` has not yet been stored *in this
        // transaction* since it's not in the buffer. So we need to store it.
        //
        // However, the Getable *may or may not* be in the store. If it is in the
        // store, we need to store the TagsCache in the buffer. Therefore, we still
        // have to call get().

        @SuppressWarnings("unchecked")
        StoredGetable<U, T> previousValue = (StoredGetable<U, T>) rocksdbWrapper.get(
            getable.getStoreKey(),
            StoredGetable.class
        );

        @SuppressWarnings("unchecked")
        GetableToStore<U, T> toPut = new GetableToStore<>(
            previousValue,
            (Class<T>) getable.getClass()
        );

        toPut.setObjectToStore(getable);
        buffer.put(getable.getObjectId(), toPut);
    }

    /**
     * Marks for deletion all Getable's with the provided type and prefix. They
     * and their Tags will be deleted from the store upon the call to
     * {@link LHDAO#commitChanges()}.
     *
     * This method was made to be called when the LHDAO deletes a WfRun and all of
     * its children. As such, for example, it will delete all of the NodeRun's of
     * the WfRun.
     *
     * In the future, we will have to implement a "phased delete" so that we can
     * safely delete WfRun's with 5k+ NodeRun's without stalling progress of the
     * processor. However, it should be fine for up to 5k, and initial use cases
     * will not have more than 5k NodeRun's in a WfRun.
     *
     * @param prefix is the objectId prefix to delete.
     * @param cls is the type of object to delete.
     */
    public <U extends Message, T extends Getable<U>> void deleteAllByPrefix(
        String prefix,
        Class<T> cls
    ) {
        log.trace("Deleting all {} with prefix {}", cls.getSimpleName(), prefix);

        // Note this iterates in a non-paginated way through all NodeRun's in the
        // WfRun. Fine for most use-cases, but if there's a WfRUn that runs for a
        // year and has hundreds of tasks per day, it will be a problem.
        List<GetableToStore<U, T>> allItems = iterateOverPrefixAndPutInBuffer(
            prefix,
            cls
        );

        for (GetableToStore<U, T> itemToDelete : allItems) {
            // Marking the objectToStore as null causes the flush() to delete it.
            itemToDelete.setObjectToStore(null);
        }
    }

    /**
     * Accepts an ObjectId Prefix and a predicate, and returns the first ObjectId
     * in the store+buffer, ordered by the Getable's created time, that matches
     * the predicate.
     * @param <U> Is the Getable proto type
     * @param <T> is the Getable java type
     * @param prefix is the prefix to search from
     * @param cls is the Java class
     * @param discriminator is a filter to apply to the result
     * @return the first T by created time that matches discriminator, or else null.
     */
    public <
        U extends Message, T extends Getable<U>
    > T getFirstByCreatedTimeFromPrefix(
        String prefix,
        Class<T> cls,
        Predicate<T> discriminator
    ) {
        T result = iterateOverPrefix(prefix, cls)
            .stream()
            .map(getableToStore -> getableToStore.getObjectToStore())
            .filter(discriminator)
            .min((t1, t2) -> t1.getCreatedAt().compareTo(t2.getCreatedAt()))
            .orElse(null);

        // iterateOverPrefix doesn't put in the buffer. We do that here, but only
        // for the one we return.
        put(result);

        return result;
    }

    /**
     * Marks a provided Getable for deletion upon the committing of the "transaction"
     * when we call {@link GetableStorageManager#flush()}.
     * @param <U> is the proto type of the Getable to delete.
     * @param <T> is the java type of the Getable to delete.
     * @param id is the ObjectId of the Getable to delete.
     * @return the Getable we deleted, if it exists, or null otherwise.
     */
    public <U extends Message, T extends Getable<U>> T delete(ObjectId<?, U, T> id) {
        log.trace("Deleting {} with key {}", id.getType(), id.getStoreKey());

        T thingToDelete = get(id);
        if (thingToDelete == null) return null;

        // Then we need to update the GetableToStore to reflect that we're
        // going to delete it. Also note that since we called get(), we know
        // that the thing is already in the buffer.
        @SuppressWarnings("unchecked")
        GetableToStore<U, T> bufferEntry = (GetableToStore<U, T>) buffer.get(id);

        if (bufferEntry == null) {
            throw new IllegalStateException(
                "Impossible to get null buffer entry after successfull this#get()"
            );
        }
        // Mark it for deletion
        bufferEntry.setObjectToStore(null);

        return thingToDelete;
    }

    /**
     * Flushes all state updates stored in the buffer. This should be called at the
     * end of CommandProcessor#process(), in other words, for each Command record
     * in the `core-cmd` Kafka topic.
     *
     * This method is responsible for:
     * - Flushing actual Getable object state into RocksDB
     * - Flushing local tags into RocksDB
     * - Flushing remote tags into RocksDB.
     */
    // TODO: Check if this is just Colt's IDE
    @SuppressWarnings("unchecked")
    public void flush() {
        log.trace("Flushing for command {}", command.getType());

        for (Map.Entry<ObjectId<?, ?, ?>, GetableToStore<?, ?>> entry : buffer.entrySet()) {
            ObjectId<?, ?, ?> id = entry.getKey();
            GetableToStore<?, ?> entity = entry.getValue();

            if (entity.getObjectToStore() == null) {
                rocksdbWrapper.delete(
                    StoredGetable.getStoreKey(id),
                    Storeable.getStoreableType(
                        (Class<? extends Storeable<?>>) StoredGetable.class
                    )
                );
                tagStorageManager.store(
                    List.of(),
                    entity.getTagsPresentBeforeUpdate(),
                    id.getGetableClass()
                );
            } else {
                Getable<?> getable = entity.getObjectToStore();
                rocksdbWrapper.put(new StoredGetable<>(getable));
                tagStorageManager.store(
                    getable.getIndexEntries(),
                    entity.getTagsPresentBeforeUpdate(),
                    (Class<? extends Getable<?>>) getable.getClass()
                );

                if (isGlobalMetadata(getable)) {
                    // forward to changelog topic
                }
            }
        }
    }

    private <
        U extends Message, T extends Getable<U>
    > List<GetableToStore<U, T>> iterateOverPrefixAndPutInBuffer(
        String prefix,
        Class<T> cls
    ) {
        throw new NotImplementedException();
    }

    private <
        U extends Message, T extends Getable<U>
    > List<GetableToStore<U, T>> iterateOverPrefix(String prefix, Class<T> cls) {
        throw new NotImplementedException();
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
