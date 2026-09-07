package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdst extends zzbwj {
    final /* synthetic */ zzdsv zza;

    zzdst(zzdsv zzdsvVar) {
        this.zza = zzdsvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zze(int i) throws RemoteException {
        zzdsv zzdsvVar = this.zza;
        zzdsvVar.zzb.zzm(zzdsvVar.zza, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdsv zzdsvVar = this.zza;
        zzdsvVar.zzb.zzm(zzdsvVar.zza, zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zzg() throws RemoteException {
        zzdsv zzdsvVar = this.zza;
        zzdsvVar.zzb.zzp(zzdsvVar.zza);
    }
}
