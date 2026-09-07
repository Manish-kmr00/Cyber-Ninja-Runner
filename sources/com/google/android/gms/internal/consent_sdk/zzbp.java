package com.google.android.gms.internal.consent_sdk;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbp extends WebViewClient {
    final /* synthetic */ zzbr zza;

    /* synthetic */ zzbp(zzbr zzbrVar, zzbq zzbqVar) {
        this.zza = zzbrVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/consent_sdk/zzbp;->onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V");
        CreativeInfoManager.onResourceLoaded(h.h, webView, str);
        safedk_zzbp_onLoadResource_8473a8d936f4808be0e8ca22056eda20(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/consent_sdk/zzbp;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(h.h, webView, str);
        safedk_zzbp_onPageFinished_5ec2e4b2cef2c99d88eac8620196853d(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(h.h, view, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/consent_sdk/zzbp;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.h, webView, i, str, str2);
        safedk_zzbp_onReceivedError_57436a8d9bcaf4979ca15e6886cc0b9c(webView, i, str, str2);
    }

    public void safedk_zzbp_onLoadResource_8473a8d936f4808be0e8ca22056eda20(WebView p0, String p1) {
        if (zzbr.zzf(this.zza, p1)) {
            this.zza.zzb.zze(p1);
        }
    }

    public void safedk_zzbp_onPageFinished_5ec2e4b2cef2c99d88eac8620196853d(WebView p0, String p1) {
        if (this.zza.zzc) {
            return;
        }
        Log.d("UserMessagingPlatform", "Wall html loaded.");
        this.zza.zzc = true;
    }

    public void safedk_zzbp_onReceivedError_57436a8d9bcaf4979ca15e6886cc0b9c(WebView p0, int p1, String p2, String p3) {
        this.zza.zzb.zzf(p1, p2, p3);
    }

    public boolean safedk_zzbp_shouldOverrideUrlLoading_475b395086d5af16405d7a5a99d1ae3e(WebView p0, WebResourceRequest p1) {
        String string = p1.getUrl().toString();
        if (!zzbr.zzf(this.zza, string)) {
            return false;
        }
        this.zza.zzb.zze(string);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(h.h, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/consent_sdk/zzbp;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_zzbp_shouldOverrideUrlLoading_475b395086d5af16405d7a5a99d1ae3e = safedk_zzbp_shouldOverrideUrlLoading_475b395086d5af16405d7a5a99d1ae3e(webView, webResourceRequest);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.h, webView, webResourceRequest, zSafedk_zzbp_shouldOverrideUrlLoading_475b395086d5af16405d7a5a99d1ae3e);
        return zSafedk_zzbp_shouldOverrideUrlLoading_475b395086d5af16405d7a5a99d1ae3e;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/consent_sdk/zzbp;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_zzbp_shouldOverrideUrlLoading_3e0c7d176bb341beca34a1b76faeeb98 = safedk_zzbp_shouldOverrideUrlLoading_3e0c7d176bb341beca34a1b76faeeb98(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.h, webView, str, zSafedk_zzbp_shouldOverrideUrlLoading_3e0c7d176bb341beca34a1b76faeeb98);
        return zSafedk_zzbp_shouldOverrideUrlLoading_3e0c7d176bb341beca34a1b76faeeb98;
    }

    public boolean safedk_zzbp_shouldOverrideUrlLoading_3e0c7d176bb341beca34a1b76faeeb98(WebView p0, String p1) {
        if (!zzbr.zzf(this.zza, p1)) {
            return false;
        }
        this.zza.zzb.zze(p1);
        return true;
    }
}
