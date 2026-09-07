package com.yandex.mobile.ads.impl;

import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ki1 implements nj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Player f9423a;
    private final qi1 b;

    public ki1(Player player, qi1 playerStateHolder) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        this.f9423a = player;
        this.b = playerStateHolder;
    }

    @Override // com.yandex.mobile.ads.impl.nj1
    public final long a() {
        Timeline timelineB = this.b.b();
        return this.f9423a.getContentPosition() - (!timelineB.isEmpty() ? timelineB.getPeriod(0, this.b.a()).getPositionInWindowMs() : 0L);
    }
}
