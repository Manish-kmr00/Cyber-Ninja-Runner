package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeuh implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;

    public zzeuh(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4, zzhfh zzhfhVar5) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar3;
        this.zzc = zzhfhVar4;
    }

    public static zzeuf zza(String str, zzbaj zzbajVar, zzbza zzbzaVar, ScheduledExecutorService scheduledExecutorService, zzgcd zzgcdVar) {
        return new zzeuf(str, zzbajVar, zzbzaVar, scheduledExecutorService, zzgcdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeuf(((zzevc) this.zza).zza(), zzcjy.zza(), (zzbza) this.zzb.zzb(), (ScheduledExecutorService) this.zzc.zzb(), zzfen.zzc());
    }
}
