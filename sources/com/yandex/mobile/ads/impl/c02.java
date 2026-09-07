package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class c02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8554a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c02)) {
            return false;
        }
        c02 c02Var = (c02) obj;
        return this.f8554a == c02Var.f8554a && this.b == c02Var.b && this.c == c02Var.c && this.d == c02Var.d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.d) + wx1.a(this.c, wx1.a(this.b, Integer.hashCode(this.f8554a) * 31, 31), 31);
    }

    public final String toString() {
        return "SmartCenter(x=" + this.f8554a + ", y=" + this.b + ", width=" + this.c + ", height=" + this.d + ")";
    }

    public c02(int i, int i2, int i3, int i4) {
        this.f8554a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i3 * i4;
    }

    public final int d() {
        return this.f8554a;
    }

    public final int e() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final int b() {
        return this.d;
    }

    public final int a() {
        return this.e;
    }
}
