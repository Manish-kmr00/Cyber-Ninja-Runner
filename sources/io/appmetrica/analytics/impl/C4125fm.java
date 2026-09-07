package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.fm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4125fm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11557a;

    public C4125fm(int i) {
        this.f11557a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C4125fm) && this.f11557a == ((C4125fm) obj).f11557a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11557a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f11557a + ')';
    }
}
