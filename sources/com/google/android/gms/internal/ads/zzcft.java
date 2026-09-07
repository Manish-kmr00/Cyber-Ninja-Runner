package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.h;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public class zzcft extends zzcet {
    public zzcft(zzcel zzcelVar, zzbbg zzbbgVar, boolean z, zzebe zzebeVar) {
        super(zzcelVar, zzbbgVar, z, new zzbsb(zzcelVar, zzcelVar.zzE(), new zzbbq(zzcelVar.getContext())), null, zzebeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcet, android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(h.h, view, url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final WebResourceResponse zzW(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzcel)) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcel zzcelVar = (zzcel) webView;
        zzbxi zzbxiVar = this.zza;
        if (zzbxiVar != null) {
            zzbxiVar.zze(str, map, 1);
        }
        zzfpb.zza();
        zzfph zzfphVar = zzfph.zza;
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzcelVar.zzN() != null) {
            zzcelVar.zzN().zzH();
        }
        if (zzcelVar.zzO().zzi()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzad);
        } else if (zzcelVar.zzaF()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzac);
        } else {
            str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzab);
        }
        com.google.android.gms.ads.internal.zzv.zzq();
        return com.google.android.gms.ads.internal.util.zzs.zzy(zzcelVar.getContext(), zzcelVar.zzm().afmaVersion, str2);
    }
}
