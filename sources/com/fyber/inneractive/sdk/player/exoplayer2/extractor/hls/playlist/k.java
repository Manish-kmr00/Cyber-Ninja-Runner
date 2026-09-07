package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.B;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.D;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class k implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.b f2022a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.j f;
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.f i;
    public b j;
    public a k;
    public d l;
    public boolean m;
    public final int c = 3;
    public final ArrayList g = new ArrayList();
    public final B h = new B("HlsPlaylistTracker:MasterPlaylist");
    public final g b = new g();
    public final IdentityHashMap d = new IdentityHashMap();
    public final Handler e = new Handler();

    public k(Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.j jVar) {
        this.f2022a = bVar;
        this.i = fVar;
        this.f = jVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(z zVar, long j, long j2, boolean z) {
        D d = (D) zVar;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.i;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = d.f2146a;
        long j3 = d.f;
        if (fVar.b != null) {
            fVar.f2125a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.c(fVar, kVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3));
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(z zVar, long j, long j2) {
        b bVar;
        D d = (D) zVar;
        e eVar = d.d;
        boolean z = eVar instanceof d;
        if (z) {
            List listSingletonList = Collections.singletonList(new a(eVar.f2018a, new o("0", "application/x-mpegURL", null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null)));
            List listEmptyList = Collections.emptyList();
            bVar = new b(null, listSingletonList, listEmptyList, listEmptyList, null, null);
        } else {
            bVar = (b) eVar;
        }
        this.j = bVar;
        this.k = (a) bVar.b.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(bVar.b);
        arrayList.addAll(bVar.c);
        arrayList.addAll(bVar.d);
        int size = arrayList.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            a aVar = (a) arrayList.get(i);
            this.d.put(aVar, new h(this, aVar, jElapsedRealtime));
        }
        h hVar = (h) this.d.get(this.k);
        if (z) {
            hVar.a((d) eVar);
        } else {
            hVar.b();
        }
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.i;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = d.f2146a;
        long j3 = d.f;
        if (fVar.b != null) {
            fVar.f2125a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.b(fVar, kVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3));
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final int a(z zVar, long j, long j2, IOException iOException) {
        boolean z;
        D d = (D) zVar;
        boolean z2 = iOException instanceof r;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.i;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = d.f2146a;
        long j3 = d.f;
        if (fVar.b != null) {
            z = z2;
            fVar.f2125a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.d(fVar, kVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z));
        } else {
            z = z2;
        }
        return z ? 3 : 0;
    }

    public final d a(a aVar) {
        d dVar;
        h hVar = (h) this.d.get(aVar);
        hVar.getClass();
        hVar.g = SystemClock.elapsedRealtime();
        d dVar2 = hVar.d;
        if (dVar2 != null && this.j.b.contains(aVar) && (((dVar = this.l) == null || !dVar.j) && ((h) this.d.get(this.k)).g - SystemClock.elapsedRealtime() > 15000)) {
            this.k = aVar;
            ((h) this.d.get(aVar)).b();
        }
        return dVar2;
    }
}
