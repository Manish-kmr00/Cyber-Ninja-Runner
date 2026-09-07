package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzchs implements zzdfz {
    private final zzchv zza;
    private zzeyp zzb;
    private zzexs zzc;
    private zzdaw zzd;
    private zzcul zze;
    private zzdfv zzf;
    private zzcnw zzg;

    /* synthetic */ zzchs(zzchv zzchvVar, zzciz zzcizVar) {
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

    @Override // com.google.android.gms.internal.ads.zzdfz
    public final /* bridge */ /* synthetic */ zzdfz zzc(zzcnw zzcnwVar) {
        this.zzg = zzcnwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdfz
    public final /* bridge */ /* synthetic */ zzdfz zzd(zzdfv zzdfvVar) {
        this.zzf = zzdfvVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdfz
    public final /* bridge */ /* synthetic */ zzdfz zze(zzdaw zzdawVar) {
        this.zzd = zzdawVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdfz
    public final /* bridge */ /* synthetic */ zzdfz zzf(zzcul zzculVar) {
        this.zze = zzculVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcuh
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzdga zzh() {
        zzhfg.zzc(this.zzd, zzdaw.class);
        zzhfg.zzc(this.zze, zzcul.class);
        zzhfg.zzc(this.zzf, zzdfv.class);
        zzhfg.zzc(this.zzg, zzcnw.class);
        return new zzcht(this.zza, this.zzg, this.zzf, new zzcrm(), new zzfcu(), new zzctn(), new zzdrt(), this.zzd, this.zze, zzegf.zza(), null, this.zzb, this.zzc);
    }
}
