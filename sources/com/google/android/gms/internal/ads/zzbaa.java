package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public interface zzbaa extends IInterface {
    com.google.android.gms.ads.internal.client.zzbx zze() throws RemoteException;

    com.google.android.gms.ads.internal.client.zzdx zzf() throws RemoteException;

    void zzg(boolean z) throws RemoteException;

    void zzh(com.google.android.gms.ads.internal.client.zzdq zzdqVar) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper, zzbah zzbahVar) throws RemoteException;
}
