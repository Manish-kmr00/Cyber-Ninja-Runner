package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class li1 implements oj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Player f9523a;
    private final ri1 b;

    public li1(Player player, ri1 playerStateHolder) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        this.f9523a = player;
        this.b = playerStateHolder;
    }

    @Override // com.yandex.mobile.ads.impl.oj1
    public final long a() {
        Timeline timelineB = this.b.b();
        return this.f9523a.getContentPosition() - (!timelineB.isEmpty() ? timelineB.getPeriod(0, this.b.a()).getPositionInWindowMs() : 0L);
    }
}
