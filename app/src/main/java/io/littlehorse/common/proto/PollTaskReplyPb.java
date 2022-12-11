// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.common.proto;

/**
 * Protobuf type {@code lh_proto.PollTaskReplyPb}
 */
public final class PollTaskReplyPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:lh_proto.PollTaskReplyPb)
    PollTaskReplyPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PollTaskReplyPb.newBuilder() to construct.
  private PollTaskReplyPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PollTaskReplyPb() {
    code_ = 0;
    message_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PollTaskReplyPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PollTaskReplyPb(
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
          case 8: {
            int rawValue = input.readEnum();

            code_ = rawValue;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();
            bitField0_ |= 0x00000001;
            message_ = s;
            break;
          }
          case 26: {
            io.littlehorse.common.proto.TaskScheduleRequestPb.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) != 0)) {
              subBuilder = result_.toBuilder();
            }
            result_ = input.readMessage(io.littlehorse.common.proto.TaskScheduleRequestPb.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(result_);
              result_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
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
    return io.littlehorse.common.proto.Service.internal_static_lh_proto_PollTaskReplyPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.common.proto.Service.internal_static_lh_proto_PollTaskReplyPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.common.proto.PollTaskReplyPb.class, io.littlehorse.common.proto.PollTaskReplyPb.Builder.class);
  }

  private int bitField0_;
  public static final int CODE_FIELD_NUMBER = 1;
  private int code_;
  /**
   * <code>.lh_proto.LHResponseCodePb code = 1;</code>
   * @return The enum numeric value on the wire for code.
   */
  @java.lang.Override public int getCodeValue() {
    return code_;
  }
  /**
   * <code>.lh_proto.LHResponseCodePb code = 1;</code>
   * @return The code.
   */
  @java.lang.Override public io.littlehorse.common.proto.LHResponseCodePb getCode() {
    @SuppressWarnings("deprecation")
    io.littlehorse.common.proto.LHResponseCodePb result = io.littlehorse.common.proto.LHResponseCodePb.valueOf(code_);
    return result == null ? io.littlehorse.common.proto.LHResponseCodePb.UNRECOGNIZED : result;
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object message_;
  /**
   * <code>string message = 2;</code>
   * @return Whether the message field is set.
   */
  @java.lang.Override
  public boolean hasMessage() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  @java.lang.Override
  public java.lang.String getMessage() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMessageBytes() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int RESULT_FIELD_NUMBER = 3;
  private io.littlehorse.common.proto.TaskScheduleRequestPb result_;
  /**
   * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
   * @return Whether the result field is set.
   */
  @java.lang.Override
  public boolean hasResult() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
   * @return The result.
   */
  @java.lang.Override
  public io.littlehorse.common.proto.TaskScheduleRequestPb getResult() {
    return result_ == null ? io.littlehorse.common.proto.TaskScheduleRequestPb.getDefaultInstance() : result_;
  }
  /**
   * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
   */
  @java.lang.Override
  public io.littlehorse.common.proto.TaskScheduleRequestPbOrBuilder getResultOrBuilder() {
    return result_ == null ? io.littlehorse.common.proto.TaskScheduleRequestPb.getDefaultInstance() : result_;
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
    if (code_ != io.littlehorse.common.proto.LHResponseCodePb.OK.getNumber()) {
      output.writeEnum(1, code_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, message_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeMessage(3, getResult());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (code_ != io.littlehorse.common.proto.LHResponseCodePb.OK.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, code_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, message_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getResult());
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
    if (!(obj instanceof io.littlehorse.common.proto.PollTaskReplyPb)) {
      return super.equals(obj);
    }
    io.littlehorse.common.proto.PollTaskReplyPb other = (io.littlehorse.common.proto.PollTaskReplyPb) obj;

    if (code_ != other.code_) return false;
    if (hasMessage() != other.hasMessage()) return false;
    if (hasMessage()) {
      if (!getMessage()
          .equals(other.getMessage())) return false;
    }
    if (hasResult() != other.hasResult()) return false;
    if (hasResult()) {
      if (!getResult()
          .equals(other.getResult())) return false;
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
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + code_;
    if (hasMessage()) {
      hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getMessage().hashCode();
    }
    if (hasResult()) {
      hash = (37 * hash) + RESULT_FIELD_NUMBER;
      hash = (53 * hash) + getResult().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.common.proto.PollTaskReplyPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.PollTaskReplyPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.PollTaskReplyPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.PollTaskReplyPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.PollTaskReplyPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.PollTaskReplyPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.PollTaskReplyPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.PollTaskReplyPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.PollTaskReplyPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.PollTaskReplyPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.PollTaskReplyPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.PollTaskReplyPb parseFrom(
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
  public static Builder newBuilder(io.littlehorse.common.proto.PollTaskReplyPb prototype) {
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
   * Protobuf type {@code lh_proto.PollTaskReplyPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:lh_proto.PollTaskReplyPb)
      io.littlehorse.common.proto.PollTaskReplyPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.common.proto.Service.internal_static_lh_proto_PollTaskReplyPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.common.proto.Service.internal_static_lh_proto_PollTaskReplyPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.common.proto.PollTaskReplyPb.class, io.littlehorse.common.proto.PollTaskReplyPb.Builder.class);
    }

    // Construct using io.littlehorse.common.proto.PollTaskReplyPb.newBuilder()
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
      code_ = 0;

      message_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      if (resultBuilder_ == null) {
        result_ = null;
      } else {
        resultBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.common.proto.Service.internal_static_lh_proto_PollTaskReplyPb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.PollTaskReplyPb getDefaultInstanceForType() {
      return io.littlehorse.common.proto.PollTaskReplyPb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.common.proto.PollTaskReplyPb build() {
      io.littlehorse.common.proto.PollTaskReplyPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.PollTaskReplyPb buildPartial() {
      io.littlehorse.common.proto.PollTaskReplyPb result = new io.littlehorse.common.proto.PollTaskReplyPb(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.code_ = code_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        to_bitField0_ |= 0x00000001;
      }
      result.message_ = message_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        if (resultBuilder_ == null) {
          result.result_ = result_;
        } else {
          result.result_ = resultBuilder_.build();
        }
        to_bitField0_ |= 0x00000002;
      }
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
      if (other instanceof io.littlehorse.common.proto.PollTaskReplyPb) {
        return mergeFrom((io.littlehorse.common.proto.PollTaskReplyPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.common.proto.PollTaskReplyPb other) {
      if (other == io.littlehorse.common.proto.PollTaskReplyPb.getDefaultInstance()) return this;
      if (other.code_ != 0) {
        setCodeValue(other.getCodeValue());
      }
      if (other.hasMessage()) {
        bitField0_ |= 0x00000001;
        message_ = other.message_;
        onChanged();
      }
      if (other.hasResult()) {
        mergeResult(other.getResult());
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
      io.littlehorse.common.proto.PollTaskReplyPb parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.littlehorse.common.proto.PollTaskReplyPb) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int code_ = 0;
    /**
     * <code>.lh_proto.LHResponseCodePb code = 1;</code>
     * @return The enum numeric value on the wire for code.
     */
    @java.lang.Override public int getCodeValue() {
      return code_;
    }
    /**
     * <code>.lh_proto.LHResponseCodePb code = 1;</code>
     * @param value The enum numeric value on the wire for code to set.
     * @return This builder for chaining.
     */
    public Builder setCodeValue(int value) {
      
      code_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.lh_proto.LHResponseCodePb code = 1;</code>
     * @return The code.
     */
    @java.lang.Override
    public io.littlehorse.common.proto.LHResponseCodePb getCode() {
      @SuppressWarnings("deprecation")
      io.littlehorse.common.proto.LHResponseCodePb result = io.littlehorse.common.proto.LHResponseCodePb.valueOf(code_);
      return result == null ? io.littlehorse.common.proto.LHResponseCodePb.UNRECOGNIZED : result;
    }
    /**
     * <code>.lh_proto.LHResponseCodePb code = 1;</code>
     * @param value The code to set.
     * @return This builder for chaining.
     */
    public Builder setCode(io.littlehorse.common.proto.LHResponseCodePb value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      code_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.lh_proto.LHResponseCodePb code = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCode() {
      
      code_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object message_ = "";
    /**
     * <code>string message = 2;</code>
     * @return Whether the message field is set.
     */
    public boolean hasMessage() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>string message = 2;</code>
     * @return The message.
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string message = 2;</code>
     * @return The bytes for message.
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string message = 2;</code>
     * @param value The message to set.
     * @return This builder for chaining.
     */
    public Builder setMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      message_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string message = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessage() {
      bitField0_ = (bitField0_ & ~0x00000001);
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string message = 2;</code>
     * @param value The bytes for message to set.
     * @return This builder for chaining.
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      bitField0_ |= 0x00000001;
      message_ = value;
      onChanged();
      return this;
    }

    private io.littlehorse.common.proto.TaskScheduleRequestPb result_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.littlehorse.common.proto.TaskScheduleRequestPb, io.littlehorse.common.proto.TaskScheduleRequestPb.Builder, io.littlehorse.common.proto.TaskScheduleRequestPbOrBuilder> resultBuilder_;
    /**
     * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
     * @return Whether the result field is set.
     */
    public boolean hasResult() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
     * @return The result.
     */
    public io.littlehorse.common.proto.TaskScheduleRequestPb getResult() {
      if (resultBuilder_ == null) {
        return result_ == null ? io.littlehorse.common.proto.TaskScheduleRequestPb.getDefaultInstance() : result_;
      } else {
        return resultBuilder_.getMessage();
      }
    }
    /**
     * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
     */
    public Builder setResult(io.littlehorse.common.proto.TaskScheduleRequestPb value) {
      if (resultBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        result_ = value;
        onChanged();
      } else {
        resultBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
     */
    public Builder setResult(
        io.littlehorse.common.proto.TaskScheduleRequestPb.Builder builderForValue) {
      if (resultBuilder_ == null) {
        result_ = builderForValue.build();
        onChanged();
      } else {
        resultBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
     */
    public Builder mergeResult(io.littlehorse.common.proto.TaskScheduleRequestPb value) {
      if (resultBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
            result_ != null &&
            result_ != io.littlehorse.common.proto.TaskScheduleRequestPb.getDefaultInstance()) {
          result_ =
            io.littlehorse.common.proto.TaskScheduleRequestPb.newBuilder(result_).mergeFrom(value).buildPartial();
        } else {
          result_ = value;
        }
        onChanged();
      } else {
        resultBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
     */
    public Builder clearResult() {
      if (resultBuilder_ == null) {
        result_ = null;
        onChanged();
      } else {
        resultBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
     */
    public io.littlehorse.common.proto.TaskScheduleRequestPb.Builder getResultBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getResultFieldBuilder().getBuilder();
    }
    /**
     * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
     */
    public io.littlehorse.common.proto.TaskScheduleRequestPbOrBuilder getResultOrBuilder() {
      if (resultBuilder_ != null) {
        return resultBuilder_.getMessageOrBuilder();
      } else {
        return result_ == null ?
            io.littlehorse.common.proto.TaskScheduleRequestPb.getDefaultInstance() : result_;
      }
    }
    /**
     * <code>.lh_proto.TaskScheduleRequestPb result = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.littlehorse.common.proto.TaskScheduleRequestPb, io.littlehorse.common.proto.TaskScheduleRequestPb.Builder, io.littlehorse.common.proto.TaskScheduleRequestPbOrBuilder> 
        getResultFieldBuilder() {
      if (resultBuilder_ == null) {
        resultBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.littlehorse.common.proto.TaskScheduleRequestPb, io.littlehorse.common.proto.TaskScheduleRequestPb.Builder, io.littlehorse.common.proto.TaskScheduleRequestPbOrBuilder>(
                getResult(),
                getParentForChildren(),
                isClean());
        result_ = null;
      }
      return resultBuilder_;
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


    // @@protoc_insertion_point(builder_scope:lh_proto.PollTaskReplyPb)
  }

  // @@protoc_insertion_point(class_scope:lh_proto.PollTaskReplyPb)
  private static final io.littlehorse.common.proto.PollTaskReplyPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.common.proto.PollTaskReplyPb();
  }

  public static io.littlehorse.common.proto.PollTaskReplyPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PollTaskReplyPb>
      PARSER = new com.google.protobuf.AbstractParser<PollTaskReplyPb>() {
    @java.lang.Override
    public PollTaskReplyPb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PollTaskReplyPb(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PollTaskReplyPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PollTaskReplyPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.common.proto.PollTaskReplyPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

