package com.yandex.mobile.ads.impl;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: classes6.dex */
abstract class r22 {
    private t52 b;
    private y70 c;
    private zd1 d;
    private long e;
    private long f;
    private long g;
    private int h;
    private int i;
    private long k;
    private boolean l;
    private boolean m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xd1 f10068a = new xd1();
    private a j = new a();

    protected abstract long a(wf1 wf1Var);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected abstract boolean a(wf1 wf1Var, long j, a aVar) throws IOException;

    private static final class b implements zd1 {
        @Override // com.yandex.mobile.ads.impl.zd1
        public final long a(tz tzVar) {
            return -1L;
        }

        @Override // com.yandex.mobile.ads.impl.zd1
        public final void a(long j) {
        }

        @Override // com.yandex.mobile.ads.impl.zd1
        public final xw1 a() {
            return new xw1.b(-9223372036854775807L, 0L);
        }

        private b() {
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        gc0 f10069a;
        vb0.a b;

        a() {
        }
    }

    protected final long a(long j) {
        return (j * 1000000) / ((long) this.i);
    }

    protected final long b(long j) {
        return (((long) this.i) * j) / 1000000;
    }

    protected void c(long j) {
        this.g = j;
    }

    final void a(y70 y70Var, t52 t52Var) {
        this.c = y70Var;
        this.b = t52Var;
        a(true);
    }

    final int a(tz tzVar, lj1 lj1Var) throws IOException {
        if (this.b != null) {
            int i = x82.f10629a;
            int i2 = this.h;
            if (i2 == 0) {
                while (this.f10068a.a(tzVar)) {
                    this.k = tzVar.a() - this.f;
                    if (a(this.f10068a.b(), this.f, this.j)) {
                        this.f = tzVar.a();
                    } else {
                        gc0 gc0Var = this.j.f10069a;
                        this.i = gc0Var.A;
                        if (!this.m) {
                            this.b.a(gc0Var);
                            this.m = true;
                        }
                        vb0.a aVar = this.j.b;
                        if (aVar != null) {
                            this.d = aVar;
                        } else if (tzVar.b() == -1) {
                            this.d = new b();
                        } else {
                            yd1 yd1VarA = this.f10068a.a();
                            this.d = new g00(this, this.f, tzVar.b(), yd1VarA.d + yd1VarA.e, yd1VarA.b, (yd1VarA.f10727a & 4) != 0);
                        }
                        this.h = 2;
                        this.f10068a.d();
                        return 0;
                    }
                }
                this.h = 3;
                return -1;
            }
            if (i2 == 1) {
                tzVar.a((int) this.f);
                this.h = 2;
                return 0;
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    return -1;
                }
                throw new IllegalStateException();
            }
            long jA = this.d.a(tzVar);
            if (jA >= 0) {
                lj1Var.f9531a = jA;
                return 1;
            }
            if (jA < -1) {
                c(-(jA + 2));
            }
            if (!this.l) {
                xw1 xw1VarA = this.d.a();
                if (xw1VarA != null) {
                    this.c.a(xw1VarA);
                    this.l = true;
                } else {
                    throw new IllegalStateException();
                }
            }
            if (this.k <= 0 && !this.f10068a.a(tzVar)) {
                this.h = 3;
                return -1;
            }
            this.k = 0L;
            wf1 wf1VarB = this.f10068a.b();
            long jA2 = a(wf1VarB);
            if (jA2 >= 0) {
                long j = this.g;
                if (j + jA2 >= this.e) {
                    long jA3 = a(j);
                    this.b.a(wf1VarB.e(), wf1VarB);
                    this.b.a(jA3, 1, wf1VarB.e(), 0, null);
                    this.e = -1L;
                }
            }
            this.g += jA2;
            return 0;
        }
        throw new IllegalStateException();
    }

    protected void a(boolean z) {
        if (z) {
            this.j = new a();
            this.f = 0L;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.e = -1L;
        this.g = 0L;
    }

    final void a(long j, long j2) {
        this.f10068a.c();
        if (j == 0) {
            a(!this.l);
            return;
        }
        if (this.h != 0) {
            long jB = b(j2);
            this.e = jB;
            zd1 zd1Var = this.d;
            int i = x82.f10629a;
            zd1Var.a(jB);
            this.h = 2;
        }
    }
}
