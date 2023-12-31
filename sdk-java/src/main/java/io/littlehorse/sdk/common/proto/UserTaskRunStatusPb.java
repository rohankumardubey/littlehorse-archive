// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.sdk.common.proto;

/**
 * Protobuf enum {@code littlehorse.UserTaskRunStatusPb}
 */
public enum UserTaskRunStatusPb
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>UNASSIGNED = 0;</code>
   */
  UNASSIGNED(0),
  /**
   * <code>ASSIGNED = 1;</code>
   */
  ASSIGNED(1),
  /**
   * <code>DONE = 3;</code>
   */
  DONE(3),
  /**
   * <code>CANCELLED = 4;</code>
   */
  CANCELLED(4),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNASSIGNED = 0;</code>
   */
  public static final int UNASSIGNED_VALUE = 0;
  /**
   * <code>ASSIGNED = 1;</code>
   */
  public static final int ASSIGNED_VALUE = 1;
  /**
   * <code>DONE = 3;</code>
   */
  public static final int DONE_VALUE = 3;
  /**
   * <code>CANCELLED = 4;</code>
   */
  public static final int CANCELLED_VALUE = 4;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static UserTaskRunStatusPb valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static UserTaskRunStatusPb forNumber(int value) {
    switch (value) {
      case 0: return UNASSIGNED;
      case 1: return ASSIGNED;
      case 3: return DONE;
      case 4: return CANCELLED;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<UserTaskRunStatusPb>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      UserTaskRunStatusPb> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<UserTaskRunStatusPb>() {
          public UserTaskRunStatusPb findValueByNumber(int number) {
            return UserTaskRunStatusPb.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return io.littlehorse.sdk.common.proto.Service.getDescriptor().getEnumTypes().get(8);
  }

  private static final UserTaskRunStatusPb[] VALUES = values();

  public static UserTaskRunStatusPb valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private UserTaskRunStatusPb(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:littlehorse.UserTaskRunStatusPb)
}

