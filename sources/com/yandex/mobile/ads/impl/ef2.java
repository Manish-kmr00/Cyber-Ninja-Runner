package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ef2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f8794a;
    private final mc2 b;

    public ef2(Context context, o3 adConfiguration, o8<?> adResponse, lp1 metricaReporter, mc2 reportParametersProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        Intrinsics.checkNotNullParameter(reportParametersProvider, "reportParametersProvider");
        this.f8794a = metricaReporter;
        this.b = reportParametersProvider;
    }

    public final void a(String str) {
        ip1 ip1VarA = this.b.a();
        ip1VarA.b(str, "error_message");
        hp1.b bVar = hp1.b.s;
        Map<String, Object> mapB = ip1VarA.b();
        this.f8794a.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData")));
    }
}
