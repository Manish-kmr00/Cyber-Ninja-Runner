package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class mt0 implements a82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dt f9669a;
    private final tt0 b;
    private final fb2 c;
    private final pt0 d;
    private final im0 e;
    private ot0 f;
    private gt g;

    public mt0(Context context, uu1 sdkEnvironmentModule, dt instreamAdBreak, z2 adBreakStatusController, xl0 customUiElementsHolder, jm0 instreamAdPlayerReuseControllerFactory, tt0 manualPlaybackEventListener, fb2 videoAdCreativePlaybackProxyListener, pt0 presenterProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamAdBreak, "instreamAdBreak");
        Intrinsics.checkNotNullParameter(adBreakStatusController, "adBreakStatusController");
        Intrinsics.checkNotNullParameter(customUiElementsHolder, "customUiElementsHolder");
        Intrinsics.checkNotNullParameter(instreamAdPlayerReuseControllerFactory, "instreamAdPlayerReuseControllerFactory");
        Intrinsics.checkNotNullParameter(manualPlaybackEventListener, "manualPlaybackEventListener");
        Intrinsics.checkNotNullParameter(videoAdCreativePlaybackProxyListener, "videoAdCreativePlaybackProxyListener");
        Intrinsics.checkNotNullParameter(presenterProvider, "presenterProvider");
        this.f9669a = instreamAdBreak;
        this.b = manualPlaybackEventListener;
        this.c = videoAdCreativePlaybackProxyListener;
        this.d = presenterProvider;
        instreamAdPlayerReuseControllerFactory.getClass();
        this.e = jm0.a(this);
    }

    public final void b() {
        ot0 ot0Var = this.f;
        if (ot0Var != null) {
            ot0Var.a();
        }
        gt gtVar = this.g;
        if (gtVar != null) {
            this.e.b(gtVar);
        }
        this.f = null;
        this.g = null;
    }

    @Override // com.yandex.mobile.ads.impl.a82
    public final void invalidateAdPlayer() {
        ot0 ot0Var = this.f;
        if (ot0Var != null) {
            ot0Var.a();
        }
        gt gtVar = this.g;
        if (gtVar != null) {
            this.e.b(gtVar);
        }
        this.f = null;
        this.g = null;
    }

    public final dt a() {
        return this.f9669a;
    }

    public final void a(q70 instreamAdView) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        ot0 ot0Var = this.f;
        if (ot0Var != null) {
            ot0Var.a(instreamAdView);
        }
    }

    public final void c() {
        ot0 ot0Var = this.f;
        if (ot0Var != null) {
            ot0Var.b();
        }
    }

    public final void d() {
        ot0 ot0Var = this.f;
        if (ot0Var != null) {
            ot0Var.d();
        }
    }

    public final void a(zl2 player) {
        Intrinsics.checkNotNullParameter(player, "player");
        ot0 ot0Var = this.f;
        if (ot0Var != null) {
            ot0Var.a();
        }
        gt gtVar = this.g;
        if (gtVar != null) {
            this.e.b(gtVar);
        }
        this.f = null;
        this.g = player;
        this.e.a(player);
        ot0 ot0VarA = this.d.a(player);
        ot0VarA.a(this.c);
        ot0VarA.c();
        this.f = ot0VarA;
    }

    public final void a(io0 io0Var) {
        this.c.a(io0Var);
    }

    public final void a(ul2 ul2Var) {
        this.b.a(ul2Var);
    }
}
