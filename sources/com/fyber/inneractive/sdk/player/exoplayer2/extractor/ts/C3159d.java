package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;
import android.util.Pair;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3159d implements h {
    public static final byte[] r = {73, 68, 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2076a;
    public final String d;
    public String e;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r f;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r g;
    public boolean k;
    public boolean l;
    public long m;
    public int n;
    public long o;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r p;
    public long q;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.m b = new com.fyber.inneractive.sdk.player.exoplayer2.util.m(new byte[7]);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(Arrays.copyOf(r, 10));
    public int h = 0;
    public int i = 0;
    public int j = 256;

    public C3159d(boolean z, String str) {
        this.f2076a = z;
        this.d = str;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        while (true) {
            int i = nVar.c;
            int i2 = nVar.b;
            int i3 = i - i2;
            if (i3 <= 0) {
                return;
            }
            int i4 = this.h;
            if (i4 == 0) {
                byte[] bArr = nVar.f2184a;
                while (true) {
                    if (i2 >= i) {
                        nVar.e(i2);
                        break;
                    }
                    int i5 = i2 + 1;
                    byte b = bArr[i2];
                    int i6 = b & 255;
                    int i7 = this.j;
                    if (i7 == 512 && i6 >= 240 && i6 != 255) {
                        this.k = (b & 1) == 0;
                        this.h = 2;
                        this.i = 0;
                        nVar.e(i5);
                        break;
                    }
                    int i8 = i7 | i6;
                    if (i8 == 329) {
                        this.j = 768;
                    } else if (i8 == 511) {
                        this.j = 512;
                    } else if (i8 == 836) {
                        this.j = 1024;
                    } else {
                        if (i8 == 1075) {
                            this.h = 1;
                            this.i = 3;
                            this.n = 0;
                            this.c.e(0);
                            nVar.e(i5);
                            break;
                        }
                        if (i7 != 256) {
                            this.j = 256;
                        }
                    }
                    i2 = i5;
                }
            } else if (i4 == 1) {
                byte[] bArr2 = this.c.f2184a;
                int iMin = Math.min(i3, 10 - this.i);
                nVar.a(bArr2, this.i, iMin);
                int i9 = this.i + iMin;
                this.i = i9;
                if (i9 == 10) {
                    this.g.a(10, this.c);
                    this.c.e(6);
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = this.g;
                    int i10 = this.c.i() + 10;
                    this.h = 3;
                    this.i = 10;
                    this.p = rVar;
                    this.q = 0L;
                    this.n = i10;
                }
            } else if (i4 == 2) {
                int i11 = this.k ? 7 : 5;
                byte[] bArr3 = this.b.f2183a;
                int iMin2 = Math.min(i3, i11 - this.i);
                nVar.a(bArr3, this.i, iMin2);
                int i12 = this.i + iMin2;
                this.i = i12;
                if (i12 == i11) {
                    this.b.b(0);
                    if (this.l) {
                        this.b.c(10);
                    } else {
                        int iA = this.b.a(2) + 1;
                        if (iA != 2) {
                            Log.w("AdtsReader", "Detected audio object type: " + iA + ", but assuming AAC LC.");
                            iA = 2;
                        }
                        int iA2 = this.b.a(4);
                        this.b.c(1);
                        byte[] bArr4 = {(byte) (((iA << 3) & 248) | ((iA2 >> 1) & 7)), (byte) (((iA2 << 7) & 128) | ((this.b.a(3) << 3) & 120))};
                        Pair pairA = com.fyber.inneractive.sdk.player.exoplayer2.util.d.a(bArr4);
                        com.fyber.inneractive.sdk.player.exoplayer2.o oVarA = com.fyber.inneractive.sdk.player.exoplayer2.o.a(this.e, "audio/mp4a-latm", -1, -1, ((Integer) pairA.second).intValue(), ((Integer) pairA.first).intValue(), Collections.singletonList(bArr4), null, this.d);
                        this.m = 1024000000 / ((long) oVarA.s);
                        this.f.a(oVarA);
                        this.l = true;
                    }
                    this.b.c(4);
                    int iA3 = this.b.a(13);
                    int i13 = iA3 - 7;
                    if (this.k) {
                        i13 = iA3 - 9;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar2 = this.f;
                    long j = this.m;
                    this.h = 3;
                    this.i = 0;
                    this.p = rVar2;
                    this.q = j;
                    this.n = i13;
                }
            } else if (i4 == 3) {
                int iMin3 = Math.min(i3, this.n - this.i);
                this.p.a(iMin3, nVar);
                int i14 = this.i + iMin3;
                this.i = i14;
                int i15 = this.n;
                if (i14 == i15) {
                    this.p.a(this.o, 1, i15, 0, null);
                    this.o += this.q;
                    this.h = 0;
                    this.i = 0;
                    this.j = 256;
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, E e) {
        e.a();
        e.b();
        this.e = e.e;
        e.b();
        this.f = jVar.a(e.d, 1);
        if (this.f2076a) {
            e.a();
            e.b();
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(e.d, 4);
            this.g = gVarA;
            e.b();
            gVarA.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(e.e, "application/id3", (com.fyber.inneractive.sdk.player.exoplayer2.drm.d) null));
            return;
        }
        this.g = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.h();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        this.o = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        this.h = 0;
        this.i = 0;
        this.j = 256;
    }
}
