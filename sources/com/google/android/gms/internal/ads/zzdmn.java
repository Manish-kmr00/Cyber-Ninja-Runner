package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdmn implements zzgbo {
    final /* synthetic */ zzfau zza;
    final /* synthetic */ zzfax zzb;
    final /* synthetic */ zzclx zzc;
    final /* synthetic */ zzdmt zzd;

    zzdmn(zzdmt zzdmtVar, zzfau zzfauVar, zzfax zzfaxVar, zzclx zzclxVar) {
        this.zza = zzfauVar;
        this.zzb = zzfaxVar;
        this.zzc = zzclxVar;
        this.zzd = zzdmtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcel zzcelVar = (zzcel) obj;
        zzfau zzfauVar = this.zza;
        zzcelVar.zzW(zzfauVar, this.zzb);
        zzcgd zzcgdVarZzN = zzcelVar.zzN();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkj)).booleanValue() && zzcgdVarZzN != null) {
            zzclx zzclxVar = this.zzc;
            zzdmt zzdmtVar = this.zzd;
            zzcgdVarZzN.zzK(zzclxVar, zzdmtVar.zzi, zzdmtVar.zzj);
            zzcgdVarZzN.zzM(zzclxVar, zzdmtVar.zzi, zzdmtVar.zzd);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzna)).booleanValue() || zzcgdVarZzN == null) {
            return;
        }
        zzcgdVarZzN.zzN(zzfauVar);
    }
}
