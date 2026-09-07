package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

/* JADX INFO: loaded from: classes8.dex */
public final class w implements F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f2093a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(32);
    public int c;
    public int d;
    public boolean e;
    public boolean f;

    public w(v vVar) {
        this.f2093a = vVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.F
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, E e) {
        this.f2093a.a(vVar, jVar, e);
        this.f = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.F
    public final void a() {
        this.f = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.F
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, boolean z) {
        int iJ = z ? nVar.b + nVar.j() : -1;
        if (this.f) {
            if (!z) {
                return;
            }
            this.f = false;
            nVar.e(iJ);
            this.d = 0;
        }
        while (true) {
            int i = nVar.c - nVar.b;
            if (i <= 0) {
                return;
            }
            int i2 = this.d;
            if (i2 < 3) {
                if (i2 == 0) {
                    int iJ2 = nVar.j();
                    nVar.e(nVar.b - 1);
                    if (iJ2 == 255) {
                        this.f = true;
                        return;
                    }
                }
                int iMin = Math.min(nVar.c - nVar.b, 3 - this.d);
                nVar.a(this.b.f2184a, this.d, iMin);
                int i3 = this.d + iMin;
                this.d = i3;
                if (i3 == 3) {
                    this.b.c(3);
                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.b;
                    nVar2.e(nVar2.b + 1);
                    int iJ3 = this.b.j();
                    int iJ4 = this.b.j();
                    this.e = (iJ3 & 128) != 0;
                    this.c = (((iJ3 & 15) << 8) | iJ4) + 3;
                    int iA = this.b.a();
                    int i4 = this.c;
                    if (iA < i4) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = this.b;
                        byte[] bArr = nVar3.f2184a;
                        nVar3.c(Math.min(4098, Math.max(i4, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.b.f2184a, 0, 3);
                    }
                }
            } else {
                int iMin2 = Math.min(i, this.c - i2);
                nVar.a(this.b.f2184a, this.d, iMin2);
                int i5 = this.d + iMin2;
                this.d = i5;
                int i6 = this.c;
                if (i5 != i6) {
                    continue;
                } else {
                    if (this.e) {
                        byte[] bArr2 = this.b.f2184a;
                        int i7 = -1;
                        for (int i8 = 0; i8 < i6; i8++) {
                            i7 = com.fyber.inneractive.sdk.player.exoplayer2.util.z.h[((i7 >>> 24) ^ (bArr2[i8] & 255)) & 255] ^ (i7 << 8);
                        }
                        int i9 = com.fyber.inneractive.sdk.player.exoplayer2.util.z.f2192a;
                        if (i7 != 0) {
                            this.f = true;
                            return;
                        }
                        this.b.c(this.c - 4);
                    } else {
                        this.b.c(i6);
                    }
                    this.f2093a.a(this.b);
                    this.d = 0;
                }
            }
        }
    }
}
