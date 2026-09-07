package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ci1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p5 f8613a;
    private final ni1 b;
    private final fs0 c;

    public ci1(p5 adPlaybackStateController, qj1 positionProviderHolder, he2 videoDurationHolder, ni1 playerStateChangedListener, fs0 loadingAdGroupIndexProvider) {
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(playerStateChangedListener, "playerStateChangedListener");
        Intrinsics.checkNotNullParameter(loadingAdGroupIndexProvider, "loadingAdGroupIndexProvider");
        this.f8613a = adPlaybackStateController;
        this.b = playerStateChangedListener;
        this.c = loadingAdGroupIndexProvider;
    }

    public final void a(int i, Player player) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (i == 2 && !player.isPlayingAd()) {
            AdPlaybackState adPlaybackStateA = this.f8613a.a();
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
