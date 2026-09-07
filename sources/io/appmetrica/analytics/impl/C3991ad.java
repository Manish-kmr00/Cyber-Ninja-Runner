package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ad, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3991ad implements ModuleEventServiceHandlerReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4386q9 f11462a;
    public final C3984a6 b;

    public C3991ad(C4386q9 c4386q9, C3984a6 c3984a6) {
        this.f11462a = c4386q9;
        this.b = c3984a6;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final void report(CounterReportApi counterReportApi) {
        C3984a6 c3984a6D = C3984a6.d(this.b);
        c3984a6D.d = counterReportApi.getType();
        c3984a6D.e = counterReportApi.getCustomType();
        c3984a6D.setName(counterReportApi.getName());
        c3984a6D.setValue(counterReportApi.getValue());
        c3984a6D.setValueBytes(counterReportApi.getValueBytes());
        c3984a6D.g = counterReportApi.getBytesTruncated();
        C4386q9 c4386q9 = this.f11462a;
        c4386q9.a(c3984a6D, C4521vk.a(c4386q9.c.b(c3984a6D), c3984a6D.i));
    }
}
