package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class nc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eg2 f9722a;
    private boolean b;

    public nc2(oc2<?> videoAdPlayer, eg2 videoTracker) {
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        this.f9722a = videoTracker;
        this.b = videoAdPlayer.getVolume() == 0.0f;
    }

    public final void a(float f) {
        if (f == 0.0f) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.f9722a.l();
            return;
        }
        if (this.b) {
            this.b = false;
            this.f9722a.a();
        }
    }
}
