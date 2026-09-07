package com.yandex.mobile.ads.impl;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class il {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final a f9233a;
    protected final f b;
    protected c c;
    private final int d;

    public static class a implements xw1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f9234a;
        private final long b;
        private final long c = 0;
        private final long d;
        private final long e;
        private final long f;
        private final long g;

        @Override // com.yandex.mobile.ads.impl.xw1
        public final boolean b() {
            return true;
        }

        public a(d dVar, long j, long j2, long j3, long j4, long j5) {
            this.f9234a = dVar;
            this.b = j;
            this.d = j2;
            this.e = j3;
            this.f = j4;
            this.g = j5;
        }

        @Override // com.yandex.mobile.ads.impl.xw1
        public final xw1.a b(long j) {
            zw1 zw1Var = new zw1(j, c.a(this.f9234a.a(j), this.c, this.d, this.e, this.f, this.g));
            return new xw1.a(zw1Var, zw1Var);
        }

        @Override // com.yandex.mobile.ads.impl.xw1
        public final long c() {
            return this.b;
        }
    }

    public static final class b implements d {
        @Override // com.yandex.mobile.ads.impl.il.d
        public final long a(long j) {
            return j;
        }
    }

    protected interface d {
        long a(long j);
    }

    public static final class e {
        public static final e d = new e(-3, -9223372036854775807L, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9236a;
        private final long b;
        private final long c;

        public static e a(long j, long j2) {
            return new e(-1, j, j2);
        }

        public static e b(long j, long j2) {
            return new e(-2, j, j2);
        }

        public static e a(long j) {
            return new e(0, -9223372036854775807L, j);
        }

        private e(int i, long j, long j2) {
            this.f9236a = i;
            this.b = j;
            this.c = j2;
        }
    }

    protected interface f {
        e a(tz tzVar, long j) throws IOException;

        default void a() {
        }
    }

    protected il(d dVar, f fVar, long j, long j2, long j3, long j4, long j5, int i) {
        this.b = fVar;
        this.d = i;
        this.f9233a = new a(dVar, j, j2, j3, j4, j5);
    }

    public final a a() {
        return this.f9233a;
    }

    public final int a(tz tzVar, lj1 lj1Var) throws IOException {
        while (true) {
            c cVar = this.c;
            if (cVar != null) {
                long j = cVar.f;
                long j2 = cVar.g;
                long j3 = cVar.h;
                if (j2 - j <= this.d) {
                    this.c = null;
                    this.b.a();
                    if (j == tzVar.a()) {
                        return 0;
                    }
                    lj1Var.f9531a = j;
                    return 1;
                }
                long jA = j3 - tzVar.a();
                if (jA < 0 || jA > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    if (j3 == tzVar.a()) {
                        return 0;
                    }
                    lj1Var.f9531a = j3;
                    return 1;
                }
                tzVar.a((int) jA);
                tzVar.c();
                e eVarA = this.b.a(tzVar, cVar.b);
                int i = eVarA.f9236a;
                if (i == -3) {
                    this.c = null;
                    this.b.a();
                    if (j3 == tzVar.a()) {
                        return 0;
                    }
                    lj1Var.f9531a = j3;
                    return 1;
                }
                if (i == -2) {
                    long j4 = eVarA.b;
                    long j5 = eVarA.c;
                    cVar.d = j4;
                    cVar.f = j5;
                    cVar.h = c.a(cVar.b, j4, cVar.e, j5, cVar.g, cVar.c);
                } else {
                    if (i != -1) {
                        if (i != 0) {
                            throw new IllegalStateException("Invalid case");
                        }
                        long jA2 = eVarA.c - tzVar.a();
                        if (jA2 >= 0 && jA2 <= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                            tzVar.a((int) jA2);
                        }
                        this.c = null;
                        this.b.a();
                        long j6 = eVarA.c;
                        if (j6 == tzVar.a()) {
                            return 0;
                        }
                        lj1Var.f9531a = j6;
                        return 1;
                    }
                    long j7 = eVarA.b;
                    long j8 = eVarA.c;
                    cVar.e = j7;
                    cVar.g = j8;
                    cVar.h = c.a(cVar.b, cVar.d, j7, cVar.f, j8, cVar.c);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final boolean b() {
        return this.c != null;
    }

    public final void a(long j) {
        c cVar = this.c;
        if (cVar == null || cVar.f9235a != j) {
            long jA = this.f9233a.f9234a.a(j);
            a aVar = this.f9233a;
            this.c = new c(j, jA, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g);
        }
    }

    protected static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9235a;
        private final long b;
        private final long c;
        private long d;
        private long e;
        private long f;
        private long g;
        private long h;

        protected static long a(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
            long j8 = j7 / 20;
            int i = x82.f10629a;
            return Math.max(j4, Math.min(((j7 + j4) - j6) - j8, j5 - 1));
        }

        protected c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.f9235a = j;
            this.b = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
            this.c = j7;
            this.h = a(j2, j3, j4, j5, j6, j7);
        }
    }
}
