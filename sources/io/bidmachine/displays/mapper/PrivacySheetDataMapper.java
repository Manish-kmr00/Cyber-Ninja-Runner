package io.bidmachine.displays.mapper;

import com.explorestack.protobuf.adcom.Ad;
import io.bidmachine.LabelData;
import io.bidmachine.PrivacySheetData;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.PrivacySheetParamsParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrivacySheetDataMapper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/bidmachine/displays/mapper/PrivacySheetDataMapper;", "", "labelDataMapper", "Lio/bidmachine/displays/mapper/LabelDataMapper;", "(Lio/bidmachine/displays/mapper/LabelDataMapper;)V", "map", "Lio/bidmachine/PrivacySheetData;", "data", "Lcom/explorestack/protobuf/adcom/Ad$Display$Native$Asset;", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PrivacySheetDataMapper {
    private final LabelDataMapper labelDataMapper;

    public PrivacySheetDataMapper(LabelDataMapper labelDataMapper) {
        Intrinsics.checkNotNullParameter(labelDataMapper, "labelDataMapper");
        this.labelDataMapper = labelDataMapper;
    }

    public final PrivacySheetData map(Ad.Display.Native.Asset data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            PrivacySheetDataMapper privacySheetDataMapper = this;
            String value = data.getData().getValue();
            Intrinsics.checkNotNullExpressionValue(value, "data.data.value");
            PrivacySheetParams json = PrivacySheetParamsParser.parseJson(value);
            if (json == null) {
                return null;
            }
            LabelDataMapper labelDataMapper = this.labelDataMapper;
            Ad.Display.Native.Asset.LabelAsset label = data.getLabel();
            Intrinsics.checkNotNullExpressionValue(label, "data.label");
            LabelData map = labelDataMapper.map(label);
            if (map == null) {
                return null;
            }
            return new PrivacySheetData(map, json);
        } catch (Throwable unused) {
            return null;
        }
    }
}
