package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes12.dex */
public final class df0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f8689a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof df0) && this.f8689a == ((df0) obj).f8689a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f8689a);
    }

    public final String toString() {
        return "HandledAction(shouldTrackClick=" + this.f8689a + ")";
    }

    public df0(boolean z) {
        this.f8689a = z;
    }

    public final boolean a() {
        return this.f8689a;
    }
}
