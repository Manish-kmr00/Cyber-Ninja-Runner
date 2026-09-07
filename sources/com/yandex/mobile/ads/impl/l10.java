package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.util.TypedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes7.dex */
public final class l10 {
    public static int a(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MathKt.roundToInt(TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()));
    }
}
