package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes4.dex */
public class tr implements xw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10327a;
    private final long b;
    private final int c;
    private final long d;
    private final int e;
    private final long f;
    private final boolean g;

    public tr(int i, int i2, long j, long j2, boolean z) {
        this.f10327a = j;
        this.b = j2;
        this.c = i2 == -1 ? 1 : i2;
        this.e = i;
        this.g = z;
        if (j == -1) {
            this.d = -1L;
            this.f = -9223372036854775807L;
        } else {
            this.d = j - j2;
            this.f = a(i, j, j2);
        }
    }

    public long a(long j) {
        return c(j);
    }

    private static long a(int i, long j, long j2) {
        return (Math.max(0L, j - j2) * 8000000) / ((long) i);
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final xw1.a b(long j) {
        long j2 = this.d;
        if (j2 == -1 && !this.g) {
            zw1 zw1Var = new zw1(0L, this.b);
            return new xw1.a(zw1Var, zw1Var);
        }
        long j3 = (((long) this.e) * j) / 8000000;
        long j4 = this.c;
        long jMin = (j3 / j4) * j4;
        if (j2 != -1) {
            jMin = Math.min(jMin, j2 - j4);
        }
        long jMax = Math.max(jMin, 0L);
        long j5 = this.b;
        long j6 = jMax + j5;
        long jA = a(this.e, j6, j5);
        zw1 zw1Var2 = new zw1(jA, j6);
        if (this.d != -1 && jA < j) {
            long j7 = j6 + ((long) this.c);
            if (j7 < this.f10327a) {
                return new xw1.a(zw1Var2, new zw1(a(this.e, j7, this.b), j7));
            }
        }
        return new xw1.a(zw1Var2, zw1Var2);
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final long c() {
        return this.f;
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final boolean b() {
        return this.d != -1 || this.g;
    }

    public final long c(long j) {
        return a(this.e, j, this.b);
    }
}
