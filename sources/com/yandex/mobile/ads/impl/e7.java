package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.quality.base.result.AdQualityVerificationResult;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f8768a;
    private final w6 b;
    private final f7 c;

    public final void a(Context context, AdQualityVerificationResult verificationResult, o8<?> o8Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        if (verificationResult instanceof AdQualityVerificationResult.NotImplemented) {
            return;
        }
        ip1 ip1VarA = this.b.a(o8Var, this.f8768a);
        this.c.getClass();
        ip1 ip1VarA2 = jp1.a(ip1VarA, f7.b(verificationResult));
        hp1.b bVar = hp1.b.a0;
        Map<String, Object> mapB = ip1VarA2.b();
        hp1 hp1Var = new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA2, bVar, "reportType", mapB, "reportData"));
        this.f8768a.q().f();
        nd.a(context, bn2.f8524a, this.f8768a.q().b()).a(hp1Var);
    }

    public /* synthetic */ e7(o3 o3Var) {
        this(o3Var, new w6(), new f7());
    }

    public e7(o3 adConfiguration, w6 adQualityAdapterReportDataProvider, f7 adQualityVerificationResultReportDataProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adQualityAdapterReportDataProvider, "adQualityAdapterReportDataProvider");
        Intrinsics.checkNotNullParameter(adQualityVerificationResultReportDataProvider, "adQualityVerificationResultReportDataProvider");
        this.f8768a = adConfiguration;
        this.b = adQualityAdapterReportDataProvider;
        this.c = adQualityVerificationResultReportDataProvider;
    }
}
