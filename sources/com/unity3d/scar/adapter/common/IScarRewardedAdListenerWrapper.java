package com.unity3d.scar.adapter.common;

/* JADX INFO: loaded from: classes13.dex */
public interface IScarRewardedAdListenerWrapper extends IScarAdListenerWrapper {
    void onAdFailedToShow(int i, String str);

    void onAdImpression();

    void onAdSkipped();

    void onUserEarnedReward();
}
