package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
final class mo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final t52 f9659a;
    private final int b;
    private final int c;
    private final long d;
    private final int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long[] k;
    private int[] l;

    public final xw1.a b(long j) {
        long j2 = 1;
        int i = (int) (j / ((this.d * j2) / ((long) this.e)));
        int iA = x82.a(this.l, i, true, true);
        int[] iArr = this.l;
        int i2 = iArr[iA];
        if (i2 == i) {
            zw1 zw1Var = new zw1(((this.d * j2) / ((long) this.e)) * ((long) i2), this.k[iA]);
            return new xw1.a(zw1Var, zw1Var);
        }
        long j3 = i2;
        long j4 = (this.d * j2) / ((long) this.e);
        long[] jArr = this.k;
        zw1 zw1Var2 = new zw1(j3 * j4, jArr[iA]);
        int i3 = iA + 1;
        return i3 < jArr.length ? new xw1.a(zw1Var2, new zw1(j4 * ((long) iArr[i3]), jArr[i3])) : new xw1.a(zw1Var2, zw1Var2);
    }

    public mo(int i, int i2, long j, int i3, t52 t52Var) {
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        hg.a(z);
        this.d = j;
        this.e = i3;
        this.f9659a = t52Var;
        this.b = a(i, i2 == 2 ? 1667497984 : 1651965952);
        this.c = i2 == 2 ? a(i, 1650720768) : -1;
        this.k = new long[512];
        this.l = new int[512];
    }

    public final void a(long j) {
        if (this.j == this.l.length) {
            long[] jArr = this.k;
            this.k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.l;
            this.l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.k;
        int i = this.j;
        jArr2[i] = j;
        this.l[i] = this.i;
        this.j = i + 1;
    }

    public final void b() {
        this.i++;
    }

    public final void c(long j) {
        if (this.j == 0) {
            this.h = 0;
        } else {
            this.h = this.l[x82.b(this.k, j, true)];
        }
    }

    public final void a() {
        this.k = Arrays.copyOf(this.k, this.j);
        this.l = Arrays.copyOf(this.l, this.j);
    }

    public final void b(int i) {
        this.f = i;
        this.g = i;
    }

    private static int a(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    public final boolean a(int i) {
        return this.b == i || this.c == i;
    }

    public final boolean a(tz tzVar) throws IOException {
        int i = this.g;
        int iB = i - this.f9659a.b(tzVar, i, false);
        this.g = iB;
        boolean z = iB == 0;
        if (z) {
            if (this.f > 0) {
                t52 t52Var = this.f9659a;
                int i2 = this.h;
                t52Var.a((this.d * ((long) i2)) / ((long) this.e), Arrays.binarySearch(this.l, i2) >= 0 ? 1 : 0, this.f, 0, null);
            }
            this.h++;
        }
        return z;
    }
}
