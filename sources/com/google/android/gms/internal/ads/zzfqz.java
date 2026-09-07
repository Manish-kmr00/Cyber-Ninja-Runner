package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfqz extends zzfrl {
    private String zza;
    private String zzb;

    zzfqz() {
    }

    @Override // com.google.android.gms.internal.ads.zzfrl
    public final zzfrl zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfrl
    public final zzfrl zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfrl
    public final zzfrm zzc() {
        return new zzfrb(this.zza, this.zzb, null);
    }
}
