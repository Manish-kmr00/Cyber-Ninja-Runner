package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes10.dex */
public final class o52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9783a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final gc0 f;
    public final int g;
    public final long[] h;
    public final long[] i;
    public final int j;
    private final p52[] k;

    public o52(int i, int i2, long j, long j2, long j3, gc0 gc0Var, int i3, p52[] p52VarArr, int i4, long[] jArr, long[] jArr2) {
        this.f9783a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = gc0Var;
        this.g = i3;
        this.k = p52VarArr;
        this.j = i4;
        this.h = jArr;
        this.i = jArr2;
    }

    public final p52 a(int i) {
        p52[] p52VarArr = this.k;
        if (p52VarArr == null) {
            return null;
        }
        return p52VarArr[i];
    }
}
