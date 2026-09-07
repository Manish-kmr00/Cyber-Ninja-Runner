package com.yandex.mobile.ads.impl;

import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s60 implements Player.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ol f10179a;
    private final x60 b;
    private final bi1 c;
    private final mi1 d;
    private final gi1 e;
    private final c52 f;
    private final ph1 g;

    public s60(ol bindingControllerHolder, x60 exoPlayerProvider, bi1 playbackStateChangedListener, mi1 playerStateChangedListener, gi1 playerErrorListener, c52 timelineChangedListener, ph1 playbackChangesHandler) {
        Intrinsics.checkNotNullParameter(bindingControllerHolder, "bindingControllerHolder");
        Intrinsics.checkNotNullParameter(exoPlayerProvider, "exoPlayerProvider");
        Intrinsics.checkNotNullParameter(playbackStateChangedListener, "playbackStateChangedListener");
        Intrinsics.checkNotNullParameter(playerStateChangedListener, "playerStateChangedListener");
        Intrinsics.checkNotNullParameter(playerErrorListener, "playerErrorListener");
        Intrinsics.checkNotNullParameter(timelineChangedListener, "timelineChangedListener");
        Intrinsics.checkNotNullParameter(playbackChangesHandler, "playbackChangesHandler");
        this.f10179a = bindingControllerHolder;
        this.b = exoPlayerProvider;
        this.c = playbackStateChangedListener;
        this.d = playerStateChangedListener;
        this.e = playerErrorListener;
        this.f = timelineChangedListener;
        this.g = playbackChangesHandler;
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlayerError(PlaybackException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.e.a(error);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPositionDiscontinuity(Player.PositionInfo oldPosition, Player.PositionInfo newPosition, int i) {
        Intrinsics.checkNotNullParameter(oldPosition, "oldPosition");
        Intrinsics.checkNotNullParameter(newPosition, "newPosition");
        this.g.a();
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onTimelineChanged(Timeline timeline, int i) {
        Intrinsics.checkNotNullParameter(timeline, "timeline");
        this.f.a(timeline);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        Player playerA = this.b.a();
        if (!this.f10179a.b() || playerA == null) {
            return;
        }
        this.c.a(i, playerA);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlayWhenReadyChanged(boolean z, int i) {
        Player playerA = this.b.a();
        if (!this.f10179a.b() || playerA == null) {
            return;
        }
        this.d.a(z, playerA.getPlaybackState());
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onRenderedFirstFrame() {
        Player playerA = this.b.a();
        if (playerA != null) {
            onPlaybackStateChanged(playerA.getPlaybackState());
        }
    }
}
