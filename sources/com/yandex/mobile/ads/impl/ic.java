package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s70 f9199a;

    public ic(eb2 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f9199a = new s70(videoAd.l());
    }

    public final boolean a() {
        return this.f9199a.a();
    }
}
