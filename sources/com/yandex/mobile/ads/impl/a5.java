package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f8369a = new LinkedHashMap();
    private final LinkedHashMap b = new LinkedHashMap();

    public final v4 a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return (v4) this.f8369a.get(videoAd);
    }

    public final do0 a(v4 adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        return (do0) this.b.get(adInfo);
    }

    public final void a(v4 adInfo, do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f8369a.put(videoAd, adInfo);
        this.b.put(adInfo, videoAd);
    }
}
