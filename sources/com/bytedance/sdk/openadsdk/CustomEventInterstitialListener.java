package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes7.dex */
public interface CustomEventInterstitialListener {
    void onInterstitialClicked();

    void onInterstitialDismissed();

    void onInterstitialImpression();

    void onInterstitialShowFail();

    void onInterstitialShown();

    void onLeaveApplication();
}
