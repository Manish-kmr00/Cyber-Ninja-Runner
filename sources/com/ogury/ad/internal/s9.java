package com.ogury.ad.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
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
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class s9 extends WebViewClient {
    public abstract WebResourceResponse a(WebView webView, String str);

    public abstract void a(String str, int i, String str2, Uri uri);

    public abstract boolean b(WebView webView, String str);

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded("io.presage", view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        BrandSafetyUtils.onWebViewPageFinished("io.presage", view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted("io.presage", view, url);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "")
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Uri uri = Uri.parse(str2);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        a("WEBVIEW", i, str, uri);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest request, WebResourceResponse errorResponse) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
        int statusCode = errorResponse.getStatusCode();
        String reasonPhrase = errorResponse.getReasonPhrase();
        Uri url = request.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
        a("HTTP", statusCode, reasonPhrase, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(error, "error");
        int primaryError = error.getPrimaryError();
        Uri uri = Uri.parse(error.getUrl());
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        a("SSL", primaryError, "An SSL error occurred while loading a resource", uri);
        super.onReceivedSslError(view, handler, error);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        boolean zDidCrash = Build.VERSION.SDK_INT >= 26 ? detail.didCrash() : true;
        String url = view.getUrl();
        if (url == null) {
            url = "";
        }
        Uri failingUri = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(failingUri, "parse(...)");
        Intrinsics.checkNotNullParameter(failingUri, "failingUri");
        f5 f5Var = ((g5) this).f;
        if (f5Var != null) {
            f5Var.a(zDidCrash, failingUri);
        }
        return true;
    }

    public boolean safedk_s9_shouldOverrideUrlLoading_d0d77075fb24517d89f9442b451a1e72(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        String string = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return b(view, string);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "")
    public final WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        return a(view, url);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("Ogury|SafeDK: Execution> Lcom/ogury/ad/internal/s9;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_s9_shouldOverrideUrlLoading_d0d77075fb24517d89f9442b451a1e72 = safedk_s9_shouldOverrideUrlLoading_d0d77075fb24517d89f9442b451a1e72(webView, webResourceRequest);
        BrandSafetyUtils.onShouldOverrideUrlLoading("io.presage", webView, webResourceRequest, zSafedk_s9_shouldOverrideUrlLoading_d0d77075fb24517d89f9442b451a1e72);
        return zSafedk_s9_shouldOverrideUrlLoading_d0d77075fb24517d89f9442b451a1e72;
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "")
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("Ogury|SafeDK: Execution> Lcom/ogury/ad/internal/s9;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_s9_shouldOverrideUrlLoading_6ddd2efb44fa20b3ec7dfe07e431106f = safedk_s9_shouldOverrideUrlLoading_6ddd2efb44fa20b3ec7dfe07e431106f(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading("io.presage", webView, str, zSafedk_s9_shouldOverrideUrlLoading_6ddd2efb44fa20b3ec7dfe07e431106f);
        return zSafedk_s9_shouldOverrideUrlLoading_6ddd2efb44fa20b3ec7dfe07e431106f;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
        int errorCode = error.getErrorCode();
        String string = error.getDescription().toString();
        Uri url = request.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
        a("WEBVIEW", errorCode, string, url);
    }

    @Deprecated(message = "")
    public boolean safedk_s9_shouldOverrideUrlLoading_6ddd2efb44fa20b3ec7dfe07e431106f(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        return b(view, url);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        String string = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return a(view, string);
    }
}
