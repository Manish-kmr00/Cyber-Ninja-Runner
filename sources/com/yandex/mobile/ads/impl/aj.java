package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f8410a;

    public aj(uu1 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        this.f8410a = sdkEnvironmentModule;
    }

    public final ej a(o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        dz0 dz0VarD = adResponse.D();
        if (dz0VarD != null) {
            return new fy0(adResponse, dz0VarD);
        }
        return fs.c == adResponse.v() ? new bw1(this.f8410a) : new tt1(this.f8410a);
    }
}
