package com.yandex.mobile.ads.impl;

import androidx.core.view.MotionEventCompat;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes9.dex */
public final class vf1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f10476a;
    private int b;
    private int c;
    private int d;

    public final long g() {
        int iB = b(4);
        int iB2 = b(32);
        int i = x82.f10629a;
        return ((((long) iB) & 4294967295L) << 32) | (((long) iB2) & 4294967295L);
    }

    public vf1() {
        this.f10476a = x82.f;
    }

    public vf1(int i, byte[] bArr) {
        this.f10476a = bArr;
        this.d = i;
    }

    public vf1(byte[] bArr) {
        this(bArr.length, bArr);
    }

    public final int b() {
        return ((this.d - this.b) * 8) - this.c;
    }

    public final int e() {
        return (this.b * 8) + this.c;
    }

    public final int d() {
        if (this.c == 0) {
            return this.b;
        }
        throw new IllegalStateException();
    }

    public final void h() {
        int i = this.c + 1;
        this.c = i;
        if (i == 8) {
            this.c = 0;
            this.b++;
        }
        a();
    }

    public final boolean f() {
        boolean z = (this.f10476a[this.b] & (128 >> this.c)) != 0;
        h();
        return z;
    }

    public final void c() {
        if (this.c == 0) {
            return;
        }
        this.c = 0;
        this.b++;
        a();
    }

    public final void d(int i) {
        int i2 = i / 8;
        int i3 = this.b + i2;
        this.b = i3;
        int i4 = (i - (i2 * 8)) + this.c;
        this.c = i4;
        if (i4 > 7) {
            this.b = i3 + 1;
            this.c = i4 - 8;
        }
        a();
    }

    public final int b(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.c += i;
        int i3 = 0;
        while (true) {
            i2 = this.c;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.c = i4;
            byte[] bArr = this.f10476a;
            int i5 = this.b;
            this.b = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.f10476a;
        int i6 = this.b;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.c = 0;
            this.b = i6 + 1;
        }
        a();
        return i7;
    }

    public final void b(byte[] bArr, int i) {
        if (this.c == 0) {
            System.arraycopy(this.f10476a, this.b, bArr, 0, i);
            this.b += i;
            a();
            return;
        }
        throw new IllegalStateException();
    }

    private void a() {
        int i = this.b;
        if (i >= 0) {
            int i2 = this.d;
            if (i < i2) {
                return;
            }
            if (i == i2 && this.c == 0) {
                return;
            }
        }
        throw new IllegalStateException();
    }

    public final void a(int i) {
        int i2 = i & 16383;
        int iMin = Math.min(8 - this.c, 14);
        int i3 = this.c;
        int i4 = (8 - i3) - iMin;
        int i5 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i3) | ((1 << i4) - 1);
        byte[] bArr = this.f10476a;
        int i6 = this.b;
        byte b = (byte) (i5 & bArr[i6]);
        bArr[i6] = b;
        int i7 = 14 - iMin;
        bArr[i6] = (byte) (b | ((i2 >>> i7) << i4));
        int i8 = i6 + 1;
        while (i7 > 8) {
            this.f10476a[i8] = (byte) (i2 >>> (i7 - 8));
            i7 -= 8;
            i8++;
        }
        int i9 = 8 - i7;
        byte[] bArr2 = this.f10476a;
        byte b2 = (byte) (bArr2[i8] & ((1 << i9) - 1));
        bArr2[i8] = b2;
        bArr2[i8] = (byte) (((i2 & ((1 << i7) - 1)) << i9) | b2);
        d(14);
        a();
    }

    public final void c(int i) {
        int i2 = i / 8;
        this.b = i2;
        this.c = i - (i2 * 8);
        a();
    }

    public final void a(byte[] bArr, int i) {
        int i2 = i >> 3;
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr2 = this.f10476a;
            int i4 = this.b;
            int i5 = i4 + 1;
            this.b = i5;
            byte b = bArr2[i4];
            int i6 = this.c;
            byte b2 = (byte) (b << i6);
            bArr[i3] = b2;
            bArr[i3] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | b2);
        }
        int i7 = i & 7;
        if (i7 == 0) {
            return;
        }
        byte b3 = (byte) (bArr[i2] & (255 >> i7));
        bArr[i2] = b3;
        int i8 = this.c;
        if (i8 + i7 > 8) {
            byte[] bArr3 = this.f10476a;
            int i9 = this.b;
            this.b = i9 + 1;
            bArr[i2] = (byte) (b3 | ((bArr3[i9] & 255) << i8));
            this.c = i8 - 8;
        }
        int i10 = this.c + i7;
        this.c = i10;
        byte[] bArr4 = this.f10476a;
        int i11 = this.b;
        bArr[i2] = (byte) (((byte) (((255 & bArr4[i11]) >> (8 - i10)) << (8 - i7))) | bArr[i2]);
        if (i10 == 8) {
            this.c = 0;
            this.b = i11 + 1;
        }
        a();
    }

    public final void e(int i) {
        if (this.c == 0) {
            this.b += i;
            a();
            return;
        }
        throw new IllegalStateException();
    }

    public final String a(int i, Charset charset) {
        byte[] bArr = new byte[i];
        b(bArr, i);
        return new String(bArr, charset);
    }

    public final void a(int i, byte[] bArr) {
        this.f10476a = bArr;
        this.b = 0;
        this.c = 0;
        this.d = i;
    }
}
