package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.vc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4513vc extends C4282m5 implements Ta, Sa {
    public final C3994ag v;
    public final C4094eg w;
    public final L6 x;
    public final C4255l3 y;

    public C4513vc(Context context, Hl hl, C4108f5 c4108f5, F4 f4, C3994ag c3994ag, L6 l6, AbstractC4232k5 abstractC4232k5) {
        this(context, c4108f5, hl, f4, new C4078e0(), new TimePassedChecker(), new C4563xc(context, c4108f5, f4, abstractC4232k5, hl, new C4389qc(l6), C4486ua.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), C4486ua.j().w(), C4486ua.j().k(), new C4214jc()), c3994ag, l6);
    }

    @Override // io.appmetrica.analytics.impl.C4282m5
    public final void B() {
        this.v.a(this.w);
    }

    public final boolean C() {
        boolean zOptBoolean;
        Un un = this.t;
        synchronized (un) {
            zOptBoolean = un.f11384a.a().optBoolean("referrer_handled", false);
        }
        return zOptBoolean;
    }

    @Override // io.appmetrica.analytics.impl.C4282m5, io.appmetrica.analytics.impl.Wa, io.appmetrica.analytics.impl.La
    public final synchronized void a(F4 f4) {
        super.a(f4);
        this.x.a(f4.i);
    }

    @Override // io.appmetrica.analytics.impl.C4282m5, io.appmetrica.analytics.impl.La
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MAIN;
    }

    @Override // io.appmetrica.analytics.impl.C4282m5, io.appmetrica.analytics.impl.Wa, io.appmetrica.analytics.impl.InterfaceC4447sl
    public final void a(Hl hl) {
        super.a(hl);
        this.y.a(hl);
    }

    @Override // io.appmetrica.analytics.impl.Sa
    public final void a() {
        Un un = this.t;
        synchronized (un) {
            Vn vn = un.f11384a;
            vn.a(vn.a().put("referrer_handled", true));
        }
    }

    public C4513vc(Context context, C4108f5 c4108f5, Hl hl, F4 f4, C4078e0 c4078e0, TimePassedChecker timePassedChecker, C4563xc c4563xc, C3994ag c3994ag, L6 l6) {
        super(context, c4108f5, c4078e0, timePassedChecker, c4563xc, f4);
        this.v = c3994ag;
        C4062d9 c4062d9J = j();
        c4062d9J.a(EnumC4164hb.EVENT_TYPE_REGULAR, new C4542wg(c4062d9J.b()));
        this.w = c4563xc.b(this);
        this.x = l6;
        C4255l3 c4255l3A = c4563xc.a(this);
        this.y = c4255l3A;
        c4255l3A.a(hl, f4.m);
    }
}
