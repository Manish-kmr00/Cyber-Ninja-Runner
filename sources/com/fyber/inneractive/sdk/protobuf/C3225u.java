package com.fyber.inneractive.sdk.protobuf;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3225u extends AbstractC3229w {
    public final InputStream e;
    public final byte[] f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l = Integer.MAX_VALUE;

    public C3225u(InputStream inputStream) {
        Charset charset = AbstractC3205m0.f2291a;
        if (inputStream == null) {
            throw new NullPointerException("input");
        }
        this.e = inputStream;
        this.f = new byte[4096];
        this.g = 0;
        this.i = 0;
        this.k = 0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final void a(int i) throws C3211o0 {
        if (this.j != i) {
            throw new C3211o0("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int b() {
        return this.k + this.i;
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

    /* JADX WARN: Code duplicated, block: B:48:0x00a0 A[PHI: r3
  0x00a0: PHI (r3v13 int) = (r3v12 int), (r3v15 int) binds: [B:25:0x0053, B:29:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int m() throws C3211o0 {
        int i;
        int i2 = this.i;
        int i3 = this.g;
        if (i3 != i2) {
            byte[] bArr = this.f;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.i = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << Ascii.SO) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                            i5 = i9;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << Ascii.FS)) ^ 266354560;
                            if (b2 < 0) {
                                int i12 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i12] < 0) {
                                        i12 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i12] < 0) {
                                                int i13 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i7 = i13;
                                                }
                                            }
                                        } else {
                                            i7 = i12;
                                        }
                                    }
                                } else {
                                    i7 = i12;
                                }
                            }
                            i = i11;
                        }
                    }
                    i5 = i7;
                }
                this.i = i5;
                return i;
            }
        }
        long j = 0;
        for (int i14 = 0; i14 < 64; i14 += 7) {
            if (this.i == this.g) {
                i(1);
            }
            byte[] bArr2 = this.f;
            int i15 = this.i;
            this.i = i15 + 1;
            byte b3 = bArr2[i15];
            j |= ((long) (b3 & 127)) << i14;
            if ((b3 & 128) == 0) {
                return (int) j;
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
            int i = this.g;
            int i2 = this.i;
            if (iM <= i - i2) {
                String str = new String(this.f, i2, iM, AbstractC3205m0.f2291a);
                this.i += iM;
                return str;
            }
        }
        if (iM == 0) {
            return "";
        }
        if (iM > this.g) {
            return new String(f(iM), AbstractC3205m0.f2291a);
        }
        i(iM);
        String str2 = new String(this.f, this.i, iM, AbstractC3205m0.f2291a);
        this.i += iM;
        return str2;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final String s() throws IOException {
        byte[] bArrF;
        int iM = m();
        int i = this.i;
        int i2 = this.g;
        if (iM <= i2 - i && iM > 0) {
            bArrF = this.f;
            this.i = i + iM;
        } else {
            if (iM == 0) {
                return "";
            }
            i = 0;
            if (iM <= i2) {
                i(iM);
                bArrF = this.f;
                this.i = iM;
            } else {
                bArrF = f(iM);
            }
        }
        return E1.f2253a.a(bArrF, i, iM);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int t() throws C3211o0 {
        if (c()) {
            this.j = 0;
            return 0;
        }
        int iM = m();
        this.j = iM;
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
        int i = this.i;
        if (this.g - i < 4) {
            i(4);
            i = this.i;
        }
        byte[] bArr = this.f;
        this.i = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long x() throws C3211o0 {
        int i = this.i;
        if (this.g - i < 8) {
            i(8);
            i = this.i;
        }
        byte[] bArr = this.f;
        this.i = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final long y() throws C3211o0 {
        long j;
        long j2;
        long j3;
        int i = this.i;
        int i2 = this.g;
        long j4 = 0;
        if (i2 != i) {
            byte[] bArr = this.f;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.i = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << Ascii.SO) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                        if (i9 < 0) {
                            j = (-2080896) ^ i9;
                            i4 = i8;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (((long) bArr[i8]) << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i10 = i + 6;
                                long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (((long) bArr[i10]) << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i10 = i + 8;
                                        j7 = j6 ^ (((long) bArr[i4]) << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (((long) bArr[i10]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i11 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i11;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j = j7 ^ j2;
                                i4 = i10;
                            }
                            j = j3 ^ j6;
                        }
                    }
                }
                this.i = i4;
                return j;
            }
        }
        for (int i12 = 0; i12 < 64; i12 += 7) {
            if (this.i == this.g) {
                i(1);
            }
            byte[] bArr2 = this.f;
            int i13 = this.i;
            this.i = i13 + 1;
            byte b2 = bArr2[i13];
            j4 |= ((long) (b2 & 127)) << i12;
            if ((b2 & 128) == 0) {
                return j4;
            }
        }
        throw new C3211o0("CodedInputStream encountered a malformed varint.");
    }

    public final void z() {
        int i = this.g + this.h;
        this.g = i;
        int i2 = this.k + i;
        int i3 = this.l;
        if (i2 <= i3) {
            this.h = 0;
            return;
        }
        int i4 = i2 - i3;
        this.h = i4;
        this.g = i - i4;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int d(int i) throws C3211o0 {
        if (i < 0) {
            throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = this.k + this.i + i;
        int i3 = this.l;
        if (i2 > i3) {
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.l = i2;
        z();
        return i3;
    }

    public final byte[] f(int i) throws IOException {
        byte[] bArrG = g(i);
        if (bArrG != null) {
            return bArrG;
        }
        int i2 = this.i;
        int i3 = this.g;
        int length = i3 - i2;
        this.k += i3;
        this.i = 0;
        this.g = 0;
        ArrayList<byte[]> arrayListH = h(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.f, i2, bArr, 0, length);
        for (byte[] bArr2 : arrayListH) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    public final byte[] g(int i) throws IOException {
        if (i == 0) {
            return AbstractC3205m0.b;
        }
        if (i < 0) {
            throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = this.k;
        int i3 = this.i;
        int i4 = i2 + i3 + i;
        if (i4 - this.c > 0) {
            throw new C3211o0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i5 = this.l;
        if (i4 > i5) {
            j((i5 - i2) - i3);
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = this.g - i3;
        int i7 = i - i6;
        if (i7 >= 4096 && i7 > this.e.available()) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f, this.i, bArr, 0, i6);
        this.k += this.g;
        this.i = 0;
        this.g = 0;
        while (i6 < i) {
            int i8 = this.e.read(bArr, i6, i - i6);
            if (i8 == -1) {
                throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.k += i8;
            i6 += i8;
        }
        return bArr;
    }

    public final ArrayList h(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i3 = this.e.read(bArr, i2, iMin - i2);
                if (i3 == -1) {
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.k += i3;
                i2 += i3;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final void i(int i) throws C3211o0 {
        if (k(i)) {
            return;
        }
        if (i <= (this.c - this.k) - this.i) {
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new C3211o0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void j(int i) throws C3211o0 {
        int i2 = this.g;
        int i3 = this.i;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.i = i3 + i;
            return;
        }
        if (i < 0) {
            throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i5 = this.k;
        int i6 = i5 + i3;
        int i7 = i6 + i;
        int i8 = this.l;
        if (i7 > i8) {
            j((i8 - i5) - i3);
            throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.k = i6;
        this.g = 0;
        this.i = 0;
        while (i4 < i) {
            try {
                long j = i - i4;
                long jSkip = this.e.skip(j);
                if (jSkip < 0 || jSkip > j) {
                    throw new IllegalStateException(this.e.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                }
                if (jSkip == 0) {
                    break;
                } else {
                    i4 += (int) jSkip;
                }
            } catch (Throwable th) {
                this.k += i4;
                z();
                throw th;
            }
        }
        this.k += i4;
        z();
        if (i4 >= i) {
            return;
        }
        int i9 = this.g;
        int i10 = i9 - this.i;
        this.i = i9;
        i(1);
        while (true) {
            int i11 = i - i10;
            int i12 = this.g;
            if (i11 <= i12) {
                this.i = i11;
                return;
            } else {
                i10 += i12;
                this.i = i12;
                i(1);
            }
        }
    }

    public final boolean k(int i) throws IOException {
        int i2 = this.i;
        int i3 = i2 + i;
        int i4 = this.g;
        if (i3 <= i4) {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }
        int i5 = this.c;
        int i6 = this.k;
        if (i > (i5 - i6) - i2 || i6 + i2 + i > this.l) {
            return false;
        }
        if (i2 > 0) {
            if (i4 > i2) {
                byte[] bArr = this.f;
                System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
            }
            this.k += i2;
            this.g -= i2;
            this.i = 0;
        }
        InputStream inputStream = this.e;
        byte[] bArr2 = this.f;
        int i7 = this.g;
        int i8 = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.c - this.k) - i7));
        if (i8 == 0 || i8 < -1 || i8 > this.f.length) {
            throw new IllegalStateException(this.e.getClass() + "#read(byte[]) returned invalid result: " + i8 + "\nThe InputStream implementation is buggy.");
        }
        if (i8 <= 0) {
            return false;
        }
        this.g += i8;
        z();
        if (this.g >= i) {
            return true;
        }
        return k(i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final boolean c() {
        return this.i == this.g && !k(1);
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
            if (this.g - this.i >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.f;
                    int i4 = this.i;
                    this.i = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw new C3211o0("CodedInputStream encountered a malformed varint.");
            }
            while (i3 < 10) {
                if (this.i == this.g) {
                    i(1);
                }
                byte[] bArr2 = this.f;
                int i5 = this.i;
                this.i = i5 + 1;
                if (bArr2[i5] < 0) {
                    i3++;
                }
            }
            throw new C3211o0("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i2 == 1) {
            j(8);
            return true;
        }
        if (i2 == 2) {
            j(m());
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
            j(4);
            return true;
        }
        int i6 = C3211o0.f2292a;
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
    public final C3216q e() throws IOException {
        int iM = m();
        int i = this.g;
        int i2 = this.i;
        if (iM <= i - i2 && iM > 0) {
            byte[] bArr = this.f;
            C3216q c3216q = AbstractC3221s.b;
            AbstractC3221s.a(i2, i2 + iM, bArr.length);
            C3216q c3216q2 = new C3216q(AbstractC3221s.c.a(bArr, i2, iM));
            this.i += iM;
            return c3216q2;
        }
        if (iM == 0) {
            return AbstractC3221s.b;
        }
        byte[] bArrG = g(iM);
        if (bArrG != null) {
            int length = bArrG.length;
            AbstractC3221s.a(0, length, bArrG.length);
            return new C3216q(AbstractC3221s.c.a(bArrG, 0, length));
        }
        int i3 = this.i;
        int i4 = this.g;
        int length2 = i4 - i3;
        this.k += i4;
        this.i = 0;
        this.g = 0;
        ArrayList<byte[]> arrayListH = h(iM - length2);
        byte[] bArr2 = new byte[iM];
        System.arraycopy(this.f, i3, bArr2, 0, length2);
        for (byte[] bArr3 : arrayListH) {
            System.arraycopy(bArr3, 0, bArr2, length2, bArr3.length);
            length2 += bArr3.length;
        }
        C3216q c3216q3 = AbstractC3221s.b;
        return new C3216q(bArr2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3229w
    public final int a() {
        int i = this.l;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.k + this.i);
    }
}
