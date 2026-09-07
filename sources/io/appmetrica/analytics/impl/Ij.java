package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;

/* JADX INFO: loaded from: classes5.dex */
public final class Ij extends C4282m5 {
    public Ij(Context context, Hl hl, C4108f5 c4108f5, F4 f4, Zg zg, AbstractC4232k5 abstractC4232k5, C4083e5 c4083e5) {
        this(context, c4108f5, new C4078e0(), new TimePassedChecker(), new C4406r5(context, c4108f5, f4, abstractC4232k5, hl, zg, C4486ua.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), C4486ua.j().k(), c4083e5), f4);
    }

    @Override // io.appmetrica.analytics.impl.C4282m5, io.appmetrica.analytics.impl.La
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public Ij(Context context, C4108f5 c4108f5, C4078e0 c4078e0, TimePassedChecker timePassedChecker, C4406r5 c4406r5, F4 f4) {
        super(context, c4108f5, c4078e0, timePassedChecker, c4406r5, f4);
    }
}
