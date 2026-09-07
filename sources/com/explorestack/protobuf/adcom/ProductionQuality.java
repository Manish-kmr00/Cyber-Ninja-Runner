package com.explorestack.protobuf.adcom;

import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes5.dex */
public enum ProductionQuality implements ProtocolMessageEnum {
    PRODUCTION_QUALITY_INVALID(0),
    PRODUCTION_QUALITY_PROFESSIONALLY_PRODUCED(1),
    PRODUCTION_QUALITY_PROSUMER(2),
    PRODUCTION_QUALITY_USER_GENERATED(3),
    UNRECOGNIZED(-1);

    public static final int PRODUCTION_QUALITY_INVALID_VALUE = 0;
    public static final int PRODUCTION_QUALITY_PROFESSIONALLY_PRODUCED_VALUE = 1;
    public static final int PRODUCTION_QUALITY_PROSUMER_VALUE = 2;
    public static final int PRODUCTION_QUALITY_USER_GENERATED_VALUE = 3;
    private final int value;
    private static final Internal.EnumLiteMap<ProductionQuality> internalValueMap = new Internal.EnumLiteMap<ProductionQuality>() { // from class: com.explorestack.protobuf.adcom.ProductionQuality.1
        @Override // com.explorestack.protobuf.Internal.EnumLiteMap
        public ProductionQuality findValueByNumber(int i) {
            return ProductionQuality.forNumber(i);
        }
    };
    private static final ProductionQuality[] VALUES = values();

    @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static ProductionQuality valueOf(int i) {
        return forNumber(i);
    }

    public static ProductionQuality forNumber(int i) {
        if (i == 0) {
            return PRODUCTION_QUALITY_INVALID;
        }
        if (i == 1) {
            return PRODUCTION_QUALITY_PROFESSIONALLY_PRODUCED;
        }
        if (i == 2) {
            return PRODUCTION_QUALITY_PROSUMER;
        }
        if (i != 3) {
            return null;
        }
        return PRODUCTION_QUALITY_USER_GENERATED;
    }

    public static Internal.EnumLiteMap<ProductionQuality> internalGetValueMap() {
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
        return AdcomProto.getDescriptor().getEnumTypes().get(27);
    }

    public static ProductionQuality valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    ProductionQuality(int i) {
        this.value = i;
    }
}
