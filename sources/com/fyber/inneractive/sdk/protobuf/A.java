package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes13.dex */
public final class A extends B {
    public final byte[] d;
    public final int e;
    public int f;
    public final OutputStream g;

    public A(OutputStream outputStream, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i, 20);
        this.d = new byte[iMax];
        this.e = iMax;
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.g = outputStream;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void a(int i, int i2) {
        j(14);
        e(i, 5);
        h(i2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void b(int i, int i2) {
        j(20);
        e(i, 0);
        if (i2 >= 0) {
            i(i2);
        } else {
            f(i2);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void c(int i, int i2) {
        j(5);
        i((i << 3) | i2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void d(int i, int i2) {
        j(20);
        e(i, 0);
        i(i2);
    }

    public final void e(int i, int i2) {
        i((i << 3) | i2);
    }

    public final void f(long j) {
        if (!B.c) {
            while ((j & (-128)) != 0) {
                byte[] bArr = this.d;
                int i = this.f;
                this.f = i + 1;
                bArr[i] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            }
            byte[] bArr2 = this.d;
            int i2 = this.f;
            this.f = i2 + 1;
            bArr2[i2] = (byte) j;
            return;
        }
        while ((j & (-128)) != 0) {
            byte[] bArr3 = this.d;
            int i3 = this.f;
            this.f = i3 + 1;
            y1.c.a((Object) bArr3, y1.f + ((long) i3), (byte) ((((int) j) & 127) | 128));
            j >>>= 7;
        }
        byte[] bArr4 = this.d;
        int i4 = this.f;
        this.f = i4 + 1;
        y1.c.a((Object) bArr4, y1.f + ((long) i4), (byte) j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void g(int i) {
        j(5);
        i(i);
    }

    public final void h(int i) {
        byte[] bArr = this.d;
        int i2 = this.f;
        int i3 = i2 + 1;
        this.f = i3;
        bArr[i2] = (byte) (i & 255);
        int i4 = i2 + 2;
        this.f = i4;
        bArr[i3] = (byte) ((i >> 8) & 255);
        int i5 = i2 + 3;
        this.f = i5;
        bArr[i4] = (byte) ((i >> 16) & 255);
        this.f = i2 + 4;
        bArr[i5] = (byte) ((i >> 24) & 255);
    }

    public final void i(int i) {
        if (!B.c) {
            while ((i & (-128)) != 0) {
                byte[] bArr = this.d;
                int i2 = this.f;
                this.f = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                i >>>= 7;
            }
            byte[] bArr2 = this.d;
            int i3 = this.f;
            this.f = i3 + 1;
            bArr2[i3] = (byte) i;
            return;
        }
        while ((i & (-128)) != 0) {
            byte[] bArr3 = this.d;
            int i4 = this.f;
            this.f = i4 + 1;
            y1.c.a((Object) bArr3, y1.f + ((long) i4), (byte) ((i & 127) | 128));
            i >>>= 7;
        }
        byte[] bArr4 = this.d;
        int i5 = this.f;
        this.f = i5 + 1;
        y1.c.a((Object) bArr4, y1.f + ((long) i5), (byte) i);
    }

    public final void j(int i) {
        if (this.e - this.f < i) {
            a();
        }
    }

    public final void e(long j) {
        byte[] bArr = this.d;
        int i = this.f;
        int i2 = i + 1;
        this.f = i2;
        bArr[i] = (byte) (j & 255);
        int i3 = i + 2;
        this.f = i3;
        bArr[i2] = (byte) ((j >> 8) & 255);
        int i4 = i + 3;
        this.f = i4;
        bArr[i3] = (byte) ((j >> 16) & 255);
        int i5 = i + 4;
        this.f = i5;
        bArr[i4] = (byte) (255 & (j >> 24));
        int i6 = i + 5;
        this.f = i6;
        bArr[i5] = (byte) (((int) (j >> 32)) & 255);
        int i7 = i + 6;
        this.f = i7;
        bArr[i6] = (byte) (((int) (j >> 40)) & 255);
        int i8 = i + 7;
        this.f = i8;
        bArr[i7] = (byte) (((int) (j >> 48)) & 255);
        this.f = i + 8;
        bArr[i8] = (byte) (((int) (j >> 56)) & 255);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void c(long j) {
        j(8);
        e(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void a(int i, long j) {
        j(18);
        e(i, 1);
        e(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void d(long j) {
        j(10);
        f(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void a(int i, boolean z) {
        j(11);
        e(i, 0);
        byte b = z ? (byte) 1 : (byte) 0;
        byte[] bArr = this.d;
        int i2 = this.f;
        this.f = i2 + 1;
        bArr[i2] = b;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void b(int i, long j) {
        j(20);
        e(i, 0);
        f(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void a(String str, int i) throws IOException {
        c(i, 2);
        b(str);
    }

    public final void b(AbstractC3221s abstractC3221s) {
        int size = abstractC3221s.size();
        j(5);
        i(size);
        abstractC3221s.a(this);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void e(int i) {
        j(4);
        h(i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void f(int i) {
        if (i >= 0) {
            j(5);
            i(i);
        } else {
            j(10);
            f(i);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void a(int i, AbstractC3221s abstractC3221s) {
        c(i, 2);
        b(abstractC3221s);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void a(int i, E0 e0, U0 u0) {
        c(i, 2);
        int serializedSize = ((AbstractC3171b) e0).getSerializedSize(u0);
        j(5);
        i(serializedSize);
        u0.a((Object) e0, this.f2250a);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void b(int i, AbstractC3221s abstractC3221s) {
        c(1, 3);
        d(2, i);
        c(3, 2);
        b(abstractC3221s);
        c(1, 4);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void a(int i, E0 e0) {
        c(1, 3);
        d(2, i);
        c(3, 2);
        a(e0);
        c(1, 4);
    }

    public final void b(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int iC = B.c(length);
            int i = iC + length;
            int i2 = this.e;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iA = E1.f2253a.a(str, bArr, 0, length);
                j(5);
                i(iA);
                b(bArr, 0, iA);
                return;
            }
            if (i > i2 - this.f) {
                a();
            }
            int iC2 = B.c(str.length());
            int i3 = this.f;
            try {
                if (iC2 == iC) {
                    int i4 = i3 + iC2;
                    this.f = i4;
                    int iA2 = E1.f2253a.a(str, this.d, i4, this.e - i4);
                    this.f = i3;
                    i((iA2 - i3) - iC2);
                    this.f = iA2;
                } else {
                    int iA3 = E1.a(str);
                    i(iA3);
                    this.f = E1.f2253a.a(str, this.d, this.f, iA3);
                }
            } catch (C1 e) {
                this.f = i3;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new C3235z(e2);
            }
        } catch (C1 e3) {
            a(str, e3);
        }
    }

    public final void a(E0 e0) {
        int serializedSize = e0.getSerializedSize();
        j(5);
        i(serializedSize);
        e0.writeTo(this);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.B
    public final void a(byte b) {
        if (this.f == this.e) {
            a();
        }
        byte[] bArr = this.d;
        int i = this.f;
        this.f = i + 1;
        bArr[i] = b;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3198k
    public final void a(byte[] bArr, int i, int i2) throws IOException {
        b(bArr, i, i2);
    }

    public final void a() {
        this.g.write(this.d, 0, this.f);
        this.f = 0;
    }

    public final void b(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.e;
        int i4 = this.f;
        int i5 = i3 - i4;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, this.d, i4, i2);
            this.f += i2;
            return;
        }
        System.arraycopy(bArr, i, this.d, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f = this.e;
        a();
        if (i7 <= this.e) {
            System.arraycopy(bArr, i6, this.d, 0, i7);
            this.f = i7;
        } else {
            this.g.write(bArr, i6, i7);
        }
    }
}
