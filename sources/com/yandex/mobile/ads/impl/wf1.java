package com.yandex.mobile.ads.impl;

import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class wf1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f10562a;
    private int b;
    private int c;

    public final String j() {
        int i = this.c;
        int i2 = this.b;
        if (i - i2 == 0) {
            return null;
        }
        while (i2 < this.c) {
            byte b = this.f10562a[i2];
            int i3 = x82.f10629a;
            if (b == 10 || b == 13) {
                break;
            }
            i2++;
        }
        int i4 = this.b;
        if (i2 - i4 >= 3) {
            byte[] bArr = this.f10562a;
            if (bArr[i4] == -17 && bArr[i4 + 1] == -69 && bArr[i4 + 2] == -65) {
                this.b = i4 + 3;
            }
        }
        byte[] bArr2 = this.f10562a;
        int i5 = this.b;
        String strA = x82.a(bArr2, i5, i2 - i5);
        this.b = i2;
        int i6 = this.c;
        if (i2 == i6) {
            return strA;
        }
        byte[] bArr3 = this.f10562a;
        if (bArr3[i2] == 13) {
            int i7 = i2 + 1;
            this.b = i7;
            if (i7 == i6) {
                return strA;
            }
        }
        int i8 = this.b;
        if (bArr3[i8] == 10) {
            this.b = i8 + 1;
        }
        return strA;
    }

    public final String q() {
        int i = this.c;
        int i2 = this.b;
        if (i - i2 == 0) {
            return null;
        }
        while (i2 < this.c && this.f10562a[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.f10562a;
        int i3 = this.b;
        String strA = x82.a(bArr, i3, i2 - i3);
        this.b = i2;
        if (i2 >= this.c) {
            return strA;
        }
        this.b = i2 + 1;
        return strA;
    }

    public wf1() {
        this.f10562a = x82.f;
    }

    public wf1(int i) {
        this.f10562a = new byte[i];
        this.c = i;
    }

    public wf1(int i, byte[] bArr) {
        this.f10562a = bArr;
        this.c = i;
    }

    public final int a() {
        return this.c - this.b;
    }

    public final void a(int i) {
        byte[] bArr = this.f10562a;
        if (i > bArr.length) {
            this.f10562a = Arrays.copyOf(bArr, i);
        }
    }

    public final int e() {
        return this.c;
    }

    public final int d() {
        return this.b;
    }

    public wf1(byte[] bArr) {
        this.f10562a = bArr;
        this.c = bArr.length;
    }

    public final byte[] c() {
        return this.f10562a;
    }

    public final void c(int i) {
        byte[] bArr = this.f10562a;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        this.f10562a = bArr;
        this.c = i;
        this.b = 0;
    }

    public final int b() {
        return this.f10562a.length;
    }

    public final int g() {
        return this.f10562a[this.b] & 255;
    }

    public final char f() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        return (char) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public final int t() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public final int z() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i + 2;
        return (bArr[i2] & 255) | i3;
    }

    public final int o() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.b = i + 2;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public final short r() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i + 2;
        return (short) ((bArr[i2] & 255) | i3);
    }

    public final short m() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.b = i + 2;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    public final int w() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = i + 2;
        int i3 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
        this.b = i + 3;
        return (bArr[i2] & 255) | i3;
    }

    public final int i() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = i + 2;
        int i3 = ((bArr[i + 1] & 255) << 8) | (((bArr[i] & 255) << 24) >> 8);
        this.b = i + 3;
        return (bArr[i2] & 255) | i3;
    }

    public final void d(int i) {
        if (i >= 0 && i <= this.f10562a.length) {
            this.c = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final void e(int i) {
        if (i >= 0 && i <= this.c) {
            this.b = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final long v() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = i + 3;
        long j = ((((long) bArr[i]) & 255) << 24) | ((((long) bArr[i + 1]) & 255) << 16) | ((((long) bArr[i + 2]) & 255) << 8);
        this.b = i + 4;
        return (((long) bArr[i2]) & 255) | j;
    }

    public final long n() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = i + 3;
        long j = (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16);
        this.b = i + 4;
        return ((((long) bArr[i2]) & 255) << 24) | j;
    }

    public final int h() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24);
        int i3 = i + 3;
        int i4 = i2 | ((bArr[i + 2] & 255) << 8);
        this.b = i + 4;
        return (bArr[i3] & 255) | i4;
    }

    public final int k() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
        int i3 = i + 3;
        int i4 = i2 | ((bArr[i + 2] & 255) << 16);
        this.b = i + 4;
        return ((bArr[i3] & 255) << 24) | i4;
    }

    public final long p() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = i + 7;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
        this.b = i + 8;
        return (((long) bArr[i2]) & 255) | j;
    }

    public final long l() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = i + 7;
        long j = (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        this.b = i + 8;
        return ((((long) bArr[i2]) & 255) << 56) | j;
    }

    public final void a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f10562a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public final void a(int i, byte[] bArr) {
        this.f10562a = bArr;
        this.c = i;
        this.b = 0;
    }

    public final int u() {
        byte[] bArr = this.f10562a;
        int i = this.b;
        int i2 = (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
        this.b = i + 4;
        return i2;
    }

    public final int s() {
        return (t() << 21) | (t() << 14) | (t() << 7) | t();
    }

    public final int x() {
        int iH = h();
        if (iH >= 0) {
            return iH;
        }
        throw new IllegalStateException(oe.a("Top bit not zero: ", iH));
    }

    public final long y() {
        long jP = p();
        if (jP >= 0) {
            return jP;
        }
        throw new IllegalStateException("Top bit not zero: " + jP);
    }

    public final void f(int i) {
        e(this.b + i);
    }

    public final void a(byte[] bArr) {
        int length = bArr.length;
        this.f10562a = bArr;
        this.c = length;
        this.b = 0;
    }

    public final String a(int i, Charset charset) {
        String str = new String(this.f10562a, this.b, i, charset);
        this.b += i;
        return str;
    }

    public final long A() {
        int i;
        int i2;
        long j = this.f10562a[this.b];
        int i3 = 7;
        while (true) {
            if (i3 >= 0) {
                int i4 = 1 << i3;
                if ((((long) i4) & j) == 0) {
                    if (i3 < 6) {
                        j &= (long) (i4 - 1);
                        i2 = 7 - i3;
                        break;
                    }
                    if (i3 == 7) {
                        i2 = 1;
                        break;
                    }
                } else {
                    i3--;
                }
            }
            i2 = 0;
            break;
        }
        if (i2 != 0) {
            for (i = 1; i < i2; i++) {
                byte b = this.f10562a[this.b + i];
                if ((b & 192) != 128) {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                }
                j = (j << 6) | ((long) (b & 63));
            }
            this.b += i2;
            return j;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
    }

    public final String b(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.b;
        int i3 = (i2 + i) - 1;
        String strA = x82.a(this.f10562a, i2, (i3 >= this.c || this.f10562a[i3] != 0) ? i : i - 1);
        this.b += i;
        return strA;
    }
}
