package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.video.playback.model.AdPodInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cl2 implements AdPodInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rc2 f8623a;

    public cl2(rc2 adPodInfo) {
        Intrinsics.checkNotNullParameter(adPodInfo, "adPodInfo");
        this.f8623a = adPodInfo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof cl2) && Intrinsics.areEqual(this.f8623a, ((cl2) obj).f8623a);
    }

    public final int hashCode() {
        return this.f8623a.hashCode();
    }

    public final String toString() {
        return "YandexAdPodInfo(adPodInfo=" + this.f8623a + ")";
    }

    @Override // com.yandex.mobile.ads.video.playback.model.AdPodInfo
    public final int getAdsCount() {
        return this.f8623a.b();
    }

    @Override // com.yandex.mobile.ads.video.playback.model.AdPodInfo
    public final int getAdPosition() {
        return this.f8623a.a();
    }
}
