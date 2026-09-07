package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes5.dex */
public final class ji2 implements eq1<gi2, ci2> {
    @Override // com.yandex.mobile.ads.impl.eq1
    public final hp1 a(gi2 gi2Var) {
        gi2 requestConfiguration = gi2Var;
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        Map reportData = MapsKt.mapOf(TuplesKt.to("page_id", requestConfiguration.a()), TuplesKt.to(Reporting.Key.CATEGORY_ID, requestConfiguration.b()), TuplesKt.to("ad_type", qs.h.a()));
        hp1.b reportType = hp1.b.t;
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        return new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), (f) null);
    }

    @Override // com.yandex.mobile.ads.impl.eq1
    public final hp1 a(qq1<ci2> qq1Var, int i, gi2 gi2Var) {
        gi2 requestConfiguration = gi2Var;
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        Map reportData = MapsKt.toMutableMap(MapsKt.mapOf(TuplesKt.to("page_id", requestConfiguration.a()), TuplesKt.to(Reporting.Key.CATEGORY_ID, requestConfiguration.b()), TuplesKt.to("ad_type", qs.h.a())));
        if (i != -1) {
            reportData.put("code", Integer.valueOf(i));
        }
        hp1.b reportType = hp1.b.u;
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        return new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), (f) null);
    }
}
