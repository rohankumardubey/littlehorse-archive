// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lh_proto.proto

package io.littlehorse.common.proto;

public interface ExternalEventDefPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.ExternalEventDefPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * TODO: In the future, maybe add schema? Maybe add correlations?
   * Unclear until we have some customer feedback.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   * @return Whether the createdAt field is set.
   */
  boolean hasCreatedAt();
  /**
   * <pre>
   * TODO: In the future, maybe add schema? Maybe add correlations?
   * Unclear until we have some customer feedback.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   * @return The createdAt.
   */
  com.google.protobuf.Timestamp getCreatedAt();
  /**
   * <pre>
   * TODO: In the future, maybe add schema? Maybe add correlations?
   * Unclear until we have some customer feedback.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   */
  com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder();
}
