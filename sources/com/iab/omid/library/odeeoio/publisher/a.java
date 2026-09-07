package com.iab.omid.library.odeeoio.publisher;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes10.dex */
public class a extends AdSessionStatePublisher {
    public a(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        a(webView);
    }
}
