package com.yandex.mobile.ads.impl;

import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
final class vh1 {
    private static final rw0.b s = new rw0.b(new Object());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b52 f10479a;
    public final rw0.b b;
    public final long c;
    public final long d;
    public final int e;
    public final j60 f;
    public final boolean g;
    public final s52 h;
    public final z52 i;
    public final List<g01> j;
    public final rw0.b k;
    public final boolean l;
    public final int m;
    public final xh1 n;
    public final boolean o;
    public volatile long p;
    public volatile long q;
    public volatile long r;

    public static vh1 a(z52 z52Var) {
        b52 b52Var = b52.b;
        rw0.b bVar = s;
        return new vh1(b52Var, bVar, -9223372036854775807L, 0L, 1, null, false, s52.e, z52Var, hk0.h(), bVar, false, 0, xh1.e, 0L, 0L, 0L, false);
    }

    public static rw0.b a() {
        return s;
    }

    public final vh1 a(rw0.b bVar, long j, long j2, long j3, long j4, s52 s52Var, z52 z52Var, List<g01> list) {
        return new vh1(this.f10479a, bVar, j2, j3, this.e, this.f, this.g, s52Var, z52Var, list, this.k, this.l, this.m, this.n, this.p, j4, j, this.o);
    }

    public final vh1 a(b52 b52Var) {
        return new vh1(b52Var, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }

    public final vh1 a(int i) {
        return new vh1(this.f10479a, this.b, this.c, this.d, i, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }

    public final vh1 a(j60 j60Var) {
        return new vh1(this.f10479a, this.b, this.c, this.d, this.e, j60Var, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }

    public final vh1 a(rw0.b bVar) {
        return new vh1(this.f10479a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, bVar, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }

    public vh1(b52 b52Var, rw0.b bVar, long j, long j2, int i, j60 j60Var, boolean z, s52 s52Var, z52 z52Var, List<g01> list, rw0.b bVar2, boolean z2, int i2, xh1 xh1Var, long j3, long j4, long j5, boolean z3) {
        this.f10479a = b52Var;
        this.b = bVar;
        this.c = j;
        this.d = j2;
        this.e = i;
        this.f = j60Var;
        this.g = z;
        this.h = s52Var;
        this.i = z52Var;
        this.j = list;
        this.k = bVar2;
        this.l = z2;
        this.m = i2;
        this.n = xh1Var;
        this.p = j3;
        this.q = j4;
        this.r = j5;
        this.o = z3;
    }
}
