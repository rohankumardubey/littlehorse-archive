// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.jlib.common.proto;

/**
 * Protobuf type {@code littlehorse.TaskWorkerGroupPb}
 */
public final class TaskWorkerGroupPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:littlehorse.TaskWorkerGroupPb)
    TaskWorkerGroupPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TaskWorkerGroupPb.newBuilder() to construct.
  private TaskWorkerGroupPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TaskWorkerGroupPb() {
    taskDefName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TaskWorkerGroupPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.littlehorse.jlib.common.proto.Service.internal_static_littlehorse_TaskWorkerGroupPb_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 3:
        return internalGetTaskWorkers();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.jlib.common.proto.Service.internal_static_littlehorse_TaskWorkerGroupPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.jlib.common.proto.TaskWorkerGroupPb.class, io.littlehorse.jlib.common.proto.TaskWorkerGroupPb.Builder.class);
  }

  public static final int TASK_DEF_NAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object taskDefName_ = "";
  /**
   * <code>string task_def_name = 1;</code>
   * @return The taskDefName.
   */
  @java.lang.Override
  public java.lang.String getTaskDefName() {
    java.lang.Object ref = taskDefName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      taskDefName_ = s;
      return s;
    }
  }
  /**
   * <code>string task_def_name = 1;</code>
   * @return The bytes for taskDefName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTaskDefNameBytes() {
    java.lang.Object ref = taskDefName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      taskDefName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CREATED_AT_FIELD_NUMBER = 2;
  private com.google.protobuf.Timestamp createdAt_;
  /**
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   * @return Whether the createdAt field is set.
   */
  @java.lang.Override
  public boolean hasCreatedAt() {
    return createdAt_ != null;
  }
  /**
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   * @return The createdAt.
   */
  @java.lang.Override
  public com.google.protobuf.Timestamp getCreatedAt() {
    return createdAt_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : createdAt_;
  }
  /**
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   */
  @java.lang.Override
  public com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder() {
    return createdAt_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : createdAt_;
  }

  public static final int TASK_WORKERS_FIELD_NUMBER = 3;
  private static final class TaskWorkersDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb>newDefaultInstance(
                io.littlehorse.jlib.common.proto.Service.internal_static_littlehorse_TaskWorkerGroupPb_TaskWorkersEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb.getDefaultInstance());
  }
  @SuppressWarnings("serial")
  private com.google.protobuf.MapField<
      java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> taskWorkers_;
  private com.google.protobuf.MapField<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb>
  internalGetTaskWorkers() {
    if (taskWorkers_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          TaskWorkersDefaultEntryHolder.defaultEntry);
    }
    return taskWorkers_;
  }
  public int getTaskWorkersCount() {
    return internalGetTaskWorkers().getMap().size();
  }
  /**
   * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
   */
  @java.lang.Override
  public boolean containsTaskWorkers(
      java.lang.String key) {
    if (key == null) { throw new NullPointerException("map key"); }
    return internalGetTaskWorkers().getMap().containsKey(key);
  }
  /**
   * Use {@link #getTaskWorkersMap()} instead.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> getTaskWorkers() {
    return getTaskWorkersMap();
  }
  /**
   * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
   */
  @java.lang.Override
  public java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> getTaskWorkersMap() {
    return internalGetTaskWorkers().getMap();
  }
  /**
   * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
   */
  @java.lang.Override
  public /* nullable */
