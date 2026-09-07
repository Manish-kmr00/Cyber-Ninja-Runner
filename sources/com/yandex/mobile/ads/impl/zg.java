package com.yandex.mobile.ads.impl;

import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class zg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qs f10815a;
    private final String b;
    private final w1 c;
    private final s8 d;
    private t71 e;

    public /* synthetic */ zg(y4 y4Var, qs qsVar, String str) {
        this(y4Var, qsVar, str, y4Var.a(), y4Var.b());
    }

    public zg(y4 adInfoReportDataProviderFactory, qs adType, String str, w1 adAdapterReportDataProvider, s8 adResponseReportDataProvider) {
        Intrinsics.checkNotNullParameter(adInfoReportDataProviderFactory, "adInfoReportDataProviderFactory");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adAdapterReportDataProvider, "adAdapterReportDataProvider");
        Intrinsics.checkNotNullParameter(adResponseReportDataProvider, "adResponseReportDataProvider");
        this.f10815a = adType;
        this.b = str;
        this.c = adAdapterReportDataProvider;
        this.d = adResponseReportDataProvider;
    }

    public final ip1 a() {
        ip1 ip1VarA = this.d.a();
        ip1VarA.b(this.f10815a.a(), "ad_type");
        ip1VarA.a(this.b, CreativeInfo.c);
        ip1VarA.a((Map<String, ? extends Object>) this.c.a());
        t71 t71Var = this.e;
        return t71Var != null ? jp1.a(ip1VarA, t71Var.a()) : ip1VarA;
    }

    public final void a(t71 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.e = reportParameterManager;
    }
}
