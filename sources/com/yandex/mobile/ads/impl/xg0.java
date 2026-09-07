package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public class xg0 extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final yg0 f10652a;
    private final pj2 b;

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.y, view, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        super.onPageFinished(view, url);
        this.f10652a.a();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.y, view, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView view, int i, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
        this.f10652a.a(i);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(error, "error");
        pj2 pj2Var = this.b;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (pj2Var.a(context, error)) {
            handler.proceed();
        } else {
            this.f10652a.a(-11);
            super.onReceivedSslError(view, handler, error);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return true;
    }

    public boolean safedk_xg0_shouldOverrideUrlLoading_6670e83ca2a3bd816b76895c94bd4cf2(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        yg0 yg0Var = this.f10652a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        yg0Var.a(context, url);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.y, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("Yandex|SafeDK: Execution> Lcom/yandex/mobile/ads/impl/xg0;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_xg0_shouldOverrideUrlLoading_6670e83ca2a3bd816b76895c94bd4cf2 = safedk_xg0_shouldOverrideUrlLoading_6670e83ca2a3bd816b76895c94bd4cf2(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.y, webView, str, zSafedk_xg0_shouldOverrideUrlLoading_6670e83ca2a3bd816b76895c94bd4cf2);
        return zSafedk_xg0_shouldOverrideUrlLoading_6670e83ca2a3bd816b76895c94bd4cf2;
    }

    public /* synthetic */ xg0(yg0 yg0Var) {
        this(yg0Var, ws1.b());
    }

    public xg0(yg0 webViewClientListener, pj2 webViewSslErrorHandler) {
        Intrinsics.checkNotNullParameter(webViewClientListener, "webViewClientListener");
        Intrinsics.checkNotNullParameter(webViewSslErrorHandler, "webViewSslErrorHandler");
        this.f10652a = webViewClientListener;
        this.b = webViewSslErrorHandler;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f10652a.a(error.getErrorCode());
    }
}
