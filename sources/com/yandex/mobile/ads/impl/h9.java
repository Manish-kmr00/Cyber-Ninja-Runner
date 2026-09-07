package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class h9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9074a;
    private final int b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h9)) {
            return false;
        }
        h9 h9Var = (h9) obj;
        return this.f9074a == h9Var.f9074a && this.b == h9Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.f9074a) * 31);
    }

    public final String toString() {
        return "AdSize(width=" + this.f9074a + ", height=" + this.b + ")";
    }

    public h9(int i, int i2) {
        this.f9074a = i;
        this.b = i2;
    }

    public final int b() {
        return this.f9074a;
    }

    public final int a() {
        return this.b;
    }
}
