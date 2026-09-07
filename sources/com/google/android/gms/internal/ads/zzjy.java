package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzjy implements zzla {
    private final Object zza;
    private zzbl zzb;

    public zzjy(Object obj, zzut zzutVar) {
        this.zza = obj;
        this.zzb = zzutVar.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzla
    public final zzbl zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzla
    public final Object zzb() {
        return this.zza;
    }

    public final void zzc(zzbl zzblVar) {
        this.zzb = zzblVar;
    }
}
