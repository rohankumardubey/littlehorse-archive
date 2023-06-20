// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.jlib.common.proto;

/**
 * Protobuf type {@code littlehorse.WaitingForExtEvtOePb}
 */
public final class WaitingForExtEvtOePb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:littlehorse.WaitingForExtEvtOePb)
    WaitingForExtEvtOePbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WaitingForExtEvtOePb.newBuilder() to construct.
  private WaitingForExtEvtOePb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WaitingForExtEvtOePb() {
    extEvtDefName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new WaitingForExtEvtOePb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.littlehorse.jlib.common.proto.Service.internal_static_littlehorse_WaitingForExtEvtOePb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.jlib.common.proto.Service.internal_static_littlehorse_WaitingForExtEvtOePb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb.class, io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb.Builder.class);
  }

  public static final int THREAD_RUN_NUMBER_FIELD_NUMBER = 1;
  private int threadRunNumber_ = 0;
  /**
   * <code>int32 thread_run_number = 1;</code>
   * @return The threadRunNumber.
   */
  @java.lang.Override
  public int getThreadRunNumber() {
    return threadRunNumber_;
  }

  public static final int NODE_RUN_POSITION_FIELD_NUMBER = 2;
  private int nodeRunPosition_ = 0;
  /**
   * <code>int32 node_run_position = 2;</code>
   * @return The nodeRunPosition.
   */
  @java.lang.Override
  public int getNodeRunPosition() {
    return nodeRunPosition_;
  }

  public static final int EXT_EVT_DEF_NAME_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object extEvtDefName_ = "";
  /**
   * <code>string ext_evt_def_name = 3;</code>
   * @return The extEvtDefName.
   */
  @java.lang.Override
  public java.lang.String getExtEvtDefName() {
    java.lang.Object ref = extEvtDefName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      extEvtDefName_ = s;
      return s;
    }
  }
  /**
   * <code>string ext_evt_def_name = 3;</code>
   * @return The bytes for extEvtDefName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getExtEvtDefNameBytes() {
    java.lang.Object ref = extEvtDefName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      extEvtDefName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (threadRunNumber_ != 0) {
      output.writeInt32(1, threadRunNumber_);
    }
    if (nodeRunPosition_ != 0) {
      output.writeInt32(2, nodeRunPosition_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(extEvtDefName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, extEvtDefName_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (threadRunNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, threadRunNumber_);
    }
    if (nodeRunPosition_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, nodeRunPosition_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(extEvtDefName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, extEvtDefName_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb)) {
      return super.equals(obj);
    }
    io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb other = (io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb) obj;

    if (getThreadRunNumber()
        != other.getThreadRunNumber()) return false;
    if (getNodeRunPosition()
        != other.getNodeRunPosition()) return false;
    if (!getExtEvtDefName()
        .equals(other.getExtEvtDefName())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + THREAD_RUN_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getThreadRunNumber();
    hash = (37 * hash) + NODE_RUN_POSITION_FIELD_NUMBER;
    hash = (53 * hash) + getNodeRunPosition();
    hash = (37 * hash) + EXT_EVT_DEF_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getExtEvtDefName().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb parseFrom(
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
  public static Builder newBuilder(io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb prototype) {
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
   * Protobuf type {@code littlehorse.WaitingForExtEvtOePb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:littlehorse.WaitingForExtEvtOePb)
      io.littlehorse.jlib.common.proto.WaitingForExtEvtOePbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.jlib.common.proto.Service.internal_static_littlehorse_WaitingForExtEvtOePb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.jlib.common.proto.Service.internal_static_littlehorse_WaitingForExtEvtOePb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb.class, io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb.Builder.class);
    }

    // Construct using io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      threadRunNumber_ = 0;
      nodeRunPosition_ = 0;
      extEvtDefName_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.jlib.common.proto.Service.internal_static_littlehorse_WaitingForExtEvtOePb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb getDefaultInstanceForType() {
      return io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb build() {
      io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb buildPartial() {
      io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb result = new io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.threadRunNumber_ = threadRunNumber_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.nodeRunPosition_ = nodeRunPosition_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.extEvtDefName_ = extEvtDefName_;
      }
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
      if (other instanceof io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb) {
        return mergeFrom((io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb other) {
      if (other == io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb.getDefaultInstance()) return this;
      if (other.getThreadRunNumber() != 0) {
        setThreadRunNumber(other.getThreadRunNumber());
      }
      if (other.getNodeRunPosition() != 0) {
        setNodeRunPosition(other.getNodeRunPosition());
      }
      if (!other.getExtEvtDefName().isEmpty()) {
        extEvtDefName_ = other.extEvtDefName_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
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
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              threadRunNumber_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              nodeRunPosition_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              extEvtDefName_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int threadRunNumber_ ;
    /**
     * <code>int32 thread_run_number = 1;</code>
     * @return The threadRunNumber.
     */
    @java.lang.Override
    public int getThreadRunNumber() {
      return threadRunNumber_;
    }
    /**
     * <code>int32 thread_run_number = 1;</code>
     * @param value The threadRunNumber to set.
     * @return This builder for chaining.
     */
    public Builder setThreadRunNumber(int value) {
      
      threadRunNumber_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 thread_run_number = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearThreadRunNumber() {
      bitField0_ = (bitField0_ & ~0x00000001);
      threadRunNumber_ = 0;
      onChanged();
      return this;
    }

    private int nodeRunPosition_ ;
    /**
     * <code>int32 node_run_position = 2;</code>
     * @return The nodeRunPosition.
     */
    @java.lang.Override
    public int getNodeRunPosition() {
      return nodeRunPosition_;
    }
    /**
     * <code>int32 node_run_position = 2;</code>
     * @param value The nodeRunPosition to set.
     * @return This builder for chaining.
     */
    public Builder setNodeRunPosition(int value) {
      
      nodeRunPosition_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 node_run_position = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearNodeRunPosition() {
      bitField0_ = (bitField0_ & ~0x00000002);
      nodeRunPosition_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object extEvtDefName_ = "";
    /**
     * <code>string ext_evt_def_name = 3;</code>
     * @return The extEvtDefName.
     */
    public java.lang.String getExtEvtDefName() {
      java.lang.Object ref = extEvtDefName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        extEvtDefName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string ext_evt_def_name = 3;</code>
     * @return The bytes for extEvtDefName.
     */
    public com.google.protobuf.ByteString
        getExtEvtDefNameBytes() {
      java.lang.Object ref = extEvtDefName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        extEvtDefName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string ext_evt_def_name = 3;</code>
     * @param value The extEvtDefName to set.
     * @return This builder for chaining.
     */
    public Builder setExtEvtDefName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      extEvtDefName_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string ext_evt_def_name = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearExtEvtDefName() {
      extEvtDefName_ = getDefaultInstance().getExtEvtDefName();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string ext_evt_def_name = 3;</code>
     * @param value The bytes for extEvtDefName to set.
     * @return This builder for chaining.
     */
    public Builder setExtEvtDefNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      extEvtDefName_ = value;
      bitField0_ |= 0x00000004;
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


    // @@protoc_insertion_point(builder_scope:littlehorse.WaitingForExtEvtOePb)
  }

  // @@protoc_insertion_point(class_scope:littlehorse.WaitingForExtEvtOePb)
  private static final io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb();
  }

  public static io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WaitingForExtEvtOePb>
      PARSER = new com.google.protobuf.AbstractParser<WaitingForExtEvtOePb>() {
    @java.lang.Override
    public WaitingForExtEvtOePb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<WaitingForExtEvtOePb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WaitingForExtEvtOePb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.jlib.common.proto.WaitingForExtEvtOePb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
