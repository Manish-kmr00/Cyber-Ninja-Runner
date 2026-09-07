package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.io.EOFException;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3158c implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i {
    public static final int e = com.fyber.inneractive.sdk.player.exoplayer2.util.z.a("ID3");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2075a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(200);
    public C3159d c;
    public boolean d;

    public C3158c(long j) {
        this.f2075a = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) throws InterruptedException, EOFException {
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(10);
        com.fyber.inneractive.sdk.player.exoplayer2.util.m mVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.m(nVar.f2184a);
        int i = 0;
        while (true) {
            bVar.a(nVar.f2184a, 0, 10, false);
            nVar.e(0);
            if (nVar.l() != e) {
                break;
            }
            nVar.e(nVar.b + 3);
            int i2 = nVar.i();
            i += i2 + 10;
            bVar.a(i2, false);
        }
        bVar.e = 0;
        bVar.a(i, false);
        int i3 = 0;
        int i4 = 0;
        int i5 = i;
        while (true) {
            bVar.a(nVar.f2184a, 0, 2, false);
            nVar.e(0);
            if ((nVar.o() & 65526) != 65520) {
                bVar.e = 0;
                i5++;
                if (i5 - i >= 8192) {
                    return false;
                }
                bVar.a(i5, false);
                i3 = 0;
                i4 = 0;
            } else {
                i3++;
                if (i3 >= 4 && i4 > 188) {
                    return true;
                }
                bVar.a(nVar.f2184a, 0, 4, false);
                mVar.b(14);
                int iA = mVar.a(13);
                if (iA <= 6) {
                    return false;
                }
                bVar.a(iA - 6, false);
                i4 += iA;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        C3159d c3159d = new C3159d(true, null);
        this.c = c3159d;
        c3159d.a(jVar, new E(Integer.MIN_VALUE, 0, 1));
        jVar.b();
        jVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.p(-9223372036854775807L));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.d = false;
        C3159d c3159d = this.c;
        c3159d.h = 0;
        c3159d.i = 0;
        c3159d.j = 256;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) throws InterruptedException, EOFException {
        int iMin;
        byte[] bArr = this.b.f2184a;
        int i = bVar.f;
        if (i == 0) {
            iMin = 0;
        } else {
            iMin = Math.min(i, 200);
            System.arraycopy(bVar.d, 0, bArr, 0, iMin);
            bVar.b(iMin);
        }
        if (iMin == 0) {
            iMin = bVar.a(bArr, 0, 200, 0, true);
        }
        if (iMin != -1) {
            bVar.c += (long) iMin;
        }
        if (iMin == -1) {
            return -1;
        }
        this.b.e(0);
        this.b.d(iMin);
        if (!this.d) {
            this.c.o = this.f2075a;
            this.d = true;
        }
        this.c.a(this.b);
        return 0;
    }
}
