package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes4.dex */
public final class u4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10355a;
    private final int b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u4)) {
            return false;
        }
        u4 u4Var = (u4) obj;
        return this.f10355a == u4Var.f10355a && this.b == u4Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.f10355a) * 31);
    }

    public final String toString() {
        return "AdInfo(adGroupIndex=" + this.f10355a + ", adIndexInAdGroup=" + this.b + ")";
    }

    public u4(int i, int i2) {
        this.f10355a = i;
        this.b = i2;
    }

    public final int a() {
        return this.f10355a;
    }

    public final int b() {
        return this.b;
    }
}
