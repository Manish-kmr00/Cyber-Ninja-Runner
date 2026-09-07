package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes2.dex */
public final class m7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9601a;
    private final boolean b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m7)) {
            return false;
        }
        m7 m7Var = (m7) obj;
        return this.f9601a == m7Var.f9601a && this.b == m7Var.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Integer.hashCode(this.f9601a) * 31);
    }

    public final String toString() {
        return "AdQualityVerifierNetworkConfiguration(usagePercent=" + this.f9601a + ", disabled=" + this.b + ")";
    }

    public m7(boolean z, int i) {
        this.f9601a = i;
        this.b = z;
    }

    public final int b() {
        return this.f9601a;
    }

    public final boolean a() {
        return this.b;
    }
}
