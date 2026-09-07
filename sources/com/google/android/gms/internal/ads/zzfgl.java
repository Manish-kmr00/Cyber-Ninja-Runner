package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfgl implements zzgbo {
    final /* synthetic */ zzfgn zza;
    final /* synthetic */ zzfgc zzb;

    zzfgl(zzfgn zzfgnVar, zzfgc zzfgcVar) {
        this.zza = zzfgnVar;
        this.zzb = zzfgcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        zzfgc zzfgcVar = this.zzb;
        zzfgcVar.zzh(th);
        zzfgcVar.zzg(false);
        this.zza.zza(zzfgcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zzb(Object obj) {
    }
}
