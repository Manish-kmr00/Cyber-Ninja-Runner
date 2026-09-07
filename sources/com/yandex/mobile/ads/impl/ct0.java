package com.yandex.mobile.ads.impl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public final class ct0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8638a;
    private long[] b;

    public ct0() {
        this(0);
    }

    public ct0(int i) {
        this.b = new long[32];
    }

    public final void a(long j) {
        int i = this.f8638a;
        long[] jArr = this.b;
        if (i == jArr.length) {
            this.b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.b;
        int i2 = this.f8638a;
        this.f8638a = i2 + 1;
        jArr2[i2] = j;
    }

    public final long[] b() {
        return Arrays.copyOf(this.b, this.f8638a);
    }

    public final long a(int i) {
        if (i >= 0 && i < this.f8638a) {
            return this.b[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.f8638a);
    }

    public final int a() {
        return this.f8638a;
    }
}
