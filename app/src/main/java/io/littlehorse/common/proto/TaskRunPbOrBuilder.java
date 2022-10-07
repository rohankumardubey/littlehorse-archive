// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lh_proto.proto

package io.littlehorse.common.proto;

public interface TaskRunPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.TaskRunPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Task only
   * </pre>
   *
   * <code>int32 attempt_number = 1;</code>
   * @return The attemptNumber.
   */
  int getAttemptNumber();

  /**
   * <code>.lh_proto.VariableValuePb output = 2;</code>
   * @return Whether the output field is set.
   */
  boolean hasOutput();
  /**
   * <code>.lh_proto.VariableValuePb output = 2;</code>
   * @return The output.
   */
  io.littlehorse.common.proto.VariableValuePb getOutput();
  /**
   * <code>.lh_proto.VariableValuePb output = 2;</code>
   */
  io.littlehorse.common.proto.VariableValuePbOrBuilder getOutputOrBuilder();

  /**
   * <code>bytes log_output = 3;</code>
   * @return Whether the logOutput field is set.
   */
  boolean hasLogOutput();
  /**
   * <code>bytes log_output = 3;</code>
   * @return The logOutput.
   */
  com.google.protobuf.ByteString getLogOutput();

  /**
   * <code>.google.protobuf.Timestamp start_time = 4;</code>
   * @return Whether the startTime field is set.
   */
  boolean hasStartTime();
  /**
   * <code>.google.protobuf.Timestamp start_time = 4;</code>
   * @return The startTime.
   */
  com.google.protobuf.Timestamp getStartTime();
  /**
   * <code>.google.protobuf.Timestamp start_time = 4;</code>
   */
  com.google.protobuf.TimestampOrBuilder getStartTimeOrBuilder();

  /**
   * <code>string task_def_id = 5;</code>
   * @return The taskDefId.
   */
  java.lang.String getTaskDefId();
  /**
   * <code>string task_def_id = 5;</code>
   * @return The bytes for taskDefId.
   */
  com.google.protobuf.ByteString
      getTaskDefIdBytes();
}
