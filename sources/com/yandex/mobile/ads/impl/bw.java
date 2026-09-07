package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bw implements aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f8540a;
    private final ip1 b;

    public bw(o01 metricaReporter, ip1 reportDataWrapper) {
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        Intrinsics.checkNotNullParameter(reportDataWrapper, "reportDataWrapper");
        this.f8540a = metricaReporter;
        this.b = reportDataWrapper;
    }

    @Override // com.yandex.mobile.ads.impl.aw
    public final void a(zv eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.b.b(eventType.a(), "log_type");
        hp1.b bVar = hp1.b.V;
        Map<String, Object> mapB = this.b.b();
        this.f8540a.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(this.b, bVar, "reportType", mapB, "reportData")));
    }
}
