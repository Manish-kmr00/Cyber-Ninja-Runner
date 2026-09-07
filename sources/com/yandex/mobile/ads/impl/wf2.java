package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class wf2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ri1 f10563a;
    private final ee2 b;

    public wf2(ri1 playerStateHolder, ee2 videoCompletedNotifier) {
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        Intrinsics.checkNotNullParameter(videoCompletedNotifier, "videoCompletedNotifier");
        this.f10563a = playerStateHolder;
        this.b = videoCompletedNotifier;
    }

    public final void a(Player player) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (this.f10563a.c() || player.isPlayingAd()) {
            return;
        }
        this.b.c();
        boolean zB = this.b.b();
        Timeline timelineB = this.f10563a.b();
        if (zB || timelineB.isEmpty()) {
            return;
        }
        timelineB.getPeriod(0, this.f10563a.a());
    }
}
