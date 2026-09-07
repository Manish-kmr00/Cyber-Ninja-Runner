package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a81 implements fb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final za1 f8378a;
    private ne2 b;

    public a81(za1 nativeVideoController, ie2 videoLifecycleListener, ne2 ne2Var) {
        Intrinsics.checkNotNullParameter(nativeVideoController, "nativeVideoController");
        Intrinsics.checkNotNullParameter(videoLifecycleListener, "videoLifecycleListener");
        this.f8378a = nativeVideoController;
        this.b = ne2Var;
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void a() {
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void a(long j, long j2) {
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void b() {
        ne2 ne2Var = this.b;
        if (ne2Var != null) {
            ne2Var.onVideoComplete();
        }
    }

    public final void c() {
        this.f8378a.b(this);
        this.b = null;
    }

    public final void d() {
        this.f8378a.a(this);
    }
}
