// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_server.proto

package io.littlehorse.common.proto;

public interface ProcessCommandPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.ProcessCommandPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.lh_proto.CommandPb command = 1;</code>
   * @return Whether the command field is set.
   */
  boolean hasCommand();
  /**
   * <code>.lh_proto.CommandPb command = 1;</code>
   * @return The command.
   */
  io.littlehorse.common.proto.CommandPb getCommand();
  /**
   * <code>.lh_proto.CommandPb command = 1;</code>
   */
  io.littlehorse.common.proto.CommandPbOrBuilder getCommandOrBuilder();

  /**
   * <code>int32 specific_partition = 2;</code>
   * @return The specificPartition.
   */
  int getSpecificPartition();
}