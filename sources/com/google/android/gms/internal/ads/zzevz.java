package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzevz implements zzgbo {
    final /* synthetic */ zzekg zza;
    final /* synthetic */ zzfgn zzb;
    final /* synthetic */ zzfgc zzc;
    final /* synthetic */ zzewa zzd;
    final /* synthetic */ zzewc zze;

    zzevz(zzewc zzewcVar, zzekg zzekgVar, zzfgn zzfgnVar, zzfgc zzfgcVar, zzewa zzewaVar) {
        this.zza = zzekgVar;
        this.zzb = zzfgnVar;
        this.zzc = zzfgcVar;
        this.zzd = zzewaVar;
        this.zze = zzewcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        zzfgn zzfgnVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfN)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("App open ad failed to load", th);
        }
        zzewc zzewcVar = this.zze;
        zzcnj zzcnjVar = (zzcnj) zzewcVar.zze.zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzcnjVar == null ? zzfcq.zzb(th, null) : zzcnjVar.zzb().zza(th);
        synchronized (zzewcVar) {
            zzewcVar.zzj = null;
            if (zzcnjVar != null) {
                zzcnjVar.zzc().zzdz(zzeVarZzb);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzil)).booleanValue()) {
                    zzewcVar.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzevy
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze.zzd.zzdz(zzeVarZzb);
                        }
                    });
                }
            } else {
                zzewcVar.zzd.zzdz(zzeVarZzb);
                ((zzcnj) zzewcVar.zzm(this.zzd).zzh()).zzb().zzc().zzh();
            }
            zzfcm.zzb(zzeVarZzb.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbeb.zzc.zze()).booleanValue() || (zzfgnVar = this.zzb) == null) {
                zzfgq zzfgqVar = zzewcVar.zzh;
                zzfgc zzfgcVar = this.zzc;
                zzfgcVar.zza(zzeVarZzb);
                zzfgcVar.zzh(th);
                zzfgcVar.zzg(false);
                zzfgqVar.zzc(zzfgcVar.zzm());
            } else {
                zzfgnVar.zzc(zzeVarZzb);
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
        zzcqg zzcqgVar = (zzcqg) obj;
        zzewc zzewcVar = this.zze;
        synchronized (zzewcVar) {
            zzewcVar.zzj = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzil)).booleanValue()) {
                zzcqgVar.zzn().zzb(zzewcVar.zzd);
            }
            this.zza.zzb(zzcqgVar);
            if (!((Boolean) zzbeb.zzc.zze()).booleanValue() || (zzfgnVar = this.zzb) == null) {
                zzfgq zzfgqVar = zzewcVar.zzh;
                zzfgc zzfgcVar = this.zzc;
                zzfgcVar.zzb(zzcqgVar.zzp().zzb);
                zzfgcVar.zzd(zzcqgVar.zzl().zzg());
                zzfgcVar.zzg(true);
                zzfgqVar.zzc(zzfgcVar.zzm());
            } else {
                zzfgnVar.zzg(zzcqgVar.zzp().zzb);
                zzfgnVar.zze(zzcqgVar.zzl().zzg());
                zzfgc zzfgcVar2 = this.zzc;
                zzfgcVar2.zzg(true);
                zzfgnVar.zza(zzfgcVar2);
                zzfgnVar.zzh();
            }
        }
    }
}
