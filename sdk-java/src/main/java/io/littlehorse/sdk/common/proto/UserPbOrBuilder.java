// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.sdk.common.proto;

public interface UserPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.UserPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>optional .littlehorse.UserGroupPb user_group = 2;</code>
   * @return Whether the userGroup field is set.
   */
  boolean hasUserGroup();
  /**
   * <code>optional .littlehorse.UserGroupPb user_group = 2;</code>
   * @return The userGroup.
   */
  io.littlehorse.sdk.common.proto.UserGroupPb getUserGroup();
  /**
   * <code>optional .littlehorse.UserGroupPb user_group = 2;</code>
   */
  io.littlehorse.sdk.common.proto.UserGroupPbOrBuilder getUserGroupOrBuilder();
}
