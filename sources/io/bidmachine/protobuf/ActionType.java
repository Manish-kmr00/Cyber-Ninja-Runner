package io.bidmachine.protobuf;

import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes10.dex */
public enum ActionType implements ProtocolMessageEnum {
    ACTION_TYPE_INVALID(0),
    ACTION_TYPE_AD_LOADING(500),
    ACTION_TYPE_SHOWING(501),
    ACTION_TYPE_VIEWING(502),
    ACTION_TYPE_CLICKING(503),
    ACTION_TYPE_CLOSING(504),
    ACTION_TYPE_AD_DESTROYING(505),
    ACTION_TYPE_SESSION_INITIALIZING(506),
    ACTION_TYPE_REQUEST_LOADING(507),
    ACTION_TYPE_REQUEST_CANCELING(508),
    ACTION_TYPE_HB_INITIALIZING(701),
    ACTION_TYPE_HB_PREPARING(702),
    UNRECOGNIZED(-1);

    public static final int ACTION_TYPE_AD_DESTROYING_VALUE = 505;
    public static final int ACTION_TYPE_AD_LOADING_VALUE = 500;
    public static final int ACTION_TYPE_CLICKING_VALUE = 503;
    public static final int ACTION_TYPE_CLOSING_VALUE = 504;
    public static final int ACTION_TYPE_HB_INITIALIZING_VALUE = 701;
    public static final int ACTION_TYPE_HB_PREPARING_VALUE = 702;
    public static final int ACTION_TYPE_INVALID_VALUE = 0;
    public static final int ACTION_TYPE_REQUEST_CANCELING_VALUE = 508;
    public static final int ACTION_TYPE_REQUEST_LOADING_VALUE = 507;
    public static final int ACTION_TYPE_SESSION_INITIALIZING_VALUE = 506;
    public static final int ACTION_TYPE_SHOWING_VALUE = 501;
    public static final int ACTION_TYPE_VIEWING_VALUE = 502;
    private final int value;
    private static final Internal.EnumLiteMap<ActionType> internalValueMap = new Internal.EnumLiteMap<ActionType>() { // from class: io.bidmachine.protobuf.ActionType.1
        @Override // com.explorestack.protobuf.Internal.EnumLiteMap
        public ActionType findValueByNumber(int i) {
            return ActionType.forNumber(i);
        }
    };
    private static final ActionType[] VALUES = values();

    @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static ActionType valueOf(int i) {
        return forNumber(i);
    }

    public static ActionType forNumber(int i) {
        if (i == 0) {
            return ACTION_TYPE_INVALID;
        }
        if (i == 701) {
            return ACTION_TYPE_HB_INITIALIZING;
        }
        if (i != 702) {
            switch (i) {
                case 500:
                    return ACTION_TYPE_AD_LOADING;
                case 501:
                    return ACTION_TYPE_SHOWING;
                case 502:
                    return ACTION_TYPE_VIEWING;
                case 503:
                    return ACTION_TYPE_CLICKING;
                case 504:
                    return ACTION_TYPE_CLOSING;
                case 505:
                    return ACTION_TYPE_AD_DESTROYING;
                case 506:
                    return ACTION_TYPE_SESSION_INITIALIZING;
                case 507:
                    return ACTION_TYPE_REQUEST_LOADING;
                case 508:
                    return ACTION_TYPE_REQUEST_CANCELING;
                default:
                    return null;
            }
        }
        return ACTION_TYPE_HB_PREPARING;
    }

    public static Internal.EnumLiteMap<ActionType> internalGetValueMap() {
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
        return ExtensionsProto.getDescriptor().getEnumTypes().get(2);
    }

    public static ActionType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    ActionType(int i) {
        this.value = i;
    }
}
