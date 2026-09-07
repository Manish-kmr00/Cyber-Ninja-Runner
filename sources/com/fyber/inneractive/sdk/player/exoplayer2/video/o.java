package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;

/* JADX INFO: loaded from: classes13.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f2207a;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher b;

    public o(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.b = eventDispatcher;
        this.f2207a = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2207a.ensureUpdated();
        this.b.listener.onVideoDisabled(this.f2207a);
    }
}
