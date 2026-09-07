package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ue2 implements ku {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ye2 f10382a;
    private final oo0 b;
    private final yf2 c;
    private we2 d;

    public ue2(ye2 videoPlayerController, oo0 instreamVideoPresenter) {
        Intrinsics.checkNotNullParameter(videoPlayerController, "videoPlayerController");
        Intrinsics.checkNotNullParameter(instreamVideoPresenter, "instreamVideoPresenter");
        this.f10382a = videoPlayerController;
        this.b = instreamVideoPresenter;
        this.c = videoPlayerController.a();
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoPrepared() {
        if (xf2.c == this.c.a()) {
            this.c.a(xf2.d);
            this.b.f();
        }
    }

    public final void d() {
        this.c.a(xf2.c);
        this.f10382a.e();
    }

    public final void a() {
        int iOrdinal = this.c.a().ordinal();
        if (iOrdinal == 0) {
            this.b.g();
            return;
        }
        if (iOrdinal == 7) {
            this.b.e();
            return;
        }
        if (iOrdinal == 4) {
            this.f10382a.d();
            this.b.i();
        } else {
            if (iOrdinal != 5) {
                return;
            }
            this.b.b();
        }
    }

    public final void f() {
        int iOrdinal = this.c.a().ordinal();
        if (iOrdinal == 1) {
            this.c.a(xf2.b);
        } else if (iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 6) {
            this.c.a(xf2.f);
        }
    }

    public final void b() {
        int iOrdinal = this.c.a().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4 || iOrdinal == 6 || iOrdinal == 7) {
            this.c.a(xf2.b);
            we2 we2Var = this.d;
            if (we2Var != null) {
                we2Var.a();
            }
        }
    }

    public final void a(we2 we2Var) {
        this.d = we2Var;
    }

    public final void c() {
        int iOrdinal = this.c.a().ordinal();
        if (iOrdinal == 2 || iOrdinal == 3) {
            this.f10382a.d();
        }
    }

    public final void e() {
        int iOrdinal = this.c.a().ordinal();
        if (iOrdinal == 2 || iOrdinal == 6) {
            this.f10382a.f();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoResumed() {
        this.c.a(xf2.e);
        we2 we2Var = this.d;
        if (we2Var != null) {
            we2Var.onVideoResumed();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoPaused() {
        this.c.a(xf2.h);
        we2 we2Var = this.d;
        if (we2Var != null) {
            we2Var.onVideoPaused();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoCompleted() {
        this.c.a(xf2.g);
        we2 we2Var = this.d;
        if (we2Var != null) {
            we2Var.onVideoCompleted();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoError() {
        this.c.a(xf2.i);
        we2 we2Var = this.d;
        if (we2Var != null) {
            we2Var.onVideoError();
        }
    }
}
