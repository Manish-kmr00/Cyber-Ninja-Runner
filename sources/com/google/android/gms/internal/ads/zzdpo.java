package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdpo implements zzhey {
    private final zzhfh zza;

    public zzdpo(zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        this.zza = zzhfhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgcd zzgcdVarZzc = zzfen.zzc();
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfg)).booleanValue() ? Collections.singleton(new zzdcu(((zzdqh) this.zza).zzb(), zzgcdVarZzc)) : Collections.emptySet();
        zzhfg.zzb(setSingleton);
        return setSingleton;
    }
}
