package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.InstreamAdBreak;
import com.yandex.mobile.ads.instream.InstreamAdBreakEventListener;
import com.yandex.mobile.ads.instream.inroll.Inroll;
import com.yandex.mobile.ads.instream.pauseroll.Pauseroll;
import com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayer;
import com.yandex.mobile.ads.instream.player.ad.InstreamAdView;
import com.yandex.mobile.ads.video.playback.VideoAdPlaybackListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class tn0 implements Inroll, Pauseroll {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mt0 f10319a;
    private final dm2 b;

    @Override // com.yandex.mobile.ads.instream.inroll.Inroll, com.yandex.mobile.ads.instream.pauseroll.Pauseroll
    public final void play(InstreamAdView instreamAdView) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        this.f10319a.a(instreamAdView);
    }

    @Override // com.yandex.mobile.ads.instream.inroll.Inroll, com.yandex.mobile.ads.instream.pauseroll.Pauseroll
    public final void prepare(InstreamAdPlayer instreamAdPlayer) {
        Intrinsics.checkNotNullParameter(instreamAdPlayer, "instreamAdPlayer");
        this.f10319a.a(new zl2(instreamAdPlayer, this.b));
    }

    public /* synthetic */ tn0(mt0 mt0Var) {
        this(mt0Var, new dm2());
    }

    public tn0(mt0 manualAdBreakPlaybackController, dm2 videoAdAdapterCache) {
        Intrinsics.checkNotNullParameter(manualAdBreakPlaybackController, "manualAdBreakPlaybackController");
        Intrinsics.checkNotNullParameter(videoAdAdapterCache, "videoAdAdapterCache");
        manualAdBreakPlaybackController.getClass();
        this.f10319a = manualAdBreakPlaybackController;
        this.b = videoAdAdapterCache;
    }

    @Override // com.yandex.mobile.ads.instream.inroll.Inroll, com.yandex.mobile.ads.instream.pauseroll.Pauseroll
    public final InstreamAdBreak getInstreamAdBreak() {
        return new tl2(this.f10319a.a());
    }

    @Override // com.yandex.mobile.ads.instream.inroll.Inroll, com.yandex.mobile.ads.instream.pauseroll.Pauseroll
    public final void setListener(InstreamAdBreakEventListener instreamAdBreakEventListener) {
        this.f10319a.a(instreamAdBreakEventListener != null ? new ul2(instreamAdBreakEventListener) : null);
    }

    @Override // com.yandex.mobile.ads.instream.inroll.Inroll, com.yandex.mobile.ads.instream.pauseroll.Pauseroll
    public final void setVideoAdPlaybackListener(VideoAdPlaybackListener videoAdPlaybackListener) {
        this.f10319a.a(videoAdPlaybackListener != null ? new in2(videoAdPlaybackListener, this.b) : null);
    }

    @Override // com.yandex.mobile.ads.instream.inroll.Inroll, com.yandex.mobile.ads.instream.pauseroll.Pauseroll
    public final void pause() {
        this.f10319a.c();
    }

    @Override // com.yandex.mobile.ads.instream.inroll.Inroll, com.yandex.mobile.ads.instream.pauseroll.Pauseroll
    public final void resume() {
        this.f10319a.d();
    }

    @Override // com.yandex.mobile.ads.instream.inroll.Inroll, com.yandex.mobile.ads.instream.pauseroll.Pauseroll
    public final void invalidate() {
        this.f10319a.b();
    }
}
