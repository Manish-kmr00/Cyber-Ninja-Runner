package com.yandex.mobile.ads.impl;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes.dex */
public final class l8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GradientDrawable f9488a;
    public static final ColorDrawable b;

    static {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#ff303030"), Color.parseColor("#ff181818"), Color.parseColor("#ff000000")});
        gradientDrawable.setCornerRadius(0.0f);
        f9488a = gradientDrawable;
        b = new ColorDrawable(Color.parseColor("#ff000000"));
    }
}
