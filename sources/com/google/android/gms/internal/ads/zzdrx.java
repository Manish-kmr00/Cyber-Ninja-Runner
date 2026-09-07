package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdrx implements zzhey {
    private final zzdrt zza;
    private final zzhfh zzb;

    public zzdrx(zzdrt zzdrtVar, zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        this.zza = zzdrtVar;
        this.zzb = zzhfhVar;
    }

    public static Set zza(zzdrt zzdrtVar, zzdsd zzdsdVar, Executor executor) {
        Set setZzd = zzdrt.zzd(zzdsdVar, executor);
        zzhfg.zzb(setZzd);
        return setZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zza(this.zza, (zzdsd) this.zzb.zzb(), zzfen.zzc());
    }
}
