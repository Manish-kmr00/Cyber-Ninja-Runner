package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdhj implements zzgbo {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdhl zzb;

    zzdhj(zzdhl zzdhlVar, String str, boolean z) {
        this.zzb = zzdhlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfu)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzp().zzv(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdhl zzdhlVar = this.zzb;
        zzdhlVar.zze.zzT((zzcel) obj);
        zzbzp zzbzpVarZzp = zzdhlVar.zze.zzp();
        zzeca zzecaVarZzf = zzdhlVar.zzf(this.zza, true);
        if (zzecaVarZzf != null && zzbzpVarZzp != null) {
            zzbzpVarZzp.zzc(zzecaVarZzf);
        } else if (zzbzpVarZzp != null) {
            zzbzpVarZzp.cancel(false);
        }
    }
}
