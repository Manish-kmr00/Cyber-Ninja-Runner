package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.JG.TX;

/* JADX INFO: loaded from: classes10.dex */
public class oX implements SD {
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML KZx;
    private Context Og;
    private com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD ZZv;
    private TX pA;

    public oX(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        this.Og = context;
        this.KZx = ml;
        this.ZZv = sd;
        ZZv();
    }

    private void ZZv() {
        this.pA = new TX(this.Og);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.Og, 120.0f));
        layoutParams.gravity = 17;
        this.pA.setLayoutParams(layoutParams);
        this.pA.setClipChildren(false);
        this.pA.setGuideText(this.ZZv.YkC());
        com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml = this.KZx;
        if (ml != null) {
            this.pA.setOnClickListener((View.OnClickListener) ml.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void pA() {
        TX tx = this.pA;
        if (tx != null) {
            tx.pA();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public void Og() {
        TX tx = this.pA;
        if (tx != null) {
            tx.Og();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.SD
    public ViewGroup KZx() {
        return this.pA;
    }
}
