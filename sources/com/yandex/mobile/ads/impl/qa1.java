package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qa1 implements oc2<gb1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oa1 f10003a;

    public qa1(oa1 videoPlayer) {
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        this.f10003a = videoPlayer;
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final void a(rb2<gb1> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f10003a.a(videoAdInfo.d());
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final long b() {
        return this.f10003a.b();
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final long getAdPosition() {
        return this.f10003a.getAdPosition();
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final float getVolume() {
        return this.f10003a.getVolume();
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final boolean isPlayingAd() {
        return this.f10003a.isPlayingAd();
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final void a(gc2 gc2Var) {
        this.f10003a.a(gc2Var);
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final void c() {
        this.f10003a.c();
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final void pauseAd() {
        this.f10003a.pauseAd();
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final void resumeAd() {
        this.f10003a.resumeAd();
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final void a() {
        this.f10003a.a();
    }
}
