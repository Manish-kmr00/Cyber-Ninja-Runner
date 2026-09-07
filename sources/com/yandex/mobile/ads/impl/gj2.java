package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
final class gj2 implements xw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ej2 f9012a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;

    @Override // com.yandex.mobile.ads.impl.xw1
    public final boolean b() {
        return true;
    }

    public gj2(ej2 ej2Var, int i, long j, long j2) {
        this.f9012a = ej2Var;
        this.b = i;
        this.c = j;
        long j3 = (j2 - j) / ((long) ej2Var.d);
        this.d = j3;
        this.e = c(j3);
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final xw1.a b(long j) {
        long j2 = (((long) this.f9012a.c) * j) / (((long) this.b) * 1000000);
        long j3 = this.d - 1;
        int i = x82.f10629a;
        long jMax = Math.max(0L, Math.min(j2, j3));
        long j4 = (((long) this.f9012a.d) * jMax) + this.c;
        long jC = c(jMax);
        zw1 zw1Var = new zw1(jC, j4);
        if (jC < j && jMax != this.d - 1) {
            long j5 = jMax + 1;
            return new xw1.a(zw1Var, new zw1(c(j5), (((long) this.f9012a.d) * j5) + this.c));
        }
        return new xw1.a(zw1Var, zw1Var);
    }

    private long c(long j) {
        return x82.a(j * ((long) this.b), 1000000L, this.f9012a.c);
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final long c() {
        return this.e;
    }
}
