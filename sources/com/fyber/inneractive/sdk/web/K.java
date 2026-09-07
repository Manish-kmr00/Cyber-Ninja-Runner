package com.fyber.inneractive.sdk.web;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.util.AbstractC3255t;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.C3242f;
import com.fyber.inneractive.sdk.util.IAlog;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;
import com.safedk.android.utils.Logger;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes13.dex */
public final class K extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2387a;
    public final int b;
    public final int c;
    public final int d;
    public InterfaceC3271j e;

    public K(InterfaceC3271j interfaceC3271j, boolean z, int i, int i2, int i3) {
        this.e = interfaceC3271j;
        this.f2387a = z;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/web/K;->onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V");
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.p, webView, str);
        safedk_K_onLoadResource_698f40d3eb02d283b3b1dc715b54d65d(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/web/K;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.p, webView, str);
        safedk_K_onPageFinished_b5f34205ac80c64bfaca708d8d7ebb24(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/web/K;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.p, webView, str);
        safedk_K_onPageStarted_a3c04ebbfe014ff22122df75e605bbe5(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/web/K;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.p, webView, i, str, str2);
        safedk_K_onReceivedError_cdd366db7708684d4650ce506161b1c6(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        IAlog.a("onWebViewRenderProcessGone called for web view! %s", webView);
        if (webView != null) {
            AbstractC3256u.a(webView);
            webView.destroy();
        }
        InterfaceC3271j interfaceC3271j = this.e;
        if (interfaceC3271j == null) {
            return true;
        }
        interfaceC3271j.a();
        return true;
    }

    public void safedk_K_onLoadResource_698f40d3eb02d283b3b1dc715b54d65d(WebView p0, String p1) {
        super.onLoadResource(p0, p1);
        IAlog.e("Resources to load: %s", p1);
        IAlog.d("%s %s", "RESOURCES", p1);
        InterfaceC3271j interfaceC3271j = this.e;
        if (interfaceC3271j != null) {
            AbstractC3270i abstractC3270i = (AbstractC3270i) interfaceC3271j;
            if (TextUtils.isEmpty(p1) || !p1.startsWith(com.safedk.android.analytics.brandsafety.creatives.discoveries.d.v) || AbstractC3255t.a()) {
                return;
            }
            IAlog.a("%s Found a portential unsecure resource url: %s", IAlog.a(abstractC3270i), p1);
        }
    }

    public void safedk_K_onPageFinished_b5f34205ac80c64bfaca708d8d7ebb24(WebView p0, String p1) {
        super.onPageFinished(p0, p1);
        IAlog.e("onPageFinished - url: %s", p1);
        InterfaceC3271j interfaceC3271j = this.e;
        if (interfaceC3271j != null) {
            interfaceC3271j.a(p0);
        }
    }

    public void safedk_K_onPageStarted_a3c04ebbfe014ff22122df75e605bbe5(WebView p0, String p1, Bitmap p2) {
        super.onPageStarted(p0, p1, p2);
        IAlog.e("onPageStarted - url: %s", p1);
    }

    public WebResourceResponse safedk_K_shouldInterceptRequest_bd154f52f2f01dde4c0425f95db1b44c(WebView p0, WebResourceRequest p1) {
        URL url;
        HttpURLConnection httpURLConnection;
        if (this.f2387a && p1 != null) {
            IAlog.e("shouldInterceptRequest, method = %s", p1.getMethod());
            c0 c0Var = c0.c;
            int i = this.b;
            int i2 = this.c;
            int i3 = this.d;
            c0Var.getClass();
            WebResourceResponse webResourceResponse = null;
            if (p1.getUrl() != null && p1.getUrl().getScheme() != null && p1.getUrl().getScheme().startsWith("http") && TextUtils.equals(p1.getMethod(), "GET")) {
                d0 d0Var = (d0) c0Var.f2403a.get(new e0(p1));
                if (d0Var != null) {
                    webResourceResponse = new WebResourceResponse(d0Var.c, d0Var.d, d0Var.e, d0Var.f, d0Var.b, new ByteArrayInputStream(d0Var.f2405a));
                } else {
                    try {
                        url = new URL(p1.getUrl().toString());
                    } catch (MalformedURLException unused) {
                        url = null;
                    }
                    if (url != null) {
                        ByteBuffer byteBufferAllocateDirect = (ByteBuffer) C3242f.b.f2362a.poll();
                        if (byteBufferAllocateDirect == null) {
                            byteBufferAllocateDirect = ByteBuffer.allocateDirect(16384);
                        }
                        try {
                            httpURLConnection = (HttpURLConnection) url.openConnection();
                            try {
                                httpURLConnection.setRequestMethod(p1.getMethod());
                                httpURLConnection.setInstanceFollowRedirects(false);
                                c0.a(p1, httpURLConnection);
                            } catch (Throwable unused2) {
                            }
                        } catch (Throwable unused3) {
                            httpURLConnection = null;
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.setConnectTimeout(i);
                            httpURLConnection.setReadTimeout(i2);
                            d0 d0VarA = null;
                            while (i3 > 0) {
                                try {
                                    d0VarA = c0.a(httpURLConnection, byteBufferAllocateDirect);
                                } catch (SocketTimeoutException | UnknownHostException unused4) {
                                } catch (Throwable unused5) {
                                    i3 = 0;
                                }
                                if (d0VarA != null) {
                                    break;
                                }
                                i3--;
                            }
                            if (d0VarA != null) {
                                try {
                                    if (d0VarA.a()) {
                                        c0Var.f2403a.put(new e0(p1), d0VarA);
                                    }
                                    WebResourceResponse webResourceResponse2 = new WebResourceResponse(d0VarA.c, d0VarA.d, d0VarA.e, d0VarA.f, d0VarA.b, new ByteArrayInputStream(d0VarA.f2405a));
                                    DTExchangeNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                                    C3242f.b.f2362a.offer(byteBufferAllocateDirect);
                                    webResourceResponse = webResourceResponse2;
                                } catch (Throwable unused6) {
                                    DTExchangeNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                                    C3242f.b.f2362a.offer(byteBufferAllocateDirect);
                                }
                            } else {
                                DTExchangeNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                            }
                            C3242f.b.f2362a.offer(byteBufferAllocateDirect);
                        }
                    }
                }
            }
            if (webResourceResponse != null) {
                return webResourceResponse;
            }
            IAlog.e("shouldInterceptRequest did not intercept %s", p1.getUrl());
        }
        return super.shouldInterceptRequest(p0, p1);
    }

    public boolean safedk_K_shouldOverrideUrlLoading_8a76c1c804ffa87fedcf944b95459d41(WebView p0, String p1) {
        super.shouldOverrideUrlLoading(p0, p1);
        InterfaceC3271j interfaceC3271j = this.e;
        return interfaceC3271j != null && interfaceC3271j.a(p0, p1);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/web/K;->shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.p, webView, webResourceRequest, safedk_K_shouldInterceptRequest_bd154f52f2f01dde4c0425f95db1b44c(webView, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/web/K;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_K_shouldOverrideUrlLoading_8a76c1c804ffa87fedcf944b95459d41 = safedk_K_shouldOverrideUrlLoading_8a76c1c804ffa87fedcf944b95459d41(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.p, webView, str, zSafedk_K_shouldOverrideUrlLoading_8a76c1c804ffa87fedcf944b95459d41);
        return zSafedk_K_shouldOverrideUrlLoading_8a76c1c804ffa87fedcf944b95459d41;
    }

    public void safedk_K_onReceivedError_cdd366db7708684d4650ce506161b1c6(WebView p0, int p1, String p2, String p3) {
        IAlog.e("%sError: code = %d text = %s WebView = %s", IAlog.a(this), Integer.valueOf(p1), p2, p0);
        super.onReceivedError(p0, p1, p2, p3);
        InterfaceC3271j interfaceC3271j = this.e;
        if (interfaceC3271j != null) {
            interfaceC3271j.d();
        }
    }
}
