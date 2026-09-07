package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9599a;
    private final n6 b;
    private final o6 c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m6)) {
            return false;
        }
        m6 m6Var = (m6) obj;
        return this.f9599a == m6Var.f9599a && Intrinsics.areEqual(this.b, m6Var.b) && this.c == m6Var.c;
    }

    public final int hashCode() {
        int iHashCode = Long.hashCode(this.f9599a) * 31;
        n6 n6Var = this.b;
        int iHashCode2 = (iHashCode + (n6Var == null ? 0 : n6Var.hashCode())) * 31;
        o6 o6Var = this.c;
        return iHashCode2 + (o6Var != null ? o6Var.hashCode() : 0);
    }

    public final String toString() {
        return "AdPodItem(duration=" + this.f9599a + ", skip=" + this.b + ", transitionPolicy=" + this.c + ")";
    }

    public m6(long j, n6 n6Var, o6 o6Var) {
        this.f9599a = j;
        this.b = n6Var;
        this.c = o6Var;
    }

    public final long a() {
        return this.f9599a;
    }

    public final n6 b() {
        return this.b;
    }

    public final o6 c() {
        return this.c;
    }
}
