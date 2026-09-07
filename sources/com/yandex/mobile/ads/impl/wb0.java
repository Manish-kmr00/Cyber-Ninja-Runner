package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes.dex */
public final class wb0 implements xw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xb0 f10551a;
    private final long b;

    @Override // com.yandex.mobile.ads.impl.xw1
    public final boolean b() {
        return true;
    }

    public wb0(xb0 xb0Var, long j) {
        this.f10551a = xb0Var;
        this.b = j;
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final long c() {
        return this.f10551a.b();
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final xw1.a b(long j) {
        xb0 xb0Var = this.f10551a;
        xb0.a aVar = xb0Var.k;
        if (aVar != null) {
            long[] jArr = aVar.f10637a;
            long[] jArr2 = aVar.b;
            int iB = x82.b(jArr, xb0Var.a(j), false);
            long j2 = iB == -1 ? 0L : jArr[iB];
            long j3 = iB != -1 ? jArr2[iB] : 0L;
            long j4 = this.f10551a.e;
            long j5 = (j2 * 1000000) / j4;
            long j6 = this.b;
            zw1 zw1Var = new zw1(j5, j3 + j6);
            if (j5 != j && iB != jArr.length - 1) {
                int i = iB + 1;
                return new xw1.a(zw1Var, new zw1((jArr[i] * 1000000) / j4, j6 + jArr2[i]));
            }
            return new xw1.a(zw1Var, zw1Var);
        }
        throw new IllegalStateException();
    }
}
