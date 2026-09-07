package com.pubmatic.sdk.common.viewability;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface POBNativeMeasurementProvider extends POBMeasurementProvider {

    public enum POBNativeAdEventType {
        LOADED,
        IMPRESSION
    }

    public interface POBOmidSessionListener {
        void onOmidSessionInitializationFailed();

        void onOmidSessionInitialized();
    }

    void signalAdEvent(POBNativeAdEventType pOBNativeAdEventType);

    void startAdSession(View view, List<? extends POBVerificationScriptResource> list, POBOmidSessionListener pOBOmidSessionListener);
}
