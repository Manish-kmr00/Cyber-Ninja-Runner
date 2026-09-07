package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class o extends l {
    public n n;
    public int o;
    public boolean p;
    public r q;
    public p r;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int i;
        byte b = nVar.f2184a[0];
        if ((b & 1) == 1) {
            return -1L;
        }
        n nVar2 = this.n;
        if (!nVar2.c[(b >> 1) & (255 >>> (8 - nVar2.d))].f2065a) {
            i = nVar2.f2064a.d;
        } else {
            i = nVar2.f2064a.e;
        }
        long j = this.p ? (this.o + i) / 4 : 0;
        nVar.d(nVar.c + 4);
        byte[] bArr = nVar.f2184a;
        int i2 = nVar.c;
        bArr[i2 - 4] = (byte) (j & 255);
        bArr[i2 - 3] = (byte) ((j >>> 8) & 255);
        bArr[i2 - 2] = (byte) ((j >>> 16) & 255);
        bArr[i2 - 1] = (byte) ((j >>> 24) & 255);
        this.p = true;
        this.o = i;
        return j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, long j, j jVar) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        long jFloor;
        if (this.n != null) {
            return false;
        }
        n nVar2 = null;
        if (this.q == null) {
            this.q = s.a(nVar);
        } else if (this.r == null) {
            s.a(3, nVar, false);
            nVar.b((int) nVar.e());
            long jE = nVar.e();
            String[] strArr = new String[(int) jE];
            for (int i = 0; i < jE; i++) {
                strArr[i] = nVar.b((int) nVar.e());
            }
            if ((nVar.j() & 1) != 0) {
                this.r = new p();
            } else {
                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("framing bit expected to be set");
            }
        } else {
            int i2 = nVar.c;
            byte[] bArr = new byte[i2];
            System.arraycopy(nVar.f2184a, 0, bArr, 0, i2);
            int i3 = this.q.f2066a;
            int i4 = 5;
            s.a(5, nVar, false);
            int iJ = nVar.j() + 1;
            m mVar = new m(nVar.f2184a);
            mVar.b(nVar.b * 8);
            int i5 = 0;
            while (i5 < iJ) {
                if (mVar.a(24) == 5653314) {
                    int iA = mVar.a(16);
                    int iA2 = mVar.a(24);
                    long[] jArr = new long[iA2];
                    long j2 = 0;
                    if (!mVar.a()) {
                        boolean zA = mVar.a();
                        for (int i6 = 0; i6 < iA2; i6++) {
                            if (zA) {
                                if (mVar.a()) {
                                    jArr[i6] = mVar.a(i4) + 1;
                                } else {
                                    jArr[i6] = 0;
                                }
                            } else {
                                jArr[i6] = mVar.a(i4) + 1;
                            }
                        }
                    } else {
                        int iA3 = mVar.a(i4) + 1;
                        int i7 = 0;
                        while (i7 < iA2) {
                            int i8 = 0;
                            for (int i9 = iA2 - i7; i9 > 0; i9 >>>= 1) {
                                i8++;
                            }
                            int iA4 = mVar.a(i8);
                            int i10 = 0;
                            while (i10 < iA4 && i7 < iA2) {
                                jArr[i7] = iA3;
                                i7++;
                                i10++;
                                iJ = iJ;
                            }
                            iA3++;
                            iJ = iJ;
                        }
                    }
                    int i11 = iJ;
                    int iA5 = mVar.a(4);
                    if (iA5 > 2) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r(com.fyber.inneractive.sdk.player.exoplayer2.m.a("lookup type greater than 2 not decodable: ", iA5));
                    }
                    if (iA5 == 1 || iA5 == 2) {
                        mVar.b(32);
                        mVar.b(32);
                        int iA6 = mVar.a(4) + 1;
                        mVar.b(1);
                        if (iA5 == 1) {
                            if (iA != 0) {
                                jFloor = (long) Math.floor(Math.pow(iA2, 1.0d / ((double) iA)));
                            }
                            mVar.b((int) (((long) iA6) * j2));
                        } else {
                            jFloor = iA2 * iA;
                        }
                        j2 = jFloor;
                        mVar.b((int) (((long) iA6) * j2));
                    }
                    i5++;
                    iJ = i11;
                    i4 = 5;
                } else {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("expected code book to start with [0x56, 0x43, 0x42] at " + ((mVar.c * 8) + mVar.d));
                }
            }
            int i12 = 6;
            int iA7 = mVar.a(6) + 1;
            for (int i13 = 0; i13 < iA7; i13++) {
                if (mVar.a(16) != 0) {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("placeholder of time domain transforms not zeroed out");
                }
            }
            int iA8 = mVar.a(6) + 1;
            int i14 = 0;
            while (i14 < iA8) {
                int iA9 = mVar.a(16);
                if (iA9 == 0) {
                    int i15 = 8;
                    mVar.b(8);
                    mVar.b(16);
                    mVar.b(16);
                    mVar.b(6);
                    mVar.b(8);
                    int iA10 = mVar.a(4) + 1;
                    int i16 = 0;
                    while (i16 < iA10) {
                        mVar.b(i15);
                        i16++;
                        i15 = 8;
                    }
                } else if (iA9 == 1) {
                    int iA11 = mVar.a(5);
                    int[] iArr = new int[iA11];
                    int i17 = -1;
                    for (int i18 = 0; i18 < iA11; i18++) {
                        int iA12 = mVar.a(4);
                        iArr[i18] = iA12;
                        if (iA12 > i17) {
                            i17 = iA12;
                        }
                    }
                    int i19 = i17 + 1;
                    int[] iArr2 = new int[i19];
                    for (int i20 = 0; i20 < i19; i20++) {
                        iArr2[i20] = mVar.a(3) + 1;
                        int iA13 = mVar.a(2);
                        int i21 = 8;
                        if (iA13 > 0) {
                            mVar.b(8);
                        }
                        int i22 = 0;
                        while (i22 < (1 << iA13)) {
                            mVar.b(i21);
                            i22++;
                            i21 = 8;
                        }
                    }
                    mVar.b(2);
                    int iA14 = mVar.a(4);
                    int i23 = 0;
                    int i24 = 0;
                    for (int i25 = 0; i25 < iA11; i25++) {
                        i23 += iArr2[iArr[i25]];
                        while (i24 < i23) {
                            mVar.b(iA14);
                            i24++;
                        }
                    }
                } else {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r(com.fyber.inneractive.sdk.player.exoplayer2.m.a("floor type greater than 1 not decodable: ", iA9));
                }
                i14++;
                i12 = 6;
            }
            int iA15 = mVar.a(i12) + 1;
            int i26 = 0;
            while (i26 < iA15) {
                if (mVar.a(16) <= 2) {
                    mVar.b(24);
                    mVar.b(24);
                    mVar.b(24);
                    int iA16 = mVar.a(i12) + 1;
                    int i27 = 8;
                    mVar.b(8);
                    int[] iArr3 = new int[iA16];
                    for (int i28 = 0; i28 < iA16; i28++) {
                        iArr3[i28] = ((mVar.a() ? mVar.a(5) : 0) * 8) + mVar.a(3);
                    }
                    int i29 = 0;
                    while (i29 < iA16) {
                        int i30 = 0;
                        while (i30 < i27) {
                            if ((iArr3[i29] & (1 << i30)) != 0) {
                                mVar.b(i27);
                            }
                            i30++;
                            i27 = 8;
                        }
                        i29++;
                        i27 = 8;
                    }
                    i26++;
                    i12 = 6;
                } else {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("residueType greater than 2 is not decodable");
                }
            }
            int iA17 = mVar.a(i12) + 1;
            for (int i31 = 0; i31 < iA17; i31++) {
                int iA18 = mVar.a(16);
                if (iA18 != 0) {
                    Log.e("VorbisUtil", "mapping type other than 0 not supported: " + iA18);
                } else {
                    int iA19 = mVar.a() ? mVar.a(4) + 1 : 1;
                    if (mVar.a()) {
                        int iA20 = mVar.a(8) + 1;
                        for (int i32 = 0; i32 < iA20; i32++) {
                            int i33 = i3 - 1;
                            int i34 = 0;
                            for (int i35 = i33; i35 > 0; i35 >>>= 1) {
                                i34++;
                            }
                            mVar.b(i34);
                            int i36 = 0;
                            while (i33 > 0) {
                                i36++;
                                i33 >>>= 1;
                            }
                            mVar.b(i36);
                        }
                    }
                    if (mVar.a(2) != 0) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("to reserved bits must be zero after mapping coupling steps");
                    }
                    if (iA19 > 1) {
                        for (int i37 = 0; i37 < i3; i37++) {
                            mVar.b(4);
                        }
                    }
                    for (int i38 = 0; i38 < iA19; i38++) {
                        mVar.b(8);
                        mVar.b(8);
                        mVar.b(8);
                    }
                }
            }
            int iA21 = mVar.a(6);
            int i39 = iA21 + 1;
            q[] qVarArr = new q[i39];
            for (int i40 = 0; i40 < i39; i40++) {
                boolean zA2 = mVar.a();
                mVar.a(16);
                mVar.a(16);
                mVar.a(8);
                qVarArr[i40] = new q(zA2);
            }
            if (mVar.a()) {
                int i41 = 0;
                while (iA21 > 0) {
                    i41++;
                    iA21 >>>= 1;
                }
                nVar2 = new n(this.q, bArr, qVarArr, i41);
            } else {
                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("framing bit after modes not set as expected");
            }
        }
        this.n = nVar2;
        if (nVar2 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.n.f2064a.f);
        arrayList.add(this.n.b);
        r rVar = this.n.f2064a;
        jVar.f2061a = com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, "audio/vorbis", rVar.c, -1, rVar.f2066a, (int) rVar.b, arrayList, null, null);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final void a(long j) {
        this.g = j;
        this.p = j != 0;
        r rVar = this.q;
        this.o = rVar != null ? rVar.d : 0;
    }
}
