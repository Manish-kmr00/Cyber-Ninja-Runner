package io.bidmachine.protobuf;

import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes12.dex */
public enum OSExecutionEnvironment implements ProtocolMessageEnum {
    OS_EXECUTION_ENVIRONMENT_UNKNOWN(0),
    OS_EXECUTION_ENVIRONMENT_MAC_CATALYST(1),
    OS_EXECUTION_ENVIRONMENT_MAC_IOS(2),
    OS_EXECUTION_ENVIRONMENT_NATIVE_IOS(3),
    UNRECOGNIZED(-1);

    public static final int OS_EXECUTION_ENVIRONMENT_MAC_CATALYST_VALUE = 1;
    public static final int OS_EXECUTION_ENVIRONMENT_MAC_IOS_VALUE = 2;
    public static final int OS_EXECUTION_ENVIRONMENT_NATIVE_IOS_VALUE = 3;
    public static final int OS_EXECUTION_ENVIRONMENT_UNKNOWN_VALUE = 0;
    private final int value;
    private static final Internal.EnumLiteMap<OSExecutionEnvironment> internalValueMap = new Internal.EnumLiteMap<OSExecutionEnvironment>() { // from class: io.bidmachine.protobuf.OSExecutionEnvironment.1
        @Override // com.explorestack.protobuf.Internal.EnumLiteMap
        public OSExecutionEnvironment findValueByNumber(int i) {
            return OSExecutionEnvironment.forNumber(i);
        }
    };
    private static final OSExecutionEnvironment[] VALUES = values();

    @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static OSExecutionEnvironment valueOf(int i) {
        return forNumber(i);
    }

    public static OSExecutionEnvironment forNumber(int i) {
        if (i == 0) {
            return OS_EXECUTION_ENVIRONMENT_UNKNOWN;
        }
        if (i == 1) {
            return OS_EXECUTION_ENVIRONMENT_MAC_CATALYST;
        }
        if (i == 2) {
            return OS_EXECUTION_ENVIRONMENT_MAC_IOS;
        }
        if (i != 3) {
            return null;
        }
        return OS_EXECUTION_ENVIRONMENT_NATIVE_IOS;
    }

    public static Internal.EnumLiteMap<OSExecutionEnvironment> internalGetValueMap() {
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
        return InitProto.getDescriptor().getEnumTypes().get(0);
    }

    public static OSExecutionEnvironment valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    OSExecutionEnvironment(int i) {
        this.value = i;
    }
}
