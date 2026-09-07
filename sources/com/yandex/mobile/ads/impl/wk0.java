package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes4.dex */
public final class wk0 implements xw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f10570a;
    private final long[] b;
    private final long c;
    private final boolean d;

    public wk0(long j, long[] jArr, long[] jArr2) {
        hg.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z = length > 0;
        this.d = z;
        if (!z || jArr2[0] <= 0) {
            this.f10570a = jArr;
            this.b = jArr2;
        } else {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.f10570a = jArr3;
            long[] jArr4 = new long[i];
            this.b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.c = j;
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final long c() {
        return this.c;
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final xw1.a b(long j) {
        if (!this.d) {
            zw1 zw1Var = zw1.c;
            return new xw1.a(zw1Var, zw1Var);
        }
        int iB = x82.b(this.b, j, true);
        long[] jArr = this.b;
        long j2 = jArr[iB];
        long[] jArr2 = this.f10570a;
        zw1 zw1Var2 = new zw1(j2, jArr2[iB]);
        if (j2 != j && iB != jArr.length - 1) {
            int i = iB + 1;
            return new xw1.a(zw1Var2, new zw1(jArr[i], jArr2[i]));
        }
        return new xw1.a(zw1Var2, zw1Var2);
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final boolean b() {
        return this.d;
    }
}
