package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzffz implements zzdch, zzcvs, zzdcl {
    private final zzfgn zza;
    private final zzfgc zzb;

    zzffz(Context context, zzfgn zzfgnVar) {
        this.zza = zzfgnVar;
        this.zzb = zzfgb.zza(context, 13);
    }

    @Override // com.google.android.gms.internal.ads.zzdcl
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcl
    public final void zzb() {
        if (((Boolean) zzbeb.zzd.zze()).booleanValue()) {
            zzfgn zzfgnVar = this.zza;
            zzfgc zzfgcVar = this.zzb;
            zzfgcVar.zzg(true);
            zzfgnVar.zza(zzfgcVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final void zzr(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbeb.zzd.zze()).booleanValue()) {
            zzfgn zzfgnVar = this.zza;
            zzfgc zzfgcVar = this.zzb;
            zzfgcVar.zzc(zzeVar.zza().toString());
            zzfgcVar.zzg(false);
            zzfgnVar.zza(zzfgcVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdch
    public final void zzu() {
    }

    @Override // com.google.android.gms.internal.ads.zzdch
    public final void zzv() {
        if (((Boolean) zzbeb.zzd.zze()).booleanValue()) {
            this.zzb.zzi();
        }
    }
}
