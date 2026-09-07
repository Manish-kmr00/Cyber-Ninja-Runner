package com.bytedance.adsdk.ugeno.JG.Og;

import android.view.View;
import com.bytedance.adsdk.ugeno.omh.KZx;

/* JADX INFO: loaded from: classes11.dex */
public class pA implements KZx.ML {
    final float pA = 0.8f;
    final float Og = 0.5f;

    @Override // com.bytedance.adsdk.ugeno.omh.KZx.ML
    public void pA(View view, float f) {
        float f2 = ((f < 0.0f ? 0.19999999f : -0.19999999f) * f) + 1.0f;
        float f3 = (f * (f < 0.0f ? 0.5f : -0.5f)) + 1.0f;
        if (f < 0.0f) {
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight() / 2);
        } else {
            view.setPivotX(0.0f);
            view.setPivotY(view.getHeight() / 2);
        }
        view.setScaleX(f2);
        view.setScaleY(f2);
        view.setAlpha(Math.abs(f3));
    }
}
