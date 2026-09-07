package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes7.dex */
final class u52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o52 f10359a;
    public final int b;
    public final long[] c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final long h;

    public u52(o52 o52Var, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        hg.a(iArr.length == jArr2.length);
        hg.a(jArr.length == jArr2.length);
        hg.a(iArr2.length == jArr2.length);
        this.f10359a = o52Var;
        this.c = jArr;
        this.d = iArr;
        this.e = i;
        this.f = jArr2;
        this.g = iArr2;
        this.h = j;
        this.b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public final int a(long j) {
        for (int iA = x82.a(this.f, j, true); iA < this.f.length; iA++) {
            if ((this.g[iA] & 1) != 0) {
                return iA;
            }
        }
        return -1;
    }
}
