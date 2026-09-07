package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbnc implements zzbzr {
    final /* synthetic */ zzbnl zza;
    final /* synthetic */ zzfgc zzb;
    final /* synthetic */ zzbnm zzc;

    zzbnc(zzbnm zzbnmVar, zzbnl zzbnlVar, zzfgc zzfgcVar) {
        this.zza = zzbnlVar;
        this.zzb = zzfgcVar;
        this.zzc = zzbnmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzr
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Trying to acquire lock");
        zzbnm zzbnmVar = this.zzc;
        synchronized (zzbnmVar.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock acquired");
            zzbnmVar.zzi = 1;
            com.google.android.gms.ads.internal.util.zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
            if (((Boolean) zzbeb.zzd.zze()).booleanValue() && zzbnmVar.zze != null) {
                zzfgq zzfgqVar = zzbnmVar.zze;
                zzfgc zzfgcVar = this.zzb;
                zzfgcVar.zzc("Failed loading new engine");
                zzfgcVar.zzg(false);
                zzfgqVar.zzc(zzfgcVar.zzm());
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock released");
    }
}
