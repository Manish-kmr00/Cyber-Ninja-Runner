package com.smaato.sdk.interstitial;

/* JADX INFO: loaded from: classes8.dex */
public interface EventListener {
    void onAdClicked(InterstitialAd interstitialAd);

    void onAdClosed(InterstitialAd interstitialAd);

    void onAdError(InterstitialAd interstitialAd, InterstitialError interstitialError);

    void onAdFailedToLoad(InterstitialRequestError interstitialRequestError);

    void onAdImpression(InterstitialAd interstitialAd);

    void onAdLoaded(InterstitialAd interstitialAd);

    void onAdOpened(InterstitialAd interstitialAd);

    void onAdTTLExpired(InterstitialAd interstitialAd);

    default void onCompanionAdClicked(InterstitialAd interstitialAd) {
    }

    default void onCompanionAdImpressed(InterstitialAd interstitialAd) {
    }
}
