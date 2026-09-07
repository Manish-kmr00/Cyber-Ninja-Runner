package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class uq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xq1 f10412a;
    private final c8 b;
    private final hr c;

    public final ip1 a(o8<?> o8Var, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1VarB = this.f10412a.b(o8Var, adConfiguration);
        ip1 ip1VarA = this.b.a(adConfiguration.a());
        return jp1.a(jp1.a(ip1VarB, ip1VarA), this.c.a(adConfiguration));
    }

    public /* synthetic */ uq() {
        this(new xq1(), new c8(), new hr());
    }

    public uq(xq1 responseDataProvider, c8 adRequestReportDataProvider, hr configurationReportDataProvider) {
        Intrinsics.checkNotNullParameter(responseDataProvider, "responseDataProvider");
        Intrinsics.checkNotNullParameter(adRequestReportDataProvider, "adRequestReportDataProvider");
        Intrinsics.checkNotNullParameter(configurationReportDataProvider, "configurationReportDataProvider");
        this.f10412a = responseDataProvider;
        this.b = adRequestReportDataProvider;
        this.c = configurationReportDataProvider;
    }
}
