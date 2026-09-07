package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdtj implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;
    private final zzhfh zzd;
    private final zzhfh zze;
    private final zzhfh zzf;
    private final zzhfh zzg;
    private final zzhfh zzh;
    private final zzhfh zzi;

    public zzdtj(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4, zzhfh zzhfhVar5, zzhfh zzhfhVar6, zzhfh zzhfhVar7, zzhfh zzhfhVar8, zzhfh zzhfhVar9, zzhfh zzhfhVar10) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
        this.zzd = zzhfhVar5;
        this.zze = zzhfhVar6;
        this.zzf = zzhfhVar7;
        this.zzg = zzhfhVar8;
        this.zzh = zzhfhVar9;
        this.zzi = zzhfhVar10;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdti((Executor) this.zza.zzb(), ((zzcgs) this.zzb).zza(), ((zzcgt) this.zzc).zza(), zzfen.zzc(), (zzdou) this.zzd.zzb(), (ScheduledExecutorService) this.zze.zzb(), (zzdrp) this.zzf.zzb(), ((zzchg) this.zzg).zza(), ((zzdcc) this.zzh).zzb(), (zzfgq) this.zzi.zzb());
    }
}
