package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class pg0 implements cr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uq f9923a;
    private final rz0 b;
    private o8<String> c;
    private o3 d;

    public /* synthetic */ pg0() {
        this(new uq(), new rz0());
    }

    public pg0(uq commonReportDataProvider, rz0 mediationReportDataProvider) {
        Intrinsics.checkNotNullParameter(commonReportDataProvider, "commonReportDataProvider");
        Intrinsics.checkNotNullParameter(mediationReportDataProvider, "mediationReportDataProvider");
        this.f9923a = commonReportDataProvider;
        this.b = mediationReportDataProvider;
    }

    @Override // com.yandex.mobile.ads.impl.cr1
    public final ip1 a() {
        ip1 ip1Var;
        ip1 ip1Var2 = new ip1(new HashMap(), 2);
        o8<String> o8Var = this.c;
        o3 o3Var = this.d;
        if (o8Var == null || o3Var == null) {
            return ip1Var2;
        }
        ip1 ip1VarA = jp1.a(ip1Var2, this.f9923a.a(o8Var, o3Var));
        hz0 mediationNetwork = o3Var.i();
        this.b.getClass();
        if (mediationNetwork != null) {
            Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
            ip1Var = new ip1(new LinkedHashMap(), 2);
            ip1Var.b(mediationNetwork.e(), "adapter");
            ip1Var.b(mediationNetwork.i(), "adapter_parameters");
        } else {
            ip1Var = new ip1(new LinkedHashMap(), 2);
            ip1Var.b(hp1.a.f9125a, "adapter");
        }
        ip1 ip1VarA2 = jp1.a(ip1VarA, ip1Var);
        ip1VarA2.b(o8Var.M().a().a(), "size_type");
        ip1VarA2.b(Integer.valueOf(o8Var.M().getWidth()), "width");
        ip1VarA2.b(Integer.valueOf(o8Var.M().getHeight()), "height");
        return ip1VarA2;
    }

    public final void a(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.d = adConfiguration;
    }

    public final void a(o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.c = adResponse;
    }
}
