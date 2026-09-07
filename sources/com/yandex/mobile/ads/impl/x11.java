package com.yandex.mobile.ads.impl;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class x11 implements w70, xw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10614a;
    private final wf1 b;
    private final wf1 c;
    private final wf1 d;
    private final wf1 e;
    private final ArrayDeque<jh.a> f;
    private final bx1 g;
    private final ArrayList h;
    private int i;
    private int j;
    private long k;
    private int l;
    private wf1 m;
    private int n;
    private int o;
    private int p;
    private int q;
    private y70 r;
    private a[] s;
    private long[][] t;
    private int u;
    private long v;
    private int w;
    private v11 x;

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.x11$$ExternalSyntheticLambda1
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return x11.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o52 a(o52 o52Var) {
        return o52Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ w70[] d() {
        return new w70[]{new x11()};
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final boolean b() {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final xw1.a b(long j) {
        long jMin;
        long jMin2;
        long j2;
        boolean z;
        long j3;
        int iA;
        long j4 = j;
        a[] aVarArr = this.s;
        if (aVarArr.length == 0) {
            zw1 zw1Var = zw1.c;
            return new xw1.a(zw1Var, zw1Var);
        }
        int i = this.u;
        boolean z2 = false;
        if (i != -1) {
            u52 u52Var = aVarArr[i].b;
            int iB = x82.b(u52Var.f, j4, false);
            while (true) {
                if (iB < 0) {
                    iB = -1;
                    break;
                }
                if ((u52Var.g[iB] & 1) != 0) {
                    break;
                }
                iB--;
            }
            if (iB == -1) {
                iB = u52Var.a(j4);
            }
            if (iB == -1) {
                zw1 zw1Var2 = zw1.c;
                return new xw1.a(zw1Var2, zw1Var2);
            }
            long j5 = u52Var.f[iB];
            jMin = u52Var.c[iB];
            if (j5 >= j4 || iB >= u52Var.b - 1 || (iA = u52Var.a(j4)) == -1 || iA == iB) {
                j3 = -1;
                j2 = -9223372036854775807L;
            } else {
                j2 = u52Var.f[iA];
                j3 = u52Var.c[iA];
            }
            jMin2 = j3;
            j4 = j5;
        } else {
            jMin = Long.MAX_VALUE;
            jMin2 = -1;
            j2 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            a[] aVarArr2 = this.s;
            if (i2 >= aVarArr2.length) {
                break;
            }
            if (i2 != this.u) {
                u52 u52Var2 = aVarArr2[i2].b;
                int iB2 = x82.b(u52Var2.f, j4, z2);
                while (true) {
                    if (iB2 < 0) {
                        iB2 = -1;
                        break;
                    }
                    if ((u52Var2.g[iB2] & 1) != 0) {
                        break;
                    }
                    iB2--;
                }
                if (iB2 == -1) {
                    iB2 = u52Var2.a(j4);
                }
                if (iB2 != -1) {
                    jMin = Math.min(u52Var2.c[iB2], jMin);
                }
                if (j2 != -9223372036854775807L) {
                    z = false;
                    int iB3 = x82.b(u52Var2.f, j2, false);
                    while (true) {
                        if (iB3 < 0) {
                            iB3 = -1;
                            break;
                        }
                        if ((u52Var2.g[iB3] & 1) != 0) {
                            break;
                        }
                        iB3--;
                    }
                    if (iB3 == -1) {
                        iB3 = u52Var2.a(j2);
                    }
                    if (iB3 != -1) {
                        jMin2 = Math.min(u52Var2.c[iB3], jMin2);
                    }
                } else {
                    z = false;
                }
            } else {
                z = z2;
            }
            i2++;
            z2 = z;
        }
        zw1 zw1Var3 = new zw1(j4, jMin);
        return j2 == -9223372036854775807L ? new xw1.a(zw1Var3, zw1Var3) : new xw1.a(zw1Var3, new zw1(j2, jMin2));
    }

    public x11() {
        this(0);
    }

    public x11(int i) {
        this.f10614a = 0;
        this.i = 0;
        this.g = new bx1();
        this.h = new ArrayList();
        this.e = new wf1(16);
        this.f = new ArrayDeque<>();
        this.b = new wf1(a41.f8364a);
        this.c = new wf1(4);
        this.d = new wf1();
        this.n = -1;
        this.r = y70.f10708a;
        this.s = new a[0];
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.r = y70Var;
    }

    @Override // com.yandex.mobile.ads.impl.xw1
    public final long c() {
        return this.v;
    }

    /* JADX WARN: Code duplicated, block: B:94:0x021b  */
    private void a(jh.a aVar) throws ag1 {
        g01 g01Var;
        g01 g01Var2;
        g01 g01Var3;
        long j;
        int i;
        g01 g01Var4;
        int i2;
        int i3;
        int i4;
        int i5;
        nu0 nu0Var;
        ArrayList arrayList = new ArrayList();
        boolean z = this.w == 1;
        fe0 fe0Var = new fe0();
        jh.b bVarC = aVar.c(1969517665);
        int i6 = 1751411826;
        int i7 = 4;
        if (bVarC != null) {
            int i8 = kh.b;
            wf1 wf1Var = bVarC.b;
            wf1Var.e(8);
            g01 g01Var5 = null;
            g01 g01Var6 = null;
            for (int i9 = 8; wf1Var.a() >= i9; i9 = 8) {
                int iD = wf1Var.d();
                int iH = wf1Var.h();
                int iH2 = wf1Var.h();
                if (iH2 == 1835365473) {
                    wf1Var.e(iD);
                    int i10 = iD + iH;
                    wf1Var.f(i9);
                    int iD2 = wf1Var.d();
                    wf1Var.f(i7);
                    if (wf1Var.h() != i6) {
                        iD2 += 4;
                    }
                    wf1Var.e(iD2);
                    while (true) {
                        if (wf1Var.d() < i10) {
                            int iD3 = wf1Var.d();
                            int iH3 = wf1Var.h();
                            if (wf1Var.h() == 1768715124) {
                                wf1Var.e(iD3);
                                int i11 = iD3 + iH3;
                                wf1Var.f(i9);
                                ArrayList arrayList2 = new ArrayList();
                                while (wf1Var.d() < i11) {
                                    qi0 qi0VarB = m01.b(wf1Var);
                                    if (qi0VarB != null) {
                                        arrayList2.add(qi0VarB);
                                    }
                                }
                                if (!arrayList2.isEmpty()) {
                                    g01Var6 = new g01(arrayList2);
                                    break;
                                }
                            } else {
                                wf1Var.e(iD3 + iH3);
                            }
                        }
                        g01Var6 = null;
                        break;
                    }
                }
                if (iH2 == 1936553057) {
                    wf1Var.e(iD);
                    int i12 = iD + iH;
                    wf1Var.f(12);
                    while (true) {
                        if (wf1Var.d() < i12) {
                            int iD4 = wf1Var.d();
                            int iH4 = wf1Var.h();
                            if (wf1Var.h() != 1935766900) {
                                wf1Var.e(iD4 + iH4);
                            } else if (iH4 >= 14) {
                                wf1Var.f(5);
                                int iT = wf1Var.t();
                                if (iT == 12 || iT == 13) {
                                    float f = iT == 12 ? 240.0f : 120.0f;
                                    wf1Var.f(1);
                                    g01Var5 = new g01(new m02(wf1Var.t(), f));
                                    break;
                                }
                            }
                        }
                        g01Var5 = null;
                        break;
                    }
                }
                wf1Var.e(iD + iH);
                i6 = 1751411826;
                i7 = 4;
            }
            Pair pairCreate = Pair.create(g01Var6, g01Var5);
            g01 g01Var7 = (g01) pairCreate.first;
            g01 g01Var8 = (g01) pairCreate.second;
            if (g01Var7 != null) {
                fe0Var.a(g01Var7);
            }
            g01Var = g01Var8;
            g01Var2 = g01Var7;
        } else {
            g01Var = null;
            g01Var2 = null;
        }
        jh.a aVarB = aVar.b(1835365473);
        if (aVarB != null) {
            int i13 = kh.b;
            jh.b bVarC2 = aVarB.c(1751411826);
            jh.b bVarC3 = aVarB.c(1801812339);
            jh.b bVarC4 = aVarB.c(1768715124);
            if (bVarC2 == null || bVarC3 == null || bVarC4 == null) {
                g01Var3 = null;
            } else {
                wf1 wf1Var2 = bVarC2.b;
                wf1Var2.e(16);
                if (wf1Var2.h() != 1835299937) {
                    g01Var3 = null;
                } else {
                    wf1 wf1Var3 = bVarC3.b;
                    wf1Var3.e(12);
                    int iH5 = wf1Var3.h();
                    String[] strArr = new String[iH5];
                    for (int i14 = 0; i14 < iH5; i14++) {
                        int iH6 = wf1Var3.h();
                        wf1Var3.f(4);
                        strArr[i14] = wf1Var3.a(iH6 - 8, ko.c);
                    }
                    wf1 wf1Var4 = bVarC4.b;
                    wf1Var4.e(8);
                    ArrayList arrayList3 = new ArrayList();
                    for (int i15 = 8; wf1Var4.a() > i15; i15 = 8) {
                        int iD5 = wf1Var4.d();
                        int iH7 = wf1Var4.h();
                        int iH8 = wf1Var4.h() - 1;
                        if (iH8 >= 0 && iH8 < iH5) {
                            String str = strArr[iH8];
                            int i16 = iD5 + iH7;
                            while (true) {
                                int iD6 = wf1Var4.d();
                                if (iD6 >= i16) {
                                    i5 = iH5;
                                    nu0Var = null;
                                    break;
                                }
                                int iH9 = wf1Var4.h();
                                i5 = iH5;
                                if (wf1Var4.h() == 1684108385) {
                                    int iH10 = wf1Var4.h();
                                    int iH11 = wf1Var4.h();
                                    int i17 = iH9 - 16;
                                    byte[] bArr = new byte[i17];
                                    wf1Var4.a(bArr, 0, i17);
                                    nu0Var = new nu0(iH11, iH10, str, bArr);
                                    break;
                                }
                                wf1Var4.e(iD6 + iH9);
                                iH5 = i5;
                            }
                            if (nu0Var != null) {
                                arrayList3.add(nu0Var);
                            }
                        } else {
                            i5 = iH5;
                            strArr = strArr;
                            tr0.a("Skipped metadata with unknown key index: ", iH8, "AtomParsers");
                        }
                        wf1Var4.e(iD5 + iH7);
                        iH5 = i5;
                        strArr = strArr;
                    }
                    if (arrayList3.isEmpty()) {
                        g01Var3 = null;
                    } else {
                        g01Var3 = new g01(arrayList3);
                    }
                }
            }
        } else {
            g01Var3 = null;
        }
        ArrayList arrayListA = kh.a(aVar, fe0Var, -9223372036854775807L, null, (this.f10614a & 1) != 0, z, new ce0() { // from class: com.yandex.mobile.ads.impl.x11$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.ce0
            public final Object apply(Object obj) {
                return x11.a((o52) obj);
            }
        });
        int size = arrayListA.size();
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        int i18 = 0;
        int size2 = -1;
        while (true) {
            j = 0;
            if (i18 >= size) {
                break;
            }
            u52 u52Var = (u52) arrayListA.get(i18);
            if (u52Var.b != 0) {
                o52 o52Var = u52Var.f10359a;
                long j4 = o52Var.e;
                if (j4 == j2) {
                    j4 = u52Var.h;
                }
                long jMax = Math.max(j3, j4);
                a aVar2 = new a(o52Var, u52Var, this.r.a(i18, o52Var.b));
                if ("audio/true-hd".equals(o52Var.f.m)) {
                    i = u52Var.e * 16;
                } else {
                    i = u52Var.e + 30;
                }
                gc0.a aVarA = o52Var.f.a();
                aVarA.h(i);
                if (o52Var.b == 2 && j4 > 0 && (i4 = u52Var.b) > 1) {
                    aVarA.a(i4 / (j4 / 1000000.0f));
                }
                if (o52Var.b == 1 && (i3 = fe0Var.f8887a) != -1 && fe0Var.b != -1) {
                    aVarA.d(i3).e(fe0Var.b);
                }
                int i19 = o52Var.b;
                g01[] g01VarArr = new g01[2];
                g01VarArr[0] = g01Var;
                if (this.h.isEmpty()) {
                    i2 = 1;
                    g01Var4 = null;
                } else {
                    g01Var4 = new g01(this.h);
                    i2 = 1;
                }
                g01VarArr[i2] = g01Var4;
                g01 g01Var9 = new g01(new g01.b[0]);
                if (i19 == i2) {
                    if (g01Var2 != null) {
                        g01Var9 = g01Var2;
                    }
                } else if (i19 == 2 && g01Var3 != null) {
                    for (int i20 = 0; i20 < g01Var3.c(); i20++) {
                        g01.b bVarA = g01Var3.a(i20);
                        if (bVarA instanceof nu0) {
                            nu0 nu0Var2 = (nu0) bVarA;
                            if ("com.android.capture.fps".equals(nu0Var2.b)) {
                                g01Var9 = new g01(nu0Var2);
                                break;
                            }
                        }
                    }
                }
                for (int i21 = 0; i21 < 2; i21++) {
                    g01Var9 = g01Var9.a(g01VarArr[i21]);
                }
                if (g01Var9.c() > 0) {
                    aVarA.a(g01Var9);
                }
                aVar2.c.a(aVarA.a());
                if (o52Var.b == 2 && size2 == -1) {
                    size2 = arrayList.size();
                }
                arrayList.add(aVar2);
                j3 = jMax;
            }
            i18++;
            arrayListA = arrayListA;
            size = size;
            g01Var = g01Var;
            j2 = -9223372036854775807L;
        }
        this.u = size2;
        this.v = j3;
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        this.s = aVarArr;
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i22 = 0; i22 < aVarArr.length; i22++) {
            jArr[i22] = new long[aVarArr[i22].b.b];
            jArr2[i22] = aVarArr[i22].b.f[0];
        }
        int i23 = 0;
        while (i23 < aVarArr.length) {
            int i24 = -1;
            long j5 = Long.MAX_VALUE;
            for (int i25 = 0; i25 < aVarArr.length; i25++) {
                if (!zArr[i25]) {
                    long j6 = jArr2[i25];
                    if (j6 <= j5) {
                        i24 = i25;
                        j5 = j6;
                    }
                }
            }
            int i26 = iArr[i24];
            long[] jArr3 = jArr[i24];
            jArr3[i26] = j;
            u52 u52Var2 = aVarArr[i24].b;
            j += (long) u52Var2.d[i26];
            int i27 = i26 + 1;
            iArr[i24] = i27;
            if (i27 < jArr3.length) {
                jArr2[i24] = u52Var2.f[i27];
            } else {
                zArr[i24] = true;
                i23++;
            }
        }
        this.t = jArr;
        this.r.a();
        this.r.a(this);
    }

    private void c(long j) throws ag1 {
        while (!this.f.isEmpty() && this.f.peek().b == j) {
            jh.a aVarPop = this.f.pop();
            if (aVarPop.f9316a == 1836019574) {
                a(aVarPop);
                this.f.clear();
                this.i = 2;
            } else if (!this.f.isEmpty()) {
                this.f.peek().d.add(aVarPop);
            }
        }
        if (this.i != 2) {
            this.i = 0;
            this.l = 0;
        }
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o52 f10615a;
        public final u52 b;
        public final t52 c;
        public final b72 d;
        public int e;

        public a(o52 o52Var, u52 u52Var, t52 t52Var) {
            this.f10615a = o52Var;
            this.b = u52Var;
            this.c = t52Var;
            this.d = "audio/true-hd".equals(o52Var.f.m) ? new b72() : null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        boolean z;
        int i;
        jh.a aVarPeek;
        while (true) {
            int i2 = this.i;
            if (i2 == 0) {
                if (this.l == 0) {
                    if (!x70Var.a(this.e.c(), 0, 8, true)) {
                        if (this.w != 2 || (this.f10614a & 2) == 0) {
                            return -1;
                        }
                        t52 t52VarA = this.r.a(0, 4);
                        v11 v11Var = this.x;
                        t52VarA.a(new gc0.a().a(v11Var == null ? null : new g01(v11Var)).a());
                        this.r.a();
                        this.r.a(new xw1.b(-9223372036854775807L, 0L));
                        return -1;
                    }
                    this.l = 8;
                    this.e.e(0);
                    this.k = this.e.v();
                    this.j = this.e.h();
                }
                long j = this.k;
                if (j == 1) {
                    x70Var.b(this.e.c(), 8, 8);
                    this.l += 8;
                    this.k = this.e.y();
                } else if (j == 0) {
                    long jB = x70Var.b();
                    if (jB == -1 && (aVarPeek = this.f.peek()) != null) {
                        jB = aVarPeek.b;
                    }
                    if (jB != -1) {
                        this.k = (jB - x70Var.a()) + ((long) this.l);
                    }
                }
                long j2 = this.k;
                int i3 = this.l;
                if (j2 >= i3) {
                    int i4 = this.j;
                    if (i4 == 1836019574 || i4 == 1953653099 || i4 == 1835297121 || i4 == 1835626086 || i4 == 1937007212 || i4 == 1701082227 || i4 == 1835365473) {
                        long jA = x70Var.a();
                        long j3 = this.k;
                        long j4 = this.l;
                        long j5 = (jA + j3) - j4;
                        if (j3 != j4 && this.j == 1835365473) {
                            this.d.c(8);
                            x70Var.a(this.d.c(), 0, 8);
                            wf1 wf1Var = this.d;
                            int i5 = kh.b;
                            int iD = wf1Var.d();
                            wf1Var.f(4);
                            if (wf1Var.h() != 1751411826) {
                                iD += 4;
                            }
                            wf1Var.e(iD);
                            x70Var.a(this.d.d());
                            x70Var.c();
                        }
                        this.f.push(new jh.a(this.j, j5));
                        if (this.k == this.l) {
                            c(j5);
                        } else {
                            this.i = 0;
                            this.l = 0;
                        }
                    } else if (i4 != 1835296868 && i4 != 1836476516 && i4 != 1751411826 && i4 != 1937011556 && i4 != 1937011827 && i4 != 1937011571 && i4 != 1668576371 && i4 != 1701606260 && i4 != 1937011555 && i4 != 1937011578 && i4 != 1937013298 && i4 != 1937007471 && i4 != 1668232756 && i4 != 1953196132 && i4 != 1718909296 && i4 != 1969517665 && i4 != 1801812339 && i4 != 1768715124) {
                        long jA2 = x70Var.a();
                        long j6 = this.l;
                        long j7 = jA2 - j6;
                        if (this.j == 1836086884) {
                            this.x = new v11(0L, j7, -9223372036854775807L, j7 + j6, this.k - j6);
                        }
                        this.m = null;
                        this.i = 1;
                    } else {
                        if (i3 != 8) {
                            throw new IllegalStateException();
                        }
                        if (j2 <= 2147483647L) {
                            wf1 wf1Var2 = new wf1((int) j2);
                            System.arraycopy(this.e.c(), 0, wf1Var2.c(), 0, 8);
                            this.m = wf1Var2;
                            this.i = 1;
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                } else {
                    throw ag1.a("Atom size less than header length (unsupported).");
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException();
                        }
                        this.g.a(x70Var, lj1Var, this.h);
                        if (lj1Var.f9531a == 0) {
                            this.i = 0;
                            this.l = 0;
                        }
                        return 1;
                    }
                    long jA3 = x70Var.a();
                    if (this.n == -1) {
                        int i6 = -1;
                        int i7 = -1;
                        boolean z2 = true;
                        boolean z3 = true;
                        int i8 = 0;
                        long j8 = Long.MAX_VALUE;
                        long j9 = Long.MAX_VALUE;
                        long j10 = Long.MAX_VALUE;
                        while (true) {
                            a[] aVarArr = this.s;
                            if (i8 >= aVarArr.length) {
                                break;
                            }
                            a aVar = aVarArr[i8];
                            int i9 = aVar.e;
                            u52 u52Var = aVar.b;
                            if (i9 != u52Var.b) {
                                long j11 = u52Var.c[i9];
                                long[][] jArr = this.t;
                                int i10 = x82.f10629a;
                                long j12 = jArr[i8][i9];
                                long j13 = j11 - jA3;
                                boolean z4 = j13 < 0 || j13 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                                if ((!z4 && z2) || (z4 == z2 && j13 < j10)) {
                                    z2 = z4;
                                    i7 = i8;
                                    j10 = j13;
                                    j9 = j12;
                                }
                                if (j12 < j8) {
                                    z3 = z4;
                                    i6 = i8;
                                    j8 = j12;
                                }
                            }
                            i8++;
                        }
                        int i11 = (j8 == Long.MAX_VALUE || !z3 || j9 < j8 + 10485760) ? i7 : i6;
                        this.n = i11;
                        if (i11 == -1) {
                            return -1;
                        }
                    }
                    a aVar2 = this.s[this.n];
                    t52 t52Var = aVar2.c;
                    int i12 = aVar2.e;
                    u52 u52Var2 = aVar2.b;
                    long j14 = u52Var2.c[i12];
                    int i13 = u52Var2.d[i12];
                    b72 b72Var = aVar2.d;
                    long j15 = (j14 - jA3) + ((long) this.o);
                    if (j15 >= 0 && j15 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        if (aVar2.f10615a.g == 1) {
                            j15 += 8;
                            i13 -= 8;
                        }
                        x70Var.a((int) j15);
                        o52 o52Var = aVar2.f10615a;
                        if (o52Var.j != 0) {
                            byte[] bArrC = this.c.c();
                            bArrC[0] = 0;
                            bArrC[1] = 0;
                            bArrC[2] = 0;
                            int i14 = aVar2.f10615a.j;
                            int i15 = 4 - i14;
                            while (this.p < i13) {
                                int i16 = this.q;
                                if (i16 == 0) {
                                    x70Var.b(bArrC, i15, i14);
                                    this.o += i14;
                                    this.c.e(0);
                                    int iH = this.c.h();
                                    if (iH >= 0) {
                                        this.q = iH;
                                        this.b.e(0);
                                        t52Var.a(4, this.b);
                                        this.p += 4;
                                        i13 += i15;
                                    } else {
                                        throw ag1.a("Invalid NAL length", (Exception) null);
                                    }
                                } else {
                                    int iB = t52Var.b(x70Var, i16, false);
                                    this.o += iB;
                                    this.p += iB;
                                    this.q -= iB;
                                }
                            }
                        } else {
                            if ("audio/ac4".equals(o52Var.f.m)) {
                                if (this.p == 0) {
                                    w.a(i13, this.d);
                                    t52Var.a(7, this.d);
                                    this.p += 7;
                                }
                                i13 += 7;
                            } else if (b72Var != null) {
                                b72Var.a(x70Var);
                            }
                            while (true) {
                                int i17 = this.p;
                                if (i17 >= i13) {
                                    break;
                                }
                                int iB2 = t52Var.b(x70Var, i13 - i17, false);
                                this.o += iB2;
                                this.p += iB2;
                                this.q -= iB2;
                            }
                        }
                        u52 u52Var3 = aVar2.b;
                        long j16 = u52Var3.f[i12];
                        int i18 = u52Var3.g[i12];
                        if (b72Var != null) {
                            b72Var.a(t52Var, j16, i18, i13, 0, null);
                            if (i12 + 1 == aVar2.b.b) {
                                b72Var.a(t52Var, null);
                            }
                        } else {
                            t52Var.a(j16, i18, i13, 0, null);
                        }
                        aVar2.e++;
                        this.n = -1;
                        this.o = 0;
                        this.p = 0;
                        this.q = 0;
                        return 0;
                    }
                    lj1Var.f9531a = j14;
                    return 1;
                }
                long j17 = this.k - ((long) this.l);
                long jA4 = x70Var.a() + j17;
                wf1 wf1Var3 = this.m;
                if (wf1Var3 != null) {
                    x70Var.b(wf1Var3.c(), this.l, (int) j17);
                    if (this.j == 1718909296) {
                        wf1Var3.e(8);
                        int iH2 = wf1Var3.h();
                        if (iH2 != 1751476579) {
                            i = iH2 != 1903435808 ? 0 : 1;
                        } else {
                            i = 2;
                        }
                        if (i == 0) {
                            wf1Var3.f(4);
                            do {
                                if (wf1Var3.a() <= 0) {
                                    i = 0;
                                    break;
                                }
                                int iH3 = wf1Var3.h();
                                if (iH3 != 1751476579) {
                                    i = iH3 != 1903435808 ? 0 : 1;
                                } else {
                                    i = 2;
                                }
                            } while (i == 0);
                        }
                        this.w = i;
                    } else if (!this.f.isEmpty()) {
                        this.f.peek().c.add(new jh.b(this.j, wf1Var3));
                    }
                } else {
                    if (j17 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        x70Var.a((int) j17);
                    } else {
                        lj1Var.f9531a = x70Var.a() + j17;
                        z = true;
                    }
                    c(jA4);
                    if (z && this.i != 2) {
                        return 1;
                    }
                }
                z = false;
                c(jA4);
                if (z) {
                    continue;
                }
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        this.f.clear();
        this.l = 0;
        this.n = -1;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        if (j == 0) {
            if (this.i != 3) {
                this.i = 0;
                this.l = 0;
                return;
            } else {
                this.g.a();
                this.h.clear();
                return;
            }
        }
        for (a aVar : this.s) {
            u52 u52Var = aVar.b;
            int iB = x82.b(u52Var.f, j2, false);
            while (true) {
                if (iB < 0) {
                    iB = -1;
                    break;
                } else if ((u52Var.g[iB] & 1) != 0) {
                    break;
                } else {
                    iB--;
                }
            }
            if (iB == -1) {
                iB = u52Var.a(j2);
            }
            aVar.e = iB;
            b72 b72Var = aVar.d;
            if (b72Var != null) {
                b72Var.a();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        return n02.a(x70Var, (this.f10614a & 2) != 0);
    }
}
