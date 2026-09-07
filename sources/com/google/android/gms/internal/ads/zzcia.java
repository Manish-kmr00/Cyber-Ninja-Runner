package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcia implements zzevv {
    final zzhfh zza;
    final zzhfh zzb;
    final zzhfh zzc;
    final zzhfh zzd;
    final zzhfh zze;
    final zzhfh zzf;
    private final zzchv zzg;

    zzcia(zzchv zzchvVar, Context context, String str) {
        this.zzg = zzchvVar;
        zzhey zzheyVarZza = zzhez.zza(context);
        this.zza = zzheyVarZza;
        zzhey zzheyVarZza2 = zzhez.zza(str);
        this.zzb = zzheyVarZza2;
        zzhfh zzhfhVar = zzchvVar.zzbf;
        zzeyn zzeynVar = new zzeyn(zzheyVarZza, zzhfhVar, zzchvVar.zzbg);
        this.zzc = zzeynVar;
        zzhfh zzhfhVarZzc = zzhex.zzc(new zzewt(zzhfhVar));
        this.zzd = zzhfhVarZzc;
        zzhfh zzhfhVar2 = zzchvVar.zza;
        zzhfh zzhfhVar3 = zzchvVar.zzQ;
        zzfbr zzfbrVarZza = zzfbr.zza();
        zzhfh zzhfhVar4 = zzchvVar.zzj;
        zzhfh zzhfhVarZzc2 = zzhex.zzc(new zzewv(zzheyVarZza, zzhfhVar2, zzhfhVar3, zzeynVar, zzhfhVarZzc, zzfbrVarZza, zzhfhVar4));
        this.zze = zzhfhVarZzc2;
        this.zzf = zzhex.zzc(new zzexb(zzhfhVar3, zzheyVarZza, zzheyVarZza2, zzhfhVarZzc2, zzhfhVarZzc, zzhfhVar4, zzchvVar.zzK));
    }

    @Override // com.google.android.gms.internal.ads.zzevv
    public final zzexa zza() {
        return (zzexa) this.zzf.zzb();
    }
}
