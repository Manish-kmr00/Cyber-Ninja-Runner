package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes8.dex */
public enum ErrorReasonAnalytics implements ProtocolMessageEnum {
    ERROR_REASON_ANALYTICS_INVALID(0),
    ERROR_REASON_ANALYTICS_UNDEFINED(2000),
    ERROR_REASON_ANALYTICS_MONITOR_UNDEFINED(2100),
    ERROR_REASON_ANALYTICS_MONITOR_NO_CONTENT(2101),
    ERROR_REASON_ANALYTICS_MONITOR_BAD_CONTENT(2102),
    ERROR_REASON_ANALYTICS_READER_UNDEFINED(2200),
    ERROR_REASON_ANALYTICS_READER_NO_CONTENT(2201),
    ERROR_REASON_ANALYTICS_READER_BAD_CONTENT(2202),
    ERROR_REASON_ANALYTICS_READER_NO_ACCESS(2203),
    UNRECOGNIZED(-1);

    public static final int ERROR_REASON_ANALYTICS_INVALID_VALUE = 0;
    public static final int ERROR_REASON_ANALYTICS_MONITOR_BAD_CONTENT_VALUE = 2102;
    public static final int ERROR_REASON_ANALYTICS_MONITOR_NO_CONTENT_VALUE = 2101;
    public static final int ERROR_REASON_ANALYTICS_MONITOR_UNDEFINED_VALUE = 2100;
    public static final int ERROR_REASON_ANALYTICS_READER_BAD_CONTENT_VALUE = 2202;
    public static final int ERROR_REASON_ANALYTICS_READER_NO_ACCESS_VALUE = 2203;
    public static final int ERROR_REASON_ANALYTICS_READER_NO_CONTENT_VALUE = 2201;
    public static final int ERROR_REASON_ANALYTICS_READER_UNDEFINED_VALUE = 2200;
    public static final int ERROR_REASON_ANALYTICS_UNDEFINED_VALUE = 2000;
    private final int value;
    private static final Internal.EnumLiteMap<ErrorReasonAnalytics> internalValueMap = new Internal.EnumLiteMap<ErrorReasonAnalytics>() { // from class: io.bidmachine.protobuf.sdk.ErrorReasonAnalytics.1
        @Override // com.explorestack.protobuf.Internal.EnumLiteMap
        public ErrorReasonAnalytics findValueByNumber(int i) {
            return ErrorReasonAnalytics.forNumber(i);
        }
    };
    private static final ErrorReasonAnalytics[] VALUES = values();

    @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static ErrorReasonAnalytics valueOf(int i) {
        return forNumber(i);
    }

    public static ErrorReasonAnalytics forNumber(int i) {
        if (i == 0) {
            return ERROR_REASON_ANALYTICS_INVALID;
        }
        if (i == 2000) {
            return ERROR_REASON_ANALYTICS_UNDEFINED;
        }
        switch (i) {
            case 2100:
                return ERROR_REASON_ANALYTICS_MONITOR_UNDEFINED;
            case 2101:
                return ERROR_REASON_ANALYTICS_MONITOR_NO_CONTENT;
            case 2102:
                return ERROR_REASON_ANALYTICS_MONITOR_BAD_CONTENT;
            default:
                switch (i) {
                    case 2200:
                        return ERROR_REASON_ANALYTICS_READER_UNDEFINED;
                    case 2201:
                        return ERROR_REASON_ANALYTICS_READER_NO_CONTENT;
                    case 2202:
                        return ERROR_REASON_ANALYTICS_READER_BAD_CONTENT;
                    case 2203:
                        return ERROR_REASON_ANALYTICS_READER_NO_ACCESS;
                    default:
                        return null;
                }
        }
    }

    public static Internal.EnumLiteMap<ErrorReasonAnalytics> internalGetValueMap() {
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
        return SDKErrorsProto.getDescriptor().getEnumTypes().get(0);
    }

    public static ErrorReasonAnalytics valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    ErrorReasonAnalytics(int i) {
        this.value = i;
    }
}
