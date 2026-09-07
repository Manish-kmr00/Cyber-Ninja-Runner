package com.fyber.inneractive.sdk.protobuf;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3189h extends AbstractC3192i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2286a = true;
    public final byte[] b;
    public int c;
    public int d;
    public int e;
    public int f;

    public C3189h(ByteBuffer byteBuffer) {
        this.b = byteBuffer.array();
        this.c = byteBuffer.position() + byteBuffer.arrayOffset();
        this.d = byteBuffer.limit() + byteBuffer.arrayOffset();
    }

    public final String a(boolean z) throws C3211o0 {
        c(2);
        int iX = x();
        if (iX == 0) {
            return "";
        }
        a(iX);
        if (z) {
            byte[] bArr = this.b;
            int i = this.c;
            if (!E1.f2253a.b(bArr, i, i + iX)) {
                throw new C3211o0("Protocol message had invalid UTF-8.");
            }
        }
        String str = new String(this.b, this.c, iX, AbstractC3205m0.f2291a);
        this.c += iX;
        return str;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final Object b(Class cls, H h) throws C3208n0 {
        c(2);
        return d(Q0.c.a(cls), h);
    }

    public final Object c(U0 u0, H h) {
        int i = this.f;
        this.f = ((this.e >>> 3) << 3) | 4;
        try {
            Object objA = u0.a();
            u0.a(objA, this, h);
            u0.c(objA);
            if (this.e != this.f) {
                throw new C3211o0("Failed to parse the message.");
            }
            this.f = i;
            return objA;
        } catch (Throwable th) {
            this.f = i;
            throw th;
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int d() throws C3208n0 {
        c(0);
        return x();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int e() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final long f() throws C3208n0 {
        c(0);
        return y();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final long g() throws C3211o0 {
        c(1);
        a(8);
        return w();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final double h() throws C3211o0 {
        c(1);
        a(8);
        return Double.longBitsToDouble(w());
    }

    /* JADX WARN: Code duplicated, block: B:44:0x008b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0091  */
    /* JADX WARN: Code duplicated, block: B:49:0x009c A[LOOP:2: B:43:0x0089->B:49:0x009c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x009f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x009b A[SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final boolean i() throws C3211o0 {
        int i;
        int i2;
        int i3;
        byte[] bArr;
        if (u() || (i = this.e) == (i2 = this.f)) {
            return false;
        }
        int i4 = i & 7;
        if (i4 != 0) {
            if (i4 == 1) {
                a(8);
                this.c += 8;
                return true;
            }
            if (i4 == 2) {
                int iX = x();
                a(iX);
                this.c += iX;
                return true;
            }
            if (i4 != 3) {
                if (i4 != 5) {
                    int i5 = C3211o0.f2292a;
                    throw new C3208n0();
                }
                a(4);
                this.c += 4;
                return true;
            }
            this.f = ((i >>> 3) << 3) | 4;
            while (s() != Integer.MAX_VALUE && i()) {
            }
            if (this.e != this.f) {
                throw new C3211o0("Failed to parse the message.");
            }
            this.f = i2;
            return true;
        }
        int i6 = this.d;
        int i7 = this.c;
        if (i6 - i7 < 10) {
            for (int i8 = 0; i8 < 10; i8++) {
                i3 = this.c;
                if (i3 != this.d) {
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                bArr = this.b;
                this.c = i3 + 1;
                if (bArr[i3] >= 0) {
                }
            }
            throw new C3211o0("CodedInputStream encountered a malformed varint.");
        }
        byte[] bArr2 = this.b;
        int i9 = 0;
        while (i9 < 10) {
            int i10 = i7 + 1;
            if (bArr2[i7] >= 0) {
                this.c = i10;
            } else {
                i9++;
                i7 = i10;
            }
        }
        while (i8 < 10) {
            i3 = this.c;
            if (i3 != this.d) {
                throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            bArr = this.b;
            this.c = i3 + 1;
            if (bArr[i3] >= 0) {
            }
        }
        throw new C3211o0("CodedInputStream encountered a malformed varint.");
        return true;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int j() throws C3208n0 {
        c(0);
        return AbstractC3229w.b(x());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final float k() throws C3211o0 {
        c(5);
        a(4);
        return Float.intBitsToFloat(v());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final long l() throws C3208n0 {
        c(0);
        return AbstractC3229w.a(y());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int m() throws C3211o0 {
        c(5);
        a(4);
        return v();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final String n() {
        return a(false);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final long o() throws C3208n0 {
        c(0);
        return y();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final String p() {
        return a(true);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int q() throws C3211o0 {
        c(5);
        a(4);
        return v();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final boolean r() throws C3208n0 {
        c(0);
        return x() != 0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int s() throws C3211o0 {
        if (u()) {
            return Integer.MAX_VALUE;
        }
        int iX = x();
        this.e = iX;
        if (iX == this.f) {
            return Integer.MAX_VALUE;
        }
        return iX >>> 3;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final long t() throws C3211o0 {
        c(1);
        a(8);
        return w();
    }

    public final boolean u() {
        return this.c == this.d;
    }

    public final int v() {
        int i = this.c;
        byte[] bArr = this.b;
        this.c = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long w() {
        int i = this.c;
        byte[] bArr = this.b;
        this.c = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00a4 A[PHI: r2
  0x00a4: PHI (r2v7 int) = (r2v6 int), (r2v9 int) binds: [B:37:0x0082, B:41:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    public final int x() throws C3211o0 {
        int i;
        int i2 = this.c;
        int i3 = this.d;
        if (i3 == i2) {
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.b;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            this.c = i4;
            return b;
        }
        if (i3 - i4 < 9) {
            long j = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                int i6 = this.c;
                if (i6 == this.d) {
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                byte[] bArr2 = this.b;
                this.c = i6 + 1;
                byte b2 = bArr2[i6];
                j |= ((long) (b2 & 127)) << i5;
                if ((b2 & 128) == 0) {
                    return (int) j;
                }
            }
            throw new C3211o0("CodedInputStream encountered a malformed varint.");
        }
        int i7 = i2 + 2;
        int i8 = (bArr[i4] << 7) ^ b;
        if (i8 < 0) {
            i = i8 ^ (-128);
        } else {
            int i9 = i2 + 3;
            int i10 = (bArr[i7] << Ascii.SO) ^ i8;
            if (i10 >= 0) {
                i = i10 ^ 16256;
            } else {
                int i11 = i2 + 4;
                int i12 = i10 ^ (bArr[i9] << Ascii.NAK);
                if (i12 < 0) {
                    i = (-2080896) ^ i12;
                    i7 = i11;
                } else {
                    i9 = i2 + 5;
                    byte b3 = bArr[i11];
                    int i13 = (i12 ^ (b3 << Ascii.FS)) ^ 266354560;
                    if (b3 < 0) {
                        int i14 = i2 + 6;
                        if (bArr[i9] < 0) {
                            i9 = i2 + 7;
                            if (bArr[i14] < 0) {
                                i14 = i2 + 8;
                                if (bArr[i9] < 0) {
                                    i9 = i2 + 9;
                                    if (bArr[i14] < 0) {
                                        int i15 = i2 + 10;
                                        if (bArr[i9] < 0) {
                                            throw new C3211o0("CodedInputStream encountered a malformed varint.");
                                        }
                                        i9 = i15;
                                    }
                                } else {
                                    i9 = i14;
                                }
                            }
                        } else {
                            i9 = i14;
                        }
                    }
                    i = i13;
                }
            }
            i7 = i9;
        }
        this.c = i7;
        return i;
    }

    public final long y() throws C3211o0 {
        long j;
        long j2;
        long j3;
        long j4;
        int i = this.c;
        int i2 = this.d;
        if (i2 == i) {
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.b;
        int i3 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            this.c = i3;
            return b;
        }
        long j5 = 0;
        if (i2 - i3 < 9) {
            for (int i4 = 0; i4 < 64; i4 += 7) {
                int i5 = this.c;
                if (i5 == this.d) {
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                byte[] bArr2 = this.b;
                this.c = i5 + 1;
                byte b2 = bArr2[i5];
                j5 |= ((long) (b2 & 127)) << i4;
                if ((b2 & 128) == 0) {
                    return j5;
                }
            }
            throw new C3211o0("CodedInputStream encountered a malformed varint.");
        }
        int i6 = i + 2;
        int i7 = (bArr[i3] << 7) ^ b;
        if (i7 < 0) {
            j = i7 ^ (-128);
        } else {
            int i8 = i + 3;
            int i9 = (bArr[i6] << Ascii.SO) ^ i7;
            if (i9 >= 0) {
                j = i9 ^ 16256;
                i6 = i8;
            } else {
                int i10 = i + 4;
                int i11 = i9 ^ (bArr[i8] << Ascii.NAK);
                if (i11 < 0) {
                    j4 = (-2080896) ^ i11;
                } else {
                    long j6 = i11;
                    i6 = i + 5;
                    long j7 = j6 ^ (((long) bArr[i10]) << 28);
                    if (j7 >= 0) {
                        j3 = 266354560;
                    } else {
                        i10 = i + 6;
                        long j8 = j7 ^ (((long) bArr[i6]) << 35);
                        if (j8 < 0) {
                            j2 = -34093383808L;
                        } else {
                            i6 = i + 7;
                            j7 = j8 ^ (((long) bArr[i10]) << 42);
                            if (j7 >= 0) {
                                j3 = 4363953127296L;
                            } else {
                                i10 = i + 8;
                                j8 = j7 ^ (((long) bArr[i6]) << 49);
                                if (j8 < 0) {
                                    j2 = -558586000294016L;
                                } else {
                                    i6 = i + 9;
                                    long j9 = (j8 ^ (((long) bArr[i10]) << 56)) ^ 71499008037633920L;
                                    if (j9 < 0) {
                                        int i12 = i + 10;
                                        if (bArr[i6] < 0) {
                                            throw new C3211o0("CodedInputStream encountered a malformed varint.");
                                        }
                                        i6 = i12;
                                    }
                                    j = j9;
                                }
                            }
                        }
                        j4 = j2 ^ j8;
                    }
                    j = j3 ^ j7;
                }
                i6 = i10;
                j = j4;
            }
        }
        this.c = i6;
        return j;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void e(List list) throws C3211o0 {
        int i;
        int i2;
        if (!(list instanceof C3172b0)) {
            int i3 = this.e & 7;
            if (i3 == 2) {
                int iX = x();
                d(iX);
                int i4 = this.c + iX;
                while (this.c < i4) {
                    list.add(Integer.valueOf(v()));
                }
                return;
            }
            if (i3 != 5) {
                int i5 = C3211o0.f2292a;
                throw new C3208n0();
            }
            do {
                list.add(Integer.valueOf(q()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        C3172b0 c3172b0 = (C3172b0) list;
        int i6 = this.e & 7;
        if (i6 == 2) {
            int iX2 = x();
            d(iX2);
            int i7 = this.c + iX2;
            while (this.c < i7) {
                c3172b0.c(v());
            }
            return;
        }
        if (i6 != 5) {
            int i8 = C3211o0.f2292a;
            throw new C3208n0();
        }
        do {
            c3172b0.c(q());
            if (u()) {
                return;
            } else {
                i2 = this.c;
            }
        } while (x() == this.e);
        this.c = i2;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void n(List list) throws C3211o0 {
        int i;
        int i2;
        if (!(list instanceof C3228v0)) {
            int i3 = this.e & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(g()));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (x() == this.e);
                this.c = i;
                return;
            }
            if (i3 != 2) {
                int i4 = C3211o0.f2292a;
                throw new C3208n0();
            }
            int iX = x();
            e(iX);
            int i5 = this.c + iX;
            while (this.c < i5) {
                list.add(Long.valueOf(w()));
            }
            return;
        }
        C3228v0 c3228v0 = (C3228v0) list;
        int i6 = this.e & 7;
        if (i6 == 1) {
            do {
                c3228v0.a(g());
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (x() == this.e);
            this.c = i2;
            return;
        }
        if (i6 != 2) {
            int i7 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int iX2 = x();
        e(iX2);
        int i8 = this.c + iX2;
        while (this.c < i8) {
            c3228v0.a(w());
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void p(List list) throws C3211o0 {
        int i;
        int i2;
        if (!(list instanceof C3172b0)) {
            int i3 = this.e & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    int i4 = C3211o0.f2292a;
                    throw new C3208n0();
                }
                int iX = this.c + x();
                while (this.c < iX) {
                    list.add(Integer.valueOf(x()));
                }
                return;
            }
            do {
                c(0);
                list.add(Integer.valueOf(x()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        C3172b0 c3172b0 = (C3172b0) list;
        int i5 = this.e & 7;
        if (i5 != 0) {
            if (i5 != 2) {
                int i6 = C3211o0.f2292a;
                throw new C3208n0();
            }
            int iX2 = this.c + x();
            while (this.c < iX2) {
                c3172b0.c(x());
            }
            return;
        }
        do {
            c(0);
            c3172b0.c(x());
            if (u()) {
                return;
            } else {
                i2 = this.c;
            }
        } while (x() == this.e);
        this.c = i2;
    }

    public final Object d(U0 u0, H h) throws C3211o0 {
        int iX = x();
        a(iX);
        int i = this.d;
        int i2 = this.c + iX;
        this.d = i2;
        try {
            Object objA = u0.a();
            u0.a(objA, this, h);
            u0.c(objA);
            if (this.c == i2) {
                this.d = i;
                return objA;
            }
            throw new C3211o0("Failed to parse the message.");
        } catch (Throwable th) {
            this.d = i;
            throw th;
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void f(List list) throws C3211o0 {
        int i;
        int i2;
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            int i3 = this.e & 7;
            if (i3 == 2) {
                int iX = x();
                d(iX);
                int i4 = this.c + iX;
                while (this.c < i4) {
                    c3172b0.c(v());
                }
                return;
            }
            if (i3 == 5) {
                do {
                    c3172b0.c(m());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            int i5 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i6 = this.e & 7;
        if (i6 == 2) {
            int iX2 = x();
            d(iX2);
            int i7 = this.c + iX2;
            while (this.c < i7) {
                list.add(Integer.valueOf(v()));
            }
            return;
        }
        if (i6 == 5) {
            do {
                list.add(Integer.valueOf(m()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        int i8 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void j(List list) throws C3211o0 {
        int i;
        int i2;
        if (list instanceof D) {
            D d = (D) list;
            int i3 = this.e & 7;
            if (i3 == 1) {
                do {
                    d.a(h());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int iX = x();
                e(iX);
                int i4 = this.c + iX;
                while (this.c < i4) {
                    d.a(Double.longBitsToDouble(w()));
                }
                return;
            }
            int i5 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i6 = this.e & 7;
        if (i6 == 1) {
            do {
                list.add(Double.valueOf(h()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i6 == 2) {
            int iX2 = x();
            e(iX2);
            int i7 = this.c + iX2;
            while (this.c < i7) {
                list.add(Double.valueOf(Double.longBitsToDouble(w())));
            }
            return;
        }
        int i8 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void l(List list) throws C3211o0 {
        int i;
        int i2;
        if (list instanceof C3195j) {
            C3195j c3195j = (C3195j) list;
            int i3 = this.e & 7;
            if (i3 == 0) {
                do {
                    c3195j.a(r());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int iX = this.c + x();
                while (this.c < iX) {
                    c3195j.a(x() != 0);
                }
                b(iX);
                return;
            }
            int i4 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i5 = this.e & 7;
        if (i5 == 0) {
            do {
                list.add(Boolean.valueOf(r()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i5 == 2) {
            int iX2 = this.c + x();
            while (this.c < iX2) {
                list.add(Boolean.valueOf(x() != 0));
            }
            b(iX2);
            return;
        }
        int i6 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void o(List list) throws C3211o0 {
        int i;
        int i2;
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            int i3 = this.e & 7;
            if (i3 == 0) {
                do {
                    c(0);
                    c3172b0.c(x());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int iX = this.c + x();
                while (this.c < iX) {
                    c3172b0.c(x());
                }
                b(iX);
                return;
            }
            int i4 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i5 = this.e & 7;
        if (i5 == 0) {
            do {
                c(0);
                list.add(Integer.valueOf(x()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i5 == 2) {
            int iX2 = this.c + x();
            while (this.c < iX2) {
                list.add(Integer.valueOf(x()));
            }
            b(iX2);
            return;
        }
        int i6 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final Object b(U0 u0, H h) throws C3208n0 {
        c(2);
        return d(u0, h);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void g(List list) throws C3211o0 {
        int i;
        int i2;
        if (list instanceof C3228v0) {
            C3228v0 c3228v0 = (C3228v0) list;
            int i3 = this.e & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iX = this.c + x();
                    while (this.c < iX) {
                        c3228v0.a(AbstractC3229w.a(y()));
                    }
                    return;
                }
                int i4 = C3211o0.f2292a;
                throw new C3208n0();
            }
            do {
                c(0);
                c3228v0.a(AbstractC3229w.a(y()));
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (x() == this.e);
            this.c = i2;
            return;
        }
        int i5 = this.e & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int iX2 = this.c + x();
                while (this.c < iX2) {
                    list.add(Long.valueOf(AbstractC3229w.a(y())));
                }
                return;
            }
            int i6 = C3211o0.f2292a;
            throw new C3208n0();
        }
        do {
            c(0);
            list.add(Long.valueOf(AbstractC3229w.a(y())));
            if (u()) {
                return;
            } else {
                i = this.c;
            }
        } while (x() == this.e);
        this.c = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void m(List list) throws C3211o0 {
        int i;
        int i2;
        if (list instanceof C3228v0) {
            C3228v0 c3228v0 = (C3228v0) list;
            int i3 = this.e & 7;
            if (i3 == 1) {
                do {
                    c3228v0.a(t());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int iX = x();
                e(iX);
                int i4 = this.c + iX;
                while (this.c < i4) {
                    c3228v0.a(w());
                }
                return;
            }
            int i5 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i6 = this.e & 7;
        if (i6 == 1) {
            do {
                list.add(Long.valueOf(t()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i6 == 2) {
            int iX2 = x();
            e(iX2);
            int i7 = this.c + iX2;
            while (this.c < i7) {
                list.add(Long.valueOf(w()));
            }
            return;
        }
        int i8 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void q(List list) throws C3208n0 {
        a(list, false);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void h(List list) throws C3208n0 {
        int i;
        if ((this.e & 7) == 2) {
            do {
                list.add(a());
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        int i2 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void k(List list) throws C3211o0 {
        int i;
        int i2;
        if (list instanceof C3228v0) {
            C3228v0 c3228v0 = (C3228v0) list;
            int i3 = this.e & 7;
            if (i3 == 0) {
                do {
                    c(0);
                    c3228v0.a(y());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int iX = this.c + x();
                while (this.c < iX) {
                    c3228v0.a(y());
                }
                b(iX);
                return;
            }
            int i4 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i5 = this.e & 7;
        if (i5 == 0) {
            do {
                c(0);
                list.add(Long.valueOf(y()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i5 == 2) {
            int iX2 = this.c + x();
            while (this.c < iX2) {
                list.add(Long.valueOf(y()));
            }
            b(iX2);
            return;
        }
        int i6 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int b() throws C3208n0 {
        c(0);
        return x();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void b(List list) throws C3208n0 {
        a(list, true);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void b(List list, U0 u0, H h) throws C3208n0 {
        int i;
        int i2 = this.e;
        if ((i2 & 7) == 2) {
            do {
                list.add(d(u0, h));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == i2);
            this.c = i;
            return;
        }
        int i3 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final Object a(Class cls, H h) throws C3208n0 {
        c(3);
        return c(Q0.c.a(cls), h);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final Object a(U0 u0, H h) throws C3208n0 {
        c(3);
        return c(u0, h);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final AbstractC3221s a() throws C3211o0 {
        AbstractC3221s c3216q;
        c(2);
        int iX = x();
        if (iX == 0) {
            return AbstractC3221s.b;
        }
        a(iX);
        if (this.f2286a) {
            byte[] bArr = this.b;
            int i = this.c;
            C3216q c3216q2 = AbstractC3221s.b;
            c3216q = new C3207n(bArr, i, iX);
        } else {
            byte[] bArr2 = this.b;
            int i2 = this.c;
            C3216q c3216q3 = AbstractC3221s.b;
            AbstractC3221s.a(i2, i2 + iX, bArr2.length);
            c3216q = new C3216q(AbstractC3221s.c.a(bArr2, i2, iX));
        }
        this.c += iX;
        return c3216q;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final int c() throws C3208n0 {
        c(0);
        return x();
    }

    public final void b(int i) throws C3211o0 {
        if (this.c != i) {
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void c(List list) throws C3211o0 {
        int i;
        int i2;
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            int i3 = this.e & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iX = this.c + x();
                    while (this.c < iX) {
                        c3172b0.c(AbstractC3229w.b(x()));
                    }
                    return;
                }
                int i4 = C3211o0.f2292a;
                throw new C3208n0();
            }
            do {
                c(0);
                c3172b0.c(AbstractC3229w.b(x()));
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (x() == this.e);
            this.c = i2;
            return;
        }
        int i5 = this.e & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int iX2 = this.c + x();
                while (this.c < iX2) {
                    list.add(Integer.valueOf(AbstractC3229w.b(x())));
                }
                return;
            }
            int i6 = C3211o0.f2292a;
            throw new C3208n0();
        }
        do {
            c(0);
            list.add(Integer.valueOf(AbstractC3229w.b(x())));
            if (u()) {
                return;
            } else {
                i = this.c;
            }
        } while (x() == this.e);
        this.c = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void d(List list) throws C3211o0 {
        int i;
        int i2;
        if (list instanceof Q) {
            Q q = (Q) list;
            int i3 = this.e & 7;
            if (i3 == 2) {
                int iX = x();
                d(iX);
                int i4 = this.c + iX;
                while (this.c < i4) {
                    q.a(Float.intBitsToFloat(v()));
                }
                return;
            }
            if (i3 == 5) {
                do {
                    q.a(k());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            int i5 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i6 = this.e & 7;
        if (i6 == 2) {
            int iX2 = x();
            d(iX2);
            int i7 = this.c + iX2;
            while (this.c < i7) {
                list.add(Float.valueOf(Float.intBitsToFloat(v())));
            }
            return;
        }
        if (i6 == 5) {
            do {
                list.add(Float.valueOf(k()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        int i8 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void a(List list) throws C3211o0 {
        int i;
        int i2;
        if (list instanceof C3228v0) {
            C3228v0 c3228v0 = (C3228v0) list;
            int i3 = this.e & 7;
            if (i3 == 0) {
                do {
                    c(0);
                    c3228v0.a(y());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int iX = this.c + x();
                while (this.c < iX) {
                    c3228v0.a(y());
                }
                b(iX);
                return;
            }
            int i4 = C3211o0.f2292a;
            throw new C3208n0();
        }
        int i5 = this.e & 7;
        if (i5 == 0) {
            do {
                c(0);
                list.add(Long.valueOf(y()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i5 == 2) {
            int iX2 = this.c + x();
            while (this.c < iX2) {
                list.add(Long.valueOf(y()));
            }
            b(iX2);
            return;
        }
        int i6 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void i(List list) throws C3211o0 {
        int i;
        int i2;
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            int i3 = this.e & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iX = this.c + x();
                    while (this.c < iX) {
                        c3172b0.c(x());
                    }
                    return;
                }
                int i4 = C3211o0.f2292a;
                throw new C3208n0();
            }
            do {
                c(0);
                c3172b0.c(x());
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (x() == this.e);
            this.c = i2;
            return;
        }
        int i5 = this.e & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int iX2 = this.c + x();
                while (this.c < iX2) {
                    list.add(Integer.valueOf(x()));
                }
                return;
            }
            int i6 = C3211o0.f2292a;
            throw new C3208n0();
        }
        do {
            c(0);
            list.add(Integer.valueOf(x()));
            if (u()) {
                return;
            } else {
                i = this.c;
            }
        } while (x() == this.e);
        this.c = i;
    }

    public final void e(int i) throws C3211o0 {
        a(i);
        if ((i & 7) != 0) {
            throw new C3211o0("Failed to parse the message.");
        }
    }

    public final void c(int i) throws C3208n0 {
        if ((this.e & 7) == i) {
            return;
        }
        int i2 = C3211o0.f2292a;
        throw new C3208n0();
    }

    public final void d(int i) throws C3211o0 {
        a(i);
        if ((i & 3) != 0) {
            throw new C3211o0("Failed to parse the message.");
        }
    }

    public final void a(List list, boolean z) throws C3208n0 {
        int i;
        int i2;
        if ((this.e & 7) == 2) {
            if ((list instanceof InterfaceC3219r0) && !z) {
                InterfaceC3219r0 interfaceC3219r0 = (InterfaceC3219r0) list;
                do {
                    interfaceC3219r0.a(a());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            do {
                list.add(a(z));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        int i3 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.T0
    public final void a(List list, U0 u0, H h) throws C3208n0 {
        int i;
        int i2 = this.e;
        if ((i2 & 7) == 3) {
            do {
                list.add(c(u0, h));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == i2);
            this.c = i;
            return;
        }
        int i3 = C3211o0.f2292a;
        throw new C3208n0();
    }

    public final void a(int i) throws C3211o0 {
        if (i < 0 || i > this.d - this.c) {
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }
}
