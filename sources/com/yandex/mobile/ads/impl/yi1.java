package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class yi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v4 f10739a;
    private final do0 b;

    public yi1(v4 playingAdInfo, do0 playingVideoAd) {
        Intrinsics.checkNotNullParameter(playingAdInfo, "playingAdInfo");
        Intrinsics.checkNotNullParameter(playingVideoAd, "playingVideoAd");
        this.f10739a = playingAdInfo;
        this.b = playingVideoAd;
    }

    public final v4 a() {
        return this.f10739a;
    }

    public final do0 b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yi1)) {
            return false;
        }
        yi1 yi1Var = (yi1) obj;
        return Intrinsics.areEqual(this.f10739a, yi1Var.f10739a) && Intrinsics.areEqual(this.b, yi1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f10739a.hashCode() * 31);
    }

    public final String toString() {
        return "PlayingAdData(playingAdInfo=" + this.f10739a + ", playingVideoAd=" + this.b + ")";
    }

    public final v4 c() {
        return this.f10739a;
    }

    public final do0 d() {
        return this.b;
    }
}
