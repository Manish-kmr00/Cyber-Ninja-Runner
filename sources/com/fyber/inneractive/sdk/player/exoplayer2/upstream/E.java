package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
public final class E implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f2147a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c b;

    public E(h hVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c cVar) {
        hVar.getClass();
        this.f2147a = hVar;
        cVar.getClass();
        this.b = cVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(k kVar) throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.b {
        k kVar2 = kVar;
        long jA = this.f2147a.a(kVar2);
        if (kVar2.d == -1 && jA != -1) {
            kVar2 = new k(kVar2.f2163a, kVar2.b, kVar2.c, jA, kVar2.e, kVar2.f);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c cVar = this.b;
        cVar.getClass();
        if (kVar2.d != -1 || (kVar2.f & 2) == 2) {
            cVar.d = kVar2;
            cVar.i = 0L;
            try {
                cVar.b();
            } catch (IOException e) {
                throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.b(e);
            }
        } else {
            cVar.d = null;
        }
        return jA;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.b {
        try {
            this.f2147a.close();
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c cVar = this.b;
            if (cVar.d == null) {
                return;
            }
            try {
                cVar.a();
            } catch (IOException e) {
                throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.b(e);
            }
        } catch (Throwable th) {
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c cVar2 = this.b;
            if (cVar2.d != null) {
                try {
                    cVar2.a();
                } catch (IOException e2) {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.b(e2);
                }
            }
            throw th;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.b {
        int i3 = this.f2147a.read(bArr, i, i2);
        if (i3 > 0) {
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.c cVar = this.b;
            if (cVar.d != null) {
                int i4 = 0;
                while (i4 < i3) {
                    try {
                        if (cVar.h == cVar.b) {
                            cVar.a();
                            cVar.b();
                        }
                        int iMin = (int) Math.min(i3 - i4, cVar.b - cVar.h);
                        cVar.f.write(bArr, i + i4, iMin);
                        i4 += iMin;
                        long j = iMin;
                        cVar.h += j;
                        cVar.i += j;
                    } catch (IOException e) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.b(e);
                    }
                }
            }
        }
        return i3;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        return this.f2147a.a();
    }
}
