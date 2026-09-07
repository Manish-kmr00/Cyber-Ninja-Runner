package com.yandex.mobile.ads.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapter;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class eu1 implements su1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f8832a;
    private final jf b;

    public eu1(o01 o01Var, jf appMetricaPolicyConfigurator) {
        Intrinsics.checkNotNullParameter(appMetricaPolicyConfigurator, "appMetricaPolicyConfigurator");
        this.f8832a = o01Var;
        this.b = appMetricaPolicyConfigurator;
    }

    @Override // com.yandex.mobile.ads.impl.su1
    public final void a(Context context, cu1 sdkConfiguration) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        boolean zB = this.b.b(context);
        kd configuration = this.b.a(context);
        lp1 lp1Var = this.f8832a;
        if (lp1Var != null) {
            lp1Var.a(zB);
        }
        fd.f8884a.getClass();
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        try {
            Result.Companion companion = Result.INSTANCE;
            AppMetricaLibraryAdapter.setAdvIdentifiersTracking(configuration.a());
            objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
            op0.b(new Object[0]);
        }
    }
}
