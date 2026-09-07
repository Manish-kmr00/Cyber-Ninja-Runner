package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f2084a;
    public final boolean b;
    public final boolean c;
    public long g;
    public String i;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r j;
    public l k;
    public boolean l;
    public long m;
    public final boolean[] h = new boolean[3];
    public final r d = new r(7);
    public final r e = new r(8);
    public final r f = new r(6);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n n = new com.fyber.inneractive.sdk.player.exoplayer2.util.n();

    public m(x xVar, boolean z, boolean z2) {
        this.f2084a = xVar;
        this.b = z;
        this.c = z2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(this.h);
        r rVar = this.d;
        rVar.b = false;
        rVar.c = false;
        r rVar2 = this.e;
        rVar2.b = false;
        rVar2.c = false;
        r rVar3 = this.f;
        rVar3.b = false;
        rVar3.c = false;
        l lVar = this.k;
        lVar.k = false;
        lVar.o = false;
        k kVar = lVar.n;
        kVar.b = false;
        kVar.f2082a = false;
        this.g = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, E e) {
        e.a();
        e.b();
        this.i = e.e;
        e.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(e.d, 2);
        this.j = gVarA;
        this.k = new l(gVarA, this.b, this.c);
        this.f2084a.a(jVar, e);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        this.m = j;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0293  */
    /* JADX WARN: Code duplicated, block: B:129:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:29:0x007e  */
    /* JADX WARN: Code duplicated, block: B:94:0x024d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0251  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int i;
        byte[] bArr;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        boolean z3;
        int i11 = nVar.b;
        int i12 = nVar.c;
        byte[] bArr2 = nVar.f2184a;
        int i13 = i12 - i11;
        this.g += (long) i13;
        this.j.a(i13, nVar);
        while (true) {
            int iA = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(bArr2, i11, i12, this.h);
            if (iA == i12) {
                break;
            }
            int i14 = iA + 3;
            int i15 = bArr2[i14] & Ascii.US;
            int i16 = iA - i11;
            if (i16 > 0) {
                if (!this.l || this.k.c) {
                    this.d.a(bArr2, i11, iA);
                    this.e.a(bArr2, i11, iA);
                }
                this.f.a(bArr2, i11, iA);
                this.k.a(bArr2, i11, iA);
            }
            int i17 = i12 - iA;
            long j = this.g - ((long) i17);
            int i18 = i16 < 0 ? -i16 : 0;
            long j2 = this.m;
            if (!this.l || this.k.c) {
                this.d.a(i18);
                this.e.a(i18);
                if (!this.l) {
                    if (this.d.c && this.e.c) {
                        ArrayList arrayList = new ArrayList();
                        r rVar = this.d;
                        arrayList.add(Arrays.copyOf(rVar.d, rVar.e));
                        r rVar2 = this.e;
                        arrayList.add(Arrays.copyOf(rVar2.d, rVar2.e));
                        r rVar3 = this.d;
                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVarA = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar3.d, 3, rVar3.e);
                        r rVar4 = this.e;
                        i = i12;
                        com.fyber.inneractive.sdk.player.exoplayer2.util.o oVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.o(rVar4.d, 3, rVar4.e);
                        oVar.d(8);
                        int iD = oVar.d();
                        int iD2 = oVar.d();
                        oVar.f();
                        com.fyber.inneractive.sdk.player.exoplayer2.util.j jVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.j(oVar.c(), iD, iD2);
                        bArr = bArr2;
                        i2 = i14;
                        i3 = i15;
                        this.j.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(this.i, "video/avc", -1, kVarA.b, kVarA.c, arrayList, -1, kVarA.d, null, -1, null, null));
                        this.l = true;
                        this.k.d.append(kVarA.f2181a, kVarA);
                        this.k.e.append(iD, jVar);
                        r rVar5 = this.d;
                        rVar5.b = false;
                        rVar5.c = false;
                        r rVar6 = this.e;
                        rVar6.b = false;
                        rVar6.c = false;
                    } else {
                        i = i12;
                        bArr = bArr2;
                        i2 = i14;
                        i3 = i15;
                    }
                } else {
                    i = i12;
                    bArr = bArr2;
                    i2 = i14;
                    i3 = i15;
                    r rVar7 = this.d;
                    if (rVar7.c) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVarA2 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar7.d, 3, rVar7.e);
                        this.k.d.append(kVarA2.f2181a, kVarA2);
                        r rVar8 = this.d;
                        rVar8.b = false;
                        rVar8.c = false;
                    } else {
                        r rVar9 = this.e;
                        if (rVar9.c) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.o oVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.util.o(rVar9.d, 3, rVar9.e);
                            oVar2.d(8);
                            int iD3 = oVar2.d();
                            int iD4 = oVar2.d();
                            oVar2.f();
                            this.k.e.append(iD3, new com.fyber.inneractive.sdk.player.exoplayer2.util.j(oVar2.c(), iD3, iD4));
                            r rVar10 = this.e;
                            rVar10.b = false;
                            rVar10.c = false;
                        }
                    }
                }
            } else {
                i = i12;
                bArr = bArr2;
                i2 = i14;
                i3 = i15;
            }
            if (this.f.a(i18)) {
                r rVar11 = this.f;
                int iA2 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar11.e, rVar11.d);
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.n;
                nVar2.f2184a = this.f.d;
                nVar2.c = iA2;
                nVar2.b = 0;
                nVar2.e(4);
                com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j2, this.n, this.f2084a.b);
            }
            l lVar = this.k;
            if (lVar.i != 9) {
                if (lVar.c) {
                    k kVar = lVar.n;
                    k kVar2 = lVar.m;
                    if (kVar.f2082a && (!kVar2.f2082a || kVar.f != kVar2.f || kVar.g != kVar2.g || kVar.h != kVar2.h || ((kVar.i && kVar2.i && kVar.j != kVar2.j) || (((i8 = kVar.d) != (i9 = kVar2.d) && (i8 == 0 || i9 == 0)) || (((i10 = kVar.c.h) == 0 && kVar2.c.h == 0 && (kVar.m != kVar2.m || kVar.n != kVar2.n)) || ((i10 == 1 && kVar2.c.h == 1 && (kVar.o != kVar2.o || kVar.p != kVar2.p)) || (z2 = kVar.k) != (z3 = kVar2.k) || (z2 && z3 && kVar.l != kVar2.l))))))) {
                        if (lVar.o) {
                            long j3 = lVar.j;
                            lVar.f2083a.a(lVar.q, lVar.r ? 1 : 0, (int) (j3 - lVar.p), i17 + ((int) (j - j3)), null);
                        }
                        lVar.p = lVar.j;
                        lVar.q = lVar.l;
                        lVar.r = false;
                        i4 = 1;
                        lVar.o = true;
                    }
                }
                i4 = 1;
            } else {
                if (lVar.o) {
                    long j4 = lVar.j;
                    lVar.f2083a.a(lVar.q, lVar.r ? 1 : 0, (int) (j4 - lVar.p), i17 + ((int) (j - j4)), null);
                }
                lVar.p = lVar.j;
                lVar.q = lVar.l;
                lVar.r = false;
                i4 = 1;
                lVar.o = true;
            }
            boolean z4 = lVar.r;
            int i19 = lVar.i;
            if (i19 == 5) {
                z = true;
            } else {
                if (lVar.b && i19 == i4) {
                    k kVar3 = lVar.n;
                    if (kVar3.b && ((i7 = kVar3.e) == 7 || i7 == 2)) {
                        z = true;
                    }
                }
                z = false;
            }
            lVar.r = z | z4;
            long j5 = this.m;
            if (!this.l || this.k.c) {
                i5 = i3;
                this.d.b(i5);
                this.e.b(i5);
            } else {
                i5 = i3;
            }
            this.f.b(i5);
            l lVar2 = this.k;
            lVar2.i = i5;
            lVar2.l = j5;
            lVar2.j = j;
            if (lVar2.b) {
                i6 = 1;
                if (i5 == 1) {
                    k kVar4 = lVar2.m;
                    lVar2.m = lVar2.n;
                    lVar2.n = kVar4;
                    kVar4.b = false;
                    kVar4.f2082a = false;
                    lVar2.h = 0;
                    lVar2.k = true;
                }
                i12 = i;
                bArr2 = bArr;
                i11 = i2;
            } else {
                i6 = 1;
            }
            if (lVar2.c && (i5 == 5 || i5 == i6 || i5 == 2)) {
                k kVar5 = lVar2.m;
                lVar2.m = lVar2.n;
                lVar2.n = kVar5;
                kVar5.b = false;
                kVar5.f2082a = false;
                lVar2.h = 0;
                lVar2.k = true;
            }
            i12 = i;
            bArr2 = bArr;
            i11 = i2;
        }
        if (!this.l || this.k.c) {
            this.d.a(bArr2, i11, i12);
            this.e.a(bArr2, i11, i12);
        }
        this.f.a(bArr2, i11, i12);
        this.k.a(bArr2, i11, i12);
    }
}
