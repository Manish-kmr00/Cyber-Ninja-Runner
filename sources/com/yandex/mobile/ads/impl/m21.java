package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m21 implements vg0 {
    @Override // com.yandex.mobile.ads.impl.vg0
    public final ug0 a(pj parentHtmlWebView, ut1.b htmlWebViewListener, ne2 videoLifecycleListener, mk0 impressionListener) {
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        Intrinsics.checkNotNullParameter(videoLifecycleListener, "videoLifecycleListener");
        Intrinsics.checkNotNullParameter(impressionListener, "impressionListener");
        l21 l21Var = new l21(parentHtmlWebView, htmlWebViewListener, videoLifecycleListener, impressionListener, new t21.a(htmlWebViewListener), new i21(parentHtmlWebView));
        l21Var.a(htmlWebViewListener);
        return l21Var;
    }

    @Override // com.yandex.mobile.ads.impl.vg0
    public final dd0 a(md0 parentHtmlWebView, ed0 htmlWebViewListener, id0 rewardListener, uc0 onCloseButtonListener, id0 impressionListener) {
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        Intrinsics.checkNotNullParameter(rewardListener, "rewardListener");
        Intrinsics.checkNotNullParameter(onCloseButtonListener, "onCloseButtonListener");
        Intrinsics.checkNotNullParameter(impressionListener, "impressionListener");
        k21 k21Var = new k21(parentHtmlWebView, htmlWebViewListener, rewardListener, onCloseButtonListener, impressionListener, new t21.a(htmlWebViewListener), new i21(parentHtmlWebView));
        k21Var.a(htmlWebViewListener);
        return k21Var;
    }

    @Override // com.yandex.mobile.ads.impl.vg0
    public final ug0 a(s21 parentHtmlWebView, ah0 htmlWebViewListener, ie2 videoLifecycleListener, j21 impressionListener, j21 rewardListener, j21 onCloseButtonListener) {
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        Intrinsics.checkNotNullParameter(videoLifecycleListener, "videoLifecycleListener");
        Intrinsics.checkNotNullParameter(impressionListener, "impressionListener");
        Intrinsics.checkNotNullParameter(rewardListener, "rewardListener");
        Intrinsics.checkNotNullParameter(onCloseButtonListener, "onCloseButtonListener");
        r21 r21Var = new r21(parentHtmlWebView, htmlWebViewListener, videoLifecycleListener, impressionListener, rewardListener, onCloseButtonListener, new t21.a(htmlWebViewListener), new i21(parentHtmlWebView));
        r21Var.a(htmlWebViewListener);
        return r21Var;
    }
}
