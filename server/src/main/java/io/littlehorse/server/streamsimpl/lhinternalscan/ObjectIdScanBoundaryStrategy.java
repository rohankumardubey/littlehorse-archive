package io.littlehorse.server.streamsimpl.lhinternalscan;

import com.google.protobuf.Message;
import io.littlehorse.common.proto.InternalScanPb;

public class ObjectIdScanBoundaryStrategy implements SearchScanBoundaryStrategy {

    private String startKey;
    private String endKey;

    private String objectId;

    public ObjectIdScanBoundaryStrategy(String objectId) {
        this(objectId, objectId + "/", objectId + "/~");
    }

    public ObjectIdScanBoundaryStrategy(
        String objectId,
        String startKey,
        String endKey
    ) {
        this.startKey = startKey;
        this.endKey = endKey;
        this.objectId = objectId;
    }

    @Override
    public Message buildScanProto() {
        return InternalScanPb.BoundedObjectIdScanPb
            .newBuilder()
            .setStartObjectId(startKey)
            .setEndObjectId(endKey)
            .build();
    }

    @Override
    public String getSearchAttributeString() {
        return objectId;
    }
}
