package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
public final class dt1 implements t52 {
    private boolean A;
    private boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ct1 f8731a;
    private final f40 d;
    private final e40.a e;
    private c f;
    private gc0 g;
    private d40 h;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean w;
    private gc0 z;
    private final a b = new a();
    private int i = 1000;
    private int[] j = new int[1000];
    private long[] k = new long[1000];
    private long[] n = new long[1000];
    private int[] m = new int[1000];
    private int[] l = new int[1000];
    private t52.a[] o = new t52.a[1000];
    private final i12<b> c = new i12<>(new vr() { // from class: com.yandex.mobile.ads.impl.dt1$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.vr
        public final void accept(Object obj) {
            dt1.a((dt1.b) obj);
        }
    });
    private long t = Long.MIN_VALUE;
    private long u = Long.MIN_VALUE;
    private long v = Long.MIN_VALUE;
    private boolean y = true;
    private boolean x = true;

    public interface c {
    }

    protected dt1(cd cdVar, f40 f40Var, e40.a aVar) {
        this.d = f40Var;
        this.e = aVar;
        this.f8731a = new ct1(cdVar);
    }

    public final void i() {
        b(true);
        d40 d40Var = this.h;
        if (d40Var != null) {
            d40Var.a(this.e);
            this.h = null;
            this.g = null;
        }
    }

    public final int e() {
        return this.q + this.p;
    }

    public final void h() {
        a();
        d40 d40Var = this.h;
        if (d40Var != null) {
            d40Var.a(this.e);
            this.h = null;
            this.g = null;
        }
    }

    public final void g() throws IOException {
        d40 d40Var = this.h;
        if (d40Var == null || d40Var.getState() != 1) {
            return;
        }
        d40.a error = this.h.getError();
        error.getClass();
        throw error;
    }

    public final int c() {
        return this.q + this.s;
    }

    public final synchronized gc0 d() {
        return this.y ? null : this.z;
    }

    public final synchronized long b() {
        return this.v;
    }

    public final synchronized boolean f() {
        return this.w;
    }

    private synchronized void j() {
        this.s = 0;
        this.f8731a.c();
    }

    private synchronized void a(long j, int i, long j2, int i2, t52.a aVar) {
        f40.b bVarA;
        int i3 = this.p;
        if (i3 > 0) {
            int iC = c(i3 - 1);
            if (this.k[iC] + ((long) this.l[iC]) > j2) {
                throw new IllegalArgumentException();
            }
        }
        this.w = (536870912 & i) != 0;
        this.v = Math.max(this.v, j);
        int iC2 = c(this.p);
        this.n[iC2] = j;
        this.k[iC2] = j2;
        this.l[iC2] = i2;
        this.m[iC2] = i;
        this.o[iC2] = aVar;
        this.j[iC2] = 0;
        if (this.c.c() || !this.c.b().f8733a.equals(this.z)) {
            f40 f40Var = this.d;
            if (f40Var != null) {
                bVarA = f40Var.a(this.e, this.z);
            } else {
                bVarA = f40.b.f8866a;
            }
            i12<b> i12Var = this.c;
            int i4 = this.q + this.p;
            gc0 gc0Var = this.z;
            gc0Var.getClass();
            i12Var.a(i4, new b(gc0Var, bVarA));
        }
        int i5 = this.p + 1;
        this.p = i5;
        int i6 = this.i;
        if (i5 == i6) {
            int i7 = i6 + 1000;
            int[] iArr = new int[i7];
            long[] jArr = new long[i7];
            long[] jArr2 = new long[i7];
            int[] iArr2 = new int[i7];
            int[] iArr3 = new int[i7];
            t52.a[] aVarArr = new t52.a[i7];
            int i8 = this.r;
            int i9 = i6 - i8;
            System.arraycopy(this.k, i8, jArr, 0, i9);
            System.arraycopy(this.n, this.r, jArr2, 0, i9);
            System.arraycopy(this.m, this.r, iArr2, 0, i9);
            System.arraycopy(this.l, this.r, iArr3, 0, i9);
            System.arraycopy(this.o, this.r, aVarArr, 0, i9);
            System.arraycopy(this.j, this.r, iArr, 0, i9);
            int i10 = this.r;
            System.arraycopy(this.k, 0, jArr, i9, i10);
            System.arraycopy(this.n, 0, jArr2, i9, i10);
            System.arraycopy(this.m, 0, iArr2, i9, i10);
            System.arraycopy(this.l, 0, iArr3, i9, i10);
            System.arraycopy(this.o, 0, aVarArr, i9, i10);
            System.arraycopy(this.j, 0, iArr, i9, i10);
            this.k = jArr;
            this.n = jArr2;
            this.m = iArr2;
            this.l = iArr3;
            this.o = aVarArr;
            this.j = iArr;
            this.r = 0;
            this.i = i7;
        }
    }

