package com.yandex.mobile.ads.impl;

import android.util.Pair;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes8.dex */
public final class mc0 implements w70 {
    private static final byte[] F;
    private static final gc0 G;
    private boolean A;
    private y70 B;
    private t52[] C;
    private t52[] D;
    private boolean E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<gc0> f9624a;
    private final SparseArray<b> b;
    private final wf1 c;
    private final wf1 d;
    private final wf1 e;
    private final byte[] f;
    private final wf1 g;
    private final x50 h;
    private final wf1 i;
    private final ArrayDeque<jh.a> j;
    private final ArrayDeque<a> k;
    private final t52 l;
    private int m;
    private int n;
    private long o;
    private int p;
    private wf1 q;
    private long r;
    private int s;
    private long t;
    private long u;
    private long v;
    private b w;
    private int x;
    private int y;
    private int z;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f9625a;
        public final boolean b;
        public final int c;

        public a(int i, long j, boolean z) {
            this.f9625a = j;
            this.b = z;
            this.c = i;
        }
    }

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.mc0$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return mc0.a();
            }
        };
        F = new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
        G = new gc0.a().e("application/x-emsg").a();
    }

    protected final o52 a(o52 o52Var) {
        return o52Var;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    public mc0(int i) {
        this(Collections.emptyList());
    }

    private static c40 a(ArrayList arrayList) {
        int size = arrayList.size();
        ArrayList arrayList2 = null;
        for (int i = 0; i < size; i++) {
            jh.b bVar = (jh.b) arrayList.get(i);
            if (bVar.f9316a == 1886614376) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] bArrC = bVar.b.c();
                UUID uuidC = vm1.c(bArrC);
                if (uuidC == null) {
                    at0.d("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList2.add(new c40.b(uuidC, null, "video/mp4", bArrC));
                }
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        return new c40(arrayList2);
    }

    public mc0(List list) {
        this(list, 0);
    }

    public mc0(List list, int i) {
        this.f9624a = Collections.unmodifiableList(list);
        this.l = null;
        this.h = new x50();
        this.i = new wf1(16);
        this.c = new wf1(a41.f8364a);
        this.d = new wf1(5);
        this.e = new wf1();
        byte[] bArr = new byte[16];
        this.f = bArr;
        this.g = new wf1(bArr);
        this.j = new ArrayDeque<>();
        this.k = new ArrayDeque<>();
        this.b = new SparseArray<>();
        this.u = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.B = y70.f10708a;
        this.C = new t52[0];
        this.D = new t52[0];
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        int i;
        this.B = y70Var;
        int i2 = 0;
        this.m = 0;
        this.p = 0;
        t52[] t52VarArr = new t52[2];
        this.C = t52VarArr;
        t52 t52Var = this.l;
        if (t52Var != null) {
            t52VarArr[0] = t52Var;
            i = 1;
        } else {
            i = 0;
        }
        t52[] t52VarArr2 = (t52[]) x82.a(i, t52VarArr);
        this.C = t52VarArr2;
        for (t52 t52Var2 : t52VarArr2) {
            t52Var2.a(G);
        }
        this.D = new t52[this.f9624a.size()];
        int i3 = 100;
        while (i2 < this.D.length) {
            int i4 = i3 + 1;
            t52 t52VarA = this.B.a(i3, 3);
            t52VarA.a(this.f9624a.get(i2));
            this.D[i2] = t52VarA;
            i2++;
            i3 = i4;
        }
    }

    private void a(jh.a aVar) throws ag1 {
        k00 k00Var;
        k00 k00Var2;
        c40 c40VarA = a(aVar.c);
        jh.a aVarB = aVar.b(1836475768);
        aVarB.getClass();
        SparseArray sparseArray = new SparseArray();
        int size = aVarB.c.size();
        long jV = -9223372036854775807L;
        for (int i = 0; i < size; i++) {
            jh.b bVar = (jh.b) aVarB.c.get(i);
            int i2 = bVar.f9316a;
            if (i2 == 1953654136) {
                wf1 wf1Var = bVar.b;
                wf1Var.e(12);
                Pair pairCreate = Pair.create(Integer.valueOf(wf1Var.h()), new k00(wf1Var.h() - 1, wf1Var.h(), wf1Var.h(), wf1Var.h()));
                sparseArray.put(((Integer) pairCreate.first).intValue(), (k00) pairCreate.second);
            } else if (i2 == 1835362404) {
                wf1 wf1Var2 = bVar.b;
                wf1Var2.e(8);
                jV = ((wf1Var2.h() >> 24) & 255) == 0 ? wf1Var2.v() : wf1Var2.y();
            }
        }
        ArrayList arrayListA = kh.a(aVar, new fe0(), jV, c40VarA, false, false, new ce0() { // from class: com.yandex.mobile.ads.impl.mc0$$ExternalSyntheticLambda1
            @Override // com.yandex.mobile.ads.impl.ce0
            public final Object apply(Object obj) {
                return this.f$0.a((o52) obj);
            }
        });
        int size2 = arrayListA.size();
        if (this.b.size() == 0) {
            for (int i3 = 0; i3 < size2; i3++) {
                u52 u52Var = (u52) arrayListA.get(i3);
                o52 o52Var = u52Var.f10359a;
                t52 t52VarA = this.B.a(i3, o52Var.b);
                int i4 = o52Var.f9783a;
                if (sparseArray.size() == 1) {
                    k00Var2 = (k00) sparseArray.valueAt(0);
                } else {
                    k00Var2 = (k00) sparseArray.get(i4);
                    k00Var2.getClass();
                }
                this.b.put(o52Var.f9783a, new b(t52VarA, u52Var, k00Var2));
                this.u = Math.max(this.u, o52Var.e);
            }
            this.B.a();
            return;
        }
        if (this.b.size() != size2) {
            throw new IllegalStateException();
        }
        for (int i5 = 0; i5 < size2; i5++) {
            u52 u52Var2 = (u52) arrayListA.get(i5);
            o52 o52Var2 = u52Var2.f10359a;
            b bVar2 = this.b.get(o52Var2.f9783a);
            int i6 = o52Var2.f9783a;
            if (sparseArray.size() == 1) {
                k00Var = (k00) sparseArray.valueAt(0);
            } else {
                k00Var = (k00) sparseArray.get(i6);
                k00Var.getClass();
            }
            bVar2.a(u52Var2, k00Var);
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t52 f9626a;
        public u52 d;
        public k00 e;
        public int f;
        public int g;
        public int h;
        public int i;
        private boolean l;
        public final q52 b = new q52();
        public final wf1 c = new wf1();
        private final wf1 j = new wf1(1);
        private final wf1 k = new wf1();

        public b(t52 t52Var, u52 u52Var, k00 k00Var) {
            this.f9626a = t52Var;
            this.d = u52Var;
            this.e = k00Var;
            a(u52Var, k00Var);
        }

        public final void b() {
            q52 q52Var = this.b;
            q52Var.d = 0;
            q52Var.p = 0L;
            q52Var.q = false;
            q52Var.k = false;
            q52Var.o = false;
            q52Var.m = null;
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.l = false;
        }

        public final p52 a() {
            if (!this.l) {
                return null;
            }
            q52 q52Var = this.b;
            k00 k00Var = q52Var.f9984a;
            int i = x82.f10629a;
            int i2 = k00Var.f9367a;
            p52 p52VarA = q52Var.m;
            if (p52VarA == null) {
                p52VarA = this.d.f10359a.a(i2);
            }
            if (p52VarA == null || !p52VarA.f9896a) {
                return null;
            }
            return p52VarA;
        }

        public final int a(int i, int i2) {
            wf1 wf1Var;
            p52 p52VarA = a();
            if (p52VarA == null) {
                return 0;
            }
            int length = p52VarA.d;
            if (length != 0) {
                wf1Var = this.b.n;
            } else {
                byte[] bArr = p52VarA.e;
                int i3 = x82.f10629a;
                this.k.a(bArr.length, bArr);
                wf1 wf1Var2 = this.k;
                length = bArr.length;
                wf1Var = wf1Var2;
            }
            q52 q52Var = this.b;
            boolean z = q52Var.k && q52Var.l[this.f];
            boolean z2 = z || i2 != 0;
            this.j.c()[0] = (byte) ((z2 ? 128 : 0) | length);
            this.j.e(0);
            this.f9626a.b(1, this.j);
            this.f9626a.b(length, wf1Var);
            if (!z2) {
                return length + 1;
            }
            if (!z) {
                this.c.c(8);
                byte[] bArrC = this.c.c();
                bArrC[0] = 0;
                bArrC[1] = 1;
                bArrC[2] = (byte) 0;
                bArrC[3] = (byte) (i2 & 255);
                bArrC[4] = (byte) ((i >> 24) & 255);
                bArrC[5] = (byte) ((i >> 16) & 255);
                bArrC[6] = (byte) ((i >> 8) & 255);
                bArrC[7] = (byte) (i & 255);
                this.f9626a.b(8, this.c);
                return length + 9;
            }
            wf1 wf1Var3 = this.b.n;
            int iZ = wf1Var3.z();
            wf1Var3.f(-2);
            int i4 = (iZ * 6) + 2;
            if (i2 != 0) {
                this.c.c(i4);
                byte[] bArrC2 = this.c.c();
                wf1Var3.a(bArrC2, 0, i4);
                int i5 = (((bArrC2[2] & 255) << 8) | (bArrC2[3] & 255)) + i2;
                bArrC2[2] = (byte) ((i5 >> 8) & 255);
                bArrC2[3] = (byte) (i5 & 255);
                wf1Var3 = this.c;
            }
            this.f9626a.b(i4, wf1Var3);
            return length + 1 + i4;
        }

        public final void a(u52 u52Var, k00 k00Var) {
            this.d = u52Var;
            this.e = k00Var;
            this.f9626a.a(u52Var.f10359a.f);
            b();
        }
    }

    private static void a(wf1 wf1Var, int i, q52 q52Var) throws ag1 {
        wf1Var.e(i + 8);
        int iH = wf1Var.h();
        if ((iH & 1) == 0) {
            boolean z = (iH & 2) != 0;
            int iX = wf1Var.x();
            if (iX == 0) {
                Arrays.fill(q52Var.l, 0, q52Var.e, false);
                return;
            }
            if (iX == q52Var.e) {
                Arrays.fill(q52Var.l, 0, iX, z);
                q52Var.n.c(wf1Var.a());
                q52Var.k = true;
                q52Var.o = true;
                wf1Var.a(q52Var.n.c(), 0, q52Var.n.e());
                q52Var.n.e(0);
                q52Var.o = false;
                return;
            }
            throw ag1.a("Senc sample count " + iX + " is different from fragment sample count" + q52Var.e, (Exception) null);
        }
        throw ag1.a("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0215 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0217  */
    /* JADX WARN: Code duplicated, block: B:108:0x0222  */
    /* JADX WARN: Code duplicated, block: B:111:0x022c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x022e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0237  */
    /* JADX WARN: Code duplicated, block: B:115:0x023d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x023f  */
    /* JADX WARN: Code duplicated, block: B:117:0x0244  */
    /* JADX WARN: Code duplicated, block: B:120:0x024b  */
    /* JADX WARN: Code duplicated, block: B:122:0x024f  */
    /* JADX WARN: Code duplicated, block: B:123:0x025c  */
    /* JADX WARN: Code duplicated, block: B:126:0x0276  */
    /* JADX WARN: Code duplicated, block: B:127:0x0280  */
    /* JADX WARN: Code duplicated, block: B:130:0x028c  */
    /* JADX WARN: Code duplicated, block: B:131:0x028e  */
    /* JADX WARN: Code duplicated, block: B:245:0x052f  */
    /* JADX WARN: Code duplicated, block: B:281:0x02b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:282:0x02a3 A[SYNTHETIC] */
    private void a(long j) throws ag1 {
        mc0 mc0Var;
        jh.a aVar;
        SparseArray<b> sparseArray;
        int i;
        int i2;
        byte[] bArr;
        int iH;
        int iH2;
        int iH3;
        int iH4;
        int i3;
        byte[] bArr2;
        byte[] bArr3;
        int i4;
        boolean z;
        byte[] bArr4;
        long j2;
        int[] iArr;
        long[] jArr;
        boolean[] zArr;
        int i5;
        long j3;
        long j4;
        int i6;
        int iH5;
        int iH6;
        int iH7;
        int iH8;
        long jA;
        boolean z2;
        mc0 mc0Var2 = this;
        while (!mc0Var2.j.isEmpty() && mc0Var2.j.peek().b == j) {
            jh.a aVarPop = mc0Var2.j.pop();
            int i7 = aVarPop.f9316a;
            if (i7 == 1836019574) {
                mc0Var2.a(aVarPop);
            } else {
                if (i7 == 1836019558) {
                    SparseArray<b> sparseArray2 = mc0Var2.b;
                    byte[] bArr5 = mc0Var2.f;
                    int size = aVarPop.d.size();
                    int i8 = 0;
                    while (i8 < size) {
                        jh.a aVar2 = (jh.a) aVarPop.d.get(i8);
                        if (aVar2.f9316a == 1953653094) {
                            jh.b bVarC = aVar2.c(1952868452);
                            bVarC.getClass();
                            wf1 wf1Var = bVarC.b;
                            wf1Var.e(8);
                            int iH9 = wf1Var.h();
                            b bVar = sparseArray2.get(wf1Var.h());
                            if (bVar == null) {
                                bVar = null;
                            } else {
                                if ((iH9 & 1) != 0) {
                                    long jY = wf1Var.y();
                                    q52 q52Var = bVar.b;
                                    q52Var.b = jY;
                                    q52Var.c = jY;
                                }
                                k00 k00Var = bVar.e;
                                if ((iH9 & 2) != 0) {
                                    iH = wf1Var.h() - 1;
                                } else {
                                    iH = k00Var.f9367a;
                                }
                                if ((iH9 & 8) != 0) {
                                    iH2 = wf1Var.h();
                                } else {
                                    iH2 = k00Var.b;
                                }
                                if ((iH9 & 16) != 0) {
                                    iH3 = wf1Var.h();
                                } else {
                                    iH3 = k00Var.c;
                                }
                                if ((iH9 & 32) != 0) {
                                    iH4 = wf1Var.h();
                                } else {
                                    iH4 = k00Var.d;
                                }
                                bVar.b.f9984a = new k00(iH, iH2, iH3, iH4);
                            }
                            if (bVar == null) {
                                aVar = aVarPop;
                                sparseArray = sparseArray2;
                                i = size;
                                i2 = i8;
                                bArr = bArr5;
                            } else {
                                q52 q52Var2 = bVar.b;
                                long j5 = q52Var2.p;
                                boolean z3 = q52Var2.q;
                                bVar.b();
                                bVar.l = true;
                                jh.b bVarC2 = aVar2.c(1952867444);
                                if (bVarC2 != null) {
                                    wf1 wf1Var2 = bVarC2.b;
                                    wf1Var2.e(8);
                                    q52Var2.p = ((wf1Var2.h() >> 24) & 255) == 1 ? wf1Var2.y() : wf1Var2.v();
                                    q52Var2.q = true;
                                } else {
                                    q52Var2.p = j5;
                                    q52Var2.q = z3;
                                }
                                ArrayList arrayList = aVar2.c;
                                int size2 = arrayList.size();
                                int i9 = 0;
                                int i10 = 0;
                                int i11 = 0;
                                while (true) {
                                    i3 = 1953658222;
                                    if (i9 >= size2) {
                                        break;
                                    }
                                    jh.b bVar2 = (jh.b) arrayList.get(i9);
                                    SparseArray<b> sparseArray3 = sparseArray2;
                                    if (bVar2.f9316a == 1953658222) {
                                        wf1 wf1Var3 = bVar2.b;
                                        wf1Var3.e(12);
                                        int iX = wf1Var3.x();
                                        if (iX > 0) {
                                            i10 += iX;
                                            i11++;
                                        }
                                    }
                                    i9++;
                                    sparseArray2 = sparseArray3;
                                }
                                sparseArray = sparseArray2;
                                bVar.h = 0;
                                bVar.g = 0;
                                bVar.f = 0;
                                q52 q52Var3 = bVar.b;
                                q52Var3.d = i11;
                                q52Var3.e = i10;
                                if (q52Var3.g.length < i11) {
                                    q52Var3.f = new long[i11];
                                    q52Var3.g = new int[i11];
                                }
                                if (q52Var3.h.length < i10) {
                                    int i12 = (i10 * Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) / 100;
                                    q52Var3.h = new int[i12];
                                    q52Var3.i = new long[i12];
                                    q52Var3.j = new boolean[i12];
                                    q52Var3.l = new boolean[i12];
                                }
                                int i13 = 0;
                                int i14 = 0;
                                int i15 = 0;
                                while (i13 < size2) {
                                    jh.b bVar3 = (jh.b) arrayList.get(i13);
                                    if (bVar3.f9316a == i3) {
                                        int i16 = i14 + 1;
                                        wf1 wf1Var4 = bVar3.b;
                                        wf1Var4.e(8);
                                        int iH10 = wf1Var4.h();
                                        o52 o52Var = bVar.d.f10359a;
                                        q52 q52Var4 = bVar.b;
                                        k00 k00Var2 = q52Var4.f9984a;
                                        int i17 = x82.f10629a;
                                        q52Var4.g[i14] = wf1Var4.x();
                                        long[] jArr2 = q52Var4.f;
                                        long j6 = q52Var4.b;
                                        jArr2[i14] = j6;
                                        if ((iH10 & 1) != 0) {
                                            jArr2[i14] = j6 + ((long) wf1Var4.h());
                                        }
                                        boolean z4 = (iH10 & 4) != 0;
                                        int iH11 = k00Var2.d;
                                        if (z4) {
                                            iH11 = wf1Var4.h();
                                        }
                                        boolean z5 = (iH10 & 256) != 0;
                                        boolean z6 = (iH10 & 512) != 0;
                                        boolean z7 = (iH10 & 1024) != 0;
                                        boolean z8 = (iH10 & 2048) != 0;
                                        long[] jArr3 = o52Var.h;
                                        int i18 = iH11;
                                        if (jArr3 != null) {
                                            bArr4 = bArr5;
                                            if (jArr3.length == 1 && jArr3[0] == 0) {
                                                j2 = o52Var.i[0];
                                            }
                                            iArr = q52Var4.h;
                                            jArr = q52Var4.i;
                                            zArr = q52Var4.j;
                                            i5 = q52Var4.g[i14] + i15;
                                            j3 = o52Var.c;
                                            j4 = q52Var4.p;
                                            i6 = i15;
                                            while (i6 < i5) {
                                                if (z5) {
                                                    iH5 = wf1Var4.h();
                                                } else {
                                                    iH5 = k00Var2.b;
                                                }
                                                if (iH5 >= 0) {
                                                    throw ag1.a("Unexpected negative value: " + iH5, (Exception) null);
                                                }
                                                if (z6) {
                                                    iH6 = wf1Var4.h();
                                                } else {
                                                    iH6 = k00Var2.c;
                                                }
                                                if (iH6 >= 0) {
                                                    if (z7) {
                                                        iH7 = wf1Var4.h();
                                                    } else if (i6 == 0 || !z4) {
                                                        iH7 = k00Var2.d;
                                                    } else {
                                                        iH7 = i18;
                                                    }
                                                    if (z8) {
                                                        iH8 = wf1Var4.h();
                                                    } else {
                                                        iH8 = 0;
                                                    }
                                                    jA = x82.a((((long) iH8) + j4) - j2, 1000000L, j3);
                                                    jArr[i6] = jA;
                                                    if (!q52Var4.q) {
                                                        jArr[i6] = jA + bVar.d.h;
                                                    }
                                                    iArr[i6] = iH6;
                                                    if (((iH7 >> 16) & 1) == 0) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    zArr[i6] = z2;
                                                    j4 += (long) iH5;
                                                    i6++;
                                                    j3 = j3;
                                                    z5 = z5;
                                                    i5 = i5;
                                                    z6 = z6;
                                                    z4 = z4;
                                                    k00Var2 = k00Var2;
                                                } else {
                                                    throw ag1.a("Unexpected negative value: " + iH6, (Exception) null);
                                                }
                                            }
                                            q52Var4.p = j4;
                                            i14 = i16;
                                            i15 = i5;
                                        } else {
                                            bArr4 = bArr5;
                                        }
                                        j2 = 0;
                                        iArr = q52Var4.h;
                                        jArr = q52Var4.i;
                                        zArr = q52Var4.j;
                                        i5 = q52Var4.g[i14] + i15;
                                        j3 = o52Var.c;
                                        j4 = q52Var4.p;
                                        i6 = i15;
                                        while (i6 < i5) {
                                            if (z5) {
                                                iH5 = wf1Var4.h();
                                            } else {
                                                iH5 = k00Var2.b;
                                            }
                                            if (iH5 >= 0) {
                                                throw ag1.a("Unexpected negative value: " + iH5, (Exception) null);
                                            }
                                            if (z6) {
                                                iH6 = wf1Var4.h();
                                            } else {
                                                iH6 = k00Var2.c;
                                            }
                                            if (iH6 >= 0) {
                                                if (z7) {
                                                    iH7 = wf1Var4.h();
                                                } else if (i6 == 0) {
                                                    iH7 = k00Var2.d;
                                                } else {
                                                    iH7 = k00Var2.d;
                                                }
                                                if (z8) {
                                                    iH8 = wf1Var4.h();
                                                } else {
                                                    iH8 = 0;
                                                }
                                                jA = x82.a((((long) iH8) + j4) - j2, 1000000L, j3);
                                                jArr[i6] = jA;
                                                if (!q52Var4.q) {
                                                    jArr[i6] = jA + bVar.d.h;
                                                }
                                                iArr[i6] = iH6;
                                                if (((iH7 >> 16) & 1) == 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                zArr[i6] = z2;
                                                j4 += (long) iH5;
                                                i6++;
                                                j3 = j3;
                                                z5 = z5;
                                                i5 = i5;
                                                z6 = z6;
                                                z4 = z4;
                                                k00Var2 = k00Var2;
                                            } else {
                                                throw ag1.a("Unexpected negative value: " + iH6, (Exception) null);
                                            }
                                        }
                                        q52Var4.p = j4;
                                        i14 = i16;
                                        i15 = i5;
                                    } else {
                                        q52Var2 = q52Var2;
                                        i13 = i13;
                                        bArr4 = bArr5;
                                        i8 = i8;
                                    }
                                    i13++;
                                    size = size;
                                    arrayList = arrayList;
                                    size2 = size2;
                                    aVarPop = aVarPop;
                                    i8 = i8;
                                    q52Var2 = q52Var2;
                                    bArr5 = bArr4;
                                    aVar2 = aVar2;
                                    i3 = 1953658222;
                                }
                                aVar = aVarPop;
                                q52 q52Var5 = q52Var2;
                                byte[] bArr6 = bArr5;
                                i = size;
                                i2 = i8;
                                o52 o52Var2 = bVar.d.f10359a;
                                k00 k00Var3 = q52Var5.f9984a;
                                k00Var3.getClass();
                                p52 p52VarA = o52Var2.a(k00Var3.f9367a);
                                jh.b bVarC3 = aVar2.c(1935763834);
                                if (bVarC3 != null) {
                                    p52VarA.getClass();
                                    wf1 wf1Var5 = bVarC3.b;
                                    int i19 = p52VarA.d;
                                    wf1Var5.e(8);
                                    if ((wf1Var5.h() & 1) == 1) {
                                        wf1Var5.f(8);
                                    }
                                    int iT = wf1Var5.t();
                                    int iX2 = wf1Var5.x();
                                    if (iX2 <= q52Var5.e) {
                                        if (iT == 0) {
                                            boolean[] zArr2 = q52Var5.l;
                                            i4 = 0;
                                            for (int i20 = 0; i20 < iX2; i20++) {
                                                int iT2 = wf1Var5.t();
                                                i4 += iT2;
                                                zArr2[i20] = iT2 > i19;
                                            }
                                            z = false;
                                        } else {
                                            boolean z9 = iT > i19;
                                            i4 = iT * iX2;
                                            z = false;
                                            Arrays.fill(q52Var5.l, 0, iX2, z9);
                                        }
                                        Arrays.fill(q52Var5.l, iX2, q52Var5.e, z);
                                        if (i4 > 0) {
                                            q52Var5.n.c(i4);
                                            q52Var5.k = true;
                                            q52Var5.o = true;
                                        }
                                    } else {
                                        throw ag1.a("Saiz sample count " + iX2 + " is greater than fragment sample count" + q52Var5.e, (Exception) null);
                                    }
                                }
                                jh.b bVarC4 = aVar2.c(1935763823);
                                if (bVarC4 != null) {
                                    wf1 wf1Var6 = bVarC4.b;
                                    wf1Var6.e(8);
                                    int iH12 = wf1Var6.h();
                                    if ((iH12 & 1) == 1) {
                                        wf1Var6.f(8);
                                    }
                                    int iX3 = wf1Var6.x();
                                    if (iX3 != 1) {
                                        throw ag1.a("Unexpected saio entry count: " + iX3, (Exception) null);
                                    }
                                    q52Var5.c += ((iH12 >> 24) & 255) == 0 ? wf1Var6.v() : wf1Var6.y();
                                }
                                jh.b bVarC5 = aVar2.c(1936027235);
                                if (bVarC5 != null) {
                                    a(bVarC5.b, 0, q52Var5);
                                }
                                String str = p52VarA != null ? p52VarA.b : null;
                                wf1 wf1Var7 = null;
                                wf1 wf1Var8 = null;
                                for (int i21 = 0; i21 < aVar2.c.size(); i21++) {
                                    jh.b bVar4 = (jh.b) aVar2.c.get(i21);
                                    wf1 wf1Var9 = bVar4.b;
                                    int i22 = bVar4.f9316a;
                                    if (i22 == 1935828848) {
                                        wf1Var9.e(12);
                                        if (wf1Var9.h() == 1936025959) {
                                            wf1Var7 = wf1Var9;
                                        }
                                    } else if (i22 == 1936158820) {
                                        wf1Var9.e(12);
                                        if (wf1Var9.h() == 1936025959) {
                                            wf1Var8 = wf1Var9;
                                        }
                                    }
                                }
                                if (wf1Var7 != null && wf1Var8 != null) {
                                    wf1Var7.e(8);
                                    int iH13 = (wf1Var7.h() >> 24) & 255;
                                    wf1Var7.f(4);
                                    if (iH13 == 1) {
                                        wf1Var7.f(4);
                                    }
                                    if (wf1Var7.h() == 1) {
                                        wf1Var8.e(8);
                                        int iH14 = (wf1Var8.h() >> 24) & 255;
                                        wf1Var8.f(4);
                                        if (iH14 == 1) {
                                            if (wf1Var8.v() == 0) {
                                                throw ag1.a("Variable length description in sgpd found (unsupported)");
                                            }
                                        } else if (iH14 >= 2) {
                                            wf1Var8.f(4);
                                        }
                                        if (wf1Var8.v() == 1) {
                                            wf1Var8.f(1);
                                            int iT3 = wf1Var8.t();
                                            int i23 = (iT3 & 240) >> 4;
                                            int i24 = iT3 & 15;
                                            boolean z10 = wf1Var8.t() == 1;
                                            if (z10) {
                                                int iT4 = wf1Var8.t();
                                                byte[] bArr7 = new byte[16];
                                                wf1Var8.a(bArr7, 0, 16);
                                                if (iT4 == 0) {
                                                    int iT5 = wf1Var8.t();
                                                    byte[] bArr8 = new byte[iT5];
                                                    wf1Var8.a(bArr8, 0, iT5);
                                                    bArr3 = bArr8;
                                                } else {
                                                    bArr3 = null;
                                                }
                                                q52Var5.k = true;
                                                q52Var5.m = new p52(z10, str, iT4, bArr7, i23, i24, bArr3);
                                            }
                                        } else {
                                            throw ag1.a("Entry count in sgpd != 1 (unsupported).");
                                        }
                                    } else {
                                        throw ag1.a("Entry count in sbgp != 1 (unsupported).");
                                    }
                                }
                                int size3 = aVar2.c.size();
                                int i25 = 0;
                                while (i25 < size3) {
                                    jh.b bVar5 = (jh.b) aVar2.c.get(i25);
                                    if (bVar5.f9316a == 1970628964) {
                                        wf1 wf1Var10 = bVar5.b;
                                        wf1Var10.e(8);
                                        bArr2 = bArr6;
                                        wf1Var10.a(bArr2, 0, 16);
                                        if (Arrays.equals(bArr2, F)) {
                                            a(wf1Var10, 16, q52Var5);
                                        }
                                    } else {
                                        bArr2 = bArr6;
                                    }
                                    i25++;
                                    bArr6 = bArr2;
                                }
                                bArr = bArr6;
                            }
                        } else {
                            aVar = aVarPop;
                            sparseArray = sparseArray2;
                            i = size;
                            i2 = i8;
                            bArr = bArr5;
                        }
                        i8 = i2 + 1;
                        bArr5 = bArr;
                        sparseArray2 = sparseArray;
                        size = i;
                        aVarPop = aVar;
                    }
                    c40 c40VarA = a(aVarPop.c);
                    mc0Var = this;
                    if (c40VarA != null) {
                        int size4 = mc0Var.b.size();
                        for (int i26 = 0; i26 < size4; i26++) {
                            b bVarValueAt = mc0Var.b.valueAt(i26);
                            o52 o52Var3 = bVarValueAt.d.f10359a;
                            k00 k00Var4 = bVarValueAt.b.f9984a;
                            int i27 = x82.f10629a;
                            p52 p52VarA2 = o52Var3.a(k00Var4.f9367a);
                            bVarValueAt.f9626a.a(bVarValueAt.d.f10359a.f.a().a(c40VarA.a(p52VarA2 != null ? p52VarA2.b : null)).a());
                        }
                    }
                    if (mc0Var.t != -9223372036854775807L) {
                        int size5 = mc0Var.b.size();
                        for (int i28 = 0; i28 < size5; i28++) {
                            b bVarValueAt2 = mc0Var.b.valueAt(i28);
                            long j7 = mc0Var.t;
                            int i29 = bVarValueAt2.f;
                            while (true) {
                                q52 q52Var6 = bVarValueAt2.b;
                                if (i29 >= q52Var6.e || q52Var6.i[i29] >= j7) {
                                    break;
                                }
                                if (q52Var6.j[i29]) {
                                    bVarValueAt2.i = i29;
                                }
                                i29++;
                            }
                        }
                        mc0Var.t = -9223372036854775807L;
                    }
                } else {
                    mc0Var = mc0Var2;
                    if (!mc0Var.j.isEmpty()) {
                        mc0Var.j.peek().d.add(aVarPop);
                    }
                }
                mc0Var2 = mc0Var;
            }
        }
        mc0 mc0Var3 = mc0Var2;
        mc0Var3.m = 0;
        mc0Var3.p = 0;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0212  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        Exception exc;
        ?? r9;
        b bVar;
        long j;
        int i;
        int i2;
        int iB;
        boolean z;
        int i3;
        long j2;
        long j3;
        String str;
        long jA;
        long jV;
        String str2;
        long j4;
        long j5;
        long jY;
        long jY2;
        while (true) {
            int i4 = this.m;
            exc = null;
            r9 = 0;
            if (i4 == 0) {
                if (this.p == 0) {
                    if (!((tz) x70Var).a(this.i.c(), 0, 8, true)) {
                        return -1;
                    }
                    this.p = 8;
                    this.i.e(0);
                    this.o = this.i.v();
                    this.n = this.i.h();
                }
                long j6 = this.o;
                if (j6 == 1) {
                    ((tz) x70Var).a(this.i.c(), 8, 8, false);
                    this.p += 8;
                    this.o = this.i.y();
                } else if (j6 == 0) {
                    tz tzVar = (tz) x70Var;
                    long jB = tzVar.b();
                    if (jB == -1 && !this.j.isEmpty()) {
                        jB = this.j.peek().b;
                    }
                    if (jB != -1) {
                        this.o = (jB - tzVar.a()) + ((long) this.p);
                    }
                }
                if (this.o >= this.p) {
                    tz tzVar2 = (tz) x70Var;
                    long jA2 = tzVar2.a() - ((long) this.p);
                    int i5 = this.n;
                    if ((i5 == 1836019558 || i5 == 1835295092) && !this.E) {
                        this.B.a(new xw1.b(this.u, jA2));
                        this.E = true;
                    }
                    if (this.n == 1836019558) {
                        int size = this.b.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            q52 q52Var = this.b.valueAt(i6).b;
                            q52Var.getClass();
                            q52Var.c = jA2;
                            q52Var.b = jA2;
                        }
                    }
                    int i7 = this.n;
                    if (i7 == 1835295092) {
                        this.w = null;
                        this.r = jA2 + this.o;
                        this.m = 2;
                    } else if (i7 == 1836019574 || i7 == 1953653099 || i7 == 1835297121 || i7 == 1835626086 || i7 == 1937007212 || i7 == 1836019558 || i7 == 1953653094 || i7 == 1836475768 || i7 == 1701082227) {
                        long jA3 = (tzVar2.a() + this.o) - 8;
                        this.j.push(new jh.a(this.n, jA3));
                        if (this.o == this.p) {
                            a(jA3);
                        } else {
                            this.m = 0;
                            this.p = 0;
                        }
                    } else if (i7 == 1751411826 || i7 == 1835296868 || i7 == 1836476516 || i7 == 1936286840 || i7 == 1937011556 || i7 == 1937011827 || i7 == 1668576371 || i7 == 1937011555 || i7 == 1937011578 || i7 == 1937013298 || i7 == 1937007471 || i7 == 1668232756 || i7 == 1937011571 || i7 == 1952867444 || i7 == 1952868452 || i7 == 1953196132 || i7 == 1953654136 || i7 == 1953658222 || i7 == 1886614376 || i7 == 1935763834 || i7 == 1935763823 || i7 == 1936027235 || i7 == 1970628964 || i7 == 1935828848 || i7 == 1936158820 || i7 == 1701606260 || i7 == 1835362404 || i7 == 1701671783) {
                        if (this.p == 8) {
                            long j7 = this.o;
                            if (j7 <= 2147483647L) {
                                wf1 wf1Var = new wf1((int) j7);
                                System.arraycopy(this.i.c(), 0, wf1Var.c(), 0, 8);
                                this.q = wf1Var;
                                this.m = 1;
                            } else {
                                throw ag1.a("Leaf atom with length > 2147483647 (unsupported).");
                            }
                        } else {
                            throw ag1.a("Leaf atom defines extended atom size (unsupported).");
                        }
                    } else if (this.o <= 2147483647L) {
                        this.q = null;
                        this.m = 1;
                    } else {
                        throw ag1.a("Skipping atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw ag1.a("Atom size less than header length (unsupported).");
                }
            } else if (i4 != 1) {
                long j8 = Long.MAX_VALUE;
                if (i4 != 2) {
                    bVar = this.w;
                    if (bVar != null) {
                        break;
                    }
                    SparseArray<b> sparseArray = this.b;
                    int size2 = sparseArray.size();
                    long j9 = Long.MAX_VALUE;
                    b bVar2 = null;
                    for (int i8 = 0; i8 < size2; i8++) {
                        b bVarValueAt = sparseArray.valueAt(i8);
                        boolean z2 = bVarValueAt.l;
                        if ((z2 || bVarValueAt.f != bVarValueAt.d.b) && (!z2 || bVarValueAt.h != bVarValueAt.b.d)) {
                            if (!z2) {
                                j3 = bVarValueAt.d.c[bVarValueAt.f];
                            } else {
                                j3 = bVarValueAt.b.f[bVarValueAt.h];
                            }
                            if (j3 < j9) {
                                bVar2 = bVarValueAt;
                                j9 = j3;
                            }
                        }
                    }
                    if (bVar2 == null) {
                        tz tzVar3 = (tz) x70Var;
                        int iA = (int) (this.r - tzVar3.a());
                        if (iA >= 0) {
                            tzVar3.a(iA);
                            this.m = 0;
                            this.p = 0;
                        } else {
                            throw ag1.a("Offset to end of mdat was negative.", (Exception) null);
                        }
                    } else {
                        if (!bVar2.l) {
                            j2 = bVar2.d.c[bVar2.f];
                        } else {
                            j2 = bVar2.b.f[bVar2.h];
                        }
                        tz tzVar4 = (tz) x70Var;
                        int iA2 = (int) (j2 - tzVar4.a());
                        if (iA2 < 0) {
                            at0.d("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            iA2 = 0;
                        }
                        tzVar4.a(iA2);
                        this.w = bVar2;
                        bVar = bVar2;
                        break;
                    }
                } else {
                    int size3 = this.b.size();
                    b bVarValueAt2 = null;
                    for (int i9 = 0; i9 < size3; i9++) {
                        q52 q52Var2 = this.b.valueAt(i9).b;
                        if (q52Var2.o) {
                            long j10 = q52Var2.c;
                            if (j10 < j8) {
                                bVarValueAt2 = this.b.valueAt(i9);
                                j8 = j10;
                            }
                        }
                    }
                    if (bVarValueAt2 == null) {
                        this.m = 3;
                    } else {
                        tz tzVar5 = (tz) x70Var;
                        int iA3 = (int) (j8 - tzVar5.a());
                        if (iA3 >= 0) {
                            tzVar5.a(iA3);
                            q52 q52Var3 = bVarValueAt2.b;
                            tzVar5.a(q52Var3.n.c(), 0, q52Var3.n.e(), false);
                            q52Var3.n.e(0);
                            q52Var3.o = false;
                        } else {
                            throw ag1.a("Offset to encryption data was negative.", (Exception) null);
                        }
                    }
                }
            } else {
                int i10 = ((int) this.o) - this.p;
                wf1 wf1Var2 = this.q;
                if (wf1Var2 != null) {
                    tz tzVar6 = (tz) x70Var;
                    tzVar6.a(wf1Var2.c(), 8, i10, false);
                    int i11 = this.n;
                    jh.b bVar3 = new jh.b(i11, wf1Var2);
                    long jA4 = tzVar6.a();
                    if (!this.j.isEmpty()) {
                        this.j.peek().c.add(bVar3);
                    } else if (i11 == 1936286840) {
                        wf1Var2.e(8);
                        int iH = (wf1Var2.h() >> 24) & 255;
                        wf1Var2.f(4);
                        long jV2 = wf1Var2.v();
                        if (iH == 0) {
                            jY = wf1Var2.v();
                            jY2 = wf1Var2.v();
                        } else {
                            jY = wf1Var2.y();
                            jY2 = wf1Var2.y();
                        }
                        long j11 = jY2 + jA4;
                        long jA5 = x82.a(jY, 1000000L, jV2);
                        wf1Var2.f(2);
                        int iZ = wf1Var2.z();
                        int[] iArr = new int[iZ];
                        long[] jArr = new long[iZ];
                        long[] jArr2 = new long[iZ];
                        long[] jArr3 = new long[iZ];
                        long j12 = j11;
                        long jA6 = jA5;
                        int i12 = 0;
                        while (i12 < iZ) {
                            int iH2 = wf1Var2.h();
                            if ((iH2 & Integer.MIN_VALUE) == 0) {
                                long jV3 = wf1Var2.v();
                                iArr[i12] = iH2 & Integer.MAX_VALUE;
                                jArr[i12] = j12;
                                jArr3[i12] = jA6;
                                jY += jV3;
                                jA6 = x82.a(jY, 1000000L, jV2);
                                jArr2[i12] = jA6 - jArr3[i12];
                                wf1Var2.f(4);
                                j12 += (long) iArr[i12];
                                i12++;
                                iZ = iZ;
                                jV2 = jV2;
                            } else {
                                throw ag1.a("Unhandled indirect reference", (Exception) null);
                            }
                        }
                        Pair pairCreate = Pair.create(Long.valueOf(jA5), new lo(iArr, jArr, jArr2, jArr3));
                        this.v = ((Long) pairCreate.first).longValue();
                        this.B.a((xw1) pairCreate.second);
                        this.E = true;
                    } else if (i11 == 1701671783 && this.C.length != 0) {
                        wf1Var2.e(8);
                        int iH3 = (wf1Var2.h() >> 24) & 255;
                        if (iH3 == 0) {
                            String strQ = wf1Var2.q();
                            strQ.getClass();
                            String strQ2 = wf1Var2.q();
                            strQ2.getClass();
                            long jV4 = wf1Var2.v();
                            long jA7 = x82.a(wf1Var2.v(), 1000000L, jV4);
                            long j13 = this.v;
                            long j14 = j13 != -9223372036854775807L ? j13 + jA7 : -9223372036854775807L;
                            str = strQ;
                            jA = x82.a(wf1Var2.v(), 1000L, jV4);
                            jV = wf1Var2.v();
                            str2 = strQ2;
                            j4 = jA7;
                            j5 = j14;
                        } else if (iH3 != 1) {
                            tr0.a("Skipping unsupported emsg version: ", iH3, "FragmentedMp4Extractor");
                        } else {
                            long jV5 = wf1Var2.v();
                            long jA8 = x82.a(wf1Var2.y(), 1000000L, jV5);
                            long jA9 = x82.a(wf1Var2.v(), 1000L, jV5);
                            long jV6 = wf1Var2.v();
                            String strQ3 = wf1Var2.q();
                            strQ3.getClass();
                            String strQ4 = wf1Var2.q();
                            strQ4.getClass();
                            str = strQ3;
                            jA = jA9;
                            j5 = jA8;
                            jV = jV6;
                            str2 = strQ4;
                            j4 = -9223372036854775807L;
                        }
                        byte[] bArr = new byte[wf1Var2.a()];
                        wf1Var2.a(bArr, 0, wf1Var2.a());
                        wf1 wf1Var3 = new wf1(this.h.a(new v50(str, str2, jA, jV, bArr)));
                        int iA4 = wf1Var3.a();
                        for (t52 t52Var : this.C) {
                            wf1Var3.e(0);
                            t52Var.a(iA4, wf1Var3);
                        }
                        if (j5 == -9223372036854775807L) {
                            this.k.addLast(new a(iA4, j4, true));
                            this.s += iA4;
                        } else if (!this.k.isEmpty()) {
                            this.k.addLast(new a(iA4, j5, false));
                            this.s += iA4;
                        } else {
                            for (t52 t52Var2 : this.C) {
                                t52Var2.a(j5, 1, iA4, 0, null);
                            }
                        }
                    }
                } else {
                    ((tz) x70Var).a(i10);
                }
                a(((tz) x70Var).a());
            }
        }
        int i13 = 6;
        if (this.m == 3) {
            if (!bVar.l) {
                i3 = bVar.d.d[bVar.f];
            } else {
                i3 = bVar.b.h[bVar.f];
            }
            this.x = i3;
            if (bVar.f < bVar.i) {
                ((tz) x70Var).a(i3);
                p52 p52VarA = bVar.a();
                if (p52VarA != null) {
                    wf1 wf1Var4 = bVar.b.n;
                    int i14 = p52VarA.d;
                    if (i14 != 0) {
                        wf1Var4.f(i14);
                    }
                    q52 q52Var4 = bVar.b;
                    int i15 = bVar.f;
                    if (q52Var4.k && q52Var4.l[i15]) {
                        wf1Var4.f(wf1Var4.z() * 6);
                    }
                }
                bVar.f++;
                if (bVar.l) {
                    int i16 = bVar.g + 1;
                    bVar.g = i16;
                    int[] iArr2 = bVar.b.g;
                    int i17 = bVar.h;
                    if (i16 == iArr2[i17]) {
                        bVar.h = i17 + 1;
                        bVar.g = 0;
                        this.w = null;
                    }
                } else {
                    this.w = null;
                }
                this.m = 3;
                return 0;
            }
            if (bVar.d.f10359a.g == 1) {
                this.x = i3 - 8;
                ((tz) x70Var).a(8);
            }
            if ("audio/ac4".equals(bVar.d.f10359a.f.m)) {
                this.y = bVar.a(this.x, 7);
                w.a(this.x, this.g);
                bVar.f9626a.a(7, this.g);
                this.y += 7;
            } else {
                this.y = bVar.a(this.x, 0);
            }
            this.x += this.y;
            this.m = 4;
            this.z = 0;
        }
        u52 u52Var = bVar.d;
        o52 o52Var = u52Var.f10359a;
        t52 t52Var3 = bVar.f9626a;
        if (!bVar.l) {
            j = u52Var.f[bVar.f];
        } else {
            j = bVar.b.i[bVar.f];
        }
        if (o52Var.j == 0) {
            while (true) {
                int i18 = this.y;
                int i19 = this.x;
                if (i18 >= i19) {
                    break;
                }
                this.y += t52Var3.b(x70Var, i19 - i18, false);
            }
        } else {
            byte[] bArrC = this.d.c();
            bArrC[0] = 0;
            bArrC[1] = 0;
            bArrC[2] = 0;
            int i20 = o52Var.j;
            int i21 = i20 + 1;
            int i22 = 4 - i20;
            while (this.y < this.x) {
                int i23 = this.z;
                if (i23 == 0) {
                    ((tz) x70Var).a(bArrC, i22, i21, r9);
                    this.d.e(r9);
                    int iH4 = this.d.h();
                    if (iH4 >= 1) {
                        this.z = iH4 - 1;
                        this.c.e(r9);
                        t52Var3.a(4, this.c);
                        t52Var3.a(1, this.d);
                        if (this.D.length > 0) {
                            String str3 = o52Var.f.m;
                            int i24 = bArrC[4];
                            byte[] bArr2 = a41.f8364a;
                            if (("video/avc".equals(str3) && (i24 & 31) == i13) || ("video/hevc".equals(str3) && ((i24 & 126) >> 1) == 39)) {
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                        this.A = z;
                        this.y += 5;
                        this.x += i22;
                    } else {
                        throw ag1.a("Invalid NAL length", exc);
                    }
                } else {
                    if (this.A) {
                        this.e.c(i23);
                        ((tz) x70Var).a(this.e.c(), 0, this.z, false);
                        t52Var3.a(this.z, this.e);
                        iB = this.z;
                        int iA5 = a41.a(this.e.e(), this.e.c());
                        this.e.e("video/hevc".equals(o52Var.f.m) ? 1 : 0);
                        this.e.d(iA5);
                        co.a(j, this.e, this.D);
                    } else {
                        iB = t52Var3.b(x70Var, i23, false);
                    }
                    this.y += iB;
                    this.z -= iB;
                    i13 = 6;
                    exc = null;
                }
                r9 = 0;
            }
        }
        if (!bVar.l) {
            i = bVar.d.g[bVar.f];
        } else {
            i = bVar.b.j[bVar.f] ? 1 : 0;
        }
        if (bVar.a() != null) {
            i |= 1073741824;
        }
        int i25 = i;
        p52 p52VarA2 = bVar.a();
        t52Var3.a(j, i25, this.x, 0, p52VarA2 != null ? p52VarA2.c : null);
        while (!this.k.isEmpty()) {
            a aVarRemoveFirst = this.k.removeFirst();
            this.s -= aVarRemoveFirst.c;
            long j15 = aVarRemoveFirst.f9625a;
            if (aVarRemoveFirst.b) {
                j15 += j;
            }
            for (t52 t52Var4 : this.C) {
                t52Var4.a(j15, 1, aVarRemoveFirst.c, this.s, null);
            }
        }
        bVar.f++;
        if (bVar.l) {
            int i26 = bVar.g + 1;
            bVar.g = i26;
            int[] iArr3 = bVar.b.g;
            int i27 = bVar.h;
            if (i26 == iArr3[i27]) {
                bVar.h = i27 + 1;
                i2 = 0;
                bVar.g = 0;
            } else {
                i2 = 0;
            }
            this.m = 3;
            return i2;
        }
        i2 = 0;
        this.w = null;
        this.m = 3;
        return i2;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.b.valueAt(i).b();
        }
        this.k.clear();
        this.s = 0;
        this.t = j2;
        this.j.clear();
        this.m = 0;
        this.p = 0;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        return n02.a((tz) x70Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static w70[] a() {
        return new w70[]{new mc0(0)};
    }
}
