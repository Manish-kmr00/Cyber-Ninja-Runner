package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcfr {
    private final zzcfs zza;
    private final zzcfq zzb;

    public zzcfr(zzcfs zzcfsVar, zzcfq zzcfqVar) {
        this.zzb = zzcfqVar;
        this.zza = zzcfsVar;
    }

    public static /* synthetic */ void zza(zzcfr zzcfrVar, String str) {
        Uri uri = Uri.parse(str);
        zzcet zzcetVarZzaO = ((zzcfk) zzcfrVar.zzb.zza).zzaO();
        if (zzcetVarZzaO != null) {
            zzcetVarZzaO.zzn(uri);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        }
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        zzcfs zzcfsVar = this.zza;
        zzauy zzauyVarZzI = ((zzcfy) zzcfsVar).zzI();
        if (zzauyVarZzI == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzaut zzautVarZzc = zzauyVarZzI.zzc();
        if (zzautVarZzc == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signals object is empty, ignoring.");
            return "";
        }
        if (zzcfsVar.getContext() != null) {
            return zzautVarZzc.zze(zzcfsVar.getContext(), str, ((zzcga) zzcfsVar).zzF(), zzcfsVar.zzi());
        }
        com.google.android.gms.ads.internal.util.zze.zza("Context is null, ignoring.");
        return "";
    }

    @JavascriptInterface
    public String getViewSignals() {
        zzcfs zzcfsVar = this.zza;
        zzauy zzauyVarZzI = ((zzcfy) zzcfsVar).zzI();
        if (zzauyVarZzI == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzaut zzautVarZzc = zzauyVarZzI.zzc();
        if (zzautVarZzc == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signals object is empty, ignoring.");
            return "";
        }
        if (zzcfsVar.getContext() != null) {
            return zzautVarZzc.zzh(zzcfsVar.getContext(), ((zzcga) zzcfsVar).zzF(), zzcfsVar.zzi());
        }
        com.google.android.gms.ads.internal.util.zze.zza("Context is null, ignoring.");
        return "";
    }

    @JavascriptInterface
    public void notify(final String str) {
        if (!TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfp
                @Override // java.lang.Runnable
                public final void run() {
                    zzcfr.zza(this.zza, str);
                }
            });
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("URL is empty, ignoring message");
        }
    }
}
