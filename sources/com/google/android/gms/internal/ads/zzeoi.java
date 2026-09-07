package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeoi implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;

    public zzeoi(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4) {
        this.zza = zzhfhVar2;
        this.zzb = zzhfhVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzenn(zzequ.zza(), ((Long) zzbdx.zzf.zze()).longValue(), (Clock) this.zza.zzb(), zzfen.zzc(), (zzdre) this.zzb.zzb());
    }
}
