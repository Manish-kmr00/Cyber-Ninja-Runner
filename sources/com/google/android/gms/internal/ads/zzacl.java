package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzacl {
    public static final zzacl zza = new zzacl(-3, -9223372036854775807L, -1);
    private final int zzb;
    private final long zzc;
    private final long zzd;

    private zzacl(int i, long j, long j2) {
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzacl zzd(long j, long j2) {
        return new zzacl(-1, j, j2);
    }

    public static zzacl zze(long j) {
        return new zzacl(0, -9223372036854775807L, j);
    }

    public static zzacl zzf(long j, long j2) {
        return new zzacl(-2, j, j2);
    }
}
