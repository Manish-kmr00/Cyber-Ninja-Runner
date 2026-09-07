package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class du1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eu1 f8734a;
    private final iu1 b;

    public du1(jf appMetricaPolicyConfigurator, eu1 sdkConfigurationChangeListener, iu1 sdkConfigurationProvider) {
        Intrinsics.checkNotNullParameter(appMetricaPolicyConfigurator, "appMetricaPolicyConfigurator");
        Intrinsics.checkNotNullParameter(sdkConfigurationChangeListener, "sdkConfigurationChangeListener");
        Intrinsics.checkNotNullParameter(sdkConfigurationProvider, "sdkConfigurationProvider");
        this.f8734a = sdkConfigurationChangeListener;
        this.b = sdkConfigurationProvider;
    }

    public final void a() {
        this.b.a(this.f8734a);
    }
}
