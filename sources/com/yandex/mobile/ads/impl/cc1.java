package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class cc1 implements vc0, fc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ec1 f8589a;
    private final xp b;

    public cc1(ec1 nativeWebViewController, xp closeShowListener) {
        Intrinsics.checkNotNullParameter(nativeWebViewController, "nativeWebViewController");
        Intrinsics.checkNotNullParameter(closeShowListener, "closeShowListener");
        this.f8589a = nativeWebViewController;
        this.b = closeShowListener;
    }

    @Override // com.yandex.mobile.ads.impl.fc1
    public final void a() {
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void pause() {
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void resume() {
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void invalidate() {
        this.f8589a.b(this);
    }

    @Override // com.yandex.mobile.ads.impl.fc1
    public final void a(boolean z) {
        if (z) {
            return;
        }
        this.b.a();
        this.f8589a.b(this);
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void start() {
        this.f8589a.a(this);
    }
}
