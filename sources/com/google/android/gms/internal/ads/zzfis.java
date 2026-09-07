package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfis extends zzbac {
    final /* synthetic */ zzgcm zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzfp zzb;
    final /* synthetic */ zzfit zzc;

    zzfis(zzfit zzfitVar, zzgcm zzgcmVar, com.google.android.gms.ads.internal.client.zzfp zzfpVar) {
        this.zza = zzgcmVar;
        this.zzb = zzfpVar;
        this.zzc = zzfitVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbad
    public final void zzb(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbad
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to load app open ad with error parcel: " + zzeVar.zzb().toString() + " for ad unit: " + this.zzb.zza);
        this.zzc.zzE(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbad
    public final void zzd(zzbaa zzbaaVar) {
        zzfir.zza(zzbaaVar, this.zza);
    }
}
