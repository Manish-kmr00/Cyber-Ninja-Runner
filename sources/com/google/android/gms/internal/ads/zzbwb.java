package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbwb extends zzaxx implements zzbwd {
    zzbwb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final Bundle zzb() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(9, zza());
        Bundle bundle = (Bundle) zzaxz.zza(parcelZzcZ, Bundle.CREATOR);
        parcelZzcZ.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final com.google.android.gms.ads.internal.client.zzdx zzc() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(12, zza());
        com.google.android.gms.ads.internal.client.zzdx zzdxVarZzb = com.google.android.gms.ads.internal.client.zzdw.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzdxVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final zzbwa zzd() throws RemoteException {
        zzbwa zzbvyVar;
        Parcel parcelZzcZ = zzcZ(11, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbvyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            zzbvyVar = iInterfaceQueryLocalInterface instanceof zzbwa ? (zzbwa) iInterfaceQueryLocalInterface : new zzbvy(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbvyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final String zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzf(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbwk zzbwkVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, zzmVar);
        zzaxz.zzf(parcelZza, zzbwkVar);
        zzda(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzg(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbwk zzbwkVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, zzmVar);
        zzaxz.zzf(parcelZza, zzbwkVar);
        zzda(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzh(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        int i = zzaxz.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzda(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzi(com.google.android.gms.ads.internal.client.zzdn zzdnVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, zzdnVar);
        zzda(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzj(com.google.android.gms.ads.internal.client.zzdq zzdqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, zzdqVar);
        zzda(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzk(zzbwg zzbwgVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, zzbwgVar);
        zzda(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzl(zzbwr zzbwrVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, zzbwrVar);
        zzda(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzf(parcelZza, iObjectWrapper);
        zzda(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final boolean zzo() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzp(zzbwl zzbwlVar) throws RemoteException {
        throw null;
    }
}
