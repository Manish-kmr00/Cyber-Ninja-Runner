package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ia0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ba0 f9194a;
    private final List<k90> b;

    public ia0(ba0 state, List<k90> items) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(items, "items");
        this.f9194a = state;
        this.b = items;
    }

    public final ba0 a() {
        return this.f9194a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ia0)) {
            return false;
        }
        ia0 ia0Var = (ia0) obj;
        return Intrinsics.areEqual(this.f9194a, ia0Var.f9194a) && Intrinsics.areEqual(this.b, ia0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f9194a.hashCode() * 31);
    }

    public final String toString() {
        return "FeedState(state=" + this.f9194a + ", items=" + this.b + ")";
    }

    public final ba0 c() {
        return this.f9194a;
    }

    public final List<k90> b() {
        return this.b;
    }
}
