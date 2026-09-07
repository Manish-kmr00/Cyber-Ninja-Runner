package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeke {
    private final zzdib zza;
    private final zzejr zzb;
    private final zzcvf zzc;

    public zzeke(zzdib zzdibVar, zzdre zzdreVar) {
        this.zza = zzdibVar;
        final zzejr zzejrVar = new zzejr(zzdreVar);
        this.zzb = zzejrVar;
        final zzbmc zzbmcVarZzg = zzdibVar.zzg();
        this.zzc = new zzcvf() { // from class: com.google.android.gms.internal.ads.zzekd
            @Override // com.google.android.gms.internal.ads.zzcvf
            public final void zzdz(com.google.android.gms.ads.internal.client.zze zzeVar) {
                zzejrVar.zzdz(zzeVar);
                zzbmc zzbmcVar = zzbmcVarZzg;
                if (zzbmcVar != null) {
                    try {
                        zzbmcVar.zzf(zzeVar);
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
                if (zzbmcVar != null) {
                    try {
                        zzbmcVar.zze(zzeVar.zza);
                    } catch (RemoteException e2) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e2);
                    }
                }
            }
        };
    }

    public final zzcvf zza() {
        return this.zzc;
    }

    public final zzcwq zzb() {
        return this.zzb;
    }

    public final zzdfv zzc() {
        return new zzdfv(this.zza, this.zzb.zzg());
    }

    public final zzejr zzd() {
        return this.zzb;
    }

    public final void zze(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        this.zzb.zzj(zzbkVar);
    }
}
