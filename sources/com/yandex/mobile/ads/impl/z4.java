package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f10788a = new LinkedHashMap();
    private final LinkedHashMap b = new LinkedHashMap();

    public final u4 a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return (u4) this.f10788a.get(videoAd);
    }

    public final do0 a(u4 adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        return (do0) this.b.get(adInfo);
    }

    public final void a(u4 adInfo, do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f10788a.put(videoAd, adInfo);
        this.b.put(adInfo, videoAd);
    }
}
