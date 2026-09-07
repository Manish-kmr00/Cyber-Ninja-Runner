package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.q9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4386q9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Le f11734a;
    public final Un b;
    public final C4521vk c;
    public final S6 d;
    public final L8 e;
    public final C4322nk f;
    public final C4053d0 g;
    public final X8 h;
    public final C4332o5 i;
    public final TimeProvider j;
    public final int k;
    public long l;
    public int m;

    public C4386q9(Le le, Un un, C4521vk c4521vk, S6 s6, C4053d0 c4053d0, L8 l8, C4322nk c4322nk, int i, C4332o5 c4332o5, X8 x8, SystemTimeProvider systemTimeProvider) {
        this.f11734a = le;
        this.b = un;
        this.c = c4521vk;
        this.d = s6;
        this.g = c4053d0;
        this.e = l8;
        this.f = c4322nk;
        this.k = i;
        this.h = x8;
        this.j = systemTimeProvider;
        this.i = c4332o5;
        this.l = le.h();
        this.m = le.g();
    }

    public final void a(C3984a6 c3984a6, C4571xk c4571xk) {
        Map map = c3984a6.p;
        C4322nk c4322nk = this.f;
        c4322nk.getClass();
        map.putAll(new HashMap(c4322nk.b));
        c3984a6.c(this.f11734a.i());
        c3984a6.o = Integer.valueOf(this.b.b());
        C4028c0 c4028c0A = this.g.a();
        L8 l8 = this.e;
        l8.getClass();
        K8 k8 = (K8) l8.b.a(EnumC4164hb.a(c3984a6.d));
        S6 s6 = this.d;
        E8 e8A = k8.a(c3984a6);
        int i = c3984a6.d;
        X8 x8 = this.h;
        C4359p7 c4359p7 = new C4359p7(s6.g, c4571xk, i, x8, e8A, (C4045ch) s6.h.k.a(), c4028c0A);
        Long lValueOf = Long.valueOf(c4571xk.f11847a);
        EnumC4621zk enumC4621zk = c4571xk.d;
        Long lValueOf2 = Long.valueOf(c4571xk.b);
        EnumC4164hb enumC4164hbA = EnumC4164hb.a(c4359p7.h.d);
        long jOptLong = 0;
        if (!C9.g.contains(EnumC4164hb.a(i))) {
            Un un = x8.b;
            synchronized (un) {
                jOptLong = un.f11384a.a().optLong("global_number", 0L);
            }
            x8.b.b(1 + jOptLong);
        }
        s6.a(s6.l.fromModel(new C4284m7(lValueOf, enumC4621zk, lValueOf2, enumC4164hbA, Long.valueOf(jOptLong), Long.valueOf(c4571xk.c), c4359p7.a())));
        this.i.f11696a.f();
    }
}
