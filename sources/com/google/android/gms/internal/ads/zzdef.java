package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdef implements zzhey {
    private final zzhfh zza;

    public zzdef(zzdee zzdeeVar, zzhfh zzhfhVar) {
        this.zza = zzhfhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzdcu((zzctx) this.zza.zzb(), zzbzk.zzg));
        zzhfg.zzb(setSingleton);
        return setSingleton;
    }
}
