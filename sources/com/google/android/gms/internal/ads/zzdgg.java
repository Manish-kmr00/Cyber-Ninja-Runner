package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdgg implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;
    private final zzhfh zzd;
    private final zzhfh zze;
    private final zzhfh zzf;

    public zzdgg(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4, zzhfh zzhfhVar5, zzhfh zzhfhVar6) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
        this.zzd = zzhfhVar4;
        this.zze = zzhfhVar5;
        this.zzf = zzhfhVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcgl zzcglVar = (zzcgl) this.zza.zzb();
        zzcuj zzcujVarZza = ((zzcuu) this.zzb).zza();
        zzdaw zzdawVarZza = ((zzdbq) this.zzc).zza();
        zzdfv zzdfvVarZza = ((zzdfx) this.zzd).zza();
        zzcxv zzcxvVarZzb = ((zzcny) this.zze).zzb();
        zzefu zzefuVar = (zzefu) this.zzf.zzb();
        zzcpc zzcpcVarZzd = zzcglVar.zzd();
        zzcpcVarZzd.zzi(zzcujVarZza.zzl());
        zzcpcVarZzd.zzf(zzdawVarZza);
        zzcpcVarZzd.zzd(zzdfvVarZza);
        zzcpcVarZzd.zze(new zzeia(null));
        zzcpcVarZzd.zzg(new zzcpy(zzcxvVarZzb, null));
        zzcpcVarZzd.zzc(new zzcnw(null));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdR)).booleanValue()) {
            zzcpcVarZzd.zzj(zzegd.zzb(zzefuVar));
        }
        zzcqj zzcqjVarZzb = zzcpcVarZzd.zzh().zzb();
        zzhfg.zzb(zzcqjVarZzb);
        return zzcqjVarZzb;
    }
}
