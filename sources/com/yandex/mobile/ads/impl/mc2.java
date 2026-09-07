package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class mc2 implements dd2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9627a;
    private final o8<?> b;
    private final e81 c;

    public /* synthetic */ mc2(o3 o3Var, o8 o8Var) {
        this(o3Var, o8Var, new r71());
    }

    public mc2(o3 adConfiguration, o8<?> adResponse, e81 commonReportDataProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(commonReportDataProvider, "commonReportDataProvider");
        this.f9627a = adConfiguration;
        this.b = adResponse;
        this.c = commonReportDataProvider;
    }

    @Override // com.yandex.mobile.ads.impl.dd2.b
    public final ip1 a() {
        Object objI = this.b.I();
        ip1 ip1VarA = this.c.a(this.b, this.f9627a, objI instanceof u61 ? (u61) objI : null);
        ip1VarA.b(hp1.a.f9125a, "adapter");
        ip1VarA.a(this.b.a());
        return ip1VarA;
    }
}
