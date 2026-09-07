package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes12.dex */
public class ML extends aBv<com.bytedance.sdk.component.adexpress.JG.SD> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.aBv
    protected void ZZv() {
    }

    public ML(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        super(context, ml, sd);
        pA(sd);
    }

    private void pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        this.pA = new com.bytedance.sdk.component.adexpress.JG.omh(this.Og);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.pA.setLayoutParams(layoutParams);
        if (this.pA instanceof com.bytedance.sdk.component.adexpress.JG.omh) {
            ((com.bytedance.sdk.component.adexpress.JG.omh) this.pA).setButtonText(this.ZZv.YkC());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.aBv, com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void pA() {
        this.pA.pA();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.aBv, com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void Og() {
        this.pA.Og();
    }
}
