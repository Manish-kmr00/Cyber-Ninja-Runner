package com.yandex.mobile.ads.impl;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.util.Util;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pj1 f8876a;
    private final ge2 b;

    public f80(pj1 positionProviderHolder, ge2 videoDurationHolder) {
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        this.f8876a = positionProviderHolder;
        this.b = videoDurationHolder;
    }

    public final void a(AdPlaybackState adPlaybackState, int i) {
        Intrinsics.checkNotNullParameter(adPlaybackState, "adPlaybackState");
        long jUsToMs = Util.usToMs(adPlaybackState.getAdGroup(i).timeUs);
        if (jUsToMs == Long.MIN_VALUE) {
            jUsToMs = this.b.a();
        }
        this.f8876a.a(new h80(jUsToMs));
    }

    public final void a() {
        this.f8876a.a((h80) null);
    }
}
