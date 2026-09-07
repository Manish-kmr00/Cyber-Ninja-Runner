package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdsu extends zzbwf {
    final /* synthetic */ zzdsv zza;

    zzdsu(zzdsv zzdsvVar) {
        this.zza = zzdsvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zze() throws RemoteException {
        zzdsv zzdsvVar = this.zza;
        zzdsvVar.zzb.zzj(zzdsvVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzf() throws RemoteException {
        zzdsv zzdsvVar = this.zza;
        zzdsvVar.zzb.zzo(zzdsvVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzg() throws RemoteException {
        zzdsv zzdsvVar = this.zza;
        zzdsvVar.zzb.zzk(zzdsvVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzh(int i) throws RemoteException {
        zzdsv zzdsvVar = this.zza;
        zzdsvVar.zzb.zzn(zzdsvVar.zza, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzi(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdsv zzdsvVar = this.zza;
        zzdsvVar.zzb.zzn(zzdsvVar.zza, zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzj() throws RemoteException {
        zzdsv zzdsvVar = this.zza;
        zzdsvVar.zzb.zzr(zzdsvVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzk(zzbwa zzbwaVar) throws RemoteException {
        zzdsv zzdsvVar = this.zza;
        zzdsvVar.zzb.zzl(zzdsvVar.zza, zzbwaVar);
    }
}
