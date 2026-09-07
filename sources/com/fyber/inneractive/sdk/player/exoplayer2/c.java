package com.fyber.inneractive.sdk.player.exoplayer2;

import io.bidmachine.media3.exoplayer.dash.DashMediaSource;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.l f1990a = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.l();
    public final long b = ((long) 15000) * 1000;
    public final long c = ((long) 30000) * 1000;
    public final long d = 2500000;
    public final long e = DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US;
    public int f;
    public boolean g;

    public final void a(boolean z) {
        this.f = 0;
        this.g = false;
        if (z) {
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l lVar = this.f1990a;
            synchronized (lVar) {
                lVar.a(0);
            }
        }
    }
}
