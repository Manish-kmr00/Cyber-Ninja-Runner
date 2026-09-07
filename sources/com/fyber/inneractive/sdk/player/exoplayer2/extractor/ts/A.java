package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes9.dex */
public final class A implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.m f2068a = new com.fyber.inneractive.sdk.player.exoplayer2.util.m(new byte[5]);
    public final SparseArray b = new SparseArray();
    public final SparseIntArray c = new SparseIntArray();
    public final int d;
    public final /* synthetic */ B e;

    public A(B b, int i) {
        this.e = b;
        this.d = i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, E e) {
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0110  */
    /* JADX WARN: Code duplicated, block: B:41:0x011b  */
    /* JADX WARN: Code duplicated, block: B:78:0x01cc  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar2;
        char c;
        F fA;
        int i;
        int i2;
        if (nVar.j() != 2) {
            return;
        }
        B b = this.e;
        int i3 = b.f2069a;
        int i4 = 0;
        if (i3 == 1 || i3 == 2 || b.i == 1) {
            vVar = (com.fyber.inneractive.sdk.player.exoplayer2.util.v) b.b.get(0);
        } else {
            vVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.v(((com.fyber.inneractive.sdk.player.exoplayer2.util.v) b.b.get(0)).f2190a);
            this.e.b.add(vVar);
        }
        nVar.e(nVar.b + 2);
        int iO = nVar.o();
        int i5 = 5;
        nVar.e(nVar.b + 5);
        com.fyber.inneractive.sdk.player.exoplayer2.util.m mVar = this.f2068a;
        nVar.a(mVar.f2183a, 0, 2);
        mVar.b(0);
        int i6 = 4;
        this.f2068a.c(4);
        int i7 = 12;
        nVar.e(nVar.b + this.f2068a.a(12));
        B b2 = this.e;
        if (b2.f2069a == 2 && b2.k == null) {
            D d = new D(21, null, null, new byte[0]);
            B b3 = this.e;
            b3.k = b3.e.a(21, d);
            B b4 = this.e;
            b4.k.a(vVar, b4.h, new E(iO, 21, 8192));
        }
        this.b.clear();
        this.c.clear();
        int i8 = nVar.c - nVar.b;
        while (i8 > 0) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.m mVar2 = this.f2068a;
            nVar.a(mVar2.f2183a, i4, i5);
            mVar2.b(i4);
            int iA = this.f2068a.a(8);
            int i9 = 3;
            this.f2068a.c(3);
            int iA2 = this.f2068a.a(13);
            this.f2068a.c(i6);
            int iA3 = this.f2068a.a(i7);
            int i10 = nVar.b;
            int i11 = i10 + iA3;
            int i12 = -1;
            String strTrim = null;
            ArrayList arrayList = null;
            while (nVar.b < i11) {
                int iJ = nVar.j();
                int iJ2 = nVar.b + nVar.j();
                if (iJ == i5) {
                    long jK = nVar.k();
                    if (jK == B.l) {
                        i2 = 129;
                    } else if (jK == B.m) {
                        i2 = 135;
                    } else {
                        if (jK == B.n) {
                            i2 = 36;
                        }
                        i = 4;
                    }
                    i12 = i2;
                    i = 4;
                } else {
                    if (iJ == 106) {
                        i2 = 129;
                    } else if (iJ == 122) {
                        i2 = 135;
                    } else if (iJ == 123) {
                        i2 = 138;
                    } else {
                        if (iJ == 10) {
                            strTrim = nVar.b(i9).trim();
                        } else if (iJ == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (nVar.b < iJ2) {
                                String strTrim2 = nVar.b(i9).trim();
                                nVar.j();
                                byte[] bArr = new byte[4];
                                nVar.a(bArr, 0, 4);
                                arrayList2.add(new C(strTrim2, bArr));
                                vVar = vVar;
                                i9 = 3;
                            }
                            vVar = vVar;
                            i = 4;
                            arrayList = arrayList2;
                            i12 = 89;
                        }
                        i = 4;
                    }
                    i12 = i2;
                    i = 4;
                }
                int i13 = nVar.b;
                nVar.e((iJ2 - i13) + i13);
                i6 = i;
                vVar = vVar;
                i5 = 5;
                i9 = 3;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar3 = vVar;
            int i14 = i6;
            nVar.e(i11);
            D d2 = new D(i12, strTrim, arrayList, Arrays.copyOfRange(nVar.f2184a, i10, i11));
            if (iA == 6) {
                iA = i12;
            }
            i8 -= iA3 + 5;
            B b5 = this.e;
            int i15 = b5.f2069a == 2 ? iA : iA2;
            if (b5.g.get(i15)) {
                c = 21;
            } else {
                B b6 = this.e;
                if (b6.f2069a == 2) {
                    c = 21;
                    if (iA == 21) {
                        fA = b6.k;
                    }
                    if (this.e.f2069a == 2 || iA2 < this.c.get(i15, 8192)) {
                        this.c.put(i15, iA2);
                        this.b.put(i15, fA);
                    }
                } else {
                    c = 21;
                }
                fA = b6.e.a(iA, d2);
                if (this.e.f2069a == 2) {
                    this.c.put(i15, iA2);
                    this.b.put(i15, fA);
                } else {
                    this.c.put(i15, iA2);
                    this.b.put(i15, fA);
                }
            }
            i6 = i14;
            vVar = vVar3;
            i4 = 0;
            i5 = 5;
            i7 = 12;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar4 = vVar;
        int size = this.c.size();
        int i16 = 0;
        while (i16 < size) {
            int iKeyAt = this.c.keyAt(i16);
            this.e.g.put(iKeyAt, true);
            F f = (F) this.b.valueAt(i16);
            if (f != null) {
                B b7 = this.e;
                if (f != b7.k) {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar = b7.h;
                    E e = new E(iO, iKeyAt, 8192);
                    vVar2 = vVar4;
                    f.a(vVar2, jVar, e);
                } else {
                    vVar2 = vVar4;
                }
                this.e.f.put(this.c.valueAt(i16), f);
            } else {
                vVar2 = vVar4;
            }
            i16++;
            vVar4 = vVar2;
        }
        B b8 = this.e;
        if (b8.f2069a == 2) {
            if (b8.j) {
                return;
            }
            b8.h.b();
            B b9 = this.e;
            b9.i = 0;
            b9.j = true;
            return;
        }
        b8.f.remove(this.d);
        B b10 = this.e;
        int i17 = b10.f2069a == 1 ? 0 : b10.i - 1;
        b10.i = i17;
        if (i17 == 0) {
            b10.h.b();
            this.e.j = true;
        }
    }
}
