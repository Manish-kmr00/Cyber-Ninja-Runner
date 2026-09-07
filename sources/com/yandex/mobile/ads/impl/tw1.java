package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class tw1 implements ju {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xl1 f10335a;
    private final vi1 b;
    private final bf2 c;

    public tw1(ol1 progressProvider, vi1 playerVolumeController, bf2 eventsController) {
        Intrinsics.checkNotNullParameter(progressProvider, "progressProvider");
        Intrinsics.checkNotNullParameter(playerVolumeController, "playerVolumeController");
        Intrinsics.checkNotNullParameter(eventsController, "eventsController");
        this.f10335a = progressProvider;
        this.b = playerVolumeController;
        this.c = eventsController;
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final void a(df2 df2Var) {
        this.c.a(df2Var);
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final float getVolume() {
        Float fA = this.b.a();
        if (fA != null) {
            return fA.floatValue();
        }
        return 0.0f;
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final long getVideoPosition() {
        return this.f10335a.a().c();
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final long getVideoDuration() {
        return this.f10335a.a().b();
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final void prepareVideo() {
        this.c.onVideoPrepared();
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final void pauseVideo() {
        this.c.onVideoPaused();
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final void resumeVideo() {
        this.c.onVideoResumed();
    }
}
