package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class cd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f8590a;
    private final String b;
    private final zu1 c;

    public cd0(o8<?> adResponse, String htmlResponse, zu1 sdkFullscreenHtmlAd) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(htmlResponse, "htmlResponse");
        Intrinsics.checkNotNullParameter(sdkFullscreenHtmlAd, "sdkFullscreenHtmlAd");
        this.f8590a = adResponse;
        this.b = htmlResponse;
        this.c = sdkFullscreenHtmlAd;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cd0)) {
            return false;
        }
        cd0 cd0Var = (cd0) obj;
        return Intrinsics.areEqual(this.f8590a, cd0Var.f8590a) && Intrinsics.areEqual(this.b, cd0Var.b) && Intrinsics.areEqual(this.c, cd0Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + v3.a(this.b, this.f8590a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "FullScreenDataHolder(adResponse=" + this.f8590a + ", htmlResponse=" + this.b + ", sdkFullscreenHtmlAd=" + this.c + ")";
    }

    public final o8<?> a() {
        return this.f8590a;
    }

    public final zu1 b() {
        return this.c;
    }
}
