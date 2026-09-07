package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
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

/* JADX INFO: loaded from: classes13.dex */
public class s3 extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t3 f1132a;
    public final l4 b;
    public final i6 c;
    public final o9 d;

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.c, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/s3;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.c, webView, str);
        safedk_s3_onPageFinished_e455b0e3bf4ad750ae933e8f80bd371b(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/s3;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.c, webView, str);
        safedk_s3_onPageStarted_8d092992a482772bf63f0a55fdf54bc6(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/s3;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.c, webView, i, str, str2);
        safedk_s3_onReceivedError_98806c59a1e4c42e72276d91ff2a3bb0(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/s3;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.c, webView, webResourceRequest, webResourceError);
        safedk_s3_onReceivedError_c16a283007e986996e71fb3fc6645066(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.c, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/s3;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_s3_shouldOverrideUrlLoading_d0a88ce4da6cfa00f5fe79f82e7ce7a1 = safedk_s3_shouldOverrideUrlLoading_d0a88ce4da6cfa00f5fe79f82e7ce7a1(webView, webResourceRequest);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.c, webView, webResourceRequest, zSafedk_s3_shouldOverrideUrlLoading_d0a88ce4da6cfa00f5fe79f82e7ce7a1);
        return zSafedk_s3_shouldOverrideUrlLoading_d0a88ce4da6cfa00f5fe79f82e7ce7a1;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/s3;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_s3_shouldOverrideUrlLoading_4bd8b0fdc06fb95cea136c14dcc54271 = safedk_s3_shouldOverrideUrlLoading_4bd8b0fdc06fb95cea136c14dcc54271(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.c, webView, str, zSafedk_s3_shouldOverrideUrlLoading_4bd8b0fdc06fb95cea136c14dcc54271);
        return zSafedk_s3_shouldOverrideUrlLoading_4bd8b0fdc06fb95cea136c14dcc54271;
    }

    public s3(t3 t3Var, l4 l4Var, i6 i6Var, o9 o9Var) {
        this.f1132a = t3Var;
        this.b = l4Var;
        this.c = i6Var;
        this.d = o9Var;
    }

    public void safedk_s3_onPageStarted_8d092992a482772bf63f0a55fdf54bc6(WebView p0, String p1, Bitmap p2) {
        super.onPageStarted(p0, p1, p2);
        if (Build.VERSION.SDK_INT >= 26) {
            PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
            if (currentWebViewPackage != null) {
                b7.a("WebView version: " + currentWebViewPackage.versionName, null);
            } else {
                a("Device was not set up correctly.");
            }
        }
        this.f1132a.c();
    }

    public void safedk_s3_onPageFinished_e455b0e3bf4ad750ae933e8f80bd371b(WebView p0, String p1) {
        super.onPageFinished(p0, p1);
        t3 t3Var = this.f1132a;
        if (t3Var != null) {
            t3Var.d();
        }
    }

    public void safedk_s3_onReceivedError_98806c59a1e4c42e72276d91ff2a3bb0(WebView p0, int p1, String p2, String p3) {
        a("Error loading " + p3 + ": " + p2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.b.mo4741track(j4.a(ma.i.WEBVIEW_SSL_ERROR, sslError.toString()));
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        b7.a("Error loading " + webResourceRequest.getUrl().toString() + ": " + (webResourceResponse == null ? "unknown error" : webResourceResponse.getReasonPhrase()), null);
    }

    public boolean safedk_s3_shouldOverrideUrlLoading_d0a88ce4da6cfa00f5fe79f82e7ce7a1(WebView p0, WebResourceRequest p1) {
        if (!this.d.z) {
            return false;
        }
        this.c.b(new m2(p1.getUrl().toString(), Boolean.FALSE));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        a(renderProcessGoneDetail.didCrash() ? "Webview crashed: " + renderProcessGoneDetail : "Webview killed, likely due to low memory");
        if (webView == null || !(webView.getContext() instanceof Activity)) {
            return true;
        }
        ((Activity) webView.getContext()).finish();
        return true;
    }

    public final void a(String str) {
        t3 t3Var = this.f1132a;
        if (t3Var != null) {
            t3Var.a(str);
        }
    }

    public void safedk_s3_onReceivedError_c16a283007e986996e71fb3fc6645066(WebView p0, WebResourceRequest p1, WebResourceError p2) {
        if (p1.isForMainFrame()) {
            a("Error loading " + p1.getUrl().toString() + ": " + ((Object) p2.getDescription()));
        }
    }

    public boolean safedk_s3_shouldOverrideUrlLoading_4bd8b0fdc06fb95cea136c14dcc54271(WebView p0, String p1) {
        if (!this.d.z) {
            return false;
        }
        this.c.b(new m2(p1, Boolean.FALSE));
        return true;
    }
}
