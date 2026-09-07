package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9702a;
    private final lp1 b;

    public final void a(Map reportData, cu1 cu1Var) {
        hp1.b reportType = hp1.b.Z;
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        if (cu1Var == null || !cu1Var.I()) {
            return;
        }
        o3 o3Var = this.f9702a;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("ad_type", o3Var.b().a());
        String strC = o3Var.c();
        if (strC == null) {
            strC = "";
        }
        pairArr[1] = TuplesKt.to("ad_unit_id", strC);
        Map reportData2 = MapsKt.plus(MapsKt.mapOf(pairArr), reportData);
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData2, "reportData");
        this.b.a(new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData2), (f) null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n62(Context context, o3 o3Var) {
        this(context, o3Var, nd.a(context, bn2.f8524a, o3Var.q().b()));
        o3Var.q().f();
    }

    public n62(Context context, o3 adConfiguration, lp1 metricaReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        this.f9702a = adConfiguration;
        this.b = metricaReporter;
    }
}
