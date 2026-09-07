package com.applovin.impl.adview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.c2;
import com.applovin.impl.e2;
import com.applovin.impl.h7;
import com.applovin.impl.k7;
import com.applovin.impl.l7;
import com.applovin.impl.o7;
import com.applovin.impl.r4;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v4;
import com.applovin.impl.x7;
import com.applovin.sdk.AppLovinAdSize;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class c extends r4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f342a;
    private final o b;
    private final a c;

    public c(a aVar, com.applovin.impl.sdk.k kVar) {
        this.f342a = kVar;
        this.b = kVar.O();
        this.c = aVar;
    }

    private void b() {
        this.c.z();
    }

    private void c() {
        this.c.a();
    }

    @Override // com.applovin.impl.r4
    protected Map a() {
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("name", "AdWebViewClient");
        mapHashMap.putAll(e2.a((AppLovinAdImpl) this.c.g()));
        return mapHashMap;
    }

    protected a d() {
        return this.c;
    }

    @Override // com.applovin.impl.r4, android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/impl/adview/c;->onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V");
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.f8160a, webView, str);
        safedk_c_onLoadResource_1af43fc902fb6865fb0a01b3cce96a24(webView, str);
    }

    @Override // com.applovin.impl.r4, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/impl/adview/c;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.f8160a, webView, str);
        safedk_c_onPageFinished_a44c2ec5ed56e4c2419c3d079c098b25(webView, str);
    }

    @Override // com.applovin.impl.r4, android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.f8160a, view, url);
    }

    @Override // com.applovin.impl.r4, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/impl/adview/c;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.f8160a, webView, i, str, str2);
        safedk_c_onReceivedError_8e544adb9beea31f39e1655c605c306d(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/impl/adview/c;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.f8160a, webView, webResourceRequest, webResourceError);
        safedk_c_onReceivedError_3e062ec97139c0570b7d2cb7765ff835(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        com.applovin.impl.sdk.ad.b bVarG = this.c.g();
        if (o.a()) {
            this.b.b("AdWebView", "Received HTTP error: " + webResourceResponse + "for url: " + webResourceRequest.getUrl() + " and ad: " + bVarG);
        }
        if (k7.a(webResourceRequest.getUrl().toString(), this.f342a)) {
            this.f342a.E().a("adWebViewReceivedHttpError", webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        com.applovin.impl.sdk.ad.b bVarG = this.c.g();
        String str = "Received SSL error: " + sslError;
        if (o.a()) {
            this.b.b("AdWebView", str + " for ad: " + bVarG);
        }
    }

    @Override // com.applovin.impl.r4, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.render_process_gone"), null);
        com.applovin.impl.sdk.ad.b bVarG = this.c.g();
        o.h("AdWebView", "Render process gone for ad: " + bVarG + ". Process did crash: " + renderProcessGoneDetail.didCrash());
        boolean zOnRenderProcessGone = super.onRenderProcessGone(webView, renderProcessGoneDetail);
        if (((Boolean) this.f342a.a(v4.F5)).booleanValue()) {
            a(webView, renderProcessGoneDetail, bVarG);
        }
        return zOnRenderProcessGone;
    }

    public void safedk_c_onLoadResource_1af43fc902fb6865fb0a01b3cce96a24(WebView p0, String p1) {
        super.onLoadResource(p0, p1);
        if (o.a()) {
            this.b.d("AdWebView", "Loaded resource: " + p1);
        }
    }

    public void safedk_c_onPageFinished_a44c2ec5ed56e4c2419c3d079c098b25(WebView p0, String p1) {
        super.onPageFinished(p0, p1);
        if (o.a()) {
            this.b.d("AdWebView", "Loaded URL: " + p1);
        }
        this.c.a(p0, p1);
    }

    public void safedk_c_onReceivedError_3e062ec97139c0570b7d2cb7765ff835(WebView p0, WebResourceRequest p1, WebResourceError p2) {
        super.onReceivedError(p0, p1, p2);
        onReceivedError(p0, p2.getErrorCode(), p2.getDescription().toString(), p1.getUrl().toString());
    }

    public boolean safedk_c_shouldOverrideUrlLoading_678f8c4351efae3cc506edb28e260cba(WebView p0, WebResourceRequest p1) {
        Uri url = p1.getUrl();
        if (url != null) {
            return a(p0, url.toString());
        }
        if (!o.a()) {
            return false;
        }
        this.b.b("AdWebView", "No url found for request");
        return false;
    }

    @Override // com.applovin.impl.r4, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.f8160a, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/impl/adview/c;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_c_shouldOverrideUrlLoading_678f8c4351efae3cc506edb28e260cba = safedk_c_shouldOverrideUrlLoading_678f8c4351efae3cc506edb28e260cba(webView, webResourceRequest);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.f8160a, webView, webResourceRequest, zSafedk_c_shouldOverrideUrlLoading_678f8c4351efae3cc506edb28e260cba);
        return zSafedk_c_shouldOverrideUrlLoading_678f8c4351efae3cc506edb28e260cba;
    }

    @Override // com.applovin.impl.r4, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/impl/adview/c;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_c_shouldOverrideUrlLoading_2ce55369ff10fa536fb839524e517b10 = safedk_c_shouldOverrideUrlLoading_2ce55369ff10fa536fb839524e517b10(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.f8160a, webView, str, zSafedk_c_shouldOverrideUrlLoading_2ce55369ff10fa536fb839524e517b10);
        return zSafedk_c_shouldOverrideUrlLoading_2ce55369ff10fa536fb839524e517b10;
    }

    public void safedk_c_onReceivedError_8e544adb9beea31f39e1655c605c306d(WebView p0, int p1, String p2, String p3) {
        super.onReceivedError(p0, p1, p2, p3);
        com.applovin.impl.sdk.ad.b bVarG = this.c.g();
        String str = "Received error with error code: " + p1 + " with description \\'" + p2 + "\\' for URL: " + p3;
        if (o.a()) {
            this.b.b("AdWebView", str + " for ad: " + bVarG);
        }
        if (k7.a(p3, this.f342a)) {
            this.f342a.E().a("adWebViewReceivedError", p3, p1, p2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:153:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:78:0x0163  */
    /* JADX WARN: Code duplicated, block: B:98:0x01c0  */
    protected boolean a(WebView webView, String str) {
        boolean z;
        if (this.c == null) {
            return true;
        }
        if (o.a()) {
            this.b.d("AdWebView", "Processing click on ad URL \"" + str + "\"");
        }
        if (str != null && (webView instanceof b)) {
            Uri uri = Uri.parse(str);
            b bVar = (b) webView;
            String scheme = uri.getScheme();
            String host = uri.getHost();
            String path = uri.getPath();
            com.applovin.impl.sdk.ad.b bVarG = this.c.g();
            if (bVarG == null) {
                if (o.a()) {
                    this.b.b("AdWebView", "Unable to process click, ad not found!");
                }
                return true;
            }
            boolean zA = bVar.a();
            if ("applovin".equals(scheme) && "com.applovin.sdk".equals(host)) {
                if ("/vibrate".equals(path)) {
                    long j = StringUtils.parseLong(uri.getQueryParameter("duration_ms"), 0L);
                    if (j > 0) {
                        k7.a(StringUtils.parseFloat(uri.getQueryParameter("intensity"), 0.5f), j, this.f342a.O());
                    }
                } else if ("/adservice/close_ad".equals(path)) {
                    b();
                } else if ("/adservice/expand_ad".equals(path)) {
                    if (a(zA, bVarG, uri)) {
                        if (o.a()) {
                            this.b.b("AdWebView", "Skipping expand command without user interaction");
                        }
                        return true;
                    }
                    a(bVar.getLastClickEvent());
                } else if ("/adservice/contract_ad".equals(path)) {
                    c();
                } else {
                    if ("/adservice/no_op".equals(path)) {
                        return true;
                    }
                    if ("/adservice/load_url".equals(path)) {
                        if (a(zA, bVarG, uri)) {
                            if (o.a()) {
                                this.b.b("AdWebView", "Skipping URL load command without user interaction");
                            }
                            return true;
                        }
                        h7.a(uri, this.c, this.f342a);
                    } else if ("/adservice/track_click_now".equals(path)) {
                        if (a(zA, bVarG, uri)) {
                            if (o.a()) {
                                this.b.b("AdWebView", "Skipping click tracking command without user interaction");
                            }
                            return true;
                        }
                        if (bVarG instanceof l7) {
                            a((l7) bVarG, bVar);
                        } else {
                            a(bVar, Uri.parse("/adservice/track_click_now"));
                        }
                    } else if ("/adservice/deeplink".equals(path)) {
                        if (a(zA, bVarG, uri)) {
                            if (o.a()) {
                                this.b.b("AdWebView", "Skipping deep link plus command without user interaction");
                            }
                            return true;
                        }
                        if (bVarG instanceof l7) {
                            l7 l7Var = (l7) bVarG;
                            if (l7Var.I1()) {
                                a(l7Var, bVar);
                            } else {
                                a(bVar, uri);
                            }
                        } else {
                            a(bVar, uri);
                        }
                    } else if ("/adservice/postback".equals(path)) {
                        h7.a(uri, bVarG, this.f342a);
                    } else if ("/ga_init".equals(path)) {
                        this.c.b(uri);
                    } else if ("/ga_event".equals(path)) {
                        this.c.a(uri);
                    } else if ("/playable_event".equals(path)) {
                        a(uri);
                    } else if ("/adservice/direct_download".equals(path)) {
                        Bundle bundleA = h7.a(uri);
                        if (bVarG instanceof l7) {
                            l7 l7Var2 = (l7) bVarG;
                            if (l7Var2.I1()) {
                                a(l7Var2, bVar, bundleA);
                            } else {
                                a(bVar, bVarG.m(), bundleA);
                            }
                        } else {
                            a(bVar, bVarG.m(), bundleA);
                        }
                    } else if ("/save_template_state".equals(path)) {
                        bVarG.b(uri.getQueryParameter("state"));
                    } else if ("/template_error".equals(path)) {
                        h7.c(uri, bVarG, this.f342a);
                    } else if ("/adservice/fully_watched".equals(path)) {
                        this.c.A();
                    } else if ("/adservice/preload".equals(path)) {
                        h7.b(uri, bVarG, this.f342a);
                    } else if ("/adservice/custom_intent".equals(path)) {
                        h7.a(uri, bVarG, this.c.i(), this.f342a);
                    } else {
                        if (o.a()) {
                            this.b.k("AdWebView", "Unknown URL: " + str);
                        }
                        if (o.a()) {
                            this.b.k("AdWebView", "Path: " + path);
                        }
                    }
                }
            } else {
                Iterator it = bVarG.f0().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    String str2 = (String) it.next();
                    if (StringUtils.isValidString(path) && path.contains(str2)) {
                        z = false;
                        break;
                    }
                }
                if (!zA) {
                    boolean zK1 = bVarG.k1();
                    boolean z2 = zK1 ? false : z;
                    a(uri, zK1, bVarG, this.f342a);
                    z = z2;
                }
                if (z) {
                    List listZ0 = bVarG.z0();
                    List listY0 = bVarG.y0();
                    if ((!listZ0.isEmpty() && !listZ0.contains(scheme)) || (!listY0.isEmpty() && !listY0.contains(host))) {
                        if (o.a()) {
                            this.b.b("AdWebView", "URL is not whitelisted - bypassing click");
                        }
                    } else if (bVarG instanceof l7) {
                        l7 l7Var3 = (l7) bVarG;
                        if (l7Var3.I1()) {
                            a(l7Var3, bVar);
                        } else {
                            a(bVar, uri);
                        }
                    } else {
                        a(bVar, uri);
                    }
                }
            }
        }
        return true;
    }

    public boolean safedk_c_shouldOverrideUrlLoading_2ce55369ff10fa536fb839524e517b10(WebView p0, String p1) {
        return a(p0, p1);
    }

    private void a(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail, com.applovin.impl.sdk.ad.b bVar) {
        if (renderProcessGoneDetail.didCrash() && ((Boolean) this.f342a.a(v4.M5)).booleanValue()) {
            throw new RuntimeException("Render process crashed. This is likely caused by a crash in an AppLovin ad with ID: " + (bVar != null ? String.valueOf(bVar.getAdIdNumber()) : "null"));
        }
        if (webView == null || !webView.equals(this.c.f())) {
            return;
        }
        this.c.b();
        AppLovinAdSize appLovinAdSizeK = this.c.k();
        if (k7.a(appLovinAdSizeK)) {
            this.c.a(appLovinAdSizeK);
            this.c.F();
        }
    }

    private boolean a(boolean z, com.applovin.impl.sdk.ad.b bVar, Uri uri) {
        if (z) {
            return false;
        }
        boolean zL1 = bVar.l1();
        a(uri, zL1, bVar, this.f342a);
        return zL1;
    }

    private static void a(Uri uri, boolean z, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.k kVar) {
        if (kVar.c(v4.F6).contains(uri.getScheme())) {
            return;
        }
        kVar.E().d(c2.w0, a(bVar, uri, z));
    }

    private static Map a(com.applovin.impl.sdk.ad.b bVar, Uri uri, boolean z) {
        Map mapA = e2.a((AppLovinAdImpl) bVar);
        CollectionUtils.putStringIfValid("url", uri.toString(), mapA);
        CollectionUtils.putStringIfValid("is_blocked_auto_redirect", String.valueOf(z), mapA);
        return mapA;
    }

    private void a(MotionEvent motionEvent) {
        this.c.a(motionEvent);
    }

    private void a(l7 l7Var, b bVar) {
        a(l7Var, bVar, (Bundle) null);
    }

    private void a(l7 l7Var, b bVar, Bundle bundle) {
        o7 o7VarS1 = l7Var.s1();
        if (o7VarS1 != null) {
            x7.a(o7VarS1.b(), this.c.j());
            a(bVar, o7VarS1.c(), bundle);
        }
    }

    private void a(b bVar, Uri uri) {
        a(bVar, uri, (Bundle) null);
    }

    private void a(b bVar, Uri uri, Bundle bundle) {
        com.applovin.impl.sdk.ad.b currentAd = bVar.getCurrentAd();
        AppLovinAdView appLovinAdViewI = this.c.i();
        if (appLovinAdViewI != null && currentAd != null) {
            if (currentAd instanceof l7) {
                ((l7) currentAd).getAdEventTracker().v();
            }
            this.c.a(currentAd, appLovinAdViewI, uri, bVar.getAndClearLastClickEvent(), bundle);
        } else if (o.a()) {
            this.b.b("AdWebView", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
        }
    }

    private void a(Uri uri) {
        String str;
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("success", false);
        String queryParameter = uri.getQueryParameter("type");
        if (booleanQueryParameter) {
            str = "Tracked event: " + queryParameter;
        } else {
            str = "Failed to track event: " + queryParameter;
        }
        k7.a(str, com.applovin.impl.sdk.k.o());
    }
}
