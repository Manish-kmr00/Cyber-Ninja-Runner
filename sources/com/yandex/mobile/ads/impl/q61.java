package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v7 f9989a;
    private final y91 b;
    private final ba1 c;
    private final aq1<u61> d;
    private final int e;

    public q61(v7 adRequestData, y91 nativeResponseType, ba1 sourceType, aq1<u61> requestPolicy, int i) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(nativeResponseType, "nativeResponseType");
        Intrinsics.checkNotNullParameter(sourceType, "sourceType");
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        this.f9989a = adRequestData;
        this.b = nativeResponseType;
        this.c = sourceType;
        this.d = requestPolicy;
        this.e = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q61)) {
            return false;
        }
        q61 q61Var = (q61) obj;
        return Intrinsics.areEqual(this.f9989a, q61Var.f9989a) && this.b == q61Var.b && this.c == q61Var.c && Intrinsics.areEqual(this.d, q61Var.d) && this.e == q61Var.e;
    }

    public final int hashCode() {
        return Integer.hashCode(this.e) + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.f9989a.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "NativeAdRequestData(adRequestData=" + this.f9989a + ", nativeResponseType=" + this.b + ", sourceType=" + this.c + ", requestPolicy=" + this.d + ", adsCount=" + this.e + ")";
    }

    public final v7 a() {
        return this.f9989a;
    }

    public final y91 c() {
        return this.b;
    }

    public final ba1 e() {
        return this.c;
    }

    public final aq1<u61> d() {
        return this.d;
    }

    public final int b() {
        return this.e;
    }
}
