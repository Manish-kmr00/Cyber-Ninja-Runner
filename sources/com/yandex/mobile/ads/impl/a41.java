package com.yandex.mobile.ads.impl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public final class a41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f8364a = {0, 0, 0, 1};
    public static final float[] b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object c = new Object();
    private static int[] d = new int[10];

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8365a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int[] e;
        public final int f;
        public final float g;

        public a(int i, boolean z, int i2, int i3, int[] iArr, int i4, int i5, int i6, float f) {
            this.f8365a = i;
            this.b = z;
            this.c = i2;
            this.d = i3;
            this.e = iArr;
            this.f = i4;
            this.g = f;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8367a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final float g;
        public final boolean h;
        public final boolean i;
        public final int j;
        public final int k;
        public final int l;
        public final boolean m;

        public c(int i, int i2, int i3, int i4, int i5, int i6, float f, boolean z, boolean z2, int i7, int i8, int i9, boolean z3) {
            this.f8367a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = f;
            this.h = z;
            this.i = z2;
            this.j = i7;
            this.k = i8;
            this.l = i9;
            this.m = z3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:68:0x0111  */
    /* JADX WARN: Code duplicated, block: B:69:0x0113  */
    /* JADX WARN: Code duplicated, block: B:71:0x0118  */
    /* JADX WARN: Code duplicated, block: B:72:0x011b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0120  */
    /* JADX WARN: Code duplicated, block: B:92:0x016b  */
    public static c b(byte[] bArr, int i, int i2) {
        int iE;
        boolean zC;
        int iE2;
        boolean z;
        boolean zC2;
        int i3;
        int i4;
        int i5;
        float f;
        float f2;
        int i6;
        int i7;
        xf1 xf1Var = new xf1(bArr, i + 1, i2);
        int iB = xf1Var.b(8);
        int iB2 = xf1Var.b(8);
        int iB3 = xf1Var.b(8);
        int iE3 = xf1Var.e();
        if (iB == 100 || iB == 110 || iB == 122 || iB == 244 || iB == 44 || iB == 83 || iB == 86 || iB == 118 || iB == 128 || iB == 138) {
            iE = xf1Var.e();
            zC = iE == 3 ? xf1Var.c() : false;
            xf1Var.e();
            xf1Var.e();
            xf1Var.f();
            if (xf1Var.c()) {
                int i8 = iE != 3 ? 8 : 12;
                int i9 = 0;
                while (i9 < i8) {
                    if (xf1Var.c()) {
                        int i10 = i9 < 6 ? 16 : 64;
                        int iD = 8;
                        int i11 = 8;
                        for (int i12 = 0; i12 < i10; i12++) {
                            if (iD != 0) {
                                iD = ((xf1Var.d() + i11) + 256) % 256;
                            }
                            if (iD != 0) {
                                i11 = iD;
                            }
                        }
                    }
                    i9++;
                }
            }
        } else {
            iE = 1;
            zC = false;
        }
        int iE4 = xf1Var.e() + 4;
        int iE5 = xf1Var.e();
        if (iE5 != 0) {
            if (iE5 == 1) {
                boolean zC3 = xf1Var.c();
                xf1Var.d();
                xf1Var.d();
                long jE = xf1Var.e();
                for (int i13 = 0; i13 < jE; i13++) {
                    xf1Var.e();
                }
                z = zC3;
                iE2 = 0;
            } else {
                iE2 = 0;
            }
            xf1Var.e();
            xf1Var.f();
            int iE6 = xf1Var.e() + 1;
            int iE7 = xf1Var.e() + 1;
            zC2 = xf1Var.c();
            i3 = 2 - (zC2 ? 1 : 0);
            int i14 = iE7 * i3;
            if (!zC2) {
                xf1Var.f();
            }
            xf1Var.f();
            i4 = iE6 * 16;
            i5 = i14 * 16;
            if (xf1Var.c()) {
                int iE8 = xf1Var.e();
                int iE9 = xf1Var.e();
                int iE10 = xf1Var.e();
                int iE11 = xf1Var.e();
                if (iE == 0) {
                    i7 = 1;
                } else {
                    if (iE == 3) {
                        i6 = 1;
                    } else {
                        i6 = 2;
                    }
                    i3 *= iE == 1 ? 2 : 1;
                    i7 = i6;
                }
                i4 -= (iE8 + iE9) * i7;
                i5 -= (iE10 + iE11) * i3;
            }
            int i15 = i5;
            if (xf1Var.c() || !xf1Var.c()) {
                f = 1.0f;
                f2 = f;
            } else {
                int iB4 = xf1Var.b(8);
                if (iB4 == 255) {
                    int iB5 = xf1Var.b(16);
                    int iB6 = xf1Var.b(16);
                    if (iB5 != 0 && iB6 != 0) {
                        f2 = iB5 / iB6;
                    }
                } else {
                    float[] fArr = b;
                    if (iB4 < 17) {
                        f = fArr[iB4];
                    } else {
                        tr0.a("Unexpected aspect_ratio_idc value: ", iB4, "NalUnitUtil");
                    }
                    f2 = f;
                }
                f = 1.0f;
                f2 = f;
            }
            return new c(iB, iB2, iB3, iE3, i4, i15, f2, zC, zC2, iE4, iE5, iE2, z);
        }
        iE2 = xf1Var.e() + 4;
        z = false;
        xf1Var.e();
        xf1Var.f();
        int iE12 = xf1Var.e() + 1;
        int iE13 = xf1Var.e() + 1;
        zC2 = xf1Var.c();
        i3 = 2 - (zC2 ? 1 : 0);
        int i16 = iE13 * i3;
        if (!zC2) {
            xf1Var.f();
        }
        xf1Var.f();
        i4 = iE12 * 16;
        i5 = i16 * 16;
        if (xf1Var.c()) {
            int iE14 = xf1Var.e();
            int iE15 = xf1Var.e();
            int iE16 = xf1Var.e();
            int iE17 = xf1Var.e();
            if (iE == 0) {
                i7 = 1;
            } else {
                if (iE == 3) {
                    i6 = 1;
                } else {
                    i6 = 2;
                }
                i3 *= iE == 1 ? 2 : 1;
                i7 = i6;
            }
            i4 -= (iE14 + iE15) * i7;
            i5 -= (iE16 + iE17) * i3;
        }
        int i17 = i5;
        if (xf1Var.c()) {
            f = 1.0f;
            f2 = f;
        } else {
            f = 1.0f;
            f2 = f;
        }
        return new c(iB, iB2, iB3, iE3, i4, i17, f2, zC, zC2, iE4, iE5, iE2, z);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8366a;
        public final boolean b;

        public b(int i, int i2, boolean z) {
            this.f8366a = i2;
            this.b = z;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
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

    public static a a(byte[] bArr, int i, int i2) {
        boolean z;
        int[] iArrCopyOf;
        xf1 xf1Var = new xf1(bArr, i + 2, i2);
        int i3 = 4;
        xf1Var.d(4);
        int iB = xf1Var.b(3);
        xf1Var.f();
        int iB2 = xf1Var.b(2);
        boolean zC = xf1Var.c();
        int iB3 = xf1Var.b(5);
        int i4 = 0;
        for (int i5 = 0; i5 < 32; i5++) {
            if (xf1Var.c()) {
                i4 |= 1 << i5;
            }
        }
        int i6 = 6;
        int[] iArr = new int[6];
        for (int i7 = 0; i7 < 6; i7++) {
            iArr[i7] = xf1Var.b(8);
        }
        int iB4 = xf1Var.b(8);
        int i8 = 0;
        for (int i9 = 0; i9 < iB; i9++) {
            if (xf1Var.c()) {
                i8 += 89;
            }
            if (xf1Var.c()) {
                i8 += 8;
            }
        }
        xf1Var.d(i8);
        if (iB > 0) {
            xf1Var.d((8 - iB) * 2);
        }
        xf1Var.e();
        int iE = xf1Var.e();
        if (iE == 3) {
            xf1Var.f();
        }
        int iE2 = xf1Var.e();
        int iE3 = xf1Var.e();
        if (xf1Var.c()) {
            int iE4 = xf1Var.e();
            int iE5 = xf1Var.e();
            int iE6 = xf1Var.e();
            int iE7 = xf1Var.e();
            iE2 -= (iE4 + iE5) * ((iE == 1 || iE == 2) ? 2 : 1);
            iE3 -= (iE6 + iE7) * (iE == 1 ? 2 : 1);
        }
        int i10 = iE3;
        int i11 = iE2;
        xf1Var.e();
        xf1Var.e();
        int iE8 = xf1Var.e();
        for (int i12 = xf1Var.c() ? 0 : iB; i12 <= iB; i12++) {
            xf1Var.e();
            xf1Var.e();
            xf1Var.e();
        }
        xf1Var.e();
        xf1Var.e();
        xf1Var.e();
        xf1Var.e();
        xf1Var.e();
        xf1Var.e();
        if (xf1Var.c() && xf1Var.c()) {
            int i13 = 0;
            while (i13 < i3) {
                int i14 = 0;
                while (i14 < i6) {
                    if (!xf1Var.c()) {
                        xf1Var.e();
                    } else {
                        int iMin = Math.min(64, 1 << ((i13 << 1) + 4));
                        if (i13 > 1) {
                            xf1Var.d();
                        }
                        for (int i15 = 0; i15 < iMin; i15++) {
                            xf1Var.d();
                        }
                    }
                    i14 += i13 == 3 ? 3 : 1;
                    i6 = 6;
                }
                i13++;
                i3 = 4;
                i6 = 6;
            }
        }
        xf1Var.d(2);
        if (xf1Var.c()) {
            xf1Var.d(8);
            xf1Var.e();
            xf1Var.e();
            xf1Var.f();
        }
        int[] iArr2 = new int[0];
        int[] iArr3 = new int[0];
        int i16 = -1;
        int i17 = 0;
        int iE9 = -1;
        for (int iE10 = xf1Var.e(); i17 < iE10; iE10 = iE10) {
            if (i17 != 0 && xf1Var.c()) {
                int i18 = i16 + iE9;
                int iE11 = (1 - ((xf1Var.c() ? 1 : 0) * 2)) * (xf1Var.e() + 1);
                int i19 = i18 + 1;
                boolean[] zArr = new boolean[i19];
                for (int i20 = 0; i20 <= i18; i20++) {
                    if (!xf1Var.c()) {
                        zArr[i20] = xf1Var.c();
                    } else {
                        zArr[i20] = true;
                    }
                }
                int[] iArr4 = new int[i19];
                int[] iArr5 = new int[i19];
                int i21 = 0;
                for (int i22 = iE9 - 1; i22 >= 0; i22--) {
                    int i23 = iArr3[i22] + iE11;
                    if (i23 < 0 && zArr[i16 + i22]) {
                        iArr4[i21] = i23;
                        i21++;
                    }
                }
                if (iE11 < 0 && zArr[i18]) {
                    iArr4[i21] = iE11;
                    i21++;
                }
                int i24 = i21;
                for (int i25 = 0; i25 < i16; i25++) {
                    int i26 = iArr2[i25] + iE11;
                    if (i26 < 0 && zArr[i25]) {
                        iArr4[i24] = i26;
                        i24++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr4, i24);
                int i27 = 0;
                for (int i28 = i16 - 1; i28 >= 0; i28--) {
                    int i29 = iArr2[i28] + iE11;
                    if (i29 > 0 && zArr[i28]) {
                        iArr5[i27] = i29;
                        i27++;
                    }
                }
                if (iE11 > 0 && zArr[i18]) {
                    iArr5[i27] = iE11;
                    i27++;
                }
                int i30 = i27;
                for (int i31 = 0; i31 < iE9; i31++) {
                    int i32 = iArr3[i31] + iE11;
                    if (i32 > 0 && zArr[i16 + i31]) {
                        iArr5[i30] = i32;
                        i30++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr5, i30);
                iE9 = i30;
                iArr2 = iArrCopyOf2;
                i16 = i24;
                z = true;
            } else {
                int iE12 = xf1Var.e();
                iE9 = xf1Var.e();
                iArr2 = new int[iE12];
                for (int i33 = 0; i33 < iE12; i33++) {
                    iArr2[i33] = xf1Var.e() + 1;
                    xf1Var.f();
                }
                z = true;
                int[] iArr6 = new int[iE9];
                for (int i34 = 0; i34 < iE9; i34++) {
                    iArr6[i34] = xf1Var.e() + 1;
                    xf1Var.f();
                }
                i16 = iE12;
                iArrCopyOf = iArr6;
            }
            i17++;
            iB4 = iB4;
            iArr = iArr;
            i4 = i4;
            iB3 = iB3;
            iArr3 = iArrCopyOf;
        }
        int i35 = iB3;
        int i36 = i4;
        int[] iArr7 = iArr;
        int i37 = iB4;
        if (xf1Var.c()) {
            for (int i38 = 0; i38 < xf1Var.e(); i38++) {
                xf1Var.d(iE8 + 5);
            }
        }
        xf1Var.d(2);
        float f = 1.0f;
        if (xf1Var.c()) {
            if (xf1Var.c()) {
                int iB5 = xf1Var.b(8);
                if (iB5 == 255) {
                    int iB6 = xf1Var.b(16);
                    int iB7 = xf1Var.b(16);
                    if (iB6 != 0 && iB7 != 0) {
                        f = iB6 / iB7;
                    }
                } else {
                    float[] fArr = b;
                    if (iB5 < 17) {
                        f = fArr[iB5];
                    } else {
                        tr0.a("Unexpected aspect_ratio_idc value: ", iB5, "NalUnitUtil");
                    }
                }
            }
            if (xf1Var.c()) {
                xf1Var.f();
            }
            if (xf1Var.c()) {
                xf1Var.d(4);
                if (xf1Var.c()) {
                    xf1Var.d(24);
                }
            }
            if (xf1Var.c()) {
                xf1Var.e();
                xf1Var.e();
            }
            xf1Var.f();
            if (xf1Var.c()) {
                i10 *= 2;
            }
        }
        return new a(iB2, zC, i35, i36, iArr7, i37, i11, i10, f);
    }

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
}
