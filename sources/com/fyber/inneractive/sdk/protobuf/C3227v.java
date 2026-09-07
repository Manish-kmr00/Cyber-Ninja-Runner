package com.fyber.inneractive.sdk.protobuf;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3227v extends AbstractC3229w {
    public final ByteBuffer e;
    public final long f;
    public long g;
    public long h;
    public final long i;
    public int j;
    public int k;
    public int l = Integer.MAX_VALUE;

    public C3227v(ByteBuffer byteBuffer, boolean z) {
        this.e = byteBuffer;
        x1 x1Var = y1.c;
        long j = x1Var.f2303a.getLong(byteBuffer, y1.g);
        this.f = j;
        this.g = ((long) byteBuffer.limit()) + j;
        long jPosition = j + ((long) byteBuffer.position());
        this.h = jPosition;
        this.i = jPosition;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final void a(int i) throws C3211o0 {
        if (this.k != i) {
            throw new C3211o0("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int b() {
        return (int) (this.h - this.i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final void c(int i) {
        this.l = i;
        z();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final boolean d() {
        return y() != 0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final double f() {
        return Double.longBitsToDouble(x());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int g() {
        return m();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int h() {
        return w();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final long i() {
        return x();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final float j() {
        return Float.intBitsToFloat(w());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int k() {
        return m();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final long l() {
        return y();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00cc A[PHI: r6
  0x00cc: PHI (r6v9 long) = (r6v8 long), (r6v12 long) binds: [B:22:0x0064, B:26:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int m() throws C3211o0 {
        int i;
        long j = this.h;
        if (this.g != j) {
            long j2 = j + 1;
            x1 x1Var = y1.c;
            byte bA = x1Var.a(j);
            if (bA >= 0) {
                this.h = j2;
                return bA;
            }
            if (this.g - j2 >= 9) {
                long j3 = 2 + j;
                int iA = (x1Var.a(j2) << 7) ^ bA;
                if (iA < 0) {
                    i = iA ^ (-128);
                } else {
                    long j4 = 3 + j;
                    int iA2 = iA ^ (x1Var.a(j3) << Ascii.SO);
                    if (iA2 >= 0) {
                        i = iA2 ^ 16256;
                        j3 = j4;
                    } else {
                        j3 = 4 + j;
                        int iA3 = iA2 ^ (x1Var.a(j4) << Ascii.NAK);
                        if (iA3 < 0) {
                            i = (-2080896) ^ iA3;
                        } else {
                            long j5 = 5 + j;
                            byte bA2 = x1Var.a(j3);
                            int i2 = (iA3 ^ (bA2 << Ascii.FS)) ^ 266354560;
                            if (bA2 < 0) {
                                j3 = 6 + j;
                                if (x1Var.a(j5) < 0) {
                                    j5 = 7 + j;
                                    if (x1Var.a(j3) < 0) {
                                        j3 = 8 + j;
                                        if (x1Var.a(j5) < 0) {
                                            long j6 = 9 + j;
                                            if (x1Var.a(j3) < 0) {
                                                long j7 = j + 10;
                                                if (x1Var.a(j6) >= 0) {
                                                    j3 = j7;
                                                }
                                            } else {
                                                j3 = j6;
                                            }
                                        }
                                    } else {
                                        j3 = j5;
                                    }
                                }
                            } else {
                                j3 = j5;
                            }
                            i = i2;
                        }
                    }
                }
                this.h = j3;
                return i;
            }
        }
        long j8 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            long j9 = this.h;
            if (j9 == this.g) {
                throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.h = j9 + 1;
            byte bA3 = y1.c.a(j9);
            j8 |= ((long) (bA3 & 127)) << i3;
            if ((bA3 & 128) == 0) {
                return (int) j8;
            }
        }
        throw new C3211o0("CodedInputStream encountered a malformed varint.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int n() {
        return w();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final long o() {
        return x();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int p() {
        return AbstractC3229w.b(m());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final long q() {
        return AbstractC3229w.a(y());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final String r() throws C3211o0 {
        int iM = m();
        if (iM > 0) {
            long j = this.g;
            long j2 = this.h;
            if (iM <= ((int) (j - j2))) {
                byte[] bArr = new byte[iM];
                long j3 = iM;
                y1.c.a(j2, bArr, j3);
                String str = new String(bArr, AbstractC3205m0.f2291a);
                this.h += j3;
                return str;
            }
        }
        if (iM == 0) {
            return "";
        }
        if (iM < 0) {
            throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final String s() throws C3211o0 {
        String strB;
        int iM = m();
        if (iM > 0) {
            long j = this.g;
            long j2 = this.h;
            if (iM <= ((int) (j - j2))) {
                int i = (int) (j2 - this.f);
                ByteBuffer byteBuffer = this.e;
                A1 a1 = E1.f2253a;
                a1.getClass();
                if (byteBuffer.hasArray()) {
                    strB = a1.a(byteBuffer.array(), byteBuffer.arrayOffset() + i, iM);
                } else {
                    strB = byteBuffer.isDirect() ? a1.b(byteBuffer, i, iM) : A1.a(byteBuffer, i, iM);
                }
                this.h += (long) iM;
                return strB;
            }
        }
        if (iM == 0) {
            return "";
        }
        if (iM <= 0) {
            throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int t() throws C3211o0 {
        if (c()) {
            this.k = 0;
            return 0;
        }
        int iM = m();
        this.k = iM;
        if ((iM >>> 3) != 0) {
            return iM;
        }
        throw new C3211o0("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int u() {
        return m();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final long v() {
        return y();
    }

    public final int w() throws C3211o0 {
        long j = this.h;
        if (this.g - j < 4) {
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.h = 4 + j;
        x1 x1Var = y1.c;
        return ((x1Var.a(j + 3) & 255) << 24) | (x1Var.a(j) & 255) | ((x1Var.a(1 + j) & 255) << 8) | ((x1Var.a(2 + j) & 255) << 16);
    }

    public final long x() throws C3211o0 {
        long j = this.h;
        if (this.g - j < 8) {
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.h = 8 + j;
        x1 x1Var = y1.c;
        return ((((long) x1Var.a(j + 7)) & 255) << 56) | (((long) x1Var.a(j)) & 255) | ((((long) x1Var.a(1 + j)) & 255) << 8) | ((((long) x1Var.a(2 + j)) & 255) << 16) | ((((long) x1Var.a(3 + j)) & 255) << 24) | ((((long) x1Var.a(4 + j)) & 255) << 32) | ((((long) x1Var.a(5 + j)) & 255) << 40) | ((((long) x1Var.a(6 + j)) & 255) << 48);
    }

    public final long y() throws C3211o0 {
        long j;
        long j2;
        int i;
        long j3 = this.h;
        long j4 = 0;
        if (this.g != j3) {
            long j5 = j3 + 1;
            x1 x1Var = y1.c;
            byte bA = x1Var.a(j3);
            if (bA >= 0) {
                this.h = j5;
                return bA;
            }
            if (this.g - j5 >= 9) {
                long j6 = 2 + j3;
                int iA = (x1Var.a(j5) << 7) ^ bA;
                if (iA >= 0) {
                    long j7 = 3 + j3;
                    int iA2 = iA ^ (x1Var.a(j6) << Ascii.SO);
                    if (iA2 >= 0) {
                        j = iA2 ^ 16256;
                        j6 = j7;
                    } else {
                        j6 = 4 + j3;
                        int iA3 = iA2 ^ (x1Var.a(j7) << Ascii.NAK);
                        if (iA3 < 0) {
                            i = (-2080896) ^ iA3;
                        } else {
                            long j8 = j3 + 5;
                            long jA = ((long) iA3) ^ (((long) x1Var.a(j6)) << 28);
                            if (jA >= 0) {
                                j = 266354560 ^ jA;
                                j6 = j8;
                            } else {
                                j6 = j3 + 6;
                                long jA2 = (((long) x1Var.a(j8)) << 35) ^ jA;
                                if (jA2 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    long j9 = 7 + j3;
                                    long jA3 = jA2 ^ (((long) x1Var.a(j6)) << 42);
                                    if (jA3 >= 0) {
                                        j = 4363953127296L ^ jA3;
                                        j6 = j9;
                                    } else {
                                        j6 = j3 + 8;
                                        jA2 = jA3 ^ (((long) x1Var.a(j9)) << 49);
                                        if (jA2 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            long j10 = 9 + j3;
                                            long jA4 = (jA2 ^ (((long) x1Var.a(j6)) << 56)) ^ 71499008037633920L;
                                            if (jA4 < 0) {
                                                long j11 = j3 + 10;
                                                if (x1Var.a(j10) >= 0) {
                                                    j6 = j11;
                                                }
                                            } else {
                                                j6 = j10;
                                            }
                                            j = jA4;
                                        }
                                    }
                                }
                                j = j2 ^ jA2;
                            }
                        }
                    }
                    this.h = j6;
                    return j;
                }
                i = iA ^ (-128);
                j = i;
                this.h = j6;
                return j;
            }
        }
        for (int i2 = 0; i2 < 64; i2 += 7) {
            long j12 = this.h;
            if (j12 == this.g) {
                throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.h = j12 + 1;
            byte bA2 = y1.c.a(j12);
            j4 |= ((long) (bA2 & 127)) << i2;
            if ((bA2 & 128) == 0) {
                return j4;
            }
        }
        throw new C3211o0("CodedInputStream encountered a malformed varint.");
    }

    public final void z() {
        long j = this.g + ((long) this.j);
        this.g = j;
        int i = (int) (j - this.i);
        int i2 = this.l;
        if (i <= i2) {
            this.j = 0;
            return;
        }
        int i3 = i - i2;
        this.j = i3;
        this.g = j - ((long) i3);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int d(int i) throws C3211o0 {
        if (i < 0) {
            throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = i + ((int) (this.h - this.i));
        int i3 = this.l;
        if (i2 > i3) {
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.l = i2;
        z();
        return i3;
    }

    public final void f(int i) throws C3211o0 {
        if (i >= 0) {
            long j = this.g;
            long j2 = this.h;
            if (i <= ((int) (j - j2))) {
                this.h = j2 + ((long) i);
                return;
            }
        }
        if (i >= 0) {
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final boolean c() {
        return this.h == this.g;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final void a(int i, D0 d0, H h) throws IOException {
        int i2 = this.f2300a;
        if (i2 < this.b) {
            this.f2300a = i2 + 1;
            ((U) d0).a(this, h);
            a((i << 3) | 4);
            this.f2300a--;
            return;
        }
        throw new C3211o0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final boolean e(int i) throws C3211o0 {
        int iT;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (((int) (this.g - this.h)) >= 10) {
                while (i3 < 10) {
                    long j = this.h;
                    this.h = j + 1;
                    if (y1.c.a(j) < 0) {
                        i3++;
                    }
                }
                throw new C3211o0("CodedInputStream encountered a malformed varint.");
            }
            while (i3 < 10) {
                long j2 = this.h;
                if (j2 == this.g) {
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.h = j2 + 1;
                if (y1.c.a(j2) < 0) {
                    i3++;
                }
            }
            throw new C3211o0("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i2 == 1) {
            f(8);
            return true;
        }
        if (i2 == 2) {
            f(m());
            return true;
        }
        if (i2 == 3) {
            do {
                iT = t();
                if (iT == 0) {
                    break;
                }
            } while (e(iT));
            a(((i >>> 3) << 3) | 4);
            return true;
        }
        if (i2 == 4) {
            return false;
        }
        if (i2 == 5) {
            f(4);
            return true;
        }
        int i4 = C3211o0.f2292a;
        throw new C3208n0();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final void a(D0 d0, H h) throws IOException {
        int iM = m();
        if (this.f2300a < this.b) {
            int iD = d(iM);
            this.f2300a++;
            ((U) d0).a(this, h);
            a(0);
            this.f2300a--;
            this.l = iD;
            z();
            return;
        }
        throw new C3211o0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final C3216q e() throws C3211o0 {
        int iM = m();
        if (iM > 0) {
            long j = this.g;
            long j2 = this.h;
            if (iM <= ((int) (j - j2))) {
                byte[] bArr = new byte[iM];
                long j3 = iM;
                y1.c.a(j2, bArr, j3);
                this.h += j3;
                C3216q c3216q = AbstractC3221s.b;
                return new C3216q(bArr);
            }
        }
        if (iM == 0) {
            return AbstractC3221s.b;
        }
        if (iM < 0) {
            throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int a() {
        int i = this.l;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - ((int) (this.h - this.i));
    }
}
