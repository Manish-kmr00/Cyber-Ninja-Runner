package com.smaato.sdk.rewarded.csm;

/* JADX INFO: loaded from: classes13.dex */
public interface SMARewardedNetworkEventListener {
    void onAdClicked();

    void onAdClosed();

    void onAdError();

    void onAdFailedToLoad();

    void onAdLoaded();

    void onAdReward();

    void onAdStarted();

    void onAdTTLExpired();
}
