package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzbzu implements zzgbo {
    final /* synthetic */ zzbzw zza;

    zzbzu(zzbzw zzbzwVar) {
        this.zza = zzbzwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        this.zza.zzb.set(-1);
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zzb(Object obj) {
        this.zza.zzb.set(1);
    }
}
