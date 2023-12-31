// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.sdk.common.proto;

public interface UserTaskNodePbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.UserTaskNodePb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string user_task_def_name = 1;</code>
   * @return The userTaskDefName.
   */
  java.lang.String getUserTaskDefName();
  /**
   * <code>string user_task_def_name = 1;</code>
   * @return The bytes for userTaskDefName.
   */
  com.google.protobuf.ByteString
      getUserTaskDefNameBytes();

  /**
   * <code>.littlehorse.VariableAssignmentPb user_group = 2;</code>
   * @return Whether the userGroup field is set.
   */
  boolean hasUserGroup();
  /**
   * <code>.littlehorse.VariableAssignmentPb user_group = 2;</code>
   * @return The userGroup.
   */
  io.littlehorse.sdk.common.proto.VariableAssignmentPb getUserGroup();
  /**
   * <code>.littlehorse.VariableAssignmentPb user_group = 2;</code>
   */
  io.littlehorse.sdk.common.proto.VariableAssignmentPbOrBuilder getUserGroupOrBuilder();

  /**
   * <code>.littlehorse.VariableAssignmentPb user_id = 3;</code>
   * @return Whether the userId field is set.
   */
  boolean hasUserId();
  /**
   * <code>.littlehorse.VariableAssignmentPb user_id = 3;</code>
   * @return The userId.
   */
  io.littlehorse.sdk.common.proto.VariableAssignmentPb getUserId();
  /**
   * <code>.littlehorse.VariableAssignmentPb user_id = 3;</code>
   */
  io.littlehorse.sdk.common.proto.VariableAssignmentPbOrBuilder getUserIdOrBuilder();

  /**
   * <pre>
   * This is used to, for example, send a push notification to a mobile app
   * to remind someone that they need to fill out a task, or to re-assign
   * the task to another group of people
   * </pre>
   *
   * <code>repeated .littlehorse.UTActionTriggerPb actions = 4;</code>
   */
  java.util.List<io.littlehorse.sdk.common.proto.UTActionTriggerPb> 
      getActionsList();
  /**
   * <pre>
   * This is used to, for example, send a push notification to a mobile app
   * to remind someone that they need to fill out a task, or to re-assign
   * the task to another group of people
   * </pre>
   *
   * <code>repeated .littlehorse.UTActionTriggerPb actions = 4;</code>
   */
  io.littlehorse.sdk.common.proto.UTActionTriggerPb getActions(int index);
  /**
   * <pre>
   * This is used to, for example, send a push notification to a mobile app
   * to remind someone that they need to fill out a task, or to re-assign
   * the task to another group of people
   * </pre>
   *
   * <code>repeated .littlehorse.UTActionTriggerPb actions = 4;</code>
   */
  int getActionsCount();
  /**
   * <pre>
   * This is used to, for example, send a push notification to a mobile app
   * to remind someone that they need to fill out a task, or to re-assign
   * the task to another group of people
   * </pre>
   *
   * <code>repeated .littlehorse.UTActionTriggerPb actions = 4;</code>
   */
  java.util.List<? extends io.littlehorse.sdk.common.proto.UTActionTriggerPbOrBuilder> 
      getActionsOrBuilderList();
  /**
   * <pre>
   * This is used to, for example, send a push notification to a mobile app
   * to remind someone that they need to fill out a task, or to re-assign
   * the task to another group of people
   * </pre>
   *
   * <code>repeated .littlehorse.UTActionTriggerPb actions = 4;</code>
   */
  io.littlehorse.sdk.common.proto.UTActionTriggerPbOrBuilder getActionsOrBuilder(
      int index);

  /**
   * <pre>
   * So, once the WfSpec is created, this will be pinned to a version. Customer
   * can optionally specify a specific version or can leave it null, in which
   * case we just use the latest
   * </pre>
   *
   * <code>optional int32 user_task_def_version = 5;</code>
   * @return Whether the userTaskDefVersion field is set.
   */
  boolean hasUserTaskDefVersion();
  /**
   * <pre>
   * So, once the WfSpec is created, this will be pinned to a version. Customer
   * can optionally specify a specific version or can leave it null, in which
   * case we just use the latest
   * </pre>
   *
   * <code>optional int32 user_task_def_version = 5;</code>
   * @return The userTaskDefVersion.
   */
  int getUserTaskDefVersion();

  /**
   * <pre>
   * Allow WfRun-specific notes for this User Task.
   * </pre>
   *
   * <code>optional .littlehorse.VariableAssignmentPb notes = 6;</code>
   * @return Whether the notes field is set.
   */
  boolean hasNotes();
  /**
   * <pre>
   * Allow WfRun-specific notes for this User Task.
   * </pre>
   *
   * <code>optional .littlehorse.VariableAssignmentPb notes = 6;</code>
   * @return The notes.
   */
  io.littlehorse.sdk.common.proto.VariableAssignmentPb getNotes();
  /**
   * <pre>
   * Allow WfRun-specific notes for this User Task.
   * </pre>
   *
   * <code>optional .littlehorse.VariableAssignmentPb notes = 6;</code>
   */
  io.littlehorse.sdk.common.proto.VariableAssignmentPbOrBuilder getNotesOrBuilder();

  public io.littlehorse.sdk.common.proto.UserTaskNodePb.AssignmentCase getAssignmentCase();
}
