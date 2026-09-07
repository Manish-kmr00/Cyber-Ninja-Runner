package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcic implements zzcpc {
    private final zzchv zza;
    private zzeyp zzb;
    private zzexs zzc;
    private zzdaw zzd;
    private zzcul zze;
    private zzeia zzf;
    private zzcpy zzg;
    private zzegd zzh;
    private zzcnw zzi;
    private zzdfv zzj;

    /* synthetic */ zzcic(zzchv zzchvVar, zzciz zzcizVar) {
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

    @Override // com.google.android.gms.internal.ads.zzcpc
    public final /* bridge */ /* synthetic */ zzcpc zzc(zzcnw zzcnwVar) {
        this.zzi = zzcnwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpc
    public final /* bridge */ /* synthetic */ zzcpc zzd(zzdfv zzdfvVar) {
        this.zzj = zzdfvVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpc
    public final /* bridge */ /* synthetic */ zzcpc zze(zzeia zzeiaVar) {
        this.zzf = zzeiaVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpc
    public final /* bridge */ /* synthetic */ zzcpc zzf(zzdaw zzdawVar) {
        this.zzd = zzdawVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpc
    public final /* bridge */ /* synthetic */ zzcpc zzg(zzcpy zzcpyVar) {
        this.zzg = zzcpyVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpc
    public final /* bridge */ /* synthetic */ zzcpc zzi(zzcul zzculVar) {
        this.zze = zzculVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcpc
    public final /* bridge */ /* synthetic */ zzcpc zzj(zzegd zzegdVar) {
        this.zzh = zzegdVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcuh
    /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] */
    public final zzcpd zzh() {
        zzhfg.zzc(this.zzd, zzdaw.class);
        zzhfg.zzc(this.zze, zzcul.class);
        zzhfg.zzc(this.zzf, zzeia.class);
        zzhfg.zzc(this.zzg, zzcpy.class);
        if (this.zzh == null) {
            this.zzh = zzegf.zza();
        }
        zzhfg.zzc(this.zzi, zzcnw.class);
        zzhfg.zzc(this.zzj, zzdfv.class);
        return new zzcid(this.zza, this.zzi, this.zzj, new zzcrm(), new zzfcu(), new zzctn(), new zzdrt(), this.zzd, this.zze, this.zzh, this.zzf, this.zzg, null, this.zzb, this.zzc);
    }
}
