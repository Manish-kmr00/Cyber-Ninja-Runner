package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
final class xk0 implements ax1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10662a;
    private final ct0 b;
    private final ct0 c;
    private long d;

    @Override // com.yandex.mobile.ads.impl.xw1
    public final boolean b() {
        return true;
    }

    public xk0(long j, long j2, long j3) {
        this.d = j;
        this.f10662a = j3;
        ct0 ct0Var = new ct0();
        this.b = ct0Var;
        ct0 ct0Var2 = new ct0();
        this.c = ct0Var2;
        ct0Var.a(0L);
        ct0Var2.a(j2);
    }

    @Override // com.yandex.mobile.ads.impl.ax1
    public final long a() {
        return this.f10662a;
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final long c() {
        return this.d;
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final xw1.a b(long j) {
        int iA = x82.a(this.b, j);
        long jA = this.b.a(iA);
        zw1 zw1Var = new zw1(jA, this.c.a(iA));
        if (jA != j && iA != this.b.a() - 1) {
            int i = iA + 1;
            return new xw1.a(zw1Var, new zw1(this.b.a(i), this.c.a(i)));
        }
        return new xw1.a(zw1Var, zw1Var);
    }

    @Override // com.yandex.mobile.ads.impl.ax1
    public final long a(long j) {
        return this.b.a(x82.a(this.c, j));
    }

    final void d(long j) {
        this.d = j;
    }

    public final boolean c(long j) {
        ct0 ct0Var = this.b;
        return j - ct0Var.a(ct0Var.a() - 1) < 100000;
    }

    public final void a(long j, long j2) {
        if (c(j)) {
            return;
        }
        this.b.a(j);
        this.c.a(j2);
    }
}
