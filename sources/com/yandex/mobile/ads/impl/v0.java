package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f10439a;
    private final uq b;

    public final void a(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.f10439a.reportError("Failed to register ActivityResult", throwable);
    }

    public /* synthetic */ v0(lp1 lp1Var) {
        this(lp1Var, new uq());
    }

    public v0(lp1 reporter, uq commonReportDataProvider) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(commonReportDataProvider, "commonReportDataProvider");
        this.f10439a = reporter;
        this.b = commonReportDataProvider;
    }

    public final void a(c1 adActivityData) {
        Intrinsics.checkNotNullParameter(adActivityData, "adActivityData");
        ip1 ip1VarA = this.b.a(adActivityData.c(), adActivityData.b());
        hp1.b bVar = hp1.b.c0;
        Map<String, Object> mapB = ip1VarA.b();
        this.f10439a.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData")));
    }
}
