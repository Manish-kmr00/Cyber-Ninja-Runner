package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.i;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.o;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.EOFException;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements i {
    public static final int m = z.a("Xing");
    public static final int n = z.a("Info");
    public static final int o = z.a("VBRI");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2032a;
    public j e;
    public r f;
    public int g;
    public com.fyber.inneractive.sdk.player.exoplayer2.metadata.b h;
    public b i;
    public long k;
    public int l;
    public final n b = new n(10);
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.n c = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.n();
    public final m d = new m();
    public long j = -9223372036854775807L;

    public c(long j) {
        this.f2032a = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        return a(bVar, true);
    }

    public final a b(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        bVar.a(this.b.f2184a, 0, 4, false);
        this.b.e(0);
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(this.b.b(), this.c);
        return new a(this.c.f, bVar.c, bVar.b);
    }

    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, boolean z) throws InterruptedException, com.fyber.inneractive.sdk.player.exoplayer2.r, EOFException {
        int i;
        int i2;
        int iA;
        int i3 = z ? 16384 : 131072;
        bVar.e = 0;
        if (bVar.c == 0) {
            int i4 = 0;
            while (true) {
                bVar.a(this.b.f2184a, 0, 10, false);
                this.b.e(0);
                if (this.b.l() != com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n.b) {
                    break;
                }
                n nVar = this.b;
                nVar.e(nVar.b + 3);
                int i5 = this.b.i();
                int i6 = i5 + 10;
                if (this.h == null) {
                    byte[] bArr = new byte[i6];
                    System.arraycopy(this.b.f2184a, 0, bArr, 0, 10);
                    bVar.a(bArr, 10, i5, false);
                    com.fyber.inneractive.sdk.player.exoplayer2.metadata.b bVarA = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n(null).a(i6, bArr);
                    this.h = bVarA;
                    if (bVarA != null) {
                        this.d.a(bVarA);
                    }
                } else {
                    bVar.a(i5, false);
                }
                i4 += i6;
            }
            bVar.e = 0;
            bVar.a(i4, false);
            i = (int) (bVar.c + ((long) bVar.e));
            if (!z) {
                bVar.a(i);
            }
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        int i7 = i2;
        int i8 = i7;
        while (true) {
            if (!bVar.a(this.b.f2184a, 0, 4, i2 > 0)) {
                break;
            }
            this.b.e(0);
            int iB = this.b.b();
            if ((i7 == 0 || ((-128000) & iB) == (((long) i7) & (-128000))) && (iA = com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(iB)) != -1) {
                i2++;
                if (i2 != 1) {
                    if (i2 == 4) {
                        break;
                    }
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(iB, this.c);
                    i7 = iB;
                }
                bVar.a(iA - 4, false);
            } else {
                int i9 = i8 + 1;
                if (i8 == i3) {
                    if (z) {
                        return false;
                    }
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Searched too many bytes.");
                }
                if (z) {
                    bVar.e = 0;
                    bVar.a(i + i9, false);
                } else {
                    bVar.a(1);
                }
                i7 = 0;
                i8 = i9;
                i2 = 0;
            }
        }
        if (z) {
            bVar.a(i + i8);
        } else {
            bVar.e = 0;
        }
        this.g = i7;
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(j jVar) {
        this.e = jVar;
        this.f = jVar.a(0, 1);
        this.e.b();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.g = 0;
        this.j = -9223372036854775807L;
        this.k = 0L;
        this.l = 0;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x005d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0068  */
    /* JADX WARN: Code duplicated, block: B:30:0x006a  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, o oVar) throws InterruptedException, com.fyber.inneractive.sdk.player.exoplayer2.r, EOFException {
        int i;
        int i2;
        int iB;
        int iB2;
        int i3;
        b bVarB;
        int iM;
        d dVar;
        int iJ;
        long j;
        long jMin;
        if (this.g == 0) {
            try {
                a(bVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.i == null) {
            n nVar = new n(this.c.c);
            bVar.a(nVar.f2184a, 0, this.c.c, false);
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar2 = this.c;
            if ((nVar2.f2053a & 1) != 0) {
                if (nVar2.e != 1) {
                    i2 = 36;
                } else {
                    i2 = 21;
                }
            } else if (nVar2.e != 1) {
                i2 = 21;
            } else {
                i2 = 13;
            }
            if (nVar.c >= i2 + 4) {
                nVar.e(i2);
                iB = nVar.b();
                if (iB != m && iB != n) {
                    if (nVar.c >= 40) {
                        nVar.e(36);
                        iB2 = nVar.b();
                        i3 = o;
                        if (iB2 == i3) {
                            iB = i3;
                        } else {
                            iB = 0;
                        }
                    } else {
                        iB = 0;
                    }
                }
            } else if (nVar.c >= 40) {
                nVar.e(36);
                iB2 = nVar.b();
                i3 = o;
                if (iB2 == i3) {
                    iB = i3;
                } else {
                    iB = 0;
                }
            } else {
                iB = 0;
            }
            if (iB != m && iB != n) {
                if (iB == o) {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar3 = this.c;
                    long j2 = bVar.c;
                    long j3 = bVar.b;
                    nVar.e(nVar.b + 10);
                    int iB3 = nVar.b();
                    if (iB3 <= 0) {
                        dVar = null;
                        break;
                    }
                    int i4 = nVar3.d;
                    long jA = z.a(iB3, ((long) (i4 >= 32000 ? 1152 : 576)) * 1000000, i4);
                    int iO = nVar.o();
                    int iO2 = nVar.o();
                    int iO3 = nVar.o();
                    int i5 = 2;
                    nVar.e(nVar.b + 2);
                    long j4 = j2 + ((long) nVar3.c);
                    int i6 = iO + 1;
                    long[] jArr = new long[i6];
                    long[] jArr2 = new long[i6];
                    jArr[0] = 0;
                    jArr2[0] = j4;
                    long j5 = j4;
                    int i7 = 1;
                    while (true) {
                        if (i7 < i6) {
                            if (iO3 == 1) {
                                iJ = nVar.j();
                            } else if (iO3 == i5) {
                                iJ = nVar.o();
                            } else if (iO3 != 3) {
                                if (iO3 != 4) {
                                    dVar = null;
                                    break;
                                }
                                iJ = nVar.m();
                            } else {
                                iJ = nVar.l();
                            }
                            long j6 = j3;
                            long j7 = j5 + ((long) (iJ * iO2));
                            int i8 = i6;
                            int i9 = iO2;
                            int i10 = iO3;
                            jArr[i7] = (((long) i7) * jA) / ((long) iO);
                            if (j6 == -1) {
                                jMin = j7;
                                j = j6;
                            } else {
                                j = j6;
                                jMin = Math.min(j, j7);
                            }
                            jArr2[i7] = jMin;
                            i7++;
                            iO2 = i9;
                            iO3 = i10;
                            long j8 = j;
                            i6 = i8;
                            j5 = j7;
                            i5 = 2;
                            j3 = j8;
                        } else {
                            dVar = new d(jArr, jArr2, jA);
                            break;
                        }
                    }
                    bVar.a(this.c.c);
                    bVarB = dVar;
                } else {
                    bVar.e = 0;
                    bVarB = null;
                }
            } else {
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar4 = this.c;
                long j9 = bVar.c;
                long j10 = bVar.b;
                int i11 = nVar4.g;
                int i12 = nVar4.d;
                long j11 = j9 + ((long) nVar4.c);
                int iB4 = nVar.b();
                if ((iB4 & 1) != 1 || (iM = nVar.m()) == 0) {
                    bVarB = null;
                } else {
                    long jA2 = z.a(iM, ((long) i11) * 1000000, i12);
                    if ((iB4 & 6) != 6) {
                        bVarB = new e(j11, jA2, j10, null, 0L, 0);
                    } else {
                        long jM = nVar.m();
                        nVar.e(nVar.b + 1);
                        long[] jArr3 = new long[99];
                        for (int i13 = 0; i13 < 99; i13++) {
                            jArr3[i13] = nVar.j();
                        }
                        bVarB = new e(j11, jA2, j10, jArr3, jM, nVar4.c);
                    }
                }
                if (bVarB != null) {
                    m mVar = this.d;
                    if (mVar.f2023a == -1 || mVar.b == -1) {
                        bVar.e = 0;
                        bVar.a(i2 + 141, false);
                        bVar.a(this.b.f2184a, 0, 3, false);
                        this.b.e(0);
                        m mVar2 = this.d;
                        int iL = this.b.l();
                        mVar2.getClass();
                        int i14 = iL >> 12;
                        int i15 = iL & 4095;
                        if (i14 > 0 || i15 > 0) {
                            mVar2.f2023a = i14;
                            mVar2.b = i15;
                        }
                    }
                }
                bVar.a(this.c.c);
                if (bVarB != null && !bVarB.a() && iB == n) {
                    bVarB = b(bVar);
                }
            }
            this.i = bVarB;
            if (bVarB == null) {
                this.i = b(bVar);
            }
            this.e.a(this.i);
            r rVar = this.f;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar5 = this.c;
            String str = nVar5.b;
            int i16 = nVar5.e;
            int i17 = nVar5.d;
            m mVar3 = this.d;
            rVar.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, str, -1, 4096, i16, i17, -1, mVar3.f2023a, mVar3.b, null, null, 0, null, this.h));
        }
        if (this.l == 0) {
            bVar.e = 0;
            if (bVar.a(this.b.f2184a, 0, 4, true)) {
                this.b.e(0);
                int iB5 = this.b.b();
                if (((-128000) & iB5) == (((long) this.g) & (-128000)) && com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(iB5) != -1) {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(iB5, this.c);
                    if (this.j == -9223372036854775807L) {
                        this.j = this.i.b(bVar.c);
                        if (this.f2032a != -9223372036854775807L) {
                            this.j = (this.f2032a - this.i.b(0L)) + this.j;
                        }
                    }
                    this.l = this.c.c;
                } else {
                    bVar.a(1);
                    this.g = 0;
                }
                return 0;
            }
            i = -1;
            return i;
        }
        int iA = this.f.a(bVar, this.l, true);
        i = -1;
        if (iA != -1) {
            int i18 = this.l - iA;
            this.l = i18;
            if (i18 <= 0) {
                long j12 = this.j;
                long j13 = this.k * 1000000;
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar6 = this.c;
                this.f.a((j13 / ((long) nVar6.d)) + j12, 1, nVar6.c, 0, null);
                this.k += (long) this.c.g;
                this.l = 0;
                return 0;
            }
            return 0;
        }
        return i;
    }
}
