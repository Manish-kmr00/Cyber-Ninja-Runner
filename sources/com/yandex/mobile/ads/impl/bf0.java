package com.yandex.mobile.ads.impl;

import android.util.SparseArray;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class bf0 implements y40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cx1 f8503a;
    private final boolean b;
    private final boolean c;
    private long g;
    private String i;
    private t52 j;
    private a k;
    private boolean l;
    private boolean n;
    private final boolean[] h = new boolean[3];
    private final z31 d = new z31(7);
    private final z31 e = new z31(8);
    private final z31 f = new z31(6);
    private long m = -9223372036854775807L;
    private final wf1 o = new wf1();

    @Override // com.yandex.mobile.ads.impl.y40
    public final void b() {
    }

    /* JADX WARN: Code duplicated, block: B:104:0x02da  */
    /* JADX WARN: Code duplicated, block: B:105:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:110:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:148:0x039d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0097  */
    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(wf1 wf1Var) {
        int i;
        byte[] bArr;
        int i2;
        long j;
        int i3;
        long j2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        if (this.j == null) {
            throw new IllegalStateException();
        }
        int i9 = x82.f10629a;
        int iD = wf1Var.d();
        int iE = wf1Var.e();
        byte[] bArrC = wf1Var.c();
        this.g += (long) wf1Var.a();
        this.j.a(wf1Var.a(), wf1Var);
        while (true) {
            int iA = a41.a(bArrC, iD, iE, this.h);
            if (iA == iE) {
                if (!this.l || this.k.c) {
                    this.d.a(bArrC, iD, iE);
                    this.e.a(bArrC, iD, iE);
                }
                this.f.a(bArrC, iD, iE);
                this.k.a(bArrC, iD, iE);
                return;
            }
            int i10 = iA + 3;
            int i11 = bArrC[i10] & Ascii.US;
            int i12 = iA - iD;
            if (i12 > 0) {
                if (!this.l || this.k.c) {
                    this.d.a(bArrC, iD, iA);
                    this.e.a(bArrC, iD, iA);
                }
                this.f.a(bArrC, iD, iA);
                this.k.a(bArrC, iD, iA);
            }
            int i13 = iE - iA;
            long j3 = this.g - ((long) i13);
            int i14 = i12 < 0 ? -i12 : 0;
            long j4 = this.m;
            if (!this.l || this.k.c) {
                this.d.a(i14);
                this.e.a(i14);
                if (this.l) {
                    i = iE;
                    bArr = bArrC;
                    i2 = i10;
                    if (this.d.a()) {
                        z31 z31Var = this.d;
                        a41.c cVarB = a41.b(z31Var.d, 3, z31Var.e);
                        this.k.d.append(cVarB.d, cVarB);
                        this.d.b();
                    } else if (this.e.a()) {
                        z31 z31Var2 = this.e;
                        xf1 xf1Var = new xf1(z31Var2.d, 4, z31Var2.e);
                        int iE2 = xf1Var.e();
                        int iE3 = xf1Var.e();
                        xf1Var.f();
                        this.k.e.append(iE2, new a41.b(iE2, iE3, xf1Var.c()));
                        this.e.b();
                    }
                } else if (this.d.a() && this.e.a()) {
                    ArrayList arrayList = new ArrayList();
                    z31 z31Var3 = this.d;
                    arrayList.add(Arrays.copyOf(z31Var3.d, z31Var3.e));
                    z31 z31Var4 = this.e;
                    arrayList.add(Arrays.copyOf(z31Var4.d, z31Var4.e));
                    z31 z31Var5 = this.d;
                    a41.c cVarB2 = a41.b(z31Var5.d, 3, z31Var5.e);
                    z31 z31Var6 = this.e;
                    i = iE;
                    xf1 xf1Var2 = new xf1(z31Var6.d, 4, z31Var6.e);
                    int iE4 = xf1Var2.e();
                    int iE5 = xf1Var2.e();
                    xf1Var2.f();
                    a41.b bVar = new a41.b(iE4, iE5, xf1Var2.c());
                    bArr = bArrC;
                    i2 = i10;
                    this.j.a(new gc0.a().b(this.i).e("video/avc").a(String.format("avc1.%02X%02X%02X", Integer.valueOf(cVarB2.f8367a), Integer.valueOf(cVarB2.b), Integer.valueOf(cVarB2.c))).o(cVarB2.e).f(cVarB2.f).b(cVarB2.g).a(arrayList).a());
                    this.l = true;
                    this.k.d.append(cVarB2.d, cVarB2);
                    this.k.e.append(iE4, bVar);
                    this.d.b();
                    this.e.b();
                } else {
                    i = iE;
                    bArr = bArrC;
                    i2 = i10;
                }
            } else {
                i = iE;
                bArr = bArrC;
                i2 = i10;
            }
            if (this.f.a(i14)) {
                z31 z31Var7 = this.f;
                this.o.a(a41.a(z31Var7.e, z31Var7.d), this.f.d);
                this.o.e(4);
                this.f8503a.a(j4, this.o);
            }
            a aVar = this.k;
            boolean z2 = this.l;
            boolean z3 = this.n;
            if (aVar.i == 9) {
                if (z2 && aVar.o) {
                    j = aVar.j;
                    i3 = i13 + ((int) (j3 - j));
                    j2 = aVar.q;
                    if (j2 != -9223372036854775807L) {
                        aVar.f8504a.a(j2, aVar.r ? 1 : 0, (int) (j - aVar.p), i3, null);
                    }
                }
                aVar.p = aVar.j;
                aVar.q = aVar.l;
                aVar.r = false;
                aVar.o = true;
            } else if (aVar.c) {
                a.C0738a c0738a = aVar.n;
                a.C0738a c0738a2 = aVar.m;
                if (c0738a.f8505a) {
                    if (c0738a2.f8505a) {
                        a41.c cVar = c0738a.c;
                        if (cVar == null) {
                            throw new IllegalStateException();
                        }
                        a41.c cVar2 = c0738a2.c;
                        if (cVar2 == null) {
                            throw new IllegalStateException();
                        }
                        if (c0738a.f != c0738a2.f || c0738a.g != c0738a2.g || c0738a.h != c0738a2.h || ((c0738a.i && c0738a2.i && c0738a.j != c0738a2.j) || (((i6 = c0738a.d) != (i7 = c0738a2.d) && (i6 == 0 || i7 == 0)) || (((i8 = cVar.k) == 0 && cVar2.k == 0 && (c0738a.m != c0738a2.m || c0738a.n != c0738a2.n)) || ((i8 == 1 && cVar2.k == 1 && (c0738a.o != c0738a2.o || c0738a.p != c0738a2.p)) || (z = c0738a.k) != c0738a2.k || (z && c0738a.l != c0738a2.l)))))) {
                            if (z2) {
                                j = aVar.j;
                                i3 = i13 + ((int) (j3 - j));
                                j2 = aVar.q;
                                if (j2 != -9223372036854775807L) {
                                    aVar.f8504a.a(j2, aVar.r ? 1 : 0, (int) (j - aVar.p), i3, null);
                                }
                            }
                            aVar.p = aVar.j;
                            aVar.q = aVar.l;
                            aVar.r = false;
                            aVar.o = true;
                        }
                    } else {
                        if (z2) {
                            j = aVar.j;
                            i3 = i13 + ((int) (j3 - j));
                            j2 = aVar.q;
                            if (j2 != -9223372036854775807L) {
                                aVar.f8504a.a(j2, aVar.r ? 1 : 0, (int) (j - aVar.p), i3, null);
                            }
                        }
                        aVar.p = aVar.j;
                        aVar.q = aVar.l;
                        aVar.r = false;
                        aVar.o = true;
                    }
                }
            }
            if (aVar.b) {
                a.C0738a c0738a3 = aVar.n;
                z3 = c0738a3.b && ((i5 = c0738a3.e) == 7 || i5 == 2);
            }
            boolean z4 = aVar.r;
            int i15 = aVar.i;
            boolean z5 = z4 | (i15 == 5 || (z3 && i15 == 1));
            aVar.r = z5;
            if (z5) {
                this.n = false;
            }
            long j5 = this.m;
            if (!this.l || this.k.c) {
                this.d.b(i11);
                this.e.b(i11);
            }
            this.f.b(i11);
            a aVar2 = this.k;
            aVar2.i = i11;
            aVar2.l = j5;
            aVar2.j = j3;
            if (aVar2.b) {
                i4 = 1;
                if (i11 == 1) {
                    a.C0738a c0738a4 = aVar2.m;
                    aVar2.m = aVar2.n;
                    aVar2.n = c0738a4;
                    c0738a4.b = false;
                    c0738a4.f8505a = false;
                    aVar2.h = 0;
                    aVar2.k = true;
                }
                iE = i;
                bArrC = bArr;
                iD = i2;
            } else {
                i4 = 1;
            }
            if (aVar2.c && (i11 == 5 || i11 == i4 || i11 == 2)) {
                a.C0738a c0738a5 = aVar2.m;
                aVar2.m = aVar2.n;
                aVar2.n = c0738a5;
                c0738a5.b = false;
                c0738a5.f8505a = false;
                aVar2.h = 0;
                aVar2.k = true;
            }
            iE = i;
            bArrC = bArr;
            iD = i2;
        }
    }

    public bf0(cx1 cx1Var, boolean z, boolean z2) {
        this.f8503a = cx1Var;
        this.b = z;
        this.c = z2;
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(y70 y70Var, i72.d dVar) {
        dVar.a();
        this.i = dVar.b();
        t52 t52VarA = y70Var.a(dVar.c(), 2);
        this.j = t52VarA;
        this.k = new a(t52VarA, this.b, this.c);
        this.f8503a.a(y70Var, dVar);
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(int i, long j) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
        this.n = ((i & 2) != 0) | this.n;
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t52 f8504a;
        private final boolean b;
        private final boolean c;
        private final SparseArray<a41.c> d = new SparseArray<>();
        private final SparseArray<a41.b> e = new SparseArray<>();
        private final xf1 f;
        private byte[] g;
        private int h;
        private int i;
        private long j;
        private boolean k;
        private long l;
        private C0738a m;
        private C0738a n;
        private boolean o;
        private long p;
        private long q;
        private boolean r;

        public a(t52 t52Var, boolean z, boolean z2) {
            this.f8504a = t52Var;
            this.b = z;
            this.c = z2;
            this.m = new C0738a();
            this.n = new C0738a();
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new xf1(bArr, 0, 0);
            a();
        }

        /* JADX WARN: Code duplicated, block: B:53:0x00fa  */
        /* JADX WARN: Code duplicated, block: B:54:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:56:0x00ff  */
        /* JADX WARN: Code duplicated, block: B:58:0x0107 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:59:0x0108  */
        /* JADX WARN: Code duplicated, block: B:60:0x010f  */
        /* JADX WARN: Code duplicated, block: B:63:0x0114  */
        /* JADX WARN: Code duplicated, block: B:65:0x011e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:66:0x011f  */
        /* JADX WARN: Code duplicated, block: B:73:0x013f  */
        /* JADX WARN: Code duplicated, block: B:74:0x0143  */
        /* JADX WARN: Code duplicated, block: B:88:0x0177  */
        public final void a(byte[] bArr, int i, int i2) {
            boolean zC;
            boolean zC2;
            boolean z;
            boolean z2;
            int iE;
            int i3;
            int iD;
            int iD2;
            int i4;
            int iB;
            if (this.k) {
                int i5 = i2 - i;
                byte[] bArr2 = this.g;
                int length = bArr2.length;
                int i6 = this.h + i5;
                if (length < i6) {
                    this.g = Arrays.copyOf(bArr2, i6 * 2);
                }
                System.arraycopy(bArr, i, this.g, this.h, i5);
                int i7 = this.h + i5;
                this.h = i7;
                int i8 = 0;
                this.f.a(this.g, 0, i7);
                if (this.f.a(8)) {
                    this.f.f();
                    int iB2 = this.f.b(2);
                    this.f.d(5);
                    if (this.f.b()) {
                        this.f.e();
                        if (this.f.b()) {
                            int iE2 = this.f.e();
                            if (!this.c) {
                                this.k = false;
                                C0738a c0738a = this.n;
                                c0738a.e = iE2;
                                c0738a.b = true;
                                return;
                            }
                            if (this.f.b()) {
                                int iE3 = this.f.e();
                                if (this.e.indexOfKey(iE3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                a41.b bVar = this.e.get(iE3);
                                a41.c cVar = this.d.get(bVar.f8366a);
                                if (cVar.h) {
                                    if (!this.f.a(2)) {
                                        return;
                                    } else {
                                        this.f.d(2);
                                    }
                                }
                                if (this.f.a(cVar.j)) {
                                    int iB3 = this.f.b(cVar.j);
                                    if (!cVar.i) {
                                        if (this.f.a(1)) {
                                            zC = this.f.c();
                                            if (!zC) {
                                                zC2 = false;
                                            } else {
                                                if (!this.f.a(1)) {
                                                    return;
                                                }
                                                zC2 = this.f.c();
                                                z = true;
                                            }
                                            if (this.i == 5) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (z2) {
                                                iE = 0;
                                            } else if (!this.f.b()) {
                                                return;
                                            } else {
                                                iE = this.f.e();
                                            }
                                            i3 = cVar.k;
                                            if (i3 == 0) {
                                                if (!this.f.a(cVar.l)) {
                                                    return;
                                                }
                                                iB = this.f.b(cVar.l);
                                                if (bVar.b || zC) {
                                                    iD = 0;
                                                    i4 = iB;
                                                    iD2 = 0;
                                                } else {
                                                    if (!this.f.b()) {
                                                        return;
                                                    }
                                                    iD = this.f.d();
                                                    i4 = iB;
                                                    iD2 = 0;
                                                }
                                            } else if (i3 == 1 || cVar.m) {
                                                iD = 0;
                                                iD2 = 0;
                                                i4 = 0;
                                            } else {
                                                if (!this.f.b()) {
                                                    return;
                                                }
                                                int iD3 = this.f.d();
                                                if (!bVar.b || zC) {
                                                    iD = 0;
                                                    i4 = 0;
                                                    i8 = iD3;
                                                    iD2 = 0;
                                                } else {
                                                    if (!this.f.b()) {
                                                        return;
                                                    }
                                                    i4 = 0;
                                                    i8 = iD3;
                                                    iD2 = this.f.d();
                                                    iD = 0;
                                                }
                                            }
                                            C0738a c0738a2 = this.n;
                                            c0738a2.c = cVar;
                                            c0738a2.d = iB2;
                                            c0738a2.e = iE2;
                                            c0738a2.f = iB3;
                                            c0738a2.g = iE3;
                                            c0738a2.h = zC;
                                            c0738a2.i = z;
                                            c0738a2.j = zC2;
                                            c0738a2.k = z2;
                                            c0738a2.l = iE;
                                            c0738a2.m = i4;
                                            c0738a2.n = iD;
                                            c0738a2.o = i8;
                                            c0738a2.p = iD2;
                                            c0738a2.f8505a = true;
                                            c0738a2.b = true;
                                            this.k = false;
                                        }
                                        return;
                                    }
                                    zC = false;
                                    zC2 = false;
                                    z = zC2;
                                    if (this.i == 5) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        iE = 0;
                                    } else if (!this.f.b()) {
                                        return;
                                    } else {
                                        iE = this.f.e();
                                    }
                                    i3 = cVar.k;
                                    if (i3 == 0) {
                                        if (!this.f.a(cVar.l)) {
                                            return;
                                        }
                                        iB = this.f.b(cVar.l);
                                        if (bVar.b) {
                                            iD = 0;
                                            i4 = iB;
                                            iD2 = 0;
                                        } else {
                                            iD = 0;
                                            i4 = iB;
                                            iD2 = 0;
                                        }
                                    } else if (i3 == 1) {
                                        iD = 0;
                                        iD2 = 0;
                                        i4 = 0;
                                    } else {
                                        iD = 0;
                                        iD2 = 0;
                                        i4 = 0;
                                    }
                                    C0738a c0738a3 = this.n;
                                    c0738a3.c = cVar;
                                    c0738a3.d = iB2;
                                    c0738a3.e = iE2;
                                    c0738a3.f = iB3;
                                    c0738a3.g = iE3;
                                    c0738a3.h = zC;
                                    c0738a3.i = z;
                                    c0738a3.j = zC2;
                                    c0738a3.k = z2;
                                    c0738a3.l = iE;
                                    c0738a3.m = i4;
                                    c0738a3.n = iD;
                                    c0738a3.o = i8;
                                    c0738a3.p = iD2;
                                    c0738a3.f8505a = true;
                                    c0738a3.b = true;
                                    this.k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.bf0$a$a, reason: collision with other inner class name */
        private static final class C0738a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f8505a;
            private boolean b;
            private a41.c c;
            private int d;
            private int e;
            private int f;
            private int g;
            private boolean h;
            private boolean i;
            private boolean j;
            private boolean k;
            private int l;
            private int m;
            private int n;
            private int o;
            private int p;

            private C0738a() {
            }
        }

        public final void a() {
            this.k = false;
            this.o = false;
            C0738a c0738a = this.n;
            c0738a.b = false;
            c0738a.f8505a = false;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a() {
        this.g = 0L;
        this.n = false;
        this.m = -9223372036854775807L;
        a41.a(this.h);
        this.d.b();
        this.e.b();
        this.f.b();
        a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
    }
}
