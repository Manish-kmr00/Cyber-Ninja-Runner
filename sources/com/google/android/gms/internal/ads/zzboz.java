package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzboz extends zzaxx implements zzbpb {
    zzboz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzA(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpe zzbpeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzmVar);
        parcelZza.writeString(str);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzda(28, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzB(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzC(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpe zzbpeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzmVar);
        parcelZza.writeString(str);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzda(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzda(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzE() throws RemoteException {
        zzda(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzF() throws RemoteException {
        zzda(9, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzG(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        int i = zzaxz.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzda(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzda(39, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzI() throws RemoteException {
        zzda(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzda(37, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzda(30, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzL() throws RemoteException {
        zzda(12, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final boolean zzM() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(22, zza());
        boolean zZzg = zzaxz.zzg(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final boolean zzN() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(13, zza());
        boolean zZzg = zzaxz.zzg(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbpj zzO() throws RemoteException {
        zzbpj zzbpjVar;
        Parcel parcelZzcZ = zzcZ(15, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbpjVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzbpjVar = iInterfaceQueryLocalInterface instanceof zzbpj ? (zzbpj) iInterfaceQueryLocalInterface : new zzbpj(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbpjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbpk zzP() throws RemoteException {
        zzbpk zzbpkVar;
        Parcel parcelZzcZ = zzcZ(16, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbpkVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzbpkVar = iInterfaceQueryLocalInterface instanceof zzbpk ? (zzbpk) iInterfaceQueryLocalInterface : new zzbpk(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbpkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final Bundle zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final Bundle zzf() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final Bundle zzg() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final com.google.android.gms.ads.internal.client.zzea zzh() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(26, zza());
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzb = com.google.android.gms.ads.internal.client.zzdz.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzeaVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbgn zzi() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbph zzj() throws RemoteException {
        zzbph zzbpfVar;
        Parcel parcelZzcZ = zzcZ(36, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbpfVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
            zzbpfVar = iInterfaceQueryLocalInterface instanceof zzbph ? (zzbph) iInterfaceQueryLocalInterface : new zzbpf(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbpfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbpn zzk() throws RemoteException {
        zzbpn zzbplVar;
        Parcel parcelZzcZ = zzcZ(27, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbplVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzbplVar = iInterfaceQueryLocalInterface instanceof zzbpn ? (zzbpn) iInterfaceQueryLocalInterface : new zzbpl(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbplVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbrm zzl() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(33, zza());
        zzbrm zzbrmVar = (zzbrm) zzaxz.zza(parcelZzcZ, zzbrm.CREATOR);
        parcelZzcZ.recycle();
        return zzbrmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbrm zzm() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(34, zza());
        zzbrm zzbrmVar = (zzbrm) zzaxz.zza(parcelZzcZ, zzbrm.CREATOR);
        parcelZzcZ.recycle();
        return zzbrmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final IObjectWrapper zzn() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(2, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzo() throws RemoteException {
        zzda(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzp(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvv zzbvvVar, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzmVar);
        parcelZza.writeString(null);
        zzaxz.zzf(parcelZza, zzbvvVar);
        parcelZza.writeString(str2);
        zzda(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzq(IObjectWrapper iObjectWrapper, zzbll zzbllVar, List list) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzbllVar);
        parcelZza.writeTypedList(list);
        zzda(31, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzr(IObjectWrapper iObjectWrapper, zzbvv zzbvvVar, List list) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzbvvVar);
        parcelZza.writeStringList(list);
        zzda(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzs(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, zzmVar);
        parcelZza.writeString(str);
        zzda(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzt(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpe zzbpeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzmVar);
        parcelZza.writeString(str);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzda(38, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzu(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpe zzbpeVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzv(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpe zzbpeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzrVar);
        zzaxz.zzd(parcelZza, zzmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzda(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzw(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpe zzbpeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzrVar);
        zzaxz.zzd(parcelZza, zzmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzda(35, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzx(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpe zzbpeVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzy(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpe zzbpeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzda(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzz(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpe zzbpeVar, zzbfi zzbfiVar, List list) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzd(parcelZza, zzmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzaxz.zzd(parcelZza, zzbfiVar);
        parcelZza.writeStringList(list);
        zzda(14, parcelZza);
    }
}
