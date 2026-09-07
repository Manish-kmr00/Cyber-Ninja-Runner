package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class sa1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oa1 f10190a;

    public sa1(oa1 videoAdPlayer) {
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        this.f10190a = videoAdPlayer;
    }

    public final void a(Double d) {
        this.f10190a.setVolume((float) (d != null ? d.doubleValue() : 0.0d));
    }
}
