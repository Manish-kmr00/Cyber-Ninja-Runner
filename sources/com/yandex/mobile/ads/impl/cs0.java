package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class cs0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uz1 f8635a;
    private final o8<String> b;

    public cs0(uz1 sliderAd, o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(sliderAd, "sliderAd");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f8635a = sliderAd;
        this.b = adResponse;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cs0)) {
            return false;
        }
        cs0 cs0Var = (cs0) obj;
        return Intrinsics.areEqual(this.f8635a, cs0Var.f8635a) && Intrinsics.areEqual(this.b, cs0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f8635a.hashCode() * 31);
    }

    public final String toString() {
        return "LoadedFeedItem(sliderAd=" + this.f8635a + ", adResponse=" + this.b + ")";
    }

    public final uz1 b() {
        return this.f8635a;
    }

    public final o8<String> a() {
        return this.b;
    }
}
