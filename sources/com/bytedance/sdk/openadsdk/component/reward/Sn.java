package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* JADX INFO: loaded from: classes13.dex */
class Sn implements TTClientBidding {
    private final omh pA;

    Sn(Context context, com.bytedance.sdk.openadsdk.core.model.pA pAVar, AdSlot adSlot) {
        this.pA = new omh(context, pAVar, adSlot);
    }

    public omh pA() {
        return this.pA;
    }

    public void Og() {
        this.pA.pA();
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        this.pA.win(d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        this.pA.loss(d, str, str2);
    }
}
