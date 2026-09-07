package com.explorestack.protobuf.adcom;

import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes3.dex */
public enum MediaRating implements ProtocolMessageEnum {
    MEDIA_RATING_INVALID(0),
    MEDIA_RATING_ALL_AUDIENCES(1),
    MEDIA_RATING_EVERYONE_OVER_AGE_12(2),
    MEDIA_RATING_MATURE_AUDIENCES(3),
    UNRECOGNIZED(-1);

    public static final int MEDIA_RATING_ALL_AUDIENCES_VALUE = 1;
    public static final int MEDIA_RATING_EVERYONE_OVER_AGE_12_VALUE = 2;
    public static final int MEDIA_RATING_INVALID_VALUE = 0;
    public static final int MEDIA_RATING_MATURE_AUDIENCES_VALUE = 3;
    private final int value;
    private static final Internal.EnumLiteMap<MediaRating> internalValueMap = new Internal.EnumLiteMap<MediaRating>() { // from class: com.explorestack.protobuf.adcom.MediaRating.1
        @Override // com.explorestack.protobuf.Internal.EnumLiteMap
        public MediaRating findValueByNumber(int i) {
            return MediaRating.forNumber(i);
        }
    };
    private static final MediaRating[] VALUES = values();

    @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static MediaRating valueOf(int i) {
        return forNumber(i);
    }

    public static MediaRating forNumber(int i) {
        if (i == 0) {
            return MEDIA_RATING_INVALID;
        }
        if (i == 1) {
            return MEDIA_RATING_ALL_AUDIENCES;
        }
        if (i == 2) {
            return MEDIA_RATING_EVERYONE_OVER_AGE_12;
        }
        if (i != 3) {
            return null;
        }
        return MEDIA_RATING_MATURE_AUDIENCES;
    }

    public static Internal.EnumLiteMap<MediaRating> internalGetValueMap() {
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
        return AdcomProto.getDescriptor().getEnumTypes().get(19);
    }

    public static MediaRating valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[enumValueDescriptor.getIndex()];
    }

    MediaRating(int i) {
        this.value = i;
    }
}
