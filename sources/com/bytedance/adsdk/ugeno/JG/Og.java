package com.bytedance.adsdk.ugeno.JG;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public class Og extends pA<com.bytedance.adsdk.ugeno.Og.KZx> {
    private com.bytedance.adsdk.ugeno.KZx KZx;

    public Og(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.JG.pA
    public View SD(int i) {
        return ((com.bytedance.adsdk.ugeno.Og.KZx) this.pA.get(i)).Bzk();
    }

    public void pA(com.bytedance.adsdk.ugeno.KZx kZx) {
        this.KZx = kZx;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.KZx kZx = this.KZx;
        if (kZx != null) {
            int[] iArrPA = kZx.pA(i, i2);
            super.onMeasure(iArrPA[0], iArrPA[1]);
        } else {
            super.onMeasure(i, i2);
        }
        com.bytedance.adsdk.ugeno.KZx kZx2 = this.KZx;
        if (kZx2 != null) {
            kZx2.ML();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.KZx kZx = this.KZx;
        if (kZx != null) {
            kZx.JG();
        }
        super.onLayout(z, i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.KZx kZx2 = this.KZx;
        if (kZx2 != null) {
            kZx2.pA(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.KZx kZx = this.KZx;
        if (kZx != null) {
            kZx.SD();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.KZx kZx = this.KZx;
        if (kZx != null) {
            kZx.omh();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.KZx kZx = this.KZx;
        if (kZx != null) {
            kZx.Og(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
