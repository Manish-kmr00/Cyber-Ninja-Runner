package com.yandex.mobile.ads.impl;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes9.dex */
final class mo2 implements Runnable {
    final /* synthetic */ WebView b;
    final /* synthetic */ String c;

    @Override // java.lang.Runnable
    public final void run() {
        this.b.loadUrl(this.c);
    }

    mo2(WebView webView, String str) {
        this.b = webView;
        this.c = str;
    }
}
