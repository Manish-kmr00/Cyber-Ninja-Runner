package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbnb implements zzbzt {
    final /* synthetic */ zzbnl zza;
    final /* synthetic */ zzfgc zzb;
    final /* synthetic */ zzbnm zzc;

    zzbnb(zzbnm zzbnmVar, zzbnl zzbnlVar, zzfgc zzfgcVar) {
        this.zza = zzbnlVar;
        this.zzb = zzfgcVar;
        this.zzc = zzbnmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzt
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Trying to acquire lock");
        zzbnm zzbnmVar = this.zzc;
        synchronized (zzbnmVar.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Lock acquired");
            zzbnmVar.zzi = 0;
            if (zzbnmVar.zzh != null && this.zza != zzbnmVar.zzh) {
                com.google.android.gms.ads.internal.util.zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                zzbnmVar.zzh.zzb();
            }
            zzbnmVar.zzh = this.zza;
            if (((Boolean) zzbeb.zzd.zze()).booleanValue() && zzbnmVar.zze != null) {
                zzfgq zzfgqVar = zzbnmVar.zze;
                zzfgc zzfgcVar = this.zzb;
                zzfgcVar.zzg(true);
                zzfgqVar.zzc(zzfgcVar.zzm());
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Lock released");
    }
}
