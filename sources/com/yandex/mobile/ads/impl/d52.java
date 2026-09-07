package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Util;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p5 f8665a;
    private final gb b;
    private final qh1 c;
    private final ri1 d;
    private final he2 e;
    private final g82 f;

    public d52(p5 adPlaybackStateController, pi1 playerStateController, gb adsPlaybackInitializer, qh1 playbackChangesHandler, ri1 playerStateHolder, he2 videoDurationHolder, g82 updatedDurationAdPlaybackProvider) {
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(adsPlaybackInitializer, "adsPlaybackInitializer");
        Intrinsics.checkNotNullParameter(playbackChangesHandler, "playbackChangesHandler");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(updatedDurationAdPlaybackProvider, "updatedDurationAdPlaybackProvider");
        this.f8665a = adPlaybackStateController;
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
            AdPlaybackState adPlaybackState = this.f8665a.a();
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
            this.f8665a.a(adPlaybackStateWithContentDurationUs);
        }
        if (!this.b.a()) {
            this.b.b();
        }
        this.c.a();
    }
}
