package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcis implements zzfao {
    final zzhfh zza;
    final zzhfh zzb;
    final zzhfh zzc;
    final zzhfh zzd;
    final zzhfh zze;
    final zzhfh zzf;
    final zzhfh zzg;
    final zzhfh zzh;
    private final zzchv zzi;

    zzcis(zzchv zzchvVar, Context context, String str) {
        this.zzi = zzchvVar;
        zzhey zzheyVarZza = zzhez.zza(context);
        this.zza = zzheyVarZza;
        zzhfh zzhfhVar = zzchvVar.zzbf;
        zzeyo zzeyoVar = new zzeyo(zzheyVarZza, zzhfhVar, zzchvVar.zzbg);
        this.zzb = zzeyoVar;
        zzhfh zzhfhVarZzc = zzhex.zzc(new zzezy(zzhfhVar));
        this.zzc = zzhfhVarZzc;
        zzhfh zzhfhVarZzc2 = zzhex.zzc(zzfbm.zza());
        this.zzd = zzhfhVarZzc2;
        zzhfh zzhfhVarZzc3 = zzhex.zzc(new zzfai(zzheyVarZza, zzchvVar.zza, zzchvVar.zzQ, zzeyoVar, zzhfhVarZzc, zzfbr.zza(), zzhfhVarZzc2));
        this.zze = zzhfhVarZzc3;
        this.zzf = zzhex.zzc(new zzfas(zzhfhVarZzc3, zzhfhVarZzc, zzhfhVarZzc2));
        zzhey zzheyVarZzc = zzhez.zzc(str);
        this.zzg = zzheyVarZzc;
        this.zzh = zzhex.zzc(new zzfam(zzheyVarZzc, zzhfhVarZzc3, zzheyVarZza, zzhfhVarZzc, zzhfhVarZzc2, zzchvVar.zzj, zzchvVar.zzS, zzchvVar.zzK));
    }

    @Override // com.google.android.gms.internal.ads.zzfao
    public final zzfal zza() {
        return (zzfal) this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzfao
    public final zzfar zzb() {
        return (zzfar) this.zzf.zzb();
    }
}
