package com.fyber.inneractive.sdk.util;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes13.dex */
public abstract class Q {
    public static void a(WebView webView, String str) {
        webView.evaluateJavascript(str, null);
    }
}
