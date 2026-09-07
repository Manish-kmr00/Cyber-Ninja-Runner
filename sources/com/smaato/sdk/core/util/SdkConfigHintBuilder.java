package com.smaato.sdk.core.util;

import com.smaato.sdk.core.ad.AdFormat;
import io.bidmachine.iab.vast.tags.VastTagName;

/* JADX INFO: loaded from: classes10.dex */
public class SdkConfigHintBuilder {

    /* JADX INFO: renamed from: com.smaato.sdk.core.util.SdkConfigHintBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$core$ad$AdFormat;

        static {
            int[] iArr = new int[AdFormat.values().length];
            $SwitchMap$com$smaato$sdk$core$ad$AdFormat = iArr;
            try {
                iArr[AdFormat.RICH_MEDIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdFormat[AdFormat.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String buildSdkModuleMissedHintForAdFormat(AdFormat adFormat) {
        String str;
        String str2;
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$core$ad$AdFormat[adFormat.ordinal()];
        if (i == 1) {
            str = "Rich Media";
            str2 = "com.smaato.sdk.richmedia:module-richmedia";
        } else if (i == 2) {
            str = VastTagName.VIDEO;
            str2 = "com.smaato.sdk.vast:module-video";
        } else {
            return "";
        }
        return String.format("In order to show %s ads, add %s SOMA SDK module to your app build configuration", str, str2);
    }
}
