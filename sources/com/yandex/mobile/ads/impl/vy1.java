package com.yandex.mobile.ads.impl;

import android.net.Uri;

/* JADX INFO: loaded from: classes10.dex */
public final class vy1 extends b52 {
    private static final Object p = new Object();
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final long i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final Object m;
    private final fw0 n;
    private final fw0.e o;

    static {
        new fw0.a().b("SinglePeriodTimeline").a(Uri.EMPTY).a();
    }

    @Override // com.yandex.mobile.ads.impl.b52
    public final int a() {
        return 1;
    }

    @Override // com.yandex.mobile.ads.impl.b52
    public final int b() {
        return 1;
    }

    public vy1(long j, long j2, boolean z, fw0 fw0Var, fw0.e eVar) {
        this.c = -9223372036854775807L;
        this.d = -9223372036854775807L;
        this.e = -9223372036854775807L;
        this.f = j;
        this.g = j2;
        this.h = 0L;
        this.i = 0L;
        this.j = z;
        this.k = false;
        this.l = false;
        this.m = null;
        this.n = (fw0) hg.a(fw0Var);
        this.o = eVar;
    }

    public vy1(long j, long j2, boolean z, boolean z2, fw0 fw0Var) {
        this(j, j2, z, fw0Var, z2 ? fw0Var.d : null);
    }

    @Override // com.yandex.mobile.ads.impl.b52
    public final b52.b a(int i, b52.b bVar, boolean z) {
        hg.a(i, 1);
        Object obj = z ? p : null;
        long j = this.f;
        long j2 = -this.h;
        bVar.getClass();
        return bVar.a(null, obj, 0, j, j2, n5.h, false);
    }

    @Override // com.yandex.mobile.ads.impl.b52
    public final Object a(int i) {
        hg.a(i, 1);
        return p;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002d A[PHI: r1
  0x002d: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x000c, B:5:0x0010, B:7:0x0016, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.yandex.mobile.ads.impl.b52
    public final b52.d a(int i, b52.d dVar, long j) {
        long j2;
        hg.a(i, 1);
        long j3 = this.i;
        boolean z = this.k;
        if (!z || this.l || j == 0) {
            j2 = j3;
        } else {
            long j4 = this.g;
            if (j4 != -9223372036854775807L) {
                j3 += j;
                if (j3 <= j4) {
                    j2 = j3;
                }
            }
            j2 = -9223372036854775807L;
        }
        return dVar.a(b52.d.s, this.n, this.m, this.c, this.d, this.e, this.j, z, this.o, j2, this.g, 0, 0, this.h);
    }

    @Override // com.yandex.mobile.ads.impl.b52
    public final int a(Object obj) {
        return p.equals(obj) ? 0 : -1;
    }
}
