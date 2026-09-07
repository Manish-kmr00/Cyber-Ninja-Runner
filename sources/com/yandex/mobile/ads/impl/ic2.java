package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ic2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mc2 f9201a;
    private final lp1 b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ic2(Context context, o3 o3Var, mc2 mc2Var) {
        this(context, o3Var, mc2Var, nd.a(context, bn2.f8524a, o3Var.q().b()));
        o3Var.q().f();
    }

    public ic2(Context context, o3 adConfiguration, mc2 reportParametersProvider, lp1 metricaReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(reportParametersProvider, "reportParametersProvider");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        this.f9201a = reportParametersProvider;
        this.b = metricaReporter;
    }

    public final void b() {
        hp1.b bVar = hp1.b.q;
        ip1 ip1VarA = this.f9201a.a();
        Map<String, Object> mapB = ip1VarA.b();
        this.b.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData")));
    }

    public final void a() {
        hp1.b bVar = hp1.b.r;
        ip1 ip1VarA = this.f9201a.a();
        Map<String, Object> mapB = ip1VarA.b();
        this.b.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData")));
    }
}
