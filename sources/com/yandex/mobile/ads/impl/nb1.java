package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class nb1 implements vc0, fb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final za1 f9717a;
    private final ul1 b;
    private final tl1 c;
    private final z1 d;

    public nb1(za1 nativeVideoController, ul1 progressListener, y42 timeProviderContainer, tl1 progressIncrementer, z1 adBlockDurationProvider) {
        Intrinsics.checkNotNullParameter(nativeVideoController, "nativeVideoController");
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(progressIncrementer, "progressIncrementer");
        Intrinsics.checkNotNullParameter(adBlockDurationProvider, "adBlockDurationProvider");
        this.f9717a = nativeVideoController;
        this.b = progressListener;
        this.c = progressIncrementer;
        this.d = adBlockDurationProvider;
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void pause() {
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void resume() {
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void start() {
        this.f9717a.a(this);
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void invalidate() {
        this.f9717a.b(this);
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void b() {
        this.b.a();
        this.f9717a.b(this);
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void a(long j, long j2) {
        long jA = this.c.a() + j2;
        long jA2 = this.d.a(j);
        if (jA >= jA2) {
            this.f9717a.b(this);
            this.b.a();
        } else {
            this.b.a(jA2, jA);
        }
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void a() {
        this.b.a();
        this.f9717a.b(this);
    }
}
