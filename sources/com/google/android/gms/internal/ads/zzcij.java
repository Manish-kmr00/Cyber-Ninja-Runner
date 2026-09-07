package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcij implements zzdsh {
    private final Long zza;
    private final String zzb;
    private final zzchv zzc;
    private final zzcil zzd;

    zzcij(zzchv zzchvVar, zzcil zzcilVar, Long l, String str) {
        this.zzc = zzchvVar;
        this.zzd = zzcilVar;
        this.zza = l;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdsh
    public final zzdsr zza() {
        zzcil zzcilVar = this.zzd;
        return zzdss.zza(this.zza.longValue(), zzcilVar.zze, zzcilVar.zzc(), this.zzc, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdsh
    public final zzdsv zzb() {
        zzcil zzcilVar = this.zzd;
        return zzdsw.zza(this.zza.longValue(), zzcilVar.zze, zzcilVar.zzc(), this.zzc, this.zzb);
    }
}
