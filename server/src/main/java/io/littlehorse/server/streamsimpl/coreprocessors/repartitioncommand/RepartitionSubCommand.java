package io.littlehorse.server.streamsimpl.coreprocessors.repartitioncommand;

import io.littlehorse.server.streamsimpl.storeinternals.RocksDBWrapper;
import org.apache.kafka.streams.processor.api.ProcessorContext;

public interface RepartitionSubCommand {
    public void process(
        RocksDBWrapper repartitionedStore,
        ProcessorContext<Void, Void> ctx
    );

    public String getPartitionKey();
}
