package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbwc extends zzaxy implements zzbwd {
    public zzbwc() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzbwd zzq(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        return iInterfaceQueryLocalInterface instanceof zzbwd ? (zzbwd) iInterfaceQueryLocalInterface : new zzbwb(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    protected final boolean zzdD(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbwk zzbwiVar = null;
        zzbwk zzbwiVar2 = null;
        zzbwl zzbwlVar = null;
        zzbwg zzbweVar = null;
        switch (i) {
            case 1:
                com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzbwiVar = iInterfaceQueryLocalInterface instanceof zzbwk ? (zzbwk) iInterfaceQueryLocalInterface : new zzbwi(strongBinder);
                }
                zzaxz.zzc(parcel);
                zzf(zzmVar, zzbwiVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    zzbweVar = iInterfaceQueryLocalInterface2 instanceof zzbwg ? (zzbwg) iInterfaceQueryLocalInterface2 : new zzbwe(strongBinder2);
                }
                zzaxz.zzc(parcel);
                zzk(zzbweVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzo = zzo();
                parcel2.writeNoException();
                int i3 = zzaxz.zza;
                parcel2.writeInt(zZzo ? 1 : 0);
                return true;
            case 4:
                String strZze = zze();
                parcel2.writeNoException();
                parcel2.writeString(strZze);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzm(iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    zzbwlVar = iInterfaceQueryLocalInterface3 instanceof zzbwl ? (zzbwl) iInterfaceQueryLocalInterface3 : new zzbwl(strongBinder3);
                }
                zzaxz.zzc(parcel);
                zzp(zzbwlVar);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbwr zzbwrVar = (zzbwr) zzaxz.zza(parcel, zzbwr.CREATOR);
                zzaxz.zzc(parcel);
                zzl(zzbwrVar);
                parcel2.writeNoException();
                return true;
            case 8:
                com.google.android.gms.ads.internal.client.zzdn zzdnVarZzb = com.google.android.gms.ads.internal.client.zzdm.zzb(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzi(zzdnVarZzb);
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle bundleZzb = zzb();
                parcel2.writeNoException();
                zzaxz.zze(parcel2, bundleZzb);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zZzg = zzaxz.zzg(parcel);
                zzaxz.zzc(parcel);
                zzn(iObjectWrapperAsInterface2, zZzg);
                parcel2.writeNoException();
                return true;
            case 11:
                zzbwa zzbwaVarZzd = zzd();
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbwaVarZzd);
                return true;
            case 12:
                com.google.android.gms.ads.internal.client.zzdx zzdxVarZzc = zzc();
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzdxVarZzc);
                return true;
            case 13:
                com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzj(zzdqVarZzb);
                parcel2.writeNoException();
                return true;
            case 14:
                com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzbwiVar2 = iInterfaceQueryLocalInterface4 instanceof zzbwk ? (zzbwk) iInterfaceQueryLocalInterface4 : new zzbwi(strongBinder4);
                }
                zzaxz.zzc(parcel);
                zzg(zzmVar2, zzbwiVar2);
                parcel2.writeNoException();
                return true;
            case 15:
                boolean zZzg2 = zzaxz.zzg(parcel);
                zzaxz.zzc(parcel);
                zzh(zZzg2);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
