package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r71 implements e81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xq1 f10080a;
    private final c8 b;
    private final hr c;

    @Override // com.yandex.mobile.ads.impl.e81
    public final ip1 a(o8 o8Var, o3 adConfiguration, u61 u61Var) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1VarA = this.f10080a.a(o8Var, adConfiguration, u61Var);
        ip1 ip1VarA2 = this.b.a(adConfiguration.a());
        hr hrVar = this.c;
        hrVar.getClass();
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1VarA3 = hrVar.a(adConfiguration);
        ip1 ip1Var = new ip1(new LinkedHashMap(), 2);
        ip1Var.b(Boolean.valueOf(adConfiguration.u()), "image_loading_automatically");
        return jp1.a(jp1.a(ip1VarA, ip1VarA2), jp1.a(ip1VarA3, ip1Var));
    }

    public /* synthetic */ r71() {
        this(new xq1(), new c8(), new hr());
    }

    public r71(xq1 responseDataProvider, c8 adRequestReportDataProvider, hr configurationReportDataProvider) {
        Intrinsics.checkNotNullParameter(responseDataProvider, "responseDataProvider");
        Intrinsics.checkNotNullParameter(adRequestReportDataProvider, "adRequestReportDataProvider");
        Intrinsics.checkNotNullParameter(configurationReportDataProvider, "configurationReportDataProvider");
        this.f10080a = responseDataProvider;
        this.b = adRequestReportDataProvider;
        this.c = configurationReportDataProvider;
    }
}
