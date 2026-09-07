package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class pi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ri1 f9931a;
    private final he2 b;
    private final y60 c;
    private final vi1 d;
    private final fi1 e;

    public pi1(ri1 stateHolder, he2 durationHolder, y60 playerProvider, vi1 volumeController, fi1 playerPlaybackController) {
        Intrinsics.checkNotNullParameter(stateHolder, "stateHolder");
        Intrinsics.checkNotNullParameter(durationHolder, "durationHolder");
        Intrinsics.checkNotNullParameter(playerProvider, "playerProvider");
        Intrinsics.checkNotNullParameter(volumeController, "volumeController");
        Intrinsics.checkNotNullParameter(playerPlaybackController, "playerPlaybackController");
        this.f9931a = stateHolder;
        this.b = durationHolder;
        this.c = playerProvider;
        this.d = volumeController;
        this.e = playerPlaybackController;
    }

    public final ri1 d() {
        return this.f9931a;
    }

    public final he2 a() {
        return this.b;
    }

    public final y60 c() {
        return this.c;
    }

    public final vi1 e() {
        return this.d;
    }

    public final fi1 b() {
        return this.e;
    }
}
