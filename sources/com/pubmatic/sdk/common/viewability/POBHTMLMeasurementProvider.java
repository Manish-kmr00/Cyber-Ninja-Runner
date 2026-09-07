package com.pubmatic.sdk.common.viewability;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes5.dex */
public interface POBHTMLMeasurementProvider extends POBMeasurementProvider {

    public enum POBHTMLAdEventType {
        LOADED,
        IMPRESSION,
        CLICK,
        ACCEPT_INVITATION
    }

    void signalAdEvent(POBHTMLAdEventType pOBHTMLAdEventType);

    void startAdSession(WebView webView);
}
