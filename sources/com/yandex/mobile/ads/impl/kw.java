package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class kw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<jw> f9453a;

    public kw(List<jw> adapters) {
        Intrinsics.checkNotNullParameter(adapters, "adapters");
        this.f9453a = adapters;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof kw) && Intrinsics.areEqual(this.f9453a, ((kw) obj).f9453a);
    }

    public final int hashCode() {
        return this.f9453a.hashCode();
    }

    public final String toString() {
        return "DebugPanelAdUnitMediationData(adapters=" + this.f9453a + ")";
    }

    public final List<jw> a() {
        return this.f9453a;
    }
}
