package com.bytedance.sdk.openadsdk.core.widget.pA;

import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes7.dex */
public class Og implements pA {
    private final AtomicInteger KZx;
    private final boolean ML;
    private com.bytedance.sdk.component.Bzk.ZZv Og;
    private final MessageQueue ZZv;
    IG pA;

    public Og(int i, boolean z, MessageQueue messageQueue) {
        this.KZx = new AtomicInteger(i);
        this.ML = z;
        this.ZZv = messageQueue;
    }

    public void Og() {
        if (this.KZx.get() <= 0) {
            return;
        }
        new StringBuilder("preload start ,isV3 = ").append(this.ML).append(",preloadSize = ").append(this.KZx);
        String strZZv = com.bytedance.sdk.component.adexpress.pA.Og.Og.ZZv(null);
        if (this.ML) {
            String strZZv2 = com.bytedance.sdk.component.adexpress.pA.Og.Og.ZZv("v3");
            if (strZZv != null && strZZv.equals(strZZv2)) {
                return;
            } else {
                strZZv = strZZv2;
            }
        }
        if (TextUtils.isEmpty(strZZv)) {
            return;
        }
        try {
            com.bytedance.sdk.component.Bzk.ZZv zZv = new com.bytedance.sdk.component.Bzk.ZZv(new MutableContextWrapper(aBv.pA()));
            this.Og = zZv;
            if (zZv.getWebView() == null) {
                return;
            }
            this.Og.setWebViewClient(new WebViewClient() { // from class: com.bytedance.sdk.openadsdk.core.widget.pA.Og.1
                @Override // android.webkit.WebViewClient
                public void onLoadResource(WebView view, String url) {
                    super.onLoadResource(view, url);
                    CreativeInfoManager.onResourceLoaded(h.u, view, url);
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    BrandSafetyUtils.onWebViewPageFinished(h.u, view, url);
                }

                @Override // android.webkit.WebViewClient
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    BrandSafetyUtils.onWebViewPageStarted(h.u, view, url);
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    super.onReceivedError(view, errorCode, description, failingUrl);
                    BrandSafetyUtils.onWebViewReceivedError(h.u, view, errorCode, description, failingUrl);
                }

                @Override // android.webkit.WebViewClient
                public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                    return true;
                }

                @Override // android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
                    return CreativeInfoManager.onWebViewResponseWithHeaders(h.u, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
                    BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, view, url, zShouldOverrideUrlLoading);
                    return zShouldOverrideUrlLoading;
                }
            });
            pA(this.Og);
            Uri uriBuild = Uri.parse(strZZv).buildUpon().appendQueryParameter("isPreLoad", "1").build();
            IG ig = new IG(this.Og.getContext());
            this.pA = ig;
            ig.Og(this.Og).pA(this).pA(this.Og);
            com.bytedance.sdk.component.adexpress.ML.ML.pA().pA(this.Og, this.pA);
            this.Og.a_(uriBuild.toString());
        } catch (Exception unused) {
        }
    }

    private void pA(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        if (zZv == null || zZv.getWebView() == null) {
            return;
        }
        try {
            KZx.pA(aBv.pA()).pA(false).pA(zZv.getWebView());
            zZv.setVerticalScrollBarEnabled(false);
            zZv.setHorizontalScrollBarEnabled(false);
            KZx.pA(zZv);
            zZv.SGo();
            zZv.setUserAgentString(com.bytedance.sdk.openadsdk.utils.aBv.pA(zZv.getWebView(), BuildConfig.VERSION_CODE));
            zZv.setMixedContentMode(0);
            zZv.setJavaScriptEnabled(true);
            zZv.setJavaScriptCanOpenWindowsAutomatically(true);
            zZv.setDomStorageEnabled(true);
            zZv.setDatabaseEnabled(true);
            zZv.setCacheMode(-1);
            zZv.setAllowFileAccess(false);
            zZv.setSupportZoom(true);
            zZv.setBuiltInZoomControls(true);
            zZv.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            zZv.setUseWideViewPort(true);
        } catch (Throwable th) {
            WV.pA("WebViewPool", th.toString());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.pA.pA
    public void pA() {
        MessageQueue messageQueue;
        if (this.ML) {
            com.bytedance.sdk.component.adexpress.ML.ML.pA().Og(this.Og);
        } else {
            com.bytedance.sdk.component.adexpress.ML.ML.pA().KZx(this.Og);
        }
        try {
            new Object[]{"preload finish ", Integer.valueOf(this.KZx.get()), "isV3 ?? ", Boolean.valueOf(this.ML)};
            this.KZx.decrementAndGet();
            if (this.KZx.get() <= 0 || (messageQueue = this.ZZv) == null) {
                return;
            }
            messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.sdk.openadsdk.core.widget.pA.Og.2
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    new Og(Og.this.KZx.get(), Og.this.ML, Og.this.ZZv).Og();
                    return false;
                }
            });
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
