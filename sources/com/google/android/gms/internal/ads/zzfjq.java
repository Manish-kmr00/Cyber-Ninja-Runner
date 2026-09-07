package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfjq extends zzbwj {
    final /* synthetic */ zzgcm zza;
    final /* synthetic */ zzbwd zzb;
    final /* synthetic */ zzfjr zzc;

    zzfjq(zzfjr zzfjrVar, zzgcm zzgcmVar, zzbwd zzbwdVar) {
        this.zza = zzgcmVar;
        this.zzb = zzbwdVar;
        this.zzc = zzfjrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zze(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        String string = zzeVar.zzb().toString();
        zzfjr zzfjrVar = this.zzc;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to load rewarded ad with error: " + string + ", adUnitId: " + zzfjrVar.zze.zza);
        zzfjrVar.zzE(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zzg() {
        zzfir.zza(this.zzb, this.zza);
    }
}
