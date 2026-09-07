package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbmx implements zzbjj {
    final /* synthetic */ long zza;
    final /* synthetic */ zzbnl zzb;
    final /* synthetic */ zzbmh zzc;
    final /* synthetic */ zzbnm zzd;

    zzbmx(zzbnm zzbnmVar, long j, zzbnl zzbnlVar, zzbmh zzbmhVar) {
        this.zza = j;
        this.zzb = zzbnlVar;
        this.zzc = zzbmhVar;
        this.zzd = zzbnmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        com.google.android.gms.ads.internal.util.zze.zza("onGmsg /jsLoaded. JsLoaded latency is " + (com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() - this.zza) + " ms.");
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Trying to acquire lock");
        zzbnm zzbnmVar = this.zzd;
        synchronized (zzbnmVar.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock acquired");
            zzbnl zzbnlVar = this.zzb;
            if (zzbnlVar.zze() != -1 && zzbnlVar.zze() != 1) {
                zzbnmVar.zzi = 0;
                zzbmh zzbmhVar = this.zzc;
                zzbmhVar.zzq("/log", zzbji.zzg);
                zzbmhVar.zzq("/result", zzbji.zzo);
                zzbnlVar.zzi(zzbmhVar);
                zzbnmVar.zzh = zzbnlVar;
                com.google.android.gms.ads.internal.util.zze.zza("Successfully loaded JS Engine.");
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released");
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released, the promise is already settled");
        }
    }
}
