package com.iab.omid.library.mmadbridge.publisher;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class a extends AdSessionStatePublisher {
    public a(String str, WebView webView) {
        super(str);
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        a(webView);
    }
}
