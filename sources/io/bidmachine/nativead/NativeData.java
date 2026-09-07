package io.bidmachine.nativead;

import io.bidmachine.LabelData;
import io.bidmachine.PrivacySheetData;

/* JADX INFO: loaded from: classes13.dex */
public interface NativeData extends NativePublicData {
    LabelData getAdLabelData();

    String getClickUrl();

    PrivacySheetData getPrivacySheetData();

    String getVideoAdm();

    String getVideoUrl();
}
