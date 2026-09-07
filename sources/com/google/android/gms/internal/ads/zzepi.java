package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzepi implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;

    public zzepi(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzesv zzesvVarZzb = ((zzerk) this.zza).zzb();
        zzenn zzennVar = (zzenn) this.zzb.zzb();
        if (true == ((List) this.zzc.zzb()).contains("29")) {
            zzesvVarZzb = zzennVar;
        }
        zzhfg.zzb(zzesvVarZzb);
        return zzesvVarZzb;
    }
}
