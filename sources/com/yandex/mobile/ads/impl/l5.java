package com.yandex.mobile.ads.impl;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Player;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f80 f9477a;
    private final de2 b;
    private final q9 c;
    private final o5 d;

    public l5(o9 adStateDataController, f80 fakePositionConfigurator, de2 videoCompletedNotifier, q9 adStateHolder, o5 adPlaybackStateController) {
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(fakePositionConfigurator, "fakePositionConfigurator");
        Intrinsics.checkNotNullParameter(videoCompletedNotifier, "videoCompletedNotifier");
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        this.f9477a = fakePositionConfigurator;
        this.b = videoCompletedNotifier;
        this.c = adStateHolder;
        this.d = adPlaybackStateController;
    }

    public final void a(Player player, boolean z) {
        Intrinsics.checkNotNullParameter(player, "player");
        boolean zB = this.b.b();
        int currentAdGroupIndex = player.getCurrentAdGroupIndex();
        if (currentAdGroupIndex == -1) {
            AdPlaybackState adPlaybackStateA = this.d.a();
            long contentPosition = player.getContentPosition();
            long contentDuration = player.getContentDuration();
            if (contentDuration == -9223372036854775807L || contentPosition == -9223372036854775807L) {
                currentAdGroupIndex = -1;
            } else {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                currentAdGroupIndex = adPlaybackStateA.getAdGroupIndexForPositionUs(timeUnit.toMicros(contentPosition), timeUnit.toMicros(contentDuration));
            }
        }
        boolean zB2 = this.c.b();
        if (zB || z || currentAdGroupIndex == -1 || zB2) {
            return;
        }
        AdPlaybackState adPlaybackStateA2 = this.d.a();
        if (adPlaybackStateA2.getAdGroup(currentAdGroupIndex).timeUs == Long.MIN_VALUE) {
            this.b.a();
        } else {
            this.f9477a.a(adPlaybackStateA2, currentAdGroupIndex);
        }
    }
}
