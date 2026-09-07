package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes12.dex */
public class KZx implements SD {
    com.bytedance.sdk.component.adexpress.JG.ML pA;

    public KZx(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        this.pA = new com.bytedance.sdk.component.adexpress.JG.ML(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ml.getDynamicHeight(), ml.getDynamicHeight());
        layoutParams.gravity = 17;
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
    public com.bytedance.sdk.component.adexpress.JG.ML KZx() {
        return this.pA;
    }
}
