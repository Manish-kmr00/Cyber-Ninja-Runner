package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzefd implements zzgbo {
    final /* synthetic */ zzfau zza;
    final /* synthetic */ zzefe zzb;

    zzefd(zzefe zzefeVar, zzfau zzfauVar) {
        this.zza = zzfauVar;
        this.zzb = zzefeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        zzefe zzefeVar = this.zzb;
        synchronized (zzefeVar) {
            zzeff zzeffVar = zzefeVar.zzh;
            zzfau zzfauVar = this.zza;
            zzeffVar.zzb(th, zzfauVar);
            zzfau zzfauVarZza = zzefeVar.zzh.zza();
            if (zzfauVar.zzav) {
                while (zzfauVarZza != null) {
                    zzefeVar.zze(zzfauVarZza);
                    zzfauVarZza = zzefeVar.zzh.zza();
                }
            } else if (zzfauVarZza != null) {
                zzefeVar.zze(zzfauVarZza);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzefe zzefeVar = this.zzb;
        zzefv zzefvVar = (zzefv) obj;
        synchronized (zzefeVar) {
            zzefeVar.zzh.zzc(zzefvVar, this.zza);
            zzfau zzfauVarZza = zzefeVar.zzh.zza();
            if (zzfauVarZza != null) {
                zzefeVar.zze(zzfauVarZza);
            }
        }
    }
}
