package io.littlehorse.server.streamsimpl.storeinternals;

import io.littlehorse.common.LHConfig;
import io.littlehorse.common.model.Getable;
import io.littlehorse.server.streamsimpl.coreprocessors.CommandProcessorOutput;
import io.littlehorse.server.streamsimpl.coreprocessors.repartitioncommand.RepartitionCommand;
import io.littlehorse.server.streamsimpl.coreprocessors.repartitioncommand.repartitionsubcommand.CreateRemoteTag;
import io.littlehorse.server.streamsimpl.coreprocessors.repartitioncommand.repartitionsubcommand.RemoveRemoteTag;
import io.littlehorse.server.streamsimpl.storeinternals.index.CachedTag;
import io.littlehorse.server.streamsimpl.storeinternals.index.Tag;
import io.littlehorse.server.streamsimpl.storeinternals.index.TagsCache;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;

@AllArgsConstructor
public class TagStorageManager {

    private RocksDBWrapper localStore;
    private ProcessorContext<String, CommandProcessorOutput> context;
    private LHConfig config;

    public void store(
        Collection<Tag> tags,
        TagsCache preExistingTags,
        Class<? extends Getable<?>> getableCls
    ) {
        List<String> existingTagIds = preExistingTags.getTagIds();
        List<CachedTag> cachedTags = tags
            .stream()
            .map(tag -> {
                CachedTag cachedTag = new CachedTag();
                cachedTag.setId(tag.getStoreKey());
                cachedTag.setRemote(tag.isRemote());
                return cachedTag;
            })
            .toList();
        this.storeLocalOrRemoteTag(tags, existingTagIds);
        this.removeOldTags(tags, preExistingTags.getTags());
        preExistingTags.setTags(cachedTags);
    }

    private void removeOldTags(Collection<Tag> newTags, List<CachedTag> cachedTags) {
        List<String> newTagIds = newTags.stream().map(Tag::getStoreKey).toList();
        List<CachedTag> tagsIdsToRemove = cachedTags
            .stream()
            .filter(cachedTag -> !newTagIds.contains(cachedTag.getId()))
            .toList();
        tagsIdsToRemove.forEach(this::removeTag);
    }

    public void removeTag(CachedTag cachedTag) {
        if (cachedTag.isRemote()) {
            String attributeString = extractAttributeStringFromStoreKey(
                cachedTag.getId()
            );
            sendRepartitionCommandForRemoveRemoteTag(
                cachedTag.getId(),
                attributeString
            );
        } else {
            localStore.deleteByStoreKey(cachedTag.getId(), Tag.class);
        }
    }

    private String extractAttributeStringFromStoreKey(String tagStoreKey) {
        String[] splittedStoreKey = tagStoreKey.split("/");
        return splittedStoreKey[0] + "/" + splittedStoreKey[1];
    }

    private void storeLocalOrRemoteTag(
        Collection<Tag> tags,
        List<String> cachedTagIds
    ) {
        tags
            .stream()
            .filter(tag -> !cachedTagIds.contains(tag.getStoreKey()))
            .forEach(tag -> {
                if (tag.isRemote()) {
                    this.sendRepartitionCommandForCreateRemoteTag(tag);
                } else {
                    localStore.put(tag);
                }
            });
    }

    private void sendRepartitionCommandForRemoveRemoteTag(
        String tagStoreKey,
        String tagAttributeString
    ) {
        RemoveRemoteTag command = new RemoveRemoteTag(
            tagStoreKey,
            tagAttributeString
        );
        CommandProcessorOutput cpo = new CommandProcessorOutput();
        cpo.partitionKey = tagAttributeString;
        cpo.topic = this.config.getRepartitionTopicName();
        cpo.payload = new RepartitionCommand(command, new Date(), tagStoreKey);
        Record<String, CommandProcessorOutput> out = new Record<>(
            tagAttributeString,
            cpo,
            System.currentTimeMillis()
        );
        this.context.forward(out);
    }

    private void sendRepartitionCommandForCreateRemoteTag(Tag tag) {
        CreateRemoteTag command = new CreateRemoteTag(tag);
        String partitionKey = tag.getPartitionKey();
        CommandProcessorOutput cpo = new CommandProcessorOutput();
        cpo.setPartitionKey(partitionKey);
        cpo.setTopic(this.config.getRepartitionTopicName());
        cpo.setPayload(new RepartitionCommand(command, new Date(), partitionKey));
        Record<String, CommandProcessorOutput> out = new Record<>(
            partitionKey,
            cpo,
            System.currentTimeMillis()
        );
        this.context.forward(out);
    }
}
/*

pre-existing: ["foo:bar", "baz:asdf"] // No way to get this without checking early

new tags: ["foo:bar", "baz:fdsa"] // calculated by getable.getIndexEntries()

actions:
1. remove tag "baz:asdf"
2. create tag "baz:fdsa"

Local index: just put/delete on local store
Remote index: need to send a command to repartition topic

 */
