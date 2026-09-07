package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbwa;
import com.google.android.gms.internal.ads.zzbwc;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzbwk;
import com.google.android.gms.internal.ads.zzbwl;
import com.google.android.gms.internal.ads.zzbwr;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfm extends zzbwc {
    private static void zzr(final zzbwk zzbwkVar) {
        com.google.android.gms.ads.internal.util.client.zzo.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzfl
            @Override // java.lang.Runnable
            public final void run() {
                zzbwk zzbwkVar2 = zzbwkVar;
                if (zzbwkVar2 != null) {
                    try {
                        zzbwkVar2.zze(1);
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final Bundle zzb() throws RemoteException {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final zzdx zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final zzbwa zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final String zze() throws RemoteException {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzf(zzm zzmVar, zzbwk zzbwkVar) throws RemoteException {
        zzr(zzbwkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzg(zzm zzmVar, zzbwk zzbwkVar) throws RemoteException {
        zzr(zzbwkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzh(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzi(zzdn zzdnVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzj(zzdq zzdqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzk(zzbwg zzbwgVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzl(zzbwr zzbwrVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final boolean zzo() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzp(zzbwl zzbwlVar) throws RemoteException {
    }
}
