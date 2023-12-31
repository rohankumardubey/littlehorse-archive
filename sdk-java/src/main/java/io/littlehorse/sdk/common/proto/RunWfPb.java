// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.sdk.common.proto;

/**
 * Protobuf type {@code littlehorse.RunWfPb}
 */
public final class RunWfPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:littlehorse.RunWfPb)
    RunWfPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RunWfPb.newBuilder() to construct.
  private RunWfPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RunWfPb() {
    wfSpecName_ = "";
    id_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RunWfPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.littlehorse.sdk.common.proto.Service.internal_static_littlehorse_RunWfPb_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 3:
        return internalGetVariables();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.sdk.common.proto.Service.internal_static_littlehorse_RunWfPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.sdk.common.proto.RunWfPb.class, io.littlehorse.sdk.common.proto.RunWfPb.Builder.class);
  }

  private int bitField0_;
  public static final int WF_SPEC_NAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object wfSpecName_ = "";
  /**
   * <code>string wf_spec_name = 1;</code>
   * @return The wfSpecName.
   */
  @java.lang.Override
  public java.lang.String getWfSpecName() {
    java.lang.Object ref = wfSpecName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      wfSpecName_ = s;
      return s;
    }
  }
  /**
   * <code>string wf_spec_name = 1;</code>
   * @return The bytes for wfSpecName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getWfSpecNameBytes() {
    java.lang.Object ref = wfSpecName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      wfSpecName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int WF_SPEC_VERSION_FIELD_NUMBER = 2;
  private int wfSpecVersion_ = 0;
  /**
   * <code>optional int32 wf_spec_version = 2;</code>
   * @return Whether the wfSpecVersion field is set.
   */
  @java.lang.Override
  public boolean hasWfSpecVersion() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional int32 wf_spec_version = 2;</code>
   * @return The wfSpecVersion.
   */
  @java.lang.Override
  public int getWfSpecVersion() {
    return wfSpecVersion_;
  }

  public static final int VARIABLES_FIELD_NUMBER = 3;
  private static final class VariablesDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb>newDefaultInstance(
                io.littlehorse.sdk.common.proto.Service.internal_static_littlehorse_RunWfPb_VariablesEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                io.littlehorse.sdk.common.proto.VariableValuePb.getDefaultInstance());
  }
  @SuppressWarnings("serial")
  private com.google.protobuf.MapField<
      java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> variables_;
  private com.google.protobuf.MapField<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb>
  internalGetVariables() {
    if (variables_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          VariablesDefaultEntryHolder.defaultEntry);
    }
    return variables_;
  }
  public int getVariablesCount() {
    return internalGetVariables().getMap().size();
  }
  /**
   * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 3;</code>
   */
  @java.lang.Override
  public boolean containsVariables(
      java.lang.String key) {
    if (key == null) { throw new NullPointerException("map key"); }
    return internalGetVariables().getMap().containsKey(key);
  }
  /**
   * Use {@link #getVariablesMap()} instead.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> getVariables() {
    return getVariablesMap();
  }
  /**
   * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 3;</code>
   */
  @java.lang.Override
  public java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> getVariablesMap() {
    return internalGetVariables().getMap();
  }
  /**
   * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 3;</code>
   */
  @java.lang.Override
  public /* nullable */
