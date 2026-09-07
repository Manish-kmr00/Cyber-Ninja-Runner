package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.controller.B;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f2124a;
    public final /* synthetic */ long b;
    public final /* synthetic */ f c;

    public e(f fVar, int i, com.fyber.inneractive.sdk.player.exoplayer2.o oVar, int i2, Object obj, long j) {
        this.c = fVar;
        this.f2124a = obj;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B b = this.c.b;
        com.fyber.inneractive.sdk.player.exoplayer2.b.a(this.b);
        IAlog.a("%s AdaptiveMediaSourceEventListener onDownstreamFormatChanged called.", b.a());
    }
}
