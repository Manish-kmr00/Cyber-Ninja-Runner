package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ee2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p5 f8792a;
    private final bf2 b;
    private final ce2 c;
    private boolean d;

    public ee2(p5 adPlaybackStateController, he2 videoDurationHolder, qj1 positionProviderHolder, bf2 videoPlayerEventsController, ce2 videoCompleteNotifyPolicy) {
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(videoPlayerEventsController, "videoPlayerEventsController");
        Intrinsics.checkNotNullParameter(videoCompleteNotifyPolicy, "videoCompleteNotifyPolicy");
        this.f8792a = adPlaybackStateController;
        this.b = videoPlayerEventsController;
        this.c = videoCompleteNotifyPolicy;
    }

    public final boolean b() {
        return this.d;
    }

    public final void c() {
        if (this.c.a()) {
            a();
        }
    }

    public final void a() {
        if (this.d) {
            return;
        }
        this.d = true;
        AdPlaybackState adPlaybackStateA = this.f8792a.a();
        int i = adPlaybackStateA.adGroupCount;
        for (int i2 = 0; i2 < i; i2++) {
            AdPlaybackState.AdGroup adGroup = adPlaybackStateA.getAdGroup(i2);
            Intrinsics.checkNotNullExpressionValue(adGroup, "getAdGroup(...)");
            if (adGroup.timeUs != Long.MIN_VALUE) {
                if (adGroup.count < 0) {
                    adPlaybackStateA = adPlaybackStateA.withAdCount(i2, 1);
                    Intrinsics.checkNotNullExpressionValue(adPlaybackStateA, "withAdCount(...)");
                }
                adPlaybackStateA = adPlaybackStateA.withSkippedAdGroup(i2);
                Intrinsics.checkNotNullExpressionValue(adPlaybackStateA, "withSkippedAdGroup(...)");
                this.f8792a.a(adPlaybackStateA);
            }
        }
        this.b.onVideoCompleted();
    }
}
