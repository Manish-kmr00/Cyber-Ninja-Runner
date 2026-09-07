package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ci, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C4046ci implements Za {
    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.InterfaceC3989ab
    public final Za a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final Pa b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new Dc();
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final Ya b(ReporterConfig reporterConfig) {
        return new Zh();
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final Pa a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new Dc();
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final InterfaceC4014bb b(AppMetricaConfig appMetricaConfig) {
        return new Zh();
    }
}
