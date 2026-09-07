package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* JADX INFO: loaded from: classes13.dex */
class Wx implements TTClientBidding {
    private final JG pA;

    Wx(Context context, com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        this.pA = new JG(context, pAVar);
    }

    public JG pA() {
        return this.pA;
    }

    public void pA(boolean z) {
        this.pA.pA(z);
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
