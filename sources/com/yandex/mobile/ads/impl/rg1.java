package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes10.dex */
public final class rg1 implements i72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y40 f10105a;
    private final vf1 b = new vf1(new byte[10]);
    private int c = 0;
    private int d;
    private i52 e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;

    @Override // com.yandex.mobile.ads.impl.i72
    public final void a(int i, wf1 wf1Var) throws ag1 {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.e == null) {
            throw new IllegalStateException();
        }
        int i7 = 2;
        int i8 = 3;
        int i9 = -1;
        int i10 = 0;
        if ((i & 1) != 0) {
            int i11 = this.c;
            if (i11 != 0 && i11 != 1) {
                if (i11 == 2) {
                    at0.d("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.j != -1) {
                        at0.d("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
                    }
                    this.f10105a.b();
                }
            }
            this.c = 1;
            this.d = 0;
        }
        int i12 = i;
        while (wf1Var.a() > 0) {
            int i13 = this.c;
            if (i13 == 0) {
                i2 = i7;
                i3 = i8;
                i4 = i9;
                i5 = i10;
                wf1Var.f(wf1Var.a());
            } else if (i13 == 1) {
                i3 = i8;
                int i14 = i10;
                if (a(9, wf1Var, this.b.f10476a)) {
                    this.b.c(i14);
                    int iB = this.b.b(24);
                    if (iB != 1) {
                        tr0.a("Unexpected start code prefix: ", iB, "PesReader");
                        i4 = -1;
                        this.j = -1;
                        i6 = 0;
                        i2 = 2;
                    } else {
                        this.b.d(8);
                        int iB2 = this.b.b(16);
                        this.b.d(5);
                        this.k = this.b.f();
                        i2 = 2;
                        this.b.d(2);
                        this.f = this.b.f();
                        this.g = this.b.f();
                        this.b.d(6);
                        int iB3 = this.b.b(8);
                        this.i = iB3;
                        if (iB2 == 0) {
                            this.j = -1;
                            i4 = -1;
                        } else {
                            int i15 = (iB2 - 3) - iB3;
                            this.j = i15;
                            if (i15 < 0) {
                                at0.d("PesReader", "Found negative packet payload size: " + this.j);
                                i4 = -1;
                                this.j = -1;
                            } else {
                                i4 = -1;
                            }
                        }
                        i6 = 2;
                    }
                    this.c = i6;
                    i5 = 0;
                    this.d = 0;
                } else {
                    i5 = i14;
                    i4 = -1;
                    i2 = 2;
                }
            } else if (i13 != i7) {
                if (i13 != i8) {
                    throw new IllegalStateException();
                }
                int iA = wf1Var.a();
                int i16 = this.j;
                int i17 = i16 == i9 ? i10 : iA - i16;
                if (i17 > 0) {
                    iA -= i17;
                    wf1Var.d(wf1Var.d() + iA);
                }
                this.f10105a.a(wf1Var);
                int i18 = this.j;
                if (i18 != i9) {
                    int i19 = i18 - iA;
                    this.j = i19;
                    if (i19 == 0) {
                        this.f10105a.b();
                        this.c = 1;
                        this.d = i10;
                    }
                }
                i2 = i7;
                i3 = i8;
                i4 = i9;
                i5 = i10;
            } else if (a(Math.min(10, this.i), wf1Var, this.b.f10476a) && a(this.i, wf1Var, (byte[]) null)) {
                this.b.c(i10);
                this.l = -9223372036854775807L;
                if (this.f) {
                    this.b.d(4);
                    long jB = ((long) this.b.b(i8)) << 30;
                    this.b.d(1);
                    long jB2 = ((long) (this.b.b(15) << 15)) | jB;
                    this.b.d(1);
                    long jB3 = jB2 | ((long) this.b.b(15));
                    this.b.d(1);
                    if (!this.h && this.g) {
                        this.b.d(4);
                        long jB4 = ((long) this.b.b(i8)) << 30;
                        this.b.d(1);
                        long jB5 = ((long) (this.b.b(15) << 15)) | jB4;
                        this.b.d(1);
                        long jB6 = jB5 | ((long) this.b.b(15));
                        this.b.d(1);
                        this.e.b(jB6);
                        this.h = true;
                    }
                    this.l = this.e.b(jB3);
                }
                i12 |= this.k ? 4 : 0;
                this.f10105a.a(i12, this.l);
                this.c = 3;
                this.d = 0;
                i10 = 0;
                i9 = -1;
                i8 = 3;
                i7 = 2;
            } else {
                i3 = i8;
                i4 = i9;
                i5 = i10;
                i2 = 2;
            }
            i10 = i5;
            i9 = i4;
            i8 = i3;
            i7 = i2;
        }
    }

    public rg1(y40 y40Var) {
        this.f10105a = y40Var;
    }

    private boolean a(int i, wf1 wf1Var, byte[] bArr) {
        int iMin = Math.min(wf1Var.a(), i - this.d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            wf1Var.f(iMin);
        } else {
            wf1Var.a(bArr, this.d, iMin);
        }
        int i2 = this.d + iMin;
        this.d = i2;
        return i2 == i;
    }

    @Override // com.yandex.mobile.ads.impl.i72
    public final void a(i52 i52Var, y70 y70Var, i72.d dVar) {
        this.e = i52Var;
        this.f10105a.a(y70Var, dVar);
    }

    @Override // com.yandex.mobile.ads.impl.i72
    public final void a() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.f10105a.a();
    }
}
