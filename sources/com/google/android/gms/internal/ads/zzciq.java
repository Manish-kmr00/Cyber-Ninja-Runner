package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzciq implements zzeza {
    final zzhfh zza;
    final zzhfh zzb;
    final zzhfh zzc;
    final zzhfh zzd;
    final zzhfh zze;
    final zzhfh zzf;
    final zzhfh zzg;
    private final zzchv zzh;

    zzciq(zzchv zzchvVar, Context context, String str, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzh = zzchvVar;
        zzhey zzheyVarZza = zzhez.zza(context);
        this.zza = zzheyVarZza;
        zzhey zzheyVarZza2 = zzhez.zza(zzrVar);
        this.zzb = zzheyVarZza2;
        zzhey zzheyVarZza3 = zzhez.zza(str);
        this.zzc = zzheyVarZza3;
        zzhfh zzhfhVar = zzchvVar.zzK;
        zzhfh zzhfhVarZzc = zzhex.zzc(new zzejs(zzhfhVar));
        this.zzd = zzhfhVarZzc;
        zzhfh zzhfhVarZzc2 = zzhex.zzc(new zzezy(zzchvVar.zzbf));
        this.zze = zzhfhVarZzc2;
        zzhfh zzhfhVarZzc3 = zzhex.zzc(new zzeyy(zzheyVarZza, zzchvVar.zza, zzchvVar.zzQ, zzhfhVarZzc, zzhfhVarZzc2, zzfbr.zza()));
        this.zzf = zzhfhVarZzc3;
        this.zzg = zzhex.zzc(new zzeka(zzheyVarZza, zzheyVarZza2, zzheyVarZza3, zzhfhVarZzc3, zzhfhVarZzc, zzhfhVarZzc2, zzchvVar.zzj, zzchvVar.zzS, zzhfhVar));
    }

    @Override // com.google.android.gms.internal.ads.zzeza
    public final zzejz zza() {
        return (zzejz) this.zzg.zzb();
    }
}
