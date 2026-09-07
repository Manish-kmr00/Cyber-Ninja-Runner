package com.yandex.mobile.ads.impl;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class g00 implements zd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final yd1 f8954a;
    private final long b;
    private final long c;
    private final r22 d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;

    @Override // com.yandex.mobile.ads.impl.zd1
    public final xw1 a() {
        if (this.f != 0) {
            return new a();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006a  */
    @Override // com.yandex.mobile.ads.impl.zd1
    public final long a(tz tzVar) throws IOException {
        long jMax;
        long j;
        int i = this.e;
        if (i == 0) {
            long jA = tzVar.a();
            this.g = jA;
            this.e = 1;
            long j2 = this.c - 65307;
            if (j2 > jA) {
                return j2;
            }
        } else if (i != 1) {
            if (i == 2) {
                if (this.i == this.j) {
                    jMax = -1;
                    j = -1;
                } else {
                    long jA2 = tzVar.a();
                    if (!this.f8954a.a(tzVar, this.j)) {
                        jMax = this.i;
                        if (jMax == jA2) {
                            throw new IOException("No ogg page can be found.");
                        }
                        j = -1;
                    } else {
                        this.f8954a.a(tzVar, false);
                        tzVar.c();
                        long j3 = this.h;
                        yd1 yd1Var = this.f8954a;
                        long j4 = yd1Var.b;
                        long j5 = j3 - j4;
                        int i2 = yd1Var.d + yd1Var.e;
                        if (0 > j5 || j5 >= 72000) {
                            if (j5 < 0) {
                                this.j = jA2;
                                this.l = j4;
                            } else {
                                this.i = tzVar.a() + ((long) i2);
                                this.k = this.f8954a.b;
                            }
                            long j6 = this.j;
                            long j7 = this.i;
                            if (j6 - j7 < 100000) {
                                this.j = j7;
                                jMax = j7;
                            } else {
                                long jA3 = tzVar.a() - (((long) i2) * (j5 <= 0 ? 2L : 1L));
                                long j8 = this.j;
                                long j9 = this.i;
                                int i3 = x82.f10629a;
                                jMax = Math.max(j9, Math.min(jA3 + (((j8 - j9) * j5) / (this.l - this.k)), j8 - 1));
                            }
                        } else {
                            jMax = -1;
                        }
                        j = -1;
                    }
                }
                if (jMax != j) {
                    return jMax;
                }
                this.e = 3;
            } else {
                if (i != 3) {
                    if (i == 4) {
                        return -1L;
                    }
                    throw new IllegalStateException();
                }
                j = -1;
            }
            while (true) {
                this.f8954a.a(tzVar, j);
                this.f8954a.a(tzVar, false);
                yd1 yd1Var2 = this.f8954a;
                if (yd1Var2.b > this.h) {
                    tzVar.c();
                    this.e = 4;
                    return -(this.k + 2);
                }
                tzVar.a(yd1Var2.d + yd1Var2.e);
                this.i = tzVar.a();
                this.k = this.f8954a.b;
                j = -1;
            }
        }
        yd1 yd1Var3 = this.f8954a;
        yd1Var3.f10727a = 0;
        yd1Var3.b = 0L;
        yd1Var3.c = 0;
        yd1Var3.d = 0;
        yd1Var3.e = 0;
        if (yd1Var3.a(tzVar, -1L)) {
            this.f8954a.a(tzVar, false);
            yd1 yd1Var4 = this.f8954a;
            tzVar.a(yd1Var4.d + yd1Var4.e);
            long j10 = this.f8954a.b;
            while (true) {
                yd1 yd1Var5 = this.f8954a;
                if ((yd1Var5.f10727a & 4) == 4 || !yd1Var5.a(tzVar, -1L) || tzVar.a() >= this.c || !this.f8954a.a(tzVar, true)) {
                    break;
                }
                yd1 yd1Var6 = this.f8954a;
                try {
                    tzVar.a(yd1Var6.d + yd1Var6.e);
                    j10 = this.f8954a.b;
                } catch (EOFException unused) {
                }
            }
            this.f = j10;
            this.e = 4;
            return this.g;
        }
        throw new EOFException();
    }

    public g00(r22 r22Var, long j, long j2, long j3, long j4, boolean z) {
        hg.a(j >= 0 && j2 > j);
        this.d = r22Var;
        this.b = j;
        this.c = j2;
        if (j3 != j2 - j && !z) {
            this.e = 0;
        } else {
            this.f = j4;
            this.e = 4;
        }
        this.f8954a = new yd1();
    }

    private final class a implements xw1 {
        @Override // com.yandex.mobile.ads.impl.xw1
        public final boolean b() {
            return true;
        }

        private a() {
        }

        @Override // com.yandex.mobile.ads.impl.xw1
        public final xw1.a b(long j) {
            long jB = g00.this.d.b(j);
            g00 g00Var = g00.this;
            long j2 = g00Var.b;
            long j3 = g00Var.c;
            int i = x82.f10629a;
            zw1 zw1Var = new zw1(j, Math.max(j2, Math.min(((((j3 - j2) * jB) / g00Var.f) + j2) - 30000, j3 - 1)));
            return new xw1.a(zw1Var, zw1Var);
        }

        @Override // com.yandex.mobile.ads.impl.xw1
        public final long c() {
            g00 g00Var = g00.this;
            return g00Var.d.a(g00Var.f);
        }
    }

    @Override // com.yandex.mobile.ads.impl.zd1
    public final void a(long j) {
        long j2 = this.f - 1;
        int i = x82.f10629a;
        this.h = Math.max(0L, Math.min(j, j2));
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }
}
