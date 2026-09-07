package com.fyber.inneractive.sdk.util;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes13.dex */
public final class O implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f2349a;

    public O(WebView webView) {
        this.f2349a = webView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2349a.getSettings().setDisplayZoomControls(false);
    }
}
