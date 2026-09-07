package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ew1 implements ad0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f8837a;

    public ew1(uu1 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        this.f8837a = sdkEnvironmentModule;
    }

    @Override // com.yandex.mobile.ads.impl.ad0
    public final zc0<qp0> a(gd0<qp0> loadController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        return new fw1(loadController, this.f8837a);
    }

    @Override // com.yandex.mobile.ads.impl.ad0
    public final zc0<ur1> b(gd0<ur1> loadController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        return new gw1(loadController, this.f8837a, new z51());
    }

    @Override // com.yandex.mobile.ads.impl.ad0
    public final zc0<uf> c(gd0<uf> loadController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        return new fw1(loadController, this.f8837a);
    }
}
