package com.yandex.mobile.ads.impl;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
final class wo0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10580a = 0;
    private int b = -1;
    private int c = 0;
    private int[] d = new int[16];
    private int e = 15;

    public final void a(int i) {
        int i2 = this.c;
        int[] iArr = this.d;
        if (i2 == iArr.length) {
            int length = iArr.length << 1;
            if (length >= 0) {
                int[] iArr2 = new int[length];
                int length2 = iArr.length;
                int i3 = this.f10580a;
                int i4 = length2 - i3;
                System.arraycopy(iArr, i3, iArr2, 0, i4);
                System.arraycopy(this.d, 0, iArr2, i4, i3);
                this.f10580a = 0;
                this.b = this.c - 1;
                this.d = iArr2;
                this.e = length - 1;
            } else {
                throw new IllegalStateException();
            }
        }
        int i5 = (this.b + 1) & this.e;
        this.b = i5;
        this.d[i5] = i;
        this.c++;
    }

    public final int c() {
        int i = this.c;
        if (i != 0) {
            int[] iArr = this.d;
            int i2 = this.f10580a;
            int i3 = iArr[i2];
            this.f10580a = (i2 + 1) & this.e;
            this.c = i - 1;
            return i3;
        }
        throw new NoSuchElementException();
    }

    public final boolean b() {
        return this.c == 0;
    }

    public final void a() {
        this.f10580a = 0;
        this.b = -1;
        this.c = 0;
    }
}
