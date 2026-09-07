package com.yandex.mobile.ads.impl;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class h72 implements w70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9069a;
    private final int b;
    private final List<i52> c;
    private final wf1 d;
    private final SparseIntArray e;
    private final i72.c f;
    private final SparseArray<i72> g;
    private final SparseBooleanArray h;
    private final SparseBooleanArray i;
    private final g72 j;
    private f72 k;
    private y70 l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private i72 q;
    private int r;
    private int s;

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.h72$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return h72.a();
            }
        };
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    public h72(int i) {
        this(new i52(0L), new q00());
    }

    public h72(i52 i52Var, q00 q00Var) {
        this.f = (i72.c) hg.a(q00Var);
        this.b = 112800;
        this.f9069a = 1;
        this.c = Collections.singletonList(i52Var);
        this.d = new wf1(0, new byte[9400]);
        this.h = new SparseBooleanArray();
        this.i = new SparseBooleanArray();
        this.g = new SparseArray<>();
        this.e = new SparseIntArray();
        this.j = new g72();
        this.l = y70.f10708a;
        this.s = -1;
        b();
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.l = y70Var;
    }

    private void b() {
        this.h.clear();
        this.g.clear();
        SparseArray<i72> sparseArrayA = this.f.a();
        int size = sparseArrayA.size();
        for (int i = 0; i < size; i++) {
            this.g.put(sparseArrayA.keyAt(i), sparseArrayA.valueAt(i));
        }
        this.g.put(0, new ww1(new a()));
        this.q = null;
    }

    private class a implements vw1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final vf1 f9070a = new vf1(new byte[4]);

        @Override // com.yandex.mobile.ads.impl.vw1
        public final void a(i52 i52Var, y70 y70Var, i72.d dVar) {
        }

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.vw1
        public final void a(wf1 wf1Var) {
            if (wf1Var.t() == 0 && (wf1Var.t() & 128) != 0) {
                wf1Var.f(6);
                int iA = wf1Var.a() / 4;
                for (int i = 0; i < iA; i++) {
                    vf1 vf1Var = this.f9070a;
                    wf1Var.a(vf1Var.f10476a, 0, 4);
                    vf1Var.c(0);
                    int iB = this.f9070a.b(16);
                    this.f9070a.d(3);
                    if (iB == 0) {
                        this.f9070a.d(13);
                    } else {
                        int iB2 = this.f9070a.b(13);
                        if (h72.this.g.get(iB2) == null) {
                            h72 h72Var = h72.this;
                            h72Var.g.put(iB2, new ww1(h72Var.new b(iB2)));
                            h72.this.m++;
                        }
                    }
                }
                h72 h72Var2 = h72.this;
                if (h72Var2.f9069a != 2) {
                    h72Var2.g.remove(0);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.yandex.mobile.ads.impl.i72] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.util.SparseBooleanArray] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v5, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        ?? r15;
        ?? r14;
        i72 i72Var;
        long j;
        tz tzVar = (tz) x70Var;
        long jB = tzVar.b();
        if (!this.n) {
            r15 = 0;
            r14 = 1;
        } else {
            if (jB != -1 && this.f9069a != 2 && !this.j.c()) {
                return this.j.a(tzVar, lj1Var, this.s);
            }
            if (this.o) {
                j = 0;
            } else {
                this.o = true;
                if (this.j.a() != -9223372036854775807L) {
                    j = 0;
                    f72 f72Var = new f72(this.j.b(), this.j.a(), jB, this.s, this.b);
                    this.k = f72Var;
                    this.l.a(f72Var.a());
                } else {
                    j = 0;
                    this.l.a(new xw1.b(this.j.a(), 0L));
                }
            }
            if (this.p) {
                this.p = 0;
                a(j, j);
                if (tzVar.a() != j) {
                    lj1Var.f9531a = j;
                    return 1;
                }
            }
            f72 f72Var2 = this.k;
            if (f72Var2 != null && f72Var2.b()) {
                return this.k.a(tzVar, lj1Var);
            }
        }
        byte[] bArrC = this.d.c();
        if (9400 - this.d.d() < 188) {
            int iA = this.d.a();
            if (iA > 0) {
                System.arraycopy(bArrC, this.d.d(), bArrC, r15, iA);
            }
            this.d.a(iA, bArrC);
        }
        while (this.d.a() < 188) {
            int iE = this.d.e();
            int i = tzVar.read(bArrC, iE, 9400 - iE);
            if (i == -1) {
                return -1;
            }
            this.d.d(iE + i);
        }
        int iD = this.d.d();
        int iE2 = this.d.e();
        byte[] bArrC2 = this.d.c();
        int i2 = iD;
        while (i2 < iE2 && bArrC2[i2] != 71) {
            i2++;
        }
        this.d.e(i2);
        int i3 = i2 + 188;
        ?? r5 = 0;
        if (i3 > iE2) {
            int i4 = (i2 - iD) + this.r;
            this.r = i4;
            if (this.f9069a == 2 && i4 > 376) {
                throw ag1.a("Cannot find sync byte. Most likely not a Transport Stream.", (Exception) null);
            }
        } else {
            this.r = r15;
        }
        int iE3 = this.d.e();
        if (i3 > iE3) {
            return r15;
        }
        int iH = this.d.h();
        if ((8388608 & iH) != 0) {
            this.d.e(i3);
            return r15;
        }
        ?? r10 = (4194304 & iH) != 0 ? r14 : r15;
        int i5 = (2096896 & iH) >> 8;
        ?? r6 = (iH & 32) != 0 ? r14 : r15;
        if ((iH & 16) != 0) {
            i72Var = this.g.get(i5);
        }
        if (r5 == 0) {
            r5 = i72Var;
            this.d.e(i3);
            return r15;
        }
        if (this.f9069a != 2) {
            int i6 = iH & 15;
            int i7 = this.e.get(i5, i6 - 1);
            this.e.put(i5, i6);
            if (i7 == i6) {
                r5 = i72Var;
                this.d.e(i3);
                return r15;
            }
            if (i6 != ((i7 + r14) & 15)) {
                r5 = i72Var;
                r5.a();
            }
        }
        if (r6 != 0) {
            int iT = this.d.t();
            r10 = (r10 == true ? 1 : 0) | ((this.d.t() & 64) != 0 ? 2 : r15);
            this.d.f(iT - r14);
        }
        boolean z = this.n;
        if (this.f9069a == 2 || z || !this.i.get(i5, r15)) {
            this.d.d(i3);
            r5.a(r10, this.d);
            this.d.d(iE3);
        }
        if (this.f9069a != 2 && !z && this.n && jB != -1) {
            this.p = r14;
        }
        this.d.e(i3);
        return r15;
    }

    private class b implements vw1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final vf1 f9071a = new vf1(new byte[5]);
        private final SparseArray<i72> b = new SparseArray<>();
        private final SparseIntArray c = new SparseIntArray();
        private final int d;

        @Override // com.yandex.mobile.ads.impl.vw1
        public final void a(i52 i52Var, y70 y70Var, i72.d dVar) {
        }

        public b(int i) {
            this.d = i;
        }

        /* JADX WARN: Code duplicated, block: B:46:0x0159  */
        /* JADX WARN: Code duplicated, block: B:50:0x0162  */
        /* JADX WARN: Code duplicated, block: B:55:0x016f  */
        /* JADX WARN: Code duplicated, block: B:97:0x023a  */
        @Override // com.yandex.mobile.ads.impl.vw1
        public final void a(wf1 wf1Var) {
            i52 i52Var;
            int i;
            int i2;
            i72 i72VarA;
            int i3;
            if (wf1Var.t() != 2) {
                return;
            }
            h72 h72Var = h72.this;
            int i4 = h72Var.f9069a;
            int i5 = 0;
            if (i4 != 1 && i4 != 2 && h72Var.m != 1) {
                i52Var = new i52(((i52) h72Var.c.get(0)).a());
                h72.this.c.add(i52Var);
            } else {
                i52Var = (i52) h72Var.c.get(0);
            }
            if ((wf1Var.t() & 128) == 0) {
                return;
            }
            wf1Var.f(1);
            int iZ = wf1Var.z();
            int i6 = 3;
            wf1Var.f(3);
            vf1 vf1Var = this.f9071a;
            wf1Var.a(vf1Var.f10476a, 0, 2);
            vf1Var.c(0);
            this.f9071a.d(3);
            int i7 = 13;
            h72.this.s = this.f9071a.b(13);
            vf1 vf1Var2 = this.f9071a;
            wf1Var.a(vf1Var2.f10476a, 0, 2);
            vf1Var2.c(0);
            int i8 = 4;
            this.f9071a.d(4);
            int i9 = 12;
            wf1Var.f(this.f9071a.b(12));
            h72 h72Var2 = h72.this;
            int i10 = 21;
            if (h72Var2.f9069a == 2 && h72Var2.q == null) {
                i72.b bVar = new i72.b(21, null, null, x82.f);
                h72 h72Var3 = h72.this;
                h72Var3.q = h72Var3.f.a(21, bVar);
                h72 h72Var4 = h72.this;
                i72 i72Var = h72Var4.q;
                if (i72Var != null) {
                    i72Var.a(i52Var, h72Var4.l, new i72.d(iZ, 21, 8192));
                }
            }
            this.b.clear();
            this.c.clear();
            int iA = wf1Var.a();
            while (iA > 0) {
                vf1 vf1Var3 = this.f9071a;
                int i11 = 5;
                wf1Var.a(vf1Var3.f10476a, i5, 5);
                vf1Var3.c(i5);
                int iB = this.f9071a.b(8);
                this.f9071a.d(i6);
                int iB2 = this.f9071a.b(i7);
                this.f9071a.d(i8);
                int iB3 = this.f9071a.b(i9);
                int iD = wf1Var.d();
                int i12 = iD + iB3;
                int i13 = -1;
                String strTrim = null;
                ArrayList arrayList = null;
                while (true) {
                    if (wf1Var.d() >= i12) {
                        i = i8;
                        break;
                    }
                    int iT = wf1Var.t();
                    int iD2 = wf1Var.d() + wf1Var.t();
                    if (iD2 > i12) {
                        i = 4;
                        break;
                    }
                    if (iT == i11) {
                        long jV = wf1Var.v();
                        if (jV == 1094921523) {
                            i13 = 129;
                        } else if (jV == 1161904947) {
                            i13 = 135;
                        } else if (jV == 1094921524) {
                            i13 = 172;
                        } else if (jV == 1212503619) {
                            i13 = 36;
                        }
                        i3 = 4;
                    } else {
                        if (iT == 106) {
                            i13 = 129;
                        } else if (iT == 122) {
                            i13 = 135;
                        } else if (iT == 127) {
                            if (wf1Var.t() == i10) {
                                i13 = 172;
                            }
                        } else if (iT == 123) {
                            i13 = 138;
                        } else if (iT == 10) {
                            strTrim = wf1Var.a(i6, ko.c).trim();
                        } else if (iT == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (wf1Var.d() < iD2) {
                                String strTrim2 = wf1Var.a(i6, ko.c).trim();
                                wf1Var.t();
                                byte[] bArr = new byte[4];
                                wf1Var.a(bArr, 0, 4);
                                arrayList2.add(new i72.a(strTrim2, bArr));
                                i6 = 3;
                            }
                            i3 = 4;
                            arrayList = arrayList2;
                            i13 = 89;
                        } else {
                            i3 = 4;
                            if (iT == 111) {
                                i13 = 257;
                            }
                        }
                        i3 = 4;
                    }
                    wf1Var.f(iD2 - wf1Var.d());
                    i8 = i3;
                    i11 = 5;
                    i6 = 3;
                    i10 = 21;
                }
                wf1Var.e(i12);
                i72.b bVar2 = new i72.b(i13, strTrim, arrayList, Arrays.copyOfRange(wf1Var.c(), iD, i12));
                if (iB == 6 || iB == 5) {
                    iB = i13;
                }
                iA -= iB3 + 5;
                h72 h72Var5 = h72.this;
                int i14 = h72Var5.f9069a == 2 ? iB : iB2;
                if (h72Var5.h.get(i14)) {
                    i2 = 21;
                } else {
                    h72 h72Var6 = h72.this;
                    if (h72Var6.f9069a == 2) {
                        i2 = 21;
                        if (iB == 21) {
                            i72VarA = h72Var6.q;
                        }
                        if (h72.this.f9069a == 2 || iB2 < this.c.get(i14, 8192)) {
                            this.c.put(i14, iB2);
                            this.b.put(i14, i72VarA);
                        }
                    } else {
                        i2 = 21;
                    }
                    i72VarA = h72Var6.f.a(iB, bVar2);
                    if (h72.this.f9069a == 2) {
                        this.c.put(i14, iB2);
                        this.b.put(i14, i72VarA);
                    } else {
                        this.c.put(i14, iB2);
                        this.b.put(i14, i72VarA);
                    }
                }
                i8 = i;
                i10 = i2;
                i5 = 0;
                i6 = 3;
                i7 = 13;
                i9 = 12;
            }
            int size = this.c.size();
            for (int i15 = 0; i15 < size; i15++) {
                int iKeyAt = this.c.keyAt(i15);
                int iValueAt = this.c.valueAt(i15);
                h72.this.h.put(iKeyAt, true);
                h72.this.i.put(iValueAt, true);
                i72 i72VarValueAt = this.b.valueAt(i15);
                if (i72VarValueAt != null) {
                    h72 h72Var7 = h72.this;
                    if (i72VarValueAt != h72Var7.q) {
                        i72VarValueAt.a(i52Var, h72Var7.l, new i72.d(iZ, iKeyAt, 8192));
                    }
                    h72.this.g.put(iValueAt, i72VarValueAt);
                }
            }
            h72 h72Var8 = h72.this;
            if (h72Var8.f9069a == 2) {
                if (h72Var8.n) {
                    return;
                }
                h72Var8.l.a();
                h72 h72Var9 = h72.this;
                h72Var9.m = 0;
                h72Var9.n = true;
                return;
            }
            h72Var8.g.remove(this.d);
            h72 h72Var10 = h72.this;
            int i16 = h72Var10.f9069a == 1 ? 0 : h72Var10.m - 1;
            h72Var10.m = i16;
            if (i16 == 0) {
                h72Var10.l.a();
                h72.this.n = true;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        f72 f72Var;
        if (this.f9069a != 2) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                i52 i52Var = this.c.get(i);
                boolean z = i52Var.c() == -9223372036854775807L;
                if (!z) {
                    long jA = i52Var.a();
                    if (jA != -9223372036854775807L && jA != 0 && jA != j2) {
                        i52Var.c(j2);
                    }
                } else if (z) {
                    i52Var.c(j2);
                }
            }
            if (j2 != 0 && (f72Var = this.k) != null) {
                f72Var.a(j2);
            }
            this.d.c(0);
            this.e.clear();
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                this.g.valueAt(i2).a();
            }
            this.r = 0;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        byte[] bArrC = this.d.c();
        tz tzVar = (tz) x70Var;
        tzVar.b(bArrC, 0, 940, false);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 < 5) {
                    if (bArrC[(i2 * 188) + i] != 71) {
                        break;
                    }
                    i2++;
                } else {
                    tzVar.a(i);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static w70[] a() {
        return new w70[]{new h72(0)};
    }
}
