package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class bd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f8495a;

    public bd0(uu1 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        this.f8495a = sdkEnvironmentModule;
    }

    public final ad0 a(o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        dz0 dz0VarD = adResponse.D();
        if (dz0VarD != null) {
            return new iy0(adResponse, dz0VarD);
        }
        return fs.c == adResponse.v() ? new ew1(this.f8495a) : new ev1(this.f8495a);
    }
}
