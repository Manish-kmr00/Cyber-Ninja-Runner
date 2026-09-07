package com.iab.omid.library.ogury.publisher;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iab.omid.library.ogury.adsession.AdSessionContext;
import com.iab.omid.library.ogury.adsession.VerificationScriptResource;
import com.iab.omid.library.ogury.internal.g;
import com.iab.omid.library.ogury.utils.c;
import com.iab.omid.library.ogury.utils.f;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class b extends AdSessionStatePublisher {
    private WebView f;
    private Long g = null;
    private final Map<String, VerificationScriptResource> h;
    private final String i;

    class a extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f2814a = "OMID NativeBridge WebViewClient";

        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded("com.iab.omid.library", view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            BrandSafetyUtils.onWebViewPageFinished("com.iab.omid.library", view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted("com.iab.omid.library", view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError("com.iab.omid.library", view, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w(this.f2814a, "WebView renderer gone: " + renderProcessGoneDetail.toString());
            if (b.this.getWebView() != webView) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            Log.w(this.f2814a, "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
            b.this.a((WebView) null);
            webView.destroy();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders("com.iab.omid.library", view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
            BrandSafetyUtils.onShouldOverrideUrlLoading("com.iab.omid.library", view, url, zShouldOverrideUrlLoading);
            return zShouldOverrideUrlLoading;
        }
    }

    /* JADX INFO: renamed from: com.iab.omid.library.ogury.publisher.b$b, reason: collision with other inner class name */
    class RunnableC0367b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebView f2815a;

        RunnableC0367b() {
            this.f2815a = b.this.f;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2815a.destroy();
        }
    }

    public b(Map<String, VerificationScriptResource> map, String str) {
        this.h = map;
        this.i = str;
    }

    @Override // com.iab.omid.library.ogury.publisher.AdSessionStatePublisher
    public void a(com.iab.omid.library.ogury.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String str : injectedResourcesMap.keySet()) {
            c.a(jSONObject, str, injectedResourcesMap.get(str).toJsonObject());
        }
        a(aVar, adSessionContext, jSONObject);
    }

    @Override // com.iab.omid.library.ogury.publisher.AdSessionStatePublisher
    public void b() {
        super.b();
        new Handler().postDelayed(new RunnableC0367b(), Math.max(4000 - (this.g == null ? 4000L : TimeUnit.MILLISECONDS.convert(f.b() - this.g.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f = null;
    }

    @Override // com.iab.omid.library.ogury.publisher.AdSessionStatePublisher
    public void i() {
        super.i();
        j();
    }

    void j() {
        WebView webView = new WebView(com.iab.omid.library.ogury.internal.f.b().a());
        this.f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f.getSettings().setAllowContentAccess(false);
        this.f.getSettings().setAllowFileAccess(false);
        this.f.setWebViewClient(new a());
        a(this.f);
        g.a().c(this.f, this.i);
        for (String str : this.h.keySet()) {
            g.a().a(this.f, this.h.get(str).getResourceUrl().toExternalForm(), str);
        }
        this.g = Long.valueOf(f.b());
    }
}
