package com.yandex.mobile.ads.impl;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Player;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o5 f8512a;
    private final mi1 b;
    private final es0 c;

    public bi1(o5 adPlaybackStateController, pj1 positionProviderHolder, ge2 videoDurationHolder, mi1 playerStateChangedListener, es0 loadingAdGroupIndexProvider) {
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(playerStateChangedListener, "playerStateChangedListener");
        Intrinsics.checkNotNullParameter(loadingAdGroupIndexProvider, "loadingAdGroupIndexProvider");
        this.f8512a = adPlaybackStateController;
        this.b = playerStateChangedListener;
        this.c = loadingAdGroupIndexProvider;
    }

    public final void a(int i, Player player) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (i == 2 && !player.isPlayingAd()) {
            AdPlaybackState adPlaybackStateA = this.f8512a.a();
            int iA = this.c.a(adPlaybackStateA);
            if (iA == -1) {
                return;
            }
            AdPlaybackState.AdGroup adGroup = adPlaybackStateA.getAdGroup(iA);
            Intrinsics.checkNotNullExpressionValue(adGroup, "getAdGroup(...)");
            int i2 = adGroup.count;
            if (i2 != -1 && i2 != 0 && adGroup.states[0] != 0) {
                return;
            }
        }
        this.b.a(player.getPlayWhenReady(), i);
    }
}
