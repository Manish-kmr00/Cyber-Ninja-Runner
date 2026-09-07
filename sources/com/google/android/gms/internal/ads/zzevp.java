package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzevp implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;
    private final zzhfh zzd;
    private final zzhfh zze;
    private final zzhfh zzf;
    private final zzhfh zzg;

    public zzevp(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4, zzhfh zzhfhVar5, zzhfh zzhfhVar6, zzhfh zzhfhVar7, zzhfh zzhfhVar8, zzhfh zzhfhVar9) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
        this.zzd = zzhfhVar6;
        this.zze = zzhfhVar7;
        this.zzf = zzhfhVar8;
        this.zzg = zzhfhVar9;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzevn((zzbza) this.zza.zzb(), ((zzevf) this.zzb).zzb().booleanValue(), ((zzevg) this.zzc).zzb().booleanValue(), zzcki.zza(), zzfen.zzc(), ((zzevc) this.zzd).zza(), (ScheduledExecutorService) this.zze.zzb(), ((zzevi) this.zzf).zzb().intValue(), ((zzevj) this.zzg).zzb().intValue());
    }
}
