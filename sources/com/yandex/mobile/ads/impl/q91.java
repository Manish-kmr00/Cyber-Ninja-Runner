package com.yandex.mobile.ads.impl;

import com.pubmatic.sdk.nativead.POBNativeConstants;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t71 f10000a;
    private eh b;

    public q91(t71 reportManager, eh assetsRenderedReportParameterProvider) {
        Intrinsics.checkNotNullParameter(reportManager, "reportManager");
        Intrinsics.checkNotNullParameter(assetsRenderedReportParameterProvider, "assetsRenderedReportParameterProvider");
        this.f10000a = reportManager;
        this.b = assetsRenderedReportParameterProvider;
    }

    public final Map<String, Object> a() {
        return MapsKt.plus(this.f10000a.a().b(), MapsKt.mapOf(TuplesKt.to(POBNativeConstants.NATIVE_ASSETS, MapsKt.mapOf(TuplesKt.to("rendered", this.b.a())))));
    }
}
