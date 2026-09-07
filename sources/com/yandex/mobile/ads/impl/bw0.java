package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class bw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8541a;
    private final int b;
    private final int c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bw0)) {
            return false;
        }
        bw0 bw0Var = (bw0) obj;
        return this.f8541a == bw0Var.f8541a && this.b == bw0Var.b && this.c == bw0Var.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + wx1.a(this.b, Integer.hashCode(this.f8541a) * 31, 31);
    }

    public final String toString() {
        return "MediaFileInfo(width=" + this.f8541a + ", height=" + this.b + ", bitrate=" + this.c + ")";
    }

    public bw0(int i, int i2, int i3) {
        this.f8541a = i;
        this.b = i2;
        this.c = i3;
    }

    public final int c() {
        return this.f8541a;
    }

    public final int b() {
        return this.b;
    }

    public final int a() {
        return this.c;
    }
}
