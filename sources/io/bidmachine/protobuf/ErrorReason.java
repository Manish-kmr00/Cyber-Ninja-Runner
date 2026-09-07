package io.bidmachine.protobuf;

import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes7.dex */
public enum ErrorReason implements ProtocolMessageEnum {
    ERROR_REASON_INVALID(0),
    ERROR_REASON_NO_CONNECTION(100),
    ERROR_REASON_BAD_CONTENT(101),
    ERROR_REASON_TIMEOUT(102),
    ERROR_REASON_NO_CONTENT(103),
    ERROR_REASON_HANDLED_EXCEPTION(104),
    ERROR_REASON_WAS_CLOSED(105),
    ERROR_REASON_WAS_DESTROYED(106),
    ERROR_REASON_WAS_EXPIRED(107),
    ERROR_REASON_WAS_USED_ALREADY(111),
    ERROR_REASON_INTERNAL(108),
    ERROR_REASON_HTTP_SERVER_ERROR(109),
    ERROR_REASON_HTTP_BAD_REQUEST(110),
    ERROR_REASON_HB_NETWORK(200),
    ERROR_REASON_PLACEHOLDER_TIMEOUT(201),
    UNRECOGNIZED(-1);

    public static final int ERROR_REASON_BAD_CONTENT_VALUE = 101;
    public static final int ERROR_REASON_HANDLED_EXCEPTION_VALUE = 104;
    public static final int ERROR_REASON_HB_NETWORK_VALUE = 200;
    public static final int ERROR_REASON_HTTP_BAD_REQUEST_VALUE = 110;
    public static final int ERROR_REASON_HTTP_SERVER_ERROR_VALUE = 109;
    public static final int ERROR_REASON_INTERNAL_VALUE = 108;
    public static final int ERROR_REASON_INVALID_VALUE = 0;
    public static final int ERROR_REASON_NO_CONNECTION_VALUE = 100;
    public static final int ERROR_REASON_NO_CONTENT_VALUE = 103;
    public static final int ERROR_REASON_PLACEHOLDER_TIMEOUT_VALUE = 201;
    public static final int ERROR_REASON_TIMEOUT_VALUE = 102;
    public static final int ERROR_REASON_WAS_CLOSED_VALUE = 105;
    public static final int ERROR_REASON_WAS_DESTROYED_VALUE = 106;
    public static final int ERROR_REASON_WAS_EXPIRED_VALUE = 107;
    public static final int ERROR_REASON_WAS_USED_ALREADY_VALUE = 111;
    private final int value;
    private static final Internal.EnumLiteMap<ErrorReason> internalValueMap = new Internal.EnumLiteMap<ErrorReason>() { // from class: io.bidmachine.protobuf.ErrorReason.1
        @Override // com.explorestack.protobuf.Internal.EnumLiteMap
        public ErrorReason findValueByNumber(int i) {
            return ErrorReason.forNumber(i);
        }
    };
    private static final ErrorReason[] VALUES = values();

    @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static ErrorReason valueOf(int i) {
        return forNumber(i);
    }

    public static ErrorReason forNumber(int i) {
        if (i == 0) {
            return ERROR_REASON_INVALID;
        }
        if (i == 200) {
            return ERROR_REASON_HB_NETWORK;
        }
        if (i != 201) {
            switch (i) {
                case 100:
                    return ERROR_REASON_NO_CONNECTION;
                case 101:
                    return ERROR_REASON_BAD_CONTENT;
                case 102:
                    return ERROR_REASON_TIMEOUT;
                case 103:
                    return ERROR_REASON_NO_CONTENT;
                case 104:
                    return ERROR_REASON_HANDLED_EXCEPTION;
                case 105:
                    return ERROR_REASON_WAS_CLOSED;
                case 106:
                    return ERROR_REASON_WAS_DESTROYED;
                case 107:
                    return ERROR_REASON_WAS_EXPIRED;
                case 108:
                    return ERROR_REASON_INTERNAL;
                case 109:
                    return ERROR_REASON_HTTP_SERVER_ERROR;
                case 110:
                    return ERROR_REASON_HTTP_BAD_REQUEST;
                case 111:
                    return ERROR_REASON_WAS_USED_ALREADY;
                default:
                    return null;
            }
        }
        return ERROR_REASON_PLACEHOLDER_TIMEOUT;
    }

    public static Internal.EnumLiteMap<ErrorReason> internalGetValueMap() {
        return internalValueMap;
    }

    @Override // com.explorestack.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        if (this == UNRECOGNIZED) {
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
        return getDescriptor().getValues().get(ordinal());
    }

    @Override // com.explorestack.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return ExtensionsProto.getDescriptor().getEnumTypes().get(3);
    }

    public static ErrorReason valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    ErrorReason(int i) {
        this.value = i;
    }
}
