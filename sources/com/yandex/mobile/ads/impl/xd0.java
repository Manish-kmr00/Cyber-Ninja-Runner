package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class xd0 implements y00<ExtendedNativeAdView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y00<ExtendedNativeAdView> f10644a;

    public xd0(m61 nativeAdPrivate, wr contentCloseListener, pt nativeAdEventListener, to clickConnector, lp1 reporter, y00<ExtendedNativeAdView> divKitAdBinder) {
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(clickConnector, "clickConnector");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(divKitAdBinder, "divKitAdBinder");
        this.f10644a = divKitAdBinder;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(ViewGroup viewGroup) {
        ExtendedNativeAdView fullscreenNativeAdView = (ExtendedNativeAdView) viewGroup;
        Intrinsics.checkNotNullParameter(fullscreenNativeAdView, "fullscreenNativeAdView");
        this.f10644a.a(fullscreenNativeAdView);
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        this.f10644a.c();
    }
}
