package com.yandex.mobile.ads.impl;

import androidx.media3.common.AdPlaybackState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ol f9593a;
    private final y5 b;
    private final q9 c;
    private final o5 d;
    private final x60 e;
    private final ui1 f;
    private final qi1 g;
    private final s5 h;

    public m3(ol bindingControllerHolder, o9 adStateDataController, oi1 playerStateController, y5 adPlayerEventsController, q9 adStateHolder, o5 adPlaybackStateController, x60 exoPlayerProvider, ui1 playerVolumeController, qi1 playerStateHolder, s5 adPlaybackStateSkipValidator) {
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
        this.f9593a = bindingControllerHolder;
        this.b = adPlayerEventsController;
        this.c = adStateHolder;
        this.d = adPlaybackStateController;
        this.e = exoPlayerProvider;
        this.f = playerVolumeController;
        this.g = playerStateHolder;
        this.h = adPlaybackStateSkipValidator;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0098  */
    public final void a(u4 adInfo, do0 videoAd) {
        boolean z;
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        if (!this.f9593a.b()) {
            op0.f(new Object[0]);
            return;
        }
        if (sm0.b == this.c.a(videoAd)) {
            AdPlaybackState adPlaybackStateA = this.d.a();
            if (adPlaybackStateA.isAdInErrorState(adInfo.a(), adInfo.b())) {
                op0.b(new Object[0]);
                return;
            }
            this.c.a(videoAd, sm0.f);
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
            this.c.a(videoAd, sm0.h);
            AdPlaybackState adPlaybackStateWithAdResumePositionUs = adPlaybackState.withPlayedAd(iA, iB).withAdResumePositionUs(0L);
            Intrinsics.checkNotNullExpressionValue(adPlaybackStateWithAdResumePositionUs, "withAdResumePositionUs(...)");
            this.d.a(adPlaybackStateWithAdResumePositionUs);
            if (!this.g.c()) {
                this.c.a((xi1) null);
            }
        }
        this.f.b();
        this.b.g(videoAd);
    }
}
