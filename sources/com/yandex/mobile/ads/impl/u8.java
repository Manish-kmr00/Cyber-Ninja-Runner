package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class u8 implements y8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x8 f10363a;
    private final a9 b;
    private final fb2 c;
    private y8 d;

    public u8(x8 adSectionPlaybackController, a9 adSectionStatusController, fb2 adCreativePlaybackProxyListener) {
        Intrinsics.checkNotNullParameter(adSectionPlaybackController, "adSectionPlaybackController");
        Intrinsics.checkNotNullParameter(adSectionStatusController, "adSectionStatusController");
        Intrinsics.checkNotNullParameter(adCreativePlaybackProxyListener, "adCreativePlaybackProxyListener");
        this.f10363a = adSectionPlaybackController;
        this.b = adSectionStatusController;
        this.c = adCreativePlaybackProxyListener;
        adSectionPlaybackController.a(this);
        adSectionPlaybackController.a(adCreativePlaybackProxyListener);
    }

    public final void f() {
        y8 y8Var;
        int iOrdinal = this.b.a().ordinal();
        if (iOrdinal == 0) {
            this.f10363a.prepare();
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 4 && (y8Var = this.d) != null) {
                y8Var.a();
                return;
            }
            return;
        }
        y8 y8Var2 = this.d;
        if (y8Var2 != null) {
            y8Var2.b();
        }
    }

    public final void h() {
        y8 y8Var;
        int iOrdinal = this.b.a().ordinal();
        if (iOrdinal == 0) {
            this.f10363a.prepare();
            return;
        }
        if (iOrdinal == 1) {
            this.b.a(z8.d);
            this.f10363a.start();
            return;
        }
        if (iOrdinal == 2) {
            this.f10363a.resume();
            return;
        }
        if (iOrdinal != 3) {
            if (iOrdinal == 4 && (y8Var = this.d) != null) {
                y8Var.a();
                return;
            }
            return;
        }
        y8 y8Var2 = this.d;
        if (y8Var2 != null) {
            y8Var2.c();
        }
    }

    public final void e() {
        int iOrdinal = this.b.a().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            this.f10363a.f();
        }
    }

    public final void d() {
        int iOrdinal = this.b.a().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            this.f10363a.c();
        }
    }

    public final void g() {
        y8 y8Var;
        int iOrdinal = this.b.a().ordinal();
        if (iOrdinal == 0) {
            this.f10363a.prepare();
            return;
        }
        if (iOrdinal == 2) {
            this.f10363a.resume();
            return;
        }
        if (iOrdinal != 3) {
            if (iOrdinal == 4 && (y8Var = this.d) != null) {
                y8Var.a();
                return;
            }
            return;
        }
        y8 y8Var2 = this.d;
        if (y8Var2 != null) {
            y8Var2.c();
        }
    }

    @Override // com.yandex.mobile.ads.impl.y8
    public final void b() {
        this.b.a(z8.c);
        y8 y8Var = this.d;
        if (y8Var != null) {
            y8Var.b();
        }
    }

    @Override // com.yandex.mobile.ads.impl.y8
    public final void c() {
        this.b.a(z8.e);
        y8 y8Var = this.d;
        if (y8Var != null) {
            y8Var.c();
        }
    }

    @Override // com.yandex.mobile.ads.impl.y8
    public final void a() {
        this.b.a(z8.f);
        y8 y8Var = this.d;
        if (y8Var != null) {
            y8Var.a();
        }
    }

    public final void a(io0 io0Var) {
        this.c.a(io0Var);
    }

    public final void a(y8 y8Var) {
        this.d = y8Var;
    }
}
