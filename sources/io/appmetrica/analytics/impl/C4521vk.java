package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.vk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4521vk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4282m5 f11819a;
    public final C4496uk b;
    public final C4257l5 c;
    public final AbstractC4127g d;
    public final AbstractC4127g e;
    public C4173hk f;
    public int g = 0;

    public C4521vk(C4282m5 c4282m5, C4496uk c4496uk, C4257l5 c4257l5, C4337oa c4337oa, J2 j2) {
        this.f11819a = c4282m5;
        this.c = c4257l5;
        this.d = c4337oa;
        this.e = j2;
        this.b = c4496uk;
    }

    public final synchronized long a() {
        C4173hk c4173hk;
        c4173hk = this.f;
        return c4173hk == null ? 10000000000L : c4173hk.d - 1;
    }

    public final synchronized C4173hk b(C3984a6 c3984a6) {
        if (this.g == 0) {
            C4173hk c4173hkB = this.d.b();
            if (c4173hkB != null) {
                if (c4173hkB.a(c3984a6.i)) {
                    this.f = c4173hkB;
                    this.g = 3;
                } else {
                    a(c4173hkB, c3984a6);
                }
            }
            C4173hk c4173hkB2 = this.e.b();
            if (c4173hkB2 != null) {
                if (c4173hkB2.a(c3984a6.i)) {
                    this.f = c4173hkB2;
                    this.g = 2;
                } else {
                    a(c4173hkB2, c3984a6);
                }
            }
            this.f = null;
            this.g = 1;
        }
        if (this.g != 1) {
            C4173hk c4173hk = this.f;
            if (c4173hk != null) {
                if (!c4173hk.a(c3984a6.i)) {
                    a(c4173hk, c3984a6);
                }
            }
            this.g = 1;
            this.f = null;
        }
        int iA = Q7.a(this.g);
        if (iA == 1) {
            C4173hk c4173hk2 = this.f;
            long j = c3984a6.i;
            c4173hk2.i = j;
            C4596yk c4596yk = c4173hk2.b;
            c4596yk.a(C4596yk.d, Long.valueOf(j));
            c4596yk.b();
            return this.f;
        }
        if (iA == 2) {
            return this.f;
        }
        this.f11819a.m.info("Start background session", new Object[0]);
        this.g = 2;
        long j2 = c3984a6.i;
        AbstractC4127g abstractC4127g = this.e;
        C4197ik c4197ik = new C4197ik(j2, c3984a6.j);
        abstractC4127g.getClass();
        C4173hk c4173hkA = abstractC4127g.a(c4197ik);
        if (this.f11819a.t.c()) {
            C4257l5 c4257l5 = this.c;
            c4257l5.f11644a.n.a(C3984a6.a(c3984a6, C4486ua.E.h()), a(c4173hkA, c3984a6.i));
        } else {
            int i = c3984a6.d;
            EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
            if (i == 6145) {
                C4257l5 c4257l6 = this.c;
                c4257l6.f11644a.n.a(c3984a6, a(c4173hkA, j2));
                C4257l5 c4257l7 = this.c;
                c4257l7.f11644a.n.a(C3984a6.a(c3984a6, C4486ua.E.h()), a(c4173hkA, j2));
            }
        }
        this.f = c4173hkA;
        return c4173hkA;
    }

    public final synchronized void c(C3984a6 c3984a6) {
        if (this.g == 0) {
            C4173hk c4173hkB = this.d.b();
            if (c4173hkB != null) {
                if (c4173hkB.a(c3984a6.i)) {
                    this.f = c4173hkB;
                    this.g = 3;
                } else {
                    a(c4173hkB, c3984a6);
                }
            }
            C4173hk c4173hkB2 = this.e.b();
            if (c4173hkB2 != null) {
                if (c4173hkB2.a(c3984a6.i)) {
                    this.f = c4173hkB2;
                    this.g = 2;
                } else {
                    a(c4173hkB2, c3984a6);
                }
            }
            this.f = null;
            this.g = 1;
        }
        int iA = Q7.a(this.g);
        if (iA == 0) {
            this.f = a(c3984a6);
        } else if (iA == 1) {
            a(this.f, c3984a6);
            this.f = a(c3984a6);
        } else if (iA == 2) {
            C4173hk c4173hk = this.f;
            if (c4173hk != null) {
                if (c4173hk.a(c3984a6.i)) {
                    C4173hk c4173hk2 = this.f;
                    long j = c3984a6.i;
                    c4173hk2.i = j;
                    C4596yk c4596yk = c4173hk2.b;
                    c4596yk.a(C4596yk.d, Long.valueOf(j));
                    c4596yk.b();
                } else {
                    a(c4173hk, c3984a6);
                }
            }
            this.f = a(c3984a6);
        }
    }

    public final C4173hk a(C3984a6 c3984a6) {
        this.f11819a.m.info("Start foreground session", new Object[0]);
        long j = c3984a6.i;
        AbstractC4127g abstractC4127g = this.d;
        C4197ik c4197ik = new C4197ik(j, c3984a6.j);
        abstractC4127g.getClass();
        C4173hk c4173hkA = abstractC4127g.a(c4197ik);
        this.g = 3;
        ((C4556x5) this.f11819a.p).d();
        C4257l5 c4257l5 = this.c;
        c4257l5.f11644a.n.a(C3984a6.a(c3984a6, C4486ua.E.h()), a(c4173hkA, j));
        return c4173hkA;
    }

    public final void a(C4173hk c4173hk, C3984a6 c3984a6) {
        if (c4173hk.g && c4173hk.d > 0) {
            C4257l5 c4257l5 = this.c;
            C3984a6 c3984a6A = C3984a6.a(c3984a6, EnumC4164hb.EVENT_TYPE_ALIVE);
            C4571xk c4571xk = new C4571xk();
            c4571xk.f11847a = c4173hk.d;
            c4571xk.d = c4173hk.c.f11639a;
            long andIncrement = c4173hk.f.getAndIncrement();
            C4596yk c4596yk = c4173hk.b;
            c4596yk.a(C4596yk.g, Long.valueOf(c4173hk.f.get()));
            c4596yk.b();
            c4571xk.b = andIncrement;
            c4571xk.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(c4173hk.i - c4173hk.e, c4173hk.j));
            c4257l5.f11644a.n.a(c3984a6A, c4571xk);
            if (c4173hk.g) {
                c4173hk.g = false;
                C4596yk c4596yk2 = c4173hk.b;
                c4596yk2.a(C4596yk.i, Boolean.FALSE);
                c4596yk2.b();
            }
        }
        PublicLogger publicLogger = this.f11819a.m;
        int iOrdinal = c4173hk.c.f11639a.ordinal();
        if (iOrdinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (iOrdinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (c4173hk) {
            C4596yk c4596yk3 = c4173hk.b;
            c4596yk3.getClass();
            c4596yk3.c = new C4263lb();
            c4596yk3.b();
            c4173hk.h = null;
        }
    }

    public static C4571xk a(C4173hk c4173hk, long j) {
        C4571xk c4571xk = new C4571xk();
        c4571xk.f11847a = c4173hk.d;
        long andIncrement = c4173hk.f.getAndIncrement();
        C4596yk c4596yk = c4173hk.b;
        c4596yk.a(C4596yk.g, Long.valueOf(c4173hk.f.get()));
        c4596yk.b();
        c4571xk.b = andIncrement;
        C4596yk c4596yk2 = c4173hk.b;
        long j2 = j - c4173hk.e;
        c4173hk.j = j2;
        c4596yk2.a(C4596yk.e, Long.valueOf(j2));
        c4571xk.c = TimeUnit.MILLISECONDS.toSeconds(c4173hk.j);
        c4571xk.d = c4173hk.c.f11639a;
        return c4571xk;
    }
}
