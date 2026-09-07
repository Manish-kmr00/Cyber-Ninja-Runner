package com.yandex.mobile.ads.impl;

import android.util.Pair;

/* JADX INFO: loaded from: classes13.dex */
final class v01 implements ax1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f10440a;
    private final long[] b;
    private final long c;

    @Override // com.yandex.mobile.ads.impl.ax1
    public final long a() {
        return -1L;
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final boolean b() {
        return true;
    }

    private v01(long j, long[] jArr, long[] jArr2) {
        this.f10440a = jArr;
        this.b = jArr2;
        this.c = j == -9223372036854775807L ? x82.a(jArr2[jArr2.length - 1]) : j;
    }

    public static v01 a(long j, u01 u01Var, long j2) {
        int length = u01Var.f.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += (long) (u01Var.d + u01Var.f[i3]);
            j3 += (long) (u01Var.e + u01Var.g[i3]);
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new v01(j2, jArr, jArr2);
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final xw1.a b(long j) {
        long j2 = this.c;
        int i = x82.f10629a;
        Pair<Long, Long> pairA = a(x82.b(Math.max(0L, Math.min(j, j2))), this.b, this.f10440a);
        zw1 zw1Var = new zw1(x82.a(((Long) pairA.first).longValue()), ((Long) pairA.second).longValue());
        return new xw1.a(zw1Var, zw1Var);
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final long c() {
        return this.c;
    }

    @Override // com.yandex.mobile.ads.impl.ax1
    public final long a(long j) {
        return x82.a(((Long) a(j, this.f10440a, this.b).second).longValue());
    }

    private static Pair<Long, Long> a(long j, long[] jArr, long[] jArr2) {
        int iB = x82.b(jArr, j, true);
        long j2 = jArr[iB];
        long j3 = jArr2[iB];
        int i = iB + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((j4 == j2 ? 0.0d : (j - j2) / (j4 - j2)) * (jArr2[i] - j3))) + j3));
    }
}
