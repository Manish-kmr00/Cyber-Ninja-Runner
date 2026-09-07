package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.util.Log;
import java.util.Arrays;

/* JADX INFO: loaded from: classes14.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f2182a = {0, 0, 0, 1};
    public static final float[] b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final Object c = new Object();
    public static int[] d = new int[10];

    public static int a(int i, byte[] bArr) {
        int i2;
        synchronized (c) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    try {
                        if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = d;
                    if (iArr.length <= i4) {
                        d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    d[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = d[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i9 + 2;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:70:0x010d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0111  */
    /* JADX WARN: Code duplicated, block: B:73:0x0113  */
    /* JADX WARN: Code duplicated, block: B:75:0x0117  */
    /* JADX WARN: Code duplicated, block: B:92:0x0169  */
    public static k a(byte[] bArr, int i, int i2) {
        int iD;
        boolean z;
        int iD2;
        boolean z2;
        boolean zC;
        int i3;
        int i4;
        int i5;
        float f;
        float f2;
        int i6;
        o oVar = new o(bArr, i, i2);
        oVar.d(8);
        int iB = oVar.b(8);
        oVar.d(16);
        int iD3 = oVar.d();
        int i7 = 1;
        if (iB == 100 || iB == 110 || iB == 122 || iB == 244 || iB == 44 || iB == 83 || iB == 86 || iB == 118 || iB == 128 || iB == 138) {
            iD = oVar.d();
            boolean zC2 = iD == 3 ? oVar.c() : false;
            oVar.d();
            oVar.d();
            oVar.f();
            if (oVar.c()) {
                int i8 = iD != 3 ? 8 : 12;
                int i9 = 0;
                while (i9 < i8) {
                    if (oVar.c()) {
                        int i10 = i9 < 6 ? 16 : 64;
                        int iE = 8;
                        int i11 = 8;
                        for (int i12 = 0; i12 < i10; i12++) {
                            if (iE != 0) {
                                iE = ((oVar.e() + i11) + 256) % 256;
                            }
                            if (iE != 0) {
                                i11 = iE;
                            }
                        }
                    }
                    i9++;
                }
            }
            z = zC2;
        } else {
            iD = 1;
            z = false;
        }
        int iD4 = oVar.d() + 4;
        int iD5 = oVar.d();
        if (iD5 == 0) {
            iD2 = oVar.d() + 4;
        } else {
            if (iD5 == 1) {
                boolean zC3 = oVar.c();
                oVar.e();
                oVar.e();
                long jD = oVar.d();
                z = z;
                for (int i13 = 0; i13 < jD; i13++) {
                    oVar.d();
                }
                z2 = zC3;
                iD2 = 0;
            } else {
                iD2 = 0;
            }
            oVar.d();
            oVar.f();
            int iD6 = oVar.d() + 1;
            int iD7 = oVar.d() + 1;
            zC = oVar.c();
            i3 = 2 - (zC ? 1 : 0);
            int i14 = iD7 * i3;
            if (!zC) {
                oVar.f();
            }
            oVar.f();
            i4 = iD6 * 16;
            i5 = i14 * 16;
            if (oVar.c()) {
                int iD8 = oVar.d();
                int iD9 = oVar.d();
                int iD10 = oVar.d();
                int iD11 = oVar.d();
                if (iD != 0) {
                    if (iD == 3) {
                        i6 = 1;
                    } else {
                        i6 = 2;
                    }
                    i3 *= iD == 1 ? 2 : 1;
                    i7 = i6;
                }
                i4 -= (iD8 + iD9) * i7;
                i5 -= (iD10 + iD11) * i3;
            }
            int i15 = i4;
            int i16 = i5;
            if (oVar.c() || !oVar.c()) {
                f = 1.0f;
                f2 = f;
            } else {
                int iB2 = oVar.b(8);
                if (iB2 == 255) {
                    int iB3 = oVar.b(16);
                    int iB4 = oVar.b(16);
                    if (iB3 != 0 && iB4 != 0) {
                        f2 = iB3 / iB4;
                    }
                } else {
                    float[] fArr = b;
                    if (iB2 < 17) {
                        f = fArr[iB2];
                    } else {
                        Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iB2);
                    }
                    f2 = f;
                }
                f = 1.0f;
                f2 = f;
            }
            return new k(iD3, i15, i16, f2, z, zC, iD4, iD5, iD2, z2);
        }
        z2 = false;
        oVar.d();
        oVar.f();
        int iD12 = oVar.d() + 1;
        int iD13 = oVar.d() + 1;
        zC = oVar.c();
        i3 = 2 - (zC ? 1 : 0);
        int i17 = iD13 * i3;
        if (!zC) {
            oVar.f();
        }
        oVar.f();
        i4 = iD12 * 16;
        i5 = i17 * 16;
        if (oVar.c()) {
            int iD14 = oVar.d();
            int iD15 = oVar.d();
            int iD16 = oVar.d();
            int iD17 = oVar.d();
            if (iD != 0) {
                if (iD == 3) {
                    i6 = 1;
                } else {
                    i6 = 2;
                }
                i3 *= iD == 1 ? 2 : 1;
                i7 = i6;
            }
            i4 -= (iD14 + iD15) * i7;
            i5 -= (iD16 + iD17) * i3;
        }
        int i18 = i4;
        int i19 = i5;
        if (oVar.c()) {
            f = 1.0f;
            f2 = f;
        } else {
            f = 1.0f;
            f2 = f;
        }
        return new k(iD3, i18, i19, f2, z, zC, iD4, iD5, iD2, z2);
    }

    public static int a(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalStateException();
        }
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            a(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            a(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            a(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b2 = bArr[i5];
            if ((b2 & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b2 == 1) {
                    a(zArr);
                    return i6;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
