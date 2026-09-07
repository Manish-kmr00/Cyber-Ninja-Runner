package com.yandex.mobile.ads.impl;

import android.content.res.Resources;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes10.dex */
public final class x72 {
    public static final int a(int i) {
        return i >= 0 ? MathKt.roundToInt(i / Resources.getSystem().getDisplayMetrics().density) : i;
    }
}
