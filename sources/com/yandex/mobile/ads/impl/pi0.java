package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public final class pi0 extends ly1 {
    public static final a b = new a() { // from class: com.yandex.mobile.ads.impl.pi0$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.pi0.a
        public final boolean a(int i, int i2, int i3, int i4, int i5) {
            return pi0.b(i, i2, i3, i4, i5);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f9929a;

    public interface a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9930a;
        private final boolean b;
        private final int c;

        public b(int i, int i2, boolean z) {
            this.f9930a = i;
            this.b = z;
            this.c = i2;
        }
    }

    private static int a(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    private static u01 c(int i, wf1 wf1Var) {
        int iZ = wf1Var.z();
        int iW = wf1Var.w();
        int iW2 = wf1Var.w();
        int iT = wf1Var.t();
        int iT2 = wf1Var.t();
        vf1 vf1Var = new vf1();
        vf1Var.a(wf1Var.e(), wf1Var.c());
        vf1Var.c(wf1Var.d() * 8);
        int i2 = ((i - 10) * 8) / (iT + iT2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iB = vf1Var.b(iT);
            int iB2 = vf1Var.b(iT2);
            iArr[i3] = iB;
            iArr2[i3] = iB2;
        }
        return new u01(iZ, iW, iW2, iArr, iArr2);
    }

    private static al1 d(int i, wf1 wf1Var) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        wf1Var.a(bArr, 0, i);
        int iB = b(0, bArr);
        String str = new String(bArr, 0, iB, C.ISO88591_NAME);
        int i2 = iB + 1;
        return new al1(str, i <= i2 ? x82.f : Arrays.copyOfRange(bArr, i2, i));
    }

    private static m42 e(int i, wf1 wf1Var) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iT = wf1Var.t();
        String strB = b(iT);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        wf1Var.a(bArr, 0, i2);
        int iA = a(bArr, 0, iT);
        String str = new String(bArr, 0, iA, strB);
        int iA2 = iA + a(iT);
        return new m42("TXXX", str, a(iA2, a(bArr, iA2, iT), strB, bArr));
    }

    private static k82 f(int i, wf1 wf1Var) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iT = wf1Var.t();
        String strB = b(iT);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        wf1Var.a(bArr, 0, i2);
        int iA = a(bArr, 0, iT);
        String str = new String(bArr, 0, iA, strB);
        int iA2 = iA + a(iT);
        return new k82("WXXX", str, a(iA2, b(iA2, bArr), C.ISO88591_NAME, bArr));
    }

    private static int g(int i, wf1 wf1Var) {
        byte[] bArrC = wf1Var.c();
        int iD = wf1Var.d();
        int i2 = iD;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iD + i) {
                return i;
            }
            if ((bArrC[i2] & 255) == 255 && bArrC[i3] == 0) {
                System.arraycopy(bArrC, i2 + 2, bArrC, i3, (i - (i2 - iD)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    public pi0(a aVar) {
        this.f9929a = aVar;
    }

    @Override // com.yandex.mobile.ads.impl.ly1
    protected final g01 a(j01 j01Var, ByteBuffer byteBuffer) {
        return a(byteBuffer.limit(), byteBuffer.array());
    }

    private static he a(int i, int i2, wf1 wf1Var) throws UnsupportedEncodingException {
        int iB;
        String strConcat;
        byte[] bArrCopyOfRange;
        int iT = wf1Var.t();
        String strB = b(iT);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        wf1Var.a(bArr, 0, i3);
        if (i2 == 2) {
            String str = "image/" + fg.b(new String(bArr, 0, 3, C.ISO88591_NAME));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            strConcat = str;
            iB = 2;
        } else {
            iB = b(0, bArr);
            String strB2 = fg.b(new String(bArr, 0, iB, C.ISO88591_NAME));
            strConcat = strB2.indexOf(47) == -1 ? "image/".concat(strB2) : strB2;
        }
        int i4 = bArr[iB + 1] & 255;
        int i5 = iB + 2;
        int iA = a(bArr, i5, iT);
        String str2 = new String(bArr, i5, iA - i5, strB);
        int iA2 = iA + a(iT);
        if (i3 <= iA2) {
            bArrCopyOfRange = x82.f;
        } else {
            bArrCopyOfRange = Arrays.copyOfRange(bArr, iA2, i3);
        }
        return new he(strConcat, str2, i4, bArrCopyOfRange);
    }

    private static io b(wf1 wf1Var, int i, int i2, boolean z, int i3, a aVar) throws UnsupportedEncodingException {
        int iD = wf1Var.d();
        int iB = b(iD, wf1Var.c());
        String str = new String(wf1Var.c(), iD, iB - iD, C.ISO88591_NAME);
        wf1Var.e(iB + 1);
        int iT = wf1Var.t();
        boolean z2 = (iT & 2) != 0;
        boolean z3 = (iT & 1) != 0;
        int iT2 = wf1Var.t();
        String[] strArr = new String[iT2];
        for (int i4 = 0; i4 < iT2; i4++) {
            int iD2 = wf1Var.d();
            int iB2 = b(iD2, wf1Var.c());
            strArr[i4] = new String(wf1Var.c(), iD2, iB2 - iD2, C.ISO88591_NAME);
            wf1Var.e(iB2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = iD + i;
        while (wf1Var.d() < i5) {
            qi0 qi0VarA = a(i2, wf1Var, z, i3, aVar);
            if (qi0VarA != null) {
                arrayList.add(qi0VarA);
            }
        }
        return new io(str, z2, z3, strArr, (qi0[]) arrayList.toArray(new qi0[0]));
    }

    private static ge0 b(int i, wf1 wf1Var) throws UnsupportedEncodingException {
        byte[] bArrCopyOfRange;
        int iT = wf1Var.t();
        String strB = b(iT);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        wf1Var.a(bArr, 0, i2);
        int iB = b(0, bArr);
        String str = new String(bArr, 0, iB, C.ISO88591_NAME);
        int i3 = iB + 1;
        int iA = a(bArr, i3, iT);
        String strA = a(i3, iA, strB, bArr);
        int iA2 = iA + a(iT);
        int iA3 = a(bArr, iA2, iT);
        String strA2 = a(iA2, iA3, strB, bArr);
        int iA4 = iA3 + a(iT);
        if (i2 <= iA4) {
            bArrCopyOfRange = x82.f;
        } else {
            bArrCopyOfRange = Arrays.copyOfRange(bArr, iA4, i2);
        }
        return new ge0(str, strA, strA2, bArrCopyOfRange);
    }

    private static k82 b(int i, wf1 wf1Var, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        wf1Var.a(bArr, 0, i);
        return new k82(str, null, new String(bArr, 0, b(0, bArr), C.ISO88591_NAME));
    }

    private static ho a(wf1 wf1Var, int i, int i2, boolean z, int i3, a aVar) throws UnsupportedEncodingException {
        int iD = wf1Var.d();
        int iB = b(iD, wf1Var.c());
        String str = new String(wf1Var.c(), iD, iB - iD, C.ISO88591_NAME);
        wf1Var.e(iB + 1);
        int iH = wf1Var.h();
        int iH2 = wf1Var.h();
        long jV = wf1Var.v();
        long j = jV == 4294967295L ? -1L : jV;
        long jV2 = wf1Var.v();
        long j2 = jV2 == 4294967295L ? -1L : jV2;
        ArrayList arrayList = new ArrayList();
        int i4 = iD + i;
        while (wf1Var.d() < i4) {
            qi0 qi0VarA = a(i2, wf1Var, z, i3, aVar);
            if (qi0VarA != null) {
                arrayList.add(qi0VarA);
            }
        }
        return new ho(str, iH, iH2, j, j2, (qi0[]) arrayList.toArray(new qi0[0]));
    }

    private static rq a(int i, wf1 wf1Var) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int iT = wf1Var.t();
        String strB = b(iT);
        byte[] bArr = new byte[3];
        wf1Var.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        wf1Var.a(bArr2, 0, i2);
        int iA = a(bArr2, 0, iT);
        String str2 = new String(bArr2, 0, iA, strB);
        int iA2 = iA + a(iT);
        return new rq(str, str2, a(iA2, a(bArr2, iA2, iT), strB, bArr2));
    }

    /* JADX WARN: Code duplicated, block: B:134:0x019d  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:142:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:147:0x01c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:148:0x01ca A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:152:0x01e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:153:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:158:0x01ef A[Catch: all -> 0x012f, UnsupportedEncodingException -> 0x0132, TryCatch #0 {UnsupportedEncodingException -> 0x0132, blocks: (B:91:0x011d, B:160:0x0201, B:93:0x0125, B:103:0x0142, B:105:0x014a, B:113:0x0164, B:122:0x017c, B:133:0x0197, B:140:0x01a9, B:146:0x01b8, B:151:0x01d0, B:157:0x01ea, B:158:0x01ef), top: B:173:0x0113 }] */
    private static qi0 a(int i, wf1 wf1Var, boolean z, int i2, a aVar) {
        int iW;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str;
        qi0 hlVar;
        int iT = wf1Var.t();
        int iT2 = wf1Var.t();
        int iT3 = wf1Var.t();
        int iT4 = i >= 3 ? wf1Var.t() : 0;
        if (i == 4) {
            iW = wf1Var.x();
            if (!z) {
                iW = (((iW >> 24) & 255) << 21) | (iW & 255) | (((iW >> 8) & 255) << 7) | (((iW >> 16) & 255) << 14);
            }
        } else if (i == 3) {
            iW = wf1Var.x();
        } else {
            iW = wf1Var.w();
        }
        int i4 = iW;
        int iZ = i >= 3 ? wf1Var.z() : 0;
        if (iT == 0 && iT2 == 0 && iT3 == 0 && iT4 == 0 && i4 == 0 && iZ == 0) {
            wf1Var.e(wf1Var.e());
            return null;
        }
        int iD = wf1Var.d() + i4;
        if (iD > wf1Var.e()) {
            at0.d("Id3Decoder", "Frame size exceeds remaining tag data");
            wf1Var.e(wf1Var.e());
            return null;
        }
        if (aVar != null) {
            i3 = iD;
            if (!aVar.a(i, iT, iT2, iT3, iT4)) {
                wf1Var.e(i3);
                return null;
            }
        } else {
            i3 = iD;
        }
        if (i == 3) {
            z2 = (iZ & 128) != 0;
            boolean z7 = (iZ & 64) != 0;
            z5 = (iZ & 32) != 0;
            z6 = false;
            z4 = z7;
            z3 = z2;
        } else if (i == 4) {
            boolean z8 = (iZ & 64) != 0;
            z2 = (iZ & 8) != 0;
            boolean z9 = (iZ & 4) != 0;
            boolean z10 = (iZ & 2) != 0;
            if ((iZ & 1) != 0) {
                z6 = z10;
                z5 = z8;
                z4 = z9;
                z3 = true;
            } else {
                z6 = z10;
                z5 = z8;
                z4 = z9;
                z3 = false;
            }
        } else {
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
        }
        if (!z2 && !z4) {
            if (z5) {
                i4--;
                wf1Var.f(1);
            }
            if (z3) {
                i4 -= 4;
                wf1Var.f(4);
            }
            int iG = i4;
            if (z6) {
                iG = g(iG, wf1Var);
            }
            int i5 = iG;
            try {
                try {
                    if (iT == 84 && iT2 == 88 && iT3 == 88 && (i == 2 || iT4 == 88)) {
                        hlVar = e(i5, wf1Var);
                    } else if (iT == 84) {
                        hlVar = a(i5, wf1Var, a(i, iT, iT2, iT3, iT4));
                    } else if (iT == 87 && iT2 == 88 && iT3 == 88 && (i == 2 || iT4 == 88)) {
                        hlVar = f(i5, wf1Var);
                    } else if (iT == 87) {
                        hlVar = b(i5, wf1Var, a(i, iT, iT2, iT3, iT4));
                    } else if (iT == 80 && iT2 == 82 && iT3 == 73 && iT4 == 86) {
                        hlVar = d(i5, wf1Var);
                    } else if (iT == 71 && iT2 == 69 && iT3 == 79 && (iT4 == 66 || i == 2)) {
                        hlVar = b(i5, wf1Var);
                    } else if (i == 2) {
                        if (iT == 80 && iT2 == 73 && iT3 == 67) {
                            hlVar = a(i5, i, wf1Var);
                        } else if (iT != 67 && iT2 == 79 && iT3 == 77 && (iT4 == 77 || i == 2)) {
                            hlVar = a(i5, wf1Var);
                        } else if (iT != 67 && iT2 == 72 && iT3 == 65 && iT4 == 80) {
                            hlVar = a(wf1Var, i5, i, z, i2, aVar);
                        } else if (iT != 67 && iT2 == 84 && iT3 == 79 && iT4 == 67) {
                            hlVar = b(wf1Var, i5, i, z, i2, aVar);
                        } else if (iT != 77 && iT2 == 76 && iT3 == 76 && iT4 == 84) {
                            hlVar = c(i5, wf1Var);
                        } else {
                            String strA = a(i, iT, iT2, iT3, iT4);
                            byte[] bArr = new byte[i5];
                            wf1Var.a(bArr, 0, i5);
                            hlVar = new hl(strA, bArr);
                        }
                    } else if (iT == 65 && iT2 == 80 && iT3 == 73 && iT4 == 67) {
                        hlVar = a(i5, i, wf1Var);
                    } else if (iT != 67) {
                        if (iT != 67) {
                            if (iT != 67) {
                                if (iT != 77) {
                                    String strA2 = a(i, iT, iT2, iT3, iT4);
                                    byte[] bArr2 = new byte[i5];
                                    wf1Var.a(bArr2, 0, i5);
                                    hlVar = new hl(strA2, bArr2);
                                } else {
                                    String strA3 = a(i, iT, iT2, iT3, iT4);
                                    byte[] bArr3 = new byte[i5];
                                    wf1Var.a(bArr3, 0, i5);
                                    hlVar = new hl(strA3, bArr3);
                                }
                            } else if (iT != 77) {
                                String strA4 = a(i, iT, iT2, iT3, iT4);
                                byte[] bArr4 = new byte[i5];
                                wf1Var.a(bArr4, 0, i5);
                                hlVar = new hl(strA4, bArr4);
                            } else {
                                String strA5 = a(i, iT, iT2, iT3, iT4);
                                byte[] bArr5 = new byte[i5];
                                wf1Var.a(bArr5, 0, i5);
                                hlVar = new hl(strA5, bArr5);
                            }
                        } else if (iT != 67) {
                            if (iT != 77) {
                                String strA6 = a(i, iT, iT2, iT3, iT4);
                                byte[] bArr6 = new byte[i5];
                                wf1Var.a(bArr6, 0, i5);
                                hlVar = new hl(strA6, bArr6);
                            } else {
                                String strA7 = a(i, iT, iT2, iT3, iT4);
                                byte[] bArr7 = new byte[i5];
                                wf1Var.a(bArr7, 0, i5);
                                hlVar = new hl(strA7, bArr7);
                            }
                        } else if (iT != 77) {
                            String strA8 = a(i, iT, iT2, iT3, iT4);
                            byte[] bArr8 = new byte[i5];
                            wf1Var.a(bArr8, 0, i5);
                            hlVar = new hl(strA8, bArr8);
                        } else {
                            String strA9 = a(i, iT, iT2, iT3, iT4);
                            byte[] bArr9 = new byte[i5];
                            wf1Var.a(bArr9, 0, i5);
                            hlVar = new hl(strA9, bArr9);
                        }
                    } else if (iT != 67) {
                        if (iT != 67) {
                            if (iT != 77) {
                                String strA10 = a(i, iT, iT2, iT3, iT4);
                                byte[] bArr10 = new byte[i5];
                                wf1Var.a(bArr10, 0, i5);
                                hlVar = new hl(strA10, bArr10);
                            } else {
                                String strA11 = a(i, iT, iT2, iT3, iT4);
                                byte[] bArr11 = new byte[i5];
                                wf1Var.a(bArr11, 0, i5);
                                hlVar = new hl(strA11, bArr11);
                            }
                        } else if (iT != 77) {
                            String strA12 = a(i, iT, iT2, iT3, iT4);
                            byte[] bArr12 = new byte[i5];
                            wf1Var.a(bArr12, 0, i5);
                            hlVar = new hl(strA12, bArr12);
                        } else {
                            String strA13 = a(i, iT, iT2, iT3, iT4);
                            byte[] bArr13 = new byte[i5];
                            wf1Var.a(bArr13, 0, i5);
                            hlVar = new hl(strA13, bArr13);
                        }
                    } else if (iT != 67) {
                        if (iT != 77) {
                            String strA14 = a(i, iT, iT2, iT3, iT4);
                            byte[] bArr14 = new byte[i5];
                            wf1Var.a(bArr14, 0, i5);
                            hlVar = new hl(strA14, bArr14);
                        } else {
                            String strA15 = a(i, iT, iT2, iT3, iT4);
                            byte[] bArr15 = new byte[i5];
                            wf1Var.a(bArr15, 0, i5);
                            hlVar = new hl(strA15, bArr15);
                        }
                    } else if (iT != 77) {
                        String strA16 = a(i, iT, iT2, iT3, iT4);
                        byte[] bArr16 = new byte[i5];
                        wf1Var.a(bArr16, 0, i5);
                        hlVar = new hl(strA16, bArr16);
                    } else {
                        String strA17 = a(i, iT, iT2, iT3, iT4);
                        byte[] bArr17 = new byte[i5];
                        wf1Var.a(bArr17, 0, i5);
                        hlVar = new hl(strA17, bArr17);
                    }
                    if (hlVar == null) {
                        str = r4;
                        try {
                            at0.d(str, "Failed to decode frame: id=" + a(i, iT, iT2, iT3, iT4) + ", frameSize=" + i5);
                        } catch (UnsupportedEncodingException unused) {
                            at0.d(str, "Unsupported character encoding");
                            wf1Var.e(i3);
                            return null;
                        }
                    }
                    wf1Var.e(i3);
                    return hlVar;
                } catch (Throwable th) {
                    wf1Var.e(i3);
                    throw th;
                }
            } catch (UnsupportedEncodingException unused2) {
                str = r4;
            }
        } else {
            at0.d("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
            wf1Var.e(i3);
            return null;
        }
    }

    private static String a(int i, int i2, String str, byte[] bArr) throws UnsupportedEncodingException {
        if (i2 > i && i2 <= bArr.length) {
            return new String(bArr, i, i2 - i, str);
        }
        return "";
    }

    private static m42 a(int i, wf1 wf1Var, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iT = wf1Var.t();
        String strB = b(iT);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        wf1Var.a(bArr, 0, i2);
        return new m42(str, null, new String(bArr, 0, a(bArr, 0, iT), strB));
    }

    private static String b(int i) {
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

    private static int b(int i, byte[] bArr) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static String a(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static int a(byte[] bArr, int i, int i2) {
        int iB = b(i, bArr);
        if (i2 == 0 || i2 == 3) {
            return iB;
        }
        while (iB < bArr.length - 1) {
            if ((iB - i) % 2 == 0 && bArr[iB + 1] == 0) {
                return iB;
            }
            iB = b(iB + 1, bArr);
        }
        return bArr.length;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0087 A[PHI: r3
  0x0087: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:39:0x0084, B:31:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    private static boolean a(wf1 wf1Var, int i, int i2, boolean z) {
        int iW;
        long jW;
        int iZ;
        int i3;
        int iD = wf1Var.d();
        while (true) {
            try {
                boolean z2 = true;
                if (wf1Var.a() < i2) {
                    wf1Var.e(iD);
                    return true;
                }
                if (i >= 3) {
                    iW = wf1Var.h();
                    jW = wf1Var.v();
                    iZ = wf1Var.z();
                } else {
                    iW = wf1Var.w();
                    jW = wf1Var.w();
                    iZ = 0;
                }
                if (iW == 0 && jW == 0 && iZ == 0) {
                    wf1Var.e(iD);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & jW) != 0) {
                        wf1Var.e(iD);
                        return false;
                    }
                    jW = (((jW >> 24) & 255) << 21) | (jW & 255) | (((jW >> 8) & 255) << 7) | (((jW >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (iZ & 64) != 0 ? 1 : 0;
                    if ((iZ & 1) == 0) {
                        z2 = false;
                    }
                } else if (i == 3) {
                    i3 = (iZ & 32) != 0 ? 1 : 0;
                    if ((iZ & 128) == 0) {
                        z2 = false;
                    }
                } else {
                    i3 = 0;
                    z2 = false;
                }
                if (z2) {
                    i3 += 4;
                }
                if (jW < i3) {
                    wf1Var.e(iD);
                    return false;
                }
                if (wf1Var.a() < jW) {
                    wf1Var.e(iD);
                    return false;
                }
                wf1Var.f((int) jW);
            } catch (Throwable th) {
                wf1Var.e(iD);
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008c  */
    /* JADX WARN: Code duplicated, block: B:34:0x009b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x009c  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00e8 A[SYNTHETIC] */
    public final g01 a(int i, byte[] bArr) {
        boolean z;
        b bVar;
        int i2;
        int iG;
        qi0 qi0VarA;
        ArrayList arrayList = new ArrayList();
        wf1 wf1Var = new wf1(i, bArr);
        boolean z2 = false;
        if (wf1Var.a() < 10) {
            at0.d("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int iW = wf1Var.w();
            if (iW != 4801587) {
                at0.d("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x".concat(String.format("%06X", Integer.valueOf(iW))));
            } else {
                int iT = wf1Var.t();
                wf1Var.f(1);
                int iT2 = wf1Var.t();
                int iS = wf1Var.s();
                if (iT != 2) {
                    if (iT == 3) {
                        if ((iT2 & 64) != 0) {
                            int iH = wf1Var.h();
                            wf1Var.f(iH);
                            iS -= iH + 4;
                        }
                    } else if (iT == 4) {
                        if ((iT2 & 64) != 0) {
                            int iS2 = wf1Var.s();
                            wf1Var.f(iS2 - 4);
                            iS -= iS2;
                        }
                        if ((iT2 & 16) != 0) {
                            iS -= 10;
                        }
                    } else {
                        tr0.a("Skipped ID3 tag with unsupported majorVersion=", iT, "Id3Decoder");
                    }
                    if (iT < 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    bVar = new b(iT, iS, z);
                } else if ((iT2 & 64) != 0) {
                    at0.d("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                } else {
                    if (iT < 4 || (iT2 & 128) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    bVar = new b(iT, iS, z);
                }
                if (bVar == null) {
                    return null;
                }
                int iD = wf1Var.d();
                i2 = bVar.f9930a == 2 ? 6 : 10;
                iG = bVar.c;
                if (bVar.b) {
                    iG = g(iG, wf1Var);
                }
                wf1Var.d(iD + iG);
                if (!a(wf1Var, bVar.f9930a, i2, false)) {
                    if (bVar.f9930a == 4 || !a(wf1Var, 4, i2, true)) {
                        at0.d("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVar.f9930a);
                        return null;
                    }
                    z2 = true;
                }
                while (wf1Var.a() >= i2) {
                    qi0VarA = a(bVar.f9930a, wf1Var, z2, i2, this.f9929a);
                    if (qi0VarA != null) {
                        arrayList.add(qi0VarA);
                    }
                }
                return new g01(arrayList);
            }
        }
        bVar = null;
        if (bVar == null) {
            return null;
        }
        int iD2 = wf1Var.d();
        if (bVar.f9930a == 2) {
        }
        iG = bVar.c;
        if (bVar.b) {
            iG = g(iG, wf1Var);
        }
        wf1Var.d(iD2 + iG);
        if (!a(wf1Var, bVar.f9930a, i2, false)) {
            if (bVar.f9930a == 4) {
            }
            at0.d("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVar.f9930a);
            return null;
        }
        while (wf1Var.a() >= i2) {
            qi0VarA = a(bVar.f9930a, wf1Var, z2, i2, this.f9929a);
            if (qi0VarA != null) {
                arrayList.add(qi0VarA);
            }
        }
        return new g01(arrayList);
    }
}
