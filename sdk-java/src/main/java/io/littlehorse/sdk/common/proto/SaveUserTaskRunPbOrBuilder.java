// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.sdk.common.proto;

public interface SaveUserTaskRunPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.SaveUserTaskRunPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.littlehorse.UserTaskResultPb result = 1;</code>
   * @return Whether the result field is set.
   */
  boolean hasResult();
  /**
   * <code>.littlehorse.UserTaskResultPb result = 1;</code>
   * @return The result.
   */
  io.littlehorse.sdk.common.proto.UserTaskResultPb getResult();
  /**
   * <code>.littlehorse.UserTaskResultPb result = 1;</code>
   */
  io.littlehorse.sdk.common.proto.UserTaskResultPbOrBuilder getResultOrBuilder();

  /**
   * <code>string user_id = 2;</code>
   * @return The userId.
   */
  java.lang.String getUserId();
  /**
   * <code>string user_id = 2;</code>
   * @return The bytes for userId.
   */
  com.google.protobuf.ByteString
      getUserIdBytes();

  /**
   * <code>repeated .littlehorse.UserTaskFieldResultPb results = 3;</code>
   */
  java.util.List<io.littlehorse.sdk.common.proto.UserTaskFieldResultPb> 
      getResultsList();
  /**
   * <code>repeated .littlehorse.UserTaskFieldResultPb results = 3;</code>
   */
  io.littlehorse.sdk.common.proto.UserTaskFieldResultPb getResults(int index);
  /**
   * <code>repeated .littlehorse.UserTaskFieldResultPb results = 3;</code>
   */
  int getResultsCount();
  /**
   * <code>repeated .littlehorse.UserTaskFieldResultPb results = 3;</code>
   */
  java.util.List<? extends io.littlehorse.sdk.common.proto.UserTaskFieldResultPbOrBuilder> 
      getResultsOrBuilderList();
  /**
   * <code>repeated .littlehorse.UserTaskFieldResultPb results = 3;</code>
   */
  io.littlehorse.sdk.common.proto.UserTaskFieldResultPbOrBuilder getResultsOrBuilder(
      int index);
}
