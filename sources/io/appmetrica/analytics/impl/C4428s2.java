package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.s2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4428s2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Ql fromModel(BillingConfig billingConfig) {
        Ql ql = new Ql();
        ql.f11318a = billingConfig.sendFrequencySeconds;
        ql.b = billingConfig.firstCollectingInappMaxAgeSeconds;
        return ql;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ql ql = (Ql) obj;
        return new BillingConfig(ql.f11318a, ql.b);
    }

    public final BillingConfig a(Ql ql) {
        return new BillingConfig(ql.f11318a, ql.b);
    }
}
