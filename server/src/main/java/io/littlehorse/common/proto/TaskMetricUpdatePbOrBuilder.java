// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_server.proto

package io.littlehorse.common.proto;

public interface TaskMetricUpdatePbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.TaskMetricUpdatePb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.google.protobuf.Timestamp window_start = 1;</code>
   * @return Whether the windowStart field is set.
   */
  boolean hasWindowStart();
  /**
   * <code>.google.protobuf.Timestamp window_start = 1;</code>
   * @return The windowStart.
   */
  com.google.protobuf.Timestamp getWindowStart();
  /**
   * <code>.google.protobuf.Timestamp window_start = 1;</code>
   */
  com.google.protobuf.TimestampOrBuilder getWindowStartOrBuilder();

  /**
   * <code>.littlehorse.MetricsWindowLengthPb type = 2;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.littlehorse.MetricsWindowLengthPb type = 2;</code>
   * @return The type.
   */
  io.littlehorse.sdk.common.proto.MetricsWindowLengthPb getType();

  /**
   * <code>int64 num_entries = 3;</code>
   * @return The numEntries.
   */
  long getNumEntries();

  /**
   * <code>int64 schedule_to_start_max = 4;</code>
   * @return The scheduleToStartMax.
   */
  long getScheduleToStartMax();

  /**
   * <code>int64 schedule_to_start_total = 5;</code>
   * @return The scheduleToStartTotal.
   */
  long getScheduleToStartTotal();

  /**
   * <code>int64 start_to_complete_max = 6;</code>
   * @return The startToCompleteMax.
   */
  long getStartToCompleteMax();

  /**
   * <code>int64 start_to_complete_total = 7;</code>
   * @return The startToCompleteTotal.
   */
  long getStartToCompleteTotal();

  /**
   * <code>int64 total_completed = 8;</code>
   * @return The totalCompleted.
   */
  long getTotalCompleted();

  /**
   * <code>int64 total_errored = 9;</code>
   * @return The totalErrored.
   */
  long getTotalErrored();

  /**
   * <code>int64 total_started = 10;</code>
   * @return The totalStarted.
   */
  long getTotalStarted();

  /**
   * <code>string task_def_name = 11;</code>
   * @return The taskDefName.
   */
  java.lang.String getTaskDefName();
  /**
   * <code>string task_def_name = 11;</code>
   * @return The bytes for taskDefName.
   */
  com.google.protobuf.ByteString
      getTaskDefNameBytes();

  /**
   * <code>int64 total_scheduled = 12;</code>
   * @return The totalScheduled.
   */
  long getTotalScheduled();
}
