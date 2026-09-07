package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i51 implements y00<ExtendedNativeAdView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m61 f9177a;
    private final wr b;
    private final pt c;
    private final to d;
    private final lp1 e;
    private final f41 f;
    private final dh g;

    public i51(m61 nativeAd, wr contentCloseListener, pt nativeAdEventListener, to clickConnector, lp1 reporter, f41 nativeAdAssetViewProvider, n61 divKitDesignAssetNamesProvider, dh assetsNativeAdViewProviderCreator) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(clickConnector, "clickConnector");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(nativeAdAssetViewProvider, "nativeAdAssetViewProvider");
        Intrinsics.checkNotNullParameter(divKitDesignAssetNamesProvider, "divKitDesignAssetNamesProvider");
        Intrinsics.checkNotNullParameter(assetsNativeAdViewProviderCreator, "assetsNativeAdViewProviderCreator");
        this.f9177a = nativeAd;
        this.b = contentCloseListener;
        this.c = nativeAdEventListener;
        this.d = clickConnector;
        this.e = reporter;
        this.f = nativeAdAssetViewProvider;
        this.g = assetsNativeAdViewProviderCreator;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(ViewGroup viewGroup) {
        ExtendedNativeAdView nativeAdView = (ExtendedNativeAdView) viewGroup;
        Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
        try {
            this.f9177a.b(this.g.a(nativeAdView, this.f), this.d);
            this.f9177a.a(this.c);
        } catch (a61 e) {
            this.b.f();
            this.e.reportError("Failed to bind DivKit Native Ad", e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        this.f9177a.a((pt) null);
    }
}
