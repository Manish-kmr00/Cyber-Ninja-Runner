package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzfob extends zzaxx implements IInterface {
    zzfob(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfnz zze(zzfnx zzfnxVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, zzfnxVar);
        Parcel parcelZzcZ = zzcZ(1, parcelZza);
        zzfnz zzfnzVar = (zzfnz) zzaxz.zza(parcelZzcZ, zzfnz.CREATOR);
        parcelZzcZ.recycle();
        return zzfnzVar;
    }

    public final zzfoi zzf(zzfog zzfogVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, zzfogVar);
        Parcel parcelZzcZ = zzcZ(3, parcelZza);
        zzfoi zzfoiVar = (zzfoi) zzaxz.zza(parcelZzcZ, zzfoi.CREATOR);
        parcelZzcZ.recycle();
        return zzfoiVar;
    }

    public final void zzg(zzfnu zzfnuVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, zzfnuVar);
        zzda(2, parcelZza);
    }
}
