package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbqv extends zzaxx implements zzbqx {
    zzbqv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final com.google.android.gms.ads.internal.client.zzea zze() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(5, zza());
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzb = com.google.android.gms.ads.internal.client.zzdz.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzeaVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final zzbrm zzf() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(2, zza());
        zzbrm zzbrmVar = (zzbrm) zzaxz.zza(parcelZzcZ, zzbrm.CREATOR);
        parcelZzcZ.recycle();
        return zzbrmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final zzbrm zzg() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(3, zza());
        zzbrm zzbrmVar = (zzbrm) zzaxz.zza(parcelZzcZ, zzbrm.CREATOR);
        parcelZzcZ.recycle();
        return zzbrmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzr zzrVar, zzbra zzbraVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzaxz.zzd(parcelZza, bundle);
        zzaxz.zzd(parcelZza, bundle2);
        zzaxz.zzd(parcelZza, zzrVar);
        zzaxz.zzf(parcelZza, zzbraVar);
        zzda(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbqi zzbqiVar, zzbpe zzbpeVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxz.zzd(parcelZza, zzmVar);
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzbqiVar);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzda(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbql zzbqlVar, zzbpe zzbpeVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxz.zzd(parcelZza, zzmVar);
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzbqlVar);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzaxz.zzd(parcelZza, zzrVar);
        zzda(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzk(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbql zzbqlVar, zzbpe zzbpeVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxz.zzd(parcelZza, zzmVar);
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzbqlVar);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzaxz.zzd(parcelZza, zzrVar);
        zzda(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbqo zzbqoVar, zzbpe zzbpeVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxz.zzd(parcelZza, zzmVar);
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzbqoVar);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzda(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzm(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbqr zzbqrVar, zzbpe zzbpeVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxz.zzd(parcelZza, zzmVar);
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzbqrVar);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzda(18, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbqr zzbqrVar, zzbpe zzbpeVar, zzbfi zzbfiVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxz.zzd(parcelZza, zzmVar);
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzbqrVar);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzaxz.zzd(parcelZza, zzbfiVar);
        zzda(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzo(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbqu zzbquVar, zzbpe zzbpeVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxz.zzd(parcelZza, zzmVar);
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzbquVar);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzda(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbqu zzbquVar, zzbpe zzbpeVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxz.zzd(parcelZza, zzmVar);
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzaxz.zzf(parcelZza, zzbquVar);
        zzaxz.zzf(parcelZza, zzbpeVar);
        zzda(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzq(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzda(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzcZ = zzcZ(24, parcelZza);
        boolean zZzg = zzaxz.zzg(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzcZ = zzcZ(15, parcelZza);
        boolean zZzg = zzaxz.zzg(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzcZ = zzcZ(17, parcelZza);
        boolean zZzg = zzaxz.zzg(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZzg;
    }
}
