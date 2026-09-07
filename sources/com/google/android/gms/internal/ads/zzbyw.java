package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzbyw extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzbza zza;

    zzbyw(zzbza zzbzaVar) {
        this.zza = zzbzaVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        zzbza zzbzaVar = this.zza;
        zzbcl zzbclVar = new zzbcl(zzbzaVar.zze, zzbzaVar.zzf.afmaVersion);
        synchronized (zzbzaVar.zza) {
            try {
                com.google.android.gms.ads.internal.zzv.zze();
                zzbco.zza(zzbzaVar.zzh, zzbclVar);
            } catch (IllegalArgumentException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Cannot config CSI reporter.", e);
            }
        }
    }
}
