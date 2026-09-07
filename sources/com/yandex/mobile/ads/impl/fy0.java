package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class fy0 implements ej {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<String> f8951a;
    private final dz0 b;

    public fy0(o8<String> adResponse, dz0 mediationData) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(mediationData, "mediationData");
        this.f8951a = adResponse;
        this.b = mediationData;
    }

    @Override // com.yandex.mobile.ads.impl.ej
    public final dj a(zi loadController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        return new com.monetization.ads.mediation.banner.c(loadController, this.f8951a, this.b);
    }
}
