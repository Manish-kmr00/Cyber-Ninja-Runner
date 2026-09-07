package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaxx;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbfw;
import com.google.android.gms.internal.ads.zzbfx;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbgd;
import com.google.android.gms.internal.ads.zzbki;
import com.google.android.gms.internal.ads.zzbkk;
import com.google.android.gms.internal.ads.zzbkl;
import com.google.android.gms.internal.ads.zzboy;
import com.google.android.gms.internal.ads.zzbsq;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzbsx;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbvn;
import com.google.android.gms.internal.ads.zzbwc;
import com.google.android.gms.internal.ads.zzbwd;
import com.google.android.gms.internal.ads.zzbyh;
import com.google.android.gms.internal.ads.zzbyi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcm extends zzaxx implements zzco {
    zzcm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbt zzb(IObjectWrapper iObjectWrapper, String str, zzboy zzboyVar, int i) throws RemoteException {
        zzbt zzbrVar;
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzaxz.zzf(parcelZza, zzboyVar);
        parcelZza.writeInt(251410000);
        Parcel parcelZzcZ = zzcZ(3, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbrVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzbrVar = iInterfaceQueryLocalInterface instanceof zzbt ? (zzbt) iInterfaceQueryLocalInterface : new zzbr(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbrVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbx zzc(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzboy zzboyVar, int i) throws RemoteException {
        zzbx zzbvVar;
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzrVar);
        parcelZza.writeString(str);
        zzaxz.zzf(parcelZza, zzboyVar);
        parcelZza.writeInt(251410000);
        Parcel parcelZzcZ = zzcZ(13, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbx zzd(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzboy zzboyVar, int i) throws RemoteException {
        zzbx zzbvVar;
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzrVar);
        parcelZza.writeString(str);
        zzaxz.zzf(parcelZza, zzboyVar);
        parcelZza.writeInt(251410000);
        Parcel parcelZzcZ = zzcZ(1, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbx zze(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzboy zzboyVar, int i) throws RemoteException {
        zzbx zzbvVar;
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzrVar);
        parcelZza.writeString(str);
        zzaxz.zzf(parcelZza, zzboyVar);
        parcelZza.writeInt(251410000);
        Parcel parcelZzcZ = zzcZ(2, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbx zzf(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, int i) throws RemoteException {
        zzbx zzbvVar;
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzrVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(251410000);
        Parcel parcelZzcZ = zzcZ(10, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzch zzg(IObjectWrapper iObjectWrapper, zzboy zzboyVar, int i) throws RemoteException {
        zzch zzcfVar;
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzboyVar);
        parcelZza.writeInt(251410000);
        Parcel parcelZzcZ = zzcZ(18, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzcfVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader");
            zzcfVar = iInterfaceQueryLocalInterface instanceof zzch ? (zzch) iInterfaceQueryLocalInterface : new zzcf(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzcfVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcy zzh(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzcy zzcwVar;
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeInt(251410000);
        Parcel parcelZzcZ = zzcZ(9, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzcwVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzcwVar = iInterfaceQueryLocalInterface instanceof zzcy ? (zzcy) iInterfaceQueryLocalInterface : new zzcw(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzcwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzdt zzi(IObjectWrapper iObjectWrapper, zzboy zzboyVar, int i) throws RemoteException {
        zzdt zzdrVar;
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzboyVar);
        parcelZza.writeInt(251410000);
        Parcel parcelZzcZ = zzcZ(17, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzdrVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTester");
            zzdrVar = iInterfaceQueryLocalInterface instanceof zzdt ? (zzdt) iInterfaceQueryLocalInterface : new zzdr(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzdrVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbfx zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, iObjectWrapper2);
        Parcel parcelZzcZ = zzcZ(5, parcelZza);
        zzbfx zzbfxVarZzdy = zzbfw.zzdy(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzbfxVarZzdy;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbgd zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, iObjectWrapper2);
        zzaxz.zzf(parcelZza, iObjectWrapper3);
        Parcel parcelZzcZ = zzcZ(11, parcelZza);
        zzbgd zzbgdVarZze = zzbgc.zze(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzbgdVarZze;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbkl zzl(IObjectWrapper iObjectWrapper, zzboy zzboyVar, int i, zzbki zzbkiVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzboyVar);
        parcelZza.writeInt(251410000);
        zzaxz.zzf(parcelZza, zzbkiVar);
        Parcel parcelZzcZ = zzcZ(16, parcelZza);
        zzbkl zzbklVarZzb = zzbkk.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzbklVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbsr zzm(IObjectWrapper iObjectWrapper, zzboy zzboyVar, int i) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzboyVar);
        parcelZza.writeInt(251410000);
        Parcel parcelZzcZ = zzcZ(15, parcelZza);
        zzbsr zzbsrVarZzb = zzbsq.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzbsrVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbsy zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzcZ = zzcZ(8, parcelZza);
        zzbsy zzbsyVarZzI = zzbsx.zzI(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzbsyVarZzI;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbvn zzo(IObjectWrapper iObjectWrapper, zzboy zzboyVar, int i) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbwd zzp(IObjectWrapper iObjectWrapper, String str, zzboy zzboyVar, int i) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzaxz.zzf(parcelZza, zzboyVar);
        parcelZza.writeInt(251410000);
        Parcel parcelZzcZ = zzcZ(12, parcelZza);
        zzbwd zzbwdVarZzq = zzbwc.zzq(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzbwdVarZzq;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbyi zzq(IObjectWrapper iObjectWrapper, zzboy zzboyVar, int i) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzboyVar);
        parcelZza.writeInt(251410000);
        Parcel parcelZzcZ = zzcZ(14, parcelZza);
        zzbyi zzbyiVarZzb = zzbyh.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzbyiVarZzb;
    }
}
