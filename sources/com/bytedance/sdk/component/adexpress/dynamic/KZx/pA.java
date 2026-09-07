package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes10.dex */
public class pA implements SD {
    private com.bytedance.sdk.component.adexpress.JG.Og pA;

    public pA(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        double dFw = sd.fw();
        dFw = dFw == 0.0d ? 1.0d : dFw;
        double dGy = sd.gy();
        double d = dGy != 0.0d ? dGy : 1.0d;
        int dynamicWidth = (int) (((double) ml.getDynamicWidth()) * 0.32d * dFw);
        int dynamicWidth2 = (int) (((double) ml.getDynamicWidth()) * 0.32d * d);
        this.pA = new com.bytedance.sdk.component.adexpress.JG.Og(context, dynamicWidth, dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicWidth, dynamicWidth2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, sd.lx() - 7);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, sd.SXO() - 3);
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
    public ViewGroup KZx() {
        return this.pA;
    }
}
