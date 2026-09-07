package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.v6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4507v6 extends T2 {
    public final C4532w6 o;
    public final C4375pn p;

    public C4507v6(Context context, C4367pf c4367pf, AppMetricaConfig appMetricaConfig, C4320ni c4320ni, T9 t9) {
        this(context, c4320ni, new C4568xh(c4367pf, new CounterConfiguration(appMetricaConfig, CounterConfigurationReporterType.CRASH), appMetricaConfig.userProfileID), t9, new C4532w6(context), new C4375pn(), C4455t4.i().l(), new C4350on(), new C4467tg(), new C6(), new X(), new C4590ye(t9));
    }

    @Override // io.appmetrica.analytics.impl.T2, io.appmetrica.analytics.impl.Ya, io.appmetrica.analytics.impl.InterfaceC4014bb
    public final void a(C4325nn c4325nn) {
        this.o.a(this.p.a(c4325nn, this.b));
        this.c.info("Unhandled exception received: " + c4325nn, new Object[0]);
    }

    public final void b(AppMetricaConfig appMetricaConfig) {
        b(appMetricaConfig.errorEnvironment);
    }

    @Override // io.appmetrica.analytics.impl.T2
    public final String j() {
        return "[CrashReporter]";
    }

    public C4507v6(Context context, C4320ni c4320ni, C4568xh c4568xh, T9 t9, C4532w6 c4532w6, C4375pn c4375pn, C4264lc c4264lc, C4350on c4350on, C4467tg c4467tg, C6 c6, X x, C4590ye c4590ye) {
        super(context, c4320ni, c4568xh, t9, c4264lc, c4350on, c4467tg, c6, x, c4590ye);
        this.o = c4532w6;
        this.p = c4375pn;
        C4455t4.i().getClass();
    }
}
