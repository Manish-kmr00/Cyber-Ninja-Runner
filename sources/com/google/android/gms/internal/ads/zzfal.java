package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfal extends zzbwc {
    private final zzfah zza;
    private final zzezx zzb;
    private final String zzc;
    private final zzfbh zzd;
    private final Context zze;
    private final VersionInfoParcel zzf;
    private final zzauy zzg;
    private final zzdre zzh;
    private zzdni zzi;
    private boolean zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaS)).booleanValue();

    public zzfal(String str, zzfah zzfahVar, Context context, zzezx zzezxVar, zzfbh zzfbhVar, VersionInfoParcel versionInfoParcel, zzauy zzauyVar, zzdre zzdreVar) {
        this.zzc = str;
        this.zza = zzfahVar;
        this.zzb = zzezxVar;
        this.zzd = zzfbhVar;
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzg = zzauyVar;
        this.zzh = zzdreVar;
    }

    private final synchronized void zzu(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbwk zzbwkVar, int i) throws RemoteException {
        if (!zzmVar.zzb()) {
            boolean z = false;
            if (((Boolean) zzbeg.zzk.zze()).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlm)).booleanValue()) {
                    z = true;
                }
            }
            if (this.zzf.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzln)).intValue() || !z) {
                Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
            }
        }
        zzezx zzezxVar = this.zzb;
        zzezxVar.zzk(zzbwkVar);
        com.google.android.gms.ads.internal.zzv.zzq();
        if (com.google.android.gms.ads.internal.util.zzs.zzI(this.zze) && zzmVar.zzs == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to load the ad because app ID is missing.");
            zzezxVar.zzdz(zzfcq.zzd(4, null, null));
            return;
        }
        if (this.zzi != null) {
            return;
        }
        zzezz zzezzVar = new zzezz(null);
        zzfah zzfahVar = this.zza;
        zzfahVar.zzj(i);
        zzfahVar.zzb(zzmVar, this.zzc, zzezzVar, new zzfak(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final Bundle zzb() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdni zzdniVar = this.zzi;
        return zzdniVar != null ? zzdniVar.zza() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final com.google.android.gms.ads.internal.client.zzdx zzc() {
        zzdni zzdniVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgJ)).booleanValue() && (zzdniVar = this.zzi) != null) {
            return zzdniVar.zzl();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final zzbwa zzd() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdni zzdniVar = this.zzi;
        if (zzdniVar != null) {
            return zzdniVar.zzc();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final synchronized String zze() throws RemoteException {
        zzdni zzdniVar = this.zzi;
        if (zzdniVar == null || zzdniVar.zzl() == null) {
            return null;
        }
        return zzdniVar.zzl().zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final synchronized void zzf(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbwk zzbwkVar) throws RemoteException {
        zzu(zzmVar, zzbwkVar, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final synchronized void zzg(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbwk zzbwkVar) throws RemoteException {
        zzu(zzmVar, zzbwkVar, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final synchronized void zzh(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzj = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzi(com.google.android.gms.ads.internal.client.zzdn zzdnVar) {
        if (zzdnVar == null) {
            this.zzb.zzg(null);
        } else {
            this.zzb.zzg(new zzfaj(this, zzdnVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzj(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdqVar.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzb.zzi(zzdqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzk(zzbwg zzbwgVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzj(zzbwgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final synchronized void zzl(zzbwr zzbwrVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzfbh zzfbhVar = this.zzd;
        zzfbhVar.zza = zzbwrVar.zza;
        zzfbhVar.zzb = zzbwrVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final synchronized void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzn(iObjectWrapper, this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final synchronized void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzi == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Rewarded can not be shown before loaded");
            this.zzb.zzr(zzfcq.zzd(9, null, null));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzda)).booleanValue()) {
                this.zzg.zzc().zzn(new Throwable().getStackTrace());
            }
            this.zzi.zzh(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final boolean zzo() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdni zzdniVar = this.zzi;
        return (zzdniVar == null || zzdniVar.zzf()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final void zzp(zzbwl zzbwlVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzo(zzbwlVar);
    }
}
