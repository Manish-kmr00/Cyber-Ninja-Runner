package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcif implements zzexj {
    final zzhfh zza;
    final zzhfh zzb;
    final zzhfh zzc;
    final zzhfh zzd;
    final zzhfh zze;
    final zzhfh zzf;
    private final Context zzg;
    private final com.google.android.gms.ads.internal.client.zzr zzh;
    private final String zzi;
    private final zzchv zzj;

    zzcif(zzchv zzchvVar, Context context, String str, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzj = zzchvVar;
        this.zzg = context;
        this.zzh = zzrVar;
        this.zzi = str;
        zzhey zzheyVarZza = zzhez.zza(context);
        this.zza = zzheyVarZza;
        zzhey zzheyVarZza2 = zzhez.zza(zzrVar);
        this.zzb = zzheyVarZza2;
        zzhfh zzhfhVarZzc = zzhex.zzc(new zzejs(zzchvVar.zzK));
        this.zzc = zzhfhVarZzc;
        zzhfh zzhfhVarZzc2 = zzhex.zzc(zzejx.zza());
        this.zzd = zzhfhVarZzc2;
        zzhfh zzhfhVarZzc3 = zzhex.zzc(zzdad.zza());
        this.zze = zzhfhVarZzc3;
        this.zzf = zzhex.zzc(new zzexh(zzheyVarZza, zzchvVar.zza, zzheyVarZza2, zzchvVar.zzQ, zzhfhVarZzc, zzhfhVarZzc2, zzfbr.zza(), zzhfhVarZzc3));
    }

    @Override // com.google.android.gms.internal.ads.zzexj
    public final zzeix zza() {
        zzexg zzexgVar = (zzexg) this.zzf.zzb();
        zzejr zzejrVar = (zzejr) this.zzc.zzb();
        zzchv zzchvVar = this.zzj;
        return new zzeix(this.zzg, this.zzh, this.zzi, zzexgVar, zzejrVar, zzchg.zzc(zzchvVar.zzbn), (zzdre) zzchvVar.zzK.zzb());
    }
}
