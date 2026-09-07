package com.bytedance.sdk.openadsdk.pA.Og;

import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes5.dex */
public class ML implements PAGNativeAdLoadListener {
    private final PAGNativeAdLoadListener pA;

    public ML(PAGNativeAdLoadListener pAGNativeAdLoadListener) {
        this.pA = pAGNativeAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.JG
    public void onError(final int i, final String str) {
        if (this.pA == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.Og.ML.1
            @Override // java.lang.Runnable
            public void run() {
                ML.this.pA.onError(i, str);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGNativeAd pAGNativeAd) {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.Og.ML.2
            @Override // java.lang.Runnable
            public void run() {
                ML.this.pA.onAdLoaded(pAGNativeAd);
            }
        });
    }
}
