// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.sdk.common.proto;

public interface NodeRunPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.NodeRunPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string wf_run_id = 1;</code>
   * @return The wfRunId.
   */
  java.lang.String getWfRunId();
  /**
   * <code>string wf_run_id = 1;</code>
   * @return The bytes for wfRunId.
   */
  com.google.protobuf.ByteString
      getWfRunIdBytes();

  /**
   * <code>int32 thread_run_number = 2;</code>
   * @return The threadRunNumber.
   */
  int getThreadRunNumber();

  /**
   * <code>int32 position = 3;</code>
   * @return The position.
   */
  int getPosition();

  /**
   * <code>.littlehorse.LHStatusPb status = 6;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.littlehorse.LHStatusPb status = 6;</code>
   * @return The status.
   */
  io.littlehorse.sdk.common.proto.LHStatusPb getStatus();

  /**
   * <code>.google.protobuf.Timestamp arrival_time = 7;</code>
   * @return Whether the arrivalTime field is set.
   */
  boolean hasArrivalTime();
  /**
   * <code>.google.protobuf.Timestamp arrival_time = 7;</code>
   * @return The arrivalTime.
   */
  com.google.protobuf.Timestamp getArrivalTime();
  /**
   * <code>.google.protobuf.Timestamp arrival_time = 7;</code>
   */
  com.google.protobuf.TimestampOrBuilder getArrivalTimeOrBuilder();

  /**
   * <code>optional .google.protobuf.Timestamp end_time = 8;</code>
   * @return Whether the endTime field is set.
   */
  boolean hasEndTime();
  /**
   * <code>optional .google.protobuf.Timestamp end_time = 8;</code>
   * @return The endTime.
   */
  com.google.protobuf.Timestamp getEndTime();
  /**
   * <code>optional .google.protobuf.Timestamp end_time = 8;</code>
   */
  com.google.protobuf.TimestampOrBuilder getEndTimeOrBuilder();

  /**
   * <code>.littlehorse.WfSpecIdPb wf_spec_id = 9;</code>
   * @return Whether the wfSpecId field is set.
   */
  boolean hasWfSpecId();
  /**
   * <code>.littlehorse.WfSpecIdPb wf_spec_id = 9;</code>
   * @return The wfSpecId.
   */
  io.littlehorse.sdk.common.proto.WfSpecIdPb getWfSpecId();
  /**
   * <code>.littlehorse.WfSpecIdPb wf_spec_id = 9;</code>
   */
  io.littlehorse.sdk.common.proto.WfSpecIdPbOrBuilder getWfSpecIdOrBuilder();

  /**
   * <code>string thread_spec_name = 10;</code>
   * @return The threadSpecName.
   */
  java.lang.String getThreadSpecName();
  /**
   * <code>string thread_spec_name = 10;</code>
   * @return The bytes for threadSpecName.
   */
  com.google.protobuf.ByteString
      getThreadSpecNameBytes();

  /**
   * <code>string node_name = 11;</code>
   * @return The nodeName.
   */
  java.lang.String getNodeName();
  /**
   * <code>string node_name = 11;</code>
   * @return The bytes for nodeName.
   */
  com.google.protobuf.ByteString
      getNodeNameBytes();

  /**
   * <code>optional string error_message = 13;</code>
   * @return Whether the errorMessage field is set.
   */
  boolean hasErrorMessage();
  /**
   * <code>optional string error_message = 13;</code>
   * @return The errorMessage.
   */
  java.lang.String getErrorMessage();
  /**
   * <code>optional string error_message = 13;</code>
   * @return The bytes for errorMessage.
   */
  com.google.protobuf.ByteString
      getErrorMessageBytes();

  /**
   * <code>repeated .littlehorse.FailurePb failures = 14;</code>
   */
  java.util.List<io.littlehorse.sdk.common.proto.FailurePb> 
      getFailuresList();
  /**
   * <code>repeated .littlehorse.FailurePb failures = 14;</code>
   */
  io.littlehorse.sdk.common.proto.FailurePb getFailures(int index);
  /**
   * <code>repeated .littlehorse.FailurePb failures = 14;</code>
   */
  int getFailuresCount();
  /**
   * <code>repeated .littlehorse.FailurePb failures = 14;</code>
   */
  java.util.List<? extends io.littlehorse.sdk.common.proto.FailurePbOrBuilder> 
      getFailuresOrBuilderList();
  /**
   * <code>repeated .littlehorse.FailurePb failures = 14;</code>
   */
  io.littlehorse.sdk.common.proto.FailurePbOrBuilder getFailuresOrBuilder(
      int index);

  /**
   * <code>.littlehorse.TaskNodeRunPb task = 15;</code>
   * @return Whether the task field is set.
   */
  boolean hasTask();
  /**
   * <code>.littlehorse.TaskNodeRunPb task = 15;</code>
   * @return The task.
   */
  io.littlehorse.sdk.common.proto.TaskNodeRunPb getTask();
  /**
   * <code>.littlehorse.TaskNodeRunPb task = 15;</code>
   */
  io.littlehorse.sdk.common.proto.TaskNodeRunPbOrBuilder getTaskOrBuilder();

  /**
   * <code>.littlehorse.ExternalEventRunPb external_event = 16;</code>
   * @return Whether the externalEvent field is set.
   */
  boolean hasExternalEvent();
  /**
   * <code>.littlehorse.ExternalEventRunPb external_event = 16;</code>
   * @return The externalEvent.
   */
  io.littlehorse.sdk.common.proto.ExternalEventRunPb getExternalEvent();
  /**
   * <code>.littlehorse.ExternalEventRunPb external_event = 16;</code>
   */
  io.littlehorse.sdk.common.proto.ExternalEventRunPbOrBuilder getExternalEventOrBuilder();

  /**
   * <code>.littlehorse.EntrypointRunPb entrypoint = 17;</code>
   * @return Whether the entrypoint field is set.
   */
  boolean hasEntrypoint();
  /**
   * <code>.littlehorse.EntrypointRunPb entrypoint = 17;</code>
   * @return The entrypoint.
   */
  io.littlehorse.sdk.common.proto.EntrypointRunPb getEntrypoint();
  /**
   * <code>.littlehorse.EntrypointRunPb entrypoint = 17;</code>
   */
  io.littlehorse.sdk.common.proto.EntrypointRunPbOrBuilder getEntrypointOrBuilder();

  /**
   * <code>.littlehorse.ExitRunPb exit = 19;</code>
   * @return Whether the exit field is set.
   */
  boolean hasExit();
  /**
   * <code>.littlehorse.ExitRunPb exit = 19;</code>
   * @return The exit.
   */
  io.littlehorse.sdk.common.proto.ExitRunPb getExit();
  /**
   * <code>.littlehorse.ExitRunPb exit = 19;</code>
   */
  io.littlehorse.sdk.common.proto.ExitRunPbOrBuilder getExitOrBuilder();

  /**
   * <code>.littlehorse.StartThreadRunPb start_thread = 20;</code>
   * @return Whether the startThread field is set.
   */
  boolean hasStartThread();
  /**
   * <code>.littlehorse.StartThreadRunPb start_thread = 20;</code>
   * @return The startThread.
   */
  io.littlehorse.sdk.common.proto.StartThreadRunPb getStartThread();
  /**
   * <code>.littlehorse.StartThreadRunPb start_thread = 20;</code>
   */
  io.littlehorse.sdk.common.proto.StartThreadRunPbOrBuilder getStartThreadOrBuilder();

  /**
   * <code>.littlehorse.WaitForThreadsRunPb wait_threads = 21;</code>
   * @return Whether the waitThreads field is set.
   */
  boolean hasWaitThreads();
  /**
   * <code>.littlehorse.WaitForThreadsRunPb wait_threads = 21;</code>
   * @return The waitThreads.
   */
  io.littlehorse.sdk.common.proto.WaitForThreadsRunPb getWaitThreads();
  /**
   * <code>.littlehorse.WaitForThreadsRunPb wait_threads = 21;</code>
   */
  io.littlehorse.sdk.common.proto.WaitForThreadsRunPbOrBuilder getWaitThreadsOrBuilder();

  /**
   * <code>.littlehorse.SleepNodeRunPb sleep = 22;</code>
   * @return Whether the sleep field is set.
   */
  boolean hasSleep();
  /**
   * <code>.littlehorse.SleepNodeRunPb sleep = 22;</code>
   * @return The sleep.
   */
  io.littlehorse.sdk.common.proto.SleepNodeRunPb getSleep();
  /**
   * <code>.littlehorse.SleepNodeRunPb sleep = 22;</code>
   */
  io.littlehorse.sdk.common.proto.SleepNodeRunPbOrBuilder getSleepOrBuilder();

  /**
   * <code>.littlehorse.UserTaskNodeRunPb user_task = 24;</code>
   * @return Whether the userTask field is set.
   */
  boolean hasUserTask();
  /**
   * <code>.littlehorse.UserTaskNodeRunPb user_task = 24;</code>
   * @return The userTask.
   */
  io.littlehorse.sdk.common.proto.UserTaskNodeRunPb getUserTask();
  /**
   * <code>.littlehorse.UserTaskNodeRunPb user_task = 24;</code>
   */
  io.littlehorse.sdk.common.proto.UserTaskNodeRunPbOrBuilder getUserTaskOrBuilder();

  /**
   * <code>repeated int32 failure_handler_ids = 23;</code>
   * @return A list containing the failureHandlerIds.
   */
  java.util.List<java.lang.Integer> getFailureHandlerIdsList();
  /**
   * <code>repeated int32 failure_handler_ids = 23;</code>
   * @return The count of failureHandlerIds.
   */
  int getFailureHandlerIdsCount();
  /**
   * <code>repeated int32 failure_handler_ids = 23;</code>
   * @param index The index of the element to return.
   * @return The failureHandlerIds at the given index.
   */
  int getFailureHandlerIds(int index);

  public io.littlehorse.sdk.common.proto.NodeRunPb.NodeTypeCase getNodeTypeCase();
}
