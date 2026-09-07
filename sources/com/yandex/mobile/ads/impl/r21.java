package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r21 extends t21 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r21(s21 parentHtmlWebView, ah0 htmlWebViewListener, ie2 videoLifecycleListener, j21 impressionListener, j21 rewardListener, j21 onCloseButtonListener, t21.a htmlWebViewMraidListener, i21 mraidController) {
        super(parentHtmlWebView, htmlWebViewListener, htmlWebViewMraidListener, mraidController);
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        Intrinsics.checkNotNullParameter(videoLifecycleListener, "videoLifecycleListener");
        Intrinsics.checkNotNullParameter(impressionListener, "impressionListener");
        Intrinsics.checkNotNullParameter(rewardListener, "rewardListener");
        Intrinsics.checkNotNullParameter(onCloseButtonListener, "onCloseButtonListener");
        Intrinsics.checkNotNullParameter(htmlWebViewMraidListener, "htmlWebViewMraidListener");
        Intrinsics.checkNotNullParameter(mraidController, "mraidController");
        mraidController.a(videoLifecycleListener);
        mraidController.a((n11) impressionListener);
        mraidController.a((o11) rewardListener);
        mraidController.a((ve1) onCloseButtonListener);
    }
}
