package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.controller.B;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.source.t;
import com.fyber.inneractive.sdk.player.exoplayer2.source.u;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.D;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.InterfaceC3164b;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class j implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f2010a;
    public final b b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.f c;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k d;
    public t e;

    public j(Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar, Handler handler, B b) {
        b bVar = new b(gVar);
        this.f2010a = uri;
        this.b = bVar;
        this.c = new com.fyber.inneractive.sdk.player.exoplayer2.source.f(handler, b);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final void a(t tVar) {
        if (this.d != null) {
            throw new IllegalStateException();
        }
        Uri uri = this.f2010a;
        b bVar = this.b;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k kVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k(uri, bVar, this.c, this);
        this.d = kVar;
        this.e = tVar;
        D d = new D(bVar.f2006a.a(), uri, kVar.b);
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.B b = kVar.h;
        b.getClass();
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            throw new IllegalStateException();
        }
        y yVar = new y(b, looperMyLooper, d, kVar, 3, SystemClock.elapsedRealtime());
        if (b.b != null) {
            throw new IllegalStateException();
        }
        b.b = yVar;
        yVar.e = null;
        b.f2145a.execute(yVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final void b() {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k kVar = this.d;
        if (kVar != null) {
            kVar.h.a(null);
            Iterator it = kVar.d.values().iterator();
            while (it.hasNext()) {
                ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h) it.next()).b.a(null);
            }
            kVar.e.removeCallbacksAndMessages(null);
            kVar.d.clear();
            this.d = null;
        }
        this.e = null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final void a() throws IOException {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k kVar = this.d;
        kVar.h.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar = kVar.k;
        if (aVar != null) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h hVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h) kVar.d.get(aVar);
            hVar.b.b();
            IOException iOException = hVar.j;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final s a(int i, InterfaceC3164b interfaceC3164b, long j) {
        if (i == 0) {
            return new i(this.d, this.b, this.c, interfaceC3164b, j);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.u
    public final void a(s sVar) {
        i iVar = (i) sVar;
        iVar.f2009a.g.remove(iVar);
        iVar.h.removeCallbacksAndMessages(null);
        n[] nVarArr = iVar.n;
        if (nVarArr != null) {
            for (n nVar : nVarArr) {
                int size = nVar.j.size();
                for (int i = 0; i < size; i++) {
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) nVar.j.valueAt(i)).b();
                }
                nVar.g.a(null);
                nVar.m.removeCallbacksAndMessages(null);
                nVar.s = true;
            }
        }
    }
}
