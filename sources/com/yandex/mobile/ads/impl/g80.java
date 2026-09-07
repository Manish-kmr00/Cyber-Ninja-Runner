package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Util;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qj1 f8977a;
    private final he2 b;

    public g80(qj1 positionProviderHolder, he2 videoDurationHolder) {
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        this.f8977a = positionProviderHolder;
        this.b = videoDurationHolder;
    }

    public final void a(AdPlaybackState adPlaybackState, int i) {
        Intrinsics.checkNotNullParameter(adPlaybackState, "adPlaybackState");
        long jUsToMs = Util.usToMs(adPlaybackState.getAdGroup(i).timeUs);
        if (jUsToMs == Long.MIN_VALUE) {
            jUsToMs = this.b.a();
        }
        this.f8977a.a(new i80(jUsToMs));
    }

    public final void a() {
        this.f8977a.a((i80) null);
    }
}
