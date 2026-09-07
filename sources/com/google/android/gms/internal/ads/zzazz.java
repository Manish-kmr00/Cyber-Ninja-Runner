package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public abstract class zzazz extends zzaxy implements zzbaa {
    public zzazz() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public static zzbaa zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
        return iInterfaceQueryLocalInterface instanceof zzbaa ? (zzbaa) iInterfaceQueryLocalInterface : new zzazy(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    protected final boolean zzdD(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbah zzbafVar;
        switch (i) {
            case 2:
                com.google.android.gms.ads.internal.client.zzbx zzbxVarZze = zze();
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbxVarZze);
                return true;
            case 3:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
                    if (iInterfaceQueryLocalInterface instanceof zzbae) {
                    }
                }
                zzaxz.zzc(parcel);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 == null) {
                    zzbafVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
                    zzbafVar = iInterfaceQueryLocalInterface2 instanceof zzbah ? (zzbah) iInterfaceQueryLocalInterface2 : new zzbaf(strongBinder2);
                }
                zzaxz.zzc(parcel);
                zzi(iObjectWrapperAsInterface, zzbafVar);
                parcel2.writeNoException();
                return true;
            case 5:
                com.google.android.gms.ads.internal.client.zzdx zzdxVarZzf = zzf();
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzdxVarZzf);
                return true;
            case 6:
                boolean zZzg = zzaxz.zzg(parcel);
                zzaxz.zzc(parcel);
                zzg(zZzg);
                parcel2.writeNoException();
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzh(zzdqVarZzb);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
