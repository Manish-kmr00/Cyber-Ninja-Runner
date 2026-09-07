package com.five_corp.ad.internal.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes10.dex */
public final class o extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.internal.layouter.e f1577a;
    public final /* synthetic */ com.five_corp.ad.internal.logger.a b;

    public o(com.five_corp.ad.internal.layouter.e eVar, com.five_corp.ad.internal.logger.a aVar) {
        this.f1577a = eVar;
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

    public boolean safedk_o_shouldOverrideUrlLoading_4bc1c1ab45f231a10c4dd3afa64d2957(WebView p0, String p1) {
        return r.a(Uri.parse(p1), this.f1577a, this.b);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders("com.five_corp.ad", view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("LINE|SafeDK: Execution> Lcom/five_corp/ad/internal/view/o;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_o_shouldOverrideUrlLoading_4bc1c1ab45f231a10c4dd3afa64d2957 = safedk_o_shouldOverrideUrlLoading_4bc1c1ab45f231a10c4dd3afa64d2957(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading("com.five_corp.ad", webView, str, zSafedk_o_shouldOverrideUrlLoading_4bc1c1ab45f231a10c4dd3afa64d2957);
        return zSafedk_o_shouldOverrideUrlLoading_4bc1c1ab45f231a10c4dd3afa64d2957;
    }
}
