package com.smaato.sdk.rewarded;

import com.smaato.sdk.interstitial.InterstitialAdBase;

/* JADX INFO: loaded from: classes12.dex */
public abstract class RewardedInterstitialAd extends InterstitialAdBase {
    protected abstract void showAdInternal();

    public final void showAd() {
        showAdInternal();
    }
}
