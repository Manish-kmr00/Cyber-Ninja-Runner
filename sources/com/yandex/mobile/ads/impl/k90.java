package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k90 extends fa0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uz1 f9394a;
    private final o8<String> b;
    private final List<rk1> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k90(uz1 sliderAd, o8 adResponse, ArrayList preloadedDivKitDesigns) {
        super(0);
        Intrinsics.checkNotNullParameter(sliderAd, "sliderAd");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(preloadedDivKitDesigns, "preloadedDivKitDesigns");
        this.f9394a = sliderAd;
        this.b = adResponse;
        this.c = preloadedDivKitDesigns;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k90)) {
            return false;
        }
        k90 k90Var = (k90) obj;
        return Intrinsics.areEqual(this.f9394a, k90Var.f9394a) && Intrinsics.areEqual(this.b, k90Var.b) && Intrinsics.areEqual(this.c, k90Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f9394a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "FeedItem(sliderAd=" + this.f9394a + ", adResponse=" + this.b + ", preloadedDivKitDesigns=" + this.c + ")";
    }

    public final uz1 c() {
        return this.f9394a;
    }

    public final o8<String> a() {
        return this.b;
    }

    public final List<rk1> b() {
        return this.c;
    }
}
