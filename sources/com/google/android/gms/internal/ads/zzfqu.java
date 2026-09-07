package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfqu extends zzaxx implements zzfqw {
    zzfqu(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    @Override // com.google.android.gms.internal.ads.zzfqw
    public final void zze(Bundle bundle, zzfqy zzfqyVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, bundle);
        zzaxz.zzf(parcelZza, zzfqyVar);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfqw
    public final void zzf(String str, Bundle bundle, zzfqy zzfqyVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzaxz.zzd(parcelZza, bundle);
        zzaxz.zzf(parcelZza, zzfqyVar);
        zzdb(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfqw
    public final void zzg(Bundle bundle, zzfqy zzfqyVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxz.zzd(parcelZza, bundle);
        zzaxz.zzf(parcelZza, zzfqyVar);
        zzdb(3, parcelZza);
    }
}
