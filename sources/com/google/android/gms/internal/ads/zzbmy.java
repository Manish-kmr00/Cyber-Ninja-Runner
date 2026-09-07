package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbmy implements zzbjj {
    final /* synthetic */ zzbmh zza;
    final /* synthetic */ com.google.android.gms.ads.internal.util.zzby zzb;
    final /* synthetic */ zzbnm zzc;

    zzbmy(zzbnm zzbnmVar, zzauy zzauyVar, zzbmh zzbmhVar, com.google.android.gms.ads.internal.util.zzby zzbyVar) {
        this.zza = zzbmhVar;
        this.zzb = zzbyVar;
        this.zzc = zzbnmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /requestReload handler: Trying to acquire lock");
        zzbnm zzbnmVar = this.zzc;
        synchronized (zzbnmVar.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /requestReload handler: Lock acquired");
            com.google.android.gms.ads.internal.util.client.zzo.zzi("JS Engine is requesting an update");
            if (zzbnmVar.zzi == 0) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Starting reload.");
                zzbnmVar.zzi = 2;
                zzbnmVar.zzd(null);
            }
            this.zza.zzr("/requestReload", (zzbjj) this.zzb.zza());
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /requestReload handler: Lock released");
    }
}
