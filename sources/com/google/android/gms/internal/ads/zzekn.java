package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzekn implements zzgbo {
    final /* synthetic */ zzekg zza;
    final /* synthetic */ zzfgn zzb;
    final /* synthetic */ zzfgc zzc;
    final /* synthetic */ zzdga zzd;
    final /* synthetic */ zzeko zze;

    zzekn(zzeko zzekoVar, zzekg zzekgVar, zzfgn zzfgnVar, zzfgc zzfgcVar, zzdga zzdgaVar) {
        this.zza = zzekgVar;
        this.zzb = zzfgnVar;
        this.zzc = zzfgcVar;
        this.zzd = zzdgaVar;
        this.zze = zzekoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        zzfgn zzfgnVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfN)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Native ad failed to load", th);
        }
        zzdga zzdgaVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZza = zzdgaVar.zza().zza(th);
        zzdgaVar.zzb().zzdz(zzeVarZza);
        zzeko zzekoVar = this.zze;
        zzekoVar.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzekm
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze.zzd.zza().zzdz(zzeVarZza);
            }
        });
        zzfcm.zzb(zzeVarZza.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbeb.zzc.zze()).booleanValue() || (zzfgnVar = this.zzb) == null) {
            zzfgq zzfgqVar = zzekoVar.zze;
            zzfgc zzfgcVar = this.zzc;
            zzfgcVar.zza(zzeVarZza);
            zzfgcVar.zzh(th);
            zzfgcVar.zzg(false);
            zzfgqVar.zzc(zzfgcVar.zzm());
            return;
        }
        zzfgnVar.zzc(zzeVarZza);
        zzfgc zzfgcVar2 = this.zzc;
        zzfgcVar2.zzh(th);
        zzfgcVar2.zzg(false);
        zzfgnVar.zza(zzfgcVar2);
        zzfgnVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfgn zzfgnVar;
        zzeko zzekoVar = this.zze;
        zzcqg zzcqgVar = (zzcqg) obj;
        synchronized (zzekoVar) {
            zzcqgVar.zzn().zza(zzekoVar.zzd.zzd());
            this.zza.zzb(zzcqgVar);
            zzekoVar.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzekl
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zze.zzd.zzb().zzt();
                }
            });
            if (!((Boolean) zzbeb.zzc.zze()).booleanValue() || (zzfgnVar = this.zzb) == null) {
                zzfgq zzfgqVar = zzekoVar.zze;
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
