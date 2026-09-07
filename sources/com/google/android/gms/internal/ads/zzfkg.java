package com.google.android.gms.internal.ads;

import android.view.View;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfkg {
    private final zzfki zza;
    private final WebView zzb;
    private zzfmi zzc;
    private final HashMap zzd;
    private final zzfkv zze;

    private zzfkg(zzfki zzfkiVar, WebView webView, boolean z) {
        HashMap map = new HashMap();
        this.zzd = map;
        this.zze = new zzfkv();
        zzflr.zza();
        this.zza = zzfkiVar;
        this.zzb = webView;
        if (zza() != webView) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((zzfjv) it.next()).zzd(webView);
            }
            this.zzc = new zzfmi(webView);
        }
        if (!WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
            throw new UnsupportedOperationException("The JavaScriptSessionService cannot be supported in this WebView version.");
        }
        zzh();
        WebViewCompat.addWebMessageListener(this.zzb, "omidJsSessionService", new HashSet(Arrays.asList("*")), new zzfkf(this));
    }

    public static zzfkg zzb(zzfki zzfkiVar, WebView webView, boolean z) {
        return new zzfkg(zzfkiVar, webView, true);
    }

    static /* bridge */ /* synthetic */ void zzc(zzfkg zzfkgVar, String str) {
        HashMap map = zzfkgVar.zzd;
        zzfjv zzfjvVar = (zzfjv) map.get(str);
        if (zzfjvVar != null) {
            zzfjvVar.zzc();
            map.remove(str);
        }
    }

    static /* bridge */ /* synthetic */ void zze(zzfkg zzfkgVar, String str) {
        zzfjz zzfjzVar = new zzfjz(zzfjw.zza(zzfka.DEFINED_BY_JAVASCRIPT, zzfkd.DEFINED_BY_JAVASCRIPT, zzfkh.JAVASCRIPT, zzfkh.JAVASCRIPT, false), zzfjx.zzb(zzfkgVar.zza, zzfkgVar.zzb, null, null), str);
        zzfkgVar.zzd.put(str, zzfjzVar);
        zzfjzVar.zzd(zzfkgVar.zza());
        for (zzfku zzfkuVar : zzfkgVar.zze.zza()) {
            zzfjzVar.zzb((View) zzfkuVar.zzb().get(), zzfkuVar.zza(), zzfkuVar.zzc());
        }
        zzfjzVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzh() {
        WebViewCompat.removeWebMessageListener(this.zzb, "omidJsSessionService");
    }

    final View zza() {
        zzfmi zzfmiVar = this.zzc;
        if (zzfmiVar == null) {
            return null;
        }
        return (View) zzfmiVar.get();
    }

    public final void zzf(View view, zzfkc zzfkcVar, String str) {
        Iterator it = this.zzd.values().iterator();
        while (it.hasNext()) {
            ((zzfjv) it.next()).zzb(view, zzfkcVar, "Ad overlay");
        }
        this.zze.zzb(view, zzfkcVar, "Ad overlay");
    }

    public final void zzg(zzcfc zzcfcVar) {
        Iterator it = this.zzd.values().iterator();
        while (it.hasNext()) {
            ((zzfjv) it.next()).zzc();
        }
        Timer timer = new Timer();
        timer.schedule(new zzfke(this, zzcfcVar, timer), 1000L);
    }
}
