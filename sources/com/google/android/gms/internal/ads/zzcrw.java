package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcrw implements zzcwq, com.google.android.gms.ads.internal.client.zza, zzcya, zzcvw, zzcvc, zzdam {
    private final Clock zza;
    private final zzbyt zzb;

    public zzcrw(Clock clock, zzbyt zzbytVar) {
        this.zza = clock;
        this.zzb = zzbytVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zzb.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zza() {
        this.zzb.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzc() {
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdl(zzbuy zzbuyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdm(zzfbg zzfbgVar) {
        this.zzb.zzk(this.zza.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzdq(zzbvk zzbvkVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzf() {
    }

    public final String zzg() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzdam
    public final void zzh() {
    }

    @Override // com.google.android.gms.internal.ads.zzdam
    public final void zzi(zzbbn.zzb zzbVar) {
        this.zzb.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzdam
    public final void zzj(zzbbn.zzb zzbVar) {
    }

    public final void zzk(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zzb.zzj(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdam
    public final void zzl(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzdam
    public final void zzm(zzbbn.zzb zzbVar) {
        this.zzb.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzdam
    public final void zzn(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzs() {
        this.zzb.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzt() {
        this.zzb.zzh(true);
    }
}
