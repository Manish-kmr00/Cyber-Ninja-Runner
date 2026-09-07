package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfgk implements zzgbo {
    final /* synthetic */ zzfgn zza;
    final /* synthetic */ zzfgc zzb;
    final /* synthetic */ boolean zzc;

    zzfgk(zzfgn zzfgnVar, zzfgc zzfgcVar, boolean z) {
        this.zza = zzfgnVar;
        this.zzb = zzfgcVar;
        this.zzc = z;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        zzfgc zzfgcVar = this.zzb;
        if (zzfgcVar.zzk()) {
            zzfgn zzfgnVar = this.zza;
            zzfgcVar.zzh(th);
            zzfgcVar.zzg(false);
            zzfgnVar.zza(zzfgcVar);
            if (this.zzc) {
                zzfgnVar.zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zzb(Object obj) {
        zzfgc zzfgcVar = this.zzb;
        zzfgcVar.zzg(true);
        zzfgn zzfgnVar = this.zza;
        zzfgnVar.zza(zzfgcVar);
        if (this.zzc) {
            zzfgnVar.zzh();
        }
    }
}
