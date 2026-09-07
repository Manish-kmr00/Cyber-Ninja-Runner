package com.google.unity.ads;

import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: loaded from: classes13.dex */
public interface UnityRewardedAdCallback extends UnityPaidEventListener, UnityFullScreenContentCallback {
    void onRewardedAdFailedToLoad(LoadAdError error);

    void onRewardedAdLoaded();

    void onUserEarnedReward(String type, float amount);
}
