package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbpd extends zzaxy implements zzbpe {
    public zzbpd() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzbpe zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return iInterfaceQueryLocalInterface instanceof zzbpe ? (zzbpe) iInterfaceQueryLocalInterface : new zzbpc(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    protected final boolean zzdD(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zze();
                break;
            case 2:
                zzf();
                break;
            case 3:
                int i3 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzg(i3);
                break;
            case 4:
                zzn();
                break;
            case 5:
                zzp();
                break;
            case 6:
                zzo();
                break;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (iInterfaceQueryLocalInterface instanceof zzbpi) {
                    }
                }
                zzaxz.zzc(parcel);
                break;
            case 8:
                zzm();
                break;
            case 9:
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzaxz.zzc(parcel);
                zzq(string, string2);
                break;
            case 10:
                zzbgm.zzb(parcel.readStrongBinder());
                parcel.readString();
                zzaxz.zzc(parcel);
                break;
            case 11:
                zzw();
                break;
            case 12:
                parcel.readString();
                zzaxz.zzc(parcel);
                break;
            case 13:
                zzz();
                break;
            case 14:
                zzbvw zzbvwVar = (zzbvw) zzaxz.zza(parcel, zzbvw.CREATOR);
                zzaxz.zzc(parcel);
                zzs(zzbvwVar);
                break;
            case 15:
                zzx();
                break;
            case 16:
                zzbwa zzbwaVarZzb = zzbvz.zzb(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzt(zzbwaVarZzb);
                break;
            case 17:
                int i4 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzj(i4);
                break;
            case 18:
                zzv();
                break;
            case 19:
                zzaxz.zzc(parcel);
                break;
            case 20:
                zzy();
                break;
            case 21:
                String string3 = parcel.readString();
                zzaxz.zzc(parcel);
                zzl(string3);
                break;
            case 22:
                int i5 = parcel.readInt();
                String string4 = parcel.readString();
                zzaxz.zzc(parcel);
                zzi(i5, string4);
                break;
            case 23:
                com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzaxz.zzc(parcel);
                zzh(zzeVar);
                break;
            case 24:
                com.google.android.gms.ads.internal.client.zze zzeVar2 = (com.google.android.gms.ads.internal.client.zze) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzaxz.zzc(parcel);
                zzk(zzeVar2);
                break;
            case 25:
                zzu();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
