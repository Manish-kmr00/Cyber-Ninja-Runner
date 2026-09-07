package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.h5.H5AdsRequestHandler;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzbkr extends zzbke {
    public static final /* synthetic */ int zza = 0;
    private WebViewClient zzb;
    private final H5AdsRequestHandler zzc;
    private final WebView zzd;

    public zzbkr(Context context, final WebView webView) {
        context.getClass();
        webView.getClass();
        zzftw.zzf(webView.getSettings().getJavaScriptEnabled(), "JavaScript must be enabled on the WebView.");
        this.zzd = webView;
        this.zzc = new H5AdsRequestHandler(context, new OnH5AdsEventListener() { // from class: com.google.android.gms.internal.ads.zzbkq
            @Override // com.google.android.gms.ads.h5.OnH5AdsEventListener
            public final void onH5AdsEvent(String str) {
                int i = zzbkr.zza;
                webView.evaluateJavascript(str, null);
            }
        });
    }

    private final boolean zzc(WebView webView) {
        if (this.zzd.equals(webView)) {
            return true;
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzg("H5AdsWebViewClient must be attached to the same WebVew which was passed in the constructor.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbke
    public final WebViewClient getDelegate() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbke, android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/ads/zzbkr;->onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V");
        CreativeInfoManager.onResourceLoaded(h.h, webView, str);
        safedk_zzbkr_onLoadResource_377134bc650b68c4d88a91a8488e1ea9(webView, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbke, android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        BrandSafetyUtils.onWebViewPageFinished(h.h, view, url);
    }

    @Override // com.google.android.gms.internal.ads.zzbke, android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(h.h, view, url);
    }

    @Override // com.google.android.gms.internal.ads.zzbke, android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        BrandSafetyUtils.onWebViewReceivedError(h.h, view, errorCode, description, failingUrl);
    }

    public void safedk_zzbkr_onLoadResource_377134bc650b68c4d88a91a8488e1ea9(WebView p0, String p1) {
        if (zzc(p0) && !this.zzc.handleH5AdsRequest(p1)) {
            super.onLoadResource(p0, p1);
        }
    }

    public boolean safedk_zzbkr_shouldOverrideUrlLoading_1b2c2c39e5887c9e7a7bc0e07220d874(WebView p0, WebResourceRequest p1) {
        if (!zzc(this.zzd)) {
            return false;
        }
        if (this.zzc.handleH5AdsRequest(p1.getUrl().toString())) {
            return true;
        }
        return super.shouldOverrideUrlLoading(p0, p1);
    }

    @Override // com.google.android.gms.internal.ads.zzbke, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(h.h, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // com.google.android.gms.internal.ads.zzbke, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/ads/zzbkr;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_zzbkr_shouldOverrideUrlLoading_1b2c2c39e5887c9e7a7bc0e07220d874 = safedk_zzbkr_shouldOverrideUrlLoading_1b2c2c39e5887c9e7a7bc0e07220d874(webView, webResourceRequest);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.h, webView, webResourceRequest, zSafedk_zzbkr_shouldOverrideUrlLoading_1b2c2c39e5887c9e7a7bc0e07220d874);
        return zSafedk_zzbkr_shouldOverrideUrlLoading_1b2c2c39e5887c9e7a7bc0e07220d874;
    }

    @Override // com.google.android.gms.internal.ads.zzbke, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/ads/zzbkr;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_zzbkr_shouldOverrideUrlLoading_7abeb91fac2cda76ab4b7a904f9753bf = safedk_zzbkr_shouldOverrideUrlLoading_7abeb91fac2cda76ab4b7a904f9753bf(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.h, webView, str, zSafedk_zzbkr_shouldOverrideUrlLoading_7abeb91fac2cda76ab4b7a904f9753bf);
        return zSafedk_zzbkr_shouldOverrideUrlLoading_7abeb91fac2cda76ab4b7a904f9753bf;
    }

    public final void zza() {
        this.zzc.clearAdObjects();
    }

    public final void zzb(WebViewClient webViewClient) {
        zzftw.zzf(webViewClient != this, "Delegate cannot be itself.");
        this.zzb = webViewClient;
    }

    public boolean safedk_zzbkr_shouldOverrideUrlLoading_7abeb91fac2cda76ab4b7a904f9753bf(WebView p0, String p1) {
        if (!zzc(p0)) {
            return false;
        }
        if (this.zzc.handleH5AdsRequest(p1)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(p0, p1);
    }
}
