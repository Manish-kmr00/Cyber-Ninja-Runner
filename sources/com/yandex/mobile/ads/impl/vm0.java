package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10494a;
    private final zm0 b;
    private final w72 c;
    private v72 d;

    public vm0(Context context, uu1 sdkEnvironmentModule, zm0 instreamAdViewsHolderManager, wi1 playerVolumeProvider, gm0 playerController, xl0 customUiElementsHolder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamAdViewsHolderManager, "instreamAdViewsHolderManager");
        Intrinsics.checkNotNullParameter(playerVolumeProvider, "playerVolumeProvider");
        Intrinsics.checkNotNullParameter(playerController, "playerController");
        Intrinsics.checkNotNullParameter(customUiElementsHolder, "customUiElementsHolder");
        this.f10494a = context;
        this.b = instreamAdViewsHolderManager;
        this.c = new w72(sdkEnvironmentModule, playerVolumeProvider, playerController, customUiElementsHolder);
    }

    public final void a(dt coreInstreamAdBreak, rb2 videoAdInfo, eg2 videoTracker, fb2 playbackListener, uk1 imageProvider) {
        Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(playbackListener, "playbackListener");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        a();
        ym0 ym0VarA = this.b.a();
        if (ym0VarA != null) {
            w72 w72Var = this.c;
            Context applicationContext = this.f10494a.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            v72 v72VarA = w72Var.a(applicationContext, ym0VarA, coreInstreamAdBreak, videoAdInfo, videoTracker, imageProvider, playbackListener);
            v72VarA.a();
            this.d = v72VarA;
        }
    }

    public final void a() {
        v72 v72Var = this.d;
        if (v72Var != null) {
            v72Var.b();
        }
        this.d = null;
    }

    public final void a(rb2<do0> nextVideo) {
        Intrinsics.checkNotNullParameter(nextVideo, "nextVideo");
        v72 v72Var = this.d;
        if (v72Var != null) {
            v72Var.a(nextVideo);
        }
    }
}
