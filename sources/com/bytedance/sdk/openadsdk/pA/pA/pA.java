package com.bytedance.sdk.openadsdk.pA.pA;

import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes9.dex */
public class pA implements PAGBannerAdLoadListener {
    private final PAGBannerAdLoadListener pA;

    public pA(PAGBannerAdLoadListener pAGBannerAdLoadListener) {
        this.pA = pAGBannerAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.JG
    public void onError(final int i, final String str) {
        if (this.pA == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.pA.pA.1
            @Override // java.lang.Runnable
            public void run() {
                pA.this.pA.onError(i, str);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGBannerAd pAGBannerAd) {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.pA.pA.2
            @Override // java.lang.Runnable
            public void run() {
                pA.this.pA.onAdLoaded(pAGBannerAd);
            }
        });
    }
}
