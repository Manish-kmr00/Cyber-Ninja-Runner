package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.aj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3997aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11466a;
    public final Context b;
    public final CounterConfigurationReporterType c;
    public final C4072dj d;

    public C3997aj(String str, Context context, CounterConfigurationReporterType counterConfigurationReporterType, C4072dj c4072dj) {
        this.f11466a = str;
        this.b = context;
        int i = Zi.f11451a[counterConfigurationReporterType.ordinal()];
        if (i == 1) {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = c4072dj;
    }
}
