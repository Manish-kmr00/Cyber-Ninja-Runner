package com.bytedance.sdk.openadsdk.pA.ZZv;

import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes9.dex */
public class pA implements PAGAppOpenAdLoadListener {
    private final PAGAppOpenAdLoadListener pA;

    public pA(PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
        this.pA = pAGAppOpenAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.JG
    public void onError(final int i, final String str) {
        if (this.pA == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.ZZv.pA.1
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
    public void onAdLoaded(final PAGAppOpenAd pAGAppOpenAd) {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.ZZv.pA.2
            @Override // java.lang.Runnable
            public void run() {
                if (pA.this.pA != null) {
                    pA.this.pA.onAdLoaded(pAGAppOpenAd);
                }
            }
        });
    }
}
