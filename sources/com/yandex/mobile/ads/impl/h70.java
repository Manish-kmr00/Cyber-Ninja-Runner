package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f9067a;
    private final zg b;
    private final lp1 c;

    public h70(Context context, o3 adConfiguration, y4 adInfoReportDataProviderFactory, qs adType, o8 adResponse, zg assetViewsValidationReportParametersProvider, lp1 metricaReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adInfoReportDataProviderFactory, "adInfoReportDataProviderFactory");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(assetViewsValidationReportParametersProvider, "assetViewsValidationReportParametersProvider");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        this.f9067a = adResponse;
        this.b = assetViewsValidationReportParametersProvider;
        this.c = metricaReporter;
    }

    public final void a(ArrayList assetNames) {
        Intrinsics.checkNotNullParameter(assetNames, "assetNames");
        zg zgVar = this.b;
        zgVar.getClass();
        Intrinsics.checkNotNullParameter("no_view_for_asset", "reason");
        ip1 ip1VarA = zgVar.a();
        ip1VarA.b("no_view_for_asset", "reason");
        ip1VarA.b(assetNames, POBNativeConstants.NATIVE_ASSETS);
        Map<String, Object> mapS = this.f9067a.s();
        if (mapS != null) {
            ip1VarA.a((Map<String, ? extends Object>) mapS);
        }
        ip1VarA.a(this.f9067a.a());
        hp1.b bVar = hp1.b.L;
        Map<String, Object> mapB = ip1VarA.b();
        this.c.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData")));
    }

    public /* synthetic */ h70(Context context, o3 o3Var, y4 y4Var, qs qsVar, o8 o8Var, String str) {
        zg zgVar = new zg(y4Var, qsVar, str);
        o3Var.q().f();
        this(context, o3Var, y4Var, qsVar, o8Var, zgVar, nd.a(context, bn2.f8524a, o3Var.q().b()));
    }

    public final void a(t71 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.b.a(reportParameterManager);
    }
}
