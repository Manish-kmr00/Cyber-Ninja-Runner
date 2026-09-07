package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class af1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f8404a;
    private final bl b;
    private final yg1 c;

    public af1(g5 adLoadingPhasesManager, lp1 reporter, bl reportDataProvider, yg1 phasesParametersProvider) {
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(reportDataProvider, "reportDataProvider");
        Intrinsics.checkNotNullParameter(phasesParametersProvider, "phasesParametersProvider");
        this.f8404a = reporter;
        this.b = reportDataProvider;
        this.c = phasesParametersProvider;
    }

    public final void a(cl clVar) {
        Intrinsics.checkNotNullParameter("Cannot load bidder token. Token generation failed", "reason");
        this.b.getClass();
        ip1 ip1VarA = bl.a(clVar);
        ip1VarA.b(hp1.c.d.a(), "status");
        ip1VarA.b("Cannot load bidder token. Token generation failed", "failure_reason");
        ip1VarA.b(this.c.a(), "durations");
        hp1.b bVar = hp1.b.W;
        Map<String, Object> mapB = ip1VarA.b();
        this.f8404a.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData")));
    }

    public final void a(cl clVar, au1 au1Var) {
        this.b.getClass();
        ip1 ip1VarA = bl.a(clVar);
        ip1VarA.b(hp1.c.c.a(), "status");
        ip1VarA.b(this.c.a(), "durations");
        ip1VarA.a(au1Var != null ? au1Var.a() : null, "stub_reason");
        hp1.b bVar = hp1.b.W;
        Map<String, Object> mapB = ip1VarA.b();
        this.f8404a.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData")));
    }
}
