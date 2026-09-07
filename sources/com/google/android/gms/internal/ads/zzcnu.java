package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcnu extends zzazz {
    private final zzcnt zza;
    private final com.google.android.gms.ads.internal.client.zzbx zzb;
    private final zzews zzc;
    private boolean zzd = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaV)).booleanValue();
    private final zzdre zze;

    public zzcnu(zzcnt zzcntVar, com.google.android.gms.ads.internal.client.zzbx zzbxVar, zzews zzewsVar, zzdre zzdreVar) {
        this.zza = zzcntVar;
        this.zzb = zzbxVar;
        this.zzc = zzewsVar;
        this.zze = zzdreVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbaa
    public final com.google.android.gms.ads.internal.client.zzbx zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbaa
    public final com.google.android.gms.ads.internal.client.zzdx zzf() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgJ)).booleanValue()) {
            return this.zza.zzl();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbaa
    public final void zzg(boolean z) {
        this.zzd = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbaa
    public final void zzh(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        if (this.zzc != null) {
            try {
                if (!zzdqVar.zzf()) {
                    this.zze.zze();
                }
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Error in making CSI ping for reporting paid event callback", e);
            }
            this.zzc.zzn(zzdqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbaa
    public final void zzi(IObjectWrapper iObjectWrapper, zzbah zzbahVar) {
        try {
            this.zzc.zzp(zzbahVar);
            this.zza.zzd((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzbahVar, this.zzd);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
