package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzaea implements zzaeb {
    private final long zza;
    private final zzadz zzb;

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final zzadz zzg(long j) {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final boolean zzh() {
        return false;
    }

    public zzaea(long j, long j2) {
        this.zza = j;
        zzaec zzaecVar = j2 == 0 ? zzaec.zza : new zzaec(0L, j2);
        this.zzb = new zzadz(zzaecVar, zzaecVar);
    }
}
