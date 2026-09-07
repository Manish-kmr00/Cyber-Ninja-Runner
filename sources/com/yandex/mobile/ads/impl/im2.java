package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.NativeAdAssets;
import com.yandex.mobile.ads.nativeads.NativeAdImage;
import com.yandex.mobile.ads.nativeads.NativeAdMedia;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class im2 implements NativeAdAssets {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ot f9244a;

    public im2(ot assets) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        this.f9244a = assets;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof im2) && Intrinsics.areEqual(this.f9244a, ((im2) obj).f9244a);
    }

    public final int hashCode() {
        return this.f9244a.hashCode();
    }

    public final String toString() {
        return "YandexNativeAdAssetsAdapter(assets=" + this.f9244a + ")";
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final String getAge() {
        return this.f9244a.a();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final String getBody() {
        return this.f9244a.b();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final String getCallToAction() {
        return this.f9244a.c();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final String getDomain() {
        return this.f9244a.d();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final NativeAdImage getFavicon() {
        qt qtVarE = this.f9244a.e();
        if (qtVarE != null) {
            return new km2(qtVarE);
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final boolean isFeedbackAvailable() {
        return this.f9244a.f();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final NativeAdImage getIcon() {
        qt qtVarG = this.f9244a.g();
        if (qtVarG != null) {
            return new km2(qtVarG);
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final NativeAdImage getImage() {
        qt qtVarH = this.f9244a.h();
        if (qtVarH != null) {
            return new km2(qtVarH);
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final NativeAdMedia getMedia() {
        ut utVarI = this.f9244a.i();
        if (utVarI != null) {
            return new nm2(utVarI);
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final String getPrice() {
        return this.f9244a.j();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final Float getRating() {
        return this.f9244a.k();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final String getReviewCount() {
        return this.f9244a.l();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final String getSponsored() {
        return this.f9244a.m();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final String getTitle() {
        return this.f9244a.n();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final String getWarning() {
        return this.f9244a.o();
    }
}
