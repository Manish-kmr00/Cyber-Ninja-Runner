package com.google.unity.ads;

import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: loaded from: classes12.dex */
public interface UnityRewardedInterstitialAdCallback extends UnityPaidEventListener, UnityFullScreenContentCallback {
    void onRewardedInterstitialAdFailedToLoad(LoadAdError error);

    void onRewardedInterstitialAdLoaded();

    void onUserEarnedReward(String type, float amount);
}
