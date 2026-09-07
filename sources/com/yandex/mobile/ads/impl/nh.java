package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class nh {
    public static final int a(Context context, int i) {
        int color;
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, 0);
        } catch (Exception unused) {
            color = ViewCompat.MEASURED_STATE_MASK;
        }
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }
}
