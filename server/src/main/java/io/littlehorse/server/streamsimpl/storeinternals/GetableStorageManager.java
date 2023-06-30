package io.littlehorse.server.streamsimpl.storeinternals;

import io.littlehorse.common.LHConfig;
import io.littlehorse.common.model.Getable;
import io.littlehorse.common.model.wfrun.NodeRun;
import io.littlehorse.server.streamsimpl.coreprocessors.CommandProcessorOutput;
import io.littlehorse.server.streamsimpl.storeinternals.index.Tag;
import io.littlehorse.server.streamsimpl.storeinternals.index.TagUtils;
import io.littlehorse.server.streamsimpl.storeinternals.utils.StoreUtils;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.kafka.streams.processor.api.ProcessorContext;

public class GetableStorageManager {

    private LHStoreWrapper localStore;

    private TagStorageManager tagStorageManager;

    public GetableStorageManager(
        LHStoreWrapper localStore,
        LHConfig config,
        TagStorageManager tagStorageManager
    ) {
        this.localStore = localStore;
        this.tagStorageManager = tagStorageManager;
    }

    public GetableStorageManager(
        LHStoreWrapper localStore,
        LHConfig config,
        ProcessorContext<String, CommandProcessorOutput> context
    ) {
        this(localStore, config, new TagStorageManager(localStore, context, config));
    }

    public void store(Getable<?> geTable) {
        localStore.put(geTable);
        Collection<Tag> tags = getTagsFor(geTable);
        String tagsCacheKey = StoreUtils.getTagsCacheKey(geTable);
        tagStorageManager.store(tags, tagsCacheKey);
    }

    public Collection<Tag> getTagsFor(Getable<?> getAble) {
        if (getAble instanceof NodeRun) {
            return TagUtils.tagThing(getAble);
        }
        List<GetableIndex> getAbleIndices = GetableIndexRegistry
            .getInstance()
            .findIndexesFor(getAble.getClass());
        return getAbleIndices
            .stream()
            .filter(geTableIndex -> geTableIndex.isActive(getAble))
            .flatMap(getableIndex ->
                extractTagValues(getableIndex, getAble)
                    .stream()
                    .map(pairs ->
                        new Tag(getAble, getableIndex.getTagStorageTypePb(), pairs)
                    )
            )
            .collect(Collectors.toList());
    }

    private Collection<List<Pair<String, String>>> extractTagValues(
        GetableIndex getableIndex,
        Getable<?> geTable
    ) {
        return getableIndex
            .getKeys()
            .stream()
            .flatMap(key ->
                getableIndex
                    .getValue(geTable, key)
                    .stream()
                    .map(value -> Pair.of(key, value))
            )
            .collect(
                Collectors.groupingBy(pair ->
                    getableIndex
                        .getValue(geTable, pair.getLeft())
                        .indexOf(pair.getRight())
                )
            )
            .values();
    }
}