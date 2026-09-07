package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class yd0 implements y00<ExtendedNativeAdView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m61 f10726a;
    private final wr b;
    private final pt c;
    private final lp1 d;
    private final dh e;
    private final g41 f;

    public yd0(m61 nativeAd, wr contentCloseListener, pt nativeAdEventListener, lp1 reporter, dh assetsNativeAdViewProviderCreator, g41 nativeAdAssetViewProviderById) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(assetsNativeAdViewProviderCreator, "assetsNativeAdViewProviderCreator");
        Intrinsics.checkNotNullParameter(nativeAdAssetViewProviderById, "nativeAdAssetViewProviderById");
        this.f10726a = nativeAd;
        this.b = contentCloseListener;
        this.c = nativeAdEventListener;
        this.d = reporter;
        this.e = assetsNativeAdViewProviderCreator;
        this.f = nativeAdAssetViewProviderById;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(ViewGroup viewGroup) {
        ExtendedNativeAdView nativeAdView = (ExtendedNativeAdView) viewGroup;
        Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
        try {
            this.f10726a.b(this.e.a(nativeAdView, this.f));
            this.f10726a.a(this.c);
        } catch (a61 e) {
            this.b.f();
            this.d.reportError("Failed to bind DivKit Fullscreen Native Ad", e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        this.f10726a.a((pt) null);
    }
}
