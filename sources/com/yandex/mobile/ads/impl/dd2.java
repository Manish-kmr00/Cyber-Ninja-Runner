package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class dd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f8684a;
    private final o01 b;
    private final cd2 c;
    private a d;
    private b e;
    private Map<String, ? extends Object> f;

    public interface a {
        Map<String, Object> a();
    }

    public interface b {
        ip1 a();
    }

    public dd2(Context context, o3 adConfiguration, o8<?> o8Var, g5 adLoadingPhasesManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        this.f8684a = o8Var;
        adConfiguration.q().f();
        this.b = nd.a(context, bn2.f8524a, adConfiguration.q().b());
        this.c = new cd2(adLoadingPhasesManager);
    }

    public final void a(String failureReason, String errorMessage) {
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        a(MapsKt.mutableMapOf(TuplesKt.to("status", "error"), TuplesKt.to("failure_reason", failureReason), TuplesKt.to("error_message", errorMessage)));
    }

    private final void a(Map<String, Object> reportData) {
        Map<String, ? extends Object> mapEmptyMap = this.f;
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        reportData.putAll(mapEmptyMap);
        a aVar = this.d;
        Map<String, Object> mapA = aVar != null ? aVar.a() : null;
        if (mapA == null) {
            mapA = MapsKt.emptyMap();
        }
        reportData.putAll(mapA);
        b bVar = this.e;
        Map<String, Object> mapB = bVar != null ? bVar.a().b() : null;
        if (mapB == null) {
            mapB = MapsKt.emptyMap();
        }
        reportData.putAll(mapB);
        hp1.b reportType = hp1.b.O;
        o8<?> o8Var = this.f8684a;
        f fVarA = o8Var != null ? o8Var.a() : null;
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        this.b.a(new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), fVarA));
    }

    public final void b(Map<String, ? extends Object> map) {
        this.f = map;
    }

    public final void a() {
        a(MapsKt.mutableMapOf(TuplesKt.to("status", "success"), TuplesKt.to("durations", this.c.a())));
    }

    public final void a(b bVar) {
        this.e = bVar;
    }

    public final void a(a aVar) {
        this.d = aVar;
    }
}
