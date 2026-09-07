package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class hz1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zn0 f9150a;
    private final gd2 b;

    public final void a(View skipControl, in0 controlsState) {
        Intrinsics.checkNotNullParameter(skipControl, "skipControl");
        Intrinsics.checkNotNullParameter(controlsState, "controlsState");
        if (this.b == null) {
            skipControl.setVisibility(8);
            return;
        }
        skipControl.setOnClickListener(new gz1(this.f9150a));
        if (controlsState.c()) {
            skipControl.setVisibility(0);
        }
        skipControl.setEnabled(controlsState.c());
    }

    public /* synthetic */ hz1(zn0 zn0Var, do0 do0Var) {
        this(zn0Var, do0Var, do0Var.g());
    }

    public hz1(zn0 instreamVastAdPlayer, do0 instreamVideoAd, gd2 gd2Var) {
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        Intrinsics.checkNotNullParameter(instreamVideoAd, "instreamVideoAd");
        this.f9150a = instreamVastAdPlayer;
        this.b = gd2Var;
    }
}
