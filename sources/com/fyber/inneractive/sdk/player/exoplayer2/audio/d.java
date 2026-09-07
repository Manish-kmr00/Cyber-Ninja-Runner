package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f1976a;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher b;

    public d(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.b = eventDispatcher;
        this.f1976a = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.listener.onAudioEnabled(this.f1976a);
    }
}
