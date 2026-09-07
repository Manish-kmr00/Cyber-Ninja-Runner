package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class js implements t72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ks f9349a;
    private final fh b;
    private final xm0 c;
    private final um0 d;

    public js(Context context, uu1 sdkEnvironmentModule, xl0 customUiElementsHolder, zn0 instreamVastAdPlayer, dt coreInstreamAdBreak, rb2 videoAdInfo, eg2 videoTracker, uk1 imageProvider, fb2 playbackListener, ks controlsViewConfigurator, fn0 assetsWrapperProvider, en0 assetsWrapper, yg assetViewConfiguratorsCreator, List assetViewConfigurators, fh assetsViewConfigurator, xm0 instreamAdViewUiElementsManager, nn0 instreamDesignProvider, mn0 instreamDesign, um0 instreamAdUiElementsController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(customUiElementsHolder, "customUiElementsHolder");
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(playbackListener, "playbackListener");
        Intrinsics.checkNotNullParameter(controlsViewConfigurator, "controlsViewConfigurator");
        Intrinsics.checkNotNullParameter(assetsWrapperProvider, "assetsWrapperProvider");
        Intrinsics.checkNotNullParameter(assetsWrapper, "assetsWrapper");
        Intrinsics.checkNotNullParameter(assetViewConfiguratorsCreator, "assetViewConfiguratorsCreator");
        Intrinsics.checkNotNullParameter(assetViewConfigurators, "assetViewConfigurators");
        Intrinsics.checkNotNullParameter(assetsViewConfigurator, "assetsViewConfigurator");
        Intrinsics.checkNotNullParameter(instreamAdViewUiElementsManager, "instreamAdViewUiElementsManager");
        Intrinsics.checkNotNullParameter(instreamDesignProvider, "instreamDesignProvider");
        Intrinsics.checkNotNullParameter(instreamDesign, "instreamDesign");
        Intrinsics.checkNotNullParameter(instreamAdUiElementsController, "instreamAdUiElementsController");
        this.f9349a = controlsViewConfigurator;
        this.b = assetsViewConfigurator;
        this.c = instreamAdViewUiElementsManager;
        this.d = instreamAdUiElementsController;
    }

    @Override // com.yandex.mobile.ads.impl.t72
    public final void a(q70 instreamAdView, in0 controlsState) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        Intrinsics.checkNotNullParameter(controlsState, "controlsState");
        gb2 gb2VarA = this.d.a(instreamAdView);
        if (gb2VarA != null) {
            this.f9349a.a(gb2VarA, controlsState);
            this.b.a(gb2VarA);
            instreamAdView.addView(gb2VarA.a(), new ViewGroup.LayoutParams(-1, -1));
        }
        this.c.getClass();
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        instreamAdView.setAdUiElements(gb2VarA);
    }

    @Override // com.yandex.mobile.ads.impl.t72
    public final void a(q70 instreamAdView) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        this.c.getClass();
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        gb2 adUiElements = instreamAdView.getAdUiElements();
        if (adUiElements != null) {
            instreamAdView.removeView(adUiElements.a());
        }
        this.c.getClass();
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        instreamAdView.setAdUiElements(null);
    }
}
