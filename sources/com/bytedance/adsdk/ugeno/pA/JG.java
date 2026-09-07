package com.bytedance.adsdk.ugeno.pA;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class JG implements ML {
    private float JG;
    private float KZx;
    private float ML;
    private float Og;
    private float ZZv;
    private View pA;

    public JG(View view) {
        this.pA = view;
    }

    public void pA(float f) {
        View view = this.pA;
        if (view == null) {
            return;
        }
        this.Og = f;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f);
        }
    }

    public float pA() {
        return this.Og;
    }

    public void Og(float f) {
        View view = this.pA;
        if (view == null) {
            return;
        }
        this.KZx = f;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getRipple() {
        return this.KZx;
    }

    public void KZx(float f) {
        View view = this.pA;
        if (view == null) {
            return;
        }
        this.ZZv = f;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getShine() {
        return this.ZZv;
    }

    public void ZZv(float f) {
        this.ML = f;
        this.pA.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getStretch() {
        return this.ML;
    }

    public void ML(float f) {
        this.JG = f;
        this.pA.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getRubIn() {
        return this.JG;
    }

    public void pA(int i) {
        View view = this.pA;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i);
        }
    }
}
