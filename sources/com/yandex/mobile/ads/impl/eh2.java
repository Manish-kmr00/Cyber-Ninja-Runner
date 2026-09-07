package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes11.dex */
public final class eh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8801a;
    private final int b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eh2)) {
            return false;
        }
        eh2 eh2Var = (eh2) obj;
        return this.f8801a == eh2Var.f8801a && this.b == eh2Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.f8801a) * 31);
    }

    public final String toString() {
        return "ViewSize(width=" + this.f8801a + ", height=" + this.b + ")";
    }

    public eh2(int i, int i2) {
        this.f8801a = i;
        this.b = i2;
    }

    public final int b() {
        return this.f8801a;
    }

    public final int a() {
        return this.b;
    }
}
