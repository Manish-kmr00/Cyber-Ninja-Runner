package com.bytedance.sdk.openadsdk.component;

import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class ML implements com.bytedance.sdk.openadsdk.pA.ZZv.Og {
    private final AtomicBoolean Og = new AtomicBoolean(false);
    private final PAGAppOpenAdInteractionListener pA;

    public ML(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.pA = pAGAppOpenAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.pA.ZZv.Og
    public void pA() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.pA;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdShowed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.pA;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.pA.ZZv.Og
    public void Og() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener;
        if (this.Og.getAndSet(true) || (pAGAppOpenAdInteractionListener = this.pA) == null) {
            return;
        }
        pAGAppOpenAdInteractionListener.onAdDismissed();
    }

    @Override // com.bytedance.sdk.openadsdk.pA.ZZv.Og
    public void KZx() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener;
        if (this.Og.getAndSet(true) || (pAGAppOpenAdInteractionListener = this.pA) == null) {
            return;
        }
        pAGAppOpenAdInteractionListener.onAdDismissed();
    }
}
