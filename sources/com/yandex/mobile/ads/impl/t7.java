package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class t7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f10273a;
    private final o3 b;
    private final pg0 c;
    private final lp1 d;
    private final yg1 e;
    private final cu1 f;

    public /* synthetic */ t7(Context context, o8 o8Var, o3 o3Var, g5 g5Var, pg0 pg0Var) {
        o3Var.q().f();
        o01 o01VarA = nd.a(context, bn2.f8524a, o3Var.q().b());
        s7 s7Var = new s7(g5Var);
        int i = iw1.l;
        this(context, o8Var, o3Var, g5Var, pg0Var, o01VarA, s7Var, iw1.a.a().a(context));
    }

    public final void a() {
        ip1 ip1VarA = this.c.a();
        ip1VarA.b(hp1.a.f9125a, "adapter");
        ip1VarA.a(this.e.a());
        zy1 zy1VarR = this.b.r();
        if (zy1VarR != null) {
            ip1VarA.b(zy1VarR.a().a(), "size_type");
            ip1VarA.b(Integer.valueOf(zy1VarR.getWidth()), "width");
            ip1VarA.b(Integer.valueOf(zy1VarR.getHeight()), "height");
        }
        cu1 cu1Var = this.f;
        if (cu1Var != null) {
            ip1VarA.b(cu1Var.m(), "banner_size_calculation_type");
        }
        ip1VarA.a(this.f10273a.a());
        hp1.b bVar = hp1.b.d;
        Map<String, Object> mapB = ip1VarA.b();
        this.d.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData")));
    }

    public t7(Context context, o8<?> adResponse, o3 adConfiguration, g5 adLoadingPhasesManager, pg0 reportParameterManager, lp1 metricaReporter, yg1 phasesParametersProvider, cu1 cu1Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        Intrinsics.checkNotNullParameter(phasesParametersProvider, "phasesParametersProvider");
        this.f10273a = adResponse;
        this.b = adConfiguration;
        this.c = reportParameterManager;
        this.d = metricaReporter;
        this.e = phasesParametersProvider;
        this.f = cu1Var;
    }
}
