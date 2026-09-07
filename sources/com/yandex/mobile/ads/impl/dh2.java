package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes8.dex */
public final class dh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8695a;
    private final int b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dh2)) {
            return false;
        }
        dh2 dh2Var = (dh2) obj;
        return this.f8695a == dh2Var.f8695a && this.b == dh2Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.f8695a) * 31);
    }

    public final String toString() {
        return "ViewSize(width=" + this.f8695a + ", height=" + this.b + ")";
    }

    public dh2(int i, int i2) {
        this.f8695a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.f8695a;
    }
}
