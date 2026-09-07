package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class dc1 implements vc0, fc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ec1 f8680a;
    private k3 b;

    public dc1(ec1 nativeWebViewController, k3 adCompleteListener) {
        Intrinsics.checkNotNullParameter(nativeWebViewController, "nativeWebViewController");
        Intrinsics.checkNotNullParameter(adCompleteListener, "adCompleteListener");
        this.f8680a = nativeWebViewController;
        this.b = adCompleteListener;
    }

    @Override // com.yandex.mobile.ads.impl.fc1
    public final void a(boolean z) {
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void pause() {
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void resume() {
    }

    @Override // com.yandex.mobile.ads.impl.fc1
    public final void a() {
        k3 k3Var = this.b;
        if (k3Var != null) {
            k3Var.b();
        }
        this.f8680a.b(this);
        this.b = null;
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void invalidate() {
        this.f8680a.b(this);
        this.b = null;
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void start() {
        this.f8680a.a(this);
    }
}
