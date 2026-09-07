package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbsi extends zzbgw {
    final /* synthetic */ zzbsl zza;

    /* synthetic */ zzbsi(zzbsl zzbslVar, zzbsk zzbskVar) {
        this.zza = zzbslVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgx
    public final void zze(zzbgn zzbgnVar, String str) {
        zzbsl zzbslVar = this.zza;
        if (zzbslVar.zzb == null) {
            return;
        }
        zzbslVar.zzb.onCustomClick(zzbslVar.zzf(zzbgnVar), str);
    }
}
