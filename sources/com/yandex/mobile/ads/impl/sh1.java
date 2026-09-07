package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class sh1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nm0 f10208a;
    private final rh1 b;
    private py1 c;
    private r01 d;
    private py1 e;

    public /* synthetic */ sh1(Context context, uu1 uu1Var, bt btVar, gm0 gm0Var, zm0 zm0Var, ye2 ye2Var, ue2 ue2Var, xl0 xl0Var) {
        this(context, uu1Var, btVar, gm0Var, zm0Var, ye2Var, ue2Var, xl0Var, new nm0(btVar, ye2Var));
    }

    public sh1(Context context, uu1 sdkEnvironmentModule, bt instreamVideoAd, gm0 instreamAdPlayerController, zm0 instreamAdViewHolderProvider, ye2 videoPlayerController, ue2 videoPlaybackController, xl0 customUiElementsHolder, nm0 instreamAdPlaylistHolder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamVideoAd, "instreamVideoAd");
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        Intrinsics.checkNotNullParameter(instreamAdViewHolderProvider, "instreamAdViewHolderProvider");
        Intrinsics.checkNotNullParameter(videoPlayerController, "videoPlayerController");
        Intrinsics.checkNotNullParameter(videoPlaybackController, "videoPlaybackController");
        Intrinsics.checkNotNullParameter(customUiElementsHolder, "customUiElementsHolder");
        Intrinsics.checkNotNullParameter(instreamAdPlaylistHolder, "instreamAdPlaylistHolder");
        this.f10208a = instreamAdPlaylistHolder;
        this.b = new rh1(context, sdkEnvironmentModule, instreamAdPlayerController, videoPlayerController, videoPlaybackController, instreamAdViewHolderProvider, instreamAdPlaylistHolder, customUiElementsHolder);
    }

    public final x8 c() {
        py1 py1VarA = this.c;
        if (py1VarA == null) {
            dt dtVarC = this.f10208a.a().c();
            py1VarA = dtVarC != null ? this.b.a(dtVarC) : null;
            this.c = py1VarA;
        }
        return py1VarA;
    }

    public final x8 a() {
        r01 r01Var = this.d;
        if (r01Var != null) {
            return r01Var;
        }
        r01 r01VarA = this.b.a(this.f10208a.a());
        this.d = r01VarA;
        return r01VarA;
    }

    public final x8 b() {
        py1 py1VarA = this.e;
        if (py1VarA == null) {
            dt dtVarB = this.f10208a.a().b();
            py1VarA = dtVarB != null ? this.b.a(dtVarB) : null;
            this.e = py1VarA;
        }
        return py1VarA;
    }
}
