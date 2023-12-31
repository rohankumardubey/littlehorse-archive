// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.sdk.common.proto;

public interface TaskRunPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.TaskRunPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.littlehorse.TaskRunIdPb id = 1;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <code>.littlehorse.TaskRunIdPb id = 1;</code>
   * @return The id.
   */
  io.littlehorse.sdk.common.proto.TaskRunIdPb getId();
  /**
   * <code>.littlehorse.TaskRunIdPb id = 1;</code>
   */
  io.littlehorse.sdk.common.proto.TaskRunIdPbOrBuilder getIdOrBuilder();

  /**
   * <code>repeated .littlehorse.TaskAttemptPb attempts = 2;</code>
   */
  java.util.List<io.littlehorse.sdk.common.proto.TaskAttemptPb> 
      getAttemptsList();
  /**
   * <code>repeated .littlehorse.TaskAttemptPb attempts = 2;</code>
   */
  io.littlehorse.sdk.common.proto.TaskAttemptPb getAttempts(int index);
  /**
   * <code>repeated .littlehorse.TaskAttemptPb attempts = 2;</code>
   */
  int getAttemptsCount();
  /**
   * <code>repeated .littlehorse.TaskAttemptPb attempts = 2;</code>
   */
  java.util.List<? extends io.littlehorse.sdk.common.proto.TaskAttemptPbOrBuilder> 
      getAttemptsOrBuilderList();
  /**
   * <code>repeated .littlehorse.TaskAttemptPb attempts = 2;</code>
   */
  io.littlehorse.sdk.common.proto.TaskAttemptPbOrBuilder getAttemptsOrBuilder(
      int index);

  /**
   * <code>int32 max_attempts = 3;</code>
   * @return The maxAttempts.
   */
  int getMaxAttempts();

  /**
   * <code>string task_def_name = 4;</code>
   * @return The taskDefName.
   */
  java.lang.String getTaskDefName();
  /**
   * <code>string task_def_name = 4;</code>
   * @return The bytes for taskDefName.
   */
  com.google.protobuf.ByteString
      getTaskDefNameBytes();

  /**
   * <code>repeated .littlehorse.VarNameAndValPb input_variables = 5;</code>
   */
  java.util.List<io.littlehorse.sdk.common.proto.VarNameAndValPb> 
      getInputVariablesList();
  /**
   * <code>repeated .littlehorse.VarNameAndValPb input_variables = 5;</code>
   */
  io.littlehorse.sdk.common.proto.VarNameAndValPb getInputVariables(int index);
  /**
   * <code>repeated .littlehorse.VarNameAndValPb input_variables = 5;</code>
   */
  int getInputVariablesCount();
  /**
   * <code>repeated .littlehorse.VarNameAndValPb input_variables = 5;</code>
   */
  java.util.List<? extends io.littlehorse.sdk.common.proto.VarNameAndValPbOrBuilder> 
      getInputVariablesOrBuilderList();
  /**
   * <code>repeated .littlehorse.VarNameAndValPb input_variables = 5;</code>
   */
  io.littlehorse.sdk.common.proto.VarNameAndValPbOrBuilder getInputVariablesOrBuilder(
      int index);

  /**
   * <code>.littlehorse.TaskRunSourcePb source = 6;</code>
   * @return Whether the source field is set.
   */
  boolean hasSource();
  /**
   * <code>.littlehorse.TaskRunSourcePb source = 6;</code>
   * @return The source.
   */
  io.littlehorse.sdk.common.proto.TaskRunSourcePb getSource();
  /**
   * <code>.littlehorse.TaskRunSourcePb source = 6;</code>
   */
  io.littlehorse.sdk.common.proto.TaskRunSourcePbOrBuilder getSourceOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp scheduled_at = 7;</code>
   * @return Whether the scheduledAt field is set.
   */
  boolean hasScheduledAt();
  /**
   * <code>.google.protobuf.Timestamp scheduled_at = 7;</code>
   * @return The scheduledAt.
   */
  com.google.protobuf.Timestamp getScheduledAt();
  /**
   * <code>.google.protobuf.Timestamp scheduled_at = 7;</code>
   */
  com.google.protobuf.TimestampOrBuilder getScheduledAtOrBuilder();

  /**
   * <code>.littlehorse.TaskStatusPb status = 8;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.littlehorse.TaskStatusPb status = 8;</code>
   * @return The status.
   */
  io.littlehorse.sdk.common.proto.TaskStatusPb getStatus();

  /**
   * <code>int32 timeout_seconds = 9;</code>
   * @return The timeoutSeconds.
   */
  int getTimeoutSeconds();
}
