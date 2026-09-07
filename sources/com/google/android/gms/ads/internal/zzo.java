package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzfcq;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzo extends WebViewClient {
    final /* synthetic */ zzu zza;

    zzo(zzu zzuVar) {
        this.zza = zzuVar;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(h.h, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        BrandSafetyUtils.onWebViewPageFinished(h.h, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(h.h, view, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/ads/internal/zzo;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.h, webView, webResourceRequest, webResourceError);
        safedk_zzo_onReceivedError_755510dbf45b221b70af277c25e4ddd0(webView, webResourceRequest, webResourceError);
    }

    public void safedk_zzo_onReceivedError_755510dbf45b221b70af277c25e4ddd0(WebView p0, WebResourceRequest p1, WebResourceError p2) {
        zzu zzuVar = this.zza;
        if (zzuVar.zzg != null) {
            try {
                zzuVar.zzg.zzf(zzfcq.zzd(1, null, null));
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            }
        }
        zzu zzuVar2 = this.zza;
        if (zzuVar2.zzg != null) {
            try {
                zzuVar2.zzg.zze(0);
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e2);
            }
        }
    }

    public boolean safedk_zzo_shouldOverrideUrlLoading_d3d4e73010143acf73d406f77cfb80c7(WebView p0, String p1) {
        zzu zzuVar = this.zza;
        if (p1.startsWith(zzuVar.zzq())) {
            return false;
        }
        if (p1.startsWith("gmsg://noAdLoaded")) {
            if (zzuVar.zzg != null) {
                try {
                    zzuVar.zzg.zzf(zzfcq.zzd(3, null, null));
                } catch (RemoteException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                }
            }
            zzu zzuVar2 = this.zza;
            if (zzuVar2.zzg != null) {
                try {
                    zzuVar2.zzg.zze(3);
                } catch (RemoteException e2) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e2);
                }
            }
            this.zza.zzV(0);
            return true;
        }
        if (p1.startsWith("gmsg://scriptLoadFailed")) {
            zzu zzuVar3 = this.zza;
            if (zzuVar3.zzg != null) {
                try {
                    zzuVar3.zzg.zzf(zzfcq.zzd(1, null, null));
                } catch (RemoteException e3) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e3);
                }
            }
            zzu zzuVar4 = this.zza;
            if (zzuVar4.zzg != null) {
                try {
                    zzuVar4.zzg.zze(0);
                } catch (RemoteException e4) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e4);
                }
            }
            this.zza.zzV(0);
            return true;
        }
        if (p1.startsWith("gmsg://adResized")) {
            zzu zzuVar5 = this.zza;
            if (zzuVar5.zzg != null) {
                try {
                    zzuVar5.zzg.zzi();
                } catch (RemoteException e5) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e5);
                }
            }
            zzu zzuVar6 = this.zza;
            zzuVar6.zzV(zzuVar6.zzb(p1));
            return true;
        }
        if (p1.startsWith("gmsg://")) {
            return true;
        }
        zzu zzuVar7 = this.zza;
        if (zzuVar7.zzg != null) {
            try {
                zzuVar7.zzg.zzc();
                zzuVar7.zzg.zzh();
            } catch (RemoteException e6) {
                int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e6);
            }
        }
        zzu zzuVar8 = this.zza;
        zzu.zzw(zzuVar8, zzu.zzo(zzuVar8, p1));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(h.h, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/ads/internal/zzo;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_zzo_shouldOverrideUrlLoading_d3d4e73010143acf73d406f77cfb80c7 = safedk_zzo_shouldOverrideUrlLoading_d3d4e73010143acf73d406f77cfb80c7(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.h, webView, str, zSafedk_zzo_shouldOverrideUrlLoading_d3d4e73010143acf73d406f77cfb80c7);
        return zSafedk_zzo_shouldOverrideUrlLoading_d3d4e73010143acf73d406f77cfb80c7;
    }
}
