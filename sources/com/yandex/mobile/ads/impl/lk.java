package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class lk implements vg0 {
    @Override // com.yandex.mobile.ads.impl.vg0
    public final ug0 a(pj parentHtmlWebView, ut1.b htmlWebViewListener, ne2 videoLifecycleListener, mk0 impressionListener) {
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        Intrinsics.checkNotNullParameter(videoLifecycleListener, "videoLifecycleListener");
        Intrinsics.checkNotNullParameter(impressionListener, "impressionListener");
        kk kkVar = new kk(parentHtmlWebView);
        kkVar.a(htmlWebViewListener);
        return kkVar;
    }

    @Override // com.yandex.mobile.ads.impl.vg0
    public final dd0 a(md0 parentHtmlWebView, ed0 htmlWebViewListener, id0 rewardListener, uc0 onCloseButtonListener, id0 impressionListener) {
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        Intrinsics.checkNotNullParameter(rewardListener, "rewardListener");
        Intrinsics.checkNotNullParameter(onCloseButtonListener, "onCloseButtonListener");
        Intrinsics.checkNotNullParameter(impressionListener, "impressionListener");
        jk jkVar = new jk(parentHtmlWebView);
        jkVar.a(htmlWebViewListener);
        return jkVar;
    }

    @Override // com.yandex.mobile.ads.impl.vg0
    public final ug0 a(s21 parentHtmlWebView, ah0 htmlWebViewListener, ie2 videoLifecycleListener, j21 impressionListener, j21 rewardListener, j21 onCloseButtonListener) {
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        Intrinsics.checkNotNullParameter(videoLifecycleListener, "videoLifecycleListener");
        Intrinsics.checkNotNullParameter(impressionListener, "impressionListener");
        Intrinsics.checkNotNullParameter(rewardListener, "rewardListener");
        Intrinsics.checkNotNullParameter(onCloseButtonListener, "onCloseButtonListener");
        kk kkVar = new kk(parentHtmlWebView);
        kkVar.a(htmlWebViewListener);
        return kkVar;
    }
}
