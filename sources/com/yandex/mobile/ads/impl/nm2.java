package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.NativeAdMedia;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class nm2 implements NativeAdMedia {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ut f9744a;

    public nm2(ut media) {
        Intrinsics.checkNotNullParameter(media, "media");
        this.f9744a = media;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof nm2) && Intrinsics.areEqual(this.f9744a, ((nm2) obj).f9744a);
    }

    public final int hashCode() {
        return this.f9744a.hashCode();
    }

    public final String toString() {
        return "YandexNativeAdMediaAdapter(media=" + this.f9744a + ")";
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdMedia
    public final float getAspectRatio() {
        return this.f9744a.a();
    }
}
