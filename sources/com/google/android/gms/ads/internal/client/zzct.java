package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaxx;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbox;
import com.google.android.gms.internal.ads.zzboy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzct extends zzaxx implements zzcv {
    zzct(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final zzboy getAdapterCreator() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(2, zza());
        zzboy zzboyVarZzf = zzbox.zzf(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzboyVarZzf;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final zzex getLiteSdkVersion() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(1, zza());
        zzex zzexVar = (zzex) zzaxz.zza(parcelZzcZ, zzex.CREATOR);
        parcelZzcZ.recycle();
        return zzexVar;
    }
}
