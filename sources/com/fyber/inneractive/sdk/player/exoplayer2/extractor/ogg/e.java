package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import java.io.EOFException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f2058a;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        boolean zA;
        boolean zEquals;
        try {
            g gVar = new g();
            if (gVar.a(bVar, true) && (gVar.f2060a & 2) == 2) {
                int iMin = Math.min(gVar.e, 8);
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(iMin);
                bVar.a(nVar.f2184a, 0, iMin, false);
                nVar.e(0);
                if (nVar.c - nVar.b >= 5 && nVar.j() == 127 && nVar.k() == 1179402563) {
                    this.f2058a = new d();
                } else {
                    nVar.e(0);
                    try {
                        zA = s.a(1, nVar, true);
                    } catch (com.fyber.inneractive.sdk.player.exoplayer2.r unused) {
                        zA = false;
                    }
                    if (zA) {
                        this.f2058a = new o();
                    } else {
                        nVar.e(0);
                        int i = i.o;
                        int i2 = nVar.c - nVar.b;
                        byte[] bArr = i.p;
                        if (i2 < bArr.length) {
                            zEquals = false;
                        } else {
                            byte[] bArr2 = new byte[bArr.length];
                            nVar.a(bArr2, 0, bArr.length);
                            zEquals = Arrays.equals(bArr2, bArr);
                        }
                        if (zEquals) {
                            this.f2058a = new i();
                        }
                    }
                }
                return true;
            }
        } catch (com.fyber.inneractive.sdk.player.exoplayer2.r unused2) {
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(0, 1);
        jVar.b();
        l lVar = this.f2058a;
        lVar.c = jVar;
        lVar.b = gVarA;
        lVar.f2062a = new f();
        lVar.a(true);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        l lVar = this.f2058a;
        f fVar = lVar.f2062a;
        g gVar = fVar.f2059a;
        gVar.f2060a = 0;
        gVar.b = 0L;
        gVar.c = 0;
        gVar.d = 0;
        gVar.e = 0;
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = fVar.b;
        nVar.b = 0;
        nVar.c = 0;
        fVar.c = -1;
        fVar.e = false;
        if (j == 0) {
            lVar.a(!lVar.l);
        } else if (lVar.h != 0) {
            lVar.e = lVar.d.c(j2);
            lVar.h = 2;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) throws InterruptedException, EOFException {
        l lVar = this.f2058a;
        int i = lVar.h;
        if (i == 0) {
            boolean zA = true;
            while (zA) {
                if (!lVar.f2062a.a(bVar)) {
                    lVar.h = 3;
                    return -1;
                }
                long j = bVar.c;
                long j2 = lVar.f;
                lVar.k = j - j2;
                zA = lVar.a(lVar.f2062a.b, j2, lVar.j);
                if (zA) {
                    lVar.f = bVar.c;
                }
            }
            com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 = lVar.j.f2061a;
            lVar.i = oVar2.s;
            if (!lVar.m) {
                lVar.b.a(oVar2);
                lVar.m = true;
            }
            c cVar = lVar.j.b;
            if (cVar != null) {
                lVar.d = cVar;
            } else {
                long j3 = bVar.b;
                if (j3 == -1) {
                    lVar.d = new k();
                } else {
                    g gVar = lVar.f2062a.f2059a;
                    lVar.d = new b(lVar.f, j3, lVar, gVar.d + gVar.e, gVar.b);
                }
            }
            lVar.j = null;
            lVar.h = 2;
            lVar.f2062a.a();
        } else if (i == 1) {
            bVar.a((int) lVar.f);
            lVar.h = 2;
        } else if (i == 2) {
            long jA = lVar.d.a(bVar);
            if (jA >= 0) {
                oVar.f2054a = jA;
                return 1;
            }
            if (jA < -1) {
                lVar.a(-(jA + 2));
            }
            if (!lVar.l) {
                lVar.c.a(lVar.d.b());
                lVar.l = true;
            }
            if (lVar.k <= 0 && !lVar.f2062a.a(bVar)) {
                lVar.h = 3;
                return -1;
            }
            lVar.k = 0L;
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = lVar.f2062a.b;
            long jA2 = lVar.a(nVar);
            if (jA2 >= 0) {
                long j4 = lVar.g;
                if (j4 + jA2 >= lVar.e) {
                    long j5 = (j4 * 1000000) / ((long) lVar.i);
                    lVar.b.a(nVar.c, nVar);
                    lVar.b.a(j5, 1, nVar.c, 0, null);
                    lVar.e = -1L;
                }
            }
            lVar.g += jA2;
        } else {
            throw new IllegalStateException();
        }
        return 0;
    }
}
