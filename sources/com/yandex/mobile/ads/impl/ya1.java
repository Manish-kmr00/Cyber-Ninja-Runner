package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ya1 implements vc0, fb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final za1 f10716a;
    private final Long b;
    private k3 c;
    private ul1 d;

    public ya1(o8<?> adResponse, za1 nativeVideoController, k3 adCompleteListener, ul1 progressListener, Long l) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeVideoController, "nativeVideoController");
        Intrinsics.checkNotNullParameter(adCompleteListener, "adCompleteListener");
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        this.f10716a = nativeVideoController;
        this.b = l;
        this.c = adCompleteListener;
        this.d = progressListener;
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void pause() {
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void resume() {
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void b() {
        ul1 ul1Var = this.d;
        if (ul1Var != null) {
            ul1Var.a();
        }
        k3 k3Var = this.c;
        if (k3Var != null) {
            k3Var.b();
        }
        this.f10716a.b(this);
        this.c = null;
        this.d = null;
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void invalidate() {
        this.f10716a.b(this);
        this.c = null;
        this.d = null;
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void start() {
        this.f10716a.a(this);
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void a(long j, long j2) {
        ul1 ul1Var = this.d;
        if (ul1Var != null) {
            ul1Var.a(j, j2);
        }
        Long l = this.b;
        if (l == null || j2 <= l.longValue()) {
            return;
        }
        ul1 ul1Var2 = this.d;
        if (ul1Var2 != null) {
            ul1Var2.a();
        }
        k3 k3Var = this.c;
        if (k3Var != null) {
            k3Var.b();
        }
        this.f10716a.b(this);
        this.c = null;
        this.d = null;
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void a() {
        k3 k3Var = this.c;
        if (k3Var != null) {
            k3Var.a();
        }
        this.c = null;
    }
}
