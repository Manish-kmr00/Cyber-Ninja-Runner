package com.yandex.mobile.ads.impl;

import androidx.core.view.MotionEventCompat;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class ib implements y40 {
    private static final byte[] v = {73, 68, 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9196a;
    private final vf1 b;
    private final wf1 c;
    private final String d;
    private String e;
    private t52 f;
    private t52 g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private t52 t;
    private long u;

    @Override // com.yandex.mobile.ads.impl.y40
    public final void b() {
    }

    public ib() {
        this(null, true);
    }

    /* JADX WARN: Code duplicated, block: B:117:0x02df  */
    /* JADX WARN: Code duplicated, block: B:120:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:122:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:124:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:126:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:157:0x02bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x02bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x02bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x0304 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x0321 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x031b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x0315 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x0302 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x025f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0274  */
    /* JADX WARN: Code duplicated, block: B:81:0x0277  */
    /* JADX WARN: Code duplicated, block: B:84:0x0283  */
    /* JADX WARN: Code duplicated, block: B:86:0x0288  */
    /* JADX WARN: Code duplicated, block: B:89:0x028d  */
    /* JADX WARN: Code duplicated, block: B:94:0x02a1  */
    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(wf1 wf1Var) throws ag1 {
        int i;
        int i2;
        char c;
        byte[] bArr;
        int iB;
        byte[] bArrC;
        int iE;
        int i3;
        byte b;
        int i4;
        int i5;
        int i6;
        byte b2;
        this.f.getClass();
        int i7 = x82.f10629a;
        while (wf1Var.a() > 0) {
            int i8 = this.h;
            int i9 = -1;
            int i10 = 4;
            if (i8 == 0) {
                byte[] bArrC2 = wf1Var.c();
                int iD = wf1Var.d();
                int iE2 = wf1Var.e();
                while (true) {
                    if (iD < iE2) {
                        int i11 = iD + 1;
                        byte b3 = bArrC2[iD];
                        int i12 = b3 & 255;
                        if (this.j == 512 && (((((byte) i12) & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK) & 65526) == 65520) {
                            if (!this.l) {
                                int i13 = iD - 1;
                                wf1Var.e(iD);
                                byte[] bArr2 = this.b.f10476a;
                                if (wf1Var.a() < 1) {
                                    i9 = i9;
                                } else {
                                    wf1Var.a(bArr2, 0, 1);
                                    this.b.c(i10);
                                    int iB2 = this.b.b(1);
                                    int i14 = this.m;
                                    if (i14 != i9 && iB2 != i14) {
                                        i9 = i9;
                                    } else if (this.n != i9) {
                                        byte[] bArr3 = this.b.f10476a;
                                        if (wf1Var.a() >= 1) {
                                            wf1Var.a(bArr3, 0, 1);
                                            this.b.c(2);
                                            if (this.b.b(i10) != this.n) {
                                                i9 = -1;
                                            } else {
                                                wf1Var.e(i11);
                                                bArr = this.b.f10476a;
                                                if (wf1Var.a() < i10) {
                                                    wf1Var.a(bArr, 0, i10);
                                                    this.b.c(14);
                                                    iB = this.b.b(13);
                                                    if (iB < 7) {
                                                        i9 = -1;
                                                    } else {
                                                        bArrC = wf1Var.c();
                                                        iE = wf1Var.e();
                                                        i3 = i13 + iB;
                                                        if (i3 >= iE) {
                                                            b = bArrC[i3];
                                                            i9 = -1;
                                                            if (b == -1) {
                                                                i6 = i3 + 1;
                                                                if (i6 == iE) {
                                                                    b2 = bArrC[i6];
                                                                    if ((((b2 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK) & 65526) == 65520 || ((b2 & 8) >> 3) != iB2) {
                                                                    }
                                                                }
                                                            } else if (b == 73 && ((i4 = i3 + 1) == iE || (bArrC[i4] == 68 && ((i5 = i3 + 2) == iE || bArrC[i5] == 51)))) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        bArr = this.b.f10476a;
                                        if (wf1Var.a() < i10) {
                                            wf1Var.a(bArr, 0, i10);
                                            this.b.c(14);
                                            iB = this.b.b(13);
                                            if (iB < 7) {
                                                i9 = -1;
                                            } else {
                                                bArrC = wf1Var.c();
                                                iE = wf1Var.e();
                                                i3 = i13 + iB;
                                                if (i3 >= iE) {
                                                    b = bArrC[i3];
                                                    i9 = -1;
                                                    if (b == -1) {
                                                        i6 = i3 + 1;
                                                        if (i6 == iE) {
                                                            b2 = bArrC[i6];
                                                            if ((((b2 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK) & 65526) == 65520) {
                                                            }
                                                        }
                                                    } else if (b == 73) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                i = this.j;
                                i2 = i | i12;
                                if (i2 != 329) {
                                    c = 3;
                                    this.j = 768;
                                } else if (i2 != 511) {
                                    c = 3;
                                    this.j = 512;
                                } else if (i2 != 836) {
                                    c = 3;
                                    this.j = 1024;
                                } else if (i2 != 1075) {
                                    this.h = 2;
                                    this.i = 3;
                                    this.r = 0;
                                    this.c.e(0);
                                    wf1Var.e(i11);
                                } else if (i != 256) {
                                    this.j = 256;
                                    i10 = 4;
                                } else {
                                    c = 3;
                                }
                                iD = i11;
                                i10 = 4;
                            }
                            this.o = (b3 & 8) >> 3;
                            this.k = (b3 & 1) == 0;
                            if (this.l) {
                                this.h = 3;
                                this.i = 0;
                            } else {
                                this.h = 1;
                                this.i = 0;
                            }
                            wf1Var.e(i11);
                        } else {
                            i9 = i9;
                            i = this.j;
                            i2 = i | i12;
                            if (i2 != 329) {
                                c = 3;
                                this.j = 768;
                            } else if (i2 != 511) {
                                c = 3;
                                this.j = 512;
                            } else if (i2 != 836) {
                                c = 3;
                                this.j = 1024;
                            } else if (i2 != 1075) {
                                this.h = 2;
                                this.i = 3;
                                this.r = 0;
                                this.c.e(0);
                                wf1Var.e(i11);
                            } else if (i != 256) {
                                this.j = 256;
                                i10 = 4;
                            } else {
                                c = 3;
                            }
                            iD = i11;
                            i10 = 4;
                        }
                    } else {
                        wf1Var.e(iD);
                    }
                }
            } else if (i8 != 1) {
                if (i8 == 2) {
                    byte[] bArrC3 = this.c.c();
                    int iMin = Math.min(wf1Var.a(), 10 - this.i);
                    wf1Var.a(bArrC3, this.i, iMin);
                    int i15 = this.i + iMin;
                    this.i = i15;
                    if (i15 == 10) {
                        this.g.a(10, this.c);
                        this.c.e(6);
                        t52 t52Var = this.g;
                        int iS = this.c.s() + 10;
                        this.h = 4;
                        this.i = 10;
                        this.t = t52Var;
                        this.u = 0L;
                        this.r = iS;
                    }
                } else if (i8 == 3) {
                    int i16 = this.k ? 7 : 5;
                    byte[] bArr4 = this.b.f10476a;
                    int iMin2 = Math.min(wf1Var.a(), i16 - this.i);
                    wf1Var.a(bArr4, this.i, iMin2);
                    int i17 = this.i + iMin2;
                    this.i = i17;
                    if (i17 == i16) {
                        this.b.c(0);
                        if (this.p) {
                            this.b.d(10);
                        } else {
                            int iB3 = this.b.b(2) + 1;
                            if (iB3 != 2) {
                                at0.d("AdtsReader", "Detected audio object type: " + iB3 + ", but assuming AAC LC.");
                                iB3 = 2;
                            }
                            this.b.d(5);
                            int iB4 = this.b.b(3);
                            int i18 = this.n;
                            byte[] bArr5 = {(byte) (((iB3 << 3) & 248) | ((i18 >> 1) & 7)), (byte) (((i18 << 7) & 128) | ((iB4 << 3) & 120))};
                            e.a aVarA = e.a(new vf1(2, bArr5), false);
                            gc0 gc0VarA = new gc0.a().b(this.e).e("audio/mp4a-latm").a(aVarA.c).c(aVarA.b).l(aVarA.f8746a).a(Collections.singletonList(bArr5)).d(this.d).a();
                            this.q = 1024000000 / ((long) gc0VarA.A);
                            this.f.a(gc0VarA);
                            this.p = true;
                        }
                        this.b.d(4);
                        int iB5 = this.b.b(13);
                        int i19 = iB5 - 7;
                        if (this.k) {
                            i19 = iB5 - 9;
                        }
                        t52 t52Var2 = this.f;
                        long j = this.q;
                        this.h = 4;
                        this.i = 0;
                        this.t = t52Var2;
                        this.u = j;
                        this.r = i19;
                    }
                } else {
                    if (i8 != 4) {
                        throw new IllegalStateException();
                    }
                    int iMin3 = Math.min(wf1Var.a(), this.r - this.i);
                    this.t.a(iMin3, wf1Var);
                    int i20 = this.i + iMin3;
                    this.i = i20;
                    int i21 = this.r;
                    if (i20 == i21) {
                        long j2 = this.s;
                        if (j2 != -9223372036854775807L) {
                            this.t.a(j2, 1, i21, 0, null);
                            this.s += this.u;
                        }
                        d();
                    }
                }
            } else if (wf1Var.a() != 0) {
                this.b.f10476a[0] = wf1Var.c()[wf1Var.d()];
                this.b.c(2);
                int iB6 = this.b.b(4);
                int i22 = this.n;
                if (i22 == -1 || iB6 == i22) {
                    if (!this.l) {
                        this.l = true;
                        this.m = this.o;
                        this.n = iB6;
                    }
                    this.h = 3;
                    this.i = 0;
                } else {
                    this.l = false;
                    d();
                }
            }
        }
    }

    public ib(String str, boolean z) {
        this.b = new vf1(new byte[7]);
        this.c = new wf1(Arrays.copyOf(v, 10));
        d();
        this.m = -1;
        this.n = -1;
        this.q = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.f9196a = z;
        this.d = str;
    }

    public final long c() {
        return this.q;
    }

    private void d() {
        this.h = 0;
        this.i = 0;
        this.j = 256;
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(y70 y70Var, i72.d dVar) {
        dVar.a();
        this.e = dVar.b();
        t52 t52VarA = y70Var.a(dVar.c(), 1);
        this.f = t52VarA;
        this.t = t52VarA;
        if (this.f9196a) {
            dVar.a();
            t52 t52VarA2 = y70Var.a(dVar.c(), 5);
            this.g = t52VarA2;
            t52VarA2.a(new gc0.a().b(dVar.b()).e("application/id3").a());
            return;
        }
        this.g = new o40();
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(int i, long j) {
        if (j != -9223372036854775807L) {
            this.s = j;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a() {
        this.s = -9223372036854775807L;
        this.l = false;
        d();
    }
}
