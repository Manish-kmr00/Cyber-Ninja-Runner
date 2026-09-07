package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vt1 implements bv1<ut1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10507a;
    private final o3 b;
    private final zi c;
    private ut1 d;

    public vt1(uu1 sdkEnvironmentModule, o3 adConfiguration, zi adLoadController) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadController, "adLoadController");
        this.f10507a = sdkEnvironmentModule;
        this.b = adConfiguration;
        this.c = adLoadController;
    }

    @Override // com.yandex.mobile.ads.impl.bv1
    public final void a() {
        ut1 ut1Var = this.d;
        if (ut1Var != null) {
            ut1Var.a();
        }
        this.d = null;
    }

    @Override // com.yandex.mobile.ads.impl.bv1
    public final void a(o8<String> adResponse, zy1 sizeInfo, String htmlResponse, dv1<ut1> creationListener) throws lj2 {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        Intrinsics.checkNotNullParameter(htmlResponse, "htmlResponse");
        Intrinsics.checkNotNullParameter(creationListener, "creationListener");
        Context contextL = this.c.l();
        jp0 jp0VarC = this.c.C();
        ie2 ie2VarD = this.c.D();
        uu1 uu1Var = this.f10507a;
        o3 o3Var = this.b;
        ut1 ut1Var = new ut1(contextL, uu1Var, o3Var, adResponse, jp0VarC, this.c, new bj(), new h21(), new wg0(), new qj(contextL, o3Var), new xi());
        this.d = ut1Var;
        ut1Var.a(sizeInfo, htmlResponse, ie2VarD, creationListener);
    }
}
