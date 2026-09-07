package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbsj extends zzbgz {
    final /* synthetic */ zzbsl zza;

    /* synthetic */ zzbsj(zzbsl zzbslVar, zzbsk zzbskVar) {
        this.zza = zzbslVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zze(zzbgn zzbgnVar) {
        zzbsl zzbslVar = this.zza;
        zzbslVar.zza.onCustomFormatAdLoaded(zzbslVar.zzf(zzbgnVar));
    }
}
