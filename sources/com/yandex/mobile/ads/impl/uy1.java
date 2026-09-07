package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class uy1 implements e81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c41 f10434a;
    private final xq1 b;
    private final c8 c;
    private final hr d;

    public uy1(c41 c41Var, xq1 responseDataProvider, c8 adRequestReportDataProvider, hr configurationReportDataProvider) {
        Intrinsics.checkNotNullParameter(c41Var, "native");
        Intrinsics.checkNotNullParameter(responseDataProvider, "responseDataProvider");
        Intrinsics.checkNotNullParameter(adRequestReportDataProvider, "adRequestReportDataProvider");
        Intrinsics.checkNotNullParameter(configurationReportDataProvider, "configurationReportDataProvider");
        this.f10434a = c41Var;
        this.b = responseDataProvider;
        this.c = adRequestReportDataProvider;
        this.d = configurationReportDataProvider;
    }

    @Override // com.yandex.mobile.ads.impl.e81
    public final ip1 a(o8 o8Var, o3 adConfiguration, u61 u61Var) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1VarA = this.b.a(o8Var, u61Var, adConfiguration, this.f10434a);
        ip1 ip1VarA2 = this.c.a(adConfiguration.a());
        hr hrVar = this.d;
        hrVar.getClass();
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1VarA3 = hrVar.a(adConfiguration);
        ip1 ip1Var = new ip1(new LinkedHashMap(), 2);
        ip1Var.b(Boolean.valueOf(adConfiguration.u()), "image_loading_automatically");
        return jp1.a(jp1.a(ip1VarA, ip1VarA2), jp1.a(ip1VarA3, ip1Var));
    }
}
