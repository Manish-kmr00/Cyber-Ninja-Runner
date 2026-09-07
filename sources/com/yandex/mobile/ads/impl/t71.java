package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class t71 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10274a;
    private final String b;
    private final o8<?> c;
    private final u61 d;
    private final e81 e;
    private b81 f;

    public t71(o3 adConfiguration, String responseNativeType, o8<?> adResponse, u61 nativeAdResponse, e81 nativeCommonReportDataProvider, b81 b81Var) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(responseNativeType, "responseNativeType");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdResponse, "nativeAdResponse");
        Intrinsics.checkNotNullParameter(nativeCommonReportDataProvider, "nativeCommonReportDataProvider");
        this.f10274a = adConfiguration;
        this.b = responseNativeType;
        this.c = adResponse;
        this.d = nativeAdResponse;
        this.e = nativeCommonReportDataProvider;
        this.f = b81Var;
    }

    public final ip1 a() {
        ip1 ip1VarA = this.e.a(this.c, this.f10274a, this.d);
        b81 b81Var = this.f;
        if (b81Var != null) {
            ip1VarA.b(b81Var.a(), "bind_type");
        }
        ip1VarA.a(this.b, "native_ad_type");
        zy1 zy1VarR = this.f10274a.r();
        if (zy1VarR != null) {
            ip1VarA.b(zy1VarR.a().a(), "size_type");
            ip1VarA.b(Integer.valueOf(zy1VarR.getWidth()), "width");
            ip1VarA.b(Integer.valueOf(zy1VarR.getHeight()), "height");
        }
        ip1VarA.a(this.c.a());
        return ip1VarA;
    }

    public final void a(b81 bindType) {
        Intrinsics.checkNotNullParameter(bindType, "bindType");
        this.f = bindType;
    }
}
