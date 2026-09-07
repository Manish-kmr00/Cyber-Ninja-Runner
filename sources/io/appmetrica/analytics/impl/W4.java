package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;

/* JADX INFO: loaded from: classes3.dex */
public final class W4 extends C4568xh {
    public W4(C4367pf c4367pf) {
        super(c4367pf, new CounterConfiguration());
        b().setReporterType(CounterConfigurationReporterType.COMMUTATION);
    }

    @Override // io.appmetrica.analytics.impl.C4568xh
    public final boolean f() {
        return true;
    }
}
