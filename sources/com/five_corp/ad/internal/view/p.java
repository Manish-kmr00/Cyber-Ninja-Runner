package com.five_corp.ad.internal.view;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes10.dex */
public final class p extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.internal.layouter.e f1578a;
    public final /* synthetic */ com.five_corp.ad.internal.logger.a b;

    public p(com.five_corp.ad.internal.layouter.e eVar, com.five_corp.ad.internal.logger.a aVar) {
        this.f1578a = eVar;
        this.b = aVar;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded("com.five_corp.ad", view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        BrandSafetyUtils.onWebViewPageFinished("com.five_corp.ad", view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted("com.five_corp.ad", view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        BrandSafetyUtils.onWebViewReceivedError("com.five_corp.ad", view, errorCode, description, failingUrl);
    }

    public boolean safedk_p_shouldOverrideUrlLoading_c9e88c825b19e3e460a514bfc7de3cdd(WebView p0, WebResourceRequest p1) {
        return r.a(p1.getUrl(), this.f1578a, this.b);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders("com.five_corp.ad", view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("LINE|SafeDK: Execution> Lcom/five_corp/ad/internal/view/p;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_p_shouldOverrideUrlLoading_c9e88c825b19e3e460a514bfc7de3cdd = safedk_p_shouldOverrideUrlLoading_c9e88c825b19e3e460a514bfc7de3cdd(webView, webResourceRequest);
        BrandSafetyUtils.onShouldOverrideUrlLoading("com.five_corp.ad", webView, webResourceRequest, zSafedk_p_shouldOverrideUrlLoading_c9e88c825b19e3e460a514bfc7de3cdd);
        return zSafedk_p_shouldOverrideUrlLoading_c9e88c825b19e3e460a514bfc7de3cdd;
    }
}
