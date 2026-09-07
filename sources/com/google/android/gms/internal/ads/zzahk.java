package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahk implements zzahn {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzahk(long[] jArr, long[] jArr2, long j) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j == -9223372036854775807L ? zzeu.zzs(jArr2[jArr2.length - 1]) : j;
    }

    public static zzahk zzb(long j, zzagp zzagpVar, long j2) {
        int[] iArr = zzagpVar.zzd;
        int length = iArr.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += (long) (zzagpVar.zzb + iArr[i3]);
            j3 += (long) (zzagpVar.zzc + zzagpVar.zze[i3]);
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new zzahk(jArr, jArr2, j2);
    }

    private static Pair zzf(long j, long[] jArr, long[] jArr2) {
        int iZzd = zzeu.zzd(jArr, j, true, true);
        long j2 = jArr[iZzd];
        long j3 = jArr2[iZzd];
        int i = iZzd + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((j4 == j2 ? 0.0d : (j - j2) / (j4 - j2)) * (jArr2[i] - j3))) + j3));
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final int zzc() {
        return -2147483647;
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final long zzd() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final long zze(long j) {
        return zzeu.zzs(((Long) zzf(j, this.zza, this.zzb).second).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final zzadz zzg(long j) {
        int i = zzeu.zza;
        Pair pairZzf = zzf(zzeu.zzv(Math.max(0L, Math.min(j, this.zzc))), this.zzb, this.zza);
        zzaec zzaecVar = new zzaec(zzeu.zzs(((Long) pairZzf.first).longValue()), ((Long) pairZzf.second).longValue());
        return new zzadz(zzaecVar, zzaecVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final boolean zzh() {
        return true;
    }
}
