package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public interface zzbyi extends IInterface {
    IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper, zzbym zzbymVar, zzbyf zzbyfVar) throws RemoteException;

    void zzg(zzbtq zzbtqVar) throws RemoteException;

    void zzh(List list, IObjectWrapper iObjectWrapper, zzbtn zzbtnVar) throws RemoteException;

    void zzi(List list, IObjectWrapper iObjectWrapper, zzbtn zzbtnVar) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzl(List list, IObjectWrapper iObjectWrapper, zzbtn zzbtnVar) throws RemoteException;

    void zzm(List list, IObjectWrapper iObjectWrapper, zzbtn zzbtnVar) throws RemoteException;
}
