package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes4.dex */
public final class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10447a;
    private final int b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v4)) {
            return false;
        }
        v4 v4Var = (v4) obj;
        return this.f10447a == v4Var.f10447a && this.b == v4Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.f10447a) * 31);
    }

    public final String toString() {
        return "AdInfo(adGroupIndex=" + this.f10447a + ", adIndexInAdGroup=" + this.b + ")";
    }

    public v4(int i, int i2) {
        this.f10447a = i;
        this.b = i2;
    }

    public final int a() {
        return this.f10447a;
    }

    public final int b() {
        return this.b;
    }
}
