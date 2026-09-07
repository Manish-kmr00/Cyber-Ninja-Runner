package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzffi implements zzgbo {
    final /* synthetic */ zzfez zza;
    final /* synthetic */ zzffj zzb;

    zzffi(zzffj zzffjVar, zzfez zzfezVar) {
        this.zza = zzfezVar;
        this.zzb = zzffjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        this.zzb.zza.zzd.zzb(this.zza, th);
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zzb(Object obj) {
        this.zzb.zza.zzd.zzd(this.zza);
    }
}
