package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<m6> f8967a;
    private final int b;
    private final int c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g6)) {
            return false;
        }
        g6 g6Var = (g6) obj;
        return Intrinsics.areEqual(this.f8967a, g6Var.f8967a) && this.b == g6Var.b && this.c == g6Var.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + wx1.a(this.b, this.f8967a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "AdPod(items=" + this.f8967a + ", closableAdPosition=" + this.b + ", rewardAdPosition=" + this.c + ")";
    }

    public g6(int i, int i2, List items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.f8967a = items;
        this.b = i;
        this.c = i2;
    }

    public final List<m6> b() {
        return this.f8967a;
    }

    public final int a() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }
}
