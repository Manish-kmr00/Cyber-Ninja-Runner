package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class oi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qi1 f9822a;
    private final ge2 b;
    private final x60 c;
    private final ui1 d;
    private final ei1 e;

    public oi1(qi1 stateHolder, ge2 durationHolder, x60 playerProvider, ui1 volumeController, ei1 playerPlaybackController) {
        Intrinsics.checkNotNullParameter(stateHolder, "stateHolder");
        Intrinsics.checkNotNullParameter(durationHolder, "durationHolder");
        Intrinsics.checkNotNullParameter(playerProvider, "playerProvider");
        Intrinsics.checkNotNullParameter(volumeController, "volumeController");
        Intrinsics.checkNotNullParameter(playerPlaybackController, "playerPlaybackController");
        this.f9822a = stateHolder;
        this.b = durationHolder;
        this.c = playerProvider;
        this.d = volumeController;
        this.e = playerPlaybackController;
    }

    public final qi1 d() {
        return this.f9822a;
    }

    public final ge2 a() {
        return this.b;
    }

    public final x60 c() {
        return this.c;
    }

    public final ui1 e() {
        return this.d;
    }

    public final ei1 b() {
        return this.e;
    }
}
