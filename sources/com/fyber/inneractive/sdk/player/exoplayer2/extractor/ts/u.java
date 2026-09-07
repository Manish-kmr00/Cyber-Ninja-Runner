package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import java.io.EOFException;

/* JADX INFO: loaded from: classes8.dex */
public final class u implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i {
    public boolean d;
    public boolean e;
    public boolean f;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.j g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.v f2092a = new com.fyber.inneractive.sdk.player.exoplayer2.util.v(0);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(4096);
    public final SparseArray b = new SparseArray();

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) throws InterruptedException, EOFException {
        byte[] bArr = new byte[14];
        bVar.a(bArr, 0, 14, false);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        bVar.a(bArr[13] & 7, false);
        bVar.a(bArr, 0, 3, false);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        this.g = jVar;
        jVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.p(-9223372036854775807L));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.f2092a.c = -9223372036854775807L;
        for (int i = 0; i < this.b.size(); i++) {
            t tVar = (t) this.b.valueAt(i);
            tVar.f = false;
            tVar.f2091a.a();
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00ae  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) throws InterruptedException, EOFException {
        h qVar;
        if (!bVar.a(this.c.f2184a, 0, 4, true)) {
            return -1;
        }
        this.c.e(0);
        int iB = this.c.b();
        if (iB == 441) {
            return -1;
        }
        if (iB == 442) {
            bVar.a(this.c.f2184a, 0, 10, false);
            this.c.e(9);
            bVar.a((this.c.j() & 7) + 14);
            return 0;
        }
        if (iB == 443) {
            bVar.a(this.c.f2184a, 0, 2, false);
            this.c.e(0);
            bVar.a(this.c.o() + 6);
            return 0;
        }
        if (((iB & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            bVar.a(1);
            return 0;
        }
        int i = iB & 255;
        t tVar = (t) this.b.get(i);
        if (!this.d) {
            if (tVar == null) {
                boolean z = this.e;
                h jVar = null;
                if (z || i != 189) {
                    if (!z && (iB & 224) == 192) {
                        qVar = new q(null);
                        this.e = true;
                    } else if (!this.f && (iB & 240) == 224) {
                        jVar = new j();
                        this.f = true;
                    }
                    if (jVar != null) {
                        jVar.a(this.g, new E(Integer.MIN_VALUE, i, 256));
                        t tVar2 = new t(jVar, this.f2092a);
                        this.b.put(i, tVar2);
                        tVar = tVar2;
                    }
                } else {
                    qVar = new C3157b(null);
                    this.e = true;
                }
                jVar = qVar;
                if (jVar != null) {
                    jVar.a(this.g, new E(Integer.MIN_VALUE, i, 256));
                    t tVar3 = new t(jVar, this.f2092a);
                    this.b.put(i, tVar3);
                    tVar = tVar3;
                }
            }
            if ((this.e && this.f) || bVar.c > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                this.d = true;
                this.g.b();
            }
        }
        bVar.a(this.c.f2184a, 0, 2, false);
        this.c.e(0);
        int iO = this.c.o() + 6;
        if (tVar == null) {
            bVar.a(iO);
        } else {
            this.c.c(iO);
            bVar.b(this.c.f2184a, 0, iO, false);
            this.c.e(6);
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.c;
            nVar.a(tVar.c.f2183a, 0, 3);
            tVar.c.b(0);
            tVar.c.c(8);
            tVar.d = tVar.c.b();
            tVar.e = tVar.c.b();
            tVar.c.c(6);
            nVar.a(tVar.c.f2183a, 0, tVar.c.a(8));
            tVar.c.b(0);
            tVar.g = 0L;
            if (tVar.d) {
                tVar.c.c(4);
                long jA = ((long) tVar.c.a(3)) << 30;
                tVar.c.c(1);
                long jA2 = jA | ((long) (tVar.c.a(15) << 15));
                tVar.c.c(1);
                long jA3 = jA2 | ((long) tVar.c.a(15));
                tVar.c.c(1);
                if (!tVar.f && tVar.e) {
                    tVar.c.c(4);
                    long jA4 = ((long) tVar.c.a(3)) << 30;
                    tVar.c.c(1);
                    long jA5 = jA4 | ((long) (tVar.c.a(15) << 15));
                    tVar.c.c(1);
                    long jA6 = jA5 | ((long) tVar.c.a(15));
                    tVar.c.c(1);
                    tVar.b.b(jA6);
                    tVar.f = true;
                }
                tVar.g = tVar.b.b(jA3);
            }
            tVar.f2091a.a(true, tVar.g);
            tVar.f2091a.a(nVar);
            tVar.f2091a.b();
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.c;
            nVar2.d(nVar2.a());
        }
        return 0;
    }
}
