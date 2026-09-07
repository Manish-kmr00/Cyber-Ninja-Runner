package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class qo0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gm0 f10040a;
    private final ye2 b;
    private final zm0 c;
    private final oo0 d;

    public final void a(q70 instreamAdView, List<pb2> friendlyOverlays) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
        this.c.a(instreamAdView, friendlyOverlays);
        this.f10040a.a();
        this.b.g();
        this.d.a();
    }

    public /* synthetic */ qo0(Context context, uu1 uu1Var, bt btVar, gm0 gm0Var, ye2 ye2Var, xl0 xl0Var) {
        zm0 zm0Var = new zm0();
        this(context, uu1Var, btVar, gm0Var, ye2Var, xl0Var, zm0Var, new oo0(context, uu1Var, btVar, gm0Var, zm0Var, ye2Var, xl0Var));
    }

    public qo0(Context context, uu1 sdkEnvironmentModule, bt instreamVideoAd, gm0 instreamAdPlayerController, ye2 videoPlayerController, xl0 customUiElementsHolder, zm0 instreamAdViewsHolderManager, oo0 instreamVideoPresenter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamVideoAd, "instreamVideoAd");
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        Intrinsics.checkNotNullParameter(videoPlayerController, "videoPlayerController");
        Intrinsics.checkNotNullParameter(customUiElementsHolder, "customUiElementsHolder");
        Intrinsics.checkNotNullParameter(instreamAdViewsHolderManager, "instreamAdViewsHolderManager");
        Intrinsics.checkNotNullParameter(instreamVideoPresenter, "instreamVideoPresenter");
        this.f10040a = instreamAdPlayerController;
        this.b = videoPlayerController;
        this.c = instreamAdViewsHolderManager;
        this.d = instreamVideoPresenter;
    }

    public final void b() {
        this.d.d();
    }

    public final void d() {
        this.d.j();
        this.c.b();
    }

    public final void c() {
        this.f10040a.a();
        this.d.h();
    }

    public final void a() {
        this.d.c();
    }

    public final void a(io0 io0Var) {
        this.d.a(io0Var);
    }

    public final void a(po0 po0Var) {
        this.d.a(po0Var);
    }
}
