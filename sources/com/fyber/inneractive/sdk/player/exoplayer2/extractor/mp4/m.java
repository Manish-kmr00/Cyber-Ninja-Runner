package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.UUID;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i {
    public static final int A = z.a("seig");
    public static final byte[] B = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.v f;
    public int l;
    public long m;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.n o;
    public long p;
    public int q;
    public l t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.j y;
    public boolean z;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n g = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(16);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(com.fyber.inneractive.sdk.player.exoplayer2.util.l.f2182a);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(5);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n d = new com.fyber.inneractive.sdk.player.exoplayer2.util.n();
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n e = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(1);
    public final byte[] h = new byte[16];
    public final Stack i = new Stack();
    public final LinkedList j = new LinkedList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f2044a = new SparseArray();
    public long r = -9223372036854775807L;
    public long s = -9223372036854775807L;
    public int k = 0;
    public int n = 0;

    public m(com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar) {
        this.f = vVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        return r.a(bVar, true);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        this.y = jVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        int size = this.f2044a.size();
        for (int i = 0; i < size; i++) {
            ((l) this.f2044a.valueAt(i)).a();
        }
        this.j.clear();
        this.q = 0;
        this.i.clear();
        this.k = 0;
        this.n = 0;
    }

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
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) throws InterruptedException, com.fyber.inneractive.sdk.player.exoplayer2.r, EOFException {
        byte[] bArr;
        int i;
        byte[] bArr2;
        int iA;
        int i2;
        long jN;
        long jN2;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar2 = bVar;
        while (true) {
            int i3 = this.k;
            int i4 = 1;
            boolean z = false;
            if (i3 == 0) {
                if (this.n == 0) {
                    if (!bVar2.b(this.g.f2184a, 0, 8, true)) {
                        return -1;
                    }
                    this.n = 8;
                    this.g.e(0);
                    this.m = this.g.k();
                    this.l = this.g.b();
                }
                if (this.m == 1) {
                    bVar2.b(this.g.f2184a, 8, 8, false);
                    this.n += 8;
                    this.m = this.g.n();
                }
                long j = this.m;
                long j2 = this.n;
                if (j >= j2) {
                    long j3 = bVar2.c - j2;
                    if (this.l == c.L) {
                        int size = this.f2044a.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            u uVar = ((l) this.f2044a.valueAt(i5)).f2043a;
                            uVar.getClass();
                            uVar.c = j3;
                            uVar.b = j3;
                        }
                    }
                    int i6 = this.l;
                    if (i6 == c.i) {
                        this.t = null;
                        this.p = j3 + this.m;
                        if (!this.z) {
                            this.y.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.p(this.r));
                            this.z = true;
                        }
                        this.k = 2;
                    } else if (i6 != c.C && i6 != c.E && i6 != c.F && i6 != c.G && i6 != c.H && i6 != c.L && i6 != c.M && i6 != c.N && i6 != c.Q) {
                        if (i6 == c.T || i6 == c.S || i6 == c.D || i6 == c.B || i6 == c.U || i6 == c.x || i6 == c.y || i6 == c.P || i6 == c.z || i6 == c.A || i6 == c.V || i6 == c.d0 || i6 == c.e0 || i6 == c.i0 || i6 == c.h0 || i6 == c.f0 || i6 == c.g0 || i6 == c.R || i6 == c.O || i6 == c.G0) {
                            if (this.n == 8) {
                                long j4 = this.m;
                                if (j4 <= 2147483647L) {
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n((int) j4);
                                    this.o = nVar;
                                    System.arraycopy(this.g.f2184a, 0, nVar.f2184a, 0, 8);
                                    this.k = 1;
                                } else {
                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Leaf atom with length > 2147483647 (unsupported).");
                                }
                            } else {
                                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Leaf atom defines extended atom size (unsupported).");
                            }
                        } else if (this.m <= 2147483647L) {
                            this.o = null;
                            this.k = 1;
                        } else {
                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Skipping atom with length > 2147483647 (unsupported).");
                        }
                    } else {
                        long j5 = (bVar2.c + this.m) - 8;
                        this.i.add(new a(this.l, j5));
                        if (this.m == this.n) {
                            a(j5);
                        } else {
                            this.k = 0;
                            this.n = 0;
                        }
                    }
                } else {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Atom size less than header length (unsupported).");
                }
            } else if (i3 != 1) {
                long j6 = Long.MAX_VALUE;
                if (i3 != 2) {
                    if (i3 == 3) {
                        if (this.t == null) {
                            SparseArray sparseArray = this.f2044a;
                            int size2 = sparseArray.size();
                            l lVar = null;
                            for (int i7 = 0; i7 < size2; i7++) {
                                l lVar2 = (l) sparseArray.valueAt(i7);
                                int i8 = lVar2.g;
                                u uVar2 = lVar2.f2043a;
                                if (i8 != uVar2.d) {
                                    long j7 = uVar2.f[i8];
                                    if (j7 < j6) {
                                        lVar = lVar2;
                                        j6 = j7;
                                    }
                                }
                            }
                            if (lVar == null) {
                                int i9 = (int) (this.p - bVar2.c);
                                if (i9 >= 0) {
                                    bVar2.a(i9);
                                    this.k = 0;
                                    this.n = 0;
                                } else {
                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Offset to end of mdat was negative.");
                                }
                            } else {
                                int i10 = (int) (lVar.f2043a.f[lVar.g] - bVar2.c);
                                if (i10 < 0) {
                                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                    i10 = 0;
                                }
                                bVar2.a(i10);
                                this.t = lVar;
                            }
                        }
                        l lVar3 = this.t;
                        u uVar3 = lVar3.f2043a;
                        int[] iArr = uVar3.h;
                        int i11 = lVar3.e;
                        this.u = iArr[i11];
                        if (uVar3.l) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = uVar3.p;
                            int i12 = uVar3.f2051a.f2041a;
                            t tVar = uVar3.n;
                            if (tVar == null) {
                                tVar = lVar3.c.h[i12];
                            }
                            int i13 = tVar.f2050a;
                            boolean z2 = uVar3.m[i11];
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = this.e;
                            nVar3.f2184a[0] = (byte) ((z2 ? 128 : 0) | i13);
                            nVar3.e(0);
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = lVar3.b;
                            rVar.a(1, this.e);
                            rVar.a(i13, nVar2);
                            if (z2) {
                                int iO = nVar2.o();
                                nVar2.e(nVar2.b - 2);
                                int i14 = (iO * 6) + 2;
                                rVar.a(i14, nVar2);
                                i2 = i13 + 1 + i14;
                            } else {
                                i2 = i13 + 1;
                            }
                            this.v = i2;
                            this.u += i2;
                        } else {
                            this.v = 0;
                        }
                        if (this.t.c.g == 1) {
                            this.u -= 8;
                            bVar2.a(8);
                        }
                        this.k = 4;
                        this.w = 0;
                    }
                    l lVar4 = this.t;
                    u uVar4 = lVar4.f2043a;
                    s sVar = lVar4.c;
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar2 = lVar4.b;
                    int i15 = lVar4.e;
                    int i16 = sVar.k;
                    if (i16 == 0) {
                        while (true) {
                            int i17 = this.v;
                            int i18 = this.u;
                            if (i17 >= i18) {
                                break;
                            }
                            this.v += rVar2.a(bVar2, i18 - i17, false);
                        }
                    } else {
                        byte[] bArr3 = this.c.f2184a;
                        bArr3[0] = 0;
                        bArr3[1] = 0;
                        bArr3[2] = 0;
                        int i19 = i16 + 1;
                        int i20 = 4 - i16;
                        while (this.v < this.u) {
                            int i21 = this.w;
                            if (i21 == 0) {
                                bVar2.b(bArr3, i20, i19, z);
                                this.c.e(z ? 1 : 0);
                                this.w = this.c.m() - i4;
                                this.b.e(z ? 1 : 0);
                                rVar2.a(4, this.b);
                                rVar2.a(i4, this.c);
                                this.x = z;
                                this.v += 5;
                                this.u += i20;
                            } else {
                                if (this.x) {
                                    this.d.c(i21);
                                    bVar2.b(this.d.f2184a, z ? 1 : 0, this.w, z);
                                    rVar2.a(this.w, this.d);
                                    iA = this.w;
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar4 = this.d;
                                    int iA2 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(nVar4.c, nVar4.f2184a);
                                    this.d.e("video/hevc".equals(sVar.f.f) ? 1 : 0);
                                    this.d.d(iA2);
                                    com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a((uVar4.j[i15] + ((long) uVar4.i[i15])) * 1000, this.d, null);
                                } else {
                                    iA = rVar2.a(bVar2, i21, z ? 1 : 0);
                                }
                                this.v += iA;
                                this.w -= iA;
                                i4 = 1;
                                z = false;
                            }
                        }
                    }
                    long j8 = (uVar4.j[i15] + ((long) uVar4.i[i15])) * 1000;
                    boolean z3 = uVar4.l;
                    int i22 = (z3 ? 1073741824 : 0) | (uVar4.k[i15] ? 1 : 0);
                    int i23 = uVar4.f2051a.f2041a;
                    if (z3) {
                        t tVar2 = uVar4.n;
                        if (tVar2 != null) {
                            bArr2 = tVar2.b;
                        } else {
                            bArr2 = sVar.h[i23].b;
                        }
                        bArr = bArr2;
                    } else {
                        bArr = null;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar = this.f;
                    rVar2.a(vVar != null ? vVar.a(j8) : j8, i22, this.u, 0, bArr);
                    if (this.j.isEmpty()) {
                        l lVar5 = this.t;
                        lVar5.e++;
                        int i24 = lVar5.f + 1;
                        lVar5.f = i24;
                        int[] iArr2 = uVar4.g;
                        int i25 = lVar5.g;
                        if (i24 == iArr2[i25]) {
                            lVar5.g = i25 + 1;
                            i = 0;
                            lVar5.f = 0;
                            this.t = null;
                        } else {
                            i = 0;
                        }
                        this.k = 3;
                        return i;
                    }
                    k kVar = (k) this.j.removeFirst();
                    this.q -= kVar.b;
                    long j9 = kVar.f2042a;
                    throw null;
                }
                int size3 = this.f2044a.size();
                l lVar6 = null;
                for (int i26 = 0; i26 < size3; i26++) {
                    u uVar5 = ((l) this.f2044a.valueAt(i26)).f2043a;
                    if (uVar5.q) {
                        long j10 = uVar5.c;
                        if (j10 < j6) {
                            lVar6 = (l) this.f2044a.valueAt(i26);
                            j6 = j10;
                        }
                    }
                }
                if (lVar6 == null) {
                    this.k = 3;
                } else {
                    int i27 = (int) (j6 - bVar2.c);
                    if (i27 >= 0) {
                        bVar2.a(i27);
                        u uVar6 = lVar6.f2043a;
                        bVar2.b(uVar6.p.f2184a, 0, uVar6.o, false);
                        uVar6.p.e(0);
                        uVar6.q = false;
                    } else {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Offset to encryption data was negative.");
                    }
                }
            } else {
                int i28 = ((int) this.m) - this.n;
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar5 = this.o;
                if (nVar5 != null) {
                    bVar2.b(nVar5.f2184a, 8, i28, false);
                    int i29 = this.l;
                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar6 = this.o;
                    b bVar3 = new b(i29, nVar6);
                    long j11 = bVar2.c;
                    if (!this.i.isEmpty()) {
                        ((a) this.i.peek()).Q0.add(bVar3);
                    } else {
                        if (i29 == c.B) {
                            nVar6.e(8);
                            int iB = (nVar6.b() >> 24) & 255;
                            nVar6.e(nVar6.b + 4);
                            long jK = nVar6.k();
                            if (iB == 0) {
                                jN = nVar6.k();
                                jN2 = nVar6.k();
                            } else {
                                jN = nVar6.n();
                                jN2 = nVar6.n();
                            }
                            long j12 = jN2 + j11;
                            long j13 = jN;
                            long j14 = j12;
                            long jA = z.a(j13, 1000000L, jK);
                            nVar6.e(nVar6.b + 2);
                            int iO2 = nVar6.o();
                            int[] iArr3 = new int[iO2];
                            long[] jArr = new long[iO2];
                            long[] jArr2 = new long[iO2];
                            long[] jArr3 = new long[iO2];
                            long j15 = j13;
                            long j16 = jA;
                            int i30 = 0;
                            while (i30 < iO2) {
                                int iB2 = nVar6.b();
                                if ((Integer.MIN_VALUE & iB2) == 0) {
                                    long jK2 = nVar6.k();
                                    iArr3[i30] = iB2 & Integer.MAX_VALUE;
                                    jArr[i30] = j14;
                                    jArr3[i30] = j16;
                                    long j17 = j15 + jK2;
                                    long[] jArr4 = jArr3;
                                    long[] jArr5 = jArr2;
                                    long jA2 = z.a(j17, 1000000L, jK);
                                    jArr5[i30] = jA2 - jArr4[i30];
                                    nVar6.e(nVar6.b + 4);
                                    j14 += (long) iArr3[i30];
                                    i30++;
                                    jArr2 = jArr5;
                                    jArr = jArr;
                                    jArr3 = jArr4;
                                    iO2 = iO2;
                                    j15 = j17;
                                    j16 = jA2;
                                } else {
                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Unhandled indirect reference");
                                }
                            }
                            Pair pairCreate = Pair.create(Long.valueOf(jA), new com.fyber.inneractive.sdk.player.exoplayer2.extractor.a(iArr3, jArr, jArr2, jArr3));
                            this.s = ((Long) pairCreate.first).longValue();
                            this.y.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.q) pairCreate.second);
                            this.z = true;
                        } else {
                            int i31 = c.G0;
                        }
                        bVar2 = bVar;
                    }
                } else {
                    bVar2.a(i28);
                }
                a(bVar2.c);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:141:0x036e  */
    /* JADX WARN: Code duplicated, block: B:142:0x0372  */
    /* JADX WARN: Code duplicated, block: B:144:0x0377 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:145:0x0379  */
    /* JADX WARN: Code duplicated, block: B:146:0x0382  */
    /* JADX WARN: Code duplicated, block: B:148:0x0388  */
    /* JADX WARN: Code duplicated, block: B:149:0x0391  */
    /* JADX WARN: Code duplicated, block: B:153:0x039e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:154:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:155:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:157:0x03af  */
    /* JADX WARN: Code duplicated, block: B:158:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:161:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:162:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:244:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:256:0x0606  */
    public final void a(long j) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        m mVar;
        s sVarA;
        m mVar2;
        a aVar;
        SparseArray sparseArray;
        int i;
        int i2;
        int i3;
        byte[] bArr;
        int i4;
        u uVar;
        byte[] bArr2;
        int i5;
        byte[] bArr3;
        long jA;
        int[] iArr;
        int[] iArr2;
        long[] jArr;
        boolean[] zArr;
        int i6;
        long j2;
        long j3;
        long j4;
        int iM;
        int iM2;
        int iB;
        boolean z;
        loop0: while (true) {
            mVar = this;
            while (true) {
                if (mVar.i.isEmpty() || ((a) mVar.i.peek()).P0 != j) {
                    break loop0;
                }
                a aVar2 = (a) mVar.i.pop();
                int i7 = aVar2.f2035a;
                int i8 = 12;
                int i9 = 8;
                int i10 = 1;
                if (i7 == c.C) {
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVarA = a(aVar2.Q0);
                    a aVarB = aVar2.b(c.N);
                    SparseArray sparseArray2 = new SparseArray();
                    int size = aVarB.Q0.size();
                    long jK = -9223372036854775807L;
                    int i11 = 0;
                    while (i11 < size) {
                        b bVar = (b) aVarB.Q0.get(i11);
                        int i12 = bVar.f2035a;
                        if (i12 == c.z) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = bVar.P0;
                            nVar.e(i8);
                            Pair pairCreate = Pair.create(Integer.valueOf(nVar.b()), new j(nVar.m() - 1, nVar.m(), nVar.m(), nVar.b()));
                            sparseArray2.put(((Integer) pairCreate.first).intValue(), (j) pairCreate.second);
                        } else if (i12 == c.O) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = bVar.P0;
                            nVar2.e(8);
                            jK = ((nVar2.b() >> 24) & 255) == 0 ? nVar2.k() : nVar2.n();
                        }
                        i11++;
                        i8 = 12;
                    }
                    SparseArray sparseArray3 = new SparseArray();
                    int size2 = aVar2.R0.size();
                    for (int i13 = 0; i13 < size2; i13++) {
                        a aVar3 = (a) aVar2.R0.get(i13);
                        if (aVar3.f2035a == c.E && (sVarA = i.a(aVar3, aVar2.c(c.D), jK, dVarA, false)) != null) {
                            sparseArray3.put(sVarA.f2049a, sVarA);
                        }
                    }
                    int size3 = sparseArray3.size();
                    if (mVar.f2044a.size() == 0) {
                        for (int i14 = 0; i14 < size3; i14++) {
                            s sVar = (s) sparseArray3.valueAt(i14);
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = mVar.y.a(i14, sVar.b);
                            l lVar = new l(gVarA);
                            j jVar = (j) sparseArray2.get(sVar.f2049a);
                            lVar.c = sVar;
                            jVar.getClass();
                            lVar.d = jVar;
                            gVarA.a(sVar.f);
                            lVar.a();
                            mVar.f2044a.put(sVar.f2049a, lVar);
                            mVar.r = Math.max(mVar.r, sVar.e);
                        }
                        mVar.y.b();
                    } else {
                        if (mVar.f2044a.size() != size3) {
                            throw new IllegalStateException();
                        }
                        for (int i15 = 0; i15 < size3; i15++) {
                            s sVar2 = (s) sparseArray3.valueAt(i15);
                            l lVar2 = (l) mVar.f2044a.get(sVar2.f2049a);
                            j jVar2 = (j) sparseArray2.get(sVar2.f2049a);
                            lVar2.getClass();
                            lVar2.c = sVar2;
                            jVar2.getClass();
                            lVar2.d = jVar2;
                            lVar2.b.a(sVar2.f);
                            lVar2.a();
                        }
                    }
                } else {
                    if (i7 == c.L) {
                        SparseArray sparseArray4 = mVar.f2044a;
                        byte[] bArr4 = mVar.h;
                        int size4 = aVar2.R0.size();
                        int i16 = 0;
                        while (i16 < size4) {
                            a aVar4 = (a) aVar2.R0.get(i16);
                            if (aVar4.f2035a == c.M) {
                                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = aVar4.c(c.y).P0;
                                nVar3.e(i9);
                                int iB2 = nVar3.b();
                                l lVar3 = (l) sparseArray4.get(nVar3.b());
                                if (lVar3 == null) {
                                    lVar3 = null;
                                } else {
                                    if ((iB2 & 1) != 0) {
                                        long jN = nVar3.n();
                                        u uVar2 = lVar3.f2043a;
                                        uVar2.b = jN;
                                        uVar2.c = jN;
                                    }
                                    j jVar3 = lVar3.d;
                                    lVar3.f2043a.f2051a = new j((iB2 & 2) != 0 ? nVar3.m() - i10 : jVar3.f2041a, (iB2 & 8) != 0 ? nVar3.m() : jVar3.b, (iB2 & 16) != 0 ? nVar3.m() : jVar3.c, (iB2 & 32) != 0 ? nVar3.m() : jVar3.d);
                                }
                                if (lVar3 == null) {
                                    aVar = aVar2;
                                    sparseArray = sparseArray4;
                                    i = size4;
                                    i2 = i16;
                                    i3 = i9;
                                    bArr = bArr4;
                                    i4 = i10;
                                } else {
                                    u uVar3 = lVar3.f2043a;
                                    long jN2 = uVar3.r;
                                    lVar3.a();
                                    int i17 = c.x;
                                    if (aVar4.c(i17) != null) {
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar4 = aVar4.c(i17).P0;
                                        nVar4.e(i9);
                                        jN2 = ((nVar4.b() >> 24) & 255) == i10 ? nVar4.n() : nVar4.k();
                                    }
                                    ArrayList arrayList = aVar4.Q0;
                                    int size5 = arrayList.size();
                                    int i18 = 0;
                                    int i19 = 0;
                                    int i20 = 0;
                                    while (i20 < size5) {
                                        SparseArray sparseArray5 = sparseArray4;
                                        b bVar2 = (b) arrayList.get(i20);
                                        int i21 = size4;
                                        long j5 = jN2;
                                        if (bVar2.f2035a == c.A) {
                                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar5 = bVar2.P0;
                                            nVar5.e(12);
                                            int iM3 = nVar5.m();
                                            if (iM3 > 0) {
                                                i18 += iM3;
                                                i19++;
                                            }
                                        }
                                        i20++;
                                        size4 = i21;
                                        sparseArray4 = sparseArray5;
                                        jN2 = j5;
                                    }
                                    sparseArray = sparseArray4;
                                    i = size4;
                                    long j6 = jN2;
                                    lVar3.g = 0;
                                    lVar3.f = 0;
                                    lVar3.e = 0;
                                    u uVar4 = lVar3.f2043a;
                                    uVar4.d = i19;
                                    uVar4.e = i18;
                                    int[] iArr3 = uVar4.g;
                                    if (iArr3 == null || iArr3.length < i19) {
                                        uVar4.f = new long[i19];
                                        uVar4.g = new int[i19];
                                    }
                                    int[] iArr4 = uVar4.h;
                                    if (iArr4 == null || iArr4.length < i18) {
                                        int i22 = (i18 * Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) / 100;
                                        uVar4.h = new int[i22];
                                        uVar4.i = new int[i22];
                                        uVar4.j = new long[i22];
                                        uVar4.k = new boolean[i22];
                                        uVar4.m = new boolean[i22];
                                    }
                                    int i23 = 0;
                                    int i24 = 0;
                                    int i25 = 0;
                                    while (i23 < size5) {
                                        b bVar3 = (b) arrayList.get(i23);
                                        if (bVar3.f2035a == c.A) {
                                            int i26 = i24 + 1;
                                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar6 = bVar3.P0;
                                            nVar6.e(8);
                                            int iB3 = nVar6.b();
                                            s sVar3 = lVar3.c;
                                            u uVar5 = lVar3.f2043a;
                                            j jVar4 = uVar5.f2051a;
                                            uVar5.g[i24] = nVar6.m();
                                            long[] jArr2 = uVar5.f;
                                            long j7 = uVar5.b;
                                            jArr2[i24] = j7;
                                            if ((iB3 & 1) != 0) {
                                                jArr2[i24] = j7 + ((long) nVar6.b());
                                            }
                                            boolean z2 = (iB3 & 4) != 0;
                                            int iM4 = jVar4.d;
                                            if (z2) {
                                                iM4 = nVar6.m();
                                            }
                                            boolean z3 = (iB3 & 256) != 0;
                                            boolean z4 = (iB3 & 512) != 0;
                                            boolean z5 = (iB3 & 1024) != 0;
                                            boolean z6 = (iB3 & 2048) != 0;
                                            long[] jArr3 = sVar3.i;
                                            int i27 = iM4;
                                            if (jArr3 != null) {
                                                bArr3 = bArr4;
                                                if (jArr3.length == 1 && jArr3[0] == 0) {
                                                    jA = z.a(sVar3.j[0], 1000L, sVar3.c);
                                                }
                                                iArr = uVar5.h;
                                                iArr2 = uVar5.i;
                                                jArr = uVar5.j;
                                                zArr = uVar5.k;
                                                i6 = uVar5.g[i24] + i25;
                                                j2 = jA;
                                                j3 = sVar3.c;
                                                if (i24 > 0) {
                                                    j4 = uVar5.r;
                                                } else {
                                                    j4 = j6;
                                                }
                                                while (i25 < i6) {
                                                    if (z3) {
                                                        iM = nVar6.m();
                                                    } else {
                                                        iM = jVar4.b;
                                                    }
                                                    if (z4) {
                                                        iM2 = nVar6.m();
                                                    } else {
                                                        iM2 = jVar4.c;
                                                    }
                                                    if (i25 != 0 && z2) {
                                                        iB = i27;
                                                    } else if (z5) {
                                                        iB = nVar6.b();
                                                    } else {
                                                        iB = jVar4.d;
                                                    }
                                                    if (z6) {
                                                        iArr2[i25] = (int) (((long) (nVar6.b() * 1000)) / j3);
                                                    } else {
                                                        iArr2[i25] = 0;
                                                    }
                                                    jArr[i25] = z.a(j4, 1000L, j3) - j2;
                                                    iArr[i25] = iM2;
                                                    if (((iB >> 16) & 1) == 0) {
                                                        z = true;
                                                    } else {
                                                        z = false;
                                                    }
                                                    zArr[i25] = z;
                                                    j4 += (long) iM;
                                                    i25++;
                                                    z3 = z3;
                                                    z4 = z4;
                                                    z2 = z2;
                                                    z5 = z5;
                                                    jVar4 = jVar4;
                                                    z6 = z6;
                                                }
                                                uVar5.r = j4;
                                                i25 = i6;
                                                i24 = i26;
                                            } else {
                                                bArr3 = bArr4;
                                            }
                                            jA = 0;
                                            iArr = uVar5.h;
                                            iArr2 = uVar5.i;
                                            jArr = uVar5.j;
                                            zArr = uVar5.k;
                                            i6 = uVar5.g[i24] + i25;
                                            j2 = jA;
                                            j3 = sVar3.c;
                                            if (i24 > 0) {
                                                j4 = uVar5.r;
                                            } else {
                                                j4 = j6;
                                            }
                                            while (i25 < i6) {
                                                if (z3) {
                                                    iM = nVar6.m();
                                                } else {
                                                    iM = jVar4.b;
                                                }
                                                if (z4) {
                                                    iM2 = nVar6.m();
                                                } else {
                                                    iM2 = jVar4.c;
                                                }
                                                if (i25 != 0) {
                                                    if (z5) {
                                                        iB = nVar6.b();
                                                    } else {
                                                        iB = jVar4.d;
                                                    }
                                                } else if (z5) {
                                                    iB = nVar6.b();
                                                } else {
                                                    iB = jVar4.d;
                                                }
                                                if (z6) {
                                                    iArr2[i25] = (int) (((long) (nVar6.b() * 1000)) / j3);
                                                } else {
                                                    iArr2[i25] = 0;
                                                }
                                                jArr[i25] = z.a(j4, 1000L, j3) - j2;
                                                iArr[i25] = iM2;
                                                if (((iB >> 16) & 1) == 0) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                zArr[i25] = z;
                                                j4 += (long) iM;
                                                i25++;
                                                z3 = z3;
                                                z4 = z4;
                                                z2 = z2;
                                                z5 = z5;
                                                jVar4 = jVar4;
                                                z6 = z6;
                                            }
                                            uVar5.r = j4;
                                            i25 = i6;
                                            i24 = i26;
                                        } else {
                                            bArr3 = bArr4;
                                            i16 = i16;
                                            aVar4 = aVar4;
                                            uVar3 = uVar3;
                                        }
                                        i23++;
                                        arrayList = arrayList;
                                        size5 = size5;
                                        aVar2 = aVar2;
                                        i16 = i16;
                                        aVar4 = aVar4;
                                        uVar3 = uVar3;
                                        bArr4 = bArr3;
                                        lVar3 = lVar3;
                                    }
                                    aVar = aVar2;
                                    byte[] bArr5 = bArr4;
                                    i2 = i16;
                                    u uVar6 = uVar3;
                                    l lVar4 = lVar3;
                                    b bVarC = aVar4.c(c.d0);
                                    if (bVarC != null) {
                                        uVar = uVar6;
                                        t tVar = lVar4.c.h[uVar.f2051a.f2041a];
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar7 = bVarC.P0;
                                        int i28 = tVar.f2050a;
                                        nVar7.e(8);
                                        if ((nVar7.b() & 1) == 1) {
                                            nVar7.e(nVar7.b + 8);
                                        }
                                        int iJ = nVar7.j();
                                        int iM5 = nVar7.m();
                                        if (iM5 == uVar.e) {
                                            if (iJ == 0) {
                                                boolean[] zArr2 = uVar.m;
                                                i5 = 0;
                                                for (int i29 = 0; i29 < iM5; i29++) {
                                                    int iJ2 = nVar7.j();
                                                    i5 += iJ2;
                                                    zArr2[i29] = iJ2 > i28;
                                                }
                                            } else {
                                                i5 = iJ * iM5;
                                                Arrays.fill(uVar.m, 0, iM5, iJ > i28);
                                            }
                                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar8 = uVar.p;
                                            if (nVar8 == null || nVar8.c < i5) {
                                                uVar.p = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(i5);
                                            }
                                            uVar.o = i5;
                                            uVar.l = true;
                                            uVar.q = true;
                                        } else {
                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Length mismatch: ", iM5, ", ").append(uVar.e).toString());
                                        }
                                    } else {
                                        uVar = uVar6;
                                    }
                                    b bVarC2 = aVar4.c(c.e0);
                                    if (bVarC2 != null) {
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar9 = bVarC2.P0;
                                        nVar9.e(8);
                                        int iB4 = nVar9.b();
                                        if ((iB4 & 1) == 1) {
                                            nVar9.e(nVar9.b + 8);
                                        }
                                        int iM6 = nVar9.m();
                                        if (iM6 != 1) {
                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r(com.fyber.inneractive.sdk.player.exoplayer2.m.a("Unexpected saio entry count: ", iM6));
                                        }
                                        uVar.c += ((iB4 >> 24) & 255) == 0 ? nVar9.k() : nVar9.n();
                                    }
                                    b bVarC3 = aVar4.c(c.i0);
                                    if (bVarC3 != null) {
                                        a(bVarC3.P0, 0, uVar);
                                    }
                                    b bVarC4 = aVar4.c(c.f0);
                                    b bVarC5 = aVar4.c(c.g0);
                                    if (bVarC4 == null || bVarC5 == null) {
                                        i4 = 1;
                                    } else {
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar10 = bVarC4.P0;
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar11 = bVarC5.P0;
                                        nVar10.e(8);
                                        int iB5 = nVar10.b();
                                        int iB6 = nVar10.b();
                                        int i30 = A;
                                        if (iB6 != i30) {
                                            i4 = 1;
                                        } else {
                                            if (((iB5 >> 24) & 255) == 1) {
                                                nVar10.e(nVar10.b + 4);
                                            }
                                            if (nVar10.b() == 1) {
                                                nVar11.e(8);
                                                int iB7 = nVar11.b();
                                                if (nVar11.b() != i30) {
                                                    i4 = 1;
                                                } else {
                                                    int i31 = (iB7 >> 24) & 255;
                                                    if (i31 == 1) {
                                                        if (nVar11.k() == 0) {
                                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Variable length decription in sgpd found (unsupported)");
                                                        }
                                                    } else if (i31 >= 2) {
                                                        nVar11.e(nVar11.b + 4);
                                                    }
                                                    if (nVar11.k() == 1) {
                                                        nVar11.e(nVar11.b + 2);
                                                        i4 = 1;
                                                        if (nVar11.j() == 1) {
                                                            int iJ3 = nVar11.j();
                                                            byte[] bArr6 = new byte[16];
                                                            nVar11.a(bArr6, 0, 16);
                                                            uVar.l = true;
                                                            uVar.n = new t(iJ3, bArr6);
                                                        }
                                                    } else {
                                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Entry count in sgpd != 1 (unsupported).");
                                                    }
                                                }
                                            } else {
                                                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Entry count in sbgp != 1 (unsupported).");
                                            }
                                        }
                                    }
                                    int size6 = aVar4.Q0.size();
                                    int i32 = 0;
                                    while (i32 < size6) {
                                        b bVar4 = (b) aVar4.Q0.get(i32);
                                        if (bVar4.f2035a == c.h0) {
                                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar12 = bVar4.P0;
                                            nVar12.e(8);
                                            bArr2 = bArr5;
                                            nVar12.a(bArr2, 0, 16);
                                            if (Arrays.equals(bArr2, B)) {
                                                a(nVar12, 16, uVar);
                                            }
                                        } else {
                                            bArr2 = bArr5;
                                        }
                                        i32++;
                                        bArr5 = bArr2;
                                    }
                                    bArr = bArr5;
                                    i3 = 8;
                                }
                            } else {
                                aVar = aVar2;
                                sparseArray = sparseArray4;
                                i = size4;
                                i2 = i16;
                                i3 = i9;
                                bArr = bArr4;
                                i4 = i10;
                            }
                            i10 = i4;
                            bArr4 = bArr;
                            size4 = i;
                            sparseArray4 = sparseArray;
                            aVar2 = aVar;
                            i9 = i3;
                            i16 = i2 + 1;
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVarA2 = a(aVar2.Q0);
                        if (dVarA2 != null) {
                            mVar2 = this;
                            int size7 = mVar2.f2044a.size();
                            for (int i33 = 0; i33 < size7; i33++) {
                                l lVar5 = (l) mVar2.f2044a.valueAt(i33);
                                com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = lVar5.b;
                                com.fyber.inneractive.sdk.player.exoplayer2.o oVar = lVar5.c.f;
                                rVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.o(oVar.f2116a, oVar.e, oVar.f, oVar.c, oVar.b, oVar.g, oVar.j, oVar.k, oVar.l, oVar.m, oVar.n, oVar.p, oVar.o, oVar.q, oVar.r, oVar.s, oVar.t, oVar.u, oVar.v, oVar.x, oVar.y, oVar.z, oVar.w, oVar.h, dVarA2, oVar.d));
                            }
                        }
                    } else {
                        mVar2 = mVar;
                        if (!mVar2.i.isEmpty()) {
                            ((a) mVar2.i.peek()).R0.add(aVar2);
                        }
                    }
                    mVar = mVar2;
                }
            }
        }
        m mVar3 = mVar;
        mVar3.k = 0;
        mVar3.n = 0;
    }

    public static void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, u uVar) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        nVar.e(i + 8);
        int iB = nVar.b();
        int i2 = c.b;
        if ((iB & 1) == 0) {
            boolean z = (iB & 2) != 0;
            int iM = nVar.m();
            if (iM == uVar.e) {
                Arrays.fill(uVar.m, 0, iM, z);
                int i3 = nVar.c - nVar.b;
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = uVar.p;
                if (nVar2 == null || nVar2.c < i3) {
                    uVar.p = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(i3);
                }
                uVar.o = i3;
                uVar.l = true;
                uVar.q = true;
                nVar.a(uVar.p.f2184a, 0, i3);
                uVar.p.e(0);
                uVar.q = false;
                return;
            }
            throw new com.fyber.inneractive.sdk.player.exoplayer2.r(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Length mismatch: ", iM, ", ").append(uVar.e).toString());
        }
        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.drm.d a(ArrayList arrayList) {
        int size = arrayList.size();
        ArrayList arrayList2 = null;
        for (int i = 0; i < size; i++) {
            b bVar = (b) arrayList.get(i);
            if (bVar.f2035a == c.V) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] bArr = bVar.P0.f2184a;
                UUID uuidA = q.a(bArr);
                if (uuidA == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList2.add(new com.fyber.inneractive.sdk.player.exoplayer2.drm.c(uuidA, "video/mp4", bArr));
                }
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        return new com.fyber.inneractive.sdk.player.exoplayer2.drm.d(false, (com.fyber.inneractive.sdk.player.exoplayer2.drm.c[]) arrayList2.toArray(new com.fyber.inneractive.sdk.player.exoplayer2.drm.c[arrayList2.size()]));
    }
}
