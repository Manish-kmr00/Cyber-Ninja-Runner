package com.bytedance.sdk.openadsdk.pA.KZx;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes.dex */
public class pA implements PAGInterstitialAdLoadListener {
    private final PAGInterstitialAdLoadListener pA;

    public pA(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        this.pA = pAGInterstitialAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.JG
    public void onError(final int i, final String str) {
        if (this.pA == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.KZx.pA.1
            @Override // java.lang.Runnable
            public void run() {
                if (pA.this.pA != null) {
                    pA.this.pA.onError(i, str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGInterstitialAd pAGInterstitialAd) {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.KZx.pA.2
            @Override // java.lang.Runnable
            public void run() {
                if (pA.this.pA != null) {
                    pA.this.pA.onAdLoaded(pAGInterstitialAd);
                }
            }
        });
    }
}
