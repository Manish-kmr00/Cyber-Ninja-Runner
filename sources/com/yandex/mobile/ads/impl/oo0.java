package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class oo0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gm0 f9839a;
    private final ye2 b;
    private final fb2 c;
    private final c d;
    private final a e;
    private final b f;
    private final ue2 g;
    private final w8 h;
    private u8 i;
    private po0 j;
    private boolean k;

    public /* synthetic */ oo0(Context context, uu1 uu1Var, bt btVar, gm0 gm0Var, zm0 zm0Var, ye2 ye2Var, xl0 xl0Var) {
        this(context, uu1Var, btVar, gm0Var, zm0Var, ye2Var, xl0Var, new ve2(), new fb2());
    }

    public static final void c(oo0 oo0Var) {
        po0 po0Var = oo0Var.j;
        if (po0Var != null) {
            po0Var.a();
        }
        oo0Var.b.h();
        oo0Var.f9839a.b();
    }

    public static final void d(oo0 oo0Var) {
        u8 u8VarA = oo0Var.h.a();
        oo0Var.i = u8VarA;
        u8VarA.a(oo0Var.e);
        u8 u8Var = oo0Var.i;
        if (u8Var != null) {
            u8Var.f();
        }
    }

    public static final void e(oo0 oo0Var) {
        u8 u8VarB = oo0Var.h.b();
        oo0Var.i = u8VarB;
        if (u8VarB != null) {
            u8VarB.a(oo0Var.f);
            u8 u8Var = oo0Var.i;
            if (u8Var != null) {
                u8Var.f();
                return;
            }
            return;
        }
        po0 po0Var = oo0Var.j;
        if (po0Var != null) {
            po0Var.a();
        }
        oo0Var.b.h();
        oo0Var.f9839a.b();
    }

    public static final void g(oo0 oo0Var) {
        u8 u8Var = oo0Var.i;
        if (u8Var != null) {
            u8Var.h();
        }
    }

    public final void f() {
        if (this.i != null) {
            this.g.c();
            u8 u8Var = this.i;
            if (u8Var != null) {
                u8Var.h();
                return;
            }
            return;
        }
        u8 u8VarC = this.h.c();
        this.i = u8VarC;
        if (u8VarC != null) {
            u8VarC.a(this.d);
            this.g.c();
            this.k = true;
            u8 u8Var2 = this.i;
            if (u8Var2 != null) {
                u8Var2.f();
                return;
            }
            return;
        }
        u8 u8VarA = this.h.a();
        this.i = u8VarA;
        u8VarA.a(this.e);
        u8 u8Var3 = this.i;
        if (u8Var3 != null) {
            u8Var3.f();
        }
    }

    public oo0(Context context, uu1 sdkEnvironmentModule, bt instreamVideoAd, gm0 instreamAdPlayerController, zm0 instreamAdViewsHolderManager, ye2 videoPlayerController, xl0 customUiElementsHolder, ve2 videoPlaybackControllerFactory, fb2 videoAdCreativePlaybackProxyListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamVideoAd, "instreamVideoAd");
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        Intrinsics.checkNotNullParameter(instreamAdViewsHolderManager, "instreamAdViewsHolderManager");
        Intrinsics.checkNotNullParameter(videoPlayerController, "videoPlayerController");
        Intrinsics.checkNotNullParameter(customUiElementsHolder, "customUiElementsHolder");
        Intrinsics.checkNotNullParameter(videoPlaybackControllerFactory, "videoPlaybackControllerFactory");
        Intrinsics.checkNotNullParameter(videoAdCreativePlaybackProxyListener, "videoAdCreativePlaybackProxyListener");
        this.f9839a = instreamAdPlayerController;
        this.b = videoPlayerController;
        this.c = videoAdCreativePlaybackProxyListener;
        this.d = new c();
        this.e = new a();
        this.f = new b();
        videoPlaybackControllerFactory.getClass();
        ue2 ue2VarA = ve2.a(videoPlayerController, this);
        this.g = ue2VarA;
        this.h = new w8(context, sdkEnvironmentModule, instreamVideoAd, instreamAdPlayerController, instreamAdViewsHolderManager, videoPlayerController, ue2VarA, videoAdCreativePlaybackProxyListener, customUiElementsHolder);
    }

    public final void g() {
        this.b.a(this.g);
        this.g.d();
    }

    public final void h() {
        if (this.i == null) {
            u8 u8VarC = this.h.c();
            this.i = u8VarC;
            if (u8VarC != null) {
                u8VarC.a(this.d);
                this.k = false;
                u8 u8Var = this.i;
                if (u8Var != null) {
                    u8Var.f();
                    return;
                }
                return;
            }
            po0 po0Var = this.j;
            if (po0Var != null) {
                po0Var.onInstreamAdPrepared();
                return;
            }
            return;
        }
        po0 po0Var2 = this.j;
        if (po0Var2 != null) {
            po0Var2.onInstreamAdPrepared();
        }
    }

    public final void j() {
        this.g.f();
        u8 u8Var = this.i;
        if (u8Var != null) {
            u8Var.e();
        }
    }

    public final void b() {
        u8 u8Var = this.i;
        if (u8Var != null) {
            u8Var.g();
            return;
        }
        po0 po0Var = this.j;
        if (po0Var != null) {
            po0Var.a();
        }
        this.b.h();
        this.f9839a.b();
    }

    public final void d() {
        c();
        this.b.h();
        this.g.b();
    }

    public final void a() {
        this.g.a();
    }

    public final void c() {
        u8 u8Var = this.i;
        if (u8Var != null) {
            u8Var.d();
        }
        this.f9839a.b();
    }

    public final void i() {
        u8 u8Var = this.i;
        if (u8Var != null) {
            u8Var.g();
        }
    }

    public final void e() {
        po0 po0Var = this.j;
        if (po0Var != null) {
            po0Var.b();
        }
        this.b.h();
        this.f9839a.b();
    }

    public final void a(io0 io0Var) {
        this.c.a(io0Var);
    }

    private final class c implements y8 {
        public c() {
        }

        @Override // com.yandex.mobile.ads.impl.y8
        public final void b() {
            boolean z = oo0.this.k;
            oo0.this.k = false;
            if (!z) {
                po0 po0Var = oo0.this.j;
                if (po0Var != null) {
                    po0Var.onInstreamAdPrepared();
                    return;
                }
                return;
            }
            oo0.g(oo0.this);
        }

        @Override // com.yandex.mobile.ads.impl.y8
        public final void c() {
            oo0.d(oo0.this);
        }

        @Override // com.yandex.mobile.ads.impl.y8
        public final void a() {
            oo0.this.k = false;
            oo0.d(oo0.this);
        }
    }

    public final void a(po0 po0Var) {
        this.j = po0Var;
    }

    private final class a implements y8 {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.y8
        public final void b() {
            oo0.g(oo0.this);
        }

        @Override // com.yandex.mobile.ads.impl.y8
        public final void c() {
            oo0.e(oo0.this);
        }

        @Override // com.yandex.mobile.ads.impl.y8
        public final void a() {
            oo0.this.e();
        }
    }

    private final class b implements y8 {
        public b() {
        }

        @Override // com.yandex.mobile.ads.impl.y8
        public final void b() {
            oo0.g(oo0.this);
        }

        @Override // com.yandex.mobile.ads.impl.y8
        public final void c() {
            oo0.c(oo0.this);
        }

        @Override // com.yandex.mobile.ads.impl.y8
        public final void a() {
            oo0.c(oo0.this);
        }
    }
}
