package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes11.dex */
public final class ui2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f10389a;
    private final int b;
    private int c;
    private int d;

    public ui2(byte[] bArr) {
        this.f10389a = bArr;
        this.b = bArr.length;
    }

    public final boolean b() {
        boolean z = (((this.f10389a[this.c] & 255) >> this.d) & 1) == 1;
        b(1);
        return z;
    }

    public final int a() {
        return (this.c * 8) + this.d;
    }

    public final void b(int i) {
        int i2 = i / 8;
        int i3 = this.c + i2;
        this.c = i3;
        int i4 = (i - (i2 * 8)) + this.d;
        this.d = i4;
        if (i4 > 7) {
            this.c = i3 + 1;
            this.d = i4 - 8;
        }
        int i5 = this.c;
        if (i5 >= 0) {
            int i6 = this.b;
            if (i5 < i6) {
                return;
            }
            if (i5 == i6 && this.d == 0) {
                return;
            }
        }
        throw new IllegalStateException();
    }

    public final int a(int i) {
        int i2 = this.c;
        int iMin = Math.min(i, 8 - this.d);
        int i3 = i2 + 1;
        int i4 = ((this.f10389a[i2] & 255) >> this.d) & (255 >> (8 - iMin));
        while (iMin < i) {
            i4 |= (this.f10389a[i3] & 255) << iMin;
            iMin += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - i));
        b(i);
        return i5;
    }
}
