package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k21 extends t21 implements dd0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k21(md0 parentHtmlWebView, ed0 htmlWebViewListener, id0 mobileAdsSchemeRewardListener, uc0 onCloseButtonListener, id0 impressionListener, t21.a htmlWebViewMraidListener, i21 mraidController) {
        super(parentHtmlWebView, htmlWebViewListener, htmlWebViewMraidListener, mraidController);
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        Intrinsics.checkNotNullParameter(mobileAdsSchemeRewardListener, "mobileAdsSchemeRewardListener");
        Intrinsics.checkNotNullParameter(onCloseButtonListener, "onCloseButtonListener");
        Intrinsics.checkNotNullParameter(impressionListener, "impressionListener");
        Intrinsics.checkNotNullParameter(htmlWebViewMraidListener, "htmlWebViewMraidListener");
        Intrinsics.checkNotNullParameter(mraidController, "mraidController");
        mraidController.a(onCloseButtonListener);
        mraidController.a((o11) mobileAdsSchemeRewardListener);
        mraidController.a((n11) impressionListener);
    }

    @Override // com.yandex.mobile.ads.impl.dd0
    public final void a() {
        b().b();
    }
}
