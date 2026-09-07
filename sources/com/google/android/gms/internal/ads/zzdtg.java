package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdtg implements zzgbo {
    final /* synthetic */ zzdti zza;

    zzdtg(zzdti zzdtiVar) {
        this.zza = zzdtiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        synchronized (this) {
            zzdti zzdtiVar = this.zza;
            zzdtiVar.zzc = true;
            zzdtiVar.zzv("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - zzdtiVar.zzd));
            zzdtiVar.zze.zzd(new Exception());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        final String str = (String) obj;
        synchronized (this) {
            zzdti zzdtiVar = this.zza;
            zzdtiVar.zzc = true;
            zzdtiVar.zzv("com.google.android.gms.ads.MobileAds", true, "", (int) (com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - zzdtiVar.zzd));
            zzdtiVar.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdtf
                @Override // java.lang.Runnable
                public final void run() {
                    zzdti.zzo(this.zza.zza, str);
                }
            });
        }
    }
}
