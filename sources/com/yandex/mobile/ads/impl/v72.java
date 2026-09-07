package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class v72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ym0 f10457a;
    private final t72 b;
    private final rb2<do0> c;
    private final go0 d;
    private final fo0 e;
    private in0 f;

    public v72(ym0 instreamAdViewsHolder, t72 uiElementBinder, rb2<do0> videoAdInfo, ho0 videoAdControlsStateStorage, wi1 playerVolumeProvider, zn0 instreamVastAdPlayer, go0 videoAdControlsStateProvider, fo0 instreamVideoAdControlsStateManager) {
        Intrinsics.checkNotNullParameter(instreamAdViewsHolder, "instreamAdViewsHolder");
        Intrinsics.checkNotNullParameter(uiElementBinder, "uiElementBinder");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoAdControlsStateStorage, "videoAdControlsStateStorage");
        Intrinsics.checkNotNullParameter(playerVolumeProvider, "playerVolumeProvider");
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        Intrinsics.checkNotNullParameter(videoAdControlsStateProvider, "videoAdControlsStateProvider");
        Intrinsics.checkNotNullParameter(instreamVideoAdControlsStateManager, "instreamVideoAdControlsStateManager");
        this.f10457a = instreamAdViewsHolder;
        this.b = uiElementBinder;
        this.c = videoAdInfo;
        this.d = videoAdControlsStateProvider;
        this.e = instreamVideoAdControlsStateManager;
    }

    public final void a() {
        q70 q70VarB = this.f10457a.b();
        if (this.f != null || q70VarB == null) {
            return;
        }
        in0 in0VarA = this.d.a(this.c);
        this.b.a(q70VarB, in0VarA);
        this.f = in0VarA;
    }

    public final void a(rb2<do0> nextVideo) {
        in0 in0Var;
        Intrinsics.checkNotNullParameter(nextVideo, "nextVideo");
        q70 q70VarB = this.f10457a.b();
        if (q70VarB == null || (in0Var = this.f) == null) {
            return;
        }
        this.e.a(nextVideo, q70VarB, in0Var);
    }

    public final void b() {
        in0 in0Var;
        q70 q70VarB = this.f10457a.b();
        if (q70VarB == null || (in0Var = this.f) == null) {
            return;
        }
        this.e.b(this.c, q70VarB, in0Var);
        this.f = null;
        this.b.a(q70VarB);
    }
}
