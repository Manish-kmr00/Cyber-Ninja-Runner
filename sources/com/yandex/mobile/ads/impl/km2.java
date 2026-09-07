package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import com.yandex.mobile.ads.nativeads.NativeAdImage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class km2 implements NativeAdImage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qt f9432a;

    public km2(qt image) {
        Intrinsics.checkNotNullParameter(image, "image");
        this.f9432a = image;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof km2) && Intrinsics.areEqual(this.f9432a, ((km2) obj).f9432a);
    }

    public final int hashCode() {
        return this.f9432a.hashCode();
    }

    public final String toString() {
        return "YandexNativeAdImageAdapter(image=" + this.f9432a + ")";
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdImage
    public final Bitmap getBitmap() {
        return this.f9432a.a();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdImage
    public final int getWidth() {
        return this.f9432a.d();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdImage
    public final int getHeight() {
        return this.f9432a.b();
    }
}
