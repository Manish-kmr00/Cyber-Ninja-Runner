package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.StatFs;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class f01 {

    public static final class a {
        @JvmStatic
        public static long a(Context context, long j, long j2) {
            long availableBlocks;
            Intrinsics.checkNotNullParameter(context, "context");
            long jCoerceAtMost = RangesKt.coerceAtMost(j, j2);
            try {
                StatFs statFs = new StatFs(o10.a(context, "").getAbsolutePath());
                availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            } catch (IllegalArgumentException unused) {
                op0.c(new Object[0]);
                availableBlocks = jCoerceAtMost;
            }
            long j3 = 100;
            return RangesKt.coerceAtLeast(RangesKt.coerceAtMost((((long) 2) * availableBlocks) / j3, j2), RangesKt.coerceAtMost(jCoerceAtMost, (availableBlocks * ((long) 50)) / j3));
        }
    }

    public static long a() {
        Runtime runtime = Runtime.getRuntime();
        return Runtime.getRuntime().maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
    }
}
