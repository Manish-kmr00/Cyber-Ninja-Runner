package com.mbridge.msdk.splash.view;

import android.graphics.Bitmap;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.base.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: compiled from: SplashWebViewClient.java */
/* JADX INFO: loaded from: classes13.dex */
public class a extends b {
    private final String c = "SplashWebViewClient";
    com.mbridge.msdk.splash.middle.a d;

    /* JADX INFO: renamed from: com.mbridge.msdk.splash.view.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SplashWebViewClient.java */
    class C0495a implements ValueCallback<String> {
        C0495a() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    public void a(com.mbridge.msdk.splash.middle.a aVar) {
        if (aVar != null) {
            this.d = aVar;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(h.o, view, url);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        BrandSafetyUtils.onWebViewPageFinished(h.o, view, url);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/splash/view/a;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(h.o, webView, str);
        safedk_a_onPageStarted_4a5d6f6521f189baf1ecf9ebcad5af19(webView, str, bitmap);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        BrandSafetyUtils.onWebViewReceivedError(h.o, view, errorCode, description, failingUrl);
    }

    public void safedk_a_onPageStarted_4a5d6f6521f189baf1ecf9ebcad5af19(WebView p0, String p1, Bitmap p2) {
        super.onPageStarted(p0, p1, p2);
        try {
            String p3 = "javascript:" + com.mbridge.msdk.setting.util.a.a().b();
            p0.evaluateJavascript(p3, new C0495a());
        } catch (Throwable th) {
            o0.b("SplashWebViewClient", "onPageStarted", th);
        }
    }

    public boolean safedk_a_shouldOverrideUrlLoading_d7eb555bdc38e0c7ffd57fad76da232b(WebView p0, String p1) {
        try {
            WindVaneWebView windVaneWebView = (WindVaneWebView) p0;
            if (System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.mbridge.msdk.click.utils.a.c && com.mbridge.msdk.click.utils.a.a(((com.mbridge.msdk.splash.signal.b) windVaneWebView.getObject()).b().get(0), windVaneWebView.getUrl(), com.mbridge.msdk.click.utils.a.b)) {
                return false;
            }
            com.mbridge.msdk.splash.middle.a aVar = this.d;
            if (aVar == null) {
                return true;
            }
            aVar.a(false, p1);
            return true;
        } catch (Throwable th) {
            o0.b("SplashWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(h.o, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/splash/view/a;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_a_shouldOverrideUrlLoading_d7eb555bdc38e0c7ffd57fad76da232b = safedk_a_shouldOverrideUrlLoading_d7eb555bdc38e0c7ffd57fad76da232b(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.o, webView, str, zSafedk_a_shouldOverrideUrlLoading_d7eb555bdc38e0c7ffd57fad76da232b);
        return zSafedk_a_shouldOverrideUrlLoading_d7eb555bdc38e0c7ffd57fad76da232b;
    }
}
