package com.five_corp.ad.internal.view;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes10.dex */
public abstract class J {
    public static int a(String str) {
        try {
            if (!str.startsWith("#")) {
                str = "#".concat(str);
            }
            return Color.parseColor(str);
        } catch (Throwable unused) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
    }

    public static void a(View view) {
        ViewParent parent;
        if (view == null || (parent = view.getParent()) == null || !(parent instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) parent).removeView(view);
    }

    public static void a(TextView textView, GradientDrawable gradientDrawable) {
        textView.setBackground(gradientDrawable);
    }
}
