package com.yandex.mobile.ads.impl;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xx0 implements s8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f10685a;

    public xx0(o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f10685a = adResponse;
    }

    @Override // com.yandex.mobile.ads.impl.s8
    public final ip1 a() {
        ip1 ip1Var = new ip1(new HashMap(), 2);
        ip1Var.b(this.f10685a.m(), FirebaseAnalytics.Param.AD_SOURCE);
        ip1Var.b(this.f10685a.p(), "block_id");
        ip1Var.b(this.f10685a.p(), "ad_unit_id");
        ip1Var.a(this.f10685a.L(), "server_log_id");
        ip1Var.a(this.f10685a.a());
        return ip1Var;
    }
}
