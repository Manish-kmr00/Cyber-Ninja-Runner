package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class cp implements mp1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f8631a;
    private final o3 b;
    private final v41 c;
    private final lp1 d;
    private final uq e;
    private final id f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cp(Context context, o8 o8Var, o3 o3Var, v41 v41Var) {
        this(context, o8Var, o3Var, v41Var, nd.a(context, bn2.f8524a, o3Var.q().b()), new uq(), new id(context));
        o3Var.q().f();
    }

    private final hp1 a(hp1.b bVar, HashMap map) {
        ip1 ip1Var = new ip1(map, 2);
        ip1Var.b(hp1.a.f9125a, "adapter");
        ip1 ip1VarA = jp1.a(ip1Var, this.e.a(this.f8631a, this.b));
        zy1 zy1VarR = this.b.r();
        if (zy1VarR != null) {
            ip1VarA.b(zy1VarR.a().a(), "size_type");
            ip1VarA.b(Integer.valueOf(zy1VarR.getWidth()), "width");
            ip1VarA.b(Integer.valueOf(zy1VarR.getHeight()), "height");
        }
        v41 v41Var = this.c;
        if (v41Var != null) {
            ip1VarA.a((Map<String, ? extends Object>) v41Var.a());
        }
        Map<String, Object> mapB = ip1VarA.b();
        return new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData"));
    }

    public cp(Context context, o8<?> adResponse, o3 adConfiguration, v41 v41Var, lp1 metricaReporter, uq commonReportDataProvider, id metricaLibraryEventReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        Intrinsics.checkNotNullParameter(commonReportDataProvider, "commonReportDataProvider");
        Intrinsics.checkNotNullParameter(metricaLibraryEventReporter, "metricaLibraryEventReporter");
        this.f8631a = adResponse;
        this.b = adConfiguration;
        this.c = v41Var;
        this.d = metricaReporter;
        this.e = commonReportDataProvider;
        this.f = metricaLibraryEventReporter;
    }

    @Override // com.yandex.mobile.ads.impl.mp1
    public final void a(hp1.b reportType) {
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        this.d.a(a(reportType, new HashMap()));
    }

    @Override // com.yandex.mobile.ads.impl.mp1
    public final void a(HashMap reportData) {
        hp1.b reportType = hp1.b.C;
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        hp1 hp1VarA = a(reportType, reportData);
        this.d.a(hp1VarA);
        this.f.a(reportType, hp1VarA.b(), hp1.a.f9125a, null);
    }
}
