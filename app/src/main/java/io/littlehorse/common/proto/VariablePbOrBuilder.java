// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lh_proto.proto

package io.littlehorse.common.proto;

public interface VariablePbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.VariablePb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.lh_proto.VariableValuePb value = 1;</code>
   * @return Whether the value field is set.
   */
  boolean hasValue();
  /**
   * <code>.lh_proto.VariableValuePb value = 1;</code>
   * @return The value.
   */
  io.littlehorse.common.proto.VariableValuePb getValue();
  /**
   * <code>.lh_proto.VariableValuePb value = 1;</code>
   */
  io.littlehorse.common.proto.VariableValuePbOrBuilder getValueOrBuilder();

  /**
   * <code>string wf_run_id = 2;</code>
   * @return The wfRunId.
   */
  java.lang.String getWfRunId();
  /**
   * <code>string wf_run_id = 2;</code>
   * @return The bytes for wfRunId.
   */
  com.google.protobuf.ByteString
      getWfRunIdBytes();

  /**
   * <code>int32 thread_run_number = 3;</code>
   * @return The threadRunNumber.
   */
  int getThreadRunNumber();

  /**
   * <code>string name = 4;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 4;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>.google.protobuf.Timestamp date = 5;</code>
   * @return Whether the date field is set.
   */
  boolean hasDate();
  /**
   * <code>.google.protobuf.Timestamp date = 5;</code>
   * @return The date.
   */
  com.google.protobuf.Timestamp getDate();
  /**
   * <code>.google.protobuf.Timestamp date = 5;</code>
   */
  com.google.protobuf.TimestampOrBuilder getDateOrBuilder();
}