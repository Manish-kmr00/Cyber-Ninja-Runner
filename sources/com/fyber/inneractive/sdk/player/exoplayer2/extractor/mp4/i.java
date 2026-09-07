package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.adjust.sdk.Constants;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2040a = z.a("vide");
    public static final int b = z.a("soun");
    public static final int c = z.a("text");
    public static final int d = z.a("sbtl");
    public static final int e = z.a("subt");
    public static final int f = z.a("clcp");
    public static final int g = z.a("cenc");
    public static final int h = z.a(Constants.REFERRER_API_META);

    /* JADX WARN: Code duplicated, block: B:280:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:282:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:432:0x050a A[SYNTHETIC] */
    public static s a(a aVar, b bVar, long j, com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVar, boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        int i;
        long jK;
        int i2;
        s sVar;
        Pair pairCreate;
        b bVarC;
        long j2;
        boolean z2;
        List list;
        int i3;
        int iIntValue;
        int iIntValue2;
        String str;
        int i4;
        String str2;
        int i5;
        String str3;
        String str4;
        String str5;
        long j3;
        List listSingletonList;
        a aVarB = aVar.b(c.F);
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = aVarB.c(c.T).P0;
        nVar.e(16);
        int iB = nVar.b();
        if (iB == b) {
            i = 1;
        } else if (iB == f2040a) {
            i = 2;
        } else if (iB == c || iB == d || iB == e || iB == f) {
            i = 3;
        } else {
            i = iB == h ? 4 : -1;
        }
        if (i == -1) {
            return null;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = aVar.c(c.P).P0;
        nVar2.e(8);
        int iB2 = (nVar2.b() >> 24) & 255;
        nVar2.e(nVar2.b + (iB2 == 0 ? 8 : 16));
        int iB3 = nVar2.b();
        nVar2.e(nVar2.b + 4);
        int i6 = nVar2.b;
        int i7 = iB2 == 0 ? 4 : 8;
        int i8 = 0;
        while (true) {
            if (i8 >= i7) {
                nVar2.e(nVar2.b + i7);
            } else {
                if (nVar2.f2184a[i6 + i8] != -1) {
                    jK = iB2 == 0 ? nVar2.k() : nVar2.n();
                    if (jK != 0) {
                        break;
                    }
                    break;
                }
                i8++;
            }
            jK = -9223372036854775807L;
            break;
        }
        nVar2.e(nVar2.b + 16);
        int iB4 = nVar2.b();
        int iB5 = nVar2.b();
        nVar2.e(nVar2.b + 4);
        int iB6 = nVar2.b();
        int iB7 = nVar2.b();
        if (iB4 == 0 && iB5 == 65536 && iB6 == -65536 && iB7 == 0) {
            i2 = 90;
        } else if (iB4 == 0 && iB5 == -65536 && iB6 == 65536 && iB7 == 0) {
            i2 = 270;
        } else {
            i2 = (iB4 == -65536 && iB5 == 0 && iB6 == 0 && iB7 == -65536) ? 180 : 0;
        }
        long j4 = j == -9223372036854775807L ? jK : j;
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = bVar.P0;
        nVar3.e(8);
        int iB8 = nVar3.b();
        int i9 = c.b;
        nVar3.e(nVar3.b + (((iB8 >> 24) & 255) == 0 ? 8 : 16));
        long jK2 = nVar3.k();
        long jA = j4 != -9223372036854775807L ? z.a(j4, 1000000L, jK2) : -9223372036854775807L;
        a aVarB2 = aVarB.b(c.G).b(c.H);
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar4 = aVarB.c(c.S).P0;
        nVar4.e(8);
        int iB9 = (nVar4.b() >> 24) & 255;
        nVar4.e(nVar4.b + (iB9 == 0 ? 8 : 16));
        long jK3 = nVar4.k();
        nVar4.e(nVar4.b + (iB9 == 0 ? 4 : 8));
        int iO = nVar4.o();
        Pair pairCreate2 = Pair.create(Long.valueOf(jK3), "" + ((char) (((iO >> 10) & 31) + 96)) + ((char) (((iO >> 5) & 31) + 96)) + ((char) ((iO & 31) + 96)));
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar5 = aVarB2.c(c.U).P0;
        String str6 = (String) pairCreate2.second;
        nVar5.e(12);
        int iB10 = nVar5.b();
        f fVar = new f(iB10);
        int i10 = 0;
        while (i10 < iB10) {
            int i11 = nVar5.b;
            int iB11 = nVar5.b();
            String str7 = "childAtomSize should be positive";
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(iB11 > 0, "childAtomSize should be positive");
            int iB12 = nVar5.b();
            int i12 = iB10;
            if (iB12 == c.c || iB12 == c.d || iB12 == c.a0 || iB12 == c.l0 || iB12 == c.e || iB12 == c.f || iB12 == c.g || iB12 == c.K0 || iB12 == c.L0) {
                pairCreate2 = pairCreate2;
                Object obj = "childAtomSize should be positive";
                i2 = i2;
                j2 = jK2;
                i = i;
                int i13 = i10;
                nVar5.e(i11 + 16);
                nVar5.e(nVar5.b + 16);
                int iO2 = nVar5.o();
                int iO3 = nVar5.o();
                nVar5.e(nVar5.b + 50);
                int i14 = nVar5.b;
                iB11 = iB11;
                if (iB12 == c.a0) {
                    i10 = i13;
                    iB12 = a(nVar5, i11, iB11, fVar, i10);
                    nVar5.e(i14);
                } else {
                    i10 = i13;
                }
                int i15 = -1;
                float fM = 1.0f;
                boolean z3 = false;
                String str8 = null;
                List listSingletonList2 = null;
                byte[] bArrCopyOfRange = null;
                while (i14 - i11 < iB11) {
                    nVar5.e(i14);
                    int i16 = nVar5.b;
                    int iB13 = nVar5.b();
                    if (iB13 == 0 && nVar5.b - i11 == iB11) {
                        break;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(iB13 > 0, obj);
                    int iB14 = nVar5.b();
                    if (iB14 != c.I) {
                        if (iB14 != c.J) {
                            if (iB14 == c.M0) {
                                if (str8 != null) {
                                    throw new IllegalStateException();
                                }
                                str8 = iB12 == c.K0 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                            } else if (iB14 == c.h) {
                                if (str8 != null) {
                                    throw new IllegalStateException();
                                }
                                str8 = "video/3gpp";
                            } else if (iB14 == c.K) {
                                if (str8 != null) {
                                    throw new IllegalStateException();
                                }
                                Pair pairA = a(i16, nVar5);
                                str8 = (String) pairA.first;
                                listSingletonList2 = Collections.singletonList((byte[]) pairA.second);
                            } else if (iB14 == c.j0) {
                                nVar5.e(i16 + 8);
                                fM = nVar5.m() / nVar5.m();
                                z2 = true;
                            } else if (iB14 != c.I0) {
                                z2 = z3;
                                if (iB14 != c.H0) {
                                    break;
                                    break;
                                }
                                int iJ = nVar5.j();
                                nVar5.e(nVar5.b + 3);
                                if (iJ == 0) {
                                    int iJ2 = nVar5.j();
                                    if (iJ2 == 0) {
                                        i15 = 0;
                                    } else if (iJ2 == 1) {
                                        i15 = 1;
                                    } else if (iJ2 == 2) {
                                        i15 = 2;
                                    } else if (iJ2 == 3) {
                                        i15 = 3;
                                    }
                                }
                            } else {
                                int i17 = i16 + 8;
                                while (true) {
                                    if (i17 - i16 >= iB13) {
                                        z2 = z3;
                                        bArrCopyOfRange = null;
                                        break;
                                    }
                                    nVar5.e(i17);
                                    int iB15 = nVar5.b();
                                    z2 = z3;
                                    if (nVar5.b() == c.J0) {
                                        bArrCopyOfRange = Arrays.copyOfRange(nVar5.f2184a, i17, iB15 + i17);
                                        break;
                                    }
                                    i17 += iB15;
                                    z3 = z2;
                                }
                            }
                            z2 = z3;
                            break;
                            break;
                        }
                        if (str8 != null) {
                            throw new IllegalStateException();
                        }
                        nVar5.e(i16 + 8);
                        com.fyber.inneractive.sdk.player.exoplayer2.video.d dVarA = com.fyber.inneractive.sdk.player.exoplayer2.video.d.a(nVar5);
                        list = dVarA.f2196a;
                        fVar.c = dVarA.b;
                        str8 = "video/hevc";
                        i14 += iB13;
                        z3 = z2;
                        obj = obj;
                    } else {
                        if (str8 != null) {
                            throw new IllegalStateException();
                        }
                        nVar5.e(i16 + 8);
                        com.fyber.inneractive.sdk.player.exoplayer2.video.a aVarA = com.fyber.inneractive.sdk.player.exoplayer2.video.a.a(nVar5);
                        list = aVarA.f2194a;
                        fVar.c = aVarA.b;
                        if (!z3) {
                            fM = aVarA.e;
                        }
                        str8 = "video/avc";
                    }
                    z2 = z3;
                    listSingletonList2 = list;
                    break;
                    i14 += iB13;
                    z3 = z2;
                    obj = obj;
                }
                if (str8 != null) {
                    fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(Integer.toString(iB3), str8, -1, iO2, iO3, listSingletonList2, i2, fM, bArrCopyOfRange, i15, null, dVar);
                }
            } else if (iB12 == c.j || iB12 == c.b0 || iB12 == c.o || iB12 == c.q || iB12 == c.s || iB12 == c.v || iB12 == c.t || iB12 == c.u || iB12 == c.y0 || iB12 == c.z0 || iB12 == c.m || iB12 == c.n || iB12 == c.k || iB12 == c.O0) {
                nVar5.e(i11 + 16);
                if (z) {
                    int iO4 = nVar5.o();
                    nVar5.e(nVar5.b + 6);
                    i3 = iO4;
                } else {
                    nVar5.e(nVar5.b + 8);
                    i3 = 0;
                }
                j2 = jK2;
                if (i3 == 0 || i3 == 1) {
                    int iO5 = nVar5.o();
                    nVar5.e(nVar5.b + 6);
                    byte[] bArr = nVar5.f2184a;
                    int i18 = nVar5.b;
                    int i19 = i18 + 1;
                    nVar5.b = i19;
                    int i20 = (bArr[i18] & 255) << 8;
                    nVar5.b = i18 + 2;
                    iIntValue = i20 | (bArr[i19] & 255);
                    nVar5.b = i18 + 4;
                    if (i3 == 1) {
                        nVar5.e(i18 + 20);
                    }
                    iIntValue2 = iO5;
                } else if (i3 == 2) {
                    nVar5.e(nVar5.b + 16);
                    iIntValue = (int) Math.round(Double.longBitsToDouble(nVar5.g()));
                    iIntValue2 = nVar5.m();
                    nVar5.e(nVar5.b + 20);
                }
                int i21 = nVar5.b;
                if (iB12 == c.b0) {
                    iB12 = a(nVar5, i11, iB11, fVar, i10);
                    nVar5.e(i21);
                }
                if (iB12 == c.o) {
                    str = "audio/ac3";
                } else if (iB12 == c.q) {
                    str = "audio/eac3";
                } else if (iB12 == c.s) {
                    str = "audio/vnd.dts";
                } else if (iB12 == c.t || iB12 == c.u) {
                    str = "audio/vnd.dts.hd";
                } else if (iB12 == c.v) {
                    str = "audio/vnd.dts.hd;profile=lbr";
                } else if (iB12 == c.y0) {
                    str = "audio/3gpp";
                } else if (iB12 == c.z0) {
                    str = "audio/amr-wb";
                } else if (iB12 == c.m || iB12 == c.n) {
                    str = "audio/raw";
                } else if (iB12 == c.k) {
                    str = "audio/mpeg";
                } else {
                    str = iB12 == c.O0 ? "audio/alac" : null;
                }
                byte[] bArr2 = null;
                while (i21 - i11 < iB11) {
                    nVar5.e(i21);
                    int iB16 = nVar5.b();
                    int i22 = i2;
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(iB16 > 0, str7);
                    int iB17 = nVar5.b();
                    int i23 = iB11;
                    int i24 = c.K;
                    int i25 = i10;
                    if (iB17 == i24 || (z && iB17 == c.l)) {
                        if (iB17 == i24) {
                            i4 = i21;
                            str2 = str7;
                        } else {
                            i4 = nVar5.b;
                            while (true) {
                                if (i4 - i21 >= iB16) {
                                    str2 = str7;
                                    i5 = -1;
                                    i4 = -1;
                                    break;
                                }
                                nVar5.e(i4);
                                int iB18 = nVar5.b();
                                com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(iB18 > 0, str7);
                                str2 = str7;
                                if (nVar5.b() != c.K) {
                                    i4 += iB18;
                                    str7 = str2;
                                }
                            }
                            if (i4 != i5) {
                                Pair pairA2 = a(i4, nVar5);
                                str3 = (String) pairA2.first;
                                bArr2 = (byte[]) pairA2.second;
                                if ("audio/mp4a-latm".equals(str3)) {
                                    Pair pairA3 = com.fyber.inneractive.sdk.player.exoplayer2.util.d.a(bArr2);
                                    iIntValue = ((Integer) pairA3.first).intValue();
                                    iIntValue2 = ((Integer) pairA3.second).intValue();
                                }
                                str = str3;
                            }
                        }
                        i5 = -1;
                        if (i4 != i5) {
                            Pair pairA4 = a(i4, nVar5);
                            str3 = (String) pairA4.first;
                            bArr2 = (byte[]) pairA4.second;
                            if ("audio/mp4a-latm".equals(str3)) {
                                Pair pairA5 = com.fyber.inneractive.sdk.player.exoplayer2.util.d.a(bArr2);
                                iIntValue = ((Integer) pairA5.first).intValue();
                                iIntValue2 = ((Integer) pairA5.second).intValue();
                            }
                            str = str3;
                        }
                    } else {
                        if (iB17 == c.p) {
                            nVar5.e(i21 + 8);
                            String string = Integer.toString(iB3);
                            int i26 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.b[(nVar5.j() & 192) >> 6];
                            int iJ3 = nVar5.j();
                            int i27 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.d[(iJ3 & 56) >> 3];
                            if ((iJ3 & 4) != 0) {
                                i27++;
                            }
                            fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(string, "audio/ac3", -1, -1, i27, i26, null, dVar, str6);
                        } else if (iB17 == c.r) {
                            nVar5.e(i21 + 8);
                            String string2 = Integer.toString(iB3);
                            nVar5.e(nVar5.b + 2);
                            int i28 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.b[(nVar5.j() & 192) >> 6];
                            int iJ4 = nVar5.j();
                            int i29 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.d[(iJ4 & 14) >> 1];
                            if ((iJ4 & 1) != 0) {
                                i29++;
                            }
                            fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(string2, "audio/eac3", -1, -1, i29, i28, null, dVar, str6);
                        } else if (iB17 == c.w) {
                            fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(Integer.toString(iB3), str, -1, -1, iIntValue2, iIntValue, null, dVar, str6);
                        } else if (iB17 == c.O0) {
                            bArr2 = new byte[iB16];
                            nVar5.e(i21);
                            nVar5.a(bArr2, 0, iB16);
                            str2 = str7;
                        }
                        str2 = str7;
                    }
                    i21 += iB16;
                    str7 = str2;
                    i2 = i22;
                    iB11 = i23;
                    i10 = i25;
                }
                i2 = i2;
                int i30 = iB11;
                int i31 = i10;
                if (fVar.b == null && str != null) {
                    fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(Integer.toString(iB3), str, -1, -1, iIntValue2, iIntValue, "audio/raw".equals(str) ? 2 : -1, -1, -1, bArr2 == null ? null : Collections.singletonList(bArr2), dVar, 0, str6, null);
                }
                iB11 = i30;
                i10 = i31;
            } else {
                int i32 = c.k0;
                if (iB12 == i32 || iB12 == c.u0 || iB12 == c.v0 || iB12 == c.w0 || iB12 == c.x0) {
                    nVar5.e(i11 + 16);
                    if (iB12 == i32) {
                        j3 = Long.MAX_VALUE;
                        listSingletonList = null;
                        str5 = "application/ttml+xml";
                    } else if (iB12 == c.u0) {
                        int i33 = iB11 - 16;
                        byte[] bArr3 = new byte[i33];
                        nVar5.a(bArr3, 0, i33);
                        listSingletonList = Collections.singletonList(bArr3);
                        j3 = Long.MAX_VALUE;
                        str5 = "application/x-quicktime-tx3g";
                    } else {
                        if (iB12 == c.v0) {
                            str4 = "application/x-mp4-vtt";
                        } else if (iB12 == c.w0) {
                            str5 = "application/ttml+xml";
                            j3 = 0;
                            listSingletonList = null;
                        } else {
                            if (iB12 != c.x0) {
                                throw new IllegalStateException();
                            }
                            fVar.d = 1;
                            str4 = "application/x-mp4-cea-608";
                        }
                        j3 = Long.MAX_VALUE;
                        listSingletonList = null;
                        str5 = str4;
                    }
                    fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(Integer.toString(iB3), str5, 0, str6, -1, dVar, j3, listSingletonList);
                } else if (iB12 == c.N0) {
                    fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(Integer.toString(iB3), "application/x-camera-motion", dVar);
                }
                j2 = jK2;
            }
            nVar5.e(i11 + iB11);
            i10++;
            iB10 = i12;
            jK2 = j2;
            i = i;
            pairCreate2 = pairCreate2;
            i2 = i2;
        }
        Pair pair = pairCreate2;
        long j5 = jK2;
        int i34 = i;
        a aVarB3 = aVar.b(c.Q);
        if (aVarB3 == null || (bVarC = aVarB3.c(c.R)) == null) {
            sVar = null;
            pairCreate = Pair.create(null, null);
        } else {
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar6 = bVarC.P0;
            nVar6.e(8);
            int iB19 = (nVar6.b() >> 24) & 255;
            int iM = nVar6.m();
            long[] jArr = new long[iM];
            long[] jArr2 = new long[iM];
            for (int i35 = 0; i35 < iM; i35++) {
                jArr[i35] = iB19 == 1 ? nVar6.n() : nVar6.k();
                jArr2[i35] = iB19 == 1 ? nVar6.g() : nVar6.b();
                byte[] bArr4 = nVar6.f2184a;
                int i36 = nVar6.b;
                int i37 = i36 + 1;
                nVar6.b = i37;
                int i38 = (bArr4[i36] & 255) << 8;
                nVar6.b = i36 + 2;
                if (((short) ((bArr4[i37] & 255) | i38)) != 1) {
                    throw new IllegalArgumentException("Unsupported media rate.");
                }
                nVar6.e(i36 + 4);
            }
            pairCreate = Pair.create(jArr, jArr2);
            sVar = null;
        }
        return fVar.b == null ? sVar : new s(iB3, i34, ((Long) pair.first).longValue(), j5, jA, fVar.b, fVar.d, fVar.f2037a, fVar.c, (long[]) pairCreate.first, (long[]) pairCreate.second);
    }

    public static int a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, int i2, f fVar, int i3) {
        int i4 = nVar.b;
        while (true) {
            if (i4 - i >= i2) {
                return 0;
            }
            nVar.e(i4);
            int iB = nVar.b();
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(iB > 0, "childAtomSize should be positive");
            if (nVar.b() == c.W) {
                int i5 = i4 + 8;
                Pair pairCreate = null;
                boolean z = false;
                Integer numValueOf = null;
                t tVar = null;
                while (i5 - i4 < iB) {
                    nVar.e(i5);
                    int iB2 = nVar.b();
                    int iB3 = nVar.b();
                    if (iB3 == c.c0) {
                        numValueOf = Integer.valueOf(nVar.b());
                    } else if (iB3 == c.X) {
                        nVar.e(nVar.b + 4);
                        z = nVar.b() == g;
                    } else if (iB3 == c.Y) {
                        int i6 = i5 + 8;
                        while (true) {
                            if (i6 - i5 >= iB2) {
                                tVar = null;
                                break;
                            }
                            nVar.e(i6);
                            int iB4 = nVar.b();
                            if (nVar.b() == c.Z) {
                                nVar.e(nVar.b + 6);
                                nVar.j();
                                int iJ = nVar.j();
                                byte[] bArr = new byte[16];
                                nVar.a(bArr, 0, 16);
                                tVar = new t(iJ, bArr);
                                break;
                            }
                            i6 += iB4;
                        }
                    }
                    i5 += iB2;
                }
                if (z) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(numValueOf != null, "frma atom is mandatory");
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(tVar != null, "schi->tenc atom is mandatory");
                    pairCreate = Pair.create(numValueOf, tVar);
                }
                if (pairCreate != null) {
                    fVar.f2037a[i3] = (t) pairCreate.second;
                    return ((Integer) pairCreate.first).intValue();
                }
            }
            i4 += iB;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x008a  */
    public static Pair a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        String str;
        nVar.e(i + 12);
        nVar.e(nVar.b + 1);
        a(nVar);
        nVar.e(nVar.b + 2);
        int iJ = nVar.j();
        if ((iJ & 128) != 0) {
            nVar.e(nVar.b + 2);
        }
        if ((iJ & 64) != 0) {
            nVar.e(nVar.b + nVar.o());
        }
        if ((iJ & 32) != 0) {
            nVar.e(nVar.b + 2);
        }
        nVar.e(nVar.b + 1);
        a(nVar);
        int iJ2 = nVar.j();
        if (iJ2 == 32) {
            str = "video/mp4v-es";
        } else if (iJ2 == 33) {
            str = "video/avc";
        } else if (iJ2 == 35) {
            str = "video/hevc";
        } else if (iJ2 != 64) {
            str = null;
            if (iJ2 == 107) {
                return Pair.create("audio/mpeg", null);
            }
            if (iJ2 == 165) {
                str = "audio/ac3";
            } else if (iJ2 == 166) {
                str = "audio/eac3";
            } else {
                switch (iJ2) {
                    case 102:
                    case 103:
                    case 104:
                        str = "audio/mp4a-latm";
                        break;
                    default:
                        switch (iJ2) {
                            case 169:
                            case 172:
                                return Pair.create("audio/vnd.dts", null);
                            case 170:
                            case 171:
                                return Pair.create("audio/vnd.dts.hd", null);
                        }
                }
            }
        } else {
            str = "audio/mp4a-latm";
        }
        nVar.e(nVar.b + 12);
        nVar.e(nVar.b + 1);
        int iA = a(nVar);
        byte[] bArr = new byte[iA];
        nVar.a(bArr, 0, iA);
        return Pair.create(str, bArr);
    }

    public static int a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int iJ = nVar.j();
        int i = iJ & 127;
        while ((iJ & 128) == 128) {
            iJ = nVar.j();
            i = (i << 7) | (iJ & 127);
        }
        return i;
    }
}
