package com.smaato.sdk.interstitial.viewmodel;

import com.smaato.sdk.interstitial.InterstitialAdBase;

/* JADX INFO: loaded from: classes7.dex */
public interface EventListenerNotificationsInterface {
    void onAdClicked();

    void onAdClosed();

    void onAdError(Throwable th);

    void onAdLoaded();

    void onAdLoadingException(Throwable th);

    void onAdOpened();

    void onAdReward();

    void onAdStarted();

    void onAdTtlExpired();

    void onAdUnloaded();

    void onCompanionAdClicked();

    void onCompanionAdImpressed();

    void onImpression();

    void onInternalError();

    void onInvalidRequest(String str, String str2);

    void onNetworkError();

    void setAd(InterstitialAdBase interstitialAdBase);

    void setEventListener(Object obj);
}
