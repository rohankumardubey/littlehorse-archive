// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lh_proto.proto

package io.littlehorse.common.proto;

public interface VariableMutationPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.VariableMutationPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string lhs_name = 1;</code>
   * @return The lhsName.
   */
  java.lang.String getLhsName();
  /**
   * <code>string lhs_name = 1;</code>
   * @return The bytes for lhsName.
   */
  com.google.protobuf.ByteString
      getLhsNameBytes();

  /**
   * <code>string lhs_json_path = 2;</code>
   * @return Whether the lhsJsonPath field is set.
   */
  boolean hasLhsJsonPath();
  /**
   * <code>string lhs_json_path = 2;</code>
   * @return The lhsJsonPath.
   */
  java.lang.String getLhsJsonPath();
  /**
   * <code>string lhs_json_path = 2;</code>
   * @return The bytes for lhsJsonPath.
   */
  com.google.protobuf.ByteString
      getLhsJsonPathBytes();

  /**
   * <code>.lh_proto.VariableMutationTypePb operation = 3;</code>
   * @return The enum numeric value on the wire for operation.
   */
  int getOperationValue();
  /**
   * <code>.lh_proto.VariableMutationTypePb operation = 3;</code>
   * @return The operation.
   */
  io.littlehorse.common.proto.VariableMutationTypePb getOperation();

  /**
   * <code>.lh_proto.VariableAssignmentPb source_variable = 4;</code>
   * @return Whether the sourceVariable field is set.
   */
  boolean hasSourceVariable();
  /**
   * <code>.lh_proto.VariableAssignmentPb source_variable = 4;</code>
   * @return The sourceVariable.
   */
  io.littlehorse.common.proto.VariableAssignmentPb getSourceVariable();
  /**
   * <code>.lh_proto.VariableAssignmentPb source_variable = 4;</code>
   */
  io.littlehorse.common.proto.VariableAssignmentPbOrBuilder getSourceVariableOrBuilder();

  /**
   * <code>.lh_proto.VariableValuePb literal_value = 5;</code>
   * @return Whether the literalValue field is set.
   */
  boolean hasLiteralValue();
  /**
   * <code>.lh_proto.VariableValuePb literal_value = 5;</code>
   * @return The literalValue.
   */
  io.littlehorse.common.proto.VariableValuePb getLiteralValue();
  /**
   * <code>.lh_proto.VariableValuePb literal_value = 5;</code>
   */
  io.littlehorse.common.proto.VariableValuePbOrBuilder getLiteralValueOrBuilder();

  /**
   * <pre>
   * Dummy protobuf syntax hack
   * </pre>
   *
   * <code>bool node_output = 6;</code>
   * @return The nodeOutput.
   */
  boolean getNodeOutput();

  /**
   * <code>string rhs_json_path = 7;</code>
   * @return Whether the rhsJsonPath field is set.
   */
  boolean hasRhsJsonPath();
  /**
   * <code>string rhs_json_path = 7;</code>
   * @return The rhsJsonPath.
   */
  java.lang.String getRhsJsonPath();
  /**
   * <code>string rhs_json_path = 7;</code>
   * @return The bytes for rhsJsonPath.
   */
  com.google.protobuf.ByteString
      getRhsJsonPathBytes();

  public io.littlehorse.common.proto.VariableMutationPb.RhsValueCase getRhsValueCase();
}