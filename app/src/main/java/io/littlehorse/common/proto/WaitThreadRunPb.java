// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lh_proto.proto

package io.littlehorse.common.proto;

/**
 * Protobuf type {@code lh_proto.WaitThreadRunPb}
 */
public final class WaitThreadRunPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:lh_proto.WaitThreadRunPb)
    WaitThreadRunPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WaitThreadRunPb.newBuilder() to construct.
  private WaitThreadRunPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WaitThreadRunPb() {
    threadStatus_ = 0;
    threadResultCode_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new WaitThreadRunPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private WaitThreadRunPb(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.google.protobuf.Timestamp.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) != 0)) {
              subBuilder = threadEndTime_.toBuilder();
            }
            threadEndTime_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(threadEndTime_);
              threadEndTime_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 16: {
            int rawValue = input.readEnum();
            bitField0_ |= 0x00000002;
            threadStatus_ = rawValue;
            break;
          }
          case 24: {
            int rawValue = input.readEnum();
            bitField0_ |= 0x00000004;
            threadResultCode_ = rawValue;
            break;
          }
          case 32: {

            threadRunNumber_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_WaitThreadRunPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_WaitThreadRunPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.common.proto.WaitThreadRunPb.class, io.littlehorse.common.proto.WaitThreadRunPb.Builder.class);
  }

  private int bitField0_;
  public static final int THREAD_END_TIME_FIELD_NUMBER = 1;
  private com.google.protobuf.Timestamp threadEndTime_;
  /**
   * <code>.google.protobuf.Timestamp thread_end_time = 1;</code>
   * @return Whether the threadEndTime field is set.
   */
  @java.lang.Override
  public boolean hasThreadEndTime() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.google.protobuf.Timestamp thread_end_time = 1;</code>
   * @return The threadEndTime.
   */
  @java.lang.Override
  public com.google.protobuf.Timestamp getThreadEndTime() {
    return threadEndTime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : threadEndTime_;
  }
  /**
   * <code>.google.protobuf.Timestamp thread_end_time = 1;</code>
   */
  @java.lang.Override
  public com.google.protobuf.TimestampOrBuilder getThreadEndTimeOrBuilder() {
    return threadEndTime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : threadEndTime_;
  }

  public static final int THREAD_STATUS_FIELD_NUMBER = 2;
  private int threadStatus_;
  /**
   * <code>.lh_proto.LHStatusPb thread_status = 2;</code>
   * @return Whether the threadStatus field is set.
   */
  @java.lang.Override public boolean hasThreadStatus() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>.lh_proto.LHStatusPb thread_status = 2;</code>
   * @return The enum numeric value on the wire for threadStatus.
   */
  @java.lang.Override public int getThreadStatusValue() {
    return threadStatus_;
  }
  /**
   * <code>.lh_proto.LHStatusPb thread_status = 2;</code>
   * @return The threadStatus.
   */
  @java.lang.Override public io.littlehorse.common.proto.LHStatusPb getThreadStatus() {
    @SuppressWarnings("deprecation")
    io.littlehorse.common.proto.LHStatusPb result = io.littlehorse.common.proto.LHStatusPb.valueOf(threadStatus_);
    return result == null ? io.littlehorse.common.proto.LHStatusPb.UNRECOGNIZED : result;
  }

  public static final int THREAD_RESULT_CODE_FIELD_NUMBER = 3;
  private int threadResultCode_;
  /**
   * <code>.lh_proto.TaskResultCodePb thread_result_code = 3;</code>
   * @return Whether the threadResultCode field is set.
   */
  @java.lang.Override public boolean hasThreadResultCode() {
    return ((bitField0_ & 0x00000004) != 0);
  }
  /**
   * <code>.lh_proto.TaskResultCodePb thread_result_code = 3;</code>
   * @return The enum numeric value on the wire for threadResultCode.
   */
  @java.lang.Override public int getThreadResultCodeValue() {
    return threadResultCode_;
  }
  /**
   * <code>.lh_proto.TaskResultCodePb thread_result_code = 3;</code>
   * @return The threadResultCode.
   */
  @java.lang.Override public io.littlehorse.common.proto.TaskResultCodePb getThreadResultCode() {
    @SuppressWarnings("deprecation")
    io.littlehorse.common.proto.TaskResultCodePb result = io.littlehorse.common.proto.TaskResultCodePb.valueOf(threadResultCode_);
    return result == null ? io.littlehorse.common.proto.TaskResultCodePb.UNRECOGNIZED : result;
  }

  public static final int THREAD_RUN_NUMBER_FIELD_NUMBER = 4;
  private int threadRunNumber_;
  /**
   * <code>int32 thread_run_number = 4;</code>
   * @return The threadRunNumber.
   */
  @java.lang.Override
  public int getThreadRunNumber() {
    return threadRunNumber_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getThreadEndTime());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeEnum(2, threadStatus_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      output.writeEnum(3, threadResultCode_);
    }
    if (threadRunNumber_ != 0) {
      output.writeInt32(4, threadRunNumber_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getThreadEndTime());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, threadStatus_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, threadResultCode_);
    }
    if (threadRunNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, threadRunNumber_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.littlehorse.common.proto.WaitThreadRunPb)) {
      return super.equals(obj);
    }
    io.littlehorse.common.proto.WaitThreadRunPb other = (io.littlehorse.common.proto.WaitThreadRunPb) obj;

    if (hasThreadEndTime() != other.hasThreadEndTime()) return false;
    if (hasThreadEndTime()) {
      if (!getThreadEndTime()
          .equals(other.getThreadEndTime())) return false;
    }
    if (hasThreadStatus() != other.hasThreadStatus()) return false;
    if (hasThreadStatus()) {
      if (threadStatus_ != other.threadStatus_) return false;
    }
    if (hasThreadResultCode() != other.hasThreadResultCode()) return false;
    if (hasThreadResultCode()) {
      if (threadResultCode_ != other.threadResultCode_) return false;
    }
    if (getThreadRunNumber()
        != other.getThreadRunNumber()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasThreadEndTime()) {
      hash = (37 * hash) + THREAD_END_TIME_FIELD_NUMBER;
      hash = (53 * hash) + getThreadEndTime().hashCode();
    }
    if (hasThreadStatus()) {
      hash = (37 * hash) + THREAD_STATUS_FIELD_NUMBER;
      hash = (53 * hash) + threadStatus_;
    }
    if (hasThreadResultCode()) {
      hash = (37 * hash) + THREAD_RESULT_CODE_FIELD_NUMBER;
      hash = (53 * hash) + threadResultCode_;
    }
    hash = (37 * hash) + THREAD_RUN_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getThreadRunNumber();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.common.proto.WaitThreadRunPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.WaitThreadRunPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.WaitThreadRunPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.WaitThreadRunPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.WaitThreadRunPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.WaitThreadRunPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.WaitThreadRunPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.WaitThreadRunPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.WaitThreadRunPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.WaitThreadRunPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.WaitThreadRunPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.WaitThreadRunPb parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.littlehorse.common.proto.WaitThreadRunPb prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code lh_proto.WaitThreadRunPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:lh_proto.WaitThreadRunPb)
      io.littlehorse.common.proto.WaitThreadRunPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_WaitThreadRunPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_WaitThreadRunPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.common.proto.WaitThreadRunPb.class, io.littlehorse.common.proto.WaitThreadRunPb.Builder.class);
    }

    // Construct using io.littlehorse.common.proto.WaitThreadRunPb.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getThreadEndTimeFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (threadEndTimeBuilder_ == null) {
        threadEndTime_ = null;
      } else {
        threadEndTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      threadStatus_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      threadResultCode_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      threadRunNumber_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_WaitThreadRunPb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.WaitThreadRunPb getDefaultInstanceForType() {
      return io.littlehorse.common.proto.WaitThreadRunPb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.common.proto.WaitThreadRunPb build() {
      io.littlehorse.common.proto.WaitThreadRunPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.WaitThreadRunPb buildPartial() {
      io.littlehorse.common.proto.WaitThreadRunPb result = new io.littlehorse.common.proto.WaitThreadRunPb(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        if (threadEndTimeBuilder_ == null) {
          result.threadEndTime_ = threadEndTime_;
        } else {
          result.threadEndTime_ = threadEndTimeBuilder_.build();
        }
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        to_bitField0_ |= 0x00000002;
      }
      result.threadStatus_ = threadStatus_;
      if (((from_bitField0_ & 0x00000004) != 0)) {
        to_bitField0_ |= 0x00000004;
      }
      result.threadResultCode_ = threadResultCode_;
      result.threadRunNumber_ = threadRunNumber_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.littlehorse.common.proto.WaitThreadRunPb) {
        return mergeFrom((io.littlehorse.common.proto.WaitThreadRunPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.common.proto.WaitThreadRunPb other) {
      if (other == io.littlehorse.common.proto.WaitThreadRunPb.getDefaultInstance()) return this;
      if (other.hasThreadEndTime()) {
        mergeThreadEndTime(other.getThreadEndTime());
      }
      if (other.hasThreadStatus()) {
        setThreadStatus(other.getThreadStatus());
      }
      if (other.hasThreadResultCode()) {
        setThreadResultCode(other.getThreadResultCode());
      }
      if (other.getThreadRunNumber() != 0) {
        setThreadRunNumber(other.getThreadRunNumber());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.littlehorse.common.proto.WaitThreadRunPb parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.littlehorse.common.proto.WaitThreadRunPb) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.Timestamp threadEndTime_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> threadEndTimeBuilder_;
    /**
     * <code>.google.protobuf.Timestamp thread_end_time = 1;</code>
     * @return Whether the threadEndTime field is set.
     */
    public boolean hasThreadEndTime() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.google.protobuf.Timestamp thread_end_time = 1;</code>
     * @return The threadEndTime.
     */
    public com.google.protobuf.Timestamp getThreadEndTime() {
      if (threadEndTimeBuilder_ == null) {
        return threadEndTime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : threadEndTime_;
      } else {
        return threadEndTimeBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp thread_end_time = 1;</code>
     */
    public Builder setThreadEndTime(com.google.protobuf.Timestamp value) {
      if (threadEndTimeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        threadEndTime_ = value;
        onChanged();
      } else {
        threadEndTimeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp thread_end_time = 1;</code>
     */
    public Builder setThreadEndTime(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (threadEndTimeBuilder_ == null) {
        threadEndTime_ = builderForValue.build();
        onChanged();
      } else {
        threadEndTimeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp thread_end_time = 1;</code>
     */
    public Builder mergeThreadEndTime(com.google.protobuf.Timestamp value) {
      if (threadEndTimeBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
            threadEndTime_ != null &&
            threadEndTime_ != com.google.protobuf.Timestamp.getDefaultInstance()) {
          threadEndTime_ =
            com.google.protobuf.Timestamp.newBuilder(threadEndTime_).mergeFrom(value).buildPartial();
        } else {
          threadEndTime_ = value;
        }
        onChanged();
      } else {
        threadEndTimeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp thread_end_time = 1;</code>
     */
    public Builder clearThreadEndTime() {
      if (threadEndTimeBuilder_ == null) {
        threadEndTime_ = null;
        onChanged();
      } else {
        threadEndTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp thread_end_time = 1;</code>
     */
    public com.google.protobuf.Timestamp.Builder getThreadEndTimeBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getThreadEndTimeFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp thread_end_time = 1;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getThreadEndTimeOrBuilder() {
      if (threadEndTimeBuilder_ != null) {
        return threadEndTimeBuilder_.getMessageOrBuilder();
      } else {
        return threadEndTime_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : threadEndTime_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp thread_end_time = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getThreadEndTimeFieldBuilder() {
      if (threadEndTimeBuilder_ == null) {
        threadEndTimeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getThreadEndTime(),
                getParentForChildren(),
                isClean());
        threadEndTime_ = null;
      }
      return threadEndTimeBuilder_;
    }

    private int threadStatus_ = 0;
    /**
     * <code>.lh_proto.LHStatusPb thread_status = 2;</code>
     * @return Whether the threadStatus field is set.
     */
    @java.lang.Override public boolean hasThreadStatus() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.lh_proto.LHStatusPb thread_status = 2;</code>
     * @return The enum numeric value on the wire for threadStatus.
     */
    @java.lang.Override public int getThreadStatusValue() {
      return threadStatus_;
    }
    /**
     * <code>.lh_proto.LHStatusPb thread_status = 2;</code>
     * @param value The enum numeric value on the wire for threadStatus to set.
     * @return This builder for chaining.
     */
    public Builder setThreadStatusValue(int value) {
      bitField0_ |= 0x00000002;
      threadStatus_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.lh_proto.LHStatusPb thread_status = 2;</code>
     * @return The threadStatus.
     */
    @java.lang.Override
    public io.littlehorse.common.proto.LHStatusPb getThreadStatus() {
      @SuppressWarnings("deprecation")
      io.littlehorse.common.proto.LHStatusPb result = io.littlehorse.common.proto.LHStatusPb.valueOf(threadStatus_);
      return result == null ? io.littlehorse.common.proto.LHStatusPb.UNRECOGNIZED : result;
    }
    /**
     * <code>.lh_proto.LHStatusPb thread_status = 2;</code>
     * @param value The threadStatus to set.
     * @return This builder for chaining.
     */
    public Builder setThreadStatus(io.littlehorse.common.proto.LHStatusPb value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      threadStatus_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.lh_proto.LHStatusPb thread_status = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearThreadStatus() {
      bitField0_ = (bitField0_ & ~0x00000002);
      threadStatus_ = 0;
      onChanged();
      return this;
    }

    private int threadResultCode_ = 0;
    /**
     * <code>.lh_proto.TaskResultCodePb thread_result_code = 3;</code>
     * @return Whether the threadResultCode field is set.
     */
    @java.lang.Override public boolean hasThreadResultCode() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>.lh_proto.TaskResultCodePb thread_result_code = 3;</code>
     * @return The enum numeric value on the wire for threadResultCode.
     */
    @java.lang.Override public int getThreadResultCodeValue() {
      return threadResultCode_;
    }
    /**
     * <code>.lh_proto.TaskResultCodePb thread_result_code = 3;</code>
     * @param value The enum numeric value on the wire for threadResultCode to set.
     * @return This builder for chaining.
     */
    public Builder setThreadResultCodeValue(int value) {
      bitField0_ |= 0x00000004;
      threadResultCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.lh_proto.TaskResultCodePb thread_result_code = 3;</code>
     * @return The threadResultCode.
     */
    @java.lang.Override
    public io.littlehorse.common.proto.TaskResultCodePb getThreadResultCode() {
      @SuppressWarnings("deprecation")
      io.littlehorse.common.proto.TaskResultCodePb result = io.littlehorse.common.proto.TaskResultCodePb.valueOf(threadResultCode_);
      return result == null ? io.littlehorse.common.proto.TaskResultCodePb.UNRECOGNIZED : result;
    }
    /**
     * <code>.lh_proto.TaskResultCodePb thread_result_code = 3;</code>
     * @param value The threadResultCode to set.
     * @return This builder for chaining.
     */
    public Builder setThreadResultCode(io.littlehorse.common.proto.TaskResultCodePb value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000004;
      threadResultCode_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.lh_proto.TaskResultCodePb thread_result_code = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearThreadResultCode() {
      bitField0_ = (bitField0_ & ~0x00000004);
      threadResultCode_ = 0;
      onChanged();
      return this;
    }

    private int threadRunNumber_ ;
    /**
     * <code>int32 thread_run_number = 4;</code>
     * @return The threadRunNumber.
     */
    @java.lang.Override
    public int getThreadRunNumber() {
      return threadRunNumber_;
    }
    /**
     * <code>int32 thread_run_number = 4;</code>
     * @param value The threadRunNumber to set.
     * @return This builder for chaining.
     */
    public Builder setThreadRunNumber(int value) {
      
      threadRunNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 thread_run_number = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearThreadRunNumber() {
      
      threadRunNumber_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:lh_proto.WaitThreadRunPb)
  }

  // @@protoc_insertion_point(class_scope:lh_proto.WaitThreadRunPb)
  private static final io.littlehorse.common.proto.WaitThreadRunPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.common.proto.WaitThreadRunPb();
  }

  public static io.littlehorse.common.proto.WaitThreadRunPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WaitThreadRunPb>
      PARSER = new com.google.protobuf.AbstractParser<WaitThreadRunPb>() {
    @java.lang.Override
    public WaitThreadRunPb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new WaitThreadRunPb(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WaitThreadRunPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WaitThreadRunPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.common.proto.WaitThreadRunPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
