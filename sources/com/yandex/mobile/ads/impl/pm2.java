package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class pm2 implements com.yandex.mobile.ads.nativeads.video.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vt f9941a;

    public pm2(vt nativeAdVideoController) {
        Intrinsics.checkNotNullParameter(nativeAdVideoController, "nativeAdVideoController");
        this.f9941a = nativeAdVideoController;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof pm2) && Intrinsics.areEqual(this.f9941a, ((pm2) obj).f9941a);
    }

    public final int hashCode() {
        return this.f9941a.hashCode();
    }

    public final String toString() {
        return "YandexNativeAdVideoControllerAdapter(nativeAdVideoController=" + this.f9941a + ")";
    }

    @Override // com.yandex.mobile.ads.nativeads.video.b, com.yandex.mobile.ads.nativeads.video.NativeAdVideoController
    public final void pauseAd() {
        this.f9941a.a();
    }

    @Override // com.yandex.mobile.ads.nativeads.video.b, com.yandex.mobile.ads.nativeads.video.NativeAdVideoController
    public final void resumeAd() {
        this.f9941a.b();
    }
}
