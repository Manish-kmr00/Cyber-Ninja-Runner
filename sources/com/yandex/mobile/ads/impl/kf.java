package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class kf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jf f9409a;
    private final ie b;
    private final ue c;

    public kf(jf appMetricaPolicyConfigurator, ie appAdAnalyticsActivator, ue appMetricaAdapter) {
        Intrinsics.checkNotNullParameter(appMetricaPolicyConfigurator, "appMetricaPolicyConfigurator");
        Intrinsics.checkNotNullParameter(appAdAnalyticsActivator, "appAdAnalyticsActivator");
        Intrinsics.checkNotNullParameter(appMetricaAdapter, "appMetricaAdapter");
        this.f9409a = appMetricaPolicyConfigurator;
        this.b = appAdAnalyticsActivator;
        this.c = appMetricaAdapter;
    }

    public final lp1 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.c.a(context, pa.a(context) ? "322a737a-a0ca-44e0-bc85-649b1c7c1db6" : "478cb909-6ad1-4e12-84cc-b3629a789f93", this.f9409a, this.b);
    }
}
