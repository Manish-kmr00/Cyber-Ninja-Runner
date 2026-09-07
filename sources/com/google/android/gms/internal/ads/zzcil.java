package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcil implements zzdsp {
    final zzhfh zza;
    final zzhfh zzb;
    final zzhfh zzc;
    final zzhfh zzd;
    private final Context zze;
    private final zzbki zzf;
    private final zzchv zzg;
    private final zzcil zzh = this;

    zzcil(zzchv zzchvVar, Context context, zzbki zzbkiVar) {
        this.zzg = zzchvVar;
        this.zze = context;
        this.zzf = zzbkiVar;
        zzhey zzheyVarZza = zzhez.zza(this);
        this.zza = zzheyVarZza;
        zzhey zzheyVarZza2 = zzhez.zza(zzbkiVar);
        this.zzb = zzheyVarZza2;
        zzdsl zzdslVar = new zzdsl(zzheyVarZza2);
        this.zzc = zzdslVar;
        this.zzd = zzhex.zzc(new zzdsn(zzheyVarZza, zzdslVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdsp
    public final zzdsg zzb() {
        return new zzcii(this.zzg, this.zzh, null);
    }

    final zzdsk zzc() {
        return zzdsl.zzc(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzdsp
    public final zzdsm zzd() {
        return (zzdsm) this.zzd.zzb();
    }
}
