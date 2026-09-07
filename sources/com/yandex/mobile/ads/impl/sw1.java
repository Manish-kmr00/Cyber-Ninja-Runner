package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class sw1 implements ju {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wl1 f10243a;
    private final ui1 b;
    private final cf2 c;

    public sw1(nl1 progressProvider, ui1 playerVolumeController, cf2 eventsController) {
        Intrinsics.checkNotNullParameter(progressProvider, "progressProvider");
        Intrinsics.checkNotNullParameter(playerVolumeController, "playerVolumeController");
        Intrinsics.checkNotNullParameter(eventsController, "eventsController");
        this.f10243a = progressProvider;
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
        return this.f10243a.a().c();
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final long getVideoDuration() {
        return this.f10243a.a().b();
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
