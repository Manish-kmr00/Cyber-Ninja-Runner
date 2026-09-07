package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rb2<do0> f9375a;
    private final ao0 b;
    private final pj0 c;
    private final id2 d;
    private final eg2 e;

    public k4(rb2 videoAdInfo, ao0 playbackController, pj0 imageProvider, id2 statusController, fg2 videoTracker) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(playbackController, "playbackController");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(statusController, "statusController");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        this.f9375a = videoAdInfo;
        this.b = playbackController;
        this.c = imageProvider;
        this.d = statusController;
        this.e = videoTracker;
    }

    public final rb2<do0> c() {
        return this.f9375a;
    }

    public final ao0 a() {
        return this.b;
    }

    public final id2 b() {
        return this.d;
    }

    public final eg2 d() {
        return this.e;
    }
}
