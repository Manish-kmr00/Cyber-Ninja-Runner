package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class tz1 implements y00<ExtendedNativeAdView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uz1 f10341a;
    private final wr b;
    private final pt c;
    private final to d;
    private final lp1 e;
    private final f41 f;
    private final dh g;

    public tz1(uz1 sliderAd, wr contentCloseListener, pt nativeAdEventListener, to clickConnector, lp1 reporter, f41 nativeAdAssetViewProvider, n61 divKitDesignAssetNamesProvider, dh assetsNativeAdViewProviderCreator) {
        Intrinsics.checkNotNullParameter(sliderAd, "sliderAd");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(clickConnector, "clickConnector");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(nativeAdAssetViewProvider, "nativeAdAssetViewProvider");
        Intrinsics.checkNotNullParameter(divKitDesignAssetNamesProvider, "divKitDesignAssetNamesProvider");
        Intrinsics.checkNotNullParameter(assetsNativeAdViewProviderCreator, "assetsNativeAdViewProviderCreator");
        this.f10341a = sliderAd;
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
            this.f10341a.a(this.g.a(nativeAdView, this.f), this.d);
            d32 d32Var = new d32(this.c);
            Iterator it = this.f10341a.d().iterator();
            while (it.hasNext()) {
                ((m61) it.next()).a(d32Var);
            }
            this.f10341a.b(this.c);
        } catch (a61 e) {
            this.b.f();
            this.e.reportError("Failed to bind DivKit Slider Ad", e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        this.f10341a.b((pt) null);
        Iterator it = this.f10341a.d().iterator();
        while (it.hasNext()) {
            ((m61) it.next()).a((pt) null);
        }
    }
}
