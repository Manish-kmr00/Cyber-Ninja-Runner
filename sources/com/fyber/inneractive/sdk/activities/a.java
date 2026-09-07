package com.fyber.inneractive.sdk.activities;

import android.graphics.Bitmap;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.flow.C3102g;
import com.fyber.inneractive.sdk.flow.InterfaceC3103h;
import com.fyber.inneractive.sdk.network.AbstractC3149z;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.Q;
import com.fyber.inneractive.sdk.util.k0;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;
import com.safedk.android.utils.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FyberReportAdActivity f1604a;

    public a(FyberReportAdActivity fyberReportAdActivity) {
        this.f1604a = fyberReportAdActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.p, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.p, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.p, view, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/activities/a;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.p, webView, i, str, str2);
        safedk_a_onReceivedError_df03ec957704e5199e0fd8c9ada804c4(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbstractC3149z.a("WebViewRendererProcessGone", "Web view renderer process has gone. Web view destroyed", null, null);
        FyberReportAdActivity fyberReportAdActivity = this.f1604a;
        if (fyberReportAdActivity.b == webView) {
            fyberReportAdActivity.b = null;
        }
        if (webView != null) {
            AbstractC3256u.a(webView);
            webView.destroy();
        }
        this.f1604a.finish();
        return true;
    }

    public void safedk_a_onReceivedError_df03ec957704e5199e0fd8c9ada804c4(WebView p0, int p1, String p2, String p3) {
        IAlog.f("Received Error on WebViewClient: Code: %d, Description: %s, failingUrl: %s", Integer.valueOf(p1), p2, p3);
    }

    public boolean safedk_a_shouldOverrideUrlLoading_0e0a97058b8988959ba7eb7368f3240a(WebView p0, String p1) {
        InterfaceC3103h interfaceC3103h;
        if (p1 == null) {
            return false;
        }
        if (k0.a(p1)) {
            WebView p2 = this.f1604a.b;
            if (p2 != null) {
                DTExchangeNetworkBridge.webviewLoadUrl(p2, "chrome://crash");
            }
            return true;
        }
        if (!p1.startsWith("fybermarketplace://reportAd?") || (interfaceC3103h = FyberReportAdActivity.f) == null) {
            return false;
        }
        String strSubstring = p1.substring(28);
        C3102g c3102g = (C3102g) interfaceC3103h;
        c3102g.getClass();
        C3146w c3146w = new C3146w(EnumC3144u.FYBER_REPORT_AD, c3102g.b, c3102g.c);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", strSubstring);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "message", strSubstring);
        }
        c3146w.f.put(jSONObject);
        c3146w.g = true;
        c3146w.a((String) null);
        WebView p3 = this.f1604a.b;
        if (p3 != null) {
            Q.a(p3, "reportSent();");
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.p, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/activities/a;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_a_shouldOverrideUrlLoading_0e0a97058b8988959ba7eb7368f3240a = safedk_a_shouldOverrideUrlLoading_0e0a97058b8988959ba7eb7368f3240a(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.p, webView, str, zSafedk_a_shouldOverrideUrlLoading_0e0a97058b8988959ba7eb7368f3240a);
        return zSafedk_a_shouldOverrideUrlLoading_0e0a97058b8988959ba7eb7368f3240a;
    }
}
