package com.smaato.sdk.richmedia.mraid.dataprovider;

import android.content.Context;
import android.webkit.WebView;
import com.smaato.sdk.core.SdkConfiguration;
import com.smaato.sdk.core.gdpr.SomaGdprDataSource;
import com.smaato.sdk.core.lgpd.SomaLgpdDataSource;
import com.smaato.sdk.core.util.AppMetaData;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.richmedia.util.DeviceUtils;
import java.util.ArrayList;
import java.util.List;
import net.pubnative.lite.sdk.mraid.MRAIDNativeFeature;

/* JADX INFO: loaded from: classes8.dex */
public final class MraidSupportsProperties {
    private final AppMetaData appMetaData;
    private final SdkConfiguration sdkConfiguration;
    private final SomaGdprDataSource somaGdprDataSource;
    private final SomaLgpdDataSource somaLgpdDataSource;

    public MraidSupportsProperties(AppMetaData appMetaData, SdkConfiguration sdkConfiguration, SomaGdprDataSource somaGdprDataSource, SomaLgpdDataSource somaLgpdDataSource) {
        this.appMetaData = (AppMetaData) Objects.requireNonNull(appMetaData);
        this.sdkConfiguration = (SdkConfiguration) Objects.requireNonNull(sdkConfiguration);
        this.somaGdprDataSource = (SomaGdprDataSource) Objects.requireNonNull(somaGdprDataSource);
        this.somaLgpdDataSource = (SomaLgpdDataSource) Objects.requireNonNull(somaLgpdDataSource);
    }

    public List<String> getSupportedFeatures(Context context, WebView webView) {
        ArrayList arrayList = new ArrayList();
        if (DeviceUtils.isSmsAvailable(context)) {
            arrayList.add("sms");
        }
        if (DeviceUtils.isTelAvailable(context)) {
            arrayList.add("tel");
        }
        if (DeviceUtils.isInlineVideoSupported(context, webView)) {
            arrayList.add("inlineVideo");
        }
        return arrayList;
    }

    public String[] getAllMraidFeatures() {
        return new String[]{"sms", "tel", "calendar", "storePicture", "inlineVideo", "location", MRAIDNativeFeature.VPAID};
    }
}
