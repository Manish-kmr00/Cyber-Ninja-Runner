package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class E7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11118a;
    public final int b;

    public E7(int i, long j) {
        this.f11118a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E7)) {
            return false;
        }
        E7 e7 = (E7) obj;
        return this.f11118a == e7.f11118a && this.b == e7.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f11118a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f11118a + ", exponent=" + this.b + ')';
    }
}
