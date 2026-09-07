package com.yandex.mobile.ads.impl;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.util.Util;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o5 f8663a;
    private final b3 b;

    public d4(ge2 videoDurationHolder, o5 adPlaybackStateController, b3 adBreakTimingProvider) {
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(adBreakTimingProvider, "adBreakTimingProvider");
        this.f8663a = adPlaybackStateController;
        this.b = adBreakTimingProvider;
    }

    public final int a(et adBreakPosition) {
        Intrinsics.checkNotNullParameter(adBreakPosition, "adBreakPosition");
        long jA = this.b.a(adBreakPosition);
        AdPlaybackState adPlaybackStateA = this.f8663a.a();
        if (jA == Long.MIN_VALUE) {
            int i = adPlaybackStateA.adGroupCount;
            if (i <= 0 || adPlaybackStateA.getAdGroup(i - 1).timeUs != Long.MIN_VALUE) {
                return -1;
            }
            return adPlaybackStateA.adGroupCount - 1;
        }
        long jMsToUs = Util.msToUs(jA);
        int i2 = adPlaybackStateA.adGroupCount;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = adPlaybackStateA.getAdGroup(i3).timeUs;
            if (j != Long.MIN_VALUE && Math.abs(j - jMsToUs) <= 1000) {
                return i3;
            }
        }
        return -1;
    }
}
