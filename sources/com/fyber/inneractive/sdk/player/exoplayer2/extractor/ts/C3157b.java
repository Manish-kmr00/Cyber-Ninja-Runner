package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.google.common.base.Ascii;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3157b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.m f2074a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b;
    public final String c;
    public String d;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r e;
    public int f = 0;
    public int g;
    public boolean h;
    public long i;
    public com.fyber.inneractive.sdk.player.exoplayer2.o j;
    public int k;
    public long l;

    public C3157b(String str) {
        byte[] bArr = new byte[8];
        this.f2074a = new com.fyber.inneractive.sdk.player.exoplayer2.util.m(bArr);
        this.b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(bArr);
        this.c = str;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        this.f = 0;
        this.g = 0;
        this.h = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, E e) {
        e.a();
        e.b();
        this.d = e.e;
        e.b();
        this.e = jVar.a(e.d, 1);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        this.l = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int iA;
        int i;
        String str;
        int iA2;
        int i2;
        int i3;
        while (true) {
            int i4 = nVar.c - nVar.b;
            if (i4 <= 0) {
                return;
            }
            int i5 = this.f;
            if (i5 == 0) {
                while (nVar.c - nVar.b > 0) {
                    if (!this.h) {
                        this.h = nVar.j() == 11;
                    } else {
                        int iJ = nVar.j();
                        if (iJ == 119) {
                            this.h = false;
                            this.f = 1;
                            byte[] bArr = this.b.f2184a;
                            bArr[0] = Ascii.VT;
                            bArr[1] = 119;
                            this.g = 2;
                            break;
                        }
                        this.h = iJ == 11;
                    }
                }
            } else if (i5 == 1) {
                byte[] bArr2 = this.b.f2184a;
                int iMin = Math.min(i4, 8 - this.g);
                nVar.a(bArr2, this.g, iMin);
                int i6 = this.g + iMin;
                this.g = i6;
                if (i6 == 8) {
                    this.f2074a.b(0);
                    com.fyber.inneractive.sdk.player.exoplayer2.util.m mVar = this.f2074a;
                    int i7 = (mVar.b * 8) + mVar.c;
                    mVar.c(40);
                    byte b = mVar.a(5) == 16;
                    mVar.b(i7);
                    int i8 = 6;
                    if (b != false) {
                        mVar.c(21);
                        iA2 = (mVar.a(11) + 1) * 2;
                        int iA3 = mVar.a(2);
                        if (iA3 == 3) {
                            i3 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.c[mVar.a(2)];
                        } else {
                            i8 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.f1974a[mVar.a(2)];
                            i3 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.b[iA3];
                        }
                        i2 = i8 * 256;
                        iA = mVar.a(3);
                        i = i3;
                        str = "audio/eac3";
                    } else {
                        mVar.c(32);
                        int iA4 = mVar.a(2);
                        int iA5 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.a(iA4, mVar.a(6));
                        mVar.c(8);
                        iA = mVar.a(3);
                        if ((iA & 1) != 0 && iA != 1) {
                            mVar.c(2);
                        }
                        if ((iA & 4) != 0) {
                            mVar.c(2);
                        }
                        if (iA == 2) {
                            mVar.c(2);
                        }
                        i = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.b[iA4];
                        str = "audio/ac3";
                        iA2 = iA5;
                        i2 = 1536;
                    }
                    int i9 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.d[iA] + (mVar.b() ? 1 : 0);
                    com.fyber.inneractive.sdk.player.exoplayer2.o oVar = this.j;
                    if (oVar == null || i9 != oVar.r || i != oVar.s || str != oVar.f) {
                        com.fyber.inneractive.sdk.player.exoplayer2.o oVarA = com.fyber.inneractive.sdk.player.exoplayer2.o.a(this.d, str, -1, -1, i9, i, null, null, this.c);
                        this.j = oVarA;
                        this.e.a(oVarA);
                    }
                    this.k = iA2;
                    this.i = (((long) i2) * 1000000) / ((long) this.j.s);
                    this.b.e(0);
                    this.e.a(8, this.b);
                    this.f = 2;
                }
            } else if (i5 == 2) {
                int iMin2 = Math.min(i4, this.k - this.g);
                this.e.a(iMin2, nVar);
                int i10 = this.g + iMin2;
                this.g = i10;
                int i11 = this.k;
                if (i10 == i11) {
                    this.e.a(this.l, 1, i11, 0, null);
                    this.l += this.i;
                    this.f = 0;
                }
            }
        }
    }
}
