package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes12.dex */
public class WV implements SD {
    private com.bytedance.sdk.component.adexpress.JG.Sn pA;

    public WV(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        this.pA = new com.bytedance.sdk.component.adexpress.JG.Sn(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, 180.0f));
        layoutParams.gravity = 17;
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
    public ViewGroup KZx() {
        return this.pA;
    }
}
