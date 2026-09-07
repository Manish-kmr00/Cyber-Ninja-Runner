package com.yandex.mobile.ads.impl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes12.dex */
public final class a52<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f8371a;
    private V[] b;
    private int c;
    private int d;

    private static Object[] b() {
        return new Object[10];
    }

    public final synchronized void a(Object obj, long j) {
        int i = this.d;
        if (i > 0) {
            if (j <= this.f8371a[((this.c + i) - 1) % this.b.length]) {
                a();
            }
        }
        int length = this.b.length;
        if (this.d >= length) {
            int i2 = length * 2;
            long[] jArr = new long[i2];
            V[] vArr = (V[]) new Object[i2];
            int i3 = this.c;
            int i4 = length - i3;
            System.arraycopy(this.f8371a, i3, jArr, 0, i4);
            System.arraycopy(this.b, this.c, vArr, 0, i4);
            int i5 = this.c;
            if (i5 > 0) {
                System.arraycopy(this.f8371a, 0, jArr, i4, i5);
                System.arraycopy(this.b, 0, vArr, i4, this.c);
            }
            this.f8371a = jArr;
            this.b = vArr;
            this.c = 0;
        }
        int i6 = this.c;
        int i7 = this.d;
        Object[] objArr = (V[]) this.b;
        int length2 = (i6 + i7) % objArr.length;
        this.f8371a[length2] = j;
        objArr[length2] = obj;
        this.d = i7 + 1;
    }

    public final synchronized V b(long j) {
        V v;
        v = null;
        while (true) {
            int i = this.d;
            if (i <= 0) {
                break;
            }
            long[] jArr = this.f8371a;
            int i2 = this.c;
            if (j - jArr[i2] < 0) {
                break;
            }
            if (i > 0) {
                V[] vArr = this.b;
                V v2 = vArr[i2];
                vArr[i2] = null;
                this.c = (i2 + 1) % vArr.length;
                this.d = i - 1;
                v = v2;
            } else {
                throw new IllegalStateException();
            }
        }
        return v;
    }

    public a52() {
        this(0);
    }

    public a52(int i) {
        this.f8371a = new long[10];
        this.b = (V[]) b();
    }

    public final synchronized int d() {
        return this.d;
    }

    public final synchronized V c() {
        V v;
        int i = this.d;
        v = null;
        if (i != 0) {
            if (i > 0) {
                V[] vArr = this.b;
                int i2 = this.c;
                V v2 = vArr[i2];
                vArr[i2] = null;
                this.c = (i2 + 1) % vArr.length;
                this.d = i - 1;
                v = v2;
            } else {
                throw new IllegalStateException();
            }
        }
        return v;
    }

    public final synchronized void a() {
        this.c = 0;
        this.d = 0;
        Arrays.fill(this.b, (Object) null);
    }

    public final synchronized V a(long j) {
        V v;
        long j2 = Long.MAX_VALUE;
        v = null;
        while (true) {
            int i = this.d;
            if (i <= 0) {
                break;
            }
            long[] jArr = this.f8371a;
            int i2 = this.c;
            long j3 = j - jArr[i2];
            if (j3 < 0 && (-j3) >= j2) {
                break;
            }
            if (i > 0) {
                V[] vArr = this.b;
                v = vArr[i2];
                vArr[i2] = null;
                this.c = (i2 + 1) % vArr.length;
                this.d = i - 1;
                j2 = j3;
            } else {
                throw new IllegalStateException();
            }
        }
        return v;
    }
}
