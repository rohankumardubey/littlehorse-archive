// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: timer.proto

package io.littlehorse.common.proto;

public final class Timer {
  private Timer() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lh_proto_LHTimerPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lh_proto_LHTimerPb_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013timer.proto\022\010lh_proto\032\rcommand.proto\032\037" +
      "google/protobuf/timestamp.proto\"\227\001\n\tLHTi" +
      "merPb\0223\n\017maturation_time\030\001 \001(\0132\032.google." +
      "protobuf.Timestamp\022\013\n\003key\030\002 \001(\t\022\r\n\005topic" +
      "\030\003 \001(\t\022.\n\014wf_run_event\030\004 \001(\0132\026.lh_proto." +
      "WfRunEventPbH\000B\t\n\007payloadB(\n\033io.littleho" +
      "rse.common.protoP\001Z\007.;modelb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          io.littlehorse.common.proto.Command.getDescriptor(),
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_lh_proto_LHTimerPb_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_lh_proto_LHTimerPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lh_proto_LHTimerPb_descriptor,
        new java.lang.String[] { "MaturationTime", "Key", "Topic", "WfRunEvent", "Payload", });
    io.littlehorse.common.proto.Command.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}