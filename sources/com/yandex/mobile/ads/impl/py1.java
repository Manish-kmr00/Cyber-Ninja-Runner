package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class py1 implements x8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u2 f9958a;
    private y8 b;

    public py1(Context context, dt adBreak, gm0 instreamAdPlayerController, vm0 interfaceElementsManager, zm0 instreamAdViewsHolderManager, z2 adBreakStatusController, u2 adBreakPlaybackController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        Intrinsics.checkNotNullParameter(interfaceElementsManager, "interfaceElementsManager");
        Intrinsics.checkNotNullParameter(instreamAdViewsHolderManager, "instreamAdViewsHolderManager");
        Intrinsics.checkNotNullParameter(adBreakStatusController, "adBreakStatusController");
        Intrinsics.checkNotNullParameter(adBreakPlaybackController, "adBreakPlaybackController");
        this.f9958a = adBreakPlaybackController;
        adBreakPlaybackController.a(new a());
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void prepare() {
        this.f9958a.d();
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void start() {
        this.f9958a.g();
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void f() {
        this.f9958a.c();
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void c() {
        this.f9958a.b();
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void resume() {
        this.f9958a.f();
    }

    private final class a implements v2 {
        @Override // com.yandex.mobile.ads.impl.v2
        public final void b() {
        }

        @Override // com.yandex.mobile.ads.impl.v2
        public final void d() {
        }

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.v2
        public final void a() {
            y8 y8Var = py1.this.b;
            if (y8Var != null) {
                y8Var.b();
            }
        }

        @Override // com.yandex.mobile.ads.impl.v2
        public final void e() {
            y8 y8Var = py1.this.b;
            if (y8Var != null) {
                y8Var.c();
            }
        }

        @Override // com.yandex.mobile.ads.impl.v2
        public final void g() {
            y8 y8Var = py1.this.b;
            if (y8Var != null) {
                y8Var.a();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void a(io0 io0Var) {
        this.f9958a.a(io0Var);
    }

    @Override // com.yandex.mobile.ads.impl.x8
    public final void a(y8 y8Var) {
        this.b = y8Var;
    }
}
