package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzcmi implements zzgbo {
    final /* synthetic */ String zza;
    final /* synthetic */ zzcmj zzb;

    zzcmi(zzcmj zzcmjVar, String str) {
        this.zza = str;
        this.zzb = zzcmjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        String str = this.zza;
        zzcmj zzcmjVar = this.zzb;
        zzcmjVar.zzh.zza(zzcmjVar.zzg.zze(zzcmjVar.zze, zzcmjVar.zzf, false, str, null, zzcmjVar.zzx()), null);
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcmj zzcmjVar = this.zzb;
        zzcmjVar.zzh.zza(zzcmjVar.zzg.zze(zzcmjVar.zze, zzcmjVar.zzf, false, this.zza, (String) obj, zzcmjVar.zzx()), zzcmjVar.zzn);
    }
}
