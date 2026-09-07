package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfak implements zzekg {
    final /* synthetic */ zzfal zza;

    zzfak(zzfal zzfalVar) {
        this.zza = zzfalVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final void zza() {
        zzfal zzfalVar = this.zza;
        synchronized (zzfalVar) {
            zzfalVar.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfal zzfalVar = this.zza;
        zzdni zzdniVar = (zzdni) obj;
        synchronized (zzfalVar) {
            zzfalVar.zzi = zzdniVar;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdM)).booleanValue()) {
                zzdniVar.zzd().zza = zzfalVar.zzd;
            }
            zzfalVar.zzi.zzk();
        }
    }
}
