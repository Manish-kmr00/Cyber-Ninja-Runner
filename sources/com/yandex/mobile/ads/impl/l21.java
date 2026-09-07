package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class l21 extends t21 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l21(pj parentHtmlWebView, ut1.b htmlWebViewListener, ne2 videoLifecycleListener, mk0 impressionListener, t21.a htmlWebViewMraidListener, i21 mraidController) {
        super(parentHtmlWebView, htmlWebViewListener, htmlWebViewMraidListener, mraidController);
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        Intrinsics.checkNotNullParameter(videoLifecycleListener, "videoLifecycleListener");
        Intrinsics.checkNotNullParameter(impressionListener, "impressionListener");
        Intrinsics.checkNotNullParameter(htmlWebViewMraidListener, "htmlWebViewMraidListener");
        Intrinsics.checkNotNullParameter(mraidController, "mraidController");
        mraidController.a(videoLifecycleListener);
        mraidController.a(impressionListener);
    }
}
