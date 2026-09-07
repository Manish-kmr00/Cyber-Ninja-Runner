package com.yandex.mobile.ads.impl;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ot1 implements s8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f9858a;

    public ot1(o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f9858a = adResponse;
    }

    @Override // com.yandex.mobile.ads.impl.s8
    public final ip1 a() {
        ip1 ip1Var = new ip1((Map) null, 3);
        ip1Var.b(this.f9858a.m(), FirebaseAnalytics.Param.AD_SOURCE);
        ip1Var.b(this.f9858a.o(), "ad_type_format");
        ip1Var.b(this.f9858a.p(), "block_id");
        ip1Var.b(this.f9858a.p(), "ad_unit_id");
        ip1Var.b(this.f9858a.H(), "product_type");
        ip1Var.a(this.f9858a.L(), "server_log_id");
        ip1Var.b(this.f9858a.M().a().a(), "size_type");
        ip1Var.b(Integer.valueOf(this.f9858a.M().getWidth()), "width");
        ip1Var.b(Integer.valueOf(this.f9858a.M().getHeight()), "height");
        ip1Var.a(this.f9858a.a());
        return ip1Var;
    }
}
