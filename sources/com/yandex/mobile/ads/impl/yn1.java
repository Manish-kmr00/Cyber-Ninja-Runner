package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class yn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f10757a;
    private final lp1 b;
    private final zg c;
    private boolean d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ yn1(Context context, o3 o3Var, y4 y4Var, qs qsVar, o8 o8Var, String str) {
        this(context, o3Var, y4Var, qsVar, o8Var, str, nd.a(context, bn2.f8524a, o3Var.q().b()));
        o3Var.q().f();
    }

    public yn1(Context context, o3 adConfiguration, y4 adInfoReportDataProviderFactory, qs adType, o8<?> adResponse, String str, lp1 metricaReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adInfoReportDataProviderFactory, "adInfoReportDataProviderFactory");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        this.f10757a = adResponse;
        this.b = metricaReporter;
        this.c = new zg(adInfoReportDataProviderFactory, adType, str);
        this.d = true;
    }

    public final void a() {
        if (!this.d) {
            ip1 ip1VarA = this.c.a();
            Map<String, Object> mapS = this.f10757a.s();
            if (mapS != null) {
                ip1VarA.a((Map<String, ? extends Object>) mapS);
            }
            ip1VarA.a(this.f10757a.a());
            hp1.b bVar = hp1.b.J;
            Map<String, Object> mapB = ip1VarA.b();
            this.b.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData")));
            return;
        }
        this.d = false;
    }

    public final void a(t71 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.c.a(reportParameterManager);
    }
}
