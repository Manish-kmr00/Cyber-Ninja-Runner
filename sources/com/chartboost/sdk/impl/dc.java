package com.chartboost.sdk.impl;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class dc extends t {
    public dc(String str, WebView webView) {
        super(str);
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        a(webView);
    }
}
