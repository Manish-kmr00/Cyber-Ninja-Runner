package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfdu implements zzgbo {
    final /* synthetic */ zzfdx zza;
    final /* synthetic */ zzfdy zzb;

    zzfdu(zzfdy zzfdyVar, zzfdx zzfdxVar) {
        this.zza = zzfdxVar;
        this.zzb = zzfdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        zzfdy zzfdyVar = this.zzb;
        synchronized (zzfdyVar) {
            zzfdyVar.zze = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfdy zzfdyVar = this.zzb;
        synchronized (zzfdyVar) {
            zzfdyVar.zze = null;
            zzfdyVar.zzd.addFirst(this.zza);
            if (zzfdyVar.zzf == 1) {
                zzfdyVar.zzh();
            }
        }
    }
}
