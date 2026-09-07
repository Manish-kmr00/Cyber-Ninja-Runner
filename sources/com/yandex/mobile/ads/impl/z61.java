package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z61 implements cr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10794a;
    private final e81 b;
    private final rz0 c;
    private o8<u61> d;

    public /* synthetic */ z61(o3 o3Var) {
        this(o3Var, new r71(), new rz0());
    }

    public z61(o3 adConfiguration, e81 commonReportDataProvider, rz0 mediationNetworkReportDataProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(commonReportDataProvider, "commonReportDataProvider");
        Intrinsics.checkNotNullParameter(mediationNetworkReportDataProvider, "mediationNetworkReportDataProvider");
        this.f10794a = adConfiguration;
        this.b = commonReportDataProvider;
        this.c = mediationNetworkReportDataProvider;
    }

    @Override // com.yandex.mobile.ads.impl.cr1
    public final ip1 a() {
        ip1 ip1Var;
        ip1 ip1Var2 = new ip1((Map) null, 3);
        o8<u61> o8Var = this.d;
        if (o8Var == null) {
            return ip1Var2;
        }
        ip1 ip1VarA = jp1.a(ip1Var2, this.b.a(o8Var, this.f10794a, o8Var.I()));
        hz0 mediationNetwork = this.f10794a.i();
        this.c.getClass();
        if (mediationNetwork != null) {
            Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
            ip1Var = new ip1(new LinkedHashMap(), 2);
            ip1Var.b(mediationNetwork.e(), "adapter");
            ip1Var.b(mediationNetwork.i(), "adapter_parameters");
        } else {
            ip1Var = new ip1(new LinkedHashMap(), 2);
            ip1Var.b(hp1.a.f9125a, "adapter");
        }
        return jp1.a(ip1VarA, ip1Var);
    }

    public final void a(o8<u61> o8Var) {
        this.d = o8Var;
    }
}
