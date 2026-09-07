package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzbzv implements zzgbo {
    final /* synthetic */ zzbzt zza;
    final /* synthetic */ zzbzr zzb;

    zzbzv(zzbzw zzbzwVar, zzbzt zzbztVar, zzbzr zzbzrVar) {
        this.zza = zzbztVar;
        this.zzb = zzbzrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zzb(Object obj) {
        this.zza.zza(obj);
    }
}