io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb getTaskWorkersOrDefault(
      java.lang.String key,
      /* nullable */
io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb defaultValue) {
    if (key == null) { throw new NullPointerException("map key"); }
    java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> map =
        internalGetTaskWorkers().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
   */
  @java.lang.Override
  public io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb getTaskWorkersOrThrow(
      java.lang.String key) {
    if (key == null) { throw new NullPointerException("map key"); }
    java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> map =
        internalGetTaskWorkers().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(taskDefName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, taskDefName_);
    }
    if (createdAt_ != null) {
      output.writeMessage(2, getCreatedAt());
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetTaskWorkers(),
        TaskWorkersDefaultEntryHolder.defaultEntry,
        3);
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(taskDefName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, taskDefName_);
    }
    if (createdAt_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getCreatedAt());
    }
    for (java.util.Map.Entry<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> entry
         : internalGetTaskWorkers().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb>
      taskWorkers__ = TaskWorkersDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, taskWorkers__);
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
    if (!(obj instanceof io.littlehorse.jlib.common.proto.TaskWorkerGroupPb)) {
      return super.equals(obj);
    }
    io.littlehorse.jlib.common.proto.TaskWorkerGroupPb other = (io.littlehorse.jlib.common.proto.TaskWorkerGroupPb) obj;

    if (!getTaskDefName()
        .equals(other.getTaskDefName())) return false;
    if (hasCreatedAt() != other.hasCreatedAt()) return false;
    if (hasCreatedAt()) {
      if (!getCreatedAt()
          .equals(other.getCreatedAt())) return false;
    }
    if (!internalGetTaskWorkers().equals(
        other.internalGetTaskWorkers())) return false;
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
    hash = (37 * hash) + TASK_DEF_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getTaskDefName().hashCode();
    if (hasCreatedAt()) {
      hash = (37 * hash) + CREATED_AT_FIELD_NUMBER;
      hash = (53 * hash) + getCreatedAt().hashCode();
    }
    if (!internalGetTaskWorkers().getMap().isEmpty()) {
      hash = (37 * hash) + TASK_WORKERS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetTaskWorkers().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb parseFrom(
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
  public static Builder newBuilder(io.littlehorse.jlib.common.proto.TaskWorkerGroupPb prototype) {
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
   * Protobuf type {@code littlehorse.TaskWorkerGroupPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:littlehorse.TaskWorkerGroupPb)
      io.littlehorse.jlib.common.proto.TaskWorkerGroupPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.jlib.common.proto.Service.internal_static_littlehorse_TaskWorkerGroupPb_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetTaskWorkers();
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
          return internalGetMutableTaskWorkers();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.jlib.common.proto.Service.internal_static_littlehorse_TaskWorkerGroupPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.jlib.common.proto.TaskWorkerGroupPb.class, io.littlehorse.jlib.common.proto.TaskWorkerGroupPb.Builder.class);
    }

    // Construct using io.littlehorse.jlib.common.proto.TaskWorkerGroupPb.newBuilder()
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
      taskDefName_ = "";
      createdAt_ = null;
      if (createdAtBuilder_ != null) {
        createdAtBuilder_.dispose();
        createdAtBuilder_ = null;
      }
      internalGetMutableTaskWorkers().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.jlib.common.proto.Service.internal_static_littlehorse_TaskWorkerGroupPb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.jlib.common.proto.TaskWorkerGroupPb getDefaultInstanceForType() {
      return io.littlehorse.jlib.common.proto.TaskWorkerGroupPb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.jlib.common.proto.TaskWorkerGroupPb build() {
      io.littlehorse.jlib.common.proto.TaskWorkerGroupPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.jlib.common.proto.TaskWorkerGroupPb buildPartial() {
      io.littlehorse.jlib.common.proto.TaskWorkerGroupPb result = new io.littlehorse.jlib.common.proto.TaskWorkerGroupPb(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(io.littlehorse.jlib.common.proto.TaskWorkerGroupPb result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.taskDefName_ = taskDefName_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.createdAt_ = createdAtBuilder_ == null
            ? createdAt_
            : createdAtBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.taskWorkers_ = internalGetTaskWorkers();
        result.taskWorkers_.makeImmutable();
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
      if (other instanceof io.littlehorse.jlib.common.proto.TaskWorkerGroupPb) {
        return mergeFrom((io.littlehorse.jlib.common.proto.TaskWorkerGroupPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.jlib.common.proto.TaskWorkerGroupPb other) {
      if (other == io.littlehorse.jlib.common.proto.TaskWorkerGroupPb.getDefaultInstance()) return this;
      if (!other.getTaskDefName().isEmpty()) {
        taskDefName_ = other.taskDefName_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasCreatedAt()) {
        mergeCreatedAt(other.getCreatedAt());
      }
      internalGetMutableTaskWorkers().mergeFrom(
          other.internalGetTaskWorkers());
      bitField0_ |= 0x00000004;
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
              taskDefName_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getCreatedAtFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              com.google.protobuf.MapEntry<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb>
              taskWorkers__ = input.readMessage(
                  TaskWorkersDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              internalGetMutableTaskWorkers().getMutableMap().put(
                  taskWorkers__.getKey(), taskWorkers__.getValue());
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

    private java.lang.Object taskDefName_ = "";
    /**
     * <code>string task_def_name = 1;</code>
     * @return The taskDefName.
     */
    public java.lang.String getTaskDefName() {
      java.lang.Object ref = taskDefName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        taskDefName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string task_def_name = 1;</code>
     * @return The bytes for taskDefName.
     */
    public com.google.protobuf.ByteString
        getTaskDefNameBytes() {
      java.lang.Object ref = taskDefName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        taskDefName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string task_def_name = 1;</code>
     * @param value The taskDefName to set.
     * @return This builder for chaining.
     */
    public Builder setTaskDefName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      taskDefName_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string task_def_name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearTaskDefName() {
      taskDefName_ = getDefaultInstance().getTaskDefName();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string task_def_name = 1;</code>
     * @param value The bytes for taskDefName to set.
     * @return This builder for chaining.
     */
    public Builder setTaskDefNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      taskDefName_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private com.google.protobuf.Timestamp createdAt_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> createdAtBuilder_;
    /**
     * <code>.google.protobuf.Timestamp created_at = 2;</code>
     * @return Whether the createdAt field is set.
     */
    public boolean hasCreatedAt() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 2;</code>
     * @return The createdAt.
     */
    public com.google.protobuf.Timestamp getCreatedAt() {
      if (createdAtBuilder_ == null) {
        return createdAt_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : createdAt_;
      } else {
        return createdAtBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 2;</code>
     */
    public Builder setCreatedAt(com.google.protobuf.Timestamp value) {
      if (createdAtBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        createdAt_ = value;
      } else {
        createdAtBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 2;</code>
     */
    public Builder setCreatedAt(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (createdAtBuilder_ == null) {
        createdAt_ = builderForValue.build();
      } else {
        createdAtBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 2;</code>
     */
    public Builder mergeCreatedAt(com.google.protobuf.Timestamp value) {
      if (createdAtBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          createdAt_ != null &&
          createdAt_ != com.google.protobuf.Timestamp.getDefaultInstance()) {
          getCreatedAtBuilder().mergeFrom(value);
        } else {
          createdAt_ = value;
        }
      } else {
        createdAtBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 2;</code>
     */
    public Builder clearCreatedAt() {
      bitField0_ = (bitField0_ & ~0x00000002);
      createdAt_ = null;
      if (createdAtBuilder_ != null) {
        createdAtBuilder_.dispose();
        createdAtBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 2;</code>
     */
    public com.google.protobuf.Timestamp.Builder getCreatedAtBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getCreatedAtFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 2;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder() {
      if (createdAtBuilder_ != null) {
        return createdAtBuilder_.getMessageOrBuilder();
      } else {
        return createdAt_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : createdAt_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getCreatedAtFieldBuilder() {
      if (createdAtBuilder_ == null) {
        createdAtBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getCreatedAt(),
                getParentForChildren(),
                isClean());
        createdAt_ = null;
      }
      return createdAtBuilder_;
    }

    private com.google.protobuf.MapField<
        java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> taskWorkers_;
    private com.google.protobuf.MapField<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb>
        internalGetTaskWorkers() {
      if (taskWorkers_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            TaskWorkersDefaultEntryHolder.defaultEntry);
      }
      return taskWorkers_;
    }
    private com.google.protobuf.MapField<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb>
        internalGetMutableTaskWorkers() {
      if (taskWorkers_ == null) {
        taskWorkers_ = com.google.protobuf.MapField.newMapField(
            TaskWorkersDefaultEntryHolder.defaultEntry);
      }
      if (!taskWorkers_.isMutable()) {
        taskWorkers_ = taskWorkers_.copy();
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return taskWorkers_;
    }
    public int getTaskWorkersCount() {
      return internalGetTaskWorkers().getMap().size();
    }
    /**
     * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
     */
    @java.lang.Override
    public boolean containsTaskWorkers(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      return internalGetTaskWorkers().getMap().containsKey(key);
    }
    /**
     * Use {@link #getTaskWorkersMap()} instead.
     */
    @java.lang.Override
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> getTaskWorkers() {
      return getTaskWorkersMap();
    }
    /**
     * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
     */
    @java.lang.Override
    public java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> getTaskWorkersMap() {
      return internalGetTaskWorkers().getMap();
    }
    /**
     * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
     */
    @java.lang.Override
    public /* nullable */
io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb getTaskWorkersOrDefault(
        java.lang.String key,
        /* nullable */
io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb defaultValue) {
      if (key == null) { throw new NullPointerException("map key"); }
      java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> map =
          internalGetTaskWorkers().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
     */
    @java.lang.Override
    public io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb getTaskWorkersOrThrow(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> map =
          internalGetTaskWorkers().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }
    public Builder clearTaskWorkers() {
      bitField0_ = (bitField0_ & ~0x00000004);
      internalGetMutableTaskWorkers().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
     */
    public Builder removeTaskWorkers(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      internalGetMutableTaskWorkers().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb>
        getMutableTaskWorkers() {
      bitField0_ |= 0x00000004;
      return internalGetMutableTaskWorkers().getMutableMap();
    }
    /**
     * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
     */
    public Builder putTaskWorkers(
        java.lang.String key,
        io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb value) {
      if (key == null) { throw new NullPointerException("map key"); }
      if (value == null) { throw new NullPointerException("map value"); }
      internalGetMutableTaskWorkers().getMutableMap()
          .put(key, value);
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
     */
    public Builder putAllTaskWorkers(
        java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb> values) {
      internalGetMutableTaskWorkers().getMutableMap()
          .putAll(values);
      bitField0_ |= 0x00000004;
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


    // @@protoc_insertion_point(builder_scope:littlehorse.TaskWorkerGroupPb)
  }

  // @@protoc_insertion_point(class_scope:littlehorse.TaskWorkerGroupPb)
  private static final io.littlehorse.jlib.common.proto.TaskWorkerGroupPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.jlib.common.proto.TaskWorkerGroupPb();
  }

  public static io.littlehorse.jlib.common.proto.TaskWorkerGroupPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TaskWorkerGroupPb>
      PARSER = new com.google.protobuf.AbstractParser<TaskWorkerGroupPb>() {
    @java.lang.Override
    public TaskWorkerGroupPb parsePartialFrom(
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

  public static com.google.protobuf.Parser<TaskWorkerGroupPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TaskWorkerGroupPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.jlib.common.proto.TaskWorkerGroupPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
