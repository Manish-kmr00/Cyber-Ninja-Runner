package io.bidmachine.displays.mapper;

import com.explorestack.protobuf.adcom.NativeAssetPosition;
import io.bidmachine.PositionData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PositionDataMapper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lio/bidmachine/displays/mapper/PositionDataMapper;", "", "()V", "map", "Lio/bidmachine/PositionData;", "data", "Lcom/explorestack/protobuf/adcom/NativeAssetPosition;", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PositionDataMapper {

    /* JADX INFO: compiled from: PositionDataMapper.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NativeAssetPosition.values().length];
            try {
                iArr[NativeAssetPosition.ASSET_POSITION_TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NativeAssetPosition.ASSET_POSITION_TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NativeAssetPosition.ASSET_POSITION_BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NativeAssetPosition.ASSET_POSITION_BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final PositionData map(NativeAssetPosition data) {
        PositionData positionData;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            PositionDataMapper positionDataMapper = this;
            int i = WhenMappings.$EnumSwitchMapping$0[data.ordinal()];
            if (i == 1) {
                positionData = PositionData.TopLeft;
            } else if (i == 2) {
                positionData = PositionData.TopRight;
            } else if (i == 3) {
                positionData = PositionData.BottomLeft;
            } else {
                if (i != 4) {
                    return null;
                }
                positionData = PositionData.BottomRight;
            }
            return positionData;
        } catch (Throwable unused) {
            return null;
        }
    }
}
