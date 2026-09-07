package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdcu;
import com.google.android.gms.internal.ads.zzfen;
import com.google.android.gms.internal.ads.zzgcd;
import com.google.android.gms.internal.ads.zzhey;
import com.google.android.gms.internal.ads.zzhfh;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzbf implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;

    public zzbf(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        Object obj = (zzw) this.zza.zzb();
        zzbm zzbmVar = (zzbm) this.zzb.zzb();
        zzgcd zzgcdVarZzc = zzfen.zzc();
        if (((Integer) this.zzc.zzb()).intValue() == 2) {
            obj = zzbmVar;
        }
        return new zzdcu(obj, zzgcdVarZzc);
    }
}
