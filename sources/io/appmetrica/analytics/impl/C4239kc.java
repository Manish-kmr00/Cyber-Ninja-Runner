package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.kc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4239kc extends AbstractC4474tn {
    public final AppMetricaConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4239kc(InterfaceC3989ab interfaceC3989ab, AppMetricaConfig appMetricaConfig) {
        super(interfaceC3989ab);
        String str = appMetricaConfig.apiKey;
        this.b = appMetricaConfig;
    }

    public final InterfaceC4014bb a() {
        return this.f11787a.a().b(this.b);
    }
}
