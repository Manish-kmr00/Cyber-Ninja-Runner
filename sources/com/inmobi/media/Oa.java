package com.inmobi.media;

/* JADX INFO: loaded from: classes6.dex */
public final class Oa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3159a;
    public final int b;

    public Oa(int i, int i2) {
        this.f3159a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Oa)) {
            return false;
        }
        Oa oa = (Oa) obj;
        return this.f3159a == oa.f3159a && this.b == oa.b && Double.compare(1.0d, 1.0d) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(1.0d) + ((Integer.hashCode(this.b) + (Integer.hashCode(this.f3159a) * 31)) * 31);
    }

    public final String toString() {
        return "RetryPolicy(maxNoOfRetries=" + this.f3159a + ", delayInMillis=" + this.b + ", delayFactor=1.0)";
    }
}
