package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9166a;
    private final g2 b;
    private final long c;
    private final int d;

    public i2(boolean z, g2 requestPolicy, long j, int i) {
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        this.f9166a = z;
        this.b = requestPolicy;
        this.c = j;
        this.d = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i2)) {
            return false;
        }
        i2 i2Var = (i2) obj;
        return this.f9166a == i2Var.f9166a && this.b == i2Var.b && this.c == i2Var.c && this.d == i2Var.d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.d) + ((Long.hashCode(this.c) + ((this.b.hashCode() + (Boolean.hashCode(this.f9166a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "AdBlockerState(wasDetected=" + this.f9166a + ", requestPolicy=" + this.b + ", lastUpdateTime=" + this.c + ", failedRequestsCount=" + this.d + ")";
    }

    public final boolean d() {
        return this.f9166a;
    }

    public final g2 c() {
        return this.b;
    }

    public final long b() {
        return this.c;
    }

    public final int a() {
        return this.d;
    }
}
