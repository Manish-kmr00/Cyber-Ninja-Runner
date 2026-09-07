package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

/* JADX INFO: loaded from: classes8.dex */
public final class q implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n f2088a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.n b;
    public final String c;
    public String d;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r e;
    public int f = 0;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public int k;
    public long l;

    public q(String str) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(4);
        this.f2088a = nVar;
        nVar.f2184a[0] = -1;
        this.b = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.n();
        this.c = str;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        this.f = 0;
        this.g = 0;
        this.i = false;
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

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        while (true) {
            int i = nVar.c;
            int i2 = nVar.b;
            int i3 = i - i2;
            if (i3 <= 0) {
                return;
            }
            int i4 = this.f;
            if (i4 == 0) {
                byte[] bArr = nVar.f2184a;
                while (true) {
                    if (i2 < i) {
                        byte b = bArr[i2];
                        boolean z = (b & 255) == 255;
                        boolean z2 = this.i && (b & 224) == 224;
                        this.i = z;
                        if (z2) {
                            nVar.e(i2 + 1);
                            this.i = false;
                            this.f2088a.f2184a[1] = bArr[i2];
                            this.g = 2;
                            this.f = 1;
                            break;
                        }
                        i2++;
                    } else {
                        nVar.e(i);
                        break;
                    }
                }
            } else if (i4 == 1) {
                int iMin = Math.min(i3, 4 - this.g);
                nVar.a(this.f2088a.f2184a, this.g, iMin);
                int i5 = this.g + iMin;
                this.g = i5;
                if (i5 >= 4) {
                    this.f2088a.e(0);
                    if (!com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(this.f2088a.b(), this.b)) {
                        this.g = 0;
                        this.f = 1;
                    } else {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar2 = this.b;
                        this.k = nVar2.c;
                        if (!this.h) {
                            long j = ((long) nVar2.g) * 1000000;
                            int i6 = nVar2.d;
                            this.j = j / ((long) i6);
                            this.e.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(this.d, nVar2.b, -1, 4096, nVar2.e, i6, null, null, this.c));
                            this.h = true;
                        }
                        this.f2088a.e(0);
                        this.e.a(4, this.f2088a);
                        this.f = 2;
                    }
                }
            } else if (i4 == 2) {
                int iMin2 = Math.min(i3, this.k - this.g);
                this.e.a(iMin2, nVar);
                int i7 = this.g + iMin2;
                this.g = i7;
                int i8 = this.k;
                if (i7 >= i8) {
                    this.e.a(this.l, 1, i8, 0, null);
                    this.l += this.j;
                    this.g = 0;
                    this.f = 0;
                }
            }
        }
    }
}
