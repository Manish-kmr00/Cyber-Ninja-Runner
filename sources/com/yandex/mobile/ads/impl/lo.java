package com.yandex.mobile.ads.impl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class lo implements xw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9547a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    private final long f;

    @Override // com.yandex.mobile.ads.impl.xw1
    public final boolean b() {
        return true;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.f9547a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.c) + ", timeUs=" + Arrays.toString(this.e) + ", durationsUs=" + Arrays.toString(this.d) + ")";
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final xw1.a b(long j) {
        int iB = x82.b(this.e, j, true);
        long[] jArr = this.e;
        long j2 = jArr[iB];
        long[] jArr2 = this.c;
        zw1 zw1Var = new zw1(j2, jArr2[iB]);
        if (j2 >= j || iB == this.f9547a - 1) {
            return new xw1.a(zw1Var, zw1Var);
        }
        int i = iB + 1;
        return new xw1.a(zw1Var, new zw1(jArr[i], jArr2[i]));
    }

    public lo(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.f9547a = length;
        if (length > 0) {
            int i = length - 1;
            this.f = jArr2[i] + jArr3[i];
        } else {
            this.f = 0L;
        }
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final long c() {
        return this.f;
    }
}
