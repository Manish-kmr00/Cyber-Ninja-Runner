package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes11.dex */
final class na2 implements ax1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f9713a;
    private final long[] b;
    private final long c;
    private final long d;

    @Override // com.yandex.mobile.ads.impl.xw1
    public final boolean b() {
        return true;
    }

    public static na2 a(long j, long j2, b21.a aVar, wf1 wf1Var) {
        int iT;
        wf1Var.f(10);
        int iH = wf1Var.h();
        if (iH <= 0) {
            return null;
        }
        int i = aVar.d;
        long jA = x82.a(iH, ((long) (i >= 32000 ? 1152 : 576)) * 1000000, i);
        int iZ = wf1Var.z();
        int iZ2 = wf1Var.z();
        int iZ3 = wf1Var.z();
        wf1Var.f(2);
        long j3 = j2 + ((long) aVar.c);
        long[] jArr = new long[iZ];
        long[] jArr2 = new long[iZ];
        int i2 = 0;
        long j4 = j2;
        while (i2 < iZ) {
            int i3 = iZ2;
            long j5 = j3;
            jArr[i2] = (((long) i2) * jA) / ((long) iZ);
            jArr2[i2] = Math.max(j4, j5);
            if (iZ3 == 1) {
                iT = wf1Var.t();
            } else if (iZ3 == 2) {
                iT = wf1Var.z();
            } else if (iZ3 == 3) {
                iT = wf1Var.w();
            } else {
                if (iZ3 != 4) {
                    return null;
                }
                iT = wf1Var.x();
            }
            j4 += ((long) iT) * ((long) i3);
            i2++;
            jArr = jArr;
            iZ2 = i3;
            j3 = j5;
        }
        long[] jArr3 = jArr;
        if (j != -1 && j != j4) {
            at0.d("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new na2(jArr3, jArr2, jA, j4);
    }

    private na2(long[] jArr, long[] jArr2, long j, long j2) {
        this.f9713a = jArr;
        this.b = jArr2;
        this.c = j;
        this.d = j2;
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final xw1.a b(long j) {
        int iB = x82.b(this.f9713a, j, true);
        long[] jArr = this.f9713a;
        long j2 = jArr[iB];
        long[] jArr2 = this.b;
        zw1 zw1Var = new zw1(j2, jArr2[iB]);
        if (j2 < j && iB != jArr.length - 1) {
            int i = iB + 1;
            return new xw1.a(zw1Var, new zw1(jArr[i], jArr2[i]));
        }
        return new xw1.a(zw1Var, zw1Var);
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final long c() {
        return this.c;
    }

    @Override // com.yandex.mobile.ads.impl.ax1
    public final long a() {
        return this.d;
    }

    @Override // com.yandex.mobile.ads.impl.ax1
    public final long a(long j) {
        return this.f9713a[x82.b(this.b, j, true)];
    }
}
