package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o01 f8758a;
    private final zg b;

    public e41(Context context, o3 adConfiguration, y4 adInfoReportDataProviderFactory, qs adType, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adInfoReportDataProviderFactory, "adInfoReportDataProviderFactory");
        Intrinsics.checkNotNullParameter(adType, "adType");
        adConfiguration.q().f();
        this.f8758a = nd.a(context, bn2.f8524a, adConfiguration.q().b());
        this.b = new zg(adInfoReportDataProviderFactory, adType, str);
    }

    public final void a(ArrayList assetNames, hp1.b reportType) {
        Intrinsics.checkNotNullParameter(assetNames, "assetNames");
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        ip1 ip1VarA = this.b.a();
        ip1VarA.b(assetNames, POBNativeConstants.NATIVE_ASSETS);
        Map<String, Object> mapB = ip1VarA.b();
        this.f8758a.a(new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, reportType, "reportType", mapB, "reportData")));
    }

    public final void a(t71 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.b.a(reportParameterManager);
    }
}