    public final synchronized void d(int i) {
        if (i >= 0) {
            int i2 = this.s + i;
            if (i2 <= this.p) {
                this.s = i2;
            }
        }
        throw new IllegalArgumentException();
    }

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8732a;
        public long b;
        public t52.a c;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final gc0 f8733a;
        public final f40.b b;

        private b(gc0 gc0Var, f40.b bVar) {
            this.f8733a = gc0Var;
            this.b = bVar;
        }
    }

    private int c(int i) {
        int i2 = this.r + i;
        int i3 = this.i;
        return i2 < i3 ? i2 : i2 - i3;
    }

    private long b(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iC = c(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.n[iC]);
            if ((this.m[iC] & 1) != 0) {
                break;
            }
            iC--;
            if (iC == -1) {
                iC = this.i - 1;
            }
        }
        return jMax;
    }

    public final void b(boolean z) {
        this.f8731a.b();
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.x = true;
        this.t = Long.MIN_VALUE;
        this.u = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.w = false;
        this.c.a();
        if (z) {
            this.z = null;
            this.y = true;
        }
    }

    @Override // com.yandex.mobile.ads.impl.t52
    public final void b(int i, wf1 wf1Var) {
        this.f8731a.a(i, wf1Var);
    }

    private long a(int i) {
        this.u = Math.max(this.u, b(i));
        this.p -= i;
        int i2 = this.q + i;
        this.q = i2;
        int i3 = this.r + i;
        this.r = i3;
        int i4 = this.i;
        if (i3 >= i4) {
            this.r = i3 - i4;
        }
        int i5 = this.s - i;
        this.s = i5;
        if (i5 < 0) {
            this.s = 0;
        }
        this.c.a(i2);
        if (this.p == 0) {
            int i6 = this.r;
            if (i6 == 0) {
                i6 = this.i;
            }
            int i7 = i6 - 1;
            return this.k[i7] + ((long) this.l[i7]);
        }
        return this.k[this.r];
    }

    public final synchronized boolean b(long j, boolean z) {
        j();
        int iC = c(this.s);
        int i = this.s;
        int i2 = this.p;
        if (i != i2 && j >= this.n[iC] && (j <= this.v || z)) {
            int iA = a(iC, i2 - i, j, true);
            if (iA == -1) {
                return false;
            }
            this.t = j;
            this.s += iA;
            return true;
        }
        return false;
    }

    public final void a(long j, boolean z, boolean z2) {
        long jA;
        int i;
        ct1 ct1Var = this.f8731a;
        synchronized (this) {
            int i2 = this.p;
            jA = -1;
            if (i2 != 0) {
                long[] jArr = this.n;
                int i3 = this.r;
                if (j >= jArr[i3]) {
                    if (z2 && (i = this.s) != i2) {
                        i2 = i + 1;
                    }
                    int iA = a(i3, i2, j, z);
                    if (iA != -1) {
                        jA = a(iA);
                    }
                }
            }
        }
        ct1Var.a(jA);
    }

    public final void a() {
        long jA;
        ct1 ct1Var = this.f8731a;
        synchronized (this) {
            int i = this.p;
            jA = i == 0 ? -1L : a(i);
        }
        ct1Var.a(jA);
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.n[i];
            if (j2 > j) {
                break;
            }
            if (!z || (this.m[i] & 1) != 0) {
                i3 = i4;
                if (j2 == j) {
                    break;
                }
            }
            i++;
            if (i == this.i) {
                i = 0;
            }
        }
        return i3;
    }

    @Override // com.yandex.mobile.ads.impl.t52
    public final void a(gc0 gc0Var) {
        boolean z;
        synchronized (this) {
            z = false;
            this.y = false;
            if (!x82.a(gc0Var, this.z)) {
                if (!this.c.c() && this.c.b().f8733a.equals(gc0Var)) {
                    this.z = this.c.b().f8733a;
                } else {
                    this.z = gc0Var;
                }
                gc0 gc0Var2 = this.z;
                this.A = s01.a(gc0Var2.m, gc0Var2.j);
                this.B = false;
                z = true;
            }
        }
        c cVar = this.f;
        if (cVar == null || !z) {
            return;
        }
        ((am1) cVar).h();
    }

    public final synchronized int a(long j, boolean z) {
        int iC = c(this.s);
        int i = this.s;
        int i2 = this.p;
        if (i != i2 && j >= this.n[iC]) {
            if (j > this.v && z) {
                return i2 - i;
            }
            int iA = a(iC, i2 - i, j, true);
            if (iA == -1) {
                return 0;
            }
            return iA;
        }
        return 0;
    }

    public final synchronized boolean a(boolean z) {
        gc0 gc0Var;
        int i = this.s;
        boolean z2 = false;
        if (i != this.p) {
            if (this.c.b(this.q + i).f8733a != this.g) {
                return true;
            }
            int iC = c(this.s);
            d40 d40Var = this.h;
            if (d40Var == null || d40Var.getState() == 4 || ((this.m[iC] & 1073741824) == 0 && this.h.playClearSamplesWithoutKeys())) {
                z2 = true;
            }
            return z2;
        }
        if (z || this.w || ((gc0Var = this.z) != null && gc0Var != this.g)) {
            z2 = true;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(b bVar) {
        bVar.b.release();
    }

    private void a(gc0 gc0Var, hc0 hc0Var) {
        gc0 gc0Var2 = this.g;
        boolean z = gc0Var2 == null;
        c40 c40Var = z ? null : gc0Var2.p;
        this.g = gc0Var;
        c40 c40Var2 = gc0Var.p;
        f40 f40Var = this.d;
        hc0Var.b = f40Var != null ? gc0Var.a(f40Var.a(gc0Var)) : gc0Var;
        hc0Var.f9082a = this.h;
        if (this.d == null) {
            return;
        }
        if (z || !x82.a(c40Var, c40Var2)) {
            d40 d40Var = this.h;
            d40 d40VarB = this.d.b(this.e, gc0Var);
            this.h = d40VarB;
            hc0Var.f9082a = d40VarB;
            if (d40Var != null) {
                d40Var.a(this.e);
            }
        }
    }

    public final int a(hc0 hc0Var, oy oyVar, int i, boolean z) {
        int i2;
        boolean z2 = (i & 2) != 0;
        a aVar = this.b;
        synchronized (this) {
            oyVar.e = false;
            int i3 = this.s;
            i2 = -5;
            if (i3 != this.p) {
                gc0 gc0Var = this.c.b(this.q + i3).f8733a;
                if (!z2 && gc0Var == this.g) {
                    int iC = c(this.s);
                    d40 d40Var = this.h;
                    if (d40Var != null && d40Var.getState() != 4 && ((this.m[iC] & 1073741824) != 0 || !this.h.playClearSamplesWithoutKeys())) {
                        oyVar.e = true;
                        i2 = -3;
                    }
                    oyVar.d(this.m[iC]);
                    long j = this.n[iC];
                    oyVar.f = j;
                    if (j < this.t) {
                        oyVar.b(Integer.MIN_VALUE);
                    }
                    aVar.f8732a = this.l[iC];
                    aVar.b = this.k[iC];
                    aVar.c = this.o[iC];
                    i2 = -4;
                } else {
                    a(gc0Var, hc0Var);
                }
            } else if (!z && !this.w) {
                gc0 gc0Var2 = this.z;
                if (gc0Var2 == null || (!z2 && gc0Var2 == this.g)) {
                    i2 = -3;
                } else {
                    a(gc0Var2, hc0Var);
                }
            } else {
                oyVar.d(4);
                i2 = -4;
            }
        }
        if (i2 == -4 && !oyVar.f()) {
            boolean z3 = (i & 1) != 0;
            if ((i & 4) == 0) {
                if (z3) {
                    this.f8731a.a(oyVar, this.b);
                } else {
                    this.f8731a.b(oyVar, this.b);
                }
            }
            if (!z3) {
                this.s++;
            }
        }
        return i2;
    }

    @Override // com.yandex.mobile.ads.impl.t52
    public final int a(nv nvVar, int i, boolean z) throws IOException {
        return this.f8731a.a(nvVar, i, z);
    }

    @Override // com.yandex.mobile.ads.impl.t52
    public final void a(long j, int i, int i2, int i3, t52.a aVar) {
        int i4 = i & 1;
        boolean z = i4 != 0;
        if (this.x) {
            if (!z) {
                return;
            } else {
                this.x = false;
            }
        }
        if (this.A) {
            if (j < this.t) {
                return;
            }
            if (i4 == 0) {
                if (!this.B) {
                    at0.d("SampleQueue", "Overriding unexpected non-sync sample for format: " + this.z);
                    this.B = true;
                }
                i |= 1;
            }
        }
        a(j, i, (this.f8731a.a() - ((long) i2)) - ((long) i3), i2, aVar);
    }

    public final void a(long j) {
        this.t = j;
    }

    public final void a(c cVar) {
        this.f = cVar;
    }
}
