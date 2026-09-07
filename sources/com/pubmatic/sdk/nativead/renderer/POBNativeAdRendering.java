package com.pubmatic.sdk.nativead.renderer;

import android.view.View;
import com.pubmatic.sdk.common.viewability.POBNativeMeasurementProvider;
import com.pubmatic.sdk.nativead.response.POBNativeAdResponse;
import com.pubmatic.sdk.nativead.views.POBNativeTemplateView;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface POBNativeAdRendering {
    void destroy();

    void enableDsaIcon(boolean z);

    void registerView(POBNativeAdResponse pOBNativeAdResponse, View view, List<View> list);

    void renderAd(POBNativeAdResponse pOBNativeAdResponse, POBNativeTemplateView pOBNativeTemplateView);

    void setAdRendererListener(POBNativeRendererListener pOBNativeRendererListener);

    void setNativeMeasurementProvider(POBNativeMeasurementProvider pOBNativeMeasurementProvider);
}
