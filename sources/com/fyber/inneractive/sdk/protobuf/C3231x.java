package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3231x implements T0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC3229w f2301a;
    public int b;
    public int c;
    public int d = 0;

    public C3231x(AbstractC3229w abstractC3229w) {
        Charset charset = AbstractC3205m0.f2291a;
        if (abstractC3229w == null) {
            throw new NullPointerException("input");
        }
        this.f2301a = abstractC3229w;
        abstractC3229w.d = this;
    }

    public static void c(int i) throws C3211o0 {
        if ((i & 3) != 0) {
            throw new C3211o0("Failed to parse the message.");
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final Object a(Class cls, H h) throws C3208n0 {
        b(3);
        return c(Q0.c.a(cls), h);
    }

    public final void b(int i) throws C3208n0 {
        if ((this.b & 7) == i) {
            return;
        }
        int i2 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int d() throws C3208n0 {
        b(0);
        return this.f2301a.k();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int e() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final long f() throws C3208n0 {
        b(0);
        return this.f2301a.v();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final long g() throws C3208n0 {
        b(1);
        return this.f2301a.i();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final double h() throws C3208n0 {
        b(1);
        return this.f2301a.f();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final boolean i() {
        int i;
        if (this.f2301a.c() || (i = this.b) == this.c) {
            return false;
        }
        return this.f2301a.e(i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int j() throws C3208n0 {
        b(0);
        return this.f2301a.p();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final float k() throws C3208n0 {
        b(5);
        return this.f2301a.j();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final long l() throws C3208n0 {
        b(0);
        return this.f2301a.q();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int m() throws C3208n0 {
        b(5);
        return this.f2301a.n();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final String n() throws C3208n0 {
        b(2);
        return this.f2301a.r();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final long o() throws C3208n0 {
        b(0);
        return this.f2301a.l();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final String p() throws C3208n0 {
        b(2);
        return this.f2301a.s();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int q() throws C3208n0 {
        b(5);
        return this.f2301a.h();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final boolean r() throws C3208n0 {
        b(0);
        return this.f2301a.d();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int s() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.f2301a.t();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final long t() throws C3208n0 {
        b(1);
        return this.f2301a.o();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void e(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (!(list instanceof C3172b0)) {
            int i = this.b & 7;
            if (i == 2) {
                int iU = this.f2301a.u();
                c(iU);
                int iB = this.f2301a.b() + iU;
                do {
                    list.add(Integer.valueOf(this.f2301a.h()));
                } while (this.f2301a.b() < iB);
                return;
            }
            if (i != 5) {
                int i2 = C3211o0.f2292a;
                throw new C3208n0();
            }
            do {
                list.add(Integer.valueOf(this.f2301a.h()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        C3172b0 c3172b0 = (C3172b0) list;
        int i3 = this.b & 7;
        if (i3 == 2) {
            int iU2 = this.f2301a.u();
            c(iU2);
            int iB2 = this.f2301a.b() + iU2;
            do {
                c3172b0.c(this.f2301a.h());
            } while (this.f2301a.b() < iB2);
            return;
        }
        if (i3 != 5) {
            int i4 = C3211o0.f2292a;
            throw new C3208n0();
        }
        do {
            c3172b0.c(this.f2301a.h());
            if (this.f2301a.c()) {
                return;
            } else {
                iT2 = this.f2301a.t();
            }
        } while (iT2 == this.b);
        this.d = iT2;
    }

    public static void d(int i) throws C3211o0 {
        if ((i & 7) != 0) {
            throw new C3211o0("Failed to parse the message.");
        }
    }

    public final Object c(U0 u0, H h) {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            Object objA = u0.a();
            u0.a(objA, this, h);
            u0.c(objA);
            if (this.b == this.c) {
                this.c = i;
                return objA;
            }
            throw new C3211o0("Failed to parse the message.");
        } catch (Throwable th) {
            this.c = i;
            throw th;
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void f(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            int i = this.b & 7;
            if (i == 2) {
                int iU = this.f2301a.u();
                c(iU);
                int iB = this.f2301a.b() + iU;
                do {
                    c3172b0.c(this.f2301a.n());
                } while (this.f2301a.b() < iB);
                return;
            }
            if (i == 5) {
                do {
                    c3172b0.c(this.f2301a.n());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 2) {
            int iU2 = this.f2301a.u();
            c(iU2);
            int iB2 = this.f2301a.b() + iU2;
            do {
                list.add(Integer.valueOf(this.f2301a.n()));
            } while (this.f2301a.b() < iB2);
            return;
        }
        if (i3 == 5) {
            do {
                list.add(Integer.valueOf(this.f2301a.n()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void g(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof C3228v0) {
            C3228v0 c3228v0 = (C3228v0) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    c3228v0.a(this.f2301a.q());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f2301a.b() + this.f2301a.u();
                do {
                    c3228v0.a(this.f2301a.q());
                } while (this.f2301a.b() < iB);
                a(iB);
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Long.valueOf(this.f2301a.q()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f2301a.b() + this.f2301a.u();
            do {
                list.add(Long.valueOf(this.f2301a.q()));
            } while (this.f2301a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void h(List list) throws C3208n0 {
        int iT;
        if ((this.b & 7) == 2) {
            do {
                b(2);
                list.add(this.f2301a.e());
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        int i = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void j(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof D) {
            D d = (D) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    d.a(this.f2301a.f());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iU = this.f2301a.u();
                d(iU);
                int iB = this.f2301a.b() + iU;
                do {
                    d.a(this.f2301a.f());
                } while (this.f2301a.b() < iB);
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 1) {
            do {
                list.add(Double.valueOf(this.f2301a.f()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iU2 = this.f2301a.u();
            d(iU2);
            int iB2 = this.f2301a.b() + iU2;
            do {
                list.add(Double.valueOf(this.f2301a.f()));
            } while (this.f2301a.b() < iB2);
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void k(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof C3228v0) {
            C3228v0 c3228v0 = (C3228v0) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    c3228v0.a(this.f2301a.l());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f2301a.b() + this.f2301a.u();
                do {
                    c3228v0.a(this.f2301a.l());
                } while (this.f2301a.b() < iB);
                a(iB);
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Long.valueOf(this.f2301a.l()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f2301a.b() + this.f2301a.u();
            do {
                list.add(Long.valueOf(this.f2301a.l()));
            } while (this.f2301a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void l(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof C3195j) {
            C3195j c3195j = (C3195j) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    c3195j.a(this.f2301a.d());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f2301a.b() + this.f2301a.u();
                do {
                    c3195j.a(this.f2301a.d());
                } while (this.f2301a.b() < iB);
                a(iB);
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Boolean.valueOf(this.f2301a.d()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f2301a.b() + this.f2301a.u();
            do {
                list.add(Boolean.valueOf(this.f2301a.d()));
            } while (this.f2301a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void m(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof C3228v0) {
            C3228v0 c3228v0 = (C3228v0) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    c3228v0.a(this.f2301a.o());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iU = this.f2301a.u();
                d(iU);
                int iB = this.f2301a.b() + iU;
                do {
                    c3228v0.a(this.f2301a.o());
                } while (this.f2301a.b() < iB);
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 1) {
            do {
                list.add(Long.valueOf(this.f2301a.o()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iU2 = this.f2301a.u();
            d(iU2);
            int iB2 = this.f2301a.b() + iU2;
            do {
                list.add(Long.valueOf(this.f2301a.o()));
            } while (this.f2301a.b() < iB2);
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void n(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof C3228v0) {
            C3228v0 c3228v0 = (C3228v0) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    c3228v0.a(this.f2301a.i());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iU = this.f2301a.u();
                d(iU);
                int iB = this.f2301a.b() + iU;
                do {
                    c3228v0.a(this.f2301a.i());
                } while (this.f2301a.b() < iB);
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 1) {
            do {
                list.add(Long.valueOf(this.f2301a.i()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iU2 = this.f2301a.u();
            d(iU2);
            int iB2 = this.f2301a.b() + iU2;
            do {
                list.add(Long.valueOf(this.f2301a.i()));
            } while (this.f2301a.b() < iB2);
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void o(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    c3172b0.c(this.f2301a.k());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f2301a.b() + this.f2301a.u();
                do {
                    c3172b0.c(this.f2301a.k());
                } while (this.f2301a.b() < iB);
                a(iB);
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Integer.valueOf(this.f2301a.k()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f2301a.b() + this.f2301a.u();
            do {
                list.add(Integer.valueOf(this.f2301a.k()));
            } while (this.f2301a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void p(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    c3172b0.c(this.f2301a.g());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f2301a.b() + this.f2301a.u();
                do {
                    c3172b0.c(this.f2301a.g());
                } while (this.f2301a.b() < iB);
                a(iB);
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Integer.valueOf(this.f2301a.g()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f2301a.b() + this.f2301a.u();
            do {
                list.add(Integer.valueOf(this.f2301a.g()));
            } while (this.f2301a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void q(List list) throws C3208n0 {
        a(list, false);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final Object a(U0 u0, H h) throws C3208n0 {
        b(3);
        return c(u0, h);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final Object b(Class cls, H h) throws C3208n0 {
        b(2);
        return d(Q0.c.a(cls), h);
    }

    public final Object d(U0 u0, H h) throws C3211o0 {
        int iU = this.f2301a.u();
        AbstractC3229w abstractC3229w = this.f2301a;
        if (abstractC3229w.f2300a < abstractC3229w.b) {
            int iD = abstractC3229w.d(iU);
            Object objA = u0.a();
            this.f2301a.f2300a++;
            u0.a(objA, this, h);
            u0.c(objA);
            this.f2301a.a(0);
            AbstractC3229w abstractC3229w2 = this.f2301a;
            abstractC3229w2.f2300a--;
            abstractC3229w2.c(iD);
            return objA;
        }
        throw new C3211o0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void i(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    c3172b0.c(this.f2301a.u());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f2301a.b() + this.f2301a.u();
                do {
                    c3172b0.c(this.f2301a.u());
                } while (this.f2301a.b() < iB);
                a(iB);
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Integer.valueOf(this.f2301a.u()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f2301a.b() + this.f2301a.u();
            do {
                list.add(Integer.valueOf(this.f2301a.u()));
            } while (this.f2301a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final AbstractC3221s a() throws C3208n0 {
        b(2);
        return this.f2301a.e();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void a(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof C3228v0) {
            C3228v0 c3228v0 = (C3228v0) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    c3228v0.a(this.f2301a.v());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f2301a.b() + this.f2301a.u();
                do {
                    c3228v0.a(this.f2301a.v());
                } while (this.f2301a.b() < iB);
                a(iB);
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Long.valueOf(this.f2301a.v()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f2301a.b() + this.f2301a.u();
            do {
                list.add(Long.valueOf(this.f2301a.v()));
            } while (this.f2301a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final Object b(U0 u0, H h) throws C3208n0 {
        b(2);
        return d(u0, h);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int b() throws C3208n0 {
        b(0);
        return this.f2301a.g();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void b(List list) throws C3208n0 {
        a(list, true);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void b(List list, U0 u0, H h) throws C3208n0 {
        int iT;
        int i = this.b;
        if ((i & 7) == 2) {
            do {
                list.add(d(u0, h));
                if (this.f2301a.c() || this.d != 0) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == i);
            this.d = iT;
            return;
        }
        int i2 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void d(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof Q) {
            Q q = (Q) list;
            int i = this.b & 7;
            if (i == 2) {
                int iU = this.f2301a.u();
                c(iU);
                int iB = this.f2301a.b() + iU;
                do {
                    q.a(this.f2301a.j());
                } while (this.f2301a.b() < iB);
                return;
            }
            if (i == 5) {
                do {
                    q.a(this.f2301a.j());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 2) {
            int iU2 = this.f2301a.u();
            c(iU2);
            int iB2 = this.f2301a.b() + iU2;
            do {
                list.add(Float.valueOf(this.f2301a.j()));
            } while (this.f2301a.b() < iB2);
            return;
        }
        if (i3 == 5) {
            do {
                list.add(Float.valueOf(this.f2301a.j()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int c() throws C3208n0 {
        b(0);
        return this.f2301a.u();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void c(List list) throws C3211o0 {
        int iT;
        int iT2;
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    c3172b0.c(this.f2301a.p());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f2301a.b() + this.f2301a.u();
                do {
                    c3172b0.c(this.f2301a.p());
                } while (this.f2301a.b() < iB);
                a(iB);
                return;
            }
            int i2 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Integer.valueOf(this.f2301a.p()));
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f2301a.b() + this.f2301a.u();
            do {
                list.add(Integer.valueOf(this.f2301a.p()));
            } while (this.f2301a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    public final void a(List list, boolean z) throws C3208n0 {
        String strR;
        int iT;
        int iT2;
        if ((this.b & 7) == 2) {
            if ((list instanceof InterfaceC3219r0) && !z) {
                InterfaceC3219r0 interfaceC3219r0 = (InterfaceC3219r0) list;
                do {
                    b(2);
                    interfaceC3219r0.a(this.f2301a.e());
                    if (this.f2301a.c()) {
                        return;
                    } else {
                        iT2 = this.f2301a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            do {
                if (z) {
                    b(2);
                    strR = this.f2301a.s();
                } else {
                    b(2);
                    strR = this.f2301a.r();
                }
                list.add(strR);
                if (this.f2301a.c()) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        int i = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void a(List list, U0 u0, H h) throws C3208n0 {
        int iT;
        int i = this.b;
        if ((i & 7) == 3) {
            do {
                list.add(c(u0, h));
                if (this.f2301a.c() || this.d != 0) {
                    return;
                } else {
                    iT = this.f2301a.t();
                }
            } while (iT == i);
            this.d = iT;
            return;
        }
        int i2 = C3211o0.f2292a;
        throw new C3208n0();
    }

    public final void a(int i) throws C3211o0 {
        if (this.f2301a.b() != i) {
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }
}
