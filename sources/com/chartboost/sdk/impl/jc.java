package com.chartboost.sdk.impl;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class jc extends t {
    public WebView g;
    public Long h;
    public final Map<String, fb> i;
    public final String j;

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.c, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.c, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.c, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.c, view, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + webView);
            if (jc.this.h() == webView) {
                Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
                jc.this.a((WebView) null);
            }
            webView.destroy();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.c, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
            BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.c, view, url, zShouldOverrideUrlLoading);
            return zShouldOverrideUrlLoading;
        }
    }

    public class b implements Runnable {
        public final WebView b;

        public b() {
            this.b = jc.this.g;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.destroy();
        }
    }

    public jc(String str, Map<String, fb> map, String str2) {
        super(str);
        this.h = null;
        this.i = map;
        this.j = str2;
    }

    @Override // com.chartboost.sdk.impl.t
    public void b() {
        super.b();
        new Handler().postDelayed(new b(), Math.max(4000 - (this.h == null ? 4000L : TimeUnit.MILLISECONDS.convert(id.b() - this.h.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.g = null;
    }

    @Override // com.chartboost.sdk.impl.t
    public void j() {
        super.j();
        k();
    }

    public void k() {
        WebView webView = new WebView(md.b().a());
        this.g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.g.getSettings().setAllowContentAccess(false);
        this.g.getSettings().setAllowFileAccess(false);
        this.g.setWebViewClient(new a());
        a(this.g);
        nd.a().c(this.g, this.j);
        for (String str : this.i.keySet()) {
            nd.a().d(this.g, this.i.get(str).a().toExternalForm(), str);
        }
        this.h = Long.valueOf(id.b());
    }

    @Override // com.chartboost.sdk.impl.t
    public void a(zb zbVar, r rVar) {
        JSONObject jSONObject = new JSONObject();
        Map<String, fb> mapD = rVar.d();
        for (String str : mapD.keySet()) {
            vc.a(jSONObject, str, mapD.get(str).d());
        }
        a(zbVar, rVar, jSONObject);
    }
}
