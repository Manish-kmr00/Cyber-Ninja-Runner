package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.video.playback.model.SkipInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ym2 implements SkipInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gd2 f10754a;

    public ym2(gd2 skipInfo) {
        Intrinsics.checkNotNullParameter(skipInfo, "skipInfo");
        this.f10754a = skipInfo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ym2) && Intrinsics.areEqual(this.f10754a, ((ym2) obj).f10754a);
    }

    public final int hashCode() {
        return this.f10754a.hashCode();
    }

    public final String toString() {
        return "YandexSkipInfo(skipInfo=" + this.f10754a + ")";
    }

    @Override // com.yandex.mobile.ads.video.playback.model.SkipInfo
    public final long getSkipOffset() {
        return this.f10754a.a();
    }
}
