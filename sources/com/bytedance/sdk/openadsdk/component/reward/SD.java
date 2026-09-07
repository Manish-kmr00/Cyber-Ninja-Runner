package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes9.dex */
public class SD implements PAGRewardedAdLoadListener {
    final PAGRewardedAdLoadListener pA;

    public SD(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.pA = pAGRewardedAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.JG
    public void onError(final int i, final String str) {
        if (this.pA != null) {
            xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.SD.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SD.this.pA != null) {
                        SD.this.pA.onError(i, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGRewardedAd pAGRewardedAd) {
        if (this.pA != null) {
            xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.SD.2
                @Override // java.lang.Runnable
                public void run() {
                    if (SD.this.pA != null) {
                        SD.this.pA.onAdLoaded(pAGRewardedAd);
                    }
                }
            });
        }
    }
}
