package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class fb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ml0> f8881a;

    public fb0(ArrayList installedPackages) {
        Intrinsics.checkNotNullParameter(installedPackages, "installedPackages");
        this.f8881a = installedPackages;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof fb0) && Intrinsics.areEqual(this.f8881a, ((fb0) obj).f8881a);
    }

    public final int hashCode() {
        return this.f8881a.hashCode();
    }

    public final String toString() {
        return "FilteringRule(installedPackages=" + this.f8881a + ")";
    }
}
