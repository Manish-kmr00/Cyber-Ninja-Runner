package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class r01 implements x8, dj1, v2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z2 f10062a;
    private final ue2 b;
    private final fb2 c;
    private final q01 d;
    private final a e;
    private final bj1 f;
    private y8 g;
    private u2 h;

    public r01(Context context, lm0 instreamAdPlaylist, z2 adBreakStatusController, gm0 instreamAdPlayerController, vm0 interfaceElementsManager, zm0 instreamAdViewsHolderManager, ye2 videoPlayerController, ue2 videoPlaybackController, fb2 videoAdCreativePlaybackProxyListener, cj1 schedulerCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instreamAdPlaylist, "instreamAdPlaylist");
        Intrinsics.checkNotNullParameter(adBreakStatusController, "adBreakStatusController");
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        Intrinsics.checkNotNullParameter(interfaceElementsManager, "interfaceElementsManager");
        Intrinsics.checkNotNullParameter(instreamAdViewsHolderManager, "instreamAdViewsHolderManager");
        Intrinsics.checkNotNullParameter(videoPlayerController, "videoPlayerController");
        Intrinsics.checkNotNullParameter(videoPlaybackController, "videoPlaybackController");
        Intrinsics.checkNotNullParameter(videoAdCreativePlaybackProxyListener, "videoAdCreativePlaybackProxyListener");
        Intrinsics.checkNotNullParameter(schedulerCreator, "schedulerCreator");
        this.f10062a = adBreakStatusController;
        this.b = videoPlaybackController;
        this.c = videoAdCreativePlaybackProxyListener;
        this.d = new q01(context, adBreakStatusController, instreamAdPlayerController, interfaceElementsManager, instreamAdViewsHolderManager, videoAdCreativePlaybackProxyListener);
        this.e = new a();
        this.f = schedulerCreator.a(instreamAdPlaylist, this);
    }

    @Override // com.yandex.mobile.ads.impl.v2
    public final void a() {
    }

    @Override // com.yandex.mobile.ads.impl.v2
    public final void b() {
    }

    public static final void e(r01 r01Var) {
        u2 u2Var = r01Var.h;
        if (u2Var != null) {
            u2Var.a((v2) null);
        }
        u2 u2Var2 = r01Var.h;
        if (u2Var2 != null) {
            u2Var2.e();
        }
    }

    @Override // com.yandex.mobile.ads.impl.dj1
    public final void a(dt adBreak) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        u2 u2VarA = this.d.a(adBreak);
        if (!Intrinsics.areEqual(u2VarA, this.h)) {
            u2 u2Var = this.h;
            if (u2Var != null) {
                u2Var.a((v2) null);
            }
            u2 u2Var2 = this.h;
            if (u2Var2 != null) {
                u2Var2.e();
            }
        }
        u2VarA.a(this);
        u2VarA.g();
        this.h = u2VarA;
    }

    @Override // com.yandex.mobile.ads.impl.dj1
    public final void b(dt adBreak) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        u2 u2VarA = this.d.a(adBreak);
        if (!Intrinsics.areEqual(u2VarA, this.h)) {
            u2 u2Var = this.h;
            if (u2Var != null) {
                u2Var.a((v2) null);
            }
            u2 u2Var2 = this.h;
            if (u2Var2 != null) {
                u2Var2.e();
            }
        }
        u2VarA.a(this);
        u2VarA.d();
        this.h = u2VarA;
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void prepare() {
        y8 y8Var = this.g;
        if (y8Var != null) {
            y8Var.b();
        }
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void start() {
        this.b.a(this.e);
        this.b.e();
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void f() {
        this.f.b();
        u2 u2Var = this.h;
        if (u2Var != null) {
            u2Var.c();
        }
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void resume() {
        Unit unit;
        u2 u2Var = this.h;
        if (u2Var != null) {
            if (this.f10062a.a()) {
                this.b.c();
                u2Var.f();
            } else {
                this.b.e();
                u2Var.d();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.b.e();
        }
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void c() {
        this.f.b();
        u2 u2Var = this.h;
        if (u2Var != null) {
            u2Var.b();
        }
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void a(io0 io0Var) {
        this.c.a(io0Var);
    }

    @Override // com.yandex.mobile.ads.impl.v2
    public final void e() {
        this.h = null;
        this.b.e();
    }

    @Override // com.yandex.mobile.ads.impl.v2
    public final void g() {
        this.h = null;
        this.b.e();
    }

    @Override // com.yandex.mobile.ads.impl.v2
    public final void d() {
        this.b.c();
    }

    private final class a implements we2 {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.we2
        public final void onVideoCompleted() {
            r01.e(r01.this);
            r01.this.f.b();
            r01.this.b.a(null);
            y8 y8Var = r01.this.g;
            if (y8Var != null) {
                y8Var.c();
            }
        }

        @Override // com.yandex.mobile.ads.impl.we2
        public final void onVideoResumed() {
            r01.this.f.a();
        }

        @Override // com.yandex.mobile.ads.impl.we2
        public final void onVideoPaused() {
            r01.this.f.b();
        }

        @Override // com.yandex.mobile.ads.impl.we2
        public final void a() {
            r01.this.f.b();
            u2 u2Var = r01.this.h;
            if (u2Var != null) {
                u2Var.c();
            }
        }

        @Override // com.yandex.mobile.ads.impl.we2
        public final void onVideoError() {
            r01.this.f.b();
            r01.this.b.a(null);
            u2 u2Var = r01.this.h;
            if (u2Var != null) {
                u2Var.c();
            }
            y8 y8Var = r01.this.g;
            if (y8Var != null) {
                y8Var.a();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void a(y8 y8Var) {
        this.g = y8Var;
    }
}
