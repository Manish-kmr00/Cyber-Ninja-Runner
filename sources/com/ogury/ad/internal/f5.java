package com.ogury.ad.internal;

import android.net.Uri;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public class f5 {
    public void a() {
    }

    public void a(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
    }

    public void b(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    public void c(WebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public boolean d(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        return true;
    }

    public void a(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    public void b(WebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void a(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public boolean b(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return false;
    }

    public void a(boolean z, Uri failingUri) {
        Intrinsics.checkNotNullParameter(failingUri, "failingUri");
    }
}
