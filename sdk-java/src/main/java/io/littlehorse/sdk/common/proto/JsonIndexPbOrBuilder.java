// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.sdk.common.proto;

public interface JsonIndexPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.JsonIndexPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string path = 1;</code>
   * @return The path.
   */
  java.lang.String getPath();
  /**
   * <code>string path = 1;</code>
   * @return The bytes for path.
   */
  com.google.protobuf.ByteString
      getPathBytes();

  /**
   * <code>.littlehorse.IndexTypePb index_type = 2;</code>
   * @return The enum numeric value on the wire for indexType.
   */
  int getIndexTypeValue();
  /**
   * <code>.littlehorse.IndexTypePb index_type = 2;</code>
   * @return The indexType.
   */
  io.littlehorse.sdk.common.proto.IndexTypePb getIndexType();
}
