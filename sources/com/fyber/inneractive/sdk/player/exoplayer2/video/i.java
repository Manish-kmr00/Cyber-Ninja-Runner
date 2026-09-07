package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f2201a;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher b;

    public i(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.b = eventDispatcher;
        this.f2201a = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.listener.onVideoEnabled(this.f2201a);
    }
}
