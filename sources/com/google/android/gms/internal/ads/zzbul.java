package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbul extends zzaxy implements zzbum {
    public zzbul() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    protected final boolean zzdD(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbuq zzbuoVar = null;
        zzbur zzburVar = null;
        zzbuq zzbuoVar2 = null;
        zzbuq zzbuoVar3 = null;
        zzbuq zzbuoVar4 = null;
        switch (i) {
            case 1:
                zzaxz.zzc(parcel);
                parcel2.writeNoException();
                zzaxz.zze(parcel2, null);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (iInterfaceQueryLocalInterface instanceof zzbun) {
                    }
                }
                zzaxz.zzc(parcel);
                parcel2.writeNoException();
                return true;
            case 3:
            default:
                return false;
            case 4:
                zzbuy zzbuyVar = (zzbuy) zzaxz.zza(parcel, zzbuy.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbuoVar = iInterfaceQueryLocalInterface2 instanceof zzbuq ? (zzbuq) iInterfaceQueryLocalInterface2 : new zzbuo(strongBinder2);
                }
                zzaxz.zzc(parcel);
                zzg(zzbuyVar, zzbuoVar);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbuy zzbuyVar2 = (zzbuy) zzaxz.zza(parcel, zzbuy.CREATOR);
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbuoVar4 = iInterfaceQueryLocalInterface3 instanceof zzbuq ? (zzbuq) iInterfaceQueryLocalInterface3 : new zzbuo(strongBinder3);
                }
                zzaxz.zzc(parcel);
                zzf(zzbuyVar2, zzbuoVar4);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbuy zzbuyVar3 = (zzbuy) zzaxz.zza(parcel, zzbuy.CREATOR);
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbuoVar3 = iInterfaceQueryLocalInterface4 instanceof zzbuq ? (zzbuq) iInterfaceQueryLocalInterface4 : new zzbuo(strongBinder4);
                }
                zzaxz.zzc(parcel);
                zze(zzbuyVar3, zzbuoVar3);
                parcel2.writeNoException();
                return true;
            case 7:
                String string = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbuoVar2 = iInterfaceQueryLocalInterface5 instanceof zzbuq ? (zzbuq) iInterfaceQueryLocalInterface5 : new zzbuo(strongBinder5);
                }
                zzaxz.zzc(parcel);
                zzh(string, zzbuoVar2);
                parcel2.writeNoException();
                return true;
            case 8:
                zzbui zzbuiVar = (zzbui) zzaxz.zza(parcel, zzbui.CREATOR);
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.request.ITrustlessTokenListener");
                    zzburVar = iInterfaceQueryLocalInterface6 instanceof zzbur ? (zzbur) iInterfaceQueryLocalInterface6 : new zzbur(strongBinder6);
                }
                zzaxz.zzc(parcel);
                zzi(zzbuiVar, zzburVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
