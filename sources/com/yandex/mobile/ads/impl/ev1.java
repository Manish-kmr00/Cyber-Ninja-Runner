package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ev1 implements ad0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f8834a;

    public ev1(uu1 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        this.f8834a = sdkEnvironmentModule;
    }

    @Override // com.yandex.mobile.ads.impl.ad0
    public final zc0<qp0> a(gd0<qp0> loadController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        return new yu1(loadController, this.f8834a);
    }

    @Override // com.yandex.mobile.ads.impl.ad0
    public final zc0<ur1> b(gd0<ur1> loadController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        return new yu1(loadController, this.f8834a);
    }

    @Override // com.yandex.mobile.ads.impl.ad0
    public final zc0<uf> c(gd0<uf> loadController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        return new yu1(loadController, this.f8834a);
    }
}
