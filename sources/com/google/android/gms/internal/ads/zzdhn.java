package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdhn {
    private zzbfq zza;

    public zzdhn(zzdgy zzdgyVar) {
        this.zza = zzdgyVar;
    }

    public final synchronized zzbfq zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbfq zzbfqVar) {
        this.zza = zzbfqVar;
    }
}
