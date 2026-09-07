package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes12.dex */
public final class n {
    public static final int b = z.a("ID3");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.l f2114a;

    public n() {
        this.f2114a = null;
    }

    public static int a(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static h b(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, int i2, boolean z, int i3, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) {
        int i4 = nVar.b;
        int iB = b(i4, nVar.f2184a);
        String str = new String(nVar.f2184a, i4, iB - i4, C.ISO88591_NAME);
        nVar.e(iB + 1);
        int iJ = nVar.j();
        boolean z2 = (iJ & 2) != 0;
        boolean z3 = (iJ & 1) != 0;
        int iJ2 = nVar.j();
        String[] strArr = new String[iJ2];
        for (int i5 = 0; i5 < iJ2; i5++) {
            int i6 = nVar.b;
            int iB2 = b(i6, nVar.f2184a);
            strArr[i5] = new String(nVar.f2184a, i6, iB2 - i6, C.ISO88591_NAME);
            nVar.e(iB2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = i4 + i;
        while (nVar.b < i7) {
            o oVarA = a(i2, nVar, z, i3, lVar);
            if (oVarA != null) {
                arrayList.add(oVarA);
            }
        }
        o[] oVarArr = new o[arrayList.size()];
        arrayList.toArray(oVarArr);
        return new h(str, z2, z3, strArr, oVarArr);
    }

    public static q c(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        byte[] bArr = new byte[i];
        nVar.a(bArr, 0, i);
        int iB = b(0, bArr);
        String str = new String(bArr, 0, iB, C.ISO88591_NAME);
        int i2 = iB + 1;
        return new q(str, i2 < i ? Arrays.copyOfRange(bArr, i2, i) : new byte[0]);
    }

    public static s d(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        if (i < 1) {
            return null;
        }
        int iJ = nVar.j();
        String strB = b(iJ);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        nVar.a(bArr, 0, i2);
        int iA = a(bArr, 0, iJ);
        String str = new String(bArr, 0, iA, strB);
        int iA2 = a(iJ) + iA;
        return new s("TXXX", str, iA2 < i2 ? new String(bArr, iA2, a(bArr, iA2, iJ) - iA2, strB) : "");
    }

    public static u e(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        if (i < 1) {
            return null;
        }
        int iJ = nVar.j();
        String strB = b(iJ);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        nVar.a(bArr, 0, i2);
        int iA = a(bArr, 0, iJ);
        String str = new String(bArr, 0, iA, strB);
        int iA2 = a(iJ) + iA;
        return new u("WXXX", str, iA2 < i2 ? new String(bArr, iA2, b(iA2, bArr) - iA2, C.ISO88591_NAME) : "");
    }

    public static int f(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        byte[] bArr = nVar.f2184a;
        int i2 = nVar.b;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= i) {
                return i;
            }
            if ((bArr[i2] & 255) == 255 && bArr[i3] == 0) {
                System.arraycopy(bArr, i2 + 2, bArr, i3, (i - i2) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008e  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00ea A[SYNTHETIC] */
    public final com.fyber.inneractive.sdk.player.exoplayer2.metadata.b a(int i, byte[] bArr) {
        boolean z;
        m mVar;
        int i2;
        int iF;
        o oVarA;
        ArrayList arrayList = new ArrayList();
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(i, bArr);
        boolean z2 = false;
        if (i - nVar.b < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int iL = nVar.l();
            if (iL == b) {
                int iJ = nVar.j();
                nVar.e(nVar.b + 1);
                int iJ2 = nVar.j();
                int i3 = nVar.i();
                if (iJ != 2) {
                    if (iJ == 3) {
                        if ((iJ2 & 64) != 0) {
                            int iB = nVar.b();
                            nVar.e(nVar.b + iB);
                            i3 -= iB + 4;
                        }
                    } else if (iJ == 4) {
                        if ((iJ2 & 64) != 0) {
                            int i4 = nVar.i();
                            nVar.e(nVar.b + (i4 - 4));
                            i3 -= i4;
                        }
                        if ((iJ2 & 16) != 0) {
                            i3 -= 10;
                        }
                    } else {
                        Log.w("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iJ);
                    }
                    if (iJ < 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    mVar = new m(z, iJ, i3);
                } else if ((iJ2 & 64) != 0) {
                    Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                } else {
                    if (iJ < 4 || (iJ2 & 128) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    mVar = new m(z, iJ, i3);
                }
                if (mVar == null) {
                    return null;
                }
                int i5 = nVar.b;
                i2 = mVar.f2113a == 2 ? 6 : 10;
                iF = mVar.c;
                if (mVar.b) {
                    iF = f(iF, nVar);
                }
                nVar.d(i5 + iF);
                if (!a(nVar, mVar.f2113a, i2, false)) {
                    if (mVar.f2113a == 4 || !a(nVar, 4, i2, true)) {
                        Log.w("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + mVar.f2113a);
                        return null;
                    }
                    z2 = true;
                }
                while (nVar.c - nVar.b >= i2) {
                    oVarA = a(mVar.f2113a, nVar, z2, i2, this.f2114a);
                    if (oVarA != null) {
                        arrayList.add(oVarA);
                    }
                }
                return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.b(arrayList);
            }
            Log.w("Id3Decoder", "Unexpected first three bytes of ID3 tag header: " + iL);
        }
        mVar = null;
        if (mVar == null) {
            return null;
        }
        int i6 = nVar.b;
        if (mVar.f2113a == 2) {
        }
        iF = mVar.c;
        if (mVar.b) {
            iF = f(iF, nVar);
        }
        nVar.d(i6 + iF);
        if (!a(nVar, mVar.f2113a, i2, false)) {
            if (mVar.f2113a == 4) {
            }
            Log.w("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + mVar.f2113a);
            return null;
        }
        while (nVar.c - nVar.b >= i2) {
            oVarA = a(mVar.f2113a, nVar, z2, i2, this.f2114a);
            if (oVarA != null) {
                arrayList.add(oVarA);
            }
        }
        return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.b(arrayList);
    }

    public n(com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) {
        this.f2114a = lVar;
    }

    public static u b(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, String str) {
        byte[] bArr = new byte[i];
        nVar.a(bArr, 0, i);
        return new u(str, null, new String(bArr, 0, b(0, bArr), C.ISO88591_NAME));
    }

    public static l b(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int iJ = nVar.j();
        String strB = b(iJ);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        nVar.a(bArr, 0, i2);
        int iB = b(0, bArr);
        String str = new String(bArr, 0, iB, C.ISO88591_NAME);
        int i3 = iB + 1;
        int iA = a(bArr, i3, iJ);
        String str2 = new String(bArr, i3, iA - i3, strB);
        int iA2 = a(iJ) + iA;
        int iA3 = a(bArr, iA2, iJ);
        return new l(str, str2, new String(bArr, iA2, iA3 - iA2, strB), Arrays.copyOfRange(bArr, a(iJ) + iA3, i2));
    }

    public static f a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, int i2, boolean z, int i3, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) {
        int i4 = nVar.b;
        int iB = b(i4, nVar.f2184a);
        String str = new String(nVar.f2184a, i4, iB - i4, C.ISO88591_NAME);
        nVar.e(iB + 1);
        int iB2 = nVar.b();
        int iB3 = nVar.b();
        long jK = nVar.k();
        long j = jK == 4294967295L ? -1L : jK;
        long jK2 = nVar.k();
        long j2 = jK2 == 4294967295L ? -1L : jK2;
        ArrayList arrayList = new ArrayList();
        int i5 = i4 + i;
        while (nVar.b < i5) {
            o oVarA = a(i2, nVar, z, i3, lVar);
            if (oVarA != null) {
                arrayList.add(oVarA);
            }
        }
        o[] oVarArr = new o[arrayList.size()];
        arrayList.toArray(oVarArr);
        return new f(str, iB2, iB3, j, j2, oVarArr);
    }

    public static String b(int i) {
        if (i == 1) {
            return "UTF-16";
        }
        if (i == 2) {
            return "UTF-16BE";
        }
        if (i != 3) {
            return C.ISO88591_NAME;
        }
        return "UTF-8";
    }

    public static int b(int i, byte[] bArr) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0086 A[PHI: r3
  0x0086: PHI (r3v17 int) = (r3v6 int), (r3v20 int) binds: [B:39:0x0083, B:31:0x0075] A[DONT_GENERATE, DONT_INLINE]] */
    public static boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, int i2, boolean z) {
        int iL;
        long jL;
        int iO;
        int i3;
        int i4 = nVar.b;
        while (true) {
            try {
                boolean z2 = true;
                if (nVar.c - nVar.b < i2) {
                    nVar.e(i4);
                    return true;
                }
                if (i >= 3) {
                    iL = nVar.b();
                    jL = nVar.k();
                    iO = nVar.o();
                } else {
                    iL = nVar.l();
                    jL = nVar.l();
                    iO = 0;
                }
                if (iL == 0 && jL == 0 && iO == 0) {
                    nVar.e(i4);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & jL) != 0) {
                        nVar.e(i4);
                        return false;
                    }
                    jL = (((jL >> 24) & 255) << 21) | (jL & 255) | (((jL >> 8) & 255) << 7) | (((jL >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (iO & 64) != 0 ? 1 : 0;
                    if ((iO & 1) == 0) {
                        z2 = false;
                    }
                } else if (i == 3) {
                    i3 = (iO & 32) != 0 ? 1 : 0;
                    if ((iO & 128) == 0) {
                        z2 = false;
                    }
                } else {
                    i3 = 0;
                    z2 = false;
                }
                if (z2) {
                    i3 += 4;
                }
                if (jL < i3) {
                    nVar.e(i4);
                    return false;
                }
                int i5 = nVar.c;
                int i6 = nVar.b;
                if (i5 - i6 < jL) {
                    nVar.e(i4);
                    return false;
                }
                nVar.e(i6 + ((int) jL));
            } catch (Throwable th) {
                nVar.e(i4);
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0199  */
    /* JADX WARN: Code duplicated, block: B:152:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:154:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:159:0x01e1 A[Catch: all -> 0x0135, UnsupportedEncodingException -> 0x0216, TryCatch #1 {all -> 0x0135, blocks: (B:93:0x0123, B:161:0x01f4, B:164:0x0216, B:95:0x012a, B:106:0x0147, B:108:0x014e, B:116:0x0167, B:125:0x017c, B:136:0x0194, B:143:0x01a5, B:151:0x01c0, B:158:0x01d0, B:159:0x01e1), top: B:172:0x0119 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x01f4 A[Catch: all -> 0x0135, UnsupportedEncodingException -> 0x0216, TRY_LEAVE, TryCatch #1 {all -> 0x0135, blocks: (B:93:0x0123, B:161:0x01f4, B:164:0x0216, B:95:0x012a, B:106:0x0147, B:108:0x014e, B:116:0x0167, B:125:0x017c, B:136:0x0194, B:143:0x01a5, B:151:0x01c0, B:158:0x01d0, B:159:0x01e1), top: B:172:0x0119 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.lang.String] */
    public static o a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, boolean z, int i2, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) {
        int iL;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        o dVar;
        int iJ = nVar.j();
        int iJ2 = nVar.j();
        int iJ3 = nVar.j();
        int iJ4 = i >= 3 ? nVar.j() : 0;
        if (i == 4) {
            iL = nVar.m();
            if (!z) {
                iL = (((iL >> 24) & 255) << 21) | (iL & 255) | (((iL >> 8) & 255) << 7) | (((iL >> 16) & 255) << 14);
            }
        } else if (i == 3) {
            iL = nVar.m();
        } else {
            iL = nVar.l();
        }
        int iO = i >= 3 ? nVar.o() : 0;
        if (iJ == 0 && iJ2 == 0 && iJ3 == 0 && iJ4 == 0 && iL == 0 && iO == 0) {
            nVar.e(nVar.c);
            return null;
        }
        int i3 = nVar.b;
        int i4 = i3 + iL;
        if (i4 > nVar.c) {
            Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
            nVar.e(nVar.c);
            return null;
        }
        String str = 67;
        if (lVar != null && (iJ != 67 || iJ2 != 79 || iJ3 != 77 || (iJ4 != 77 && i != 2))) {
            nVar.e(i4);
            return null;
        }
        if (i == 3) {
            z3 = (iO & 128) != 0;
            boolean z7 = (iO & 64) != 0;
            z2 = (iO & 32) != 0;
            z5 = z7;
            z6 = false;
            z4 = z3;
        } else if (i == 4) {
            boolean z8 = (iO & 64) != 0;
            boolean z9 = (iO & 8) != 0;
            z5 = (iO & 4) != 0;
            z6 = (iO & 2) != 0;
            if ((iO & 1) != 0) {
                z2 = z8;
                z3 = z9;
                z4 = true;
            } else {
                z2 = z8;
                z3 = z9;
                z4 = false;
            }
        } else {
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
        }
        if (!z3 && !z5) {
            if (z2) {
                iL--;
                nVar.e(i3 + 1);
            }
            if (z4) {
                iL -= 4;
                nVar.e(nVar.b + 4);
            }
            if (z6) {
                iL = f(iL, nVar);
            }
            int i5 = iL;
            try {
                try {
                    try {
                        if (iJ == 84 && iJ2 == 88 && iJ3 == 88 && (i == 2 || iJ4 == 88)) {
                            dVar = d(i5, nVar);
                        } else if (iJ == 84) {
                            dVar = a(i5, nVar, a(i, iJ, iJ2, iJ3, iJ4));
                        } else if (iJ == 87 && iJ2 == 88 && iJ3 == 88 && (i == 2 || iJ4 == 88)) {
                            dVar = e(i5, nVar);
                        } else if (iJ == 87) {
                            dVar = b(i5, nVar, a(i, iJ, iJ2, iJ3, iJ4));
                        } else if (iJ == 80 && iJ2 == 82 && iJ3 == 73 && iJ4 == 86) {
                            dVar = c(i5, nVar);
                        } else if (iJ == 71 && iJ2 == 69 && iJ3 == 79 && (iJ4 == 66 || i == 2)) {
                            dVar = b(i5, nVar);
                        } else {
                            if (i == 2) {
                                if (iJ == 80 && iJ2 == 73 && iJ3 == 67) {
                                    dVar = a(nVar, i5, i);
                                } else if (iJ != 67 && iJ2 == 79 && iJ3 == 77 && (iJ4 == 77 || i == 2)) {
                                    dVar = a(i5, nVar);
                                } else if (iJ != 67 && iJ2 == 72 && iJ3 == 65 && iJ4 == 80) {
                                    str = "Id3Decoder";
                                    dVar = a(nVar, i5, i, z, i2, lVar);
                                } else if (iJ != 67 && iJ2 == 84 && iJ3 == 79 && iJ4 == 67) {
                                    str = "Id3Decoder";
                                    dVar = b(nVar, i5, i, z, i2, lVar);
                                } else {
                                    str = "Id3Decoder";
                                    String strA = a(i, iJ, iJ2, iJ3, iJ4);
                                    byte[] bArr = new byte[i5];
                                    nVar.a(bArr, 0, i5);
                                    dVar = new d(strA, bArr);
                                }
                            } else if (iJ == 65 && iJ2 == 80 && iJ3 == 73 && iJ4 == 67) {
                                dVar = a(nVar, i5, i);
                            } else {
                                if (iJ != 67) {
                                }
                                if (iJ != 67) {
                                    if (iJ != 67) {
                                        str = "Id3Decoder";
                                        String strA2 = a(i, iJ, iJ2, iJ3, iJ4);
                                        byte[] bArr2 = new byte[i5];
                                        nVar.a(bArr2, 0, i5);
                                        dVar = new d(strA2, bArr2);
                                    } else {
                                        str = "Id3Decoder";
                                        String strA3 = a(i, iJ, iJ2, iJ3, iJ4);
                                        byte[] bArr3 = new byte[i5];
                                        nVar.a(bArr3, 0, i5);
                                        dVar = new d(strA3, bArr3);
                                    }
                                } else if (iJ != 67) {
                                    str = "Id3Decoder";
                                    String strA4 = a(i, iJ, iJ2, iJ3, iJ4);
                                    byte[] bArr4 = new byte[i5];
                                    nVar.a(bArr4, 0, i5);
                                    dVar = new d(strA4, bArr4);
                                } else {
                                    str = "Id3Decoder";
                                    String strA5 = a(i, iJ, iJ2, iJ3, iJ4);
                                    byte[] bArr5 = new byte[i5];
                                    nVar.a(bArr5, 0, i5);
                                    dVar = new d(strA5, bArr5);
                                }
                            }
                            if (dVar == null) {
                                Log.w((String) str, "Failed to decode frame: id=" + a(i, iJ, iJ2, iJ3, iJ4) + ", frameSize=" + i5);
                            }
                            nVar.e(i4);
                            return dVar;
                        }
                        str = "Id3Decoder";
                        if (dVar == null) {
                            Log.w((String) str, "Failed to decode frame: id=" + a(i, iJ, iJ2, iJ3, iJ4) + ", frameSize=" + i5);
                        }
                        nVar.e(i4);
                        return dVar;
                    } catch (UnsupportedEncodingException unused) {
                        Log.w(str, "Unsupported character encoding");
                        nVar.e(i4);
                        return null;
                    }
                } catch (Throwable th) {
                    nVar.e(i4);
                    throw th;
                }
            } catch (UnsupportedEncodingException unused2) {
                str = "Id3Decoder";
                Log.w(str, "Unsupported character encoding");
                nVar.e(i4);
                return null;
            }
        }
        Log.w("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
        nVar.e(i4);
        return null;
    }

    public static s a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, String str) {
        if (i < 1) {
            return null;
        }
        int iJ = nVar.j();
        String strB = b(iJ);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        nVar.a(bArr, 0, i2);
        return new s(str, null, new String(bArr, 0, a(bArr, 0, iJ), strB));
    }

    public static b a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, int i2) {
        int iB;
        String strConcat;
        int iJ = nVar.j();
        String strB = b(iJ);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        nVar.a(bArr, 0, i3);
        if (i2 == 2) {
            strConcat = "image/" + new String(bArr, 0, 3, C.ISO88591_NAME).toLowerCase(Locale.US);
            if (strConcat.equals("image/jpg")) {
                strConcat = "image/jpeg";
            }
            iB = 2;
        } else {
            iB = b(0, bArr);
            String lowerCase = new String(bArr, 0, iB, C.ISO88591_NAME).toLowerCase(Locale.US);
            strConcat = lowerCase.indexOf(47) == -1 ? "image/".concat(lowerCase) : lowerCase;
        }
        int i4 = bArr[iB + 1] & 255;
        int i5 = iB + 2;
        int iA = a(bArr, i5, iJ);
        return new b(strConcat, new String(bArr, i5, iA - i5, strB), i4, Arrays.copyOfRange(bArr, a(iJ) + iA, i3));
    }

    public static j a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        String str;
        if (i < 4) {
            return null;
        }
        int iJ = nVar.j();
        String strB = b(iJ);
        byte[] bArr = new byte[3];
        nVar.a(bArr, 0, 3);
        String str2 = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        nVar.a(bArr2, 0, i2);
        int iA = a(bArr2, 0, iJ);
        String str3 = new String(bArr2, 0, iA, strB);
        int iA2 = a(iJ) + iA;
        if (iA2 < i2) {
            str = new String(bArr2, iA2, a(bArr2, iA2, iJ) - iA2, strB);
        } else {
            str = "";
        }
        return new j(str2, str3, str);
    }

    public static String a(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static int a(byte[] bArr, int i, int i2) {
        int iB = b(i, bArr);
        if (i2 == 0 || i2 == 3) {
            return iB;
        }
        while (iB < bArr.length - 1) {
            if (iB % 2 == 0 && bArr[iB + 1] == 0) {
                return iB;
            }
            iB = b(iB + 1, bArr);
        }
        return bArr.length;
    }
}
