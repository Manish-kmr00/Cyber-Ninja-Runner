package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes12.dex */
public class Sn implements SD<com.bytedance.sdk.component.adexpress.JG.oX> {
    private com.bytedance.sdk.component.adexpress.JG.oX pA;

    public Sn(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        this.pA = new com.bytedance.sdk.component.adexpress.JG.oX(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, 180.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, 20.0f);
        this.pA.setLayoutParams(layoutParams);
        this.pA.setGuideText(sd.YkC());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void pA() {
        this.pA.pA();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void Og() {
        this.pA.Og();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    /* JADX INFO: renamed from: ZZv, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.JG.oX KZx() {
        return this.pA;
    }
}
