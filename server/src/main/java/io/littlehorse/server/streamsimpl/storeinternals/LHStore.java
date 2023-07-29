package io.littlehorse.server.streamsimpl.storeinternals;

import com.google.common.base.Predicate;
import com.google.protobuf.Message;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.LHDAO;
import io.littlehorse.common.model.Getable;
import io.littlehorse.common.model.ObjectId;
import io.littlehorse.common.model.command.Command;
import io.littlehorse.server.streamsimpl.coreprocessors.CommandProcessorOutput;
import java.util.Map;
import java.util.TreeMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

@Slf4j
public class LHStore {

    private KeyValueStore<String, Bytes> rocksdb;
    private Command command;
    private Map<ObjectId<?, ?, ?>, Getable<?>> buffer;
    private final ProcessorContext<String, CommandProcessorOutput> ctx;
    private LHDAO dao;

    public LHStore(
        KeyValueStore<String, Bytes> store,
        final ProcessorContext<String, CommandProcessorOutput> ctx,
        LHConfig config,
        Command command,
        LHDAO dao
    ) {
        // TODO: Make this accept a DAO.
        this.rocksdb = store;
        this.ctx = ctx;
        this.buffer = new TreeMap<>();
        this.command = command;
        this.dao = dao;
    }

    public <U extends Message, T extends Getable<U>> T get(ObjectId<?, U, T> id) {
        log.trace("Getting {} with key {}", id.getType(), id.getStoreKey());
        // Remember to provide the dao
        throw new NotImplementedException();
    }

    public <U extends Message, T extends Getable<U>> T put(T getable) {
        log.trace(
            "Putting {} with key {}",
            getable.getClass(),
            getable.getStoreKey()
        );
        throw new NotImplementedException();
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
