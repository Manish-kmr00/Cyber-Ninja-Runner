package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfbz implements zzgbo {
    final /* synthetic */ zzcel zza;
    final /* synthetic */ zzclx zzb;
    final /* synthetic */ zzfio zzc;
    final /* synthetic */ zzeat zzd;

    zzfbz(zzcel zzcelVar, zzclx zzclxVar, zzfio zzfioVar, zzeat zzeatVar) {
        this.zza = zzcelVar;
        this.zzb = zzclxVar;
        this.zzc = zzfioVar;
        this.zzd = zzeatVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzclx zzclxVar;
        String str = (String) obj;
        zzcel zzcelVar = this.zza;
        zzfau zzfauVarZzD = zzcelVar.zzD();
        if (zzfauVarZzD != null && !zzfauVarZzD.zzai) {
            com.google.android.gms.ads.internal.util.client.zzv zzvVar = zzfauVarZzD.zzax;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkf)).booleanValue() && (zzclxVar = this.zzb) != null && zzclx.zzj(str)) {
                zzclxVar.zzi(str, this.zzc, com.google.android.gms.ads.internal.client.zzbb.zze(), zzvVar);
                return;
            } else {
                this.zzc.zzd(str, zzvVar, null, null);
                return;
            }
        }
        zzfax zzfaxVarZzR = zzcelVar.zzR();
        if (zzfaxVarZzR == null) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(new IllegalArgumentException("Common configuration cannot be null"), "BufferingGmsgHandlers.getBufferingClickGmsgHandler");
            return;
        }
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis();
        boolean zZzA = com.google.android.gms.ads.internal.zzv.zzp().zzA(zzcelVar.getContext());
        boolean z = false;
        boolean z2 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgk)).booleanValue() && zzfauVarZzD != null && zzfauVarZzD.zzS;
        if (zzfauVarZzD != null && zzfauVarZzD.zzad != null) {
            z = true;
        }
        this.zzd.zzd(new zzeav(jCurrentTimeMillis, zzfaxVarZzR.zzb, str, (zZzA || z2 || z) ? 2 : 1));
    }
}
