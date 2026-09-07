package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class sy0 implements i81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<u61> f10247a;
    private final dz0 b;

    public sy0(o8<u61> adResponse, dz0 mediationData) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(mediationData, "mediationData");
        this.f10247a = adResponse;
        this.b = mediationData;
    }

    @Override // com.yandex.mobile.ads.impl.i81
    public final h81 a(c61 nativeAdLoadManager) {
        Intrinsics.checkNotNullParameter(nativeAdLoadManager, "nativeAdLoadManager");
        o8<u61> o8Var = this.f10247a;
        dz0 dz0Var = this.b;
        o3 o3VarF = nativeAdLoadManager.f();
        hy0 hy0Var = new hy0(o3VarF);
        cy0 cy0Var = new cy0(o3VarF, o8Var);
        vx0 vx0Var = new vx0(dz0Var.c(), hy0Var, cy0Var);
        oy0 oy0Var = new oy0(vx0Var);
        g5 g5VarI = nativeAdLoadManager.i();
        eg1 eg1Var = new eg1(nativeAdLoadManager, dz0Var, g5VarI, new wa());
        py0 py0Var = new py0();
        nx0 nx0Var = new nx0(o3VarF, g5VarI, py0Var, cy0Var, oy0Var, eg1Var, new zx0());
        return new ry0(nativeAdLoadManager, o8Var, dz0Var, o3VarF, hy0Var, cy0Var, vx0Var, oy0Var, g5VarI, eg1Var, py0Var, nx0Var, new o71(o8Var, nativeAdLoadManager, nx0Var));
    }
}
