package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbuk extends zzaxx implements zzbum {
    zzbuk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zze(zzbuy zzbuyVar, zzbuq zzbuqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, zzbuyVar);
        zzaxz.zzf(parcelZza, zzbuqVar);
        zzda(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zzf(zzbuy zzbuyVar, zzbuq zzbuqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, zzbuyVar);
        zzaxz.zzf(parcelZza, zzbuqVar);
        zzda(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zzg(zzbuy zzbuyVar, zzbuq zzbuqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, zzbuyVar);
        zzaxz.zzf(parcelZza, zzbuqVar);
        zzda(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zzh(String str, zzbuq zzbuqVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzaxz.zzf(parcelZza, zzbuqVar);
        zzda(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zzi(zzbui zzbuiVar, zzbur zzburVar) throws RemoteException {
        throw null;
    }
}
