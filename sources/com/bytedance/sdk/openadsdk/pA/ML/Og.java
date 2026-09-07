package com.bytedance.sdk.openadsdk.pA.ML;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes11.dex */
public class Og implements PAGRewardedAdLoadListener {
    private final PAGRewardedAdLoadListener pA;

    public Og(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.pA = pAGRewardedAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.JG
    public void onError(final int i, final String str) {
        if (this.pA == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.ML.Og.1
            @Override // java.lang.Runnable
            public void run() {
                if (Og.this.pA != null) {
                    Og.this.pA.onError(i, str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGRewardedAd pAGRewardedAd) {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.ML.Og.2
            @Override // java.lang.Runnable
            public void run() {
                if (Og.this.pA != null) {
                    Og.this.pA.onAdLoaded(pAGRewardedAd);
                }
            }
        });
    }
}
