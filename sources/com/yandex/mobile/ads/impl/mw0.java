package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes10.dex */
final class mw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lw0 f9674a;
    public final Object b;
    public final et1[] c;
    public boolean d;
    public boolean e;
    public ow0 f;
    public boolean g;
    private final boolean[] h;
    private final so1[] i;
    private final y52 j;
    private final uw0 k;
    private mw0 l;
    private s52 m;
    private z52 n;
    private long o;

    public final void h() {
        this.o = 1000000000000L;
    }

    public mw0(so1[] so1VarArr, long j, y52 y52Var, cd cdVar, uw0 uw0Var, ow0 ow0Var, z52 z52Var) {
        this.i = so1VarArr;
        this.o = j;
        this.j = y52Var;
        this.k = uw0Var;
        rw0.b bVar = ow0Var.f9869a;
        this.b = bVar.f9759a;
        this.f = ow0Var;
        this.m = s52.e;
        this.n = z52Var;
        this.c = new et1[so1VarArr.length];
        this.h = new boolean[so1VarArr.length];
        this.f9674a = a(bVar, uw0Var, cdVar, ow0Var.b, ow0Var.d);
    }

    public final long c() {
        return this.o;
    }

    public final long c(long j) {
        return j - this.o;
    }

    public final long d() {
        return this.f.b + this.o;
    }

    public final long d(long j) {
        return j + this.o;
    }

    public final long a(z52 z52Var, long j, boolean z, boolean[] zArr) {
        z52 z52Var2;
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= z52Var.f10791a) {
                break;
            }
            boolean[] zArr2 = this.h;
            if (z || (z52Var2 = this.n) == null || !x82.a(z52Var.b[i2], z52Var2.b[i2]) || !x82.a(z52Var.c[i2], z52Var2.c[i2])) {
                z2 = false;
            }
            zArr2[i2] = z2;
            i2++;
        }
        et1[] et1VarArr = this.c;
        int i3 = 0;
        while (true) {
            so1[] so1VarArr = this.i;
            if (i3 >= so1VarArr.length) {
                break;
            }
            if (((rk) so1VarArr[i3]).m() == -2) {
                et1VarArr[i3] = null;
            }
            i3++;
        }
        a();
        this.n = z52Var;
        if (this.l == null) {
            int i4 = 0;
            while (true) {
                z52 z52Var3 = this.n;
                if (i4 >= z52Var3.f10791a) {
                    break;
                }
                boolean zA = z52Var3.a(i4);
                e70 e70Var = this.n.c[i4];
                if (zA && e70Var != null) {
                    e70Var.d();
                }
                i4++;
            }
        }
        long jA = this.f9674a.a(z52Var.c, this.h, this.c, zArr, j);
        et1[] et1VarArr2 = this.c;
        int i5 = 0;
        while (true) {
            so1[] so1VarArr2 = this.i;
            if (i5 >= so1VarArr2.length) {
                break;
            }
            if (((rk) so1VarArr2[i5]).m() == -2 && this.n.a(i5)) {
                et1VarArr2[i5] = new a50();
            }
            i5++;
        }
        this.e = false;
        while (true) {
            et1[] et1VarArr3 = this.c;
            if (i >= et1VarArr3.length) {
                return jA;
            }
            if (et1VarArr3[i] != null) {
                if (z52Var.a(i)) {
                    if (((rk) this.i[i]).m() != -2) {
                        this.e = true;
                    }
                } else {
                    throw new IllegalStateException();
                }
            } else if (z52Var.c[i] != null) {
                throw new IllegalStateException();
            }
            i++;
        }
    }

    public final void g() {
        a();
        uw0 uw0Var = this.k;
        lw0 lw0Var = this.f9674a;
        try {
            if (lw0Var instanceof gp) {
                uw0Var.a(((gp) lw0Var).b);
            } else {
                uw0Var.a(lw0Var);
            }
        } catch (RuntimeException e) {
            at0.a("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void a(z52 z52Var, long j) {
        a(z52Var, j, false, new boolean[this.i.length]);
    }

    public final void a(long j) {
        if (this.l == null) {
            this.f9674a.continueLoading(j - this.o);
            return;
        }
        throw new IllegalStateException();
    }

    public final mw0 b() {
        return this.l;
    }

    public final void b(long j) {
        if (this.l == null) {
            if (this.d) {
                this.f9674a.reevaluateBuffer(j - this.o);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final s52 e() {
        return this.m;
    }

    public final z52 f() {
        return this.n;
    }

    public final z52 b(float f, b52 b52Var) throws j60 {
        z52 z52VarA = this.j.a(this.i, this.m, this.f.f9869a, b52Var);
        for (e70 e70Var : z52VarA.c) {
            if (e70Var != null) {
                e70Var.a(f);
            }
        }
        return z52VarA;
    }

    private static lw0 a(rw0.b bVar, uw0 uw0Var, cd cdVar, long j, long j2) {
        eu0 eu0VarA = uw0Var.a(bVar, cdVar, j);
        return j2 != -9223372036854775807L ? new gp(eu0VarA, true, 0L, j2) : eu0VarA;
    }

    private void a() {
        if (this.l != null) {
            return;
        }
        int i = 0;
        while (true) {
            z52 z52Var = this.n;
            if (i >= z52Var.f10791a) {
                return;
            }
            boolean zA = z52Var.a(i);
            e70 e70Var = this.n.c[i];
            if (zA && e70Var != null) {
                e70Var.c();
            }
            i++;
        }
    }

    public final void a(float f, b52 b52Var) throws j60 {
        this.d = true;
        this.m = this.f9674a.getTrackGroups();
        z52 z52VarB = b(f, b52Var);
        ow0 ow0Var = this.f;
        long jMax = ow0Var.b;
        long j = ow0Var.e;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jA = a(z52VarB, jMax, false, new boolean[this.i.length]);
        long j2 = this.o;
        ow0 ow0Var2 = this.f;
        long j3 = ow0Var2.b;
        this.o = (j3 - jA) + j2;
        if (jA != j3) {
            ow0Var2 = new ow0(ow0Var2.f9869a, jA, ow0Var2.c, ow0Var2.d, ow0Var2.e, ow0Var2.f, ow0Var2.g, ow0Var2.h, ow0Var2.i);
        }
        this.f = ow0Var2;
    }

    public final void a(mw0 mw0Var) {
        if (mw0Var == this.l) {
            return;
        }
        a();
        this.l = mw0Var;
        if (mw0Var != null) {
            return;
        }
        int i = 0;
        while (true) {
            z52 z52Var = this.n;
            if (i >= z52Var.f10791a) {
                return;
            }
            boolean zA = z52Var.a(i);
            e70 e70Var = this.n.c[i];
            if (zA && e70Var != null) {
                e70Var.d();
            }
            i++;
        }
    }
}
