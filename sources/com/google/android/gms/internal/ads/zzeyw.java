package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzeyw implements zzgbo {
    final /* synthetic */ zzekg zza;
    final /* synthetic */ zzfgn zzb;
    final /* synthetic */ zzfgc zzc;
    final /* synthetic */ zzdfe zzd;
    final /* synthetic */ zzeyx zze;

    zzeyw(zzeyx zzeyxVar, zzekg zzekgVar, zzfgn zzfgnVar, zzfgc zzfgcVar, zzdfe zzdfeVar) {
        this.zza = zzekgVar;
        this.zzb = zzfgnVar;
        this.zzc = zzfgcVar;
        this.zzd = zzdfeVar;
        this.zze = zzeyxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        zzfgn zzfgnVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfN)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Interstitial ad failed to load", th);
        }
        zzdfe zzdfeVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZza = zzdfeVar.zza().zza(th);
        zzeyx zzeyxVar = this.zze;
        synchronized (zzeyxVar) {
            zzeyxVar.zzi = null;
            zzdfeVar.zzb().zzdz(zzeVarZza);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzim)).booleanValue()) {
                zzeyxVar.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeys
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzdz(zzeVarZza);
                    }
                });
                zzeyxVar.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyt
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zze.zzdz(zzeVarZza);
                    }
                });
            }
            zzfcm.zzb(zzeVarZza.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbeb.zzc.zze()).booleanValue() || (zzfgnVar = this.zzb) == null) {
                zzfgq zzfgqVar = zzeyxVar.zzg;
                zzfgc zzfgcVar = this.zzc;
                zzfgcVar.zza(zzeVarZza);
                zzfgcVar.zzh(th);
                zzfgcVar.zzg(false);
                zzfgqVar.zzc(zzfgcVar.zzm());
            } else {
                zzfgnVar.zzc(zzeVarZza);
                zzfgc zzfgcVar2 = this.zzc;
                zzfgcVar2.zzh(th);
                zzfgcVar2.zzg(false);
                zzfgnVar.zza(zzfgcVar2);
                zzfgnVar.zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfgn zzfgnVar;
        zzdea zzdeaVar = (zzdea) obj;
        zzeyx zzeyxVar = this.zze;
        synchronized (zzeyxVar) {
            zzeyxVar.zzi = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzim)).booleanValue()) {
                zzczj zzczjVarZzn = zzdeaVar.zzn();
                zzczjVarZzn.zza(zzeyxVar.zzd);
                zzczjVarZzn.zzd(zzeyxVar.zze);
            }
            this.zza.zzb(zzdeaVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzim)).booleanValue()) {
                zzeyxVar.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyu
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzt();
                    }
                });
                zzeyxVar.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyv
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zze.zzt();
                    }
                });
            }
            if (!((Boolean) zzbeb.zzc.zze()).booleanValue() || (zzfgnVar = this.zzb) == null) {
                zzfgq zzfgqVar = zzeyxVar.zzg;
                zzfgc zzfgcVar = this.zzc;
                zzfgcVar.zzb(zzdeaVar.zzp().zzb);
                zzfgcVar.zzd(zzdeaVar.zzl().zzg());
                zzfgcVar.zzg(true);
                zzfgqVar.zzc(zzfgcVar.zzm());
            } else {
                zzfgnVar.zzg(zzdeaVar.zzp().zzb);
                zzfgnVar.zze(zzdeaVar.zzl().zzg());
                zzfgc zzfgcVar2 = this.zzc;
                zzfgcVar2.zzg(true);
                zzfgnVar.zza(zzfgcVar2);
                zzfgnVar.zzh();
            }
        }
    }
}
