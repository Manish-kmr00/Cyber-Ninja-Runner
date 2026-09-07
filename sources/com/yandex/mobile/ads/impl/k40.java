package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes10.dex */
public final class k40 implements y40 {
    private final String b;
    private String c;
    private t52 d;
    private int f;
    private int g;
    private long h;
    private gc0 i;
    private int j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wf1 f9376a = new wf1(new byte[18]);
    private int e = 0;
    private long k = -9223372036854775807L;

    @Override // com.yandex.mobile.ads.impl.y40
    public final void b() {
    }

    public k40(String str) {
        this.b = str;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00fa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:40:0x0103  */
    /* JADX WARN: Code duplicated, block: B:41:0x010b  */
    /* JADX WARN: Code duplicated, block: B:43:0x0115  */
    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(wf1 wf1Var) {
        int i;
        byte b;
        boolean z;
        int i2;
        int i3;
        byte b2;
        int i4;
        byte b3;
        int i5;
        if (this.d != null) {
            while (wf1Var.a() > 0) {
                int i6 = this.e;
                if (i6 == 0) {
                    while (wf1Var.a() > 0) {
                        int i7 = this.g << 8;
                        this.g = i7;
                        int iT = i7 | wf1Var.t();
                        this.g = iT;
                        if (iT == 2147385345 || iT == -25230976 || iT == 536864768 || iT == -14745368) {
                            byte[] bArrC = this.f9376a.c();
                            int i8 = this.g;
                            bArrC[0] = (byte) ((i8 >> 24) & 255);
                            bArrC[1] = (byte) ((i8 >> 16) & 255);
                            bArrC[2] = (byte) ((i8 >> 8) & 255);
                            bArrC[3] = (byte) (i8 & 255);
                            this.f = 4;
                            this.g = 0;
                            this.e = 1;
                            break;
                        }
                    }
                } else if (i6 == 1) {
                    byte[] bArrC2 = this.f9376a.c();
                    int iMin = Math.min(wf1Var.a(), 18 - this.f);
                    wf1Var.a(bArrC2, this.f, iMin);
                    int i9 = this.f + iMin;
                    this.f = i9;
                    if (i9 == 18) {
                        byte[] bArrC3 = this.f9376a.c();
                        if (this.i == null) {
                            gc0 gc0VarA = l40.a(bArrC3, this.c, this.b);
                            this.i = gc0VarA;
                            this.d.a(gc0VarA);
                        }
                        byte b4 = bArrC3[0];
                        if (b4 == -2) {
                            i = ((bArrC3[4] & 3) << 12) | ((bArrC3[7] & 255) << 4);
                            b = bArrC3[6];
                        } else {
                            if (b4 == -1) {
                                i5 = ((bArrC3[7] & 3) << 12) | ((bArrC3[6] & 255) << 4) | ((bArrC3[9] & 60) >> 2);
                            } else if (b4 != 31) {
                                i = ((bArrC3[5] & 3) << 12) | ((bArrC3[6] & 255) << 4);
                                b = bArrC3[7];
                            } else {
                                i5 = ((bArrC3[8] & 60) >> 2) | ((bArrC3[6] & 3) << 12) | ((bArrC3[7] & 255) << 4);
                            }
                            i2 = i5 + 1;
                            z = true;
                            if (z) {
                                i2 = (i2 * 16) / 14;
                            }
                            this.j = i2;
                            if (b4 != -2) {
                                i3 = (bArrC3[5] & 1) << 6;
                                b2 = bArrC3[4];
                            } else {
                                if (b4 != -1) {
                                    i3 = (bArrC3[4] & 7) << 4;
                                    b3 = bArrC3[7];
                                } else if (b4 != 31) {
                                    i3 = (bArrC3[4] & 1) << 6;
                                    b2 = bArrC3[5];
                                } else {
                                    i3 = (bArrC3[5] & 7) << 4;
                                    b3 = bArrC3[6];
                                }
                                i4 = b3 & 60;
                                this.h = (int) ((((long) ((((i4 >> 2) | i3) + 1) * 32)) * 1000000) / ((long) this.i.A));
                                this.f9376a.e(0);
                                this.d.a(18, this.f9376a);
                                this.e = 2;
                            }
                            i4 = b2 & 252;
                            this.h = (int) ((((long) ((((i4 >> 2) | i3) + 1) * 32)) * 1000000) / ((long) this.i.A));
                            this.f9376a.e(0);
                            this.d.a(18, this.f9376a);
                            this.e = 2;
                        }
                        i2 = (i | ((b & 240) >> 4)) + 1;
                        z = false;
                        if (z) {
                            i2 = (i2 * 16) / 14;
                        }
                        this.j = i2;
                        if (b4 != -2) {
                            i3 = (bArrC3[5] & 1) << 6;
                            b2 = bArrC3[4];
                        } else {
                            if (b4 != -1) {
                                i3 = (bArrC3[4] & 7) << 4;
                                b3 = bArrC3[7];
                            } else if (b4 != 31) {
                                i3 = (bArrC3[4] & 1) << 6;
                                b2 = bArrC3[5];
                            } else {
                                i3 = (bArrC3[5] & 7) << 4;
                                b3 = bArrC3[6];
                            }
                            i4 = b3 & 60;
                            this.h = (int) ((((long) ((((i4 >> 2) | i3) + 1) * 32)) * 1000000) / ((long) this.i.A));
                            this.f9376a.e(0);
                            this.d.a(18, this.f9376a);
                            this.e = 2;
                        }
                        i4 = b2 & 252;
                        this.h = (int) ((((long) ((((i4 >> 2) | i3) + 1) * 32)) * 1000000) / ((long) this.i.A));
                        this.f9376a.e(0);
                        this.d.a(18, this.f9376a);
                        this.e = 2;
                    }
                } else if (i6 == 2) {
                    int iMin2 = Math.min(wf1Var.a(), this.j - this.f);
                    this.d.a(iMin2, wf1Var);
                    int i10 = this.f + iMin2;
                    this.f = i10;
                    int i11 = this.j;
                    if (i10 == i11) {
                        long j = this.k;
                        if (j != -9223372036854775807L) {
                            this.d.a(j, 1, i11, 0, null);
                            this.k += this.h;
                        }
                        this.e = 0;
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(y70 y70Var, i72.d dVar) {
        dVar.a();
        this.c = dVar.b();
        this.d = y70Var.a(dVar.c(), 1);
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(int i, long j) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.k = -9223372036854775807L;
    }
}
