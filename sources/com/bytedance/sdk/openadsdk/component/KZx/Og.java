package com.bytedance.sdk.openadsdk.component.KZx;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes10.dex */
public class Og implements PAGInterstitialAdLoadListener {
    final PAGInterstitialAdLoadListener pA;

    public Og(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        this.pA = pAGInterstitialAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.JG
    public void onError(final int i, final String str) {
        if (this.pA != null) {
            xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.KZx.Og.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Og.this.pA != null) {
                        Og.this.pA.onError(i, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGInterstitialAd pAGInterstitialAd) {
        if (this.pA != null) {
            xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.KZx.Og.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Og.this.pA != null) {
                        Og.this.pA.onAdLoaded(pAGInterstitialAd);
                    }
                }
            });
        }
    }
}
