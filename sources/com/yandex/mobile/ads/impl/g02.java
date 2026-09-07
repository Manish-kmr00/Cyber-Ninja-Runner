package com.yandex.mobile.ads.impl;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class g02 {
    public static final float a(c02 c02Var, RectF view, RectF image) {
        Intrinsics.checkNotNullParameter(c02Var, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(image, "image");
        float fHeight = view.height();
        float fWidth = view.width();
        float fHeight2 = image.height();
        float fWidth2 = image.width();
        if (fHeight == 0.0f || fWidth == 0.0f || fHeight2 == 0.0f || fWidth2 == 0.0f) {
            return Float.MAX_VALUE;
        }
        float fMin = Math.min(1.0f, fWidth2 / fHeight2 > fWidth / fHeight ? fHeight / fHeight2 : fWidth / fWidth2);
        if (fWidth < ((int) (c02Var.c() * fMin)) || fHeight < ((int) (c02Var.b() * fMin))) {
            return Float.MAX_VALUE;
        }
        return Math.abs(fHeight - (c02Var.b() * fMin)) + Math.abs(fWidth - (c02Var.c() * fMin));
    }
}
