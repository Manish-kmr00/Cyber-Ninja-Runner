package com.fyber.inneractive.sdk.player.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.fyber.inneractive.sdk.player.controller.B;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.InterfaceC3164b;

/* JADX INFO: loaded from: classes14.dex */
public final class q implements u, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f2135a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.k c;
    public final int d;
    public final Handler e;
    public final B f;
    public final com.fyber.inneractive.sdk.player.exoplayer2.v g = new com.fyber.inneractive.sdk.player.exoplayer2.v();
    public t h;
    public boolean i;

    public q(Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.c cVar, int i, Handler handler, B b) {
        this.f2135a = uri;
        this.b = gVar;
        this.c = cVar;
        this.d = i;
        this.e = handler;
        this.f = b;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final void a() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final void b() {
        this.h = null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final void a(t tVar) {
        this.h = tVar;
        tVar.a(new x(-9223372036854775807L, -9223372036854775807L, 0L, 0L, false, false), null);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final s a(int i, InterfaceC3164b interfaceC3164b, long j) {
        if (i == 0) {
            return new p(this.f2135a, this.b.a(), this.c.a(), this.d, this.e, this.f, this, interfaceC3164b);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final void a(s sVar) {
        p pVar = (p) sVar;
        pVar.i.a(new k(pVar, pVar.j));
        pVar.n.removeCallbacksAndMessages(null);
        pVar.G = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.t
    public final void a(x xVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.g gVar) {
        boolean z = xVar.a(0, this.g, false).d != -9223372036854775807L;
        if (!this.i || z) {
            this.i = z;
            this.h.a(xVar, null);
        }
    }
}
