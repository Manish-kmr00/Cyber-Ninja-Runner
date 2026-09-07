package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class iy0 implements ad0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<String> f9268a;
    private final dz0 b;

    public iy0(o8<String> adResponse, dz0 mediationData) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(mediationData, "mediationData");
        this.f9268a = adResponse;
        this.b = mediationData;
    }

    @Override // com.yandex.mobile.ads.impl.ad0
    public final zc0<qp0> a(gd0<qp0> loadController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        return new com.monetization.ads.mediation.interstitial.c(loadController, this.f9268a, this.b);
    }

    @Override // com.yandex.mobile.ads.impl.ad0
    public final zc0<ur1> b(gd0<ur1> loadController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        return new vy0(loadController, this.f9268a, this.b);
    }

    @Override // com.yandex.mobile.ads.impl.ad0
    public final zc0<uf> c(gd0<uf> loadController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        o8<String> adResponse = this.f9268a;
        dz0 mediationData = this.b;
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(mediationData, "mediationData");
        o3 o3VarF = loadController.f();
        hy0 hy0Var = new hy0(o3VarF);
        cy0 cy0Var = new cy0(o3VarF, adResponse);
        dy0 dy0Var = new dy0(new vx0(mediationData.c(), hy0Var, cy0Var));
        g5 g5VarI = loadController.i();
        eg1 eg1Var = new eg1(loadController, mediationData, g5VarI, new wa());
        com.monetization.ads.mediation.appopenad.c cVar = new com.monetization.ads.mediation.appopenad.c();
        nx0 nx0Var = new nx0(o3VarF, g5VarI, cVar, cy0Var, dy0Var, eg1Var, new zx0());
        return new com.monetization.ads.mediation.appopenad.b(nx0Var, cVar, new com.monetization.ads.mediation.appopenad.a(loadController, nx0Var), cy0Var);
    }
}
