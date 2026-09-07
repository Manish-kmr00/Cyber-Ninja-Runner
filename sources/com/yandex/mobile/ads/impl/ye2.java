package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ye2 implements wi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ju f10730a;
    private final yf2 b;
    private final df2 c;

    public final void a(ue2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.c.a(listener);
    }

    public /* synthetic */ ye2(ju juVar) {
        this(juVar, new yf2(), new df2());
    }

    public ye2(ju videoPlayer, yf2 statusController, df2 videoPlayerEventsController) {
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        Intrinsics.checkNotNullParameter(statusController, "statusController");
        Intrinsics.checkNotNullParameter(videoPlayerEventsController, "videoPlayerEventsController");
        this.f10730a = videoPlayer;
        this.b = statusController;
        this.c = videoPlayerEventsController;
    }

    public final yf2 a() {
        return this.b;
    }

    public final long b() {
        return this.f10730a.getVideoDuration();
    }

    public final long c() {
        return this.f10730a.getVideoPosition();
    }

    @Override // com.yandex.mobile.ads.impl.wi1
    public final float getVolume() {
        return this.f10730a.getVolume();
    }

    public final void e() {
        this.f10730a.prepareVideo();
    }

    public final void d() {
        this.f10730a.pauseVideo();
    }

    public final void f() {
        this.f10730a.resumeVideo();
    }

    public final void g() {
        this.f10730a.a(this.c);
    }

    public final void h() {
        this.f10730a.a(null);
        this.c.b();
    }
}
