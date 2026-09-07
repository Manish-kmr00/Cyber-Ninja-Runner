package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;

/* JADX INFO: loaded from: classes8.dex */
public final class s implements F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f2090a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.m b = new com.fyber.inneractive.sdk.player.exoplayer2.util.m(new byte[10]);
    public int c = 0;
    public int d;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.v e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public long l;

    public s(h hVar) {
        this.f2090a = hVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.F
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, E e) {
        this.e = vVar;
        this.f2090a.a(jVar, e);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.F
    public final void a() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.f2090a.a();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.F
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, boolean z) {
        int i;
        if (z) {
            int i2 = this.c;
            if (i2 == 2) {
                Log.w("PesReader", "Unexpected start indicator reading extended header");
            } else if (i2 == 3) {
                if (this.j != -1) {
                    Log.w("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
                }
                this.f2090a.b();
            }
            this.c = 1;
            this.d = 0;
        }
        while (true) {
            int i3 = nVar.c;
            int i4 = nVar.b;
            int i5 = i3 - i4;
            if (i5 <= 0) {
                return;
            }
            int i6 = this.c;
            if (i6 == 0) {
                nVar.e(i5 + i4);
            } else if (i6 != 1) {
                if (i6 == 2) {
                    if (a(nVar, this.b.f2183a, Math.min(10, this.i)) && a(nVar, (byte[]) null, this.i)) {
                        this.b.b(0);
                        this.l = -9223372036854775807L;
                        if (this.f) {
                            this.b.c(4);
                            long jA = ((long) this.b.a(3)) << 30;
                            this.b.c(1);
                            long jA2 = jA | ((long) (this.b.a(15) << 15));
                            this.b.c(1);
                            long jA3 = jA2 | ((long) this.b.a(15));
                            this.b.c(1);
                            if (!this.h && this.g) {
                                this.b.c(4);
                                long jA4 = ((long) this.b.a(3)) << 30;
                                this.b.c(1);
                                long jA5 = jA4 | ((long) (this.b.a(15) << 15));
                                this.b.c(1);
                                long jA6 = jA5 | ((long) this.b.a(15));
                                this.b.c(1);
                                this.e.b(jA6);
                                this.h = true;
                            }
                            this.l = this.e.b(jA3);
                        }
                        this.f2090a.a(this.k, this.l);
                        this.c = 3;
                        this.d = 0;
                    }
                } else if (i6 == 3) {
                    int i7 = this.j;
                    int i8 = i7 == -1 ? 0 : i5 - i7;
                    if (i8 > 0) {
                        i5 -= i8;
                        nVar.d(i4 + i5);
                    }
                    this.f2090a.a(nVar);
                    int i9 = this.j;
                    if (i9 != -1) {
                        int i10 = i9 - i5;
                        this.j = i10;
                        if (i10 == 0) {
                            this.f2090a.b();
                            this.c = 1;
                            this.d = 0;
                        }
                    }
                }
            } else if (a(nVar, this.b.f2183a, 9)) {
                this.b.b(0);
                int iA = this.b.a(24);
                if (iA != 1) {
                    Log.w("PesReader", "Unexpected start code prefix: " + iA);
                    this.j = -1;
                    i = 0;
                } else {
                    this.b.c(8);
                    int iA2 = this.b.a(16);
                    this.b.c(5);
                    this.k = this.b.b();
                    this.b.c(2);
                    this.f = this.b.b();
                    this.g = this.b.b();
                    this.b.c(6);
                    int iA3 = this.b.a(8);
                    this.i = iA3;
                    if (iA2 == 0) {
                        this.j = -1;
                    } else {
                        this.j = (iA2 - 3) - iA3;
                    }
                    i = 2;
                }
                this.c = i;
                this.d = 0;
            }
        }
    }

    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, byte[] bArr, int i) {
        int iMin = Math.min(nVar.c - nVar.b, i - this.d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            nVar.e(nVar.b + iMin);
        } else {
            nVar.a(bArr, this.d, iMin);
        }
        int i2 = this.d + iMin;
        this.d = i2;
        return i2 == i;
    }
}
