package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w31 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zn0 f10532a;
    private final f6 b;
    private final in0 c;
    private final v31 d;

    public w31(zn0 instreamVastAdPlayer, f6 adPlayerVolumeConfigurator, in0 instreamControlsState, v31 v31Var) {
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        Intrinsics.checkNotNullParameter(adPlayerVolumeConfigurator, "adPlayerVolumeConfigurator");
        Intrinsics.checkNotNullParameter(instreamControlsState, "instreamControlsState");
        this.f10532a = instreamVastAdPlayer;
        this.b = adPlayerVolumeConfigurator;
        this.c = instreamControlsState;
        this.d = v31Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View volumeControl) {
        Intrinsics.checkNotNullParameter(volumeControl, "volumeControl");
        boolean z = !(this.f10532a.getVolume() == 0.0f);
        this.b.a(this.c.a(), z);
        v31 v31Var = this.d;
        if (v31Var != null) {
            v31Var.setMuted(z);
        }
    }
}
