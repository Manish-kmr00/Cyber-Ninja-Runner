package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q71 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f9992a;
    private final u61 b;
    private final o3 c;
    private final e81 d;

    public /* synthetic */ q71(o8 o8Var, u61 u61Var, o3 o3Var) {
        this(o8Var, u61Var, o3Var, new r71());
    }

    public q71(o8<?> adResponse, u61 u61Var, o3 adConfiguration, e81 commonReportDataProvider) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(commonReportDataProvider, "commonReportDataProvider");
        this.f9992a = adResponse;
        this.b = u61Var;
        this.c = adConfiguration;
        this.d = commonReportDataProvider;
    }

    public final ip1 a() {
        return this.d.a(this.f9992a, this.c, this.b);
    }
}
