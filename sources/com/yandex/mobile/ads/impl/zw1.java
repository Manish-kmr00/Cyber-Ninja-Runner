package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes9.dex */
public final class zw1 {
    public static final zw1 c = new zw1(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10856a;
    public final long b;

    public final String toString() {
        return "[timeUs=" + this.f10856a + ", position=" + this.b + com.ironsource.b9.i.e;
    }

    public zw1(long j, long j2) {
        this.f10856a = j;
        this.b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zw1.class != obj.getClass()) {
            return false;
        }
        zw1 zw1Var = (zw1) obj;
        return this.f10856a == zw1Var.f10856a && this.b == zw1Var.b;
    }

    public final int hashCode() {
        return (((int) this.f10856a) * 31) + ((int) this.b);
    }
}
