package com.five_corp.ad.internal.util;

import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f1557a = new ArrayDeque();
    public final byte[] b = new byte[1];
    public final byte[] c = new byte[2];
    public final byte[] d = new byte[3];
    public final byte[] e = new byte[4];
    public final byte[] f = new byte[8];
    public int h = 0;
    public int g = 0;

    public final g a(byte[] bArr, int i, int i2, int i3) {
        int i4 = this.g;
        if (i3 != i4) {
            return new g(false, new o(p.L1, String.format("mPosition: %d, mLimit: %d, offsetInData: %d, size: %d, offsetInFile: %d", Integer.valueOf(this.h), Integer.valueOf(this.g), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)), null, null));
        }
        if (i2 <= 0) {
            return new g(false, new o(p.U1, String.format("mPosition: %d, mLimit: %d, offsetInData: %d, size: %d, offsetInFile: %d", Integer.valueOf(this.h), Integer.valueOf(this.g), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)), null, null));
        }
        this.f1557a.addLast(new a(bArr, i, i2, i4));
        this.g += i2;
        return new g(true, null);
    }

    public final int b() {
        g gVarA = a(this.e);
        if (!gVarA.f1560a) {
            gVarA.b.b();
        }
        byte[] bArr = this.e;
        return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }

    public final long c() {
        g gVarA = a(this.f);
        if (!gVarA.f1560a) {
            gVarA.b.b();
        }
        byte[] bArr = this.f;
        return (((long) (bArr[0] & 255)) << 56) | (((long) (bArr[1] & 255)) << 48) | (((long) (bArr[2] & 255)) << 40) | (((long) (bArr[3] & 255)) << 32) | (((long) (bArr[4] & 255)) << 24) | (((long) (bArr[5] & 255)) << 16) | (((long) (bArr[6] & 255)) << 8) | ((long) (bArr[7] & 255));
    }

    public final short d() {
        g gVarA = a(this.c);
        if (!gVarA.f1560a) {
            gVarA.b.b();
        }
        byte[] bArr = this.c;
        return (short) (((short) (bArr[1] & 255)) | ((short) ((bArr[0] & 255) << 8)));
    }

    public final g b(int i) {
        int i2;
        if (this.h == i) {
            return new g(true, null);
        }
        if (this.f1557a.isEmpty()) {
            return g.a(p.I1);
        }
        int i3 = this.h;
        if (i < i3) {
            return new g(false, new o(p.O1, String.format("Current position: %d, Requested position: %d", Integer.valueOf(i3), Integer.valueOf(i)), null, null));
        }
        do {
            a aVar = (a) this.f1557a.peekFirst();
            if (aVar.d + aVar.c > i) {
                break;
            }
            a aVar2 = (a) this.f1557a.pollFirst();
            i2 = aVar2.d + aVar2.c;
            if (i2 < i && this.f1557a.isEmpty()) {
                return new g(false, new o(p.K1, String.format("Maximum available position: %d, Request position: %d", Integer.valueOf(i2), Integer.valueOf(i)), null, null));
            }
        } while (i2 != i);
        this.h = i;
        return new g(true, null);
    }

    public final f a(int i) {
        if (this.f1557a.isEmpty()) {
            return new f(false, new o(p.N1, null, null, null), null);
        }
        a aVar = (a) this.f1557a.getFirst();
        int i2 = this.h;
        int i3 = i2 + i;
        int i4 = aVar.d;
        if (i3 <= aVar.c + i4) {
            b bVar = new b((aVar.b + i2) - i4, aVar.f1555a);
            g gVarB = b(i3);
            if (gVarB.f1560a) {
                return new f(true, null, bVar);
            }
            return new f(false, gVarB.b, null);
        }
        byte[] bArr = new byte[i];
        g gVarA = a(bArr);
        if (!gVarA.f1560a) {
            return new f(false, gVarA.b, null);
        }
        return new f(true, null, new b(0, bArr));
    }

    public final byte a() {
        g gVarA = a(this.b);
        if (!gVarA.f1560a) {
            gVarA.b.b();
        }
        return this.b[0];
    }

    public final g a(byte[] bArr) {
        int i;
        if (this.f1557a.isEmpty()) {
            return new g(false, new o(p.P1, String.format("Requested data length: %d, current position: %d, current limit: %d", Integer.valueOf(bArr.length), Integer.valueOf(this.h), Integer.valueOf(this.g)), null, null));
        }
        if (this.h < ((a) this.f1557a.peekFirst()).d) {
            return new g(false, new o(p.Q1, String.format("Requested data length: %d, current position: %d, current limit: %d", Integer.valueOf(bArr.length), Integer.valueOf(this.h), Integer.valueOf(this.g)), null, null));
        }
        if (this.g < this.h + bArr.length) {
            return new g(false, new o(p.R1, String.format("Requested data length: %d, current position: %d, current limit: %d", Integer.valueOf(bArr.length), Integer.valueOf(this.h), Integer.valueOf(this.g)), null, null));
        }
        int i2 = 0;
        while (i2 < bArr.length) {
            if (this.f1557a.isEmpty()) {
                return new g(false, new o(p.S1, String.format("Requested data length: %d, available data length: %d, data limit: %d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(this.g)), null, null));
            }
            a aVar = (a) this.f1557a.peekFirst();
            int i3 = this.h - aVar.d;
            int i4 = aVar.b + i3;
            int iMin = Math.min(bArr.length - i2, aVar.c - i3);
            if (i4 >= 0) {
                byte[] bArr2 = aVar.f1555a;
                if (bArr2.length >= i4 + iMin && i2 >= 0 && bArr.length >= (i = i2 + iMin) && iMin >= 0) {
                    System.arraycopy(bArr2, i4, bArr, i2, iMin);
                    g gVarB = b(this.h + iMin);
                    if (!gVarB.f1560a) {
                        return gVarB;
                    }
                    i2 = i;
                }
            }
            return new g(false, new o(p.T1, String.format("mPosition: %d, mLimit: %d, writeLength: %d, bytes.length: %d, node.offsetInFile: %d, node.offsetInData: %d, node.size: %d, node.data.length: %d", Integer.valueOf(this.h), Integer.valueOf(this.g), Integer.valueOf(iMin), Integer.valueOf(bArr.length), Integer.valueOf(aVar.d), Integer.valueOf(aVar.b), Integer.valueOf(aVar.c), Integer.valueOf(aVar.f1555a.length)), null, null));
        }
        return new g(true, null);
    }
}
