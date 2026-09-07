package com.bytedance.sdk.openadsdk.pA.Og;

import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes10.dex */
public class SD implements JG {
    private final PAGNativeAdInteractionListener pA;

    public SD(PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        this.pA = pAGNativeAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.Og.SD.1
            @Override // java.lang.Runnable
            public void run() {
                if (SD.this.pA != null) {
                    SD.this.pA.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.pA.Og.JG
    public void pA(PAGNativeAd pAGNativeAd) {
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.Og.SD.2
            @Override // java.lang.Runnable
            public void run() {
                if (SD.this.pA != null) {
                    SD.this.pA.onAdShowed();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.pA.Og.JG
    public void pA() {
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.Og.SD.3
            @Override // java.lang.Runnable
            public void run() {
                if (SD.this.pA != null) {
                    SD.this.pA.onAdDismissed();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.pA.Og.JG
    public boolean Og() {
        return this.pA != null;
    }
}
