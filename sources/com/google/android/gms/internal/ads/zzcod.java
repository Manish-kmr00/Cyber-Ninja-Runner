package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcod implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;
    private final zzhfh zzd;
    private final zzhfh zze;
    private final zzhfh zzf;
    private final zzhfh zzg;
    private final zzhfh zzh;
    private final zzhfh zzi;
    private final zzhfh zzj;

    public zzcod(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4, zzhfh zzhfhVar5, zzhfh zzhfhVar6, zzhfh zzhfhVar7, zzhfh zzhfhVar8, zzhfh zzhfhVar9, zzhfh zzhfhVar10) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
        this.zzd = zzhfhVar4;
        this.zze = zzhfhVar5;
        this.zzf = zzhfhVar6;
        this.zzg = zzhfhVar7;
        this.zzh = zzhfhVar8;
        this.zzi = zzhfhVar9;
        this.zzj = zzhfhVar10;
    }

    public static zzcoc zzc(zzcqf zzcqfVar, Context context, zzfav zzfavVar, View view, zzcel zzcelVar, zzcqe zzcqeVar, zzdib zzdibVar, zzdde zzddeVar, zzhes zzhesVar, Executor executor) {
        return new zzcoc(zzcqfVar, context, zzfavVar, view, zzcelVar, zzcqeVar, zzdibVar, zzddeVar, zzhesVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcoc zzb() {
        return new zzcoc(((zzcsn) this.zza).zzb(), (Context) this.zzb.zzb(), ((zzcoj) this.zzc).zza(), ((zzcoi) this.zzd).zza(), ((zzcow) this.zze).zza(), ((zzcok) this.zzf).zza(), ((zzdfy) this.zzg).zza(), (zzdde) this.zzh.zzb(), zzhex.zza(this.zzi), (Executor) this.zzj.zzb());
    }
}
