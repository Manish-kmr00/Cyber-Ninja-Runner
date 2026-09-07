package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1988a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final short[] f;
    public int g;
    public short[] h;
    public int i;
    public short[] j;
    public int k;
    public short[] l;
    public int q;
    public int r;
    public int s;
    public int t;
    public int v;
    public int w;
    public int x;
    public int m = 0;
    public int n = 0;
    public int u = 0;
    public float o = 1.0f;
    public float p = 1.0f;

    public w(int i, int i2) {
        this.f1988a = i;
        this.b = i2;
        this.c = i / 400;
        int i3 = i / 65;
        this.d = i3;
        int i4 = i3 * 2;
        this.e = i4;
        this.f = new short[i4];
        this.g = i4;
        int i5 = i2 * i4;
        this.h = new short[i5];
        this.i = i4;
        this.j = new short[i5];
        this.k = i4;
        this.l = new short[i5];
    }

    public final void a(int i) {
        int i2 = this.q + i;
        int i3 = this.g;
        if (i2 > i3) {
            int i4 = (i3 / 2) + i + i3;
            this.g = i4;
            this.h = Arrays.copyOf(this.h, i4 * this.b);
        }
    }

    public final void b(int i) {
        int i2 = this.r + i;
        int i3 = this.i;
        if (i2 > i3) {
            int i4 = (i3 / 2) + i + i3;
            this.i = i4;
            this.j = Arrays.copyOf(this.j, i4 * this.b);
        }
    }

    public final void a(short[] sArr, int i, int i2) {
        int i3 = this.e / i2;
        int i4 = this.b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.f[i7] = (short) (i8 / i5);
        }
    }

    public final int a(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.b;
        int i5 = 255;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i7 < i6 * i2) {
                i7 = i2;
                i6 = i9;
            }
            if (i9 * i5 > i8 * i2) {
                i5 = i2;
                i8 = i9;
            }
            i2++;
        }
        this.w = i6 / i7;
        this.x = i8 / i5;
        return i7;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x024b A[LOOP:4: B:12:0x0045->B:101:0x024b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:111:0x0172 A[EDGE_INSN: B:111:0x0172->B:64:0x0172 BREAK  A[LOOP:4: B:12:0x0045->B:101:0x024b], SYNTHETIC] */
    public final void a() {
        int iA;
        int i;
        int iMin;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = this.r;
        float f = this.o / this.p;
        double d = f;
        int i7 = 1;
        if (d <= 1.00001d && d >= 0.99999d) {
            short[] sArr = this.h;
            int i8 = this.q;
            b(i8);
            int i9 = this.b;
            System.arraycopy(sArr, 0, this.j, this.r * i9, i9 * i8);
            this.r += i8;
            this.q = 0;
        } else {
            int i10 = this.q;
            if (i10 >= this.e) {
                int i11 = 0;
                while (true) {
                    int i12 = this.t;
                    if (i12 > 0) {
                        iMin = Math.min(this.e, i12);
                        short[] sArr2 = this.h;
                        b(iMin);
                        int i13 = this.b;
                        System.arraycopy(sArr2, i11 * i13, this.j, this.r * i13, i13 * iMin);
                        this.r += iMin;
                        this.t -= iMin;
                    } else {
                        short[] sArr3 = this.h;
                        int i14 = this.f1988a;
                        int i15 = i14 > 4000 ? i14 / 4000 : i7;
                        if (this.b == i7 && i15 == i7) {
                            iA = a(sArr3, i11, this.c, this.d);
                        } else {
                            a(sArr3, i11, i15);
                            int iA2 = a(this.f, 0, this.c / i15, this.d / i15);
                            if (i15 != i7) {
                                int i16 = iA2 * i15;
                                int i17 = i15 * 4;
                                int i18 = i16 - i17;
                                int i19 = i16 + i17;
                                int i20 = this.c;
                                if (i18 < i20) {
                                    i18 = i20;
                                }
                                int i21 = this.d;
                                if (i19 > i21) {
                                    i19 = i21;
                                }
                                if (this.b == i7) {
                                    iA = a(sArr3, i11, i18, i19);
                                } else {
                                    a(sArr3, i11, i7);
                                    iA = a(this.f, 0, i18, i19);
                                }
                            } else {
                                iA = iA2;
                            }
                        }
                        int i22 = this.w;
                        int i23 = (i22 == 0 || (i3 = this.u) == 0 || this.x > i22 * 3 || i22 * 2 <= this.v * 3) ? iA : i3;
                        this.v = i22;
                        this.u = iA;
                        if (d > 1.0d) {
                            short[] sArr4 = this.h;
                            if (f >= 2.0f) {
                                i2 = (int) (i23 / (f - 1.0f));
                            } else {
                                this.t = (int) (((2.0f - f) * i23) / (f - 1.0f));
                                i2 = i23;
                            }
                            b(i2);
                            int i24 = i2;
                            a(i2, this.b, this.j, this.r, sArr4, i11, sArr4, i11 + i23);
                            this.r += i24;
                            i11 = i23 + i24 + i11;
                        } else {
                            int i25 = i23;
                            short[] sArr5 = this.h;
                            if (f < 0.5f) {
                                i = (int) ((i25 * f) / (1.0f - f));
                            } else {
                                this.t = (int) ((((2.0f * f) - 1.0f) * i25) / (1.0f - f));
                                i = i25;
                            }
                            int i26 = i25 + i;
                            b(i26);
                            int i27 = this.b;
                            System.arraycopy(sArr5, i11 * i27, this.j, this.r * i27, i27 * i25);
                            iMin = i;
                            a(iMin, this.b, this.j, this.r + i25, sArr5, i25 + i11, sArr5, i11);
                            this.r += i26;
                        }
                        if (this.e + i11 > i10) {
                            break;
                        } else {
                            i7 = 1;
                        }
                    }
                    i11 += iMin;
                    if (this.e + i11 > i10) {
                        break;
                        break;
                    }
                    i7 = 1;
                }
                int i28 = this.q - i11;
                short[] sArr6 = this.h;
                int i29 = this.b;
                System.arraycopy(sArr6, i11 * i29, sArr6, 0, i29 * i28);
                this.q = i28;
            }
        }
        float f2 = this.p;
        if (f2 == 1.0f || this.r == i6) {
            return;
        }
        int i30 = this.f1988a;
        int i31 = (int) (i30 / f2);
        while (true) {
            if (i31 <= 16384 && i30 <= 16384) {
                break;
            }
            i31 /= 2;
            i30 /= 2;
        }
        int i32 = this.r - i6;
        int i33 = this.s + i32;
        int i34 = this.k;
        if (i33 > i34) {
            int i35 = (i34 / 2) + i32 + i34;
            this.k = i35;
            this.l = Arrays.copyOf(this.l, i35 * this.b);
        }
        short[] sArr7 = this.j;
        int i36 = this.b;
        System.arraycopy(sArr7, i6 * i36, this.l, this.s * i36, i36 * i32);
        this.r = i6;
        this.s += i32;
        int i37 = 0;
        while (true) {
            int i38 = this.s;
            int i39 = i38 - 1;
            if (i37 >= i39) {
                if (i39 == 0) {
                    return;
                }
                short[] sArr8 = this.l;
                int i40 = this.b;
                System.arraycopy(sArr8, i39 * i40, sArr8, 0, (i38 - i39) * i40);
                this.s -= i39;
                return;
            }
            while (true) {
                i4 = this.m + 1;
                int i41 = i4 * i31;
                i5 = this.n;
                if (i41 <= i5 * i30) {
                    break;
                }
                b(1);
                int i42 = 0;
                while (true) {
                    int i43 = this.b;
                    if (i42 < i43) {
                        short[] sArr9 = this.j;
                        int i44 = (this.r * i43) + i42;
                        short[] sArr10 = this.l;
                        int i45 = (i37 * i43) + i42;
                        short s = sArr10[i45];
                        short s2 = sArr10[i45 + i43];
                        int i46 = this.n * i30;
                        int i47 = this.m;
                        int i48 = i47 * i31;
                        int i49 = (i47 + 1) * i31;
                        int i50 = i49 - i46;
                        int i51 = i49 - i48;
                        sArr9[i44] = (short) ((((i51 - i50) * s2) + (s * i50)) / i51);
                        i42++;
                    }
                }
                this.n++;
                this.r++;
            }
            this.m = i4;
            if (i4 == i30) {
                this.m = 0;
                if (i5 == i31) {
                    this.n = 0;
                } else {
                    throw new IllegalStateException();
                }
            }
            i37++;
        }
    }

    public static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr3[i8] * i10) + ((i - i10) * sArr2[i9])) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }
}
