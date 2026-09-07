package com.fyber.inneractive.sdk.activities;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.click.r;
import com.fyber.inneractive.sdk.network.AbstractC3149z;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.k0;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;
import com.safedk.android.utils.Logger;
import java.util.Arrays;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f1609a;

    public f(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f1609a = inneractiveInternalBrowserActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.p, view, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/activities/f;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.p, webView, str);
        safedk_f_onPageFinished_515348b3f79421f62d9f99783f61f562(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/activities/f;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.p, webView, str);
        safedk_f_onPageStarted_741dad7655efd8853845d8e27e58eda4(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/activities/f;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.p, webView, i, str, str2);
        safedk_f_onReceivedError_95cea9a9a1a18f79fed82f6adf403456(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbstractC3149z.a("WebViewRendererProcessGone", "Web view renderer process has gone. Web view destroyed", null, null);
        InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity = this.f1609a;
        if (inneractiveInternalBrowserActivity.e == webView) {
            inneractiveInternalBrowserActivity.e = null;
        }
        if (webView != null) {
            AbstractC3256u.a(webView);
            webView.destroy();
        }
        this.f1609a.finish();
        return true;
    }

    public void safedk_f_onPageFinished_515348b3f79421f62d9f99783f61f562(WebView p0, String p1) {
        super.onPageFinished(p0, p1);
        this.f1609a.f.setImageDrawable(p0.canGoBack() ? AbstractC3251o.c(R.drawable.ia_ib_left_arrow) : AbstractC3251o.c(R.drawable.ia_ib_unleft_arrow));
        this.f1609a.g.setImageDrawable(p0.canGoForward() ? AbstractC3251o.c(R.drawable.ia_ib_right_arrow) : AbstractC3251o.c(R.drawable.ia_ib_unright_arrow));
    }

    public void safedk_f_onPageStarted_741dad7655efd8853845d8e27e58eda4(WebView p0, String p1, Bitmap p2) {
        super.onPageStarted(p0, p1, p2);
        this.f1609a.g.setImageDrawable(AbstractC3251o.c(R.drawable.ia_ib_unright_arrow));
    }

    public void safedk_f_onReceivedError_95cea9a9a1a18f79fed82f6adf403456(WebView p0, int p1, String p2, String p3) {
        IAlog.f("Received Error on WebViewClient: Code: %d, Description: %s, failingUrl: %s", Integer.valueOf(p1), p2, p3);
    }

    public boolean safedk_f_shouldOverrideUrlLoading_2d5eae6a8dbd2c6a8ce724f3c448f1e6(WebView p0, String p1) {
        if (TextUtils.isEmpty(p1)) {
            return false;
        }
        if (k0.a(p1)) {
            WebView webView = this.f1609a.e;
            if (webView != null) {
                DTExchangeNetworkBridge.webviewLoadUrl(webView, "chrome://crash");
            }
            return true;
        }
        InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity = this.f1609a;
        String str = InneractiveInternalBrowserActivity.URL_EXTRA;
        inneractiveInternalBrowserActivity.getClass();
        com.fyber.inneractive.sdk.click.g gVar = new com.fyber.inneractive.sdk.click.g(new g(inneractiveInternalBrowserActivity), null, EnumC3243g.VIDEO_CTA);
        r rVar = new r(false);
        rVar.i.addAll(Arrays.asList(gVar, new com.fyber.inneractive.sdk.click.d(), new com.fyber.inneractive.sdk.click.h(), new com.fyber.inneractive.sdk.click.l(), new com.fyber.inneractive.sdk.click.i(false, TextUtils.isEmpty(p1) ? null : Uri.parse(p1).getScheme())));
        rVar.a(inneractiveInternalBrowserActivity.getApplicationContext(), p1, new h(inneractiveInternalBrowserActivity), null, false, com.fyber.inneractive.sdk.ignite.m.NONE, "");
        return !p1.startsWith("http");
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.p, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/activities/f;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_f_shouldOverrideUrlLoading_2d5eae6a8dbd2c6a8ce724f3c448f1e6 = safedk_f_shouldOverrideUrlLoading_2d5eae6a8dbd2c6a8ce724f3c448f1e6(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.p, webView, str, zSafedk_f_shouldOverrideUrlLoading_2d5eae6a8dbd2c6a8ce724f3c448f1e6);
        return zSafedk_f_shouldOverrideUrlLoading_2d5eae6a8dbd2c6a8ce724f3c448f1e6;
    }
}
