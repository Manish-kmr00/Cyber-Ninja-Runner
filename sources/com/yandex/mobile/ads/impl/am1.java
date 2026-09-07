package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: classes5.dex */
final class am1 implements lw0, y70, ds0.a<a>, ds0.e, dt1.c {
    private static final Map<String, String> N;
    private static final gc0 O;
    private boolean B;
    private boolean D;
    private boolean E;
    private int F;
    private boolean G;
    private long H;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private final Uri b;
    private final qv c;
    private final f40 d;
    private final zr0 e;
    private final sw0.a f;
    private final e40.a g;
    private final b h;
    private final cd i;
    private final String j;
    private final long k;
    private final zl1 m;
    private lw0.a r;
    private ni0 s;
    private boolean v;
    private boolean w;
    private boolean x;
    private e y;
    private xw1 z;
    private final ds0 l = new ds0("ProgressiveMediaPeriod");
    private final gr n = new gr();
    private final Runnable o = new Runnable() { // from class: com.yandex.mobile.ads.impl.am1$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.f();
        }
    };
    private final Runnable p = new Runnable() { // from class: com.yandex.mobile.ads.impl.am1$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.d();
        }
    };
    private final Handler q = x82.a();
    private d[] u = new d[0];
    private dt1[] t = new dt1[0];
    private long I = -9223372036854775807L;
    private long A = -9223372036854775807L;
    private int C = 1;

    interface b {
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8421a;
        public final boolean b;

        public d(boolean z, int i) {
            this.f8421a = i;
            this.b = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f8421a == dVar.f8421a && this.b == dVar.b;
        }

        public final int hashCode() {
            return (this.f8421a * 31) + (this.b ? 1 : 0);
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        N = Collections.unmodifiableMap(map);
        O = new gc0.a().b("icy").e("application/x-icy").a();
    }

    private void j() {
        a aVar = new a(this.b, this.c, this.m, this, this.n);
        if (this.w) {
            long j = this.I;
            if (j == -9223372036854775807L) {
                throw new IllegalStateException();
            }
            long j2 = this.A;
            if (j2 != -9223372036854775807L && j > j2) {
                this.L = true;
                this.I = -9223372036854775807L;
                return;
            }
            xw1 xw1Var = this.z;
            xw1Var.getClass();
            long j3 = xw1Var.b(this.I).f10682a.b;
            long j4 = this.I;
            aVar.f.f9531a = j3;
            aVar.i = j4;
            aVar.h = true;
            aVar.l = false;
            for (dt1 dt1Var : this.t) {
                dt1Var.a(this.I);
            }
            this.I = -9223372036854775807L;
        }
        int iE = 0;
        for (dt1 dt1Var2 : this.t) {
            iE += dt1Var2.e();
        }
        this.K = iE;
        this.l.a(aVar, this, this.e.a(this.C));
        uv uvVar = aVar.j;
        sw0.a aVar2 = this.f;
        Uri uri = uvVar.f10424a;
        Collections.emptyMap();
        aVar2.b(new as0(), null, aVar.i, this.A);
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final void reevaluateBuffer(long j) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(xw1 xw1Var) {
        this.z = this.s == null ? xw1Var : new xw1.b(-9223372036854775807L, 0L);
        this.A = xw1Var.c();
        boolean z = !this.G && xw1Var.c() == -9223372036854775807L;
        this.B = z;
        this.C = z ? 7 : 1;
        ((cm1) this.h).a(this.A, xw1Var.b(), this.B);
        if (this.w) {
            return;
        }
        f();
    }

    public final void h() {
        this.q.post(this.o);
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final void maybeThrowPrepareError() throws IOException {
        this.l.a(this.e.a(this.C));
        if (this.L && !this.w) {
            throw ag1.a("Loading finished before preparation is complete.", (Exception) null);
        }
    }

    public am1(Uri uri, qv qvVar, zl1 zl1Var, f40 f40Var, e40.a aVar, zr0 zr0Var, sw0.a aVar2, b bVar, cd cdVar, String str, int i) {
        this.b = uri;
        this.c = qvVar;
        this.d = f40Var;
        this.g = aVar;
        this.e = zr0Var;
        this.f = aVar2;
        this.h = bVar;
        this.i = cdVar;
        this.j = str;
        this.k = i;
        this.m = zl1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.M) {
            return;
        }
        lw0.a aVar = this.r;
        aVar.getClass();
        aVar.a(this);
    }

    public final void i() {
        if (this.w) {
            for (dt1 dt1Var : this.t) {
                dt1Var.h();
            }
        }
        this.l.a(this);
        this.q.removeCallbacksAndMessages(null);
        this.r = null;
        this.M = true;
    }

    @Override // com.yandex.mobile.ads.impl.ds0.e
    public final void b() {
        for (dt1 dt1Var : this.t) {
            dt1Var.i();
        }
        ((mm) this.m).c();
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final s52 getTrackGroups() {
        c();
        return this.y.f8422a;
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final void discardBuffer(long j, boolean z) {
        c();
        if (this.I != -9223372036854775807L) {
            return;
        }
        boolean[] zArr = this.y.c;
        int length = this.t.length;
        for (int i = 0; i < length; i++) {
            this.t[i].a(j, z, zArr[i]);
        }
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final boolean continueLoading(long j) {
        if (this.L || this.l.c() || this.J) {
            return false;
        }
        if (this.w && this.F == 0) {
            return false;
        }
        boolean zE = this.n.e();
        if (this.l.d()) {
            return zE;
        }
        j();
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final boolean isLoading() {
        return this.l.d() && this.n.d();
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final long readDiscontinuity() {
        if (!this.E) {
            return -9223372036854775807L;
        }
        if (!this.L) {
            int iE = 0;
            for (dt1 dt1Var : this.t) {
                iE += dt1Var.e();
            }
            if (iE <= this.K) {
                return -9223372036854775807L;
            }
        }
        this.E = false;
        return this.H;
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final long getBufferedPositionUs() {
        long jA;
        c();
        if (this.L || this.F == 0) {
            return Long.MIN_VALUE;
        }
        long j = this.I;
        if (j != -9223372036854775807L) {
            return j;
        }
        if (this.x) {
            int length = this.t.length;
            jA = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                e eVar = this.y;
                if (eVar.b[i] && eVar.c[i] && !this.t[i].f()) {
                    jA = Math.min(jA, this.t[i].b());
                }
            }
        } else {
            jA = Long.MAX_VALUE;
        }
        if (jA == Long.MAX_VALUE) {
            jA = a(false);
        }
        return jA == Long.MIN_VALUE ? this.H : jA;
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final long seekToUs(long j) {
        c();
        boolean[] zArr = this.y.b;
        if (!this.z.b()) {
            j = 0;
        }
        this.E = false;
        this.H = j;
        if (this.I != -9223372036854775807L) {
            this.I = j;
            return j;
        }
        if (this.C != 7) {
            int length = this.t.length;
            for (int i = 0; i < length; i++) {
                if (this.t[i].b(j, false) || (!zArr[i] && this.x)) {
                }
            }
            return j;
        }
        this.J = false;
        this.I = j;
        this.L = false;
        if (this.l.d()) {
            for (dt1 dt1Var : this.t) {
                dt1Var.a();
            }
            this.l.a();
        } else {
            this.l.b();
            for (dt1 dt1Var2 : this.t) {
                dt1Var2.b(false);
            }
        }
        return j;
    }

    @Override // com.yandex.mobile.ads.impl.y70
    public final void a() {
        this.v = true;
        this.q.post(this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.G = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.q.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.am1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        g01 g01VarA;
        if (this.M || this.w || !this.v || this.z == null) {
            return;
        }
        for (dt1 dt1Var : this.t) {
            if (dt1Var.d() == null) {
                return;
            }
        }
        this.n.c();
        int length = this.t.length;
        r52[] r52VarArr = new r52[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            gc0 gc0VarD = this.t[i].d();
            gc0VarD.getClass();
            String str = gc0VarD.m;
            boolean zD = s01.d(str);
            boolean z = zD || s01.f(str);
            zArr[i] = z;
            this.x = z | this.x;
            ni0 ni0Var = this.s;
            if (ni0Var != null) {
                if (zD || this.u[i].b) {
                    g01 g01Var = gc0VarD.k;
                    if (g01Var == null) {
                        g01VarA = new g01(ni0Var);
                    } else {
                        g01VarA = g01Var.a(ni0Var);
                    }
                    gc0VarD = gc0VarD.a().a(g01VarA).a();
                }
                if (zD && gc0VarD.g == -1 && gc0VarD.h == -1 && ni0Var.b != -1) {
                    gc0VarD = gc0VarD.a().b(ni0Var.b).a();
                }
            }
            r52VarArr[i] = new r52(Integer.toString(i), gc0VarD.a(this.d.a(gc0VarD)));
        }
        this.y = new e(new s52(r52VarArr), zArr);
        this.w = true;
        lw0.a aVar = this.r;
        aVar.getClass();
        aVar.a((lw0) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNull({"trackState", "seekMap"})
    public void c() {
        if (this.w) {
            this.y.getClass();
            this.z.getClass();
            return;
        }
        throw new IllegalStateException();
    }

    private final class c implements et1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8420a;

        public c(int i) {
            this.f8420a = i;
        }

        @Override // com.yandex.mobile.ads.impl.et1
        public final boolean d() {
            am1 am1Var = am1.this;
            return !am1Var.E && am1Var.I == -9223372036854775807L && am1Var.t[this.f8420a].a(am1Var.L);
        }

        @Override // com.yandex.mobile.ads.impl.et1
        public final void a() throws IOException {
            am1 am1Var = am1.this;
            am1Var.t[this.f8420a].g();
            am1Var.l.a(am1Var.e.a(am1Var.C));
        }

        @Override // com.yandex.mobile.ads.impl.et1
        public final int a(hc0 hc0Var, oy oyVar, int i) {
            am1 am1Var = am1.this;
            int i2 = this.f8420a;
            if (am1Var.E || am1Var.I != -9223372036854775807L) {
                return -3;
            }
            am1Var.c();
            e eVar = am1Var.y;
            boolean[] zArr = eVar.d;
            if (!zArr[i2]) {
                gc0 gc0VarA = eVar.f8422a.a(i2).a(0);
                am1Var.f.a(s01.c(gc0VarA.m), gc0VarA, am1Var.H);
                zArr[i2] = true;
            }
            int iA = am1Var.t[i2].a(hc0Var, oyVar, i, am1Var.L);
            if (iA == -3) {
                am1Var.a(i2);
            }
            return iA;
        }

        @Override // com.yandex.mobile.ads.impl.et1
        public final int a(long j) {
            am1 am1Var = am1.this;
            int i = this.f8420a;
            int iA = 0;
            if (!am1Var.E && am1Var.I == -9223372036854775807L) {
                am1Var.c();
                e eVar = am1Var.y;
                boolean[] zArr = eVar.d;
                if (!zArr[i]) {
                    gc0 gc0VarA = eVar.f8422a.a(i).a(0);
                    am1Var.f.a(s01.c(gc0VarA.m), gc0VarA, am1Var.H);
                    zArr[i] = true;
                }
                dt1 dt1Var = am1Var.t[i];
                iA = dt1Var.a(j, am1Var.L);
                dt1Var.d(iA);
                if (iA == 0) {
                    am1Var.a(i);
                }
            }
            return iA;
        }
    }

    final class a implements ds0.d, li0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f8419a;
        private final l22 b;
        private final zl1 c;
        private final y70 d;
        private final gr e;
        private volatile boolean g;
        private long i;
        private uv j;
        private dt1 k;
        private boolean l;
        private final lj1 f = new lj1();
        private boolean h = true;

        public a(Uri uri, qv qvVar, zl1 zl1Var, y70 y70Var, gr grVar) {
            this.f8419a = uri;
            this.b = new l22(qvVar);
            this.c = zl1Var;
            this.d = y70Var;
            this.e = grVar;
            as0.a();
            this.j = a(0L);
        }

        @Override // com.yandex.mobile.ads.impl.ds0.d
        public final void b() {
            this.g = true;
        }

        @Override // com.yandex.mobile.ads.impl.ds0.d
        public final void a() throws IOException {
            qv li0Var;
            int i;
            int iA = 0;
            while (iA == 0 && !this.g) {
                try {
                    long j = this.f.f9531a;
                    uv uvVarA = a(j);
                    this.j = uvVarA;
                    long jA = this.b.a(uvVarA);
                    if (jA != -1) {
                        jA += j;
                        am1.this.g();
                    }
                    long j2 = jA;
                    am1.this.s = ni0.a(this.b.getResponseHeaders());
                    l22 l22Var = this.b;
                    ni0 ni0Var = am1.this.s;
                    if (ni0Var == null || (i = ni0Var.g) == -1) {
                        li0Var = l22Var;
                    } else {
                        li0Var = new li0(l22Var, i, this);
                        am1 am1Var = am1.this;
                        am1Var.getClass();
                        dt1 dt1VarA = am1Var.a(new d(true, 0));
                        this.k = dt1VarA;
                        dt1VarA.a(am1.O);
                    }
                    long jB = j;
                    ((mm) this.c).a(li0Var, this.f8419a, this.b.getResponseHeaders(), j, j2, this.d);
                    if (am1.this.s != null) {
                        ((mm) this.c).a();
                    }
                    if (this.h) {
                        ((mm) this.c).a(jB, this.i);
                        this.h = false;
                    }
                    while (true) {
                        long j3 = jB;
                        while (true) {
                            if (iA != 0 || this.g) {
                                break;
                            }
                            try {
                                this.e.a();
                                iA = ((mm) this.c).a(this.f);
                                jB = ((mm) this.c).b();
                                if (jB > am1.this.k + j3) {
                                    this.e.c();
                                    am1 am1Var2 = am1.this;
                                    am1Var2.q.post(am1Var2.p);
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                    }
                    if (iA == 1) {
                        iA = 0;
                    } else if (((mm) this.c).b() != -1) {
                        this.f.f9531a = ((mm) this.c).b();
                    }
                    tv.a(this.b);
                } catch (Throwable th) {
                    if (iA != 1 && ((mm) this.c).b() != -1) {
                        this.f.f9531a = ((mm) this.c).b();
                    }
                    tv.a(this.b);
                    throw th;
                }
            }
        }

        public final void a(wf1 wf1Var) {
            long jMax;
            if (!this.l) {
                jMax = this.i;
            } else {
                jMax = Math.max(am1.this.a(true), this.i);
            }
            int iA = wf1Var.a();
            dt1 dt1Var = this.k;
            dt1Var.getClass();
            dt1Var.b(iA, wf1Var);
            dt1Var.a(jMax, 1, iA, 0, (t52.a) null);
            this.l = true;
        }

        private uv a(long j) {
            return new uv.a().a(this.f8419a).b(j).a(am1.this.j).a(6).a(am1.N).a();
        }
    }

    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s52 f8422a;
        public final boolean[] b;
        public final boolean[] c;
        public final boolean[] d;

        public e(s52 s52Var, boolean[] zArr) {
            this.f8422a = s52Var;
            this.b = zArr;
            int i = s52Var.b;
            this.c = new boolean[i];
            this.d = new boolean[i];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
    
        if (java.lang.Math.abs(r7 - r18) <= java.lang.Math.abs(r9 - r18)) goto L34;
     */
    @Override // com.yandex.mobile.ads.impl.lw0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(long r18, com.yandex.mobile.ads.impl.yw1 r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r3 = r20
            r17.c()
            com.yandex.mobile.ads.impl.xw1 r4 = r0.z
            boolean r4 = r4.b()
            r5 = 0
            if (r4 != 0) goto L14
            return r5
        L14:
            com.yandex.mobile.ads.impl.xw1 r4 = r0.z
            com.yandex.mobile.ads.impl.xw1$a r4 = r4.b(r1)
            com.yandex.mobile.ads.impl.zw1 r7 = r4.f10682a
            long r7 = r7.f10856a
            com.yandex.mobile.ads.impl.zw1 r4 = r4.b
            long r9 = r4.f10856a
            long r11 = r3.f10776a
            int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r4 != 0) goto L30
            long r13 = r3.b
            int r4 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r4 != 0) goto L30
            r13 = r1
            goto L82
        L30:
            int r4 = com.yandex.mobile.ads.impl.x82.f10629a
            long r13 = r1 - r11
            long r11 = r11 ^ r1
            long r15 = r1 ^ r13
            long r11 = r11 & r15
            int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r4 >= 0) goto L3e
            r13 = -9223372036854775808
        L3e:
            long r3 = r3.b
            long r11 = r1 + r3
            long r15 = r1 ^ r11
            long r3 = r3 ^ r11
            long r3 = r3 & r15
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L4f
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L4f:
            int r3 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            r4 = 1
            r5 = 0
            if (r3 > 0) goto L5b
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 > 0) goto L5b
            r3 = r4
            goto L5c
        L5b:
            r3 = r5
        L5c:
            int r6 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r6 > 0) goto L65
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 > 0) goto L65
            goto L66
        L65:
            r4 = r5
        L66:
            if (r3 == 0) goto L7b
            if (r4 == 0) goto L7b
            long r3 = r7 - r1
            long r3 = java.lang.Math.abs(r3)
            long r1 = r9 - r1
            long r1 = java.lang.Math.abs(r1)
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 > 0) goto L81
            goto L7d
        L7b:
            if (r3 == 0) goto L7f
        L7d:
            r13 = r7
            goto L82
        L7f:
            if (r4 == 0) goto L82
        L81:
            r13 = r9
        L82:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.am1.a(long, com.yandex.mobile.ads.impl.yw1):long");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    public long a(boolean z) {
        long jMax = Long.MIN_VALUE;
        for (int i = 0; i < this.t.length; i++) {
            if (!z) {
                e eVar = this.y;
                eVar.getClass();
                if (eVar.c[i]) {
                    jMax = Math.max(jMax, this.t[i].b());
                }
            } else {
                jMax = Math.max(jMax, this.t[i].b());
            }
        }
        return jMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        c();
        boolean[] zArr = this.y.b;
        if (this.J && zArr[i] && !this.t[i].a(false)) {
            this.I = 0L;
            this.J = false;
            this.E = true;
            this.H = 0L;
            this.K = 0;
            for (dt1 dt1Var : this.t) {
                dt1Var.b(false);
            }
            lw0.a aVar = this.r;
            aVar.getClass();
            aVar.a(this);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ds0.a
    public final void a(ds0.d dVar, long j, long j2, boolean z) {
        a aVar = (a) dVar;
        aVar.b.getClass();
        as0 as0Var = new as0();
        this.e.getClass();
        this.f.a(as0Var, aVar.i, this.A);
        if (z) {
            return;
        }
        for (dt1 dt1Var : this.t) {
            dt1Var.b(false);
        }
        if (this.F > 0) {
            lw0.a aVar2 = this.r;
            aVar2.getClass();
            aVar2.a(this);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ds0.a
    public final void a(ds0.d dVar, long j, long j2) {
        xw1 xw1Var;
        a aVar = (a) dVar;
        if (this.A == -9223372036854775807L && (xw1Var = this.z) != null) {
            boolean zB = xw1Var.b();
            long jA = a(true);
            long j3 = jA == Long.MIN_VALUE ? 0L : jA + 10000;
            this.A = j3;
            ((cm1) this.h).a(j3, zB, this.B);
        }
        aVar.b.getClass();
        as0 as0Var = new as0();
        this.e.getClass();
        this.f.a(as0Var, (gc0) null, aVar.i, this.A);
        this.L = true;
        lw0.a aVar2 = this.r;
        aVar2.getClass();
        aVar2.a(this);
    }

    @Override // com.yandex.mobile.ads.impl.ds0.a
    public final ds0.b a(ds0.d dVar, long j, long j2, IOException iOException, int i) {
        ds0.b bVarA;
        xw1 xw1Var;
        a aVar = (a) dVar;
        aVar.b.getClass();
        as0 as0Var = new as0();
        x82.b(aVar.i);
        x82.b(this.A);
        long jA = this.e.a(new zr0.a(iOException, i));
        if (jA == -9223372036854775807L) {
            bVarA = ds0.e;
        } else {
            int iE = 0;
            for (dt1 dt1Var : this.t) {
                iE += dt1Var.e();
            }
            boolean z = iE > this.K;
            if (!this.G && ((xw1Var = this.z) == null || xw1Var.c() == -9223372036854775807L)) {
                boolean z2 = this.w;
                if (z2 && !this.E && this.I == -9223372036854775807L) {
                    this.J = true;
                    bVarA = ds0.d;
                } else {
                    this.E = z2;
                    this.H = 0L;
                    this.K = 0;
                    for (dt1 dt1Var2 : this.t) {
                        dt1Var2.b(false);
                    }
                    aVar.f.f9531a = 0L;
                    aVar.i = 0L;
                    aVar.h = true;
                    aVar.l = false;
                }
            } else {
                this.K = iE;
            }
            bVarA = ds0.a(jA, z);
        }
        boolean zA = bVarA.a();
        this.f.a(as0Var, 1, null, aVar.i, this.A, iOException, !zA);
        if (!zA) {
            this.e.getClass();
        }
        return bVarA;
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final void a(lw0.a aVar, long j) {
        this.r = aVar;
        this.n.e();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public dt1 a(d dVar) {
        int length = this.t.length;
        for (int i = 0; i < length; i++) {
            if (dVar.equals(this.u[i])) {
                return this.t[i];
            }
        }
        cd cdVar = this.i;
        f40 f40Var = this.d;
        e40.a aVar = this.g;
        f40Var.getClass();
        aVar.getClass();
        dt1 dt1Var = new dt1(cdVar, f40Var, aVar);
        dt1Var.a(this);
        int i2 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.u, i2);
        dVarArr[length] = dVar;
        this.u = dVarArr;
        dt1[] dt1VarArr = (dt1[]) Arrays.copyOf(this.t, i2);
        dt1VarArr[length] = dt1Var;
        this.t = dt1VarArr;
        return dt1Var;
    }

    @Override // com.yandex.mobile.ads.impl.y70
    public final void a(final xw1 xw1Var) {
        this.q.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.am1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(xw1Var);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final long a(e70[] e70VarArr, boolean[] zArr, et1[] et1VarArr, boolean[] zArr2, long j) {
        e70 e70Var;
        c();
        e eVar = this.y;
        s52 s52Var = eVar.f8422a;
        boolean[] zArr3 = eVar.c;
        int i = this.F;
        int i2 = 0;
        for (int i3 = 0; i3 < e70VarArr.length; i3++) {
            et1 et1Var = et1VarArr[i3];
            if (et1Var != null && (e70VarArr[i3] == null || !zArr[i3])) {
                int i4 = ((c) et1Var).f8420a;
                if (zArr3[i4]) {
                    this.F--;
                    zArr3[i4] = false;
                    et1VarArr[i3] = null;
                } else {
                    throw new IllegalStateException();
                }
            }
        }
        boolean z = !this.D ? j == 0 : i != 0;
        for (int i5 = 0; i5 < e70VarArr.length; i5++) {
            if (et1VarArr[i5] == null && (e70Var = e70VarArr[i5]) != null) {
                if (e70Var.b() == 1) {
                    if (e70Var.b(0) == 0) {
                        int iA = s52Var.a(e70Var.a());
                        if (!zArr3[iA]) {
                            this.F++;
                            zArr3[iA] = true;
                            et1VarArr[i5] = new c(iA);
                            zArr2[i5] = true;
                            if (!z) {
                                dt1 dt1Var = this.t[iA];
                                z = (dt1Var.b(j, true) || dt1Var.c() == 0) ? false : true;
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        }
        if (this.F == 0) {
            this.J = false;
            this.E = false;
            if (this.l.d()) {
                dt1[] dt1VarArr = this.t;
                int length = dt1VarArr.length;
                while (i2 < length) {
                    dt1VarArr[i2].a();
                    i2++;
                }
                this.l.a();
            } else {
                for (dt1 dt1Var2 : this.t) {
                    dt1Var2.b(false);
                }
            }
        } else if (z) {
            j = seekToUs(j);
            while (i2 < et1VarArr.length) {
                if (et1VarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.D = true;
        return j;
    }

    @Override // com.yandex.mobile.ads.impl.y70
    public final t52 a(int i, int i2) {
        return a(new d(false, i));
    }
}
