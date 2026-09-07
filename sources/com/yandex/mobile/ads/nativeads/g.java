package com.yandex.mobile.ads.nativeads;

import com.monetization.ads.nativeads.CustomizableMediaView;
import com.yandex.mobile.ads.impl.b81;
import com.yandex.mobile.ads.impl.g71;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g {
    public static g71 a(NativeAdViewBinder binder) {
        Intrinsics.checkNotNullParameter(binder, "binder");
        return new g71(new g71.a(binder.getNativeAdView(), b81.c, MapsKt.emptyMap()).a(binder.getAgeView()).b(binder.getBodyView()).c(binder.getCallToActionView()).d(binder.getDomainView()).a(binder.getFaviconView()).b(binder.getFeedbackView()).c(binder.getIconView()).a((CustomizableMediaView) binder.getMediaView()).e(binder.getPriceView()).a(binder.getRatingView()).f(binder.getReviewCountView()).g(binder.getSponsoredView()).h(binder.getTitleView()).i(binder.getWarningView()), 0);
    }
}
