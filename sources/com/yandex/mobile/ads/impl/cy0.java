package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class cy0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f8651a;
    private final o8<?> b;
    private final by0 c;
    private final rz0 d;
    private final rr1 e;

    public final void a(Context context, hz0 mediationNetwork, Map<String, ? extends Object> additionalReportData, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(additionalReportData, "additionalReportData");
        a(context, hp1.b.f, mediationNetwork, str, additionalReportData);
    }

    public final void b(Context context, hz0 mediationNetwork, Map<String, ? extends Object> additionalReportData, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(additionalReportData, "additionalReportData");
        a(context, hp1.b.v, mediationNetwork, str, additionalReportData);
    }

    public final void c(Context context, hz0 mediationNetwork, Map<String, ? extends Object> additionalReportData, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(additionalReportData, "additionalReportData");
        a(context, hp1.b.C, mediationNetwork, str, additionalReportData);
    }

    public final void d(Context context, hz0 mediationNetwork, Map<String, ? extends Object> reportData, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        a(context, hp1.b.x, mediationNetwork, str, reportData);
        a(context, hp1.b.y, mediationNetwork, str, reportData);
    }

    public final void e(Context context, hz0 mediationNetwork, Map<String, ? extends Object> additionalReportData, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(additionalReportData, "additionalReportData");
        a(context, hp1.b.B, mediationNetwork, str, additionalReportData);
    }

    public final void f(Context context, hz0 mediationNetwork, Map<String, ? extends Object> additionalReportData, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(additionalReportData, "additionalReportData");
        a(context, hp1.b.e, mediationNetwork, str, additionalReportData);
    }

    public final void g(Context context, hz0 mediationNetwork, Map<String, ? extends Object> additionalReportData, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(additionalReportData, "additionalReportData");
        a(context, hp1.b.h, mediationNetwork, str, additionalReportData);
    }

    public final void h(Context context, hz0 mediationNetwork, Map<String, ? extends Object> reportData, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        a(context, hp1.b.i, mediationNetwork, str, reportData);
    }

    public /* synthetic */ cy0(o3 o3Var, o8 o8Var) {
        this(o3Var, o8Var, new by0(), new rz0(), new rr1());
    }

    public cy0(o3 adConfiguration, o8<?> o8Var, by0 mediatedAdapterReportDataProvider, rz0 mediationNetworkReportDataProvider, rr1 rewardInfoProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(mediatedAdapterReportDataProvider, "mediatedAdapterReportDataProvider");
        Intrinsics.checkNotNullParameter(mediationNetworkReportDataProvider, "mediationNetworkReportDataProvider");
        Intrinsics.checkNotNullParameter(rewardInfoProvider, "rewardInfoProvider");
        this.f8651a = adConfiguration;
        this.b = o8Var;
        this.c = mediatedAdapterReportDataProvider;
        this.d = mediationNetworkReportDataProvider;
        this.e = rewardInfoProvider;
    }

    private final void a(Context context, hp1.b bVar, hz0 mediationNetwork, String str, Map<String, ? extends Object> map) {
        ip1 ip1VarA = this.c.a(this.b, this.f8651a);
        this.d.getClass();
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        ip1 ip1Var = new ip1(new LinkedHashMap(), 2);
        ip1Var.b(mediationNetwork.e(), "adapter");
        ip1Var.b(mediationNetwork.i(), "adapter_parameters");
        ip1 ip1VarA2 = jp1.a(ip1VarA, ip1Var);
        ip1VarA2.a(map);
        Map<String, Object> mapB = ip1VarA2.b();
        hp1 hp1Var = new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA2, bVar, "reportType", mapB, "reportData"));
        this.f8651a.q().f();
        nd.a(context, bn2.f8524a, this.f8651a.q().b()).a(hp1Var);
        new id(context).a(bVar, hp1Var.b(), str, mediationNetwork.c());
    }

    public final void a(Context context, hz0 mediationNetwork, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        a(context, hp1.b.v, mediationNetwork, str, MapsKt.emptyMap());
    }

    public final void b(Context context, hz0 mediationNetwork, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        a(context, hp1.b.g, mediationNetwork, str, MapsKt.emptyMap());
    }

    public final void a(Context context, hz0 mediationNetwork, o8<?> o8Var, String str) {
        Map mapEmptyMap;
        nr1 nr1VarJ;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        this.e.getClass();
        Boolean boolValueOf = (o8Var == null || (nr1VarJ = o8Var.J()) == null) ? null : Boolean.valueOf(nr1VarJ.e());
        if (Intrinsics.areEqual(boolValueOf, Boolean.TRUE)) {
            mapEmptyMap = MapsKt.mapOf(TuplesKt.to("rewarding_side", "server_side"));
        } else if (Intrinsics.areEqual(boolValueOf, Boolean.FALSE)) {
            mapEmptyMap = MapsKt.mapOf(TuplesKt.to("rewarding_side", "client_side"));
        } else if (boolValueOf == null) {
            mapEmptyMap = MapsKt.emptyMap();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        a(context, hp1.b.N, mediationNetwork, str, MapsKt.mapOf(TuplesKt.to("reward_info", mapEmptyMap)));
    }
}
