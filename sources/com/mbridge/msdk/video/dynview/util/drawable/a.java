package com.mbridge.msdk.video.dynview.util.drawable;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.mbridge.msdk.foundation.tools.t0;

/* JADX INFO: compiled from: UIDrawableUtil.java */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public static void a(View view, int i, int i2, String str, String str2) {
        if (view != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.parseColor(str2));
            gradientDrawable.setCornerRadius(t0.a(view.getContext(), i2));
            gradientDrawable.setStroke(t0.a(view.getContext(), i), Color.parseColor(str));
            view.setBackground(gradientDrawable);
        }
    }

    public static void a(View view, float f, float f2, String str, String[] strArr, GradientDrawable.Orientation orientation) {
        if (view == null || strArr == null) {
            return;
        }
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = Color.parseColor(strArr[i]);
        }
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
        gradientDrawable.setCornerRadius(t0.a(view.getContext(), f2));
        gradientDrawable.setStroke(t0.a(view.getContext(), f), Color.parseColor(str));
        view.setBackground(gradientDrawable);
    }
}
