package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzciu implements zzdnm {
    private final zzchv zza;
    private zzeyp zzb;
    private zzexs zzc;
    private zzdaw zzd;
    private zzcul zze;

    /* synthetic */ zzciu(zzchv zzchvVar, zzciz zzcizVar) {
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

    @Override // com.google.android.gms.internal.ads.zzdnm
    public final /* bridge */ /* synthetic */ zzdnm zzc(zzdaw zzdawVar) {
        this.zzd = zzdawVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdnm
    public final /* bridge */ /* synthetic */ zzdnm zzd(zzcul zzculVar) {
        this.zze = zzculVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcuh
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzdnn zzh() {
        zzhfg.zzc(this.zzd, zzdaw.class);
        zzhfg.zzc(this.zze, zzcul.class);
        return new zzciv(this.zza, new zzcrm(), new zzfcu(), new zzctn(), new zzdrt(), this.zzd, this.zze, zzegf.zza(), null, this.zzb, this.zzc);
    }
}
