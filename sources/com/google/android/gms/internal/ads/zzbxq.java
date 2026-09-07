package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzbxq extends zzbxx {
    final zzhfh zza;
    final zzhfh zzb;
    final zzhfh zzc;
    final zzhfh zzd;
    final zzhfh zze;
    final zzhfh zzf;
    final zzhfh zzg;
    final zzhfh zzh;
    private final Clock zzj;

    zzbxq(Context context, Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbxw zzbxwVar) {
        this.zzj = clock;
        zzhey zzheyVarZza = zzhez.zza(context);
        this.zza = zzheyVarZza;
        zzhey zzheyVarZza2 = zzhez.zza(zzgVar);
        this.zzb = zzheyVarZza2;
        this.zzc = zzhex.zzc(new zzbxk(zzheyVarZza, zzheyVarZza2));
        zzhey zzheyVarZza3 = zzhez.zza(clock);
        this.zzd = zzheyVarZza3;
        zzhey zzheyVarZza4 = zzhez.zza(zzbxwVar);
        this.zze = zzheyVarZza4;
        zzhfh zzhfhVarZzc = zzhex.zzc(new zzbxm(zzheyVarZza3, zzheyVarZza2, zzheyVarZza4));
        this.zzf = zzhfhVarZzc;
        zzbxo zzbxoVar = new zzbxo(zzheyVarZza3, zzhfhVarZzc);
        this.zzg = zzbxoVar;
        this.zzh = zzhex.zzc(new zzbyc(zzheyVarZza, zzbxoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbxx
    final zzbxn zza() {
        return new zzbxn(this.zzj, (zzbxl) this.zzf.zzb());
    }
}