io.littlehorse.sdk.common.proto.VariableValuePb getVariablesOrDefault(
      java.lang.String key,
      /* nullable */
io.littlehorse.sdk.common.proto.VariableValuePb defaultValue) {
    if (key == null) { throw new NullPointerException("map key"); }
    java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> map =
        internalGetVariables().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 3;</code>
   */
  @java.lang.Override
  public io.littlehorse.sdk.common.proto.VariableValuePb getVariablesOrThrow(
      java.lang.String key) {
    if (key == null) { throw new NullPointerException("map key"); }
    java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> map =
        internalGetVariables().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
  }

  public static final int ID_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile java.lang.Object id_ = "";
  /**
   * <code>optional string id = 4;</code>
   * @return Whether the id field is set.
   */
  @java.lang.Override
  public boolean hasId() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional string id = 4;</code>
   * @return The id.
   */
  @java.lang.Override
  public java.lang.String getId() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>optional string id = 4;</code>
   * @return The bytes for id.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getIdBytes() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      id_ = b;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(wfSpecName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, wfSpecName_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeInt32(2, wfSpecVersion_);
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetVariables(),
        VariablesDefaultEntryHolder.defaultEntry,
        3);
    if (((bitField0_ & 0x00000002) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, id_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(wfSpecName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, wfSpecName_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, wfSpecVersion_);
    }
    for (java.util.Map.Entry<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> entry
         : internalGetVariables().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb>
      variables__ = VariablesDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, variables__);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, id_);
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
    if (!(obj instanceof io.littlehorse.sdk.common.proto.RunWfPb)) {
      return super.equals(obj);
    }
    io.littlehorse.sdk.common.proto.RunWfPb other = (io.littlehorse.sdk.common.proto.RunWfPb) obj;

    if (!getWfSpecName()
        .equals(other.getWfSpecName())) return false;
    if (hasWfSpecVersion() != other.hasWfSpecVersion()) return false;
    if (hasWfSpecVersion()) {
      if (getWfSpecVersion()
          != other.getWfSpecVersion()) return false;
    }
    if (!internalGetVariables().equals(
        other.internalGetVariables())) return false;
    if (hasId() != other.hasId()) return false;
    if (hasId()) {
      if (!getId()
          .equals(other.getId())) return false;
    }
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
    hash = (37 * hash) + WF_SPEC_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getWfSpecName().hashCode();
    if (hasWfSpecVersion()) {
      hash = (37 * hash) + WF_SPEC_VERSION_FIELD_NUMBER;
      hash = (53 * hash) + getWfSpecVersion();
    }
    if (!internalGetVariables().getMap().isEmpty()) {
      hash = (37 * hash) + VARIABLES_FIELD_NUMBER;
      hash = (53 * hash) + internalGetVariables().hashCode();
    }
    if (hasId()) {
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.sdk.common.proto.RunWfPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.sdk.common.proto.RunWfPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.sdk.common.proto.RunWfPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.sdk.common.proto.RunWfPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.sdk.common.proto.RunWfPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.sdk.common.proto.RunWfPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.sdk.common.proto.RunWfPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.sdk.common.proto.RunWfPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.sdk.common.proto.RunWfPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.sdk.common.proto.RunWfPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.sdk.common.proto.RunWfPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.sdk.common.proto.RunWfPb parseFrom(
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
  public static Builder newBuilder(io.littlehorse.sdk.common.proto.RunWfPb prototype) {
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
   * Protobuf type {@code littlehorse.RunWfPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:littlehorse.RunWfPb)
      io.littlehorse.sdk.common.proto.RunWfPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.sdk.common.proto.Service.internal_static_littlehorse_RunWfPb_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetVariables();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetMutableVariables();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.sdk.common.proto.Service.internal_static_littlehorse_RunWfPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.sdk.common.proto.RunWfPb.class, io.littlehorse.sdk.common.proto.RunWfPb.Builder.class);
    }

    // Construct using io.littlehorse.sdk.common.proto.RunWfPb.newBuilder()
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
      wfSpecName_ = "";
      wfSpecVersion_ = 0;
      internalGetMutableVariables().clear();
      id_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.sdk.common.proto.Service.internal_static_littlehorse_RunWfPb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.sdk.common.proto.RunWfPb getDefaultInstanceForType() {
      return io.littlehorse.sdk.common.proto.RunWfPb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.sdk.common.proto.RunWfPb build() {
      io.littlehorse.sdk.common.proto.RunWfPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.sdk.common.proto.RunWfPb buildPartial() {
      io.littlehorse.sdk.common.proto.RunWfPb result = new io.littlehorse.sdk.common.proto.RunWfPb(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(io.littlehorse.sdk.common.proto.RunWfPb result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.wfSpecName_ = wfSpecName_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.wfSpecVersion_ = wfSpecVersion_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.variables_ = internalGetVariables();
        result.variables_.makeImmutable();
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.id_ = id_;
        to_bitField0_ |= 0x00000002;
      }
      result.bitField0_ |= to_bitField0_;
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
      if (other instanceof io.littlehorse.sdk.common.proto.RunWfPb) {
        return mergeFrom((io.littlehorse.sdk.common.proto.RunWfPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.sdk.common.proto.RunWfPb other) {
      if (other == io.littlehorse.sdk.common.proto.RunWfPb.getDefaultInstance()) return this;
      if (!other.getWfSpecName().isEmpty()) {
        wfSpecName_ = other.wfSpecName_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasWfSpecVersion()) {
        setWfSpecVersion(other.getWfSpecVersion());
      }
      internalGetMutableVariables().mergeFrom(
          other.internalGetVariables());
      bitField0_ |= 0x00000004;
      if (other.hasId()) {
        id_ = other.id_;
        bitField0_ |= 0x00000008;
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
            case 10: {
              wfSpecName_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              wfSpecVersion_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              com.google.protobuf.MapEntry<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb>
              variables__ = input.readMessage(
                  VariablesDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              internalGetMutableVariables().getMutableMap().put(
                  variables__.getKey(), variables__.getValue());
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 34: {
              id_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000008;
              break;
            } // case 34
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

    private java.lang.Object wfSpecName_ = "";
    /**
     * <code>string wf_spec_name = 1;</code>
     * @return The wfSpecName.
     */
    public java.lang.String getWfSpecName() {
      java.lang.Object ref = wfSpecName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        wfSpecName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string wf_spec_name = 1;</code>
     * @return The bytes for wfSpecName.
     */
    public com.google.protobuf.ByteString
        getWfSpecNameBytes() {
      java.lang.Object ref = wfSpecName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        wfSpecName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string wf_spec_name = 1;</code>
     * @param value The wfSpecName to set.
     * @return This builder for chaining.
     */
    public Builder setWfSpecName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      wfSpecName_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string wf_spec_name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearWfSpecName() {
      wfSpecName_ = getDefaultInstance().getWfSpecName();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string wf_spec_name = 1;</code>
     * @param value The bytes for wfSpecName to set.
     * @return This builder for chaining.
     */
    public Builder setWfSpecNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      wfSpecName_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private int wfSpecVersion_ ;
    /**
     * <code>optional int32 wf_spec_version = 2;</code>
     * @return Whether the wfSpecVersion field is set.
     */
    @java.lang.Override
    public boolean hasWfSpecVersion() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional int32 wf_spec_version = 2;</code>
     * @return The wfSpecVersion.
     */
    @java.lang.Override
    public int getWfSpecVersion() {
      return wfSpecVersion_;
    }
    /**
     * <code>optional int32 wf_spec_version = 2;</code>
     * @param value The wfSpecVersion to set.
     * @return This builder for chaining.
     */
    public Builder setWfSpecVersion(int value) {
      
      wfSpecVersion_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 wf_spec_version = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearWfSpecVersion() {
      bitField0_ = (bitField0_ & ~0x00000002);
      wfSpecVersion_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> variables_;
    private com.google.protobuf.MapField<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb>
        internalGetVariables() {
      if (variables_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            VariablesDefaultEntryHolder.defaultEntry);
      }
      return variables_;
    }
    private com.google.protobuf.MapField<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb>
        internalGetMutableVariables() {
      if (variables_ == null) {
        variables_ = com.google.protobuf.MapField.newMapField(
            VariablesDefaultEntryHolder.defaultEntry);
      }
      if (!variables_.isMutable()) {
        variables_ = variables_.copy();
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return variables_;
    }
    public int getVariablesCount() {
      return internalGetVariables().getMap().size();
    }
    /**
     * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 3;</code>
     */
    @java.lang.Override
    public boolean containsVariables(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      return internalGetVariables().getMap().containsKey(key);
    }
    /**
     * Use {@link #getVariablesMap()} instead.
     */
    @java.lang.Override
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> getVariables() {
      return getVariablesMap();
    }
    /**
     * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 3;</code>
     */
    @java.lang.Override
    public java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> getVariablesMap() {
      return internalGetVariables().getMap();
    }
    /**
     * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 3;</code>
     */
    @java.lang.Override
    public /* nullable */
io.littlehorse.sdk.common.proto.VariableValuePb getVariablesOrDefault(
        java.lang.String key,
        /* nullable */
io.littlehorse.sdk.common.proto.VariableValuePb defaultValue) {
      if (key == null) { throw new NullPointerException("map key"); }
      java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> map =
          internalGetVariables().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 3;</code>
     */
    @java.lang.Override
    public io.littlehorse.sdk.common.proto.VariableValuePb getVariablesOrThrow(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> map =
          internalGetVariables().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }
    public Builder clearVariables() {
      bitField0_ = (bitField0_ & ~0x00000004);
      internalGetMutableVariables().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 3;</code>
     */
    public Builder removeVariables(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      internalGetMutableVariables().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb>
        getMutableVariables() {
      bitField0_ |= 0x00000004;
      return internalGetMutableVariables().getMutableMap();
    }
    /**
     * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 3;</code>
     */
    public Builder putVariables(
        java.lang.String key,
        io.littlehorse.sdk.common.proto.VariableValuePb value) {
      if (key == null) { throw new NullPointerException("map key"); }
      if (value == null) { throw new NullPointerException("map value"); }
      internalGetMutableVariables().getMutableMap()
          .put(key, value);
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 3;</code>
     */
    public Builder putAllVariables(
        java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.VariableValuePb> values) {
      internalGetMutableVariables().getMutableMap()
          .putAll(values);
      bitField0_ |= 0x00000004;
      return this;
    }

    private java.lang.Object id_ = "";
    /**
     * <code>optional string id = 4;</code>
     * @return Whether the id field is set.
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <code>optional string id = 4;</code>
     * @return The id.
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string id = 4;</code>
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string id = 4;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      id_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>optional string id = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      id_ = getDefaultInstance().getId();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>optional string id = 4;</code>
     * @param value The bytes for id to set.
     * @return This builder for chaining.
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      id_ = value;
      bitField0_ |= 0x00000008;
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


    // @@protoc_insertion_point(builder_scope:littlehorse.RunWfPb)
  }

  // @@protoc_insertion_point(class_scope:littlehorse.RunWfPb)
  private static final io.littlehorse.sdk.common.proto.RunWfPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.sdk.common.proto.RunWfPb();
  }

  public static io.littlehorse.sdk.common.proto.RunWfPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RunWfPb>
      PARSER = new com.google.protobuf.AbstractParser<RunWfPb>() {
    @java.lang.Override
    public RunWfPb parsePartialFrom(
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

  public static com.google.protobuf.Parser<RunWfPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RunWfPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.sdk.common.proto.RunWfPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

