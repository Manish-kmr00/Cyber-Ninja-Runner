package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class zl2 implements gt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InstreamAdPlayer f10826a;
    private final dm2 b;

    public zl2(InstreamAdPlayer instreamAdPlayer, dm2 videoAdAdapterCache) {
        Intrinsics.checkNotNullParameter(instreamAdPlayer, "instreamAdPlayer");
        Intrinsics.checkNotNullParameter(videoAdAdapterCache, "videoAdAdapterCache");
        this.f10826a = instreamAdPlayer;
        this.b = videoAdAdapterCache;
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final long a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return this.b.a(videoAd).getDuration();
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final long b(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return this.f10826a.getAdPosition(this.b.a(videoAd));
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void c(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f10826a.playAd(this.b.a(videoAd));
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void d(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f10826a.prepareAd(this.b.a(videoAd));
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void e(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f10826a.releaseAd(this.b.a(videoAd));
        this.b.b(videoAd);
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void f(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f10826a.pauseAd(this.b.a(videoAd));
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void g(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f10826a.resumeAd(this.b.a(videoAd));
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void h(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f10826a.skipAd(this.b.a(videoAd));
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void i(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f10826a.stopAd(this.b.a(videoAd));
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final boolean j(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return this.f10826a.isPlayingAd(this.b.a(videoAd));
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final float k(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return this.f10826a.getVolume(this.b.a(videoAd));
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void a(hm0 hm0Var) {
        this.f10826a.setInstreamAdPlayerListener(hm0Var != null ? new bm2(hm0Var, this.b, new am2()) : null);
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void a(do0 videoAd, float f) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f10826a.setVolume(this.b.a(videoAd), f);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zl2) && Intrinsics.areEqual(((zl2) obj).f10826a, this.f10826a);
    }

    public final int hashCode() {
        return this.f10826a.hashCode();
    }
}
