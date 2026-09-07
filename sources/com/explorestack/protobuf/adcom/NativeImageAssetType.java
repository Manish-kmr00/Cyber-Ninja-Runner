package com.explorestack.protobuf.adcom;

import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes13.dex */
public enum NativeImageAssetType implements ProtocolMessageEnum {
    NATIVE_IMAGE_ASSET_TYPE_INVALID(0),
    NATIVE_IMAGE_ASSET_TYPE_ICON_IMAGE(1),
    NATIVE_IMAGE_ASSET_TYPE_MAIN_IMAGE(3),
    UNRECOGNIZED(-1);

    public static final int NATIVE_IMAGE_ASSET_TYPE_ICON_IMAGE_VALUE = 1;
    public static final int NATIVE_IMAGE_ASSET_TYPE_INVALID_VALUE = 0;
    public static final int NATIVE_IMAGE_ASSET_TYPE_MAIN_IMAGE_VALUE = 3;
    private final int value;
    private static final Internal.EnumLiteMap<NativeImageAssetType> internalValueMap = new Internal.EnumLiteMap<NativeImageAssetType>() { // from class: com.explorestack.protobuf.adcom.NativeImageAssetType.1
        @Override // com.explorestack.protobuf.Internal.EnumLiteMap
        public NativeImageAssetType findValueByNumber(int i) {
            return NativeImageAssetType.forNumber(i);
        }
    };
    private static final NativeImageAssetType[] VALUES = values();

    @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static NativeImageAssetType valueOf(int i) {
        return forNumber(i);
    }

    public static NativeImageAssetType forNumber(int i) {
        if (i == 0) {
            return NATIVE_IMAGE_ASSET_TYPE_INVALID;
        }
        if (i == 1) {
            return NATIVE_IMAGE_ASSET_TYPE_ICON_IMAGE;
        }
        if (i != 3) {
            return null;
        }
        return NATIVE_IMAGE_ASSET_TYPE_MAIN_IMAGE;
    }

    public static Internal.EnumLiteMap<NativeImageAssetType> internalGetValueMap() {
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
        return AdcomProto.getDescriptor().getEnumTypes().get(21);
    }

    public static NativeImageAssetType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    NativeImageAssetType(int i) {
        this.value = i;
    }
}
