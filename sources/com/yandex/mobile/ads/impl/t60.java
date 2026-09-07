package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class t60 implements Player.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pl f10272a;
    private final y60 b;
    private final ci1 c;
    private final ni1 d;
    private final hi1 e;
    private final d52 f;
    private final qh1 g;

    public t60(pl bindingControllerHolder, y60 exoPlayerProvider, ci1 playbackStateChangedListener, ni1 playerStateChangedListener, hi1 playerErrorListener, d52 timelineChangedListener, qh1 playbackChangesHandler) {
        Intrinsics.checkNotNullParameter(bindingControllerHolder, "bindingControllerHolder");
        Intrinsics.checkNotNullParameter(exoPlayerProvider, "exoPlayerProvider");
        Intrinsics.checkNotNullParameter(playbackStateChangedListener, "playbackStateChangedListener");
        Intrinsics.checkNotNullParameter(playerStateChangedListener, "playerStateChangedListener");
        Intrinsics.checkNotNullParameter(playerErrorListener, "playerErrorListener");
        Intrinsics.checkNotNullParameter(timelineChangedListener, "timelineChangedListener");
        Intrinsics.checkNotNullParameter(playbackChangesHandler, "playbackChangesHandler");
        this.f10272a = bindingControllerHolder;
        this.b = exoPlayerProvider;
        this.c = playbackStateChangedListener;
        this.d = playerStateChangedListener;
        this.e = playerErrorListener;
        this.f = timelineChangedListener;
        this.g = playbackChangesHandler;
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayerError(PlaybackException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.e.a(error);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPositionDiscontinuity(Player.PositionInfo oldPosition, Player.PositionInfo newPosition, int i) {
        Intrinsics.checkNotNullParameter(oldPosition, "oldPosition");
        Intrinsics.checkNotNullParameter(newPosition, "newPosition");
        this.g.a();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onTimelineChanged(Timeline timeline, int i) {
        Intrinsics.checkNotNullParameter(timeline, "timeline");
        this.f.a(timeline);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        Player playerA = this.b.a();
        if (!this.f10272a.b() || playerA == null) {
            return;
        }
        this.c.a(i, playerA);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayWhenReadyChanged(boolean z, int i) {
        Player playerA = this.b.a();
        if (!this.f10272a.b() || playerA == null) {
            return;
        }
        this.d.a(z, playerA.getPlaybackState());
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onRenderedFirstFrame() {
        Player playerA = this.b.a();
        if (playerA != null) {
            onPlaybackStateChanged(playerA.getPlaybackState());
        }
    }
}
