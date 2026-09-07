package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zn0 f10619a;
    private final f6 b;

    public final void a(gb2 uiElements, in0 controlsState) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        Intrinsics.checkNotNullParameter(controlsState, "controlsState");
        float fA = controlsState.a();
        boolean zD = controlsState.d();
        v31 v31VarI = uiElements.i();
        w31 w31Var = new w31(this.f10619a, this.b, controlsState, v31VarI);
        if (v31VarI != null) {
            v31VarI.setOnClickListener(w31Var);
        }
        if (v31VarI != null) {
            v31VarI.setMuted(zD);
        }
        this.b.a(fA, zD);
    }

    public /* synthetic */ x31(zn0 zn0Var) {
        this(zn0Var, new f6(zn0Var));
    }

    public x31(zn0 instreamVastAdPlayer, f6 adPlayerVolumeConfigurator) {
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        Intrinsics.checkNotNullParameter(adPlayerVolumeConfigurator, "adPlayerVolumeConfigurator");
        this.f10619a = instreamVastAdPlayer;
        this.b = adPlayerVolumeConfigurator;
    }
}
