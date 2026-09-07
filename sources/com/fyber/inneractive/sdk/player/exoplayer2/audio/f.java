package com.fyber.inneractive.sdk.player.exoplayer2.audio;

/* JADX INFO: loaded from: classes6.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.player.exoplayer2.o f1978a;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher b;

    public f(AudioRendererEventListener.EventDispatcher eventDispatcher, com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        this.b = eventDispatcher;
        this.f1978a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.listener.onAudioInputFormatChanged(this.f1978a);
    }
}
