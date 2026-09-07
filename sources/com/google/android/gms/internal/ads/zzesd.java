package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzesd implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;
    private final zzhfh zzd;
    private final zzhfh zze;
    private final zzhfh zzf;
    private final zzhfh zzg;
    private final zzhfh zzh;
    private final zzhfh zzi;

    public zzesd(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4, zzhfh zzhfhVar5, zzhfh zzhfhVar6, zzhfh zzhfhVar7, zzhfh zzhfhVar8, zzhfh zzhfhVar9, zzhfh zzhfhVar10) {
        this.zza = zzhfhVar2;
        this.zzb = zzhfhVar3;
        this.zzc = zzhfhVar4;
        this.zzd = zzhfhVar5;
        this.zze = zzhfhVar6;
        this.zzf = zzhfhVar7;
        this.zzg = zzhfhVar8;
        this.zzh = zzhfhVar9;
        this.zzi = zzhfhVar10;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzesb(zzfen.zzc(), (ScheduledExecutorService) this.zza.zzb(), (String) this.zzb.zzb(), (zzein) this.zzc.zzb(), (Context) this.zzd.zzb(), ((zzcut) this.zze).zza(), (zzeij) this.zzf.zzb(), (zzdou) this.zzg.zzb(), (zzdtk) this.zzh.zzb(), ((Integer) this.zzi.zzb()).intValue());
    }
}
