package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class Ih implements Provider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4377q0 f11198a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ReporterConfig c;

    public Ih(C4377q0 c4377q0, Context context, ReporterConfig reporterConfig) {
        this.f11198a = c4377q0;
        this.b = context;
        this.c = reporterConfig;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        C4377q0 c4377q0 = this.f11198a;
        Context context = this.b;
        ReporterConfig reporterConfig = this.c;
        c4377q0.getClass();
        return C4352p0.a(context).f().c(reporterConfig);
    }
}
