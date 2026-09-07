package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcfu extends zzcft {
    public zzcfu(zzcel zzcelVar, zzbbg zzbbgVar, boolean z, zzebe zzebeVar) {
        super(zzcelVar, zzbbgVar, z, zzebeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcft, com.google.android.gms.internal.ads.zzcet, android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(h.h, view, url);
    }

    public WebResourceResponse safedk_zzcfu_shouldInterceptRequest_45d2792655afec1ca8d1fe85dadaa4aa(WebView p0, WebResourceRequest p1) {
        if (p1 == null || p1.getUrl() == null) {
            return null;
        }
        return zzW(p0, p1.getUrl().toString(), p1.getRequestHeaders());
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/ads/zzcfu;->shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponseWithHeaders(h.h, webView, webResourceRequest, safedk_zzcfu_shouldInterceptRequest_45d2792655afec1ca8d1fe85dadaa4aa(webView, webResourceRequest));
    }
}
