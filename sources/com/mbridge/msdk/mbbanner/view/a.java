package com.mbridge.msdk.mbbanner.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.base.b;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.List;

/* JADX INFO: compiled from: BannerWebViewClient.java */
/* JADX INFO: loaded from: classes11.dex */
public class a extends b {
    private final String c = "BannerWebViewClient";
    String d;
    List<CampaignEx> e;
    com.mbridge.msdk.mbbanner.common.listener.a f;

    /* JADX INFO: renamed from: com.mbridge.msdk.mbbanner.view.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BannerWebViewClient.java */
    class C0455a implements ValueCallback<String> {
        C0455a() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    public a(String str, List<CampaignEx> list, com.mbridge.msdk.mbbanner.common.listener.a aVar) {
        this.d = str;
        this.e = list;
        this.f = aVar;
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.o);
        p0.startActivity(p1);
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
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbbanner/view/a;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(h.o, webView, str);
        safedk_a_onPageStarted_eaa6bae117b893d41f236f7c54c9cdbe(webView, str, bitmap);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        BrandSafetyUtils.onWebViewReceivedError(h.o, view, errorCode, description, failingUrl);
    }

    public void safedk_a_onPageStarted_eaa6bae117b893d41f236f7c54c9cdbe(WebView p0, String p1, Bitmap p2) {
        CampaignEx campaignEx;
        super.onPageStarted(p0, p1, p2);
        try {
            String p3 = "javascript:" + com.mbridge.msdk.setting.util.a.a().b();
            a(p0, p3);
            List<CampaignEx> list = this.e;
            if (list == null || list.isEmpty() || (campaignEx = this.e.get(0)) == null || !campaignEx.isActiveOm()) {
                return;
            }
            String p4 = "javascript:" + MBridgeConstans.OMID_JS_SERVICE_CONTENT;
            a(p0, p4);
        } catch (Throwable th) {
            o0.b("BannerWebViewClient", "onPageStarted", th);
        }
    }

    public boolean safedk_a_shouldOverrideUrlLoading_078b6b002ab25c1d646f13a68f3d4eb0(WebView p0, String p1) {
        try {
            o0.b("BannerWebViewClient", "Use html to open url.");
            BaseWebView baseWebView = (BaseWebView) p0;
            if (System.currentTimeMillis() - baseWebView.lastTouchTime > com.mbridge.msdk.click.utils.a.c && com.mbridge.msdk.click.utils.a.a(this.e.get(0), baseWebView.getUrl(), com.mbridge.msdk.click.utils.a.b)) {
                return false;
            }
            if (this.e.size() > 1) {
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(c.m().d(), new Intent("android.intent.action.VIEW", Uri.parse(p1)));
                p1 = null;
            }
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.f;
            if (aVar != null) {
                aVar.a(false, p1);
            }
            return true;
        } catch (Throwable th) {
            o0.b("BannerWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(h.o, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbbanner/view/a;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_a_shouldOverrideUrlLoading_078b6b002ab25c1d646f13a68f3d4eb0 = safedk_a_shouldOverrideUrlLoading_078b6b002ab25c1d646f13a68f3d4eb0(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.o, webView, str, zSafedk_a_shouldOverrideUrlLoading_078b6b002ab25c1d646f13a68f3d4eb0);
        return zSafedk_a_shouldOverrideUrlLoading_078b6b002ab25c1d646f13a68f3d4eb0;
    }

    private void a(WebView webView, String str) {
        webView.evaluateJavascript(str, new C0455a());
    }
}
