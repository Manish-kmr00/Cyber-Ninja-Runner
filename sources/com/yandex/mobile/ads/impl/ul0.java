package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes12.dex */
public final class ul0 implements dd2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a8 f10401a;

    public ul0(dt coreInstreamAdBreak) {
        Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
        this.f10401a = new a8(coreInstreamAdBreak.a());
    }

    @Override // com.yandex.mobile.ads.impl.dd2.a
    public final Map<String, Object> a() {
        ip1 ip1Var = new ip1((Map) null, 3);
        ip1Var.b(qs.h.a(), "ad_type");
        ip1Var.b(this.f10401a.d(), "page_id");
        ip1Var.b(this.f10401a.b(), Reporting.Key.CATEGORY_ID);
        ip1Var.b(this.f10401a.c(), "imp_id");
        return ip1Var.b();
    }
}
