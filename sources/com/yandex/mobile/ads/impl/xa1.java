package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class xa1 implements vc0, fb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final za1 f10635a;
    private final xp b;
    private final Long c;
    private final yp d;
    private final ip e;

    public xa1(o8<?> adResponse, za1 nativeVideoController, xp closeShowListener, y42 timeProviderContainer, Long l, yp closeTimerProgressIncrementer, ip closableAdChecker) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeVideoController, "nativeVideoController");
        Intrinsics.checkNotNullParameter(closeShowListener, "closeShowListener");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(closeTimerProgressIncrementer, "closeTimerProgressIncrementer");
        Intrinsics.checkNotNullParameter(closableAdChecker, "closableAdChecker");
        this.f10635a = nativeVideoController;
        this.b = closeShowListener;
        this.c = l;
        this.d = closeTimerProgressIncrementer;
        this.e = closableAdChecker;
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void pause() {
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void resume() {
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void invalidate() {
        this.f10635a.b(this);
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void b() {
        if (this.e.a()) {
            this.b.a();
            this.f10635a.b(this);
        }
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void a(long j, long j2) {
        if (this.e.a()) {
            this.d.a(j - j2, j2);
            long jA = this.d.a() + j2;
            Long l = this.c;
            if (l == null || jA < l.longValue()) {
                return;
            }
            this.b.a();
            this.f10635a.b(this);
        }
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void a() {
        this.b.a();
        this.f10635a.b(this);
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void start() {
        this.f10635a.a(this);
        if (!this.e.a() || this.c == null || this.d.a() < this.c.longValue()) {
            return;
        }
        this.b.a();
        this.f10635a.b(this);
    }
}
