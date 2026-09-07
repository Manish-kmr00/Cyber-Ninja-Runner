package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pl f9693a;
    private final z5 b;
    private final r9 c;
    private final p5 d;
    private final y60 e;
    private final vi1 f;
    private final ri1 g;
    private final t5 h;

    public n3(pl bindingControllerHolder, p9 adStateDataController, pi1 playerStateController, z5 adPlayerEventsController, r9 adStateHolder, p5 adPlaybackStateController, y60 exoPlayerProvider, vi1 playerVolumeController, ri1 playerStateHolder, t5 adPlaybackStateSkipValidator) {
        Intrinsics.checkNotNullParameter(bindingControllerHolder, "bindingControllerHolder");
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(exoPlayerProvider, "exoPlayerProvider");
        Intrinsics.checkNotNullParameter(playerVolumeController, "playerVolumeController");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        Intrinsics.checkNotNullParameter(adPlaybackStateSkipValidator, "adPlaybackStateSkipValidator");
        this.f9693a = bindingControllerHolder;
        this.b = adPlayerEventsController;
        this.c = adStateHolder;
        this.d = adPlaybackStateController;
        this.e = exoPlayerProvider;
        this.f = playerVolumeController;
        this.g = playerStateHolder;
        this.h = adPlaybackStateSkipValidator;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0098  */
    public final void a(v4 adInfo, do0 videoAd) {
        boolean z;
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        if (!this.f9693a.b()) {
            op0.f(new Object[0]);
            return;
        }
        if (tm0.b == this.c.a(videoAd)) {
            AdPlaybackState adPlaybackStateA = this.d.a();
            if (adPlaybackStateA.isAdInErrorState(adInfo.a(), adInfo.b())) {
                op0.b(new Object[0]);
                return;
            }
            this.c.a(videoAd, tm0.f);
            AdPlaybackState adPlaybackStateWithSkippedAd = adPlaybackStateA.withSkippedAd(adInfo.a(), adInfo.b());
            Intrinsics.checkNotNullExpressionValue(adPlaybackStateWithSkippedAd, "withSkippedAd(...)");
            this.d.a(adPlaybackStateWithSkippedAd);
            return;
        }
        if (!this.e.b()) {
            op0.b(new Object[0]);
            return;
        }
        int iA = adInfo.a();
        int iB = adInfo.b();
        AdPlaybackState adPlaybackState = this.d.a();
        boolean zIsAdInErrorState = adPlaybackState.isAdInErrorState(iA, iB);
        this.h.getClass();
        Intrinsics.checkNotNullParameter(adPlaybackState, "adPlaybackState");
        if (iA < adPlaybackState.adGroupCount) {
            AdPlaybackState.AdGroup adGroup = adPlaybackState.getAdGroup(iA);
            Intrinsics.checkNotNullExpressionValue(adGroup, "getAdGroup(...)");
            int i = adGroup.count;
            if (i == -1 || iB >= i || adGroup.states[iB] != 2) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        if (zIsAdInErrorState || z) {
            op0.b(new Object[0]);
        } else {
            this.c.a(videoAd, tm0.h);
            AdPlaybackState adPlaybackStateWithAdResumePositionUs = adPlaybackState.withPlayedAd(iA, iB).withAdResumePositionUs(0L);
            Intrinsics.checkNotNullExpressionValue(adPlaybackStateWithAdResumePositionUs, "withAdResumePositionUs(...)");
            this.d.a(adPlaybackStateWithAdResumePositionUs);
            if (!this.g.c()) {
                this.c.a((yi1) null);
            }
        }
        this.f.b();
        this.b.g(videoAd);
    }
}
