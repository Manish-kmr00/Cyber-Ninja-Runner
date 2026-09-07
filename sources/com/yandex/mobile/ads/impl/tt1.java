package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class tt1 implements ej {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10331a;

    public tt1(uu1 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        this.f10331a = sdkEnvironmentModule;
    }

    @Override // com.yandex.mobile.ads.impl.ej
    public final dj a(zi loadController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        uu1 uu1Var = this.f10331a;
        o3 o3VarF = loadController.f();
        bj bjVar = new bj();
        vt1 vt1Var = new vt1(uu1Var, o3VarF, loadController);
        return new st1(loadController, uu1Var, o3VarF, bjVar, vt1Var, new cv1(o3VarF, bjVar, vt1Var), new qt1(o3VarF));
    }
}
