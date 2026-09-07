package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class mv1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f9672a;
    private final boolean b;
    private final s32 c;
    private final gz0 d;
    private final yg1 e;

    public final void a(w3 adRequestError, dl0 initializationCallSource, ir irVar) {
        Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
        Intrinsics.checkNotNullParameter(initializationCallSource, "initializationCallSource");
        lp1 lp1Var = this.f9672a;
        hp1.b reportType = hp1.b.Y;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("failure_reason", adRequestError.c());
        pairArr[1] = TuplesKt.to("call_source", initializationCallSource.a());
        pairArr[2] = TuplesKt.to("configuration_source", irVar != null ? irVar.a() : null);
        pairArr[3] = TuplesKt.to("durations", this.e.a());
        Map reportData = MapsKt.mapOf(pairArr);
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        lp1Var.a(new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), (f) null));
    }

    public /* synthetic */ mv1(lp1 lp1Var, boolean z, g5 g5Var) {
        this(lp1Var, z, g5Var, new s32(), new gz0(), new lv1(g5Var));
    }

    public mv1(lp1 reporter, boolean z, g5 adLoadingPhasesManager, s32 systemCurrentTimeProvider, gz0 integratedNetworksProvider, yg1 phasesParametersProvider) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(systemCurrentTimeProvider, "systemCurrentTimeProvider");
        Intrinsics.checkNotNullParameter(integratedNetworksProvider, "integratedNetworksProvider");
        Intrinsics.checkNotNullParameter(phasesParametersProvider, "phasesParametersProvider");
        this.f9672a = reporter;
        this.b = z;
        this.c = systemCurrentTimeProvider;
        this.d = integratedNetworksProvider;
        this.e = phasesParametersProvider;
    }

    public final void a(cu1 sdkConfiguration, dl0 initializationCallSource, ir irVar) {
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        Intrinsics.checkNotNullParameter(initializationCallSource, "initializationCallSource");
        lp1 lp1Var = this.f9672a;
        hp1.b reportType = hp1.b.X;
        Pair[] pairArr = new Pair[7];
        this.c.getClass();
        pairArr[0] = TuplesKt.to("creation_date", Long.valueOf(System.currentTimeMillis()));
        pairArr[1] = TuplesKt.to("startup_version", sdkConfiguration.O());
        pairArr[2] = TuplesKt.to("user_consent", sdkConfiguration.z0());
        pairArr[3] = TuplesKt.to("integrated_mediation", this.d.a(this.b));
        pairArr[4] = TuplesKt.to("call_source", initializationCallSource.a());
        pairArr[5] = TuplesKt.to("configuration_source", irVar != null ? irVar.a() : null);
        pairArr[6] = TuplesKt.to("durations", this.e.a());
        Map reportData = MapsKt.mapOf(pairArr);
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        lp1Var.a(new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), (f) null));
    }
}
