package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfri extends zzfsl {
    private String zza;
    private String zzb;

    zzfri() {
    }

    @Override // com.google.android.gms.internal.ads.zzfsl
    public final zzfsl zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfsl
    public final zzfsl zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfsl
    public final zzfsm zzc() {
        return new zzfrk(this.zza, this.zzb, null);
    }
}
