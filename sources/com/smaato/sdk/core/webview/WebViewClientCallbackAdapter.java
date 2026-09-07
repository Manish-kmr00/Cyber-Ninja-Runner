package com.smaato.sdk.core.webview;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

/* JADX INFO: loaded from: classes4.dex */
public class WebViewClientCallbackAdapter implements BaseWebViewClient.WebViewClientCallback {
    @Override // com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
    public void onGeneralError(int i, String str, String str2) {
    }

    @Override // com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
    public void onHttpError(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    @Override // com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
    public void onPageFinishedLoading(String str) {
    }

    @Override // com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
    public void onPageStartedLoading(String str) {
    }

    @Override // com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
    public void onRenderProcessGone() {
    }

    @Override // com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
    public boolean shouldOverrideUrlLoading(String str) {
        return false;
    }
}
