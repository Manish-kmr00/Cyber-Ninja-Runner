package io.bidmachine.displays.mapper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.explorestack.protobuf.adcom.Ad;
import com.explorestack.protobuf.adcom.NativeAssetPosition;
import io.bidmachine.LabelData;
import io.bidmachine.PositionData;
import io.bidmachine.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: LabelDataMapper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/bidmachine/displays/mapper/LabelDataMapper;", "", "positionDataMapper", "Lio/bidmachine/displays/mapper/PositionDataMapper;", "(Lio/bidmachine/displays/mapper/PositionDataMapper;)V", "map", "Lio/bidmachine/LabelData;", "data", "Lcom/explorestack/protobuf/adcom/Ad$Display$Native$Asset$LabelAsset;", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LabelDataMapper {
    private final PositionDataMapper positionDataMapper;

    public LabelDataMapper(PositionDataMapper positionDataMapper) {
        Intrinsics.checkNotNullParameter(positionDataMapper, "positionDataMapper");
        this.positionDataMapper = positionDataMapper;
    }

    public final LabelData map(Ad.Display.Native.Asset.LabelAsset data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            LabelDataMapper labelDataMapper = this;
            PositionDataMapper positionDataMapper = this.positionDataMapper;
            NativeAssetPosition pos = data.getPos();
            Intrinsics.checkNotNullExpressionValue(pos, "data.pos");
            PositionData map = positionDataMapper.map(pos);
            if (map == null) {
                return null;
            }
            String content = data.getContent();
            Intrinsics.checkNotNullExpressionValue(content, "data.content");
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] bArrDecodeBase64$default = UtilsKt.decodeBase64$default(bytes, 0, 1, null);
            if (bArrDecodeBase64$default == null) {
                return null;
            }
            Bitmap image = BitmapFactory.decodeByteArray(bArrDecodeBase64$default, 0, bArrDecodeBase64$default.length);
            float w = data.getW();
            float h = data.getH();
            Intrinsics.checkNotNullExpressionValue(image, "image");
            return new LabelData(w, h, image, map);
        } catch (Throwable unused) {
            return null;
        }
    }
}
