package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcpy {
    private final zzcxv zza;
    private final zzdab zzb;

    public zzcpy(zzcxv zzcxvVar, zzdab zzdabVar) {
        this.zza = zzcxvVar;
        this.zzb = zzdabVar;
    }

    public final zzcxv zza() {
        return this.zza;
    }

    final zzdab zzb() {
        return this.zzb;
    }

    final zzdcu zzc() {
        zzdab zzdabVar = this.zzb;
        return zzdabVar != null ? new zzdcu(zzdabVar, zzbzk.zzg) : new zzdcu(new zzcpx(this), zzbzk.zzg);
    }
}
