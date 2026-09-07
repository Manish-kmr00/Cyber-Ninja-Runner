package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes.dex */
public final class n6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nz1 f9700a;
    private final pz1 b;
    private final long c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n6)) {
            return false;
        }
        n6 n6Var = (n6) obj;
        return this.f9700a == n6Var.f9700a && this.b == n6Var.b && this.c == n6Var.c;
    }

    public final int hashCode() {
        nz1 nz1Var = this.f9700a;
        int iHashCode = (nz1Var == null ? 0 : nz1Var.hashCode()) * 31;
        pz1 pz1Var = this.b;
        return Long.hashCode(this.c) + ((iHashCode + (pz1Var != null ? pz1Var.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "AdPodSkip(transitionStrategy=" + this.f9700a + ", visibility=" + this.b + ", delay=" + this.c + ")";
    }

    public n6(nz1 nz1Var, pz1 pz1Var, long j) {
        this.f9700a = nz1Var;
        this.b = pz1Var;
        this.c = j;
    }

    public final nz1 b() {
        return this.f9700a;
    }

    public final pz1 c() {
        return this.b;
    }

    public final long a() {
        return this.c;
    }
}
