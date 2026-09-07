package com.bytedance.sdk.openadsdk.pA.Og.pA;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.omh.XT;

/* JADX INFO: loaded from: classes9.dex */
public class Og extends KZx {
    public Og(Context context, yFO yfo, AdSlot adSlot) {
        super(context, yfo, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.pA.Og.pA.KZx
    protected void pA() {
        this.SGo = new XT(this.omh, this.Og, this.Bzk, this.BSW);
        this.pA.pA(((XT) this.SGo).getVideoController());
        KZx();
    }

    public com.bytedance.sdk.openadsdk.multipro.Og.pA Og() {
        if (this.SGo != null) {
            return ((XT) this.SGo).getVideoModel();
        }
        return null;
    }
}
