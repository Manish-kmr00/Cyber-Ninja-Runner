package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class c7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8573a;
    private final boolean b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c7)) {
            return false;
        }
        c7 c7Var = (c7) obj;
        return this.f8573a == c7Var.f8573a && this.b == c7Var.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Integer.hashCode(this.f8573a) * 31);
    }

    public final String toString() {
        return "AdQualityVerificationNetworkConfiguration(usagePercent=" + this.f8573a + ", disabled=" + this.b + ")";
    }

    public c7(boolean z, int i) {
        this.f8573a = i;
        this.b = z;
    }

    public final int b() {
        return this.f8573a;
    }

    public final boolean a() {
        return this.b;
    }
}
