// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lh_proto.proto

package io.littlehorse.common.proto;

/**
 * Protobuf type {@code lh_proto.TaskResultOePb}
 */
public final class TaskResultOePb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:lh_proto.TaskResultOePb)
    TaskResultOePbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TaskResultOePb.newBuilder() to construct.
  private TaskResultOePb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TaskResultOePb() {
    logOutput_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TaskResultOePb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TaskResultOePb(
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
            io.littlehorse.common.proto.VariableValuePb.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) != 0)) {
              subBuilder = result_.toBuilder();
            }
            result_ = input.readMessage(io.littlehorse.common.proto.VariableValuePb.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(result_);
              result_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 18: {
            bitField0_ |= 0x00000002;
            logOutput_ = input.readBytes();
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
    return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_TaskResultOePb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_TaskResultOePb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.common.proto.TaskResultOePb.class, io.littlehorse.common.proto.TaskResultOePb.Builder.class);
  }

  private int bitField0_;
  public static final int RESULT_FIELD_NUMBER = 1;
  private io.littlehorse.common.proto.VariableValuePb result_;
  /**
   * <code>.lh_proto.VariableValuePb result = 1;</code>
   * @return Whether the result field is set.
   */
  @java.lang.Override
  public boolean hasResult() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.lh_proto.VariableValuePb result = 1;</code>
   * @return The result.
   */
  @java.lang.Override
  public io.littlehorse.common.proto.VariableValuePb getResult() {
    return result_ == null ? io.littlehorse.common.proto.VariableValuePb.getDefaultInstance() : result_;
  }
  /**
   * <code>.lh_proto.VariableValuePb result = 1;</code>
   */
  @java.lang.Override
  public io.littlehorse.common.proto.VariableValuePbOrBuilder getResultOrBuilder() {
    return result_ == null ? io.littlehorse.common.proto.VariableValuePb.getDefaultInstance() : result_;
  }

  public static final int LOG_OUTPUT_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString logOutput_;
  /**
   * <code>bytes log_output = 2;</code>
   * @return Whether the logOutput field is set.
   */
  @java.lang.Override
  public boolean hasLogOutput() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>bytes log_output = 2;</code>
   * @return The logOutput.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getLogOutput() {
    return logOutput_;
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
      output.writeMessage(1, getResult());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeBytes(2, logOutput_);
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
        .computeMessageSize(1, getResult());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, logOutput_);
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
    if (!(obj instanceof io.littlehorse.common.proto.TaskResultOePb)) {
      return super.equals(obj);
    }
    io.littlehorse.common.proto.TaskResultOePb other = (io.littlehorse.common.proto.TaskResultOePb) obj;

    if (hasResult() != other.hasResult()) return false;
    if (hasResult()) {
      if (!getResult()
          .equals(other.getResult())) return false;
    }
    if (hasLogOutput() != other.hasLogOutput()) return false;
    if (hasLogOutput()) {
      if (!getLogOutput()
          .equals(other.getLogOutput())) return false;
    }
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
    if (hasResult()) {
      hash = (37 * hash) + RESULT_FIELD_NUMBER;
      hash = (53 * hash) + getResult().hashCode();
    }
    if (hasLogOutput()) {
      hash = (37 * hash) + LOG_OUTPUT_FIELD_NUMBER;
      hash = (53 * hash) + getLogOutput().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.common.proto.TaskResultOePb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.TaskResultOePb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.TaskResultOePb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.TaskResultOePb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.TaskResultOePb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.TaskResultOePb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.TaskResultOePb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.TaskResultOePb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.TaskResultOePb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.TaskResultOePb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.TaskResultOePb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.TaskResultOePb parseFrom(
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
  public static Builder newBuilder(io.littlehorse.common.proto.TaskResultOePb prototype) {
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
   * Protobuf type {@code lh_proto.TaskResultOePb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:lh_proto.TaskResultOePb)
      io.littlehorse.common.proto.TaskResultOePbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_TaskResultOePb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_TaskResultOePb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.common.proto.TaskResultOePb.class, io.littlehorse.common.proto.TaskResultOePb.Builder.class);
    }

    // Construct using io.littlehorse.common.proto.TaskResultOePb.newBuilder()
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
        getResultFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (resultBuilder_ == null) {
        result_ = null;
      } else {
        resultBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      logOutput_ = com.google.protobuf.ByteString.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_TaskResultOePb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.TaskResultOePb getDefaultInstanceForType() {
      return io.littlehorse.common.proto.TaskResultOePb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.common.proto.TaskResultOePb build() {
      io.littlehorse.common.proto.TaskResultOePb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.TaskResultOePb buildPartial() {
      io.littlehorse.common.proto.TaskResultOePb result = new io.littlehorse.common.proto.TaskResultOePb(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        if (resultBuilder_ == null) {
          result.result_ = result_;
        } else {
          result.result_ = resultBuilder_.build();
        }
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        to_bitField0_ |= 0x00000002;
      }
      result.logOutput_ = logOutput_;
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
      if (other instanceof io.littlehorse.common.proto.TaskResultOePb) {
        return mergeFrom((io.littlehorse.common.proto.TaskResultOePb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.common.proto.TaskResultOePb other) {
      if (other == io.littlehorse.common.proto.TaskResultOePb.getDefaultInstance()) return this;
      if (other.hasResult()) {
        mergeResult(other.getResult());
      }
      if (other.hasLogOutput()) {
        setLogOutput(other.getLogOutput());
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
      io.littlehorse.common.proto.TaskResultOePb parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.littlehorse.common.proto.TaskResultOePb) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private io.littlehorse.common.proto.VariableValuePb result_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.littlehorse.common.proto.VariableValuePb, io.littlehorse.common.proto.VariableValuePb.Builder, io.littlehorse.common.proto.VariableValuePbOrBuilder> resultBuilder_;
    /**
     * <code>.lh_proto.VariableValuePb result = 1;</code>
     * @return Whether the result field is set.
     */
    public boolean hasResult() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.lh_proto.VariableValuePb result = 1;</code>
     * @return The result.
     */
    public io.littlehorse.common.proto.VariableValuePb getResult() {
      if (resultBuilder_ == null) {
        return result_ == null ? io.littlehorse.common.proto.VariableValuePb.getDefaultInstance() : result_;
      } else {
        return resultBuilder_.getMessage();
      }
    }
    /**
     * <code>.lh_proto.VariableValuePb result = 1;</code>
     */
    public Builder setResult(io.littlehorse.common.proto.VariableValuePb value) {
      if (resultBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        result_ = value;
        onChanged();
      } else {
        resultBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>.lh_proto.VariableValuePb result = 1;</code>
     */
    public Builder setResult(
        io.littlehorse.common.proto.VariableValuePb.Builder builderForValue) {
      if (resultBuilder_ == null) {
        result_ = builderForValue.build();
        onChanged();
      } else {
        resultBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>.lh_proto.VariableValuePb result = 1;</code>
     */
    public Builder mergeResult(io.littlehorse.common.proto.VariableValuePb value) {
      if (resultBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
            result_ != null &&
            result_ != io.littlehorse.common.proto.VariableValuePb.getDefaultInstance()) {
          result_ =
            io.littlehorse.common.proto.VariableValuePb.newBuilder(result_).mergeFrom(value).buildPartial();
        } else {
          result_ = value;
        }
        onChanged();
      } else {
        resultBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>.lh_proto.VariableValuePb result = 1;</code>
     */
    public Builder clearResult() {
      if (resultBuilder_ == null) {
        result_ = null;
        onChanged();
      } else {
        resultBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>.lh_proto.VariableValuePb result = 1;</code>
     */
    public io.littlehorse.common.proto.VariableValuePb.Builder getResultBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getResultFieldBuilder().getBuilder();
    }
    /**
     * <code>.lh_proto.VariableValuePb result = 1;</code>
     */
    public io.littlehorse.common.proto.VariableValuePbOrBuilder getResultOrBuilder() {
      if (resultBuilder_ != null) {
        return resultBuilder_.getMessageOrBuilder();
      } else {
        return result_ == null ?
            io.littlehorse.common.proto.VariableValuePb.getDefaultInstance() : result_;
      }
    }
    /**
     * <code>.lh_proto.VariableValuePb result = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.littlehorse.common.proto.VariableValuePb, io.littlehorse.common.proto.VariableValuePb.Builder, io.littlehorse.common.proto.VariableValuePbOrBuilder> 
        getResultFieldBuilder() {
      if (resultBuilder_ == null) {
        resultBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.littlehorse.common.proto.VariableValuePb, io.littlehorse.common.proto.VariableValuePb.Builder, io.littlehorse.common.proto.VariableValuePbOrBuilder>(
                getResult(),
                getParentForChildren(),
                isClean());
        result_ = null;
      }
      return resultBuilder_;
    }

    private com.google.protobuf.ByteString logOutput_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes log_output = 2;</code>
     * @return Whether the logOutput field is set.
     */
    @java.lang.Override
    public boolean hasLogOutput() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>bytes log_output = 2;</code>
     * @return The logOutput.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getLogOutput() {
      return logOutput_;
    }
    /**
     * <code>bytes log_output = 2;</code>
     * @param value The logOutput to set.
     * @return This builder for chaining.
     */
    public Builder setLogOutput(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      logOutput_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes log_output = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearLogOutput() {
      bitField0_ = (bitField0_ & ~0x00000002);
      logOutput_ = getDefaultInstance().getLogOutput();
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


    // @@protoc_insertion_point(builder_scope:lh_proto.TaskResultOePb)
  }

  // @@protoc_insertion_point(class_scope:lh_proto.TaskResultOePb)
  private static final io.littlehorse.common.proto.TaskResultOePb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.common.proto.TaskResultOePb();
  }

  public static io.littlehorse.common.proto.TaskResultOePb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TaskResultOePb>
      PARSER = new com.google.protobuf.AbstractParser<TaskResultOePb>() {
    @java.lang.Override
    public TaskResultOePb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TaskResultOePb(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TaskResultOePb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TaskResultOePb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.common.proto.TaskResultOePb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

