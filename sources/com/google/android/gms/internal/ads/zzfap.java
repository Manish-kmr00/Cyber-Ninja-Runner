package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfap implements zzekg {
    final /* synthetic */ zzfar zza;

    zzfap(zzfar zzfarVar) {
        this.zza = zzfarVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final void zza() {
        zzfar zzfarVar = this.zza;
        synchronized (zzfarVar) {
            zzfarVar.zzd = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfar zzfarVar = this.zza;
        zzdni zzdniVar = (zzdni) obj;
        synchronized (zzfarVar) {
            zzfarVar.zzd = zzdniVar;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdM)).booleanValue()) {
                zzdniVar.zzd().zza = zzfarVar.zzc;
            }
            zzfarVar.zzd.zzk();
        }
    }
}
