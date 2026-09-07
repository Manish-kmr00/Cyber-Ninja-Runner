package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcin implements zzdfd {
    private final zzchv zza;
    private zzeyp zzb;
    private zzexs zzc;
    private zzdaw zzd;
    private zzcul zze;
    private zzeia zzf;

    /* synthetic */ zzcin(zzchv zzchvVar, zzciz zzcizVar) {
        this.zza = zzchvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcuh
    public final /* synthetic */ zzcuh zza(zzexs zzexsVar) {
        this.zzc = zzexsVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcuh
    public final /* synthetic */ zzcuh zzb(zzeyp zzeypVar) {
        this.zzb = zzeypVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdfd
    public final /* bridge */ /* synthetic */ zzdfd zzc(zzeia zzeiaVar) {
        this.zzf = zzeiaVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdfd
    public final /* bridge */ /* synthetic */ zzdfd zzd(zzdaw zzdawVar) {
        this.zzd = zzdawVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdfd
    public final /* bridge */ /* synthetic */ zzdfd zze(zzcul zzculVar) {
        this.zze = zzculVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcuh
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzdfe zzh() {
        zzhfg.zzc(this.zzd, zzdaw.class);
        zzhfg.zzc(this.zze, zzcul.class);
        zzhfg.zzc(this.zzf, zzeia.class);
        return new zzcio(this.zza, new zzcrm(), new zzfcu(), new zzctn(), new zzdrt(), this.zzd, this.zze, zzegf.zza(), this.zzf, null, this.zzb, this.zzc);
    }
}
