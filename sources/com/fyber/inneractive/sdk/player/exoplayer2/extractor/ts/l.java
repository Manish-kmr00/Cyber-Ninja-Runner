package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.r f2083a;
    public final boolean b;
    public final boolean c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.o f;
    public byte[] g;
    public int h;
    public int i;
    public long j;
    public long l;
    public long p;
    public long q;
    public boolean r;
    public final SparseArray d = new SparseArray();
    public final SparseArray e = new SparseArray();
    public k m = new k();
    public k n = new k();
    public boolean k = false;
    public boolean o = false;

    public l(com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar, boolean z, boolean z2) {
        this.f2083a = rVar;
        this.b = z;
        this.c = z2;
        byte[] bArr = new byte[128];
        this.g = bArr;
        this.f = new com.fyber.inneractive.sdk.player.exoplayer2.util.o(bArr, 0, 0);
        k kVar = this.n;
        kVar.b = false;
        kVar.f2082a = false;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0100  */
    /* JADX WARN: Code duplicated, block: B:54:0x0102  */
    /* JADX WARN: Code duplicated, block: B:56:0x0105  */
    /* JADX WARN: Code duplicated, block: B:58:0x010d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x010e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0115  */
    /* JADX WARN: Code duplicated, block: B:63:0x011a  */
    /* JADX WARN: Code duplicated, block: B:65:0x0124 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0125  */
    /* JADX WARN: Code duplicated, block: B:73:0x0145  */
    /* JADX WARN: Code duplicated, block: B:74:0x0149  */
    /* JADX WARN: Code duplicated, block: B:88:0x017d  */
    public final void a(byte[] bArr, int i, int i2) {
        boolean zC;
        boolean zC2;
        boolean z;
        boolean z2;
        int iD;
        int i3;
        int iE;
        int iE2;
        int i4;
        int iB;
        if (this.k) {
            int i5 = i2 - i;
            byte[] bArr2 = this.g;
            int length = bArr2.length;
            int i6 = this.h + i5;
            if (length < i6) {
                this.g = Arrays.copyOf(bArr2, i6 * 2);
            }
            System.arraycopy(bArr, i, this.g, this.h, i5);
            int i7 = this.h + i5;
            this.h = i7;
            com.fyber.inneractive.sdk.player.exoplayer2.util.o oVar = this.f;
            oVar.f2185a = this.g;
            int i8 = 0;
            oVar.c = 0;
            oVar.b = i7;
            oVar.d = 0;
            oVar.a();
            if (this.f.a(8)) {
                this.f.f();
                int iB2 = this.f.b(2);
                this.f.d(5);
                if (this.f.b()) {
                    this.f.d();
                    if (this.f.b()) {
                        int iD2 = this.f.d();
                        if (!this.c) {
                            this.k = false;
                            k kVar = this.n;
                            kVar.e = iD2;
                            kVar.b = true;
                            return;
                        }
                        if (this.f.b()) {
                            int iD3 = this.f.d();
                            if (this.e.indexOfKey(iD3) < 0) {
                                this.k = false;
                                return;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.util.j jVar = (com.fyber.inneractive.sdk.player.exoplayer2.util.j) this.e.get(iD3);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.util.k) this.d.get(jVar.f2180a);
                            if (kVar2.e) {
                                if (!this.f.a(2)) {
                                    return;
                                } else {
                                    this.f.d(2);
                                }
                            }
                            if (this.f.a(kVar2.g)) {
                                int iB3 = this.f.b(kVar2.g);
                                if (!kVar2.f) {
                                    if (this.f.a(1)) {
                                        zC = this.f.c();
                                        if (!zC) {
                                            zC2 = false;
                                        } else {
                                            if (!this.f.a(1)) {
                                                return;
                                            }
                                            zC2 = this.f.c();
                                            z = true;
                                        }
                                        if (this.i == 5) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            iD = 0;
                                        } else if (!this.f.b()) {
                                            return;
                                        } else {
                                            iD = this.f.d();
                                        }
                                        i3 = kVar2.h;
                                        if (i3 == 0) {
                                            if (!this.f.a(kVar2.i)) {
                                                return;
                                            }
                                            iB = this.f.b(kVar2.i);
                                            if (jVar.b || zC) {
                                                iE = 0;
                                                i4 = iB;
                                                iE2 = 0;
                                            } else {
                                                if (!this.f.b()) {
                                                    return;
                                                }
                                                iE = this.f.e();
                                                i4 = iB;
                                                iE2 = 0;
                                            }
                                        } else if (i3 == 1 || kVar2.j) {
                                            iE = 0;
                                            iE2 = 0;
                                            i4 = 0;
                                        } else {
                                            if (!this.f.b()) {
                                                return;
                                            }
                                            int iE3 = this.f.e();
                                            if (!jVar.b || zC) {
                                                iE = 0;
                                                i4 = 0;
                                                i8 = iE3;
                                                iE2 = 0;
                                            } else {
                                                if (!this.f.b()) {
                                                    return;
                                                }
                                                i4 = 0;
                                                i8 = iE3;
                                                iE2 = this.f.e();
                                                iE = 0;
                                            }
                                        }
                                        k kVar3 = this.n;
                                        kVar3.c = kVar2;
                                        kVar3.d = iB2;
                                        kVar3.e = iD2;
                                        kVar3.f = iB3;
                                        kVar3.g = iD3;
                                        kVar3.h = zC;
                                        kVar3.i = z;
                                        kVar3.j = zC2;
                                        kVar3.k = z2;
                                        kVar3.l = iD;
                                        kVar3.m = i4;
                                        kVar3.n = iE;
                                        kVar3.o = i8;
                                        kVar3.p = iE2;
                                        kVar3.f2082a = true;
                                        kVar3.b = true;
                                        this.k = false;
                                    }
                                    return;
                                }
                                zC = false;
                                zC2 = false;
                                z = zC2;
                                if (this.i == 5) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    iD = 0;
                                } else if (!this.f.b()) {
                                    return;
                                } else {
                                    iD = this.f.d();
                                }
                                i3 = kVar2.h;
                                if (i3 == 0) {
                                    if (!this.f.a(kVar2.i)) {
                                        return;
                                    }
                                    iB = this.f.b(kVar2.i);
                                    if (jVar.b) {
                                        iE = 0;
                                        i4 = iB;
                                        iE2 = 0;
                                    } else {
                                        iE = 0;
                                        i4 = iB;
                                        iE2 = 0;
                                    }
                                } else if (i3 == 1) {
                                    iE = 0;
                                    iE2 = 0;
                                    i4 = 0;
                                } else {
                                    iE = 0;
                                    iE2 = 0;
                                    i4 = 0;
                                }
                                k kVar4 = this.n;
                                kVar4.c = kVar2;
                                kVar4.d = iB2;
                                kVar4.e = iD2;
                                kVar4.f = iB3;
                                kVar4.g = iD3;
                                kVar4.h = zC;
                                kVar4.i = z;
                                kVar4.j = zC2;
                                kVar4.k = z2;
                                kVar4.l = iD;
                                kVar4.m = i4;
                                kVar4.n = iE;
                                kVar4.o = i8;
                                kVar4.p = iE2;
                                kVar4.f2082a = true;
                                kVar4.b = true;
                                this.k = false;
                            }
                        }
                    }
                }
            }
        }
    }
}
