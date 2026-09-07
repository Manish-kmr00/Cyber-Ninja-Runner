package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes9.dex */
public final class vo0 implements dq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gi2 f10500a;

    public vo0(gi2 requestConfig) {
        Intrinsics.checkNotNullParameter(requestConfig, "requestConfig");
        this.f10500a = requestConfig;
    }

    @Override // com.yandex.mobile.ads.impl.dq1
    public final Map<String, Object> a() {
        return MapsKt.mapOf(TuplesKt.to("ad_type", qs.h.a()), TuplesKt.to("page_id", this.f10500a.a()), TuplesKt.to(Reporting.Key.CATEGORY_ID, this.f10500a.b()));
    }
}
