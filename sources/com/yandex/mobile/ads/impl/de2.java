package com.yandex.mobile.ads.impl;

import androidx.media3.common.AdPlaybackState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class de2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o5 f8687a;
    private final cf2 b;
    private final be2 c;
    private boolean d;

    public de2(o5 adPlaybackStateController, ge2 videoDurationHolder, pj1 positionProviderHolder, cf2 videoPlayerEventsController, be2 videoCompleteNotifyPolicy) {
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(videoPlayerEventsController, "videoPlayerEventsController");
        Intrinsics.checkNotNullParameter(videoCompleteNotifyPolicy, "videoCompleteNotifyPolicy");
        this.f8687a = adPlaybackStateController;
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
        AdPlaybackState adPlaybackStateA = this.f8687a.a();
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
                this.f8687a.a(adPlaybackStateA);
            }
        }
        this.b.onVideoCompleted();
    }
}
