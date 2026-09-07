package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzbyg extends zzaxx implements zzbyi {
    zzbyg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, iObjectWrapper2);
        parcelZza.writeString(str);
        zzaxz.zzf(parcelZza, iObjectWrapper3);
        Parcel parcelZzcZ = zzcZ(11, parcelZza);
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzf(IObjectWrapper iObjectWrapper, zzbym zzbymVar, zzbyf zzbyfVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzbymVar);
        zzaxz.zzf(parcelZza, zzbyfVar);
        zzda(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzg(zzbtq zzbtqVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbtn zzbtnVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbtn zzbtnVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzda(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbtn zzbtnVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbtn zzbtnVar) throws RemoteException {
        throw null;
    }
}
