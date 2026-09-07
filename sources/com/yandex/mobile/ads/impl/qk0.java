package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o8<?> f10027a;
    private final o3 b;
    private final t4 c;
    private final lp1 d;
    private final cu1 e;
    private final uq f;
    private final id g;
    private t71 h;

    public final void b(hp1.b reportType, f92 validationResult) {
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        ip1 ip1VarA = a();
        ip1VarA.b(validationResult.b().a(), "reason");
        String strA = validationResult.a();
        if (strA != null && strA.length() > 0) {
            ip1VarA.b(strA, "asset_name");
        }
        hp1 hp1Var = new hp1(reportType, (Map<String, ? extends Object>) ip1VarA.b(), ip1VarA.a());
        this.d.a(hp1Var);
        this.g.a(reportType, hp1Var.b(), hp1.a.f9125a, this.c);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ qk0(Context context, o8 o8Var, o3 o3Var, t4 t4Var) {
        o3Var.q().f();
        o01 o01VarA = nd.a(context, bn2.f8524a, o3Var.q().b());
        int i = iw1.l;
        this(context, o8Var, o3Var, t4Var, o01VarA, iw1.a.a().a(context), new uq(), new id(context));
    }

    public qk0(Context context, o8<?> adResponse, o3 adConfiguration, t4 t4Var, lp1 metricaReporter, cu1 cu1Var, uq commonReportDataProvider, id metricaLibraryEventReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        Intrinsics.checkNotNullParameter(commonReportDataProvider, "commonReportDataProvider");
        Intrinsics.checkNotNullParameter(metricaLibraryEventReporter, "metricaLibraryEventReporter");
        this.f10027a = adResponse;
        this.b = adConfiguration;
        this.c = t4Var;
        this.d = metricaReporter;
        this.e = cu1Var;
        this.f = commonReportDataProvider;
        this.g = metricaLibraryEventReporter;
    }

    private final ip1 a() {
        ip1 ip1VarA = this.f.a(this.f10027a, this.b);
        ip1VarA.b(hp1.a.f9125a, "adapter");
        zy1 zy1VarR = this.b.r();
        if (zy1VarR != null) {
            ip1VarA.b(zy1VarR.a().a(), "size_type");
            ip1VarA.b(Integer.valueOf(zy1VarR.getWidth()), "width");
            ip1VarA.b(Integer.valueOf(zy1VarR.getHeight()), "height");
        }
        cu1 cu1Var = this.e;
        if (cu1Var != null) {
            ip1VarA.b(cu1Var.m(), "banner_size_calculation_type");
        }
        t71 t71Var = this.h;
        return t71Var != null ? jp1.a(ip1VarA, t71Var.a()) : ip1VarA;
    }

    public final void a(hp1.b reportType, f92 validationResult) {
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        ip1 ip1VarA = a();
        ip1VarA.b(validationResult.b().a(), "reason");
        String strA = validationResult.a();
        if (strA != null && strA.length() > 0) {
            ip1VarA.b(strA, "asset_name");
        }
        hp1 hp1Var = new hp1(reportType, (Map<String, ? extends Object>) ip1VarA.b(), ip1VarA.a());
        this.d.a(hp1Var);
        this.g.a(reportType, hp1Var.b(), hp1.a.f9125a, this.c);
    }

    public final void a(hp1.b reportType, Map<String, ? extends Object> additionalReportData) {
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(additionalReportData, "additionalReportData");
        ip1 ip1VarA = a();
        ip1VarA.a(additionalReportData);
        hp1 hp1Var = new hp1(reportType, (Map<String, ? extends Object>) ip1VarA.b(), ip1VarA.a());
        this.d.a(hp1Var);
        this.g.a(reportType, hp1Var.b(), hp1.a.f9125a, this.c);
    }

    public final void a(hp1.b reportType) {
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        ip1 ip1VarA = a();
        hp1 hp1Var = new hp1(reportType, (Map<String, ? extends Object>) ip1VarA.b(), ip1VarA.a());
        this.d.a(hp1Var);
        this.g.a(reportType, hp1Var.b(), hp1.a.f9125a, this.c);
    }

    public final void a(t71 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.h = reportParameterManager;
    }

    public final void a(o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f10027a = adResponse;
    }
}
