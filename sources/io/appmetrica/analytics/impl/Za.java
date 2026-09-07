package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* JADX INFO: loaded from: classes7.dex */
public interface Za extends InterfaceC3989ab {
    Pa a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC3989ab
    /* synthetic */ Za a();

    void a(ReporterConfig reporterConfig);

    Pa b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    Ya b(ReporterConfig reporterConfig);

    InterfaceC4014bb b(AppMetricaConfig appMetricaConfig);
}
