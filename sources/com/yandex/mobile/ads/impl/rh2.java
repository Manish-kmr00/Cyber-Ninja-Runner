package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f10109a;

    public rh2(ArrayList viewableUrls) {
        Intrinsics.checkNotNullParameter(viewableUrls, "viewableUrls");
        this.f10109a = viewableUrls;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof rh2) && Intrinsics.areEqual(this.f10109a, ((rh2) obj).f10109a);
    }

    public final int hashCode() {
        return this.f10109a.hashCode();
    }

    public final String toString() {
        return "ViewableImpression(viewableUrls=" + this.f10109a + ")";
    }

    public final List<String> a() {
        return this.f10109a;
    }
}
