package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wi1 f10540a;
    private final gm0 b;
    private final u72 c;
    private final ho0 d;

    public final v72 a(Context context, ym0 viewHolder, dt coreInstreamAdBreak, rb2 videoAdInfo, eg2 videoTracker, uk1 imageProvider, fb2 playbackListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(playbackListener, "playbackListener");
        zn0 zn0Var = new zn0((do0) videoAdInfo.d(), this.b);
        t72 t72VarA = this.c.a(context, coreInstreamAdBreak, videoAdInfo, zn0Var, videoTracker, imageProvider, playbackListener);
        ho0 ho0Var = this.d;
        wi1 wi1Var = this.f10540a;
        return new v72(viewHolder, t72VarA, videoAdInfo, ho0Var, wi1Var, zn0Var, new go0(ho0Var, wi1Var), new fo0(ho0Var, zn0Var));
    }

    public /* synthetic */ w72(uu1 uu1Var, wi1 wi1Var, gm0 gm0Var, xl0 xl0Var) {
        this(uu1Var, wi1Var, gm0Var, xl0Var, new u72(uu1Var, xl0Var), new ho0());
    }

    public w72(uu1 sdkEnvironmentModule, wi1 playerVolumeProvider, gm0 instreamAdPlayerController, xl0 customUiElementsHolder, u72 uiElementBinderProvider, ho0 videoAdOptionsStorage) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(playerVolumeProvider, "playerVolumeProvider");
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        Intrinsics.checkNotNullParameter(customUiElementsHolder, "customUiElementsHolder");
        Intrinsics.checkNotNullParameter(uiElementBinderProvider, "uiElementBinderProvider");
        Intrinsics.checkNotNullParameter(videoAdOptionsStorage, "videoAdOptionsStorage");
        this.f10540a = playerVolumeProvider;
        this.b = instreamAdPlayerController;
        this.c = uiElementBinderProvider;
        this.d = videoAdOptionsStorage;
    }
}
