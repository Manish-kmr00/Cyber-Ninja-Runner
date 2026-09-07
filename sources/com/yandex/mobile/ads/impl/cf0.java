package com.yandex.mobile.ads.impl;

import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes11.dex */
public final class cf0 implements y40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cx1 f8596a;
    private String b;
    private t52 c;
    private a d;
    private boolean e;
    private long l;
    private final boolean[] f = new boolean[3];
    private final z31 g = new z31(32);
    private final z31 h = new z31(33);
    private final z31 i = new z31(34);
    private final z31 j = new z31(39);
    private final z31 k = new z31(40);
    private long m = -9223372036854775807L;
    private final wf1 n = new wf1();

    @Override // com.yandex.mobile.ads.impl.y40
    public final void b() {
    }

    /* JADX WARN: Code duplicated, block: B:173:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:176:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:179:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:182:0x0422  */
    /* JADX WARN: Code duplicated, block: B:184:0x0426  */
    /* JADX WARN: Code duplicated, block: B:185:0x042b  */
    /* JADX WARN: Code duplicated, block: B:195:0x045d  */
    /* JADX WARN: Code duplicated, block: B:204:0x0479  */
    /* JADX WARN: Code duplicated, block: B:207:0x047f  */
    /* JADX WARN: Code duplicated, block: B:210:0x0485  */
    /* JADX WARN: Code duplicated, block: B:213:0x048b  */
    /* JADX WARN: Code duplicated, block: B:217:0x0492  */
    /* JADX WARN: Code duplicated, block: B:220:0x049a  */
    /* JADX WARN: Code duplicated, block: B:42:0x00db  */
    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(wf1 wf1Var) {
        int i;
        long j;
        a aVar;
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        if (this.c == null) {
            throw new IllegalStateException();
        }
        int i3 = x82.f10629a;
        while (wf1Var.a() > 0) {
            int iD = wf1Var.d();
            int iE = wf1Var.e();
            byte[] bArrC = wf1Var.c();
            this.l += (long) wf1Var.a();
            this.c.a(wf1Var.a(), wf1Var);
            while (iD < iE) {
                int iA = a41.a(bArrC, iD, iE, this.f);
                if (iA == iE) {
                    a(bArrC, iD, iE);
                    return;
                }
                int i4 = iA + 3;
                int i5 = (bArrC[i4] & 126) >> 1;
                int i6 = iA - iD;
                if (i6 > 0) {
                    a(bArrC, iD, iA);
                }
                int i7 = iE - iA;
                long j2 = this.l - ((long) i7);
                int i8 = i6 < 0 ? -i6 : 0;
                long j3 = this.m;
                a aVar2 = this.d;
                boolean z5 = this.e;
                if (aVar2.j && aVar2.g) {
                    aVar2.m = aVar2.c;
                    aVar2.j = false;
                } else {
                    if (aVar2.h || aVar2.g) {
                        if (z5 && aVar2.i) {
                            long j4 = aVar2.b;
                            i = iE;
                            int i9 = i7 + ((int) (j2 - j4));
                            long j5 = aVar2.l;
                            if (j5 != -9223372036854775807L) {
                                aVar2.f8597a.a(j5, aVar2.m ? 1 : 0, (int) (j4 - aVar2.k), i9, null);
                            }
                        } else {
                            i = iE;
                        }
                        aVar2.k = aVar2.b;
                        aVar2.l = aVar2.e;
                        aVar2.m = aVar2.c;
                        aVar2.i = true;
                    }
                    if (this.e) {
                        j = j2;
                    } else {
                        this.g.a(i8);
                        this.h.a(i8);
                        this.i.a(i8);
                        if (!this.g.a() && this.h.a() && this.i.a()) {
                            t52 t52Var = this.c;
                            String str = this.b;
                            z31 z31Var = this.g;
                            z31 z31Var2 = this.h;
                            z31 z31Var3 = this.i;
                            int i10 = z31Var.e;
                            byte[] bArr = new byte[z31Var2.e + i10 + z31Var3.e];
                            System.arraycopy(z31Var.d, 0, bArr, 0, i10);
                            System.arraycopy(z31Var2.d, 0, bArr, z31Var.e, z31Var2.e);
                            System.arraycopy(z31Var3.d, 0, bArr, z31Var.e + z31Var2.e, z31Var3.e);
                            xf1 xf1Var = new xf1(z31Var2.d, 0, z31Var2.e);
                            xf1Var.d(44);
                            int iB = xf1Var.b(3);
                            xf1Var.f();
                            int i11 = 2;
                            int iB2 = xf1Var.b(2);
                            boolean zC = xf1Var.c();
                            int iB3 = xf1Var.b(5);
                            int i12 = 0;
                            int i13 = 0;
                            for (int i14 = 32; i12 < i14; i14 = 32) {
                                if (xf1Var.c()) {
                                    i13 |= 1 << i12;
                                }
                                i12++;
                            }
                            int[] iArr = new int[6];
                            for (int i15 = 0; i15 < 6; i15++) {
                                iArr[i15] = xf1Var.b(8);
                            }
                            int iB4 = xf1Var.b(8);
                            int i16 = 0;
                            for (int i17 = 0; i17 < iB; i17++) {
                                if (xf1Var.c()) {
                                    i16 += 89;
                                }
                                if (xf1Var.c()) {
                                    i16 += 8;
                                }
                            }
                            xf1Var.d(i16);
                            if (iB > 0) {
                                xf1Var.d((8 - iB) * 2);
                            }
                            xf1Var.e();
                            int iE2 = xf1Var.e();
                            if (iE2 == 3) {
                                xf1Var.f();
                            }
                            int iE3 = xf1Var.e();
                            int iE4 = xf1Var.e();
                            if (xf1Var.c()) {
                                int iE5 = xf1Var.e();
                                int iE6 = xf1Var.e();
                                int iE7 = xf1Var.e();
                                int iE8 = xf1Var.e();
                                iE3 -= (iE5 + iE6) * ((iE2 == 1 || iE2 == 2) ? 2 : 1);
                                iE4 -= (iE7 + iE8) * (iE2 == 1 ? 2 : 1);
                            }
                            xf1Var.e();
                            xf1Var.e();
                            int iE9 = xf1Var.e();
                            for (int i18 = xf1Var.c() ? 0 : iB; i18 <= iB; i18++) {
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
                                int i19 = 0;
                                for (int i20 = 4; i19 < i20; i20 = 4) {
                                    int i21 = 0;
                                    while (i21 < 6) {
                                        if (xf1Var.c()) {
                                            int iMin = Math.min(64, 1 << ((i19 << 1) + 4));
                                            if (i19 > 1) {
                                                xf1Var.d();
                                            }
                                            for (int i22 = 0; i22 < iMin; i22++) {
                                                xf1Var.d();
                                            }
                                        } else {
                                            xf1Var.e();
                                        }
                                        i21 += i19 == 3 ? 3 : 1;
                                        j2 = j2;
                                    }
                                    i19++;
                                    i11 = 2;
                                }
                            }
                            j = j2;
                            xf1Var.d(i11);
                            if (xf1Var.c()) {
                                xf1Var.d(8);
                                xf1Var.e();
                                xf1Var.e();
                                xf1Var.f();
                            }
                            int i23 = 0;
                            boolean zC2 = false;
                            int i24 = 0;
                            for (int iE10 = xf1Var.e(); i23 < iE10; iE10 = iE10) {
                                if (i23 != 0) {
                                    zC2 = xf1Var.c();
                                }
                                if (zC2) {
                                    xf1Var.f();
                                    xf1Var.e();
                                    for (int i25 = 0; i25 <= i24; i25++) {
                                        if (xf1Var.c()) {
                                            xf1Var.f();
                                        }
                                    }
                                } else {
                                    int iE11 = xf1Var.e();
                                    int iE12 = xf1Var.e();
                                    int i26 = iE11 + iE12;
                                    for (int i27 = 0; i27 < iE11; i27++) {
                                        xf1Var.e();
                                        xf1Var.f();
                                    }
                                    for (int i28 = 0; i28 < iE12; i28++) {
                                        xf1Var.e();
                                        xf1Var.f();
                                    }
                                    i24 = i26;
                                }
                                i23++;
                            }
                            if (xf1Var.c()) {
                                for (int i29 = 0; i29 < xf1Var.e(); i29++) {
                                    xf1Var.d(iE9 + 5);
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
                                        float[] fArr = a41.b;
                                        if (iB5 < 17) {
                                            f = fArr[iB5];
                                        } else {
                                            tr0.a("Unexpected aspect_ratio_idc value: ", iB5, "H265Reader");
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
                                    iE4 *= 2;
                                }
                            }
                            t52Var.a(new gc0.a().b(str).e("video/hevc").a(mq.a(iB2, zC, iB3, i13, iArr, iB4)).o(iE3).f(iE4).b(f).a(Collections.singletonList(bArr)).a());
                            this.e = true;
                        } else {
                            j = j2;
                        }
                    }
                    if (this.j.a(i8)) {
                        z31 z31Var4 = this.j;
                        this.n.a(a41.a(z31Var4.e, z31Var4.d), this.j.d);
                        this.n.f(5);
                        this.f8596a.a(j3, this.n);
                    }
                    if (this.k.a(i8)) {
                        z31 z31Var5 = this.k;
                        this.n.a(a41.a(z31Var5.e, z31Var5.d), this.k.d);
                        this.n.f(5);
                        this.f8596a.a(j3, this.n);
                    }
                    long j6 = this.m;
                    aVar = this.d;
                    boolean z6 = this.e;
                    aVar.g = false;
                    aVar.h = false;
                    aVar.e = j6;
                    aVar.d = 0;
                    long j7 = j;
                    aVar.b = j7;
                    if (i5 >= 32) {
                        if (i5 == 40) {
                            i2 = 16;
                            z = true;
                            z2 = false;
                        } else {
                            if (aVar.i || aVar.j) {
                                z2 = false;
                            } else {
                                if (z6) {
                                    long j8 = aVar.l;
                                    if (j8 != -9223372036854775807L) {
                                        aVar.f8597a.a(j8, aVar.m ? 1 : 0, (int) (j7 - aVar.k), i7, null);
                                    }
                                }
                                z2 = false;
                                aVar.i = false;
                            }
                            if ((32 > i5 && i5 <= 35) || i5 == 39) {
                                z = true;
                                aVar.h = !aVar.j;
                                aVar.j = true;
                            }
                        }
                        if (i5 >= i2 || i5 > 21) {
                            z3 = z2;
                        } else {
                            z3 = z;
                        }
                        aVar.c = z3;
                        if (!z3 || i5 <= 9) {
                            z4 = z;
                        } else {
                            z4 = z2;
                        }
                        aVar.f = z4;
                        if (!this.e) {
                            this.g.b(i5);
                            this.h.b(i5);
                            this.i.b(i5);
                        }
                        this.j.b(i5);
                        this.k.b(i5);
                        iE = i;
                        bArrC = bArrC;
                        iD = i4;
                    } else {
                        z = true;
                        z2 = false;
                    }
                    i2 = 16;
                    if (i5 >= i2) {
                        z3 = z2;
                    } else {
                        z3 = z2;
                    }
                    aVar.c = z3;
                    if (z3) {
                        z4 = z;
                    } else {
                        z4 = z;
                    }
                    aVar.f = z4;
                    if (!this.e) {
                        this.g.b(i5);
                        this.h.b(i5);
                        this.i.b(i5);
                    }
                    this.j.b(i5);
                    this.k.b(i5);
                    iE = i;
                    bArrC = bArrC;
                    iD = i4;
                }
                i = iE;
                if (this.e) {
                    this.g.a(i8);
                    this.h.a(i8);
                    this.i.a(i8);
                    if (!this.g.a()) {
                        j = j2;
                    } else {
                        j = j2;
                    }
                } else {
                    j = j2;
                }
                if (this.j.a(i8)) {
                    z31 z31Var6 = this.j;
                    this.n.a(a41.a(z31Var6.e, z31Var6.d), this.j.d);
                    this.n.f(5);
                    this.f8596a.a(j3, this.n);
                }
                if (this.k.a(i8)) {
                    z31 z31Var7 = this.k;
                    this.n.a(a41.a(z31Var7.e, z31Var7.d), this.k.d);
                    this.n.f(5);
                    this.f8596a.a(j3, this.n);
                }
                long j9 = this.m;
                aVar = this.d;
                boolean z7 = this.e;
                aVar.g = false;
                aVar.h = false;
                aVar.e = j9;
                aVar.d = 0;
                long j10 = j;
                aVar.b = j10;
                if (i5 >= 32) {
                    if (i5 == 40) {
                        i2 = 16;
                        z = true;
                        z2 = false;
                    } else {
                        if (aVar.i) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        z = 32 > i5 ? true : true;
                    }
                    if (i5 >= i2) {
                        z3 = z2;
                    } else {
                        z3 = z2;
                    }
                    aVar.c = z3;
                    if (z3) {
                        z4 = z;
                    } else {
                        z4 = z;
                    }
                    aVar.f = z4;
                    if (!this.e) {
                        this.g.b(i5);
                        this.h.b(i5);
                        this.i.b(i5);
                    }
                    this.j.b(i5);
                    this.k.b(i5);
                    iE = i;
                    bArrC = bArrC;
                    iD = i4;
                } else {
                    z = true;
                    z2 = false;
                }
                i2 = 16;
                if (i5 >= i2) {
                    z3 = z2;
                } else {
                    z3 = z2;
                }
                aVar.c = z3;
                if (z3) {
                    z4 = z;
                } else {
                    z4 = z;
                }
                aVar.f = z4;
                if (!this.e) {
                    this.g.b(i5);
                    this.h.b(i5);
                    this.i.b(i5);
                }
                this.j.b(i5);
                this.k.b(i5);
                iE = i;
                bArrC = bArrC;
                iD = i4;
            }
        }
    }

    public cf0(cx1 cx1Var) {
        this.f8596a = cx1Var;
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(y70 y70Var, i72.d dVar) {
        dVar.a();
        this.b = dVar.b();
        t52 t52VarA = y70Var.a(dVar.c(), 2);
        this.c = t52VarA;
        this.d = new a(t52VarA);
        this.f8596a.a(y70Var, dVar);
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t52 f8597a;
        private long b;
        private boolean c;
        private int d;
        private long e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private long k;
        private long l;
        private boolean m;

        public a(t52 t52Var) {
            this.f8597a = t52Var;
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void a(byte[] bArr, int i, int i2) {
        a aVar = this.d;
        if (aVar.f) {
            int i3 = aVar.d;
            int i4 = (i + 2) - i3;
            if (i4 < i2) {
                aVar.g = (bArr[i4] & 128) != 0;
                aVar.f = false;
            } else {
                aVar.d = (i2 - i) + i3;
            }
        }
        if (!this.e) {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(int i, long j) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a() {
        this.l = 0L;
        this.m = -9223372036854775807L;
        a41.a(this.f);
        this.g.b();
        this.h.b();
        this.i.b();
        this.j.b();
        this.k.b();
        a aVar = this.d;
        if (aVar != null) {
            aVar.f = false;
            aVar.g = false;
            aVar.h = false;
            aVar.i = false;
            aVar.j = false;
        }
    }
}
