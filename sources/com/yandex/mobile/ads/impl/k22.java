package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k22 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f9374a;

    public k22(lp1 reporter) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.f9374a = reporter;
    }

    public final void a(dl0 initializationCallSource) {
        Intrinsics.checkNotNullParameter(initializationCallSource, "initializationCallSource");
        lp1 lp1Var = this.f9374a;
        hp1.b reportType = hp1.b.b0;
        Map reportData = MapsKt.mapOf(TuplesKt.to("call_source", initializationCallSource.a()));
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        lp1Var.a(new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), (f) null));
    }
}
