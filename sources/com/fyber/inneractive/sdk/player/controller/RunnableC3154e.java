package com.fyber.inneractive.sdk.player.controller;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.controller.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class RunnableC3154e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3155f f1955a;

    public RunnableC3154e(C3155f c3155f) {
        this.f1955a = c3155f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.f1955a.s;
        if (gVar != null) {
            gVar.a(gVar.a(), -9223372036854775807L);
            this.f1955a.s.d.f.sendEmptyMessage(5);
            com.fyber.inneractive.sdk.player.exoplayer2.g gVar2 = this.f1955a.s;
            gVar2.d.d();
            gVar2.c.removeCallbacksAndMessages(null);
            this.f1955a.s = null;
        }
    }
}
