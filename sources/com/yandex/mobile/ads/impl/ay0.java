package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ay0 implements w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mx0<?> f8457a;
    private final zx0 b;

    public ay0(mx0<?> mx0Var, zx0 mediatedAdapterInfoReportDataProvider) {
        Intrinsics.checkNotNullParameter(mediatedAdapterInfoReportDataProvider, "mediatedAdapterInfoReportDataProvider");
        this.f8457a = mx0Var;
        this.b = mediatedAdapterInfoReportDataProvider;
    }

    @Override // com.yandex.mobile.ads.impl.w1
    public final Map<String, Object> a() {
        ip1 ip1Var = new ip1((Map) null, 3);
        mx0<?> mx0Var = this.f8457a;
        if (mx0Var != null) {
            hz0 hz0VarC = mx0Var.c();
            px0 px0VarA = this.f8457a.a();
            ip1Var.b(hz0VarC.e(), "adapter");
            ip1Var.b(hz0VarC.i(), "adapter_parameters");
            this.b.getClass();
            ip1Var.a(new HashMap(zx0.a(px0VarA)));
        }
        return ip1Var.b();
    }
}
