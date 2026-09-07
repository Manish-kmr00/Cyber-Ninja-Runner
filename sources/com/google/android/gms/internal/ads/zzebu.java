package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzebu implements zzebv {
    static /* synthetic */ zzeca zzc(String str, String str2, String str3, zzebw zzebwVar, String str4, WebView webView, String str5, String str6, zzebx zzebxVar) {
        zzfki zzfkiVarZza = zzfki.zza("Google", str2);
        zzfkh zzfkhVarZzp = zzp("javascript");
        zzfka zzfkaVarZzn = zzn(zzebwVar.toString());
        if (zzfkhVarZzp == zzfkh.NONE) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzfkaVarZzn == null) {
            String strValueOf = String.valueOf(String.valueOf(zzebwVar));
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid html session error; Unable to parse creative type: ".concat(strValueOf));
            return null;
        }
        zzfkh zzfkhVarZzp2 = zzp(str4);
        if (zzfkaVarZzn != zzfka.VIDEO || zzfkhVarZzp2 != zzfkh.NONE) {
            zzfjx zzfjxVarZzb = zzfjx.zzb(zzfkiVarZza, webView, str5, "");
            return new zzeca(zzfjv.zza(zzfjw.zza(zzfkaVarZzn, zzo(zzebxVar.toString()), zzfkhVarZzp, zzfkhVarZzp2, true), zzfjxVarZzb), zzfjxVarZzb);
        }
        String strValueOf2 = String.valueOf(str4);
        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid html session error; Video events owner unknown for video creative: ".concat(strValueOf2));
        return null;
    }

    static /* synthetic */ zzeca zzd(String str, String str2, String str3, String str4, zzebw zzebwVar, WebView webView, String str5, String str6, zzebx zzebxVar) {
        zzfki zzfkiVarZza = zzfki.zza(str, str2);
        zzfkh zzfkhVarZzp = zzp("javascript");
        zzfkh zzfkhVarZzp2 = zzp(str4);
        zzfka zzfkaVarZzn = zzn(zzebwVar.toString());
        if (zzfkhVarZzp == zzfkh.NONE) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzfkaVarZzn == null) {
            String strValueOf = String.valueOf(String.valueOf(zzebwVar));
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid js session error; Unable to parse creative type: ".concat(strValueOf));
            return null;
        }
        if (zzfkaVarZzn != zzfka.VIDEO || zzfkhVarZzp2 != zzfkh.NONE) {
            zzfjx zzfjxVarZzc = zzfjx.zzc(zzfkiVarZza, webView, str5, "");
            return new zzeca(zzfjv.zza(zzfjw.zza(zzfkaVarZzn, zzo(zzebxVar.toString()), zzfkhVarZzp, zzfkhVarZzp2, true), zzfjxVarZzc), zzfjxVarZzc);
        }
        String strValueOf2 = String.valueOf(str4);
        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid js session error; Video events owner unknown for video creative: ".concat(strValueOf2));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    private static zzfka zzn(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -382745961) {
            if (iHashCode != 112202875) {
                if (iHashCode == 714893483 && str.equals("nativeDisplay")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (str.equals("video")) {
                b = 2;
            } else {
                b = -1;
            }
        } else if (str.equals("htmlDisplay")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            return zzfka.HTML_DISPLAY;
        }
        if (b == 1) {
            return zzfka.NATIVE_DISPLAY;
        }
        if (b != 2) {
            return null;
        }
        return zzfka.VIDEO;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    private static zzfkd zzo(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1104128070) {
            if (iHashCode != 1318088141) {
                if (iHashCode == 1988248512 && str.equals("onePixel")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("definedByJavascript")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("beginToRender")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            return zzfkd.BEGIN_TO_RENDER;
        }
        if (b != 1) {
            return b != 2 ? zzfkd.UNSPECIFIED : zzfkd.ONE_PIXEL;
        }
        return zzfkd.DEFINED_BY_JAVASCRIPT;
    }

    private static zzfkh zzp(String str) {
        if ("native".equals(str)) {
            return zzfkh.NATIVE;
        }
        return "javascript".equals(str) ? zzfkh.JAVASCRIPT : zzfkh.NONE;
    }

    private static final Object zzq(zzebt zzebtVar) {
        try {
            return zzebtVar.zza();
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "omid exception");
            return null;
        }
    }

    private static final void zzr(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "omid exception");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebv
    public final zzeca zza(final String str, final WebView webView, String str2, String str3, final String str4, final zzebx zzebxVar, final zzebw zzebwVar, final String str5) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfm)).booleanValue() || !zzfjt.zzb()) {
            return null;
        }
        final String str6 = "javascript";
        final String str7 = "Google";
        final String str8 = "";
        return (zzeca) zzq(new zzebt(str7, str, str6, zzebwVar, str4, webView, str5, str8, zzebxVar) { // from class: com.google.android.gms.internal.ads.zzebj
            public final /* synthetic */ String zzb;
            public final /* synthetic */ zzebw zzd;
            public final /* synthetic */ String zze;
            public final /* synthetic */ WebView zzf;
            public final /* synthetic */ String zzg;
            public final /* synthetic */ zzebx zzi;
            public final /* synthetic */ String zza = "Google";
            public final /* synthetic */ String zzc = "javascript";
            public final /* synthetic */ String zzh = "";

            {
                this.zzb = str;
                this.zzd = zzebwVar;
                this.zze = str4;
                this.zzf = webView;
                this.zzg = str5;
                this.zzi = zzebxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzebt
            public final Object zza() {
                return zzebu.zzc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzebv
    public final zzeca zzb(final String str, final WebView webView, String str2, String str3, final String str4, final String str5, final zzebx zzebxVar, final zzebw zzebwVar, final String str6) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfm)).booleanValue() || !zzfjt.zzb()) {
            return null;
        }
        final String str7 = "";
        final String str8 = "javascript";
        return (zzeca) zzq(new zzebt(str5, str, str8, str4, zzebwVar, webView, str6, str7, zzebxVar) { // from class: com.google.android.gms.internal.ads.zzebm
            public final /* synthetic */ String zza;
            public final /* synthetic */ String zzb;
            public final /* synthetic */ String zzd;
            public final /* synthetic */ zzebw zze;
            public final /* synthetic */ WebView zzf;
            public final /* synthetic */ String zzg;
            public final /* synthetic */ zzebx zzi;
            public final /* synthetic */ String zzc = "javascript";
            public final /* synthetic */ String zzh = "";

            {
                this.zzd = str4;
                this.zze = zzebwVar;
                this.zzf = webView;
                this.zzg = str6;
                this.zzi = zzebxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzebt
            public final Object zza() {
                return zzebu.zzd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzebv
    public final zzfkg zze(final VersionInfoParcel versionInfoParcel, final WebView webView, boolean z) {
        final boolean z2 = true;
        return (zzfkg) zzq(new zzebt(webView, z2) { // from class: com.google.android.gms.internal.ads.zzebr
            public final /* synthetic */ WebView zzb;

            @Override // com.google.android.gms.internal.ads.zzebt
            public final Object zza() {
                VersionInfoParcel versionInfoParcel2 = this.zza;
                return zzfkg.zzb(zzfki.zza("Google", versionInfoParcel2.buddyApkVersion + "." + versionInfoParcel2.clientJarVersion), this.zzb, true);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzebv
    public final String zzf(Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfm)).booleanValue()) {
            return (String) zzq(new zzebt() { // from class: com.google.android.gms.internal.ads.zzebp
                @Override // com.google.android.gms.internal.ads.zzebt
                public final Object zza() {
                    return "a.1.5.2-google_20241009";
                }
            });
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzebv
    public final void zzg(final zzfjv zzfjvVar, final View view) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebi
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfm)).booleanValue() && zzfjt.zzb()) {
                    zzfjvVar.zzb(view, zzfkc.NOT_VISIBLE, "Ad overlay");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzebv
    public final void zzh(final zzfkg zzfkgVar, final View view) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebo
            @Override // java.lang.Runnable
            public final void run() {
                zzfkgVar.zzf(view, zzfkc.NOT_VISIBLE, "Ad overlay");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzebv
    public final void zzi(final zzfjv zzfjvVar) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebs
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfm)).booleanValue() && zzfjt.zzb()) {
                    zzfjvVar.zzc();
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzebv
    public final void zzj(final zzfjv zzfjvVar, final View view) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebk
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfm)).booleanValue() && zzfjt.zzb()) {
                    zzfjvVar.zzd(view);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzebv
    public final void zzk(final zzfjv zzfjvVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfm)).booleanValue() && zzfjt.zzb()) {
            Objects.requireNonNull(zzfjvVar);
            zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebl
                @Override // java.lang.Runnable
                public final void run() {
                    zzfjvVar.zze();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebv
    public final boolean zzl(final Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfm)).booleanValue()) {
            Boolean bool = (Boolean) zzq(new zzebt() { // from class: com.google.android.gms.internal.ads.zzebn
                @Override // com.google.android.gms.internal.ads.zzebt
                public final Object zza() {
                    if (zzfjt.zzb()) {
                        return true;
                    }
                    zzfjt.zza(context);
                    return Boolean.valueOf(zzfjt.zzb());
                }
            });
            return bool != null && bool.booleanValue();
        }
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid flag is disabled");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzebv
    public final void zzm(final zzfkg zzfkgVar, final zzcfc zzcfcVar) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebq
            @Override // java.lang.Runnable
            public final void run() {
                zzfkgVar.zzg(zzcfcVar);
            }
        });
    }
}
