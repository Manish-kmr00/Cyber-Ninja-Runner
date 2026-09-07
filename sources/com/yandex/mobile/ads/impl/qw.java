package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class qw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ow> f10053a;

    public qw(ArrayList adapters) {
        Intrinsics.checkNotNullParameter(adapters, "adapters");
        this.f10053a = adapters;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof qw) && Intrinsics.areEqual(this.f10053a, ((qw) obj).f10053a);
    }

    public final int hashCode() {
        return this.f10053a.hashCode();
    }

    public final String toString() {
        return "DebugPanelAdaptersData(adapters=" + this.f10053a + ")";
    }

    public final List<ow> a() {
        return this.f10053a;
    }
}
