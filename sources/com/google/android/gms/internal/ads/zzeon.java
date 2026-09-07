package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeon implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;

    public zzeon(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzesv zzesvVarZzb = ((zzekr) this.zza).zzb();
        zzenn zzennVar = (zzenn) this.zzb.zzb();
        if (true == ((List) this.zzc.zzb()).contains("2")) {
            zzesvVarZzb = zzennVar;
        }
        zzhfg.zzb(zzesvVarZzb);
        return zzesvVarZzb;
    }
}
