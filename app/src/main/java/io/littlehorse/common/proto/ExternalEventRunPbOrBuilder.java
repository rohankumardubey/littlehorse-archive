// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lh_proto.proto

package io.littlehorse.common.proto;

public interface ExternalEventRunPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.ExternalEventRunPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string external_event_def_id = 1;</code>
   * @return The externalEventDefId.
   */
  java.lang.String getExternalEventDefId();
  /**
   * <code>string external_event_def_id = 1;</code>
   * @return The bytes for externalEventDefId.
   */
  com.google.protobuf.ByteString
      getExternalEventDefIdBytes();

  /**
   * <code>.google.protobuf.Timestamp event_time = 2;</code>
   * @return Whether the eventTime field is set.
   */
  boolean hasEventTime();
  /**
   * <code>.google.protobuf.Timestamp event_time = 2;</code>
   * @return The eventTime.
   */
  com.google.protobuf.Timestamp getEventTime();
  /**
   * <code>.google.protobuf.Timestamp event_time = 2;</code>
   */
  com.google.protobuf.TimestampOrBuilder getEventTimeOrBuilder();
}
