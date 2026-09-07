package com.yandex.mobile.ads.impl;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes11.dex */
public final class rn2 extends g9 {
    public rn2(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        a(webView);
    }
}
