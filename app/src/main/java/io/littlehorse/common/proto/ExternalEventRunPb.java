// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lh_proto.proto

package io.littlehorse.common.proto;

/**
 * Protobuf type {@code lh_proto.ExternalEventRunPb}
 */
public final class ExternalEventRunPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:lh_proto.ExternalEventRunPb)
    ExternalEventRunPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ExternalEventRunPb.newBuilder() to construct.
  private ExternalEventRunPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExternalEventRunPb() {
    externalEventDefId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ExternalEventRunPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ExternalEventRunPb(
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
            java.lang.String s = input.readStringRequireUtf8();

            externalEventDefId_ = s;
            break;
          }
          case 18: {
            com.google.protobuf.Timestamp.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) != 0)) {
              subBuilder = eventTime_.toBuilder();
            }
            eventTime_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(eventTime_);
              eventTime_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
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
    return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_ExternalEventRunPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_ExternalEventRunPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.common.proto.ExternalEventRunPb.class, io.littlehorse.common.proto.ExternalEventRunPb.Builder.class);
  }

  private int bitField0_;
  public static final int EXTERNAL_EVENT_DEF_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object externalEventDefId_;
  /**
   * <code>string external_event_def_id = 1;</code>
   * @return The externalEventDefId.
   */
  @java.lang.Override
  public java.lang.String getExternalEventDefId() {
    java.lang.Object ref = externalEventDefId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      externalEventDefId_ = s;
      return s;
    }
  }
  /**
   * <code>string external_event_def_id = 1;</code>
   * @return The bytes for externalEventDefId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getExternalEventDefIdBytes() {
    java.lang.Object ref = externalEventDefId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      externalEventDefId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int EVENT_TIME_FIELD_NUMBER = 2;
  private com.google.protobuf.Timestamp eventTime_;
  /**
   * <code>.google.protobuf.Timestamp event_time = 2;</code>
   * @return Whether the eventTime field is set.
   */
  @java.lang.Override
  public boolean hasEventTime() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.google.protobuf.Timestamp event_time = 2;</code>
   * @return The eventTime.
   */
  @java.lang.Override
  public com.google.protobuf.Timestamp getEventTime() {
    return eventTime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : eventTime_;
  }
  /**
   * <code>.google.protobuf.Timestamp event_time = 2;</code>
   */
  @java.lang.Override
  public com.google.protobuf.TimestampOrBuilder getEventTimeOrBuilder() {
    return eventTime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : eventTime_;
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
    if (!getExternalEventDefIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, externalEventDefId_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(2, getEventTime());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getExternalEventDefIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, externalEventDefId_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getEventTime());
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
    if (!(obj instanceof io.littlehorse.common.proto.ExternalEventRunPb)) {
      return super.equals(obj);
    }
    io.littlehorse.common.proto.ExternalEventRunPb other = (io.littlehorse.common.proto.ExternalEventRunPb) obj;

    if (!getExternalEventDefId()
        .equals(other.getExternalEventDefId())) return false;
    if (hasEventTime() != other.hasEventTime()) return false;
    if (hasEventTime()) {
      if (!getEventTime()
          .equals(other.getEventTime())) return false;
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
    hash = (37 * hash) + EXTERNAL_EVENT_DEF_ID_FIELD_NUMBER;
    hash = (53 * hash) + getExternalEventDefId().hashCode();
    if (hasEventTime()) {
      hash = (37 * hash) + EVENT_TIME_FIELD_NUMBER;
      hash = (53 * hash) + getEventTime().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.common.proto.ExternalEventRunPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.ExternalEventRunPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.ExternalEventRunPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.ExternalEventRunPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.ExternalEventRunPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.ExternalEventRunPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.ExternalEventRunPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.ExternalEventRunPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.ExternalEventRunPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.ExternalEventRunPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.ExternalEventRunPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.ExternalEventRunPb parseFrom(
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
  public static Builder newBuilder(io.littlehorse.common.proto.ExternalEventRunPb prototype) {
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
   * Protobuf type {@code lh_proto.ExternalEventRunPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:lh_proto.ExternalEventRunPb)
      io.littlehorse.common.proto.ExternalEventRunPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_ExternalEventRunPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_ExternalEventRunPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.common.proto.ExternalEventRunPb.class, io.littlehorse.common.proto.ExternalEventRunPb.Builder.class);
    }

    // Construct using io.littlehorse.common.proto.ExternalEventRunPb.newBuilder()
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
        getEventTimeFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      externalEventDefId_ = "";

      if (eventTimeBuilder_ == null) {
        eventTime_ = null;
      } else {
        eventTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_ExternalEventRunPb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.ExternalEventRunPb getDefaultInstanceForType() {
      return io.littlehorse.common.proto.ExternalEventRunPb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.common.proto.ExternalEventRunPb build() {
      io.littlehorse.common.proto.ExternalEventRunPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.ExternalEventRunPb buildPartial() {
      io.littlehorse.common.proto.ExternalEventRunPb result = new io.littlehorse.common.proto.ExternalEventRunPb(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.externalEventDefId_ = externalEventDefId_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        if (eventTimeBuilder_ == null) {
          result.eventTime_ = eventTime_;
        } else {
          result.eventTime_ = eventTimeBuilder_.build();
        }
        to_bitField0_ |= 0x00000001;
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
      if (other instanceof io.littlehorse.common.proto.ExternalEventRunPb) {
        return mergeFrom((io.littlehorse.common.proto.ExternalEventRunPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.common.proto.ExternalEventRunPb other) {
      if (other == io.littlehorse.common.proto.ExternalEventRunPb.getDefaultInstance()) return this;
      if (!other.getExternalEventDefId().isEmpty()) {
        externalEventDefId_ = other.externalEventDefId_;
        onChanged();
      }
      if (other.hasEventTime()) {
        mergeEventTime(other.getEventTime());
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
      io.littlehorse.common.proto.ExternalEventRunPb parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.littlehorse.common.proto.ExternalEventRunPb) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object externalEventDefId_ = "";
    /**
     * <code>string external_event_def_id = 1;</code>
     * @return The externalEventDefId.
     */
    public java.lang.String getExternalEventDefId() {
      java.lang.Object ref = externalEventDefId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        externalEventDefId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string external_event_def_id = 1;</code>
     * @return The bytes for externalEventDefId.
     */
    public com.google.protobuf.ByteString
        getExternalEventDefIdBytes() {
      java.lang.Object ref = externalEventDefId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        externalEventDefId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string external_event_def_id = 1;</code>
     * @param value The externalEventDefId to set.
     * @return This builder for chaining.
     */
    public Builder setExternalEventDefId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      externalEventDefId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string external_event_def_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearExternalEventDefId() {
      
      externalEventDefId_ = getDefaultInstance().getExternalEventDefId();
      onChanged();
      return this;
    }
    /**
     * <code>string external_event_def_id = 1;</code>
     * @param value The bytes for externalEventDefId to set.
     * @return This builder for chaining.
     */
    public Builder setExternalEventDefIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      externalEventDefId_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.Timestamp eventTime_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> eventTimeBuilder_;
    /**
     * <code>.google.protobuf.Timestamp event_time = 2;</code>
     * @return Whether the eventTime field is set.
     */
    public boolean hasEventTime() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.google.protobuf.Timestamp event_time = 2;</code>
     * @return The eventTime.
     */
    public com.google.protobuf.Timestamp getEventTime() {
      if (eventTimeBuilder_ == null) {
        return eventTime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : eventTime_;
      } else {
        return eventTimeBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp event_time = 2;</code>
     */
    public Builder setEventTime(com.google.protobuf.Timestamp value) {
      if (eventTimeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        eventTime_ = value;
        onChanged();
      } else {
        eventTimeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp event_time = 2;</code>
     */
    public Builder setEventTime(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (eventTimeBuilder_ == null) {
        eventTime_ = builderForValue.build();
        onChanged();
      } else {
        eventTimeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp event_time = 2;</code>
     */
    public Builder mergeEventTime(com.google.protobuf.Timestamp value) {
      if (eventTimeBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
            eventTime_ != null &&
            eventTime_ != com.google.protobuf.Timestamp.getDefaultInstance()) {
          eventTime_ =
            com.google.protobuf.Timestamp.newBuilder(eventTime_).mergeFrom(value).buildPartial();
        } else {
          eventTime_ = value;
        }
        onChanged();
      } else {
        eventTimeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp event_time = 2;</code>
     */
    public Builder clearEventTime() {
      if (eventTimeBuilder_ == null) {
        eventTime_ = null;
        onChanged();
      } else {
        eventTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp event_time = 2;</code>
     */
    public com.google.protobuf.Timestamp.Builder getEventTimeBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getEventTimeFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp event_time = 2;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getEventTimeOrBuilder() {
      if (eventTimeBuilder_ != null) {
        return eventTimeBuilder_.getMessageOrBuilder();
      } else {
        return eventTime_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : eventTime_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp event_time = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getEventTimeFieldBuilder() {
      if (eventTimeBuilder_ == null) {
        eventTimeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getEventTime(),
                getParentForChildren(),
                isClean());
        eventTime_ = null;
      }
      return eventTimeBuilder_;
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


    // @@protoc_insertion_point(builder_scope:lh_proto.ExternalEventRunPb)
  }

  // @@protoc_insertion_point(class_scope:lh_proto.ExternalEventRunPb)
  private static final io.littlehorse.common.proto.ExternalEventRunPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.common.proto.ExternalEventRunPb();
  }

  public static io.littlehorse.common.proto.ExternalEventRunPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExternalEventRunPb>
      PARSER = new com.google.protobuf.AbstractParser<ExternalEventRunPb>() {
    @java.lang.Override
    public ExternalEventRunPb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ExternalEventRunPb(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ExternalEventRunPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExternalEventRunPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.common.proto.ExternalEventRunPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

