package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfiguration;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ni, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4320ni {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W4 f11687a;
    public final C4375pn b;
    public final C4345oi c;
    public final C4178i0 d;
    public InterfaceC4422rl e;
    public final Lj f;

    public C4320ni(C4178i0 c4178i0, C4375pn c4375pn, W4 w4, Lj lj) {
        this(c4178i0, c4375pn, w4, lj, new C4345oi(c4178i0, lj));
    }

    public final void a(C4319nh c4319nh) {
        C4568xh c4568xh = c4319nh.e;
        InterfaceC4422rl interfaceC4422rl = this.e;
        if (interfaceC4422rl != null) {
            c4568xh.b.setUuid(((C4398ql) interfaceC4422rl).g());
        } else {
            c4568xh.getClass();
        }
        this.c.a(c4319nh);
    }

    public final void b(String str) {
        C4367pf c4367pf = this.f11687a.f11474a;
        synchronized (c4367pf) {
            c4367pf.f11723a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public C4320ni(C4178i0 c4178i0, C4375pn c4375pn, W4 w4, Lj lj, C4345oi c4345oi) {
        this.d = c4178i0;
        this.f11687a = w4;
        this.b = c4375pn;
        this.f = lj;
        this.c = c4345oi;
    }

    public final void a(C4398ql c4398ql) {
        this.e = c4398ql;
        this.f11687a.b.setUuid(c4398ql.g());
    }

    public final void a(Boolean bool, Boolean bool2, Boolean bool3) {
        if (In.a(bool)) {
            this.f11687a.b.setLocationTracking(bool.booleanValue());
        }
        if (In.a(bool2)) {
            this.f11687a.b.setDataSendingEnabled(bool2.booleanValue());
        }
        if (In.a(bool3)) {
            this.f11687a.b.setAdvIdentifiersTracking(bool3.booleanValue());
        }
        C3984a6 c3984a6A = C3984a6.a();
        W4 w4 = this.f11687a;
        a(a(c3984a6A, w4), w4, 1, null);
    }

    public final void a(C3984a6 c3984a6, C4568xh c4568xh, int i, Map map) {
        String str;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!In.a(map)) {
            c3984a6.setValue(AbstractC4288mb.b(map));
            a(c3984a6, c4568xh);
        }
        C4367pf c4367pf = new C4367pf(c4568xh.f11474a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c4568xh.b);
        synchronized (c4568xh) {
            str = c4568xh.f;
        }
        a(new C4319nh(c3984a6, false, i, null, new C4568xh(c4367pf, counterConfiguration, str)));
    }

    public static C3984a6 a(C3984a6 c3984a6, C4568xh c4568xh) {
        if (C9.f11086a.contains(Integer.valueOf(c3984a6.d))) {
            c3984a6.c = c4568xh.d();
        }
        return c3984a6;
    }

    public final void a(List list) {
        C4367pf c4367pf = this.f11687a.f11474a;
        synchronized (c4367pf) {
            c4367pf.f11723a.put("PROCESS_CFG_CUSTOM_HOSTS", In.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap map) {
        C4367pf c4367pf = this.f11687a.f11474a;
        synchronized (c4367pf) {
            c4367pf.f11723a.put("PROCESS_CFG_CLIDS", AbstractC4288mb.b(map));
        }
    }

    public final void a(String str) {
        C4367pf c4367pf = this.f11687a.f11474a;
        synchronized (c4367pf) {
            c4367pf.f11723a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }
}
