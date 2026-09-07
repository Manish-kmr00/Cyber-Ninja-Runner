package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfae implements zzgbo {
    final /* synthetic */ zzekg zza;
    final /* synthetic */ zzfgn zzb;
    final /* synthetic */ zzfgc zzc;
    final /* synthetic */ zzfaf zzd;
    final /* synthetic */ zzfah zze;

    zzfae(zzfah zzfahVar, zzekg zzekgVar, zzfgn zzfgnVar, zzfgc zzfgcVar, zzfaf zzfafVar) {
        this.zza = zzekgVar;
        this.zzb = zzfgnVar;
        this.zzc = zzfgcVar;
        this.zzd = zzfafVar;
        this.zze = zzfahVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        zzfgn zzfgnVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfN)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Rewarded ad failed to load", th);
        }
        zzfah zzfahVar = this.zze;
        zzdnn zzdnnVar = (zzdnn) zzfahVar.zze.zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzdnnVar == null ? zzfcq.zzb(th, null) : zzdnnVar.zzb().zza(th);
        synchronized (zzfahVar) {
            try {
                if (zzdnnVar != null) {
                    zzdnnVar.zza().zzdz(zzeVarZzb);
                    zzfahVar.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfac
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze.zzd.zzdz(zzeVarZzb);
                        }
                    });
                } else {
                    zzfahVar.zzd.zzdz(zzeVarZzb);
                    zzfahVar.zzk(this.zzd).zzh().zzb().zzc().zzh();
                }
                zzfcm.zzb(zzeVarZzb.zza, th, "RewardedAdLoader.onFailure");
                this.zza.zza();
                if (!((Boolean) zzbeb.zzc.zze()).booleanValue() || (zzfgnVar = this.zzb) == null) {
                    zzfgq zzfgqVar = zzfahVar.zzg;
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
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfgn zzfgnVar;
        zzfah zzfahVar = this.zze;
        zzdni zzdniVar = (zzdni) obj;
        synchronized (zzfahVar) {
            zzdniVar.zzn().zzd(zzfahVar.zzd);
            this.zza.zzb(zzdniVar);
            Executor executor = zzfahVar.zzb;
            final zzezx zzezxVar = zzfahVar.zzd;
            Objects.requireNonNull(zzezxVar);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfad
                @Override // java.lang.Runnable
                public final void run() {
                    zzezxVar.zzt();
                }
            });
            zzfahVar.zzd.onAdMetadataChanged();
            if (!((Boolean) zzbeb.zzc.zze()).booleanValue() || (zzfgnVar = this.zzb) == null) {
                zzfgq zzfgqVar = zzfahVar.zzg;
                zzfgc zzfgcVar = this.zzc;
                zzfgcVar.zzb(zzdniVar.zzp().zzb);
                zzfgcVar.zzd(zzdniVar.zzl().zzg());
                zzfgcVar.zzg(true);
                zzfgqVar.zzc(zzfgcVar.zzm());
            } else {
                zzfgnVar.zzg(zzdniVar.zzp().zzb);
                zzfgnVar.zze(zzdniVar.zzl().zzg());
                zzfgc zzfgcVar2 = this.zzc;
                zzfgcVar2.zzg(true);
                zzfgnVar.zza(zzfgcVar2);
                zzfgnVar.zzh();
            }
        }
    }
}
