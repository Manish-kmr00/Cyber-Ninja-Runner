package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdsc implements zzhey {
    private final zzhfh zza;

    public zzdsc(zzdrt zzdrtVar, zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        this.zza = zzhfhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzi = zzdrt.zzi((zzdsd) this.zza.zzb(), zzfen.zzc());
        zzhfg.zzb(setZzi);
        return setZzi;
    }
}
