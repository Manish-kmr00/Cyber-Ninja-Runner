package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u61 f9780a;
    private final o8<?> b;
    private final o3 c;

    public static o41 a(o41 o41Var, u61 nativeAdResponse) {
        o8<?> adResponse = o41Var.b;
        o3 adConfiguration = o41Var.c;
        Intrinsics.checkNotNullParameter(nativeAdResponse, "nativeAdResponse");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        return new o41(adResponse, adConfiguration, nativeAdResponse);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o41)) {
            return false;
        }
        o41 o41Var = (o41) obj;
        return Intrinsics.areEqual(this.f9780a, o41Var.f9780a) && Intrinsics.areEqual(this.b, o41Var.b) && Intrinsics.areEqual(this.c, o41Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f9780a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "NativeAdBlock(nativeAdResponse=" + this.f9780a + ", adResponse=" + this.b + ", adConfiguration=" + this.c + ")";
    }

    public o41(o8 adResponse, o3 adConfiguration, u61 nativeAdResponse) {
        Intrinsics.checkNotNullParameter(nativeAdResponse, "nativeAdResponse");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.f9780a = nativeAdResponse;
        this.b = adResponse;
        this.c = adConfiguration;
    }

    public final u61 c() {
        return this.f9780a;
    }

    public final o8<?> b() {
        return this.b;
    }

    public final o3 a() {
        return this.c;
    }
}
