package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfjx {
    private final zzfki zza;
    private final WebView zzb;
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();
    private final String zze;
    private final String zzf;
    private final zzfjy zzg;

    private zzfjx(zzfki zzfkiVar, WebView webView, String str, List list, String str2, String str3, zzfjy zzfjyVar) {
        this.zza = zzfkiVar;
        this.zzb = webView;
        this.zzg = zzfjyVar;
        this.zzf = str2;
        this.zze = str3;
    }

    public static zzfjx zzb(zzfki zzfkiVar, WebView webView, String str, String str2) {
        if (str2 != null) {
            zzflr.zzd(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new zzfjx(zzfkiVar, webView, null, null, str, str2, zzfjy.HTML);
    }

    public static zzfjx zzc(zzfki zzfkiVar, WebView webView, String str, String str2) {
        zzflr.zzd("", 256, "CustomReferenceData is greater than 256 characters");
        return new zzfjx(zzfkiVar, webView, null, null, str, "", zzfjy.JAVASCRIPT);
    }

    public final WebView zza() {
        return this.zzb;
    }

    public final zzfjy zzd() {
        return this.zzg;
    }

    public final zzfki zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zze;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map zzi() {
        return Collections.unmodifiableMap(this.zzd);
    }
}
