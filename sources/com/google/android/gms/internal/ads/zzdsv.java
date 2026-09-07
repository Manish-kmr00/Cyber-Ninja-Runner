package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdsv implements zzdsf {
    private final long zza;
    private final zzdsk zzb;
    private final zzfal zzc;

    zzdsv(long j, Context context, zzdsk zzdskVar, zzcgl zzcglVar, String str) {
        this.zza = j;
        this.zzb = zzdskVar;
        zzfan zzfanVarZzv = zzcglVar.zzv();
        zzfanVarZzv.zzb(context);
        zzfanVarZzv.zza(str);
        this.zzc = zzfanVarZzv.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzdsf
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzdsf
    public final void zzb(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        try {
            this.zzc.zzf(zzmVar, new zzdst(this));
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdsf
    public final void zzc() {
        try {
            zzfal zzfalVar = this.zzc;
            zzfalVar.zzk(new zzdsu(this));
            zzfalVar.zzm(ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
