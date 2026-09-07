package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4028c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11486a;
    public final long b;

    public C4028c0(String str, long j) {
        this.f11486a = str;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C4028c0.class != obj.getClass()) {
            return false;
        }
        C4028c0 c4028c0 = (C4028c0) obj;
        if (this.b != c4028c0.b) {
            return false;
        }
        String str = this.f11486a;
        String str2 = c4028c0.f11486a;
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f11486a;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.b;
        return (iHashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
