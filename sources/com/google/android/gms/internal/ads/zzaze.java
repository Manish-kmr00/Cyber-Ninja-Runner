package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzaze implements Runnable {
    final ValueCallback zza;
    final /* synthetic */ zzayw zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzazg zze;

    zzaze(zzazg zzazgVar, final zzayw zzaywVar, final WebView webView, final boolean z) {
        this.zzb = zzaywVar;
        this.zzc = webView;
        this.zzd = z;
        this.zze = zzazgVar;
        this.zza = new ValueCallback() { // from class: com.google.android.gms.internal.ads.zzazd
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                this.zza.zze.zzc(zzaywVar, webView, (String) obj, z);
            }
        };
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView = this.zzc;
        if (webView.getSettings().getJavaScriptEnabled()) {
            try {
                webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
