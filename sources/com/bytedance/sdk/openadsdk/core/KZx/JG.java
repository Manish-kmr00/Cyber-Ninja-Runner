package com.bytedance.sdk.openadsdk.core.KZx;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes12.dex */
public class JG extends ZZv {
    public JG(Context context, yFO yfo, AdSlot adSlot) {
        super(context, yfo, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.KZx.ZZv
    public void pA(Context context, yFO yfo, AdSlot adSlot) {
        this.pA = new Og(context, yfo, adSlot);
        this.pA.addOnAttachStateChangeListener(this.JG);
    }

    public com.bytedance.sdk.openadsdk.multipro.Og.pA KZx() {
        if (this.pA != null) {
            return ((Og) this.pA).getVideoModel();
        }
        return null;
    }
}
