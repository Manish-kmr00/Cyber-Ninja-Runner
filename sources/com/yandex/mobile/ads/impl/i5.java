package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9175a;
    private final lp1 b;
    private final yg1 c;
    private final id d;
    private dq1 e;
    private cr1 f;
    private boolean g;

    public final void a(Object... listeners) {
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        boolean z = false;
        for (Object obj : listeners) {
            if (obj != null) {
                z = true;
                break;
            }
        }
        this.g = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i5(Context context, o3 o3Var, g5 g5Var) {
        this(context, o3Var, g5Var, nd.a(context, bn2.f8524a, o3Var.q().b()), new h5(g5Var), new id(context));
        o3Var.q().f();
    }

    public i5(Context context, o3 adConfiguration, g5 adLoadingPhasesManager, lp1 metricaReporter, yg1 phasesParametersProvider, id metricaLibraryEventReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        Intrinsics.checkNotNullParameter(phasesParametersProvider, "phasesParametersProvider");
        Intrinsics.checkNotNullParameter(metricaLibraryEventReporter, "metricaLibraryEventReporter");
        this.f9175a = adConfiguration;
        this.b = metricaReporter;
        this.c = phasesParametersProvider;
        this.d = metricaLibraryEventReporter;
    }

    public final void a(String failureReason) {
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        HashMap map = new HashMap();
        map.put("status", "error");
        map.put("failure_reason", failureReason);
        map.put("durations", this.c.a());
        map.put("load_listener_available", Boolean.valueOf(this.g));
        a(map);
    }

    private final void a(HashMap map) {
        ip1 ip1Var = new ip1(map, 2);
        dq1 dq1Var = this.e;
        if (dq1Var != null) {
            ip1Var.a((Map<String, ? extends Object>) dq1Var.a());
        }
        cr1 cr1Var = this.f;
        if (cr1Var != null) {
            ip1Var = jp1.a(ip1Var, cr1Var.a());
        }
        hp1.b bVar = hp1.b.c;
        Map<String, Object> mapB = ip1Var.b();
        hp1 hp1Var = new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1Var, bVar, "reportType", mapB, "reportData"));
        this.b.a(hp1Var);
        if (Intrinsics.areEqual(map.get("status"), "success")) {
            id idVar = this.d;
            Map<String, ? extends Object> mapB2 = hp1Var.b();
            String strJ = this.f9175a.j();
            if (strJ == null) {
                strJ = hp1.a.f9125a;
            }
            idVar.a(bVar, mapB2, strJ, null);
        }
    }

    public final void a() {
        HashMap map = new HashMap();
        map.put("status", "success");
        map.put("durations", this.c.a());
        map.put("load_listener_available", Boolean.valueOf(this.g));
        a(map);
    }

    public final void a(dq1 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.e = reportParameterManager;
    }

    public final void a(cr1 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.f = reportParameterManager;
    }
}
