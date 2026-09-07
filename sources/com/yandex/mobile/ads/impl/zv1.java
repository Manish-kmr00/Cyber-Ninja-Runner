package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class zv1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10854a;

    public zv1(uu1 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        this.f10854a = sdkEnvironmentModule;
    }

    public final o51 a(o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        uw1 uw1Var = new uw1();
        mt1 mt1Var = new mt1();
        uu1 uu1Var = this.f10854a;
        return new o51(new nt1(adResponse), mt1Var, uw1Var, new rv1(uu1Var, adResponse, new jx0(uu1Var, adResponse), new gx0(adResponse), new ix0(), new hx0()), new lw1());
    }
}
