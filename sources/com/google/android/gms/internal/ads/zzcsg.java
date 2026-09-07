package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcsg implements com.google.android.gms.ads.internal.client.zza {
    private final zzcsk zza;
    private final zzfbp zzb;

    zzcsg(zzcsk zzcskVar, zzfbp zzfbpVar) {
        this.zza = zzcskVar;
        this.zzb = zzfbpVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zza.zzc(this.zzb.zzf);
    }
}
