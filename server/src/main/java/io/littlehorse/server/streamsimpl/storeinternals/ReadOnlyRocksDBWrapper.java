package io.littlehorse.server.streamsimpl.storeinternals;

import com.google.protobuf.Message;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.model.Storeable;
import io.littlehorse.sdk.common.exception.LHSerdeError;
import io.littlehorse.server.streamsimpl.storeinternals.index.Tag;
import io.littlehorse.server.streamsimpl.storeinternals.utils.LHKeyValueIterator;
import io.littlehorse.server.streamsimpl.storeinternals.utils.LHKeyValueStream;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.annotation.InterfaceStability.Evolving;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;

/*
 * This is a wrapper around rocksdb stores for a single partition. It simply handles
 * serialization and segregation of types. This allows us to open only one
 * State Store and store multiple types of stuff within it, which allows for an
 * equivalent programming experience to just creating multiple KeyValueStore's
 * with different value types using Kafka Streams' standard API.
 *
 * However, the problem with multiple stores is that each store gets its own
 * changelog topic with many partitions, and additionally each changelog topic
 * causes another Consumer Group to be created among standby tasks. Those two
 * facts mean that more stores --> much longer consumer rebalance times when
 * you have a lot of input partitions. The performance and stability benefits
 * of consolidating into one state store far outweigh the extra code written
 * in this directory.
 */

@Slf4j
public class ReadOnlyRocksDBWrapper {

    protected ReadOnlyKeyValueStore<String, Bytes> rocksdb;
    protected LHConfig config;

    public ReadOnlyRocksDBWrapper(
        ReadOnlyKeyValueStore<String, Bytes> rocksdb,
        LHConfig config
    ) {
        this.rocksdb = rocksdb;
        this.config = config;
    }

    public <U extends Message, T extends Storeable<U>> T get(
        String storeableKey,
        Class<T> cls
    ) {
        String fullKey = Storeable.getFullStoreKey(cls, storeableKey);
        log.trace("Getting {} from rocksdb", fullKey);
        Bytes raw = rocksdb.get(fullKey);

        if (raw == null) return null;

        try {
            return LHSerializable.fromBytes(raw.get(), cls);
        } catch (LHSerdeError exn) {
            throw new IllegalStateException(
                "LHSerdeError indicates corrupted store.",
                exn
            );
        }
    }

    /*
     * Make sure to `.close()` the result!
     */
    public <T extends Storeable<?>> LHKeyValueIterator<T> prefixScan(
        String prefix,
        Class<T> cls
    ) {
        String compositePrefix = Storeable.getFullStoreKey(cls, prefix);
        return new LHKeyValueIterator<>(
            rocksdb.prefixScan(compositePrefix, Serdes.String().serializer()),
            cls,
            config
        );
    }

    @Deprecated
    public <T extends Storeable<?>> Stream<T> prefixTagScanStream(
        String prefix,
        Class<T> cls
    ) {
        LHKeyValueStream<T> keyValueStream = new LHKeyValueStream<>(
            rocksdb.prefixScan(
                Storeable.getSubstorePrefix(Tag.class),
                Serdes.String().serializer()
            ),
            cls,
            config
        );
        return keyValueStream.stream().map(stringTKeyValue -> stringTKeyValue.value);
    }

    /*
     * NOTE: the public API of this method should change such that the _user_ must
     * choose whether or not to pass in a "/", we shouldn't add the "/" ourselves.
     *
     * That _MUST_ be done before this PR gets merged.
     */
    @Evolving
    public <U extends Message, T extends Storeable<U>> T getLastFromPrefix(
        String prefix,
        Class<T> cls
    ) {
        LHKeyValueIterator<T> iterator = null;
        try {
            iterator = reversePrefixScan(prefix + "/", cls);
            if (iterator.hasNext()) {
                return iterator.next().getValue();
            } else {
                return null;
            }
        } finally {
            if (iterator != null) {
                iterator.close();
            }
        }
    }

    @Deprecated // this is swiss-cheese abstraction
    public Bytes getLastBytesFromFullPrefix(String fullPrefix) {
        KeyValueIterator<String, Bytes> rawIter = null;
        try {
            rawIter = rocksdb.reverseRange(fullPrefix, fullPrefix + "~");
            if (rawIter.hasNext()) {
                return rawIter.next().value;
            } else {
                return null;
            }
        } finally {
            if (rawIter != null) rawIter.close();
        }
    }

    public <T extends Storeable<?>> LHKeyValueIterator<T> reversePrefixScan(
        String prefix,
        Class<T> cls
    ) {
        String start = Storeable.getFullStoreKey(cls, prefix);
        // The Streams ReadOnlyKeyValueStore doesn't have a reverse prefix scan.
        // However, they do have a reverse range scan. So we take the prefix and
        // then we use the fact that we know the next character after the prefix is
        // one of [a-bA-B0-9\/], so we just need to append an Ascii character
        // greater than Z. We'll go with the '~', which is the greatest Ascii
        // character.
        String end = start + '~';
        return new LHKeyValueIterator<>(
            rocksdb.reverseRange(start, end),
            cls,
            config
        );
    }

    /**
     * Does a range scan over the provided object id's (note: these are NOT full
     * store keys.)
     * @param <T> type of object
     * @param start start object id
     * @param end end object id
     * @param cls type
     * @return an iter
     */
    public <T extends Storeable<?>> LHKeyValueIterator<T> range(
        String start,
        String end,
        Class<T> cls
    ) {
        return new LHKeyValueIterator<>(
            rocksdb.range(
                Storeable.getFullStoreKey(cls, start),
                Storeable.getFullStoreKey(cls, end)
            ),
            cls,
            config
        );
    }
}
/*
Want to standardize the paginated lookups. Lookup patterns:

* GET (type, object id)
  - returns an object or null

* Search (type, Tag)
  - returns a paginated range response

* Search (type, Prefix), eg. NodeRun by wfRunId
  - returns a non-paginated list of ID's

* Pop Task (taskDefName)
  - returns an id or null
  - requires coordination between requests


I think it makes sense to just write all the code and have an employee sort through
it later on.

 */
