package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9421a;
    private final int b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kh2)) {
            return false;
        }
        kh2 kh2Var = (kh2) obj;
        return Intrinsics.areEqual(this.f9421a, kh2Var.f9421a) && this.b == kh2Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f9421a.hashCode() * 31);
    }

    public final String toString() {
        return "ViewSizeKey(adUnitId=" + this.f9421a + ", screenOrientation=" + this.b + ")";
    }

    public kh2(int i, String adUnitId) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.f9421a = adUnitId;
        this.b = i;
    }

    public final String a() {
        return this.f9421a;
    }

    public final int b() {
        return this.b;
    }
}
