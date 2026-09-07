package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes4.dex */
public final class I9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11192a;

    public I9(long j) {
        this.f11192a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof I9) && this.f11192a == ((I9) obj).f11192a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f11192a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f11192a + ')';
    }
}
