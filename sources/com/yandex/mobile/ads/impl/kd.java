package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes.dex */
public final class kd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9405a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof kd) && this.f9405a == ((kd) obj).f9405a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f9405a);
    }

    public final String toString() {
        return "AnalyticsIntegrationConfiguration(advertisingIdentifiersTracking=" + this.f9405a + ")";
    }

    public kd(boolean z) {
        this.f9405a = z;
    }

    public final boolean a() {
        return this.f9405a;
    }
}
