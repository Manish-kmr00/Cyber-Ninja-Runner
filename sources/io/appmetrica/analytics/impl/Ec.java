package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.internal.CounterConfiguration;

/* JADX INFO: loaded from: classes4.dex */
public final class Ec extends T2 {
    public Ec(Context context, C4367pf c4367pf, ReporterConfig reporterConfig, C4320ni c4320ni, T9 t9) {
        this(context, c4320ni, new C4568xh(c4367pf, new CounterConfiguration(reporterConfig), reporterConfig.userProfileID), t9, C4455t4.i().l(), new C4350on(), new C4467tg(), new C6(), new X(), new C4590ye(t9));
    }

    @Override // io.appmetrica.analytics.impl.T2
    public final String j() {
        return "[ManualReporter]";
    }

    public Ec(Context context, C4320ni c4320ni, C4568xh c4568xh, T9 t9, C4264lc c4264lc, C4350on c4350on, C4467tg c4467tg, C6 c6, X x, C4590ye c4590ye) {
        super(context, c4320ni, c4568xh, t9, c4264lc, c4350on, c4467tg, c6, x, c4590ye);
        C4455t4.i().getClass();
    }
}
