package com.bytedance.sdk.component.adexpress.ZZv;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes12.dex */
public class KZx {
    public static Drawable pA(Context context, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        if (context == null || sd == null) {
            return null;
        }
        return pA(context, (int) omh.pA(context, sd.aBv()), sd.oX(), sd.roi());
    }

    public static Drawable pA(Context context, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i, i2);
        }
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }
}
