package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10538a;
    private final o3 b;

    public w61(uu1 sdkEnvironmentModule, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.f10538a = sdkEnvironmentModule;
        this.b = adConfiguration;
    }

    public final i81 a(o8<u61> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        dz0 dz0VarD = adResponse.D();
        return dz0VarD != null ? new sy0(adResponse, dz0VarD) : new dw1(this.f10538a, this.b);
    }
}
