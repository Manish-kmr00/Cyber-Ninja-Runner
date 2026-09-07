package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c8 f9098a;
    private final lp1 b;
    private final kf1 c;

    public final void a(fh2 viewSizeInfo, o3 adConfiguration) {
        String str;
        zy1.a aVarA;
        Intrinsics.checkNotNullParameter(viewSizeInfo, "viewSizeInfo");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        v7 v7VarA = adConfiguration.a();
        ip1 ip1VarA = v7VarA != null ? this.f9098a.a(v7VarA) : new ip1((Map) null, 3);
        v7 v7VarA2 = adConfiguration.a();
        if (v7VarA2 != null) {
            jp1.a(ip1VarA, this.f9098a.a(v7VarA2));
        }
        ip1VarA.b(adConfiguration.c(), "ad_unit_id");
        ip1VarA.b(adConfiguration.c(), "block_id");
        kf1 kf1Var = this.c;
        int iO = adConfiguration.o();
        kf1Var.getClass();
        if (iO != 1) {
            str = iO != 2 ? "undefined" : "landscape";
        } else {
            str = "portrait";
        }
        ip1VarA.b(str, "orientation");
        zy1 zy1VarR = adConfiguration.r();
        ip1VarA.a((zy1VarR == null || (aVarA = zy1VarR.a()) == null) ? null : aVarA.a(), "size_type");
        zy1 zy1VarR2 = adConfiguration.r();
        ip1VarA.a(zy1VarR2 != null ? Integer.valueOf(zy1VarR2.getWidth()) : null, "size_info_width");
        zy1 zy1VarR3 = adConfiguration.r();
        ip1VarA.a(zy1VarR3 != null ? Integer.valueOf(zy1VarR3.getHeight()) : null, "size_info_height");
        ip1VarA.b(Integer.valueOf(viewSizeInfo.d().b()), "view_width");
        ip1VarA.b(Integer.valueOf(viewSizeInfo.d().a()), "view_height");
        ip1VarA.a(viewSizeInfo.b().b(), "layout_width");
        ip1VarA.a(viewSizeInfo.b().a(), "layout_height");
        ip1VarA.b(Integer.valueOf(viewSizeInfo.c().b().b()), "measured_width");
        String strName = viewSizeInfo.c().b().a().name();
        Locale locale = Locale.ROOT;
        String lowerCase = strName.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        ip1VarA.b(lowerCase, "measured_width_mode");
        ip1VarA.b(Integer.valueOf(viewSizeInfo.c().a().b()), "measured_height");
        String lowerCase2 = viewSizeInfo.c().a().a().name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        ip1VarA.b(lowerCase2, "measured_height_mode");
        hp1.b bVar = hp1.b.Q;
        Map<String, Object> mapB = ip1VarA.b();
        this.b.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData")));
    }

    public /* synthetic */ hh2(Context context, o3 o3Var) {
        c8 c8Var = new c8();
        o3Var.q().f();
        this(context, o3Var, c8Var, nd.a(context, bn2.f8524a, o3Var.q().b()), new kf1());
    }

    public hh2(Context context, o3 adConfiguration, c8 adRequestReportDataProvider, lp1 metricaReporter, kf1 orientationNameProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adRequestReportDataProvider, "adRequestReportDataProvider");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        Intrinsics.checkNotNullParameter(orientationNameProvider, "orientationNameProvider");
        this.f9098a = adRequestReportDataProvider;
        this.b = metricaReporter;
        this.c = orientationNameProvider;
    }
}
