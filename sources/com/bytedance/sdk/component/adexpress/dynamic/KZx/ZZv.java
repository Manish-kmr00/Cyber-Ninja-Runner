package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class ZZv extends aBv<com.bytedance.sdk.component.adexpress.JG.SD> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.aBv
    protected void ZZv() {
    }

    public ZZv(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        super(context, ml, sd);
        pA(sd);
    }

    private void pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        this.pA = new com.bytedance.sdk.component.adexpress.JG.SD(this.Og);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.Og, sd.agB());
        this.pA.setLayoutParams(layoutParams);
        this.pA.setSlideText(this.ZZv.YkC());
        if (this.pA instanceof com.bytedance.sdk.component.adexpress.JG.SD) {
            ((com.bytedance.sdk.component.adexpress.JG.SD) this.pA).setButtonText(this.ZZv.SGo());
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
