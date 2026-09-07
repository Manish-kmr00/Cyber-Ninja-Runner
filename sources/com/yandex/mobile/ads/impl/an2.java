package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class an2 implements j92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final we f8427a;
    private final cu1 b;

    public an2(we appMetricaAdapter, Context context, cu1 cu1Var) {
        Intrinsics.checkNotNullParameter(appMetricaAdapter, "appMetricaAdapter");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8427a = appMetricaAdapter;
        this.b = cu1Var;
    }

    @Override // com.yandex.mobile.ads.impl.j92
    public final void setExperiments(String experiments) {
        Intrinsics.checkNotNullParameter(experiments, "experiments");
        cu1 cu1Var = this.b;
        if (cu1Var == null || !cu1Var.A0()) {
            return;
        }
        this.f8427a.b(experiments);
    }

    @Override // com.yandex.mobile.ads.impl.j92
    public final void setTriggeredTestIds(Set<Long> testIds) {
        Intrinsics.checkNotNullParameter(testIds, "testIds");
        cu1 cu1Var = this.b;
        if (cu1Var == null || !cu1Var.A0()) {
            return;
        }
        this.f8427a.a(testIds);
    }
}
