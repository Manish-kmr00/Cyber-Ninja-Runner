package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.t4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4455t4 {
    public static volatile C4455t4 r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4264lc f11773a;
    public final L7 b;
    public final C4206j4 c;
    public final M1 d;
    public final C4351p e;
    public final Ak f;
    public final P5 g;
    public final C4251l h;
    public final Km i;
    public C4489ud j;
    public final C4227k0 k;
    public volatile C4381q4 l;
    public final Xc m;
    public volatile Ke n;
    public Ri o;
    public final C4377q0 p;
    public final C4212ja q;

    public C4455t4(C4264lc c4264lc, C4351p c4351p, C4206j4 c4206j4) {
        this(c4264lc, c4351p, c4206j4, new C4251l(c4351p));
    }

    public static C4455t4 i() {
        if (r == null) {
            synchronized (C4455t4.class) {
                if (r == null) {
                    r = new C4455t4(new C4264lc(), new C4351p(), new C4206j4());
                }
            }
        }
        return r;
    }

    public final C4351p a() {
        return this.e;
    }

    public final C4227k0 b() {
        return this.k;
    }

    public final C4377q0 c() {
        return this.p;
    }

    public final M1 d() {
        return this.d;
    }

    public final C4206j4 e() {
        return this.c;
    }

    public final P5 f() {
        return this.g;
    }

    public final L7 g() {
        return this.b;
    }

    public final C4212ja h() {
        return this.q;
    }

    public final C4264lc j() {
        return this.f11773a;
    }

    public final C4381q4 k() {
        C4381q4 c4381q4 = this.l;
        if (c4381q4 == null) {
            synchronized (this) {
                c4381q4 = this.l;
                if (c4381q4 == null) {
                    c4381q4 = new C4381q4();
                    this.l = c4381q4;
                }
            }
        }
        return c4381q4;
    }

    public final C4264lc l() {
        return this.f11773a;
    }

    public final Ak m() {
        return this.f;
    }

    public C4455t4(C4264lc c4264lc, C4351p c4351p, C4206j4 c4206j4, C4251l c4251l) {
        this(c4264lc, new L7(), c4206j4, c4251l, new M1(), c4351p, new Ak(c4351p, c4251l), new P5(c4351p), new Km(), new C4227k0());
    }

    public final synchronized C4489ud a(Context context) {
        if (this.j == null) {
            this.j = new C4489ud(context, new Jn());
        }
        return this.j;
    }

    public final Ke b(Context context) {
        Ke ke = this.n;
        if (ke == null) {
            synchronized (this) {
                ke = this.n;
                if (ke == null) {
                    ke = new Ke(C4135g7.a(context).a());
                    this.n = ke;
                }
            }
        }
        return ke;
    }

    public C4455t4(C4264lc c4264lc, L7 l7, C4206j4 c4206j4, C4251l c4251l, M1 m1, C4351p c4351p, Ak ak, P5 p5, Km km, C4227k0 c4227k0) {
        this.m = new Xc();
        this.p = new C4377q0();
        this.q = new C4212ja();
        new K7();
        this.f11773a = c4264lc;
        this.b = l7;
        this.c = c4206j4;
        this.h = c4251l;
        this.d = m1;
        this.e = c4351p;
        this.f = ak;
        this.g = p5;
        this.i = km;
        this.k = c4227k0;
    }
}
