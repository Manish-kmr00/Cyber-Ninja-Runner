package com.ogury.ad.internal;

import android.content.res.Resources;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
public final class j7 {
    public static final int a(int i) {
        return MathKt.roundToInt(i * Resources.getSystem().getDisplayMetrics().density);
    }

    public static final int b(int i) {
        return MathKt.roundToInt(i / Resources.getSystem().getDisplayMetrics().density);
    }

    public static final int a(float f) {
        return (int) (f / Resources.getSystem().getDisplayMetrics().density);
    }
}
