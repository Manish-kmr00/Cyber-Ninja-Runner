package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.JG.BF;

/* JADX INFO: loaded from: classes13.dex */
public class aBv<E extends BF> implements SD<E> {
    protected com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML KZx;
    protected int ML;
    protected Context Og;
    protected com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD ZZv;
    protected BF pA;

    public aBv(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd, int i) {
        this.ML = i;
        this.Og = context;
        this.KZx = ml;
        this.ZZv = sd;
        ZZv();
    }

    public aBv(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        this(context, ml, sd, 0);
    }

    protected void ZZv() {
        this.pA = new BF(this.Og, this.ZZv.Gx());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.Og, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.Og, 100 - this.ML);
        this.pA.setLayoutParams(layoutParams);
        try {
            this.pA.setGuideText(this.ZZv.YkC());
        } catch (Throwable unused) {
        }
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
    /* JADX INFO: renamed from: ML, reason: merged with bridge method [inline-methods] */
    public E KZx() {
        return (E) this.pA;
    }
}
