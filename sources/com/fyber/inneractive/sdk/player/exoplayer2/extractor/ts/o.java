package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;
import java.util.Collections;

/* JADX INFO: loaded from: classes8.dex */
public final class o implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f2086a;
    public String b;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r c;
    public n d;
    public boolean e;
    public long l;
    public long m;
    public final boolean[] f = new boolean[3];
    public final r g = new r(32);
    public final r h = new r(33);
    public final r i = new r(34);
    public final r j = new r(39);
    public final r k = new r(40);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n n = new com.fyber.inneractive.sdk.player.exoplayer2.util.n();

    public o(x xVar) {
        this.f2086a = xVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(this.f);
        r rVar = this.g;
        rVar.b = false;
        rVar.c = false;
        r rVar2 = this.h;
        rVar2.b = false;
        rVar2.c = false;
        r rVar3 = this.i;
        rVar3.b = false;
        rVar3.c = false;
        r rVar4 = this.j;
        rVar4.b = false;
        rVar4.c = false;
        r rVar5 = this.k;
        rVar5.b = false;
        rVar5.c = false;
        n nVar = this.d;
        nVar.f = false;
        nVar.g = false;
        nVar.h = false;
        nVar.i = false;
        nVar.j = false;
        this.l = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, E e) {
        e.a();
        e.b();
        this.b = e.e;
        e.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(e.d, 2);
        this.c = gVarA;
        this.d = new n(gVarA);
        this.f2086a.a(jVar, e);
    }

    /* JADX WARN: Code duplicated, block: B:151:0x030d  */
    /* JADX WARN: Code duplicated, block: B:154:0x0339  */
    /* JADX WARN: Code duplicated, block: B:157:0x0363  */
    /* JADX WARN: Code duplicated, block: B:159:0x0376  */
    /* JADX WARN: Code duplicated, block: B:161:0x037a  */
    /* JADX WARN: Code duplicated, block: B:164:0x0394  */
    /* JADX WARN: Code duplicated, block: B:167:0x039a  */
    /* JADX WARN: Code duplicated, block: B:168:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:171:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:174:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:177:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:181:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:183:0x03be  */
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
        int i2;
        float f;
        float f2;
        long j;
        int i3;
        n nVar2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        while (true) {
            int i4 = nVar.c;
            int i5 = nVar.b;
            int i6 = i4 - i5;
            if (i6 <= 0) {
                return;
            }
            byte[] bArr = nVar.f2184a;
            this.l += (long) i6;
            this.c.a(i6, nVar);
            while (i5 < i4) {
                int iA = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(bArr, i5, i4, this.f);
                if (iA == i4) {
                    a(bArr, i5, i4);
                    return;
                }
                int i7 = iA + 3;
                int i8 = (bArr[i7] & 126) >> 1;
                int i9 = iA - i5;
                if (i9 > 0) {
                    a(bArr, i5, iA);
                }
                int i10 = i4 - iA;
                long j2 = this.l - ((long) i10);
                int i11 = i9 < 0 ? -i9 : 0;
                long j3 = this.m;
                if (this.e) {
                    n nVar3 = this.d;
                    if (nVar3.j && nVar3.g) {
                        nVar3.m = nVar3.c;
                        nVar3.j = false;
                    } else {
                        if (nVar3.h || nVar3.g) {
                            if (nVar3.i) {
                                long j4 = nVar3.b;
                                nVar3.f2085a.a(nVar3.l, nVar3.m ? 1 : 0, (int) (j4 - nVar3.k), i10 + ((int) (j2 - j4)), null);
                            }
                            nVar3.k = nVar3.b;
                            nVar3.l = nVar3.e;
                            nVar3.i = true;
                            nVar3.m = nVar3.c;
                        }
                        i2 = 16;
                        if (this.j.a(i11)) {
                            r rVar = this.j;
                            int iA2 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar.e, rVar.d);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar4 = this.n;
                            nVar4.f2184a = this.j.d;
                            nVar4.c = iA2;
                            nVar4.b = 0;
                            nVar4.e(5);
                            com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.f2086a.b);
                        }
                        if (this.k.a(i11)) {
                            r rVar2 = this.k;
                            int iA3 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar2.e, rVar2.d);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar5 = this.n;
                            nVar5.f2184a = this.k.d;
                            nVar5.c = iA3;
                            nVar5.b = 0;
                            nVar5.e(5);
                            com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.f2086a.b);
                        }
                        j = this.m;
                        if (this.e) {
                            nVar2 = this.d;
                            nVar2.g = false;
                            nVar2.h = false;
                            nVar2.e = j;
                            nVar2.d = 0;
                            nVar2.b = j2;
                            i3 = i8;
                            if (i3 >= 32) {
                                if (nVar2.j && nVar2.i) {
                                    boolean z5 = nVar2.m;
                                    int i12 = (int) (j2 - nVar2.k);
                                    z = false;
                                    nVar2.f2085a.a(nVar2.l, z5 ? 1 : 0, i12, i, null);
                                    nVar2.i = false;
                                } else {
                                    z = false;
                                }
                                if (i3 <= 34) {
                                    z2 = true;
                                    nVar2.h = !nVar2.j;
                                    nVar2.j = true;
                                }
                                if (i3 >= i2 || i3 > 21) {
                                    z3 = z;
                                } else {
                                    z3 = z2;
                                }
                                nVar2.c = z3;
                                if (!z3 || i3 <= 9) {
                                    z4 = z2;
                                } else {
                                    z4 = z;
                                }
                                nVar2.f = z4;
                            } else {
                                i2 = i2;
                                z = false;
                            }
                            z2 = true;
                            if (i3 >= i2) {
                                z3 = z;
                            } else {
                                z3 = z;
                            }
                            nVar2.c = z3;
                            if (z3) {
                                z4 = z2;
                            } else {
                                z4 = z2;
                            }
                            nVar2.f = z4;
                        } else {
                            i3 = i8;
                            this.g.b(i3);
                            this.h.b(i3);
                            this.i.b(i3);
                        }
                        this.j.b(i3);
                        this.k.b(i3);
                        i4 = i4;
                        bArr = bArr;
                        i5 = i7;
                    }
                    i4 = i4;
                    i11 = i11;
                    i = i10;
                    i2 = 16;
                    if (this.j.a(i11)) {
                        r rVar3 = this.j;
                        int iA4 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar3.e, rVar3.d);
                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar6 = this.n;
                        nVar6.f2184a = this.j.d;
                        nVar6.c = iA4;
                        nVar6.b = 0;
                        nVar6.e(5);
                        com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.f2086a.b);
                    }
                    if (this.k.a(i11)) {
                        r rVar4 = this.k;
                        int iA5 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar4.e, rVar4.d);
                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar7 = this.n;
                        nVar7.f2184a = this.k.d;
                        nVar7.c = iA5;
                        nVar7.b = 0;
                        nVar7.e(5);
                        com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.f2086a.b);
                    }
                    j = this.m;
                    if (this.e) {
                        nVar2 = this.d;
                        nVar2.g = false;
                        nVar2.h = false;
                        nVar2.e = j;
                        nVar2.d = 0;
                        nVar2.b = j2;
                        i3 = i8;
                        if (i3 >= 32) {
                            if (nVar2.j) {
                                z = false;
                            } else {
                                z = false;
                            }
                            if (i3 <= 34) {
                                z2 = true;
                                nVar2.h = !nVar2.j;
                                nVar2.j = true;
                            }
                            if (i3 >= i2) {
                                z3 = z;
                            } else {
                                z3 = z;
                            }
                            nVar2.c = z3;
                            if (z3) {
                                z4 = z2;
                            } else {
                                z4 = z2;
                            }
                            nVar2.f = z4;
                        } else {
                            i2 = i2;
                            z = false;
                        }
                        z2 = true;
                        if (i3 >= i2) {
                            z3 = z;
                        } else {
                            z3 = z;
                        }
                        nVar2.c = z3;
                        if (z3) {
                            z4 = z2;
                        } else {
                            z4 = z2;
                        }
                        nVar2.f = z4;
                    } else {
                        i3 = i8;
                        this.g.b(i3);
                        this.h.b(i3);
                        this.i.b(i3);
                    }
                    this.j.b(i3);
                    this.k.b(i3);
                    i4 = i4;
                    bArr = bArr;
                    i5 = i7;
                } else {
                    i4 = i4;
                    i11 = i11;
                    i10 = i10;
                    this.g.a(i11);
                    this.h.a(i11);
                    this.i.a(i11);
                    r rVar5 = this.g;
                    if (rVar5.c) {
                        r rVar6 = this.h;
                        if (rVar6.c) {
                            r rVar7 = this.i;
                            if (rVar7.c) {
                                com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar8 = this.c;
                                String str = this.b;
                                int i13 = rVar5.e;
                                bArr = bArr;
                                i7 = i7;
                                byte[] bArr2 = new byte[rVar6.e + i13 + rVar7.e];
                                i = i10;
                                System.arraycopy(rVar5.d, 0, bArr2, 0, i13);
                                i8 = i8;
                                System.arraycopy(rVar6.d, 0, bArr2, rVar5.e, rVar6.e);
                                System.arraycopy(rVar7.d, 0, bArr2, rVar5.e + rVar6.e, rVar7.e);
                                com.fyber.inneractive.sdk.player.exoplayer2.util.o oVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.o(rVar6.d, 0, rVar6.e);
                                oVar.d(44);
                                int i14 = 3;
                                int iB = oVar.b(3);
                                oVar.f();
                                oVar.d(88);
                                oVar.d(8);
                                int i15 = 0;
                                for (int i16 = 0; i16 < iB; i16++) {
                                    if (oVar.c()) {
                                        i15 += 89;
                                    }
                                    if (oVar.c()) {
                                        i15 += 8;
                                    }
                                }
                                oVar.d(i15);
                                int i17 = 2;
                                if (iB > 0) {
                                    oVar.d((8 - iB) * 2);
                                }
                                oVar.d();
                                int iD = oVar.d();
                                if (iD == 3) {
                                    oVar.f();
                                }
                                int iD2 = oVar.d();
                                int iD3 = oVar.d();
                                if (oVar.c()) {
                                    int iD4 = oVar.d();
                                    int iD5 = oVar.d();
                                    int iD6 = oVar.d();
                                    int iD7 = oVar.d();
                                    iD2 -= (iD4 + iD5) * ((iD == 1 || iD == 2) ? 2 : 1);
                                    iD3 -= (iD6 + iD7) * (iD == 1 ? 2 : 1);
                                }
                                int i18 = iD2;
                                int i19 = iD3;
                                oVar.d();
                                oVar.d();
                                int iD8 = oVar.d();
                                for (int i20 = oVar.c() ? 0 : iB; i20 <= iB; i20++) {
                                    oVar.d();
                                    oVar.d();
                                    oVar.d();
                                }
                                oVar.d();
                                oVar.d();
                                oVar.d();
                                oVar.d();
                                oVar.d();
                                oVar.d();
                                if (oVar.c() && oVar.c()) {
                                    int i21 = 0;
                                    while (true) {
                                        int i22 = 4;
                                        if (i21 >= 4) {
                                            break;
                                        }
                                        int i23 = 0;
                                        while (i23 < 6) {
                                            if (!oVar.c()) {
                                                oVar.d();
                                            } else {
                                                int iMin = Math.min(64, 1 << ((i21 << 1) + i22));
                                                if (i21 > 1) {
                                                    oVar.e();
                                                }
                                                for (int i24 = 0; i24 < iMin; i24++) {
                                                    oVar.e();
                                                }
                                                i14 = 3;
                                            }
                                            i23 += i21 == i14 ? i14 : 1;
                                            i22 = 4;
                                        }
                                        i21++;
                                        i17 = 2;
                                    }
                                }
                                oVar.d(i17);
                                if (oVar.c()) {
                                    oVar.d(8);
                                    oVar.d();
                                    oVar.d();
                                    oVar.f();
                                }
                                int i25 = 0;
                                boolean zC = false;
                                int i26 = 0;
                                for (int iD9 = oVar.d(); i25 < iD9; iD9 = iD9) {
                                    if (i25 != 0) {
                                        zC = oVar.c();
                                    }
                                    if (zC) {
                                        oVar.f();
                                        oVar.d();
                                        for (int i27 = 0; i27 <= i26; i27++) {
                                            if (oVar.c()) {
                                                oVar.f();
                                            }
                                        }
                                    } else {
                                        int iD10 = oVar.d();
                                        int iD11 = oVar.d();
                                        int i28 = iD10 + iD11;
                                        for (int i29 = 0; i29 < iD10; i29++) {
                                            oVar.d();
                                            oVar.f();
                                        }
                                        for (int i30 = 0; i30 < iD11; i30++) {
                                            oVar.d();
                                            oVar.f();
                                        }
                                        i26 = i28;
                                    }
                                    i25++;
                                }
                                if (oVar.c()) {
                                    for (int i31 = 0; i31 < oVar.d(); i31++) {
                                        oVar.d(iD8 + 5);
                                    }
                                }
                                oVar.d(2);
                                if (oVar.c() && oVar.c()) {
                                    int iB2 = oVar.b(8);
                                    if (iB2 == 255) {
                                        i2 = 16;
                                        int iB3 = oVar.b(16);
                                        int iB4 = oVar.b(16);
                                        if (iB3 != 0 && iB4 != 0) {
                                            f2 = iB3 / iB4;
                                        }
                                        rVar8.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(str, "video/hevc", -1, i18, i19, Collections.singletonList(bArr2), -1, f2, null, -1, null, null));
                                        this.e = true;
                                    } else {
                                        i2 = 16;
                                        float[] fArr = com.fyber.inneractive.sdk.player.exoplayer2.util.l.b;
                                        if (iB2 < 17) {
                                            f = fArr[iB2];
                                        } else {
                                            Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + iB2);
                                        }
                                        f2 = f;
                                        rVar8.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(str, "video/hevc", -1, i18, i19, Collections.singletonList(bArr2), -1, f2, null, -1, null, null));
                                        this.e = true;
                                    }
                                } else {
                                    i2 = 16;
                                }
                                f = 1.0f;
                                f2 = f;
                                rVar8.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(str, "video/hevc", -1, i18, i19, Collections.singletonList(bArr2), -1, f2, null, -1, null, null));
                                this.e = true;
                            }
                            if (this.j.a(i11)) {
                                r rVar9 = this.j;
                                int iA6 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar9.e, rVar9.d);
                                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar8 = this.n;
                                nVar8.f2184a = this.j.d;
                                nVar8.c = iA6;
                                nVar8.b = 0;
                                nVar8.e(5);
                                com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.f2086a.b);
                            }
                            if (this.k.a(i11)) {
                                r rVar10 = this.k;
                                int iA7 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar10.e, rVar10.d);
                                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar9 = this.n;
                                nVar9.f2184a = this.k.d;
                                nVar9.c = iA7;
                                nVar9.b = 0;
                                nVar9.e(5);
                                com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.f2086a.b);
                            }
                            j = this.m;
                            if (this.e) {
                                nVar2 = this.d;
                                nVar2.g = false;
                                nVar2.h = false;
                                nVar2.e = j;
                                nVar2.d = 0;
                                nVar2.b = j2;
                                i3 = i8;
                                if (i3 >= 32) {
                                    if (nVar2.j) {
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                    if (i3 <= 34) {
                                        z2 = true;
                                        nVar2.h = !nVar2.j;
                                        nVar2.j = true;
                                    }
                                    if (i3 >= i2) {
                                        z3 = z;
                                    } else {
                                        z3 = z;
                                    }
                                    nVar2.c = z3;
                                    if (z3) {
                                        z4 = z2;
                                    } else {
                                        z4 = z2;
                                    }
                                    nVar2.f = z4;
                                } else {
                                    i2 = i2;
                                    z = false;
                                }
                                z2 = true;
                                if (i3 >= i2) {
                                    z3 = z;
                                } else {
                                    z3 = z;
                                }
                                nVar2.c = z3;
                                if (z3) {
                                    z4 = z2;
                                } else {
                                    z4 = z2;
                                }
                                nVar2.f = z4;
                            } else {
                                i3 = i8;
                                this.g.b(i3);
                                this.h.b(i3);
                                this.i.b(i3);
                            }
                            this.j.b(i3);
                            this.k.b(i3);
                            i4 = i4;
                            bArr = bArr;
                            i5 = i7;
                        }
                    }
                }
                i = i10;
                i2 = 16;
                if (this.j.a(i11)) {
                    r rVar11 = this.j;
                    int iA8 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar11.e, rVar11.d);
                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar10 = this.n;
                    nVar10.f2184a = this.j.d;
                    nVar10.c = iA8;
                    nVar10.b = 0;
                    nVar10.e(5);
                    com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.f2086a.b);
                }
                if (this.k.a(i11)) {
                    r rVar12 = this.k;
                    int iA9 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar12.e, rVar12.d);
                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar11 = this.n;
                    nVar11.f2184a = this.k.d;
                    nVar11.c = iA9;
                    nVar11.b = 0;
                    nVar11.e(5);
                    com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.f2086a.b);
                }
                j = this.m;
                if (this.e) {
                    nVar2 = this.d;
                    nVar2.g = false;
                    nVar2.h = false;
                    nVar2.e = j;
                    nVar2.d = 0;
                    nVar2.b = j2;
                    i3 = i8;
                    if (i3 >= 32) {
                        if (nVar2.j) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (i3 <= 34) {
                            z2 = true;
                            nVar2.h = !nVar2.j;
                            nVar2.j = true;
                        }
                        if (i3 >= i2) {
                            z3 = z;
                        } else {
                            z3 = z;
                        }
                        nVar2.c = z3;
                        if (z3) {
                            z4 = z2;
                        } else {
                            z4 = z2;
                        }
                        nVar2.f = z4;
                    } else {
                        i2 = i2;
                        z = false;
                    }
                    z2 = true;
                    if (i3 >= i2) {
                        z3 = z;
                    } else {
                        z3 = z;
                    }
                    nVar2.c = z3;
                    if (z3) {
                        z4 = z2;
                    } else {
                        z4 = z2;
                    }
                    nVar2.f = z4;
                } else {
                    i3 = i8;
                    this.g.b(i3);
                    this.h.b(i3);
                    this.i.b(i3);
                }
                this.j.b(i3);
                this.k.b(i3);
                i4 = i4;
                bArr = bArr;
                i5 = i7;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        this.m = j;
    }

    public final void a(byte[] bArr, int i, int i2) {
        if (this.e) {
            n nVar = this.d;
            if (nVar.f) {
                int i3 = nVar.d;
                int i4 = (i + 2) - i3;
                if (i4 < i2) {
                    nVar.g = (bArr[i4] & 128) != 0;
                    nVar.f = false;
                } else {
                    nVar.d = (i2 - i) + i3;
                }
            }
        } else {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }
}
