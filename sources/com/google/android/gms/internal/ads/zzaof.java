package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaof implements zzaeb {
    private final zzaoc zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaof(zzaoc zzaocVar, int i, long j, long j2) {
        this.zza = zzaocVar;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / ((long) zzaocVar.zzd);
        this.zzd = j3;
        this.zze = zzb(j3);
    }

    private final long zzb(long j) {
        return zzeu.zzu(j * ((long) this.zzb), 1000000L, this.zza.zzc, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final zzadz zzg(long j) {
        long j2 = this.zzb;
        zzaoc zzaocVar = this.zza;
        long j3 = (((long) zzaocVar.zzc) * j) / (j2 * 1000000);
        int i = zzeu.zza;
        long j4 = this.zzd - 1;
        long jMax = Math.max(0L, Math.min(j3, j4));
        long j5 = zzaocVar.zzd;
        long jZzb = zzb(jMax);
        long j6 = this.zzc;
        zzaec zzaecVar = new zzaec(jZzb, (jMax * j5) + j6);
        if (jZzb >= j || jMax == j4) {
            return new zzadz(zzaecVar, zzaecVar);
        }
        long j7 = jMax + 1;
        return new zzadz(zzaecVar, new zzaec(zzb(j7), j6 + (j5 * j7)));
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final boolean zzh() {
        return true;
    }
}
