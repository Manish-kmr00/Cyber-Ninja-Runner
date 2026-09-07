package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbhr extends zzbgw {
    final /* synthetic */ zzbhu zza;

    /* synthetic */ zzbhr(zzbhu zzbhuVar, zzbht zzbhtVar) {
        this.zza = zzbhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgx
    public final void zze(zzbgn zzbgnVar, String str) {
        zzbhu zzbhuVar = this.zza;
        if (zzbhuVar.zzb == null) {
            return;
        }
        zzbhuVar.zzb.zzb(zzbhuVar.zzf(zzbgnVar), str);
    }
}
