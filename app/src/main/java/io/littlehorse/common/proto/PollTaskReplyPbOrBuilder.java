// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.common.proto;

public interface PollTaskReplyPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.PollTaskReplyPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.lh_proto.LHResponseCodePb code = 1;</code>
   * @return The enum numeric value on the wire for code.
   */
  int getCodeValue();
  /**
   * <code>.lh_proto.LHResponseCodePb code = 1;</code>
   * @return The code.
   */
  io.littlehorse.common.proto.LHResponseCodePb getCode();

  /**
   * <code>string message = 2;</code>
   * @return Whether the message field is set.
   */
  boolean hasMessage();
  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
   * @return Whether the result field is set.
   */
  boolean hasResult();
  /**
   * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
   * @return The result.
   */
  io.littlehorse.common.proto.TaskScheduleRequestPb getResult();
  /**
   * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
   */
  io.littlehorse.common.proto.TaskScheduleRequestPbOrBuilder getResultOrBuilder();
}
