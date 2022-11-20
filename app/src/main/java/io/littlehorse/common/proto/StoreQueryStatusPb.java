// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_server.proto

package io.littlehorse.common.proto;

/**
 * <pre>
 * The section below contains the protocol for inter-broker communication
 * </pre>
 *
 * Protobuf enum {@code lh_proto.StoreQueryStatusPb}
 */
public enum StoreQueryStatusPb
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * If OK and bytes is empty, means that the key is not found.
   * </pre>
   *
   * <code>RSQ_OK = 0;</code>
   */
  RSQ_OK(0),
  /**
   * <pre>
   * Can't query store, eg. during a rebalance or if migrated.
   * </pre>
   *
   * <code>RSQ_NOT_AVAILABLE = 2;</code>
   */
  RSQ_NOT_AVAILABLE(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * If OK and bytes is empty, means that the key is not found.
   * </pre>
   *
   * <code>RSQ_OK = 0;</code>
   */
  public static final int RSQ_OK_VALUE = 0;
  /**
   * <pre>
   * Can't query store, eg. during a rebalance or if migrated.
   * </pre>
   *
   * <code>RSQ_NOT_AVAILABLE = 2;</code>
   */
  public static final int RSQ_NOT_AVAILABLE_VALUE = 2;


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
  public static StoreQueryStatusPb valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static StoreQueryStatusPb forNumber(int value) {
    switch (value) {
      case 0: return RSQ_OK;
      case 2: return RSQ_NOT_AVAILABLE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<StoreQueryStatusPb>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      StoreQueryStatusPb> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<StoreQueryStatusPb>() {
          public StoreQueryStatusPb findValueByNumber(int number) {
            return StoreQueryStatusPb.forNumber(number);
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
    return io.littlehorse.common.proto.InternalServer.getDescriptor().getEnumTypes().get(0);
  }

  private static final StoreQueryStatusPb[] VALUES = values();

  public static StoreQueryStatusPb valueOf(
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

  private StoreQueryStatusPb(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:lh_proto.StoreQueryStatusPb)
}
