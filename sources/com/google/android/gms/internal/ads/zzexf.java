package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzexf implements zzgbo {
    final /* synthetic */ zzfgn zza;
    final /* synthetic */ zzfgc zzb;
    final /* synthetic */ zzcpd zzc;
    final /* synthetic */ zzexg zzd;

    zzexf(zzexg zzexgVar, zzfgn zzfgnVar, zzfgc zzfgcVar, zzcpd zzcpdVar) {
        this.zza = zzfgnVar;
        this.zzb = zzfgcVar;
        this.zzc = zzcpdVar;
        this.zzd = zzexgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        zzfgn zzfgnVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfN)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Banner ad failed to load", th);
        }
        zzexg zzexgVar = this.zzd;
        synchronized (zzexgVar) {
            zzcpd zzcpdVar = this.zzc;
            com.google.android.gms.ads.internal.client.zze zzeVarZza = zzcpdVar.zzc().zza(th);
            zzexgVar.zzn = zzeVarZza;
            zzcpdVar.zze().zzdz(zzeVarZza);
            zzfcm.zzb(zzeVarZza.zza, th, "BannerAdLoader.onFailure");
            if (zzexgVar.zzm) {
                zzexgVar.zzt();
                zzexgVar.zzh.zzd(zzexgVar.zzj.zzc());
            }
            if (!((Boolean) zzbeb.zzc.zze()).booleanValue() || (zzfgnVar = this.zza) == null) {
                zzfgq zzfgqVar = zzexgVar.zzi;
                zzfgc zzfgcVar = this.zzb;
                zzfgcVar.zza(zzeVarZza);
                zzfgcVar.zzh(th);
                zzfgcVar.zzg(false);
                zzfgqVar.zzc(zzfgcVar.zzm());
            } else {
                zzfgnVar.zzc(zzeVarZza);
                zzfgc zzfgcVar2 = this.zzb;
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
        zzexg zzexgVar = this.zzd;
        zzcnz zzcnzVar = (zzcnz) obj;
        synchronized (zzexgVar) {
            if (zzexgVar.zzm) {
                zzexgVar.zzq();
            }
            if (!((Boolean) zzbeb.zzc.zze()).booleanValue() || (zzfgnVar = this.zza) == null) {
                zzfgq zzfgqVar = zzexgVar.zzi;
                zzfgc zzfgcVar = this.zzb;
                zzfgcVar.zzb(zzcnzVar.zzp().zzb);
                zzfgcVar.zzd(zzcnzVar.zzl().zzg());
                zzfgcVar.zzg(true);
                zzfgqVar.zzc(zzfgcVar.zzm());
            } else {
                zzfgnVar.zzg(zzcnzVar.zzp().zzb);
                zzfgnVar.zze(zzcnzVar.zzl().zzg());
                zzfgc zzfgcVar2 = this.zzb;
                zzfgcVar2.zzg(true);
                zzfgnVar.zza(zzfgcVar2);
                zzfgnVar.zzh();
            }
        }
    }
}
