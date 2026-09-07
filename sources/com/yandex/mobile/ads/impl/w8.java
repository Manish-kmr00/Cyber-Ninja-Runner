package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class w8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io0 f10541a;
    private final wk1 b;
    private final sh1 c;
    private final v8 d;
    private u8 e;
    private u8 f;
    private u8 g;

    public /* synthetic */ w8(Context context, uu1 uu1Var, bt btVar, gm0 gm0Var, zm0 zm0Var, ye2 ye2Var, ue2 ue2Var, io0 io0Var, xl0 xl0Var) {
        this(context, uu1Var, btVar, gm0Var, zm0Var, ye2Var, ue2Var, io0Var, xl0Var, new wk1(ye2Var), new sh1(context, uu1Var, btVar, gm0Var, zm0Var, ye2Var, ue2Var, xl0Var), new v8());
    }

    public w8(Context context, uu1 sdkEnvironmentModule, bt instreamVideoAd, gm0 instreamAdPlayerController, zm0 instreamAdViewHolderProvider, ye2 videoPlayerController, ue2 videoPlaybackController, io0 adCreativePlaybackListener, xl0 customUiElementsHolder, wk1 prerollVideoPositionStartValidator, sh1 playbackControllerHolder, v8 adSectionControllerFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamVideoAd, "instreamVideoAd");
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        Intrinsics.checkNotNullParameter(instreamAdViewHolderProvider, "instreamAdViewHolderProvider");
        Intrinsics.checkNotNullParameter(videoPlayerController, "videoPlayerController");
        Intrinsics.checkNotNullParameter(videoPlaybackController, "videoPlaybackController");
        Intrinsics.checkNotNullParameter(adCreativePlaybackListener, "adCreativePlaybackListener");
        Intrinsics.checkNotNullParameter(customUiElementsHolder, "customUiElementsHolder");
        Intrinsics.checkNotNullParameter(prerollVideoPositionStartValidator, "prerollVideoPositionStartValidator");
        Intrinsics.checkNotNullParameter(playbackControllerHolder, "playbackControllerHolder");
        Intrinsics.checkNotNullParameter(adSectionControllerFactory, "adSectionControllerFactory");
        this.f10541a = adCreativePlaybackListener;
        this.b = prerollVideoPositionStartValidator;
        this.c = playbackControllerHolder;
        this.d = adSectionControllerFactory;
    }

    public final u8 c() {
        x8 x8VarC;
        if (this.e == null && this.b.a() && (x8VarC = this.c.c()) != null) {
            this.e = a(x8VarC);
        }
        return this.e;
    }

    public final u8 b() {
        x8 x8VarB;
        if (this.g == null && (x8VarB = this.c.b()) != null) {
            this.g = a(x8VarB);
        }
        return this.g;
    }

    private final u8 a(x8 adSectionPlaybackController) {
        v8 v8Var = this.d;
        a9 adSectionStatusController = new a9();
        fb2 adCreativePlaybackProxyListener = new fb2();
        v8Var.getClass();
        Intrinsics.checkNotNullParameter(adSectionPlaybackController, "adSectionPlaybackController");
        Intrinsics.checkNotNullParameter(adSectionStatusController, "adSectionStatusController");
        Intrinsics.checkNotNullParameter(adCreativePlaybackProxyListener, "adCreativePlaybackProxyListener");
        u8 u8Var = new u8(adSectionPlaybackController, adSectionStatusController, adCreativePlaybackProxyListener);
        u8Var.a(this.f10541a);
        return u8Var;
    }

    public final u8 a() {
        u8 u8Var = this.f;
        if (u8Var != null) {
            return u8Var;
        }
        u8 u8VarA = a(this.c.a());
        this.f = u8VarA;
        return u8VarA;
    }
}
