package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u4 f10657a;
    private final do0 b;

    public xi1(u4 playingAdInfo, do0 playingVideoAd) {
        Intrinsics.checkNotNullParameter(playingAdInfo, "playingAdInfo");
        Intrinsics.checkNotNullParameter(playingVideoAd, "playingVideoAd");
        this.f10657a = playingAdInfo;
        this.b = playingVideoAd;
    }

    public final u4 a() {
        return this.f10657a;
    }

    public final do0 b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xi1)) {
            return false;
        }
        xi1 xi1Var = (xi1) obj;
        return Intrinsics.areEqual(this.f10657a, xi1Var.f10657a) && Intrinsics.areEqual(this.b, xi1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f10657a.hashCode() * 31);
    }

    public final String toString() {
        return "PlayingAdData(playingAdInfo=" + this.f10657a + ", playingVideoAd=" + this.b + ")";
    }

    public final u4 c() {
        return this.f10657a;
    }

    public final do0 d() {
        return this.b;
    }
}
