package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbup extends zzaxy implements zzbuq {
    public zzbup() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    protected final boolean zzdD(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzaxz.zza(parcel, ParcelFileDescriptor.CREATOR);
            zzaxz.zzc(parcel);
            zzf(parcelFileDescriptor);
        } else if (i == 2) {
            com.google.android.gms.ads.internal.util.zzbb zzbbVar = (com.google.android.gms.ads.internal.util.zzbb) zzaxz.zza(parcel, com.google.android.gms.ads.internal.util.zzbb.CREATOR);
            zzaxz.zzc(parcel);
            zze(zzbbVar);
        } else {
            if (i != 3) {
                return false;
            }
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) zzaxz.zza(parcel, ParcelFileDescriptor.CREATOR);
            zzbuy zzbuyVar = (zzbuy) zzaxz.zza(parcel, zzbuy.CREATOR);
            zzaxz.zzc(parcel);
            zzg(parcelFileDescriptor2, zzbuyVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
