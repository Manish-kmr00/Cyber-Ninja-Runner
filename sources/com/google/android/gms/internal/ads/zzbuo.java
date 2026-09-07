package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbuo extends zzaxx implements zzbuq {
    zzbuo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbuq
    public final void zze(com.google.android.gms.ads.internal.util.zzbb zzbbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, zzbbVar);
        zzda(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuq
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, parcelFileDescriptor);
        zzda(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuq
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbuy zzbuyVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, parcelFileDescriptor);
        zzaxz.zzd(parcelZza, zzbuyVar);
        zzda(3, parcelZza);
    }
}
