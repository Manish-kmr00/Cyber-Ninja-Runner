package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes4.dex */
public final class H2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G2 f11171a;
    public final Boolean b;

    public H2(G2 g2, Boolean bool) {
        this.f11171a = g2;
        this.b = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || H2.class != obj.getClass()) {
            return false;
        }
        H2 h2 = (H2) obj;
        if (this.f11171a != h2.f11171a) {
            return false;
        }
        Boolean bool = this.b;
        if (bool != null) {
            return bool.equals(h2.b);
        }
        return h2.b == null;
    }

    public final int hashCode() {
        G2 g2 = this.f11171a;
        int iHashCode = (g2 != null ? g2.hashCode() : 0) * 31;
        Boolean bool = this.b;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }
}
