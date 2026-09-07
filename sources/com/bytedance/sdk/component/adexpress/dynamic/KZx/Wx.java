package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes12.dex */
public class Wx implements SD {
    private com.bytedance.sdk.component.adexpress.JG.DX pA;

    public Wx(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        this.pA = new com.bytedance.sdk.component.adexpress.JG.DX(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ml.getDynamicHeight(), ml.getDynamicHeight());
        layoutParams.gravity = 8388629;
        this.pA.setLayoutParams(layoutParams);
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
    public com.bytedance.sdk.component.adexpress.JG.DX KZx() {
        return this.pA;
    }
}
