package com.yandex.mobile.ads.impl;

import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class vf2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qi1 f10477a;
    private final de2 b;

    public vf2(qi1 playerStateHolder, de2 videoCompletedNotifier) {
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        Intrinsics.checkNotNullParameter(videoCompletedNotifier, "videoCompletedNotifier");
        this.f10477a = playerStateHolder;
        this.b = videoCompletedNotifier;
    }

    public final void a(Player player) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (this.f10477a.c() || player.isPlayingAd()) {
            return;
        }
        this.b.c();
        boolean zB = this.b.b();
        Timeline timelineB = this.f10477a.b();
        if (zB || timelineB.isEmpty()) {
            return;
        }
        timelineB.getPeriod(0, this.f10477a.a());
    }
}
