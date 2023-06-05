// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_server.proto

package io.littlehorse.common.proto;

public interface TaskStatePbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.TaskStatePb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string host = 1;</code>
   * @return The host.
   */
  java.lang.String getHost();
  /**
   * <code>string host = 1;</code>
   * @return The bytes for host.
   */
  com.google.protobuf.ByteString
      getHostBytes();

  /**
   * <code>string task_id = 2;</code>
   * @return The taskId.
   */
  java.lang.String getTaskId();
  /**
   * <code>string task_id = 2;</code>
   * @return The bytes for taskId.
   */
  com.google.protobuf.ByteString
      getTaskIdBytes();

  /**
   * <code>string topic = 3;</code>
   * @return The topic.
   */
  java.lang.String getTopic();
  /**
   * <code>string topic = 3;</code>
   * @return The bytes for topic.
   */
  com.google.protobuf.ByteString
      getTopicBytes();

  /**
   * <code>int32 partition = 4;</code>
   * @return The partition.
   */
  int getPartition();

  /**
   * <code>int64 current_offset = 5;</code>
   * @return The currentOffset.
   */
  long getCurrentOffset();

  /**
   * <code>int32 port = 6;</code>
   * @return The port.
   */
  int getPort();

  /**
   * <code>int64 lag = 7;</code>
   * @return The lag.
   */
  long getLag();

  /**
   * <code>string rack_id = 8;</code>
   * @return The rackId.
   */
  java.lang.String getRackId();
  /**
   * <code>string rack_id = 8;</code>
   * @return The bytes for rackId.
   */
  com.google.protobuf.ByteString
      getRackIdBytes();
}