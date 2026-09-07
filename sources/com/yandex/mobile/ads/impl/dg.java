package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class dg {
    private static final AtomicBoolean f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8691a;
    private final uu1 b;
    private final iw1 c;
    private final lp1 d;
    private final m80 e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ dg(Context context, uu1 uu1Var) {
        this(context, uu1Var, iw1.a.a(), uu1Var.c(), m80.a.a(context));
        int i = iw1.l;
    }

    public dg(Context appContext, uu1 sdkEnvironmentModule, iw1 settings, lp1 metricaReporter, m80 falseClickDataStorage) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        Intrinsics.checkNotNullParameter(falseClickDataStorage, "falseClickDataStorage");
        this.f8691a = appContext;
        this.b = sdkEnvironmentModule;
        this.c = settings;
        this.d = metricaReporter;
        this.e = falseClickDataStorage;
    }

    public final void a() {
        cu1 cu1VarA = this.c.a(this.f8691a);
        if (cu1VarA == null || !cu1VarA.q0() || f.getAndSet(true)) {
            return;
        }
        for (k80 k80Var : this.e.b()) {
            if (k80Var.d() != null) {
                j80 j80VarD = k80Var.d();
                new q80(this.f8691a, new o3(k80Var.c(), this.b), j80VarD).a(j80VarD.c());
            }
            this.e.a(k80Var.f());
            long jCurrentTimeMillis = System.currentTimeMillis() - k80Var.f();
            Map reportData = MapsKt.toMutableMap(k80Var.e());
            reportData.put("interval", cq0.a(jCurrentTimeMillis));
            hp1.b reportType = hp1.b.M;
            f fVarA = k80Var.a();
            Intrinsics.checkNotNullParameter(reportType, "reportType");
            Intrinsics.checkNotNullParameter(reportData, "reportData");
            this.d.a(new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), fVarA));
        }
        this.e.a();
    }
}
