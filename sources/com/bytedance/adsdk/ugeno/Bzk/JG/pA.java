package com.bytedance.adsdk.ugeno.Bzk.JG;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.KZx;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.pA.JG;
import com.bytedance.adsdk.ugeno.pA.ML;

/* JADX INFO: loaded from: classes13.dex */
public class pA extends TextView implements IAnimation, ML {
    private JG KZx;
    private float Og;
    private KZx pA;

    public pA(Context context) {
        super(context);
        this.KZx = new JG(this);
    }

    public void pA(KZx kZx) {
        this.pA = kZx;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        KZx kZx = this.pA;
        if (kZx != null) {
            int[] iArrPA = kZx.pA(i, i2);
            super.onMeasure(iArrPA[0], iArrPA[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        KZx kZx = this.pA;
        if (kZx != null) {
            kZx.pA(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation, com.bytedance.adsdk.ugeno.pA.ML
    public float getRipple() {
        return this.Og;
    }

    public void setShine(float f) {
        JG jg = this.KZx;
        if (jg != null) {
            jg.KZx(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getShine() {
        return this.KZx.getShine();
    }

    public void setStretch(float f) {
        JG jg = this.KZx;
        if (jg != null) {
            jg.ZZv(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getStretch() {
        return this.KZx.getStretch();
    }

    public void setRubIn(float f) {
        JG jg = this.KZx;
        if (jg != null) {
            jg.ML(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getRubIn() {
        return this.KZx.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation
    public void setRipple(float f) {
        this.Og = f;
        JG jg = this.KZx;
        if (jg != null) {
            jg.Og(f);
        }
        postInvalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        KZx kZx = this.pA;
        if (kZx != null) {
            kZx.pA(canvas, this);
            this.pA.pA(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        KZx kZx = this.pA;
        if (kZx != null) {
            kZx.Og(i, i2, i3, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        KZx kZx = this.pA;
        if (kZx != null) {
            kZx.SD();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KZx kZx = this.pA;
        if (kZx != null) {
            kZx.omh();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setBorderRadius(float f) {
        JG jg = this.KZx;
        if (jg != null) {
            jg.pA(f);
        }
    }

    public float getBorderRadius() {
        return this.KZx.pA();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.KZx.pA(i);
    }
}
