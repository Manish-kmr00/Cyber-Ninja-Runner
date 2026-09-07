package com.bytedance.sdk.openadsdk.component.KZx;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;

/* JADX INFO: loaded from: classes12.dex */
public class pA implements com.bytedance.sdk.openadsdk.pA.KZx.Og {
    private final PAGInterstitialAdInteractionListener pA;

    public pA(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.pA = pAGInterstitialAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.pA.KZx.Og
    public void pA() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.pA;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdShowed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.pA.KZx.Og
    public void Og() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.pA;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdDismissed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.pA;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdClicked();
        }
    }
}
