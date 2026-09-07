package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdfb implements com.google.android.gms.ads.internal.overlay.zzr {
    private final zzcxi zza;
    private final zzdco zzb;

    public zzdfb(zzcxi zzcxiVar, zzdco zzdcoVar) {
        this.zza = zzcxiVar;
        this.zzb = zzdcoVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdE() {
        this.zza.zzdE();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdi() {
        this.zza.zzdi();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdo() {
        this.zza.zzdo();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdp() {
        this.zza.zzdp();
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdr() {
        this.zza.zzdr();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds(int i) {
        this.zza.zzds(i);
        this.zzb.zza();
    }
}
