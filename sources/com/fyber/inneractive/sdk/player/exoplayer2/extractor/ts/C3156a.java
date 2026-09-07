package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.io.EOFException;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3156a implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i {
    public static final int e = com.fyber.inneractive.sdk.player.exoplayer2.util.z.a("ID3");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2073a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(2786);
    public C3157b c;
    public boolean d;

    public C3156a(long j) {
        this.f2073a = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) throws InterruptedException, EOFException {
        int iA;
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(10);
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
        int i4 = i;
        while (true) {
            bVar.a(nVar.f2184a, 0, 5, false);
            nVar.e(0);
            if (nVar.o() != 2935) {
                bVar.e = 0;
                i4++;
                if (i4 - i >= 8192) {
                    return false;
                }
                bVar.a(i4, false);
                i3 = 0;
            } else {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArr = nVar.f2184a;
                if (bArr.length < 5) {
                    iA = -1;
                } else {
                    byte b = bArr[4];
                    iA = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.a((b & 192) >> 6, b & 63);
                }
                if (iA == -1) {
                    return false;
                }
                bVar.a(iA - 5, false);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        C3157b c3157b = new C3157b(null);
        this.c = c3157b;
        c3157b.d = "0";
        c3157b.e = jVar.a(0, 1);
        jVar.b();
        jVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.p(-9223372036854775807L));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.d = false;
        this.c.a();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) throws InterruptedException, EOFException {
        int iMin;
        byte[] bArr = this.b.f2184a;
        int i = bVar.f;
        if (i == 0) {
            iMin = 0;
        } else {
            iMin = Math.min(i, 2786);
            System.arraycopy(bVar.d, 0, bArr, 0, iMin);
            bVar.b(iMin);
        }
        if (iMin == 0) {
            iMin = bVar.a(bArr, 0, 2786, 0, true);
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
            this.c.l = this.f2073a;
            this.d = true;
        }
        this.c.a(this.b);
        return 0;
    }
}
