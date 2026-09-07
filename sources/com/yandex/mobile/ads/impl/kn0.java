package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kn0 implements bf1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sn0 f9437a;
    private final do0 b;

    public kn0(sn0 instreamInteractionTracker, do0 videoAd, xz customAdClickHandler) {
        Intrinsics.checkNotNullParameter(instreamInteractionTracker, "instreamInteractionTracker");
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(customAdClickHandler, "customAdClickHandler");
        this.f9437a = instreamInteractionTracker;
        this.b = videoAd;
    }

    @Override // com.yandex.mobile.ads.impl.bf1
    public final void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        new jn0(this.f9437a);
        throw null;
    }
}
