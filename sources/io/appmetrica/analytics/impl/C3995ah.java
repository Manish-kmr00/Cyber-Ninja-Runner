package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ah, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3995ah extends X5 {
    public final C4282m5 b;
    public final Zg c;
    public final W3 d;

    public C3995ah(C4282m5 c4282m5, Zg zg) {
        this(c4282m5, zg, new W3());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.appmetrica.analytics.impl.X5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C4045ch load(W5 w5) {
        C4045ch c4045ch = (C4045ch) super.load(w5);
        c4045ch.m = ((Xg) w5.componentArguments).f11419a;
        c4045ch.r = this.b.t.a();
        c4045ch.w = this.b.q.a();
        Xg xg = (Xg) w5.componentArguments;
        c4045ch.d = xg.b;
        c4045ch.e = xg.c;
        c4045ch.f = xg.d;
        c4045ch.i = xg.e;
        c4045ch.g = xg.f;
        c4045ch.h = xg.g;
        Boolean boolValueOf = Boolean.valueOf(xg.h);
        Zg zg = this.c;
        c4045ch.j = boolValueOf;
        c4045ch.k = zg;
        Xg xg2 = (Xg) w5.componentArguments;
        c4045ch.v = xg2.j;
        Hl hl = w5.f11402a;
        C4 c4 = hl.n;
        c4045ch.n = c4.f11083a;
        C4291me c4291me = hl.s;
        if (c4291me != null) {
            c4045ch.s = c4291me.f11672a;
            c4045ch.t = c4291me.b;
        }
        c4045ch.o = c4.b;
        c4045ch.q = hl.e;
        c4045ch.p = hl.k;
        W3 w3 = this.d;
        Map<String, String> map = xg2.i;
        T3 t3E = C4486ua.E.e();
        w3.getClass();
        c4045ch.u = W3.a(map, hl, t3E);
        return c4045ch;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C4045ch(this.b);
    }

    public C3995ah(C4282m5 c4282m5, Zg zg, W3 w3) {
        super(c4282m5.getContext(), c4282m5.b().c());
        this.b = c4282m5;
        this.c = zg;
        this.d = w3;
    }

    public final C4045ch a() {
        return new C4045ch(this.b);
    }
}
