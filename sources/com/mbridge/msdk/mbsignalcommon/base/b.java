package com.mbridge.msdk.mbsignalcommon.base;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.io.File;

/* JADX INFO: compiled from: BaseWebViewClient.java */
/* JADX INFO: loaded from: classes13.dex */
public class b extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f5225a;
    private com.mbridge.msdk.mbsignalcommon.windvane.c b;

    protected boolean a(String str, String str2) {
        try {
            return new File(str).getCanonicalFile().getPath().startsWith(new File(str2).getCanonicalFile().getPath());
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(h.o, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/base/b;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(h.o, webView, str);
        safedk_b_onPageFinished_d6339d7aa13731306daf8ed1861b283b(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(h.o, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/base/b;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.o, webView, i, str, str2);
        safedk_b_onReceivedError_c5d2f6e5c4fe60c3d411e1350b507efe(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        com.mbridge.msdk.mbsignalcommon.windvane.c cVar = this.b;
        if (cVar != null) {
            cVar.a(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        o0.b("BaseWebViewClient", "WebView called onRenderProcessGone");
        if (webView != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                if (webView instanceof WindVaneWebView) {
                    ((WindVaneWebView) webView).release();
                } else {
                    webView.destroy();
                }
            } catch (Throwable th) {
                o0.b("BaseWebViewClient", th.getMessage());
                return true;
            }
        }
        com.mbridge.msdk.mbsignalcommon.windvane.c cVar = this.b;
        if (cVar != null) {
            cVar.a(webView);
        }
        return true;
    }

    public void safedk_b_onPageFinished_d6339d7aa13731306daf8ed1861b283b(WebView p0, String p1) {
        super.onPageFinished(p0, p1);
        com.mbridge.msdk.mbsignalcommon.windvane.c cVar = this.b;
        if (cVar != null) {
            cVar.a(p0, p1);
        }
    }

    public void safedk_b_onReceivedError_c5d2f6e5c4fe60c3d411e1350b507efe(WebView p0, int p1, String p2, String p3) {
        super.onReceivedError(p0, p1, p2, p3);
        com.mbridge.msdk.mbsignalcommon.windvane.c cVar = this.b;
        if (cVar != null) {
            cVar.a(p0, p1, p2, p3);
        }
    }

    public boolean safedk_b_shouldOverrideUrlLoading_1c1dff4fd3ba810928c378cea4b7b38e(WebView p0, String p1) {
        a aVar = this.f5225a;
        if (aVar != null && aVar.a(p1)) {
            return true;
        }
        com.mbridge.msdk.mbsignalcommon.windvane.c cVar = this.b;
        if (cVar != null) {
            cVar.b(p0, p1);
        }
        return super.shouldOverrideUrlLoading(p0, p1);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(h.o, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/base/b;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_b_shouldOverrideUrlLoading_1c1dff4fd3ba810928c378cea4b7b38e = safedk_b_shouldOverrideUrlLoading_1c1dff4fd3ba810928c378cea4b7b38e(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.o, webView, str, zSafedk_b_shouldOverrideUrlLoading_1c1dff4fd3ba810928c378cea4b7b38e);
        return zSafedk_b_shouldOverrideUrlLoading_1c1dff4fd3ba810928c378cea4b7b38e;
    }

    public void a(a aVar) {
        this.f5225a = aVar;
    }

    public a a() {
        return this.f5225a;
    }

    public void a(com.mbridge.msdk.mbsignalcommon.windvane.c cVar) {
        this.b = cVar;
    }
}
