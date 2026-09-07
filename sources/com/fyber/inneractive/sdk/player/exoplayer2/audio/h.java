package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;

/* JADX INFO: loaded from: classes6.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f1980a;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher b;

    public h(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.b = eventDispatcher;
        this.f1980a = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1980a.ensureUpdated();
        this.b.listener.onAudioDisabled(this.f1980a);
    }
}
