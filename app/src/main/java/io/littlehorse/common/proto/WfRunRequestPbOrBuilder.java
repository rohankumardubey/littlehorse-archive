// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_server.proto

package io.littlehorse.common.proto;

public interface WfRunRequestPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.WfRunRequestPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string wf_run_id = 1;</code>
   * @return Whether the wfRunId field is set.
   */
  boolean hasWfRunId();
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
   * <code>string wf_spec_id = 2;</code>
   * @return The wfSpecId.
   */
  java.lang.String getWfSpecId();
  /**
   * <code>string wf_spec_id = 2;</code>
   * @return The bytes for wfSpecId.
   */
  com.google.protobuf.ByteString
      getWfSpecIdBytes();

  /**
   * <code>map&lt;string, .lh_proto.VariableValuePb&gt; variables = 3;</code>
   */
  int getVariablesCount();
  /**
   * <code>map&lt;string, .lh_proto.VariableValuePb&gt; variables = 3;</code>
   */
  boolean containsVariables(
      java.lang.String key);
  /**
   * Use {@link #getVariablesMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.VariableValuePb>
  getVariables();
  /**
   * <code>map&lt;string, .lh_proto.VariableValuePb&gt; variables = 3;</code>
   */
  java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.VariableValuePb>
  getVariablesMap();
  /**
   * <code>map&lt;string, .lh_proto.VariableValuePb&gt; variables = 3;</code>
   */

  io.littlehorse.jlib.common.proto.VariableValuePb getVariablesOrDefault(
      java.lang.String key,
      io.littlehorse.jlib.common.proto.VariableValuePb defaultValue);
  /**
   * <code>map&lt;string, .lh_proto.VariableValuePb&gt; variables = 3;</code>
   */

  io.littlehorse.jlib.common.proto.VariableValuePb getVariablesOrThrow(
      java.lang.String key);
}
