package com.fyber.inneractive.sdk.activities;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f1608a;

    public e(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f1608a = inneractiveInternalBrowserActivity;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        this.f1608a.setTitle("Page is Loading...");
        this.f1608a.setProgress(i * 100);
        if (i == 100) {
            this.f1608a.setTitle(webView.getUrl());
        }
    }
}
