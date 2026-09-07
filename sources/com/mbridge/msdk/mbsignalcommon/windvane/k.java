package com.mbridge.msdk.mbsignalcommon.windvane;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.json.cc;
import com.mbridge.msdk.foundation.tools.o0;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: compiled from: WindVaneWebViewClient.java */
/* JADX INFO: loaded from: classes12.dex */
public class k extends com.mbridge.msdk.mbsignalcommon.base.b {
    protected String c = null;
    private int d = 0;
    private c e;

    private WebResourceResponse a(String str) {
        try {
            if (TextUtils.isEmpty(str) || !i.e(str)) {
                return null;
            }
            o0.c("WindVaneWebViewClient", "is image " + str);
            Bitmap bitmapB = com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).b(str);
            o0.c("WindVaneWebViewClient", "find image from cache " + str);
            if (bitmapB == null || bitmapB.isRecycled()) {
                return null;
            }
            return new WebResourceResponse(i.b(str), cc.N, com.mbridge.msdk.foundation.same.image.a.a(bitmapB));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.o, view, url);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.o, view, url);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/windvane/k;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.o, webView, str);
        safedk_k_onPageStarted_02e4e32ed4cead242fa20ba0acc0a170(webView, str, bitmap);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.o, view, errorCode, description, failingUrl);
    }

    public void safedk_k_onPageStarted_02e4e32ed4cead242fa20ba0acc0a170(WebView p0, String p1, Bitmap p2) {
        super.onPageStarted(p0, p1, p2);
        this.c = p1;
        c cVar = this.e;
        if (cVar != null) {
            cVar.a(p0, p1, p2);
        }
    }

    public WebResourceResponse safedk_k_shouldInterceptRequest_ea33cd8cea7780c2ad8461786cf124f9(WebView p0, String p1) {
        WebResourceResponse webResourceResponseA = a(p1);
        if (webResourceResponseA == null) {
            return super.shouldInterceptRequest(p0, p1);
        }
        o0.c("WindVaneWebViewClient", "find WebResourceResponse url is " + p1);
        return webResourceResponseA;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/windvane/k;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponse(com.safedk.android.utils.h.o, webView, str, safedk_k_shouldInterceptRequest_ea33cd8cea7780c2ad8461786cf124f9(webView, str));
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.o, view, url, zShouldOverrideUrlLoading);
        return zShouldOverrideUrlLoading;
    }
}
