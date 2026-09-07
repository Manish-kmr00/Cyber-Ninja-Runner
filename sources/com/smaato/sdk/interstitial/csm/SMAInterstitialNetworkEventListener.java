package com.smaato.sdk.interstitial.csm;

/* JADX INFO: loaded from: classes10.dex */
public interface SMAInterstitialNetworkEventListener {
    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad();

    void onAdLoaded();

    void onAdOpened();

    void onAdTTLExpired();
}
