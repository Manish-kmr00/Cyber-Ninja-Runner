package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rh1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10108a;
    private final gm0 b;
    private final ye2 c;
    private final ue2 d;
    private final zm0 e;
    private final vm0 f;
    private final a3 g;

    public final r01 a(lm0 instreamAdPlaylist) {
        Intrinsics.checkNotNullParameter(instreamAdPlaylist, "instreamAdPlaylist");
        Context applicationContext = this.f10108a.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        z2 z2VarA = this.g.a();
        gm0 gm0Var = this.b;
        vm0 vm0Var = this.f;
        zm0 zm0Var = this.e;
        ye2 ye2Var = this.c;
        return new r01(applicationContext, instreamAdPlaylist, z2VarA, gm0Var, vm0Var, zm0Var, ye2Var, this.d, new fb2(), new cj1(ye2Var, z2VarA));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ rh1(Context context, uu1 uu1Var, gm0 gm0Var, ye2 ye2Var, ue2 ue2Var, zm0 zm0Var, nm0 nm0Var, xl0 xl0Var) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, uu1Var, gm0Var, ye2Var, ue2Var, zm0Var, nm0Var, xl0Var, new vm0(applicationContext, uu1Var, zm0Var, ye2Var, gm0Var, xl0Var), new a3(nm0Var));
    }

    public rh1(Context context, uu1 sdkEnvironmentModule, gm0 instreamAdPlayerController, ye2 videoPlayerController, ue2 videoPlaybackController, zm0 instreamAdViewsHolderManager, nm0 instreamAdPlaylistHolder, xl0 customUiElementsHolder, vm0 instreamAdUiElementsManager, a3 adBreakStatusControllerHolder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        Intrinsics.checkNotNullParameter(videoPlayerController, "videoPlayerController");
        Intrinsics.checkNotNullParameter(videoPlaybackController, "videoPlaybackController");
        Intrinsics.checkNotNullParameter(instreamAdViewsHolderManager, "instreamAdViewsHolderManager");
        Intrinsics.checkNotNullParameter(instreamAdPlaylistHolder, "instreamAdPlaylistHolder");
        Intrinsics.checkNotNullParameter(customUiElementsHolder, "customUiElementsHolder");
        Intrinsics.checkNotNullParameter(instreamAdUiElementsManager, "instreamAdUiElementsManager");
        Intrinsics.checkNotNullParameter(adBreakStatusControllerHolder, "adBreakStatusControllerHolder");
        this.f10108a = context;
        this.b = instreamAdPlayerController;
        this.c = videoPlayerController;
        this.d = videoPlaybackController;
        this.e = instreamAdViewsHolderManager;
        this.f = instreamAdUiElementsManager;
        this.g = adBreakStatusControllerHolder;
    }

    public final py1 a(dt adBreak) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Context applicationContext = this.f10108a.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        gm0 gm0Var = this.b;
        vm0 vm0Var = this.f;
        zm0 zm0Var = this.e;
        z2 z2VarA = this.g.a();
        return new py1(applicationContext, adBreak, gm0Var, vm0Var, zm0Var, z2VarA, new u2(applicationContext, adBreak, gm0Var, vm0Var, zm0Var, z2VarA));
    }
}
