package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class dw1 implements i81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f8740a;
    private final o3 b;

    public dw1(uu1 sdkEnvironmentModule, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.f8740a = sdkEnvironmentModule;
        this.b = adConfiguration;
    }

    @Override // com.yandex.mobile.ads.impl.i81
    public final h81 a(c61 nativeAdLoadManager) {
        Intrinsics.checkNotNullParameter(nativeAdLoadManager, "nativeAdLoadManager");
        uu1 uu1Var = this.f8740a;
        return new cw1(uu1Var, nativeAdLoadManager, this.b, new zv1(uu1Var));
    }
}
