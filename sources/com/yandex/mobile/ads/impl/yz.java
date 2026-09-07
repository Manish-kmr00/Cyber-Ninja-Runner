package com.yandex.mobile.ads.impl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes6.dex */
public final class yz implements xr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10779a;
    private final long b;
    private final float c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;
    private float j;
    private float k;
    private float l;
    private long m;
    private long n;
    private long o;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f10780a = x82.a(20L);
        private long b = x82.a(500L);
        private float c = 0.999f;

        public final yz a() {
            return new yz(this.f10780a, this.b, this.c);
        }
    }

    private yz(long j, long j2, float f) {
        this.f10779a = j;
        this.b = j2;
        this.c = f;
        this.d = -9223372036854775807L;
        this.e = -9223372036854775807L;
        this.g = -9223372036854775807L;
        this.h = -9223372036854775807L;
        this.k = 0.97f;
        this.j = 1.03f;
        this.l = 1.0f;
        this.m = -9223372036854775807L;
        this.f = -9223372036854775807L;
        this.i = -9223372036854775807L;
        this.n = -9223372036854775807L;
        this.o = -9223372036854775807L;
    }

    public final void c() {
        long j = this.i;
        if (j == -9223372036854775807L) {
            return;
        }
        long j2 = j + this.b;
        this.i = j2;
        long j3 = this.h;
        if (j3 != -9223372036854775807L && j2 > j3) {
            this.i = j3;
        }
        this.m = -9223372036854775807L;
    }

    public final float a(long j, long j2) {
        if (this.d == -9223372036854775807L) {
            return 1.0f;
        }
        long j3 = j - j2;
        long j4 = this.n;
        if (j4 == -9223372036854775807L) {
            this.n = j3;
            this.o = 0L;
        } else {
            float f = this.c;
            long jMax = Math.max(j3, (long) (((1.0f - f) * j3) + (j4 * f)));
            this.n = jMax;
            long jAbs = Math.abs(j3 - jMax);
            long j5 = this.o;
            float f2 = this.c;
            this.o = (long) (((1.0f - f2) * jAbs) + (j5 * f2));
        }
        if (this.m != -9223372036854775807L && SystemClock.elapsedRealtime() - this.m < 1000) {
            return this.l;
        }
        this.m = SystemClock.elapsedRealtime();
        long j6 = (this.o * 3) + this.n;
        if (this.i > j6) {
            float fA = x82.a(1000L);
            long[] jArr = {j6, this.f, this.i - (((long) ((this.l - 1.0f) * fA)) + ((long) ((this.j - 1.0f) * fA)))};
            long j7 = jArr[0];
            for (int i = 1; i < 3; i++) {
                long j8 = jArr[i];
                if (j8 > j7) {
                    j7 = j8;
                }
            }
            this.i = j7;
        } else {
            long jMax2 = j - ((long) (Math.max(0.0f, this.l - 1.0f) / 1.0E-7f));
            long j9 = this.i;
            int i2 = x82.f10629a;
            long jMax3 = Math.max(j9, Math.min(jMax2, j6));
            this.i = jMax3;
            long j10 = this.h;
            if (j10 != -9223372036854775807L && jMax3 > j10) {
                this.i = j10;
            }
        }
        long j11 = j - this.i;
        if (Math.abs(j11) < this.f10779a) {
            this.l = 1.0f;
        } else {
            float f3 = this.k;
            float f4 = this.j;
            int i3 = x82.f10629a;
            this.l = Math.max(f3, Math.min((j11 * 1.0E-7f) + 1.0f, f4));
        }
        return this.l;
    }

    private void b() {
        long j = this.d;
        if (j != -9223372036854775807L) {
            long j2 = this.e;
            if (j2 != -9223372036854775807L) {
                j = j2;
            }
            long j3 = this.g;
            if (j3 != -9223372036854775807L && j < j3) {
                j = j3;
            }
            long j4 = this.h;
            if (j4 != -9223372036854775807L && j > j4) {
                j = j4;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.f == j) {
            return;
        }
        this.f = j;
        this.i = j;
        this.n = -9223372036854775807L;
        this.o = -9223372036854775807L;
        this.m = -9223372036854775807L;
    }

    public final long a() {
        return this.i;
    }

    public final void a(fw0.e eVar) {
        this.d = x82.a(eVar.b);
        this.g = x82.a(eVar.c);
        this.h = x82.a(eVar.d);
        float f = eVar.e;
        if (f == -3.4028235E38f) {
            f = 0.97f;
        }
        this.k = f;
        float f2 = eVar.f;
        if (f2 == -3.4028235E38f) {
            f2 = 1.03f;
        }
        this.j = f2;
        if (f == 1.0f && f2 == 1.0f) {
            this.d = -9223372036854775807L;
        }
        b();
    }

    public final void a(long j) {
        this.e = j;
        b();
    }
}
