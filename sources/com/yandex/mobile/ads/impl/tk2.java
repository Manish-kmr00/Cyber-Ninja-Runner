package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
final class tk2 implements ax1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10312a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;
    private final long[] f;

    public static tk2 a(long j, long j2, b21.a aVar, wf1 wf1Var) {
        int iX;
        int i = aVar.g;
        int i2 = aVar.d;
        int iH = wf1Var.h();
        if ((iH & 1) != 1 || (iX = wf1Var.x()) == 0) {
            return null;
        }
        long jA = x82.a(iX, ((long) i) * 1000000, i2);
        if ((iH & 6) != 6) {
            return new tk2(j2, aVar.c, jA, -1L, null);
        }
        long jV = wf1Var.v();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = wf1Var.t();
        }
        if (j != -1) {
            long j3 = j2 + jV;
            if (j != j3) {
                at0.d("XingSeeker", "XING data size mismatch: " + j + ", " + j3);
            }
        }
        return new tk2(j2, aVar.c, jA, jV, jArr);
    }

    private tk2(long j, int i, long j2, long j3, long[] jArr) {
        this.f10312a = j;
        this.b = i;
        this.c = j2;
        this.f = jArr;
        this.d = j3;
        this.e = j3 != -1 ? j + j3 : -1L;
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final xw1.a b(long j) {
        if (!b()) {
            zw1 zw1Var = new zw1(0L, this.f10312a + ((long) this.b));
            return new xw1.a(zw1Var, zw1Var);
        }
        long j2 = this.c;
        int i = x82.f10629a;
        long jMax = Math.max(0L, Math.min(j, j2));
        double d = (jMax * 100.0d) / this.c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i2 = (int) d;
                long[] jArr = this.f;
                if (jArr != null) {
                    double d3 = jArr[i2];
                    d2 = d3 + (((i2 == 99 ? 256.0d : jArr[i2 + 1]) - d3) * (d - ((double) i2)));
                } else {
                    throw new IllegalStateException();
                }
            }
        }
        zw1 zw1Var2 = new zw1(jMax, this.f10312a + Math.max(this.b, Math.min(Math.round((d2 / 256.0d) * this.d), this.d - 1)));
        return new xw1.a(zw1Var2, zw1Var2);
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final long c() {
        return this.c;
    }

    @Override // com.yandex.mobile.ads.impl.ax1
    public final long a() {
        return this.e;
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final boolean b() {
        return this.f != null;
    }

    @Override // com.yandex.mobile.ads.impl.ax1
    public final long a(long j) {
        long j2 = j - this.f10312a;
        if (!b() || j2 <= this.b) {
            return 0L;
        }
        long[] jArr = this.f;
        if (jArr != null) {
            double d = (j2 * 256.0d) / this.d;
            int iB = x82.b(jArr, (long) d, true);
            long j3 = this.c;
            long j4 = (((long) iB) * j3) / 100;
            long j5 = jArr[iB];
            int i = iB + 1;
            long j6 = (j3 * ((long) i)) / 100;
            long j7 = iB == 99 ? 256L : jArr[i];
            return Math.round((j5 == j7 ? 0.0d : (d - j5) / (j7 - j5)) * (j6 - j4)) + j4;
        }
        throw new IllegalStateException();
    }
}
