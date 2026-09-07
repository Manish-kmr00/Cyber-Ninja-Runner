package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import com.fyber.inneractive.sdk.player.exoplayer2.upstream.o;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.t;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f2152a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g c;
    public final d d;

    public f(l lVar, o oVar) {
        t tVar = new t();
        d dVar = new d(lVar);
        this.f2152a = lVar;
        this.b = oVar;
        this.c = tVar;
        this.d = dVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h a() {
        l lVar = this.f2152a;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVarA = this.b.a();
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVarA2 = this.c.a();
        d dVar = this.d;
        return new e(lVar, hVarA, hVarA2, dVar != null ? new c(dVar.f2150a) : null);
    }
}
