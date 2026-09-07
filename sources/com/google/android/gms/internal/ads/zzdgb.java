package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdgb implements zzhey {
    private final zzhfh zza;

    public zzdgb(zzhfh zzhfhVar) {
        this.zza = zzhfhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = ((zzdfy) this.zza).zza().zze() != null ? Collections.singleton("banner") : Collections.emptySet();
        zzhfg.zzb(setSingleton);
        return setSingleton;
    }
}
