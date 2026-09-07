package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;

/* JADX INFO: loaded from: classes9.dex */
public final class D implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f2146a;
    public final h b;
    public final C c;
    public volatile com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e d;
    public volatile boolean e;
    public volatile long f;

    public D(h hVar, Uri uri, C c) {
        this.b = hVar;
        this.f2146a = new k(uri, 0L, 0L, -1L, null, 1);
        this.c = c;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final boolean a() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void b() {
        this.e = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void load() {
        j jVar = new j(this.b, this.f2146a);
        try {
            jVar.f2162a.a(jVar.b);
            jVar.d = true;
            this.d = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.g) this.c).a(this.b.a(), jVar);
        } finally {
            this.f = jVar.f;
            com.fyber.inneractive.sdk.player.exoplayer2.util.z.a(jVar);
        }
    }
}
