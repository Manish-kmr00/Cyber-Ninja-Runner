package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class fo0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ho0 f8915a;
    private final xm0 b;
    private final wl0 c;

    public final void a(rb2<do0> videoAdInfo, q70 instreamAdView, in0 initialControlsState) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        Intrinsics.checkNotNullParameter(initialControlsState, "initialControlsState");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        gb2 adUiElements = instreamAdView.getAdUiElements();
        if (adUiElements != null) {
            this.f8915a.a(videoAdInfo, new in0(new in0.a().b(this.c.a(adUiElements, initialControlsState).d()).a(initialControlsState.a())));
        }
    }

    public final void b(rb2<do0> videoAdInfo, q70 instreamAdView, in0 initialControlsState) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        Intrinsics.checkNotNullParameter(initialControlsState, "initialControlsState");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        gb2 adUiElements = instreamAdView.getAdUiElements();
        if (adUiElements != null) {
            this.f8915a.a(videoAdInfo, this.c.a(adUiElements, initialControlsState));
        }
    }

    public /* synthetic */ fo0(ho0 ho0Var, zn0 zn0Var) {
        this(ho0Var, zn0Var, new xm0(), new wl0(zn0Var));
    }

    public fo0(ho0 videoAdControlsStateStorage, zn0 instreamVastAdPlayer, xm0 instreamAdViewUiElementsManager, wl0 videoAdControlsStateProvider) {
        Intrinsics.checkNotNullParameter(videoAdControlsStateStorage, "videoAdControlsStateStorage");
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        Intrinsics.checkNotNullParameter(instreamAdViewUiElementsManager, "instreamAdViewUiElementsManager");
        Intrinsics.checkNotNullParameter(videoAdControlsStateProvider, "videoAdControlsStateProvider");
        this.f8915a = videoAdControlsStateStorage;
        this.b = instreamAdViewUiElementsManager;
        this.c = videoAdControlsStateProvider;
    }
}
