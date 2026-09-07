package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzcqu implements zzgbo {
    final /* synthetic */ zzgbo zza;
    final /* synthetic */ zzcqv zzb;

    zzcqu(zzcqv zzcqvVar, zzgbo zzgboVar) {
        this.zza = zzgboVar;
        this.zzb = zzcqvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        zzbzk.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqp
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd = false;
            }
        });
        this.zza.zza(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbzk.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqp
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd = false;
            }
        });
        this.zza.zzb((zzcqg) obj);
    }
}
