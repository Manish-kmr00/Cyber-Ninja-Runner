package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8463a;
    private final List<c01> b;
    private final long c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b01)) {
            return false;
        }
        b01 b01Var = (b01) obj;
        return Intrinsics.areEqual(this.f8463a, b01Var.f8463a) && Intrinsics.areEqual(this.b, b01Var.b) && this.c == b01Var.c;
    }

    public final int hashCode() {
        return Long.hashCode(this.c) + aa.a(this.b, this.f8463a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "MediationPrefetchAdUnitSettings(adUnitId=" + this.f8463a + ", networks=" + this.b + ", loadTimeoutMillis=" + this.c + ")";
    }

    public b01(long j, String adUnitId, List networks) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(networks, "networks");
        this.f8463a = adUnitId;
        this.b = networks;
        this.c = j;
    }

    public final List<c01> b() {
        return this.b;
    }

    public final long a() {
        return this.c;
    }
}
