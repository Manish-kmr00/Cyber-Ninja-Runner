package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbob implements zzbzt {
    final /* synthetic */ zzbng zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzbzp zzc;
    final /* synthetic */ zzboe zzd;

    zzbob(zzboe zzboeVar, zzbng zzbngVar, Object obj, zzbzp zzbzpVar) {
        this.zza = zzbngVar;
        this.zzb = obj;
        this.zzc = zzbzpVar;
        this.zzd = zzboeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzt
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.zzb;
        zzbzp zzbzpVar = this.zzc;
        zzboe.zzd(this.zzd, this.zza, (zzbnn) obj, obj2, zzbzpVar);
    }
}
