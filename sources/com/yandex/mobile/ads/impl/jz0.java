package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.base.MediatedAdapterInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes7.dex */
public final class jz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cy0 f9365a;
    private final zx0 b;

    public final void a(Context context, hz0 mediationNetwork, px0 px0Var, String failureReason, Long l) {
        MediatedAdapterInfo mediatedAdapterInfoB;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("failure_reason", failureReason);
        linkedHashMap.put("status", "error");
        if (l != null) {
            linkedHashMap.put(Reporting.Key.RESPONSE_TIME, l);
        }
        if (px0Var != null) {
            this.b.getClass();
            linkedHashMap.putAll(zx0.a(px0Var));
        }
        this.f9365a.h(context, mediationNetwork, linkedHashMap, (px0Var == null || (mediatedAdapterInfoB = px0Var.b()) == null) ? null : mediatedAdapterInfoB.getNetworkName());
    }

    public /* synthetic */ jz0(cy0 cy0Var) {
        this(cy0Var, new zx0());
    }

    public jz0(cy0 mediatedAdapterReporter, zx0 mediatedAdapterInfoReportDataProvider) {
        Intrinsics.checkNotNullParameter(mediatedAdapterReporter, "mediatedAdapterReporter");
        Intrinsics.checkNotNullParameter(mediatedAdapterInfoReportDataProvider, "mediatedAdapterInfoReportDataProvider");
        this.f9365a = mediatedAdapterReporter;
        this.b = mediatedAdapterInfoReportDataProvider;
    }

    public final void a(Context context, hz0 mediationNetwork, px0 px0Var) {
        MediatedAdapterInfo mediatedAdapterInfoB;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Map<String, ? extends Object> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("status", "success"));
        if (px0Var != null) {
            this.b.getClass();
            mapMutableMapOf.putAll(zx0.a(px0Var));
        }
        this.f9365a.h(context, mediationNetwork, mapMutableMapOf, (px0Var == null || (mediatedAdapterInfoB = px0Var.b()) == null) ? null : mediatedAdapterInfoB.getNetworkName());
    }
}
