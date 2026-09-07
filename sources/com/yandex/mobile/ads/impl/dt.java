package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f8729a;
    private final List<rb2<do0>> b;
    private final List<do0> c;
    private final String d;
    private final p2 e;
    private final et f;
    private final long g;

    public dt(uu1 sdkEnvironmentModule, ArrayList videoAdInfoList, ArrayList videoAds, String type, p2 adBreak, et adBreakPosition, long j) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(videoAdInfoList, "videoAdInfoList");
        Intrinsics.checkNotNullParameter(videoAds, "videoAds");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(adBreakPosition, "adBreakPosition");
        this.f8729a = sdkEnvironmentModule;
        this.b = videoAdInfoList;
        this.c = videoAds;
        this.d = type;
        this.e = adBreak;
        this.f = adBreakPosition;
        this.g = j;
    }

    public final void a(xz xzVar) {
    }

    public final xz c() {
        return null;
    }

    public final uu1 d() {
        return this.f8729a;
    }

    public final List<rb2<do0>> f() {
        return this.b;
    }

    public final List<do0> g() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public final p2 a() {
        return this.e;
    }

    public final et b() {
        return this.f;
    }

    public final String toString() {
        return "ad_break_#" + this.g;
    }
}
