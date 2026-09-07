package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes14.dex */
public final class ya2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10717a;
    private final int b;
    private final int c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ya2)) {
            return false;
        }
        ya2 ya2Var = (ya2) obj;
        return this.f10717a == ya2Var.f10717a && this.b == ya2Var.b && this.c == ya2Var.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + wx1.a(this.b, Integer.hashCode(this.f10717a) * 31, 31);
    }

    public final String toString() {
        return "VersionInfo(majorVersion=" + this.f10717a + ", minorVersion=" + this.b + ", patchVersion=" + this.c + ")";
    }

    public ya2(int i, int i2, int i3) {
        this.f10717a = i;
        this.b = i2;
        this.c = i3;
    }

    public final int a() {
        return this.f10717a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }
}
