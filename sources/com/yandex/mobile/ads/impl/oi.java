package com.yandex.mobile.ads.impl;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class oi implements w70 {
    private int c;
    private pi e;
    private long h;
    private mo i;
    private int m;
    private boolean n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wf1 f9819a = new wf1(12);
    private final b b = new b();
    private y70 d = new n40();
    private mo[] g = new mo[0];
    private long k = -1;
    private long l = -1;
    private int j = -1;
    private long f = -9223372036854775807L;

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.c = 0;
        this.d = y70Var;
        this.h = -1L;
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0334  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e2  */
    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        boolean z;
        mo moVar;
        long j;
        mo moVar2;
        if (this.h != -1) {
            tz tzVar = (tz) x70Var;
            long jA = tzVar.a();
            long j2 = this.h;
            if (j2 >= jA && j2 <= PlaybackStateCompat.ACTION_SET_REPEAT_MODE + jA) {
                tzVar.a((int) (j2 - jA));
                z = false;
            } else {
                lj1Var.f9531a = j2;
                z = true;
            }
        } else {
            z = false;
        }
        this.h = -1L;
        if (z) {
            return 1;
        }
        mo moVar3 = null;
        switch (this.c) {
            case 0:
                if (a(x70Var)) {
                    ((tz) x70Var).a(12);
                    this.c = 1;
                    return 0;
                }
                throw ag1.a("AVI Header List not found", (Exception) null);
            case 1:
                ((tz) x70Var).a(this.f9819a.c(), 0, 12, false);
                this.f9819a.e(0);
                b bVar = this.b;
                wf1 wf1Var = this.f9819a;
                bVar.getClass();
                bVar.f9821a = wf1Var.k();
                bVar.b = wf1Var.k();
                bVar.c = 0;
                if (bVar.f9821a == 1414744396) {
                    bVar.c = wf1Var.k();
                    b bVar2 = this.b;
                    if (bVar2.c == 1819436136) {
                        this.j = bVar2.b;
                        this.c = 2;
                        return 0;
                    }
                    throw ag1.a("hdrl expected, found: " + this.b.c, (Exception) null);
                }
                throw ag1.a("LIST expected, found: " + bVar.f9821a, (Exception) null);
            case 2:
                int i = this.j - 4;
                wf1 wf1Var2 = new wf1(i);
                ((tz) x70Var).a(wf1Var2.c(), 0, i, false);
                ur0 ur0VarA = ur0.a(1819436136, wf1Var2);
                if (ur0VarA.getType() == 1819436136) {
                    pi piVar = (pi) ur0VarA.a(pi.class);
                    if (piVar != null) {
                        this.e = piVar;
                        this.f = ((long) piVar.c) * ((long) piVar.f9928a);
                        ArrayList arrayList = new ArrayList();
                        c82<ni> c82VarListIterator = ur0VarA.f10414a.listIterator(0);
                        int i2 = 0;
                        while (c82VarListIterator.hasNext()) {
                            ni next = c82VarListIterator.next();
                            if (next.getType() == 1819440243) {
                                ur0 ur0Var = (ur0) next;
                                int i3 = i2 + 1;
                                qi qiVar = (qi) ur0Var.a(qi.class);
                                o22 o22Var = (o22) ur0Var.a(o22.class);
                                if (qiVar == null) {
                                    at0.d("AviExtractor", "Missing Stream Header");
                                } else if (o22Var == null) {
                                    at0.d("AviExtractor", "Missing Stream Format");
                                } else {
                                    long jA2 = x82.a(qiVar.d, 1000000 * ((long) qiVar.b), qiVar.c);
                                    gc0 gc0Var = o22Var.f9774a;
                                    gc0.a aVarA = gc0Var.a();
                                    aVarA.g(i2);
                                    int i4 = qiVar.e;
                                    if (i4 != 0) {
                                        aVarA.h(i4);
                                    }
                                    q22 q22Var = (q22) ur0Var.a(q22.class);
                                    if (q22Var != null) {
                                        aVarA.c(q22Var.f9976a);
                                    }
                                    int iC = s01.c(gc0Var.m);
                                    if (iC == 1 || iC == 2) {
                                        t52 t52VarA = this.d.a(i2, iC);
                                        t52VarA.a(aVarA.a());
                                        moVar = new mo(i2, iC, jA2, qiVar.d, t52VarA);
                                        this.f = jA2;
                                    }
                                    if (moVar != null) {
                                        arrayList.add(moVar);
                                    }
                                    i2 = i3;
                                }
                                moVar = null;
                                if (moVar != null) {
                                    arrayList.add(moVar);
                                }
                                i2 = i3;
                            }
                        }
                        this.g = (mo[]) arrayList.toArray(new mo[0]);
                        this.d.a();
                        this.c = 3;
                        return 0;
                    }
                    throw ag1.a("AviHeader not found", (Exception) null);
                }
                throw ag1.a("Unexpected header list type " + ur0VarA.getType(), (Exception) null);
            case 3:
                if (this.k != -1) {
                    long jA3 = ((tz) x70Var).a();
                    long j3 = this.k;
                    if (jA3 != j3) {
                        this.h = j3;
                        return 0;
                    }
                }
                tz tzVar2 = (tz) x70Var;
                tzVar2.b(this.f9819a.c(), 0, 12, false);
                tzVar2.c();
                this.f9819a.e(0);
                b bVar3 = this.b;
                wf1 wf1Var3 = this.f9819a;
                bVar3.getClass();
                bVar3.f9821a = wf1Var3.k();
                bVar3.b = wf1Var3.k();
                bVar3.c = 0;
                int iK = this.f9819a.k();
                int i5 = this.b.f9821a;
                if (i5 == 1179011410) {
                    tzVar2.a(12);
                    return 0;
                }
                if (i5 == 1414744396 && iK == 1769369453) {
                    long jA4 = tzVar2.a();
                    this.k = jA4;
                    this.l = jA4 + ((long) this.b.b) + 8;
                    if (!this.n) {
                        pi piVar2 = this.e;
                        piVar2.getClass();
                        if ((piVar2.b & 16) == 16) {
                            this.c = 4;
                            this.h = this.l;
                            return 0;
                        }
                        this.d.a(new xw1.b(this.f, 0L));
                        this.n = true;
                    }
                    this.h = tzVar2.a() + 12;
                    this.c = 6;
                    return 0;
                }
                this.h = tzVar2.a() + ((long) this.b.b) + 8;
                return 0;
            case 4:
                tz tzVar3 = (tz) x70Var;
                tzVar3.a(this.f9819a.c(), 0, 8, false);
                this.f9819a.e(0);
                int iK2 = this.f9819a.k();
                int iK3 = this.f9819a.k();
                if (iK2 == 829973609) {
                    this.c = 5;
                    this.m = iK3;
                } else {
                    this.h = tzVar3.a() + ((long) iK3);
                }
                return 0;
            case 5:
                wf1 wf1Var4 = new wf1(this.m);
                ((tz) x70Var).a(wf1Var4.c(), 0, this.m, false);
                if (wf1Var4.a() < 16) {
                    j = 0;
                } else {
                    int iD = wf1Var4.d();
                    wf1Var4.f(8);
                    long jK = wf1Var4.k();
                    long j4 = this.k;
                    j = jK > j4 ? 0L : j4 + 8;
                    wf1Var4.e(iD);
                }
                while (wf1Var4.a() >= 16) {
                    int iK4 = wf1Var4.k();
                    int iK5 = wf1Var4.k();
                    long jK2 = ((long) wf1Var4.k()) + j;
                    wf1Var4.k();
                    mo[] moVarArr = this.g;
                    int length = moVarArr.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 < length) {
                            moVar2 = moVarArr[i6];
                            if (!moVar2.a(iK4)) {
                                i6++;
                            }
                        } else {
                            moVar2 = null;
                        }
                    }
                    if (moVar2 != null) {
                        if ((iK5 & 16) == 16) {
                            moVar2.a(jK2);
                        }
                        moVar2.b();
                    }
                }
                for (mo moVar4 : this.g) {
                    moVar4.a();
                }
                this.n = true;
                this.d.a(new a(this.f));
                this.c = 6;
                this.h = this.k;
                return 0;
            case 6:
                tz tzVar4 = (tz) x70Var;
                if (tzVar4.a() >= this.l) {
                    return -1;
                }
                mo moVar5 = this.i;
                if (moVar5 != null) {
                    if (!moVar5.a(tzVar4)) {
                        return 0;
                    }
                    this.i = null;
                    return 0;
                }
                if ((tzVar4.a() & 1) == 1) {
                    tzVar4.a(1);
                }
                tzVar4.b(this.f9819a.c(), 0, 12, false);
                this.f9819a.e(0);
                int iK6 = this.f9819a.k();
                if (iK6 == 1414744396) {
                    this.f9819a.e(8);
                    tzVar4.a(this.f9819a.k() == 1769369453 ? 12 : 8);
                    tzVar4.c();
                    return 0;
                }
                int iK7 = this.f9819a.k();
                if (iK6 == 1263424842) {
                    this.h = tzVar4.a() + ((long) iK7) + 8;
                    return 0;
                }
                tzVar4.a(8);
                tzVar4.c();
                for (mo moVar6 : this.g) {
                    if (moVar6.a(iK6)) {
                        moVar3 = moVar6;
                        if (moVar3 == null) {
                            this.h = tzVar4.a() + ((long) iK7);
                            return 0;
                        }
                        moVar3.b(iK7);
                        this.i = moVar3;
                        return 0;
                    }
                }
                if (moVar3 == null) {
                    this.h = tzVar4.a() + ((long) iK7);
                    return 0;
                }
                moVar3.b(iK7);
                this.i = moVar3;
                return 0;
            default:
                throw new AssertionError();
        }
    }

    private class a implements xw1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9820a;

        @Override // com.yandex.mobile.ads.impl.xw1
        public final boolean b() {
            return true;
        }

        public a(long j) {
            this.f9820a = j;
        }

        @Override // com.yandex.mobile.ads.impl.xw1
        public final long c() {
            return this.f9820a;
        }

        @Override // com.yandex.mobile.ads.impl.xw1
        public final xw1.a b(long j) {
            xw1.a aVarB = oi.this.g[0].b(j);
            int i = 1;
            while (true) {
                mo[] moVarArr = oi.this.g;
                if (i >= moVarArr.length) {
                    return aVarB;
                }
                xw1.a aVarB2 = moVarArr[i].b(j);
                if (aVarB2.f10682a.b < aVarB.f10682a.b) {
                    aVarB = aVarB2;
                }
                i++;
            }
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9821a;
        public int b;
        public int c;

        private b() {
        }
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        this.h = -1L;
        this.i = null;
        for (mo moVar : this.g) {
            moVar.c(j);
        }
        if (j == 0) {
            if (this.g.length == 0) {
                this.c = 0;
                return;
            } else {
                this.c = 3;
                return;
            }
        }
        this.c = 6;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        ((tz) x70Var).b(this.f9819a.c(), 0, 12, false);
        this.f9819a.e(0);
        if (this.f9819a.k() != 1179011410) {
            return false;
        }
        this.f9819a.f(4);
        return this.f9819a.k() == 541677121;
    }
}
