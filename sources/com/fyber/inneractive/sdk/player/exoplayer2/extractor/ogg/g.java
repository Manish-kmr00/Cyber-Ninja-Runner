package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.EOFException;

/* JADX INFO: loaded from: classes11.dex */
public final class g {
    public static final int h = z.a("OggS");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2060a;
    public long b;
    public int c;
    public int d;
    public int e;
    public final int[] f = new int[255];
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n g = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(255);

    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.r, EOFException {
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.g;
        nVar.b = 0;
        nVar.c = 0;
        this.f2060a = 0;
        this.b = 0L;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        long j = bVar.b;
        if ((j != -1 && j - (bVar.c + ((long) bVar.e)) < 27) || !bVar.a(nVar.f2184a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        }
        if (this.g.k() != h) {
            if (z) {
                return false;
            }
            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("expected OggS capture pattern at begin of page");
        }
        if (this.g.j() != 0) {
            if (z) {
                return false;
            }
            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("unsupported bit stream revision");
        }
        this.f2060a = this.g.j();
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.g;
        byte[] bArr = nVar2.f2184a;
        int i = nVar2.b;
        int i2 = i + 1;
        nVar2.b = i2;
        long j2 = ((long) bArr[i]) & 255;
        int i3 = i + 2;
        nVar2.b = i3;
        long j3 = j2 | ((((long) bArr[i2]) & 255) << 8);
        int i4 = i + 3;
        nVar2.b = i4;
        long j4 = j3 | ((((long) bArr[i3]) & 255) << 16);
        int i5 = i + 4;
        nVar2.b = i5;
        long j5 = j4 | ((((long) bArr[i4]) & 255) << 24);
        int i6 = i + 5;
        nVar2.b = i6;
        long j6 = j5 | ((((long) bArr[i5]) & 255) << 32);
        int i7 = i + 6;
        nVar2.b = i7;
        long j7 = j6 | ((((long) bArr[i6]) & 255) << 40);
        int i8 = i + 7;
        nVar2.b = i8;
        long j8 = j7 | ((((long) bArr[i7]) & 255) << 48);
        nVar2.b = i + 8;
        this.b = j8 | ((255 & ((long) bArr[i8])) << 56);
        nVar2.e();
        this.g.e();
        this.g.e();
        int iJ = this.g.j();
        this.c = iJ;
        this.d = iJ + 27;
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = this.g;
        nVar3.b = 0;
        nVar3.c = 0;
        bVar.a(nVar3.f2184a, 0, iJ, false);
        for (int i9 = 0; i9 < this.c; i9++) {
            this.f[i9] = this.g.j();
            this.e += this.f[i9];
        }
        return true;
    }
}
