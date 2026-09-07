package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
public final class jt1 implements ij {
    @Override // com.yandex.mobile.ads.impl.ij
    public final int a(Context context, int i, gf1 orientation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return MathKt.roundToInt(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(orientation == gf1.c ? 90.0f : 100.0f, oh2.a(context, orientation) * 0.15f), 50.0f));
    }
}
