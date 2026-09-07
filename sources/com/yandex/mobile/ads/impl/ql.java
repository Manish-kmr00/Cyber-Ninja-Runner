package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ql {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f10031a;
    private final lp1 b;
    private final zg c;

    public ql(y4 adInfoReportDataProviderFactory, qs adType, o8 adResponse, lp1 metricaReporter, zg assetViewsValidationReportParametersProvider) {
        Intrinsics.checkNotNullParameter(adInfoReportDataProviderFactory, "adInfoReportDataProviderFactory");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        Intrinsics.checkNotNullParameter(assetViewsValidationReportParametersProvider, "assetViewsValidationReportParametersProvider");
        this.f10031a = adResponse;
        this.b = metricaReporter;
        this.c = assetViewsValidationReportParametersProvider;
    }

    public final void a(String str) {
        zg zgVar = this.c;
        zgVar.getClass();
        Intrinsics.checkNotNullParameter("no_view_for_asset", "reason");
        ip1 ip1VarA = zgVar.a();
        ip1VarA.b("no_view_for_asset", "reason");
        ip1VarA.b(str, "asset_name");
        Map<String, Object> mapS = this.f10031a.s();
        if (mapS != null) {
            ip1VarA.a((Map<String, ? extends Object>) mapS);
        }
        ip1VarA.a(this.f10031a.a());
        hp1.b bVar = hp1.b.K;
        Map<String, Object> mapB = ip1VarA.b();
        this.b.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData")));
    }

    public /* synthetic */ ql(y4 y4Var, qs qsVar, o8 o8Var, String str, lp1 lp1Var) {
        this(y4Var, qsVar, o8Var, lp1Var, new zg(y4Var, qsVar, str));
    }

    public final void a(t71 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.c.a(reportParameterManager);
    }
}
