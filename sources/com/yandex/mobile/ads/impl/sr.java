package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class sr implements ij {
    @Override // com.yandex.mobile.ads.impl.ij
    public final int a(Context context, int i, gf1 orientation) {
        int iRoundToInt;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        float fCoerceAtMost = RangesKt.coerceAtMost(100.0f, oh2.a(context, orientation) * 0.15f);
        if (i > 655) {
            iRoundToInt = MathKt.roundToInt((((double) i) / 728.0d) * 90.0d);
        } else if (i > 632) {
            iRoundToInt = 81;
        } else if (i > 526) {
            iRoundToInt = MathKt.roundToInt((((double) i) / 468.0d) * 60.0d);
        } else {
            iRoundToInt = i > 432 ? 68 : MathKt.roundToInt((((double) i) / 320.0d) * 50.0d);
        }
        return RangesKt.coerceAtLeast(RangesKt.coerceAtMost(iRoundToInt, (int) fCoerceAtMost), 50);
    }
}
