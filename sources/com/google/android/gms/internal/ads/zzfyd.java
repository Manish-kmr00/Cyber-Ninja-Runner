package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfyd extends zzfuy {
    final transient zzfuo zza;

    zzfyd(Map map, zzfuo zzfuoVar) {
        super(map);
        this.zza = zzfuoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfuy, com.google.android.gms.internal.ads.zzfvp
    protected final /* bridge */ /* synthetic */ Collection zza() {
        return (List) this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzfvp, com.google.android.gms.internal.ads.zzfvs
    final Map zzj() {
        return zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzfvp, com.google.android.gms.internal.ads.zzfvs
    final Set zzl() {
        return zzm();
    }
}
