package com.five_corp.ad.internal.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes10.dex */
public final class q extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.internal.layouter.e f1579a;
    public final /* synthetic */ com.five_corp.ad.internal.logger.a b;

    public q(com.five_corp.ad.internal.layouter.e eVar, com.five_corp.ad.internal.logger.a aVar) {
        this.f1579a = eVar;
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

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        String str = "onRenderProcessGone, didCrash:" + renderProcessGoneDetail.didCrash() + ", rendererPriorityAtExit: " + renderProcessGoneDetail.rendererPriorityAtExit();
        this.f1579a.h.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.P6, str, null, null));
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.five_corp.ad.internal.view.q$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                J.a(webView);
            }
        });
        return true;
    }

    public boolean safedk_q_shouldOverrideUrlLoading_236bae5b006cfd9c746fe8574f1a1573(WebView p0, WebResourceRequest p1) {
        return r.a(p1.getUrl(), this.f1579a, this.b);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders("com.five_corp.ad", view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("LINE|SafeDK: Execution> Lcom/five_corp/ad/internal/view/q;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_q_shouldOverrideUrlLoading_236bae5b006cfd9c746fe8574f1a1573 = safedk_q_shouldOverrideUrlLoading_236bae5b006cfd9c746fe8574f1a1573(webView, webResourceRequest);
        BrandSafetyUtils.onShouldOverrideUrlLoading("com.five_corp.ad", webView, webResourceRequest, zSafedk_q_shouldOverrideUrlLoading_236bae5b006cfd9c746fe8574f1a1573);
        return zSafedk_q_shouldOverrideUrlLoading_236bae5b006cfd9c746fe8574f1a1573;
    }
}
