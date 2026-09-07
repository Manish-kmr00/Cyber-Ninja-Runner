package com.yandex.mobile.ads.impl;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o5 f8570a;
    private final fb b;
    private final ph1 c;
    private final qi1 d;
    private final ge2 e;
    private final f82 f;

    public c52(o5 adPlaybackStateController, oi1 playerStateController, fb adsPlaybackInitializer, ph1 playbackChangesHandler, qi1 playerStateHolder, ge2 videoDurationHolder, f82 updatedDurationAdPlaybackProvider) {
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(adsPlaybackInitializer, "adsPlaybackInitializer");
        Intrinsics.checkNotNullParameter(playbackChangesHandler, "playbackChangesHandler");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(updatedDurationAdPlaybackProvider, "updatedDurationAdPlaybackProvider");
        this.f8570a = adPlaybackStateController;
        this.b = adsPlaybackInitializer;
        this.c = playbackChangesHandler;
        this.d = playerStateHolder;
        this.e = videoDurationHolder;
        this.f = updatedDurationAdPlaybackProvider;
    }

    public final void a(Timeline timeline) {
        Intrinsics.checkNotNullParameter(timeline, "timeline");
        if (timeline.isEmpty()) {
            return;
        }
        if (timeline.getPeriodCount() != 1) {
            op0.b(new Object[0]);
        }
        this.d.a(timeline);
        Timeline.Period period = timeline.getPeriod(0, this.d.a());
        Intrinsics.checkNotNullExpressionValue(period, "getPeriod(...)");
        long j = period.durationUs;
        this.e.a(Util.usToMs(j));
        if (j != -9223372036854775807L) {
            AdPlaybackState adPlaybackState = this.f8570a.a();
            this.f.getClass();
            Intrinsics.checkNotNullParameter(adPlaybackState, "adPlaybackState");
            AdPlaybackState adPlaybackStateWithContentDurationUs = adPlaybackState.withContentDurationUs(j);
            Intrinsics.checkNotNullExpressionValue(adPlaybackStateWithContentDurationUs, "withContentDurationUs(...)");
            int i = adPlaybackStateWithContentDurationUs.adGroupCount;
            for (int i2 = 0; i2 < i; i2++) {
                if (adPlaybackStateWithContentDurationUs.getAdGroup(i2).timeUs > j) {
                    adPlaybackStateWithContentDurationUs = adPlaybackStateWithContentDurationUs.withSkippedAdGroup(i2);
                    Intrinsics.checkNotNullExpressionValue(adPlaybackStateWithContentDurationUs, "withSkippedAdGroup(...)");
                }
            }
            this.f8570a.a(adPlaybackStateWithContentDurationUs);
        }
        if (!this.b.a()) {
            this.b.b();
        }
        this.c.a();
    }
}
